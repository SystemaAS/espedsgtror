package no.systema.tror.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
//import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import no.systema.jservices.common.dao.DokefDao;
import no.systema.jservices.common.dao.DokefimDao;
import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.LocfDao;
import no.systema.jservices.common.dao.LogfDao;

import no.systema.jservices.common.json.JsonDtoContainer;
import no.systema.jservices.common.json.JsonReader;

import no.systema.main.model.SystemaWebUser;
import no.systema.main.util.StringManager;
import no.systema.main.validator.UserValidator;

import no.systema.main.service.UrlCgiProxyService;
import no.systema.main.util.AppConstants;
import no.systema.main.util.JsonDebugger;
import no.systema.main.util.MessageNoteManager;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderRecord;
import no.systema.tror.model.jsonjackson.DokefDto;
import no.systema.tror.converter.DaoConverter;

import no.systema.tror.service.html.dropdown.TrorDropDownListPopulationService;
import no.systema.tror.service.flyimport.TrorMainOrderHeaderFlyimportService;
import no.systema.tror.url.store.TrorUrlDataStore;
import no.systema.tror.util.RpgReturnResponseHandler;
import no.systema.tror.util.TrorConstants;
import no.systema.tror.util.manager.AWBManager;
import no.systema.tror.util.manager.CodeDropDownMgr;
import no.systema.tror.util.manager.FlyImportExportManager;
import no.systema.tror.util.manager.OrderContactInformationManager;
import no.systema.tror.util.manager.FreightBillMessageNoteManager;
import no.systema.tror.mapper.url.request.UrlRequestParameterMapper;
import no.systema.tror.model.CundfAuxObject;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundfContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundfRecord;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainFirmContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainFirmRecord;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaRecord;
import no.systema.z.main.maintenance.service.MaintMainCundfService;
import no.systema.z.main.maintenance.service.MaintMainFirmService;
import no.systema.z.main.maintenance.service.MaintMainKodtaService;
import no.systema.z.main.maintenance.url.store.MaintenanceMainUrlDataStore;
import no.systema.z.main.maintenance.util.MainMaintenanceConstants;
import no.systema.tror.validator.TrorOrderFlyFraktbrevImpValidator;

/**
 * Tror - Air Freight Bill Controller (flyfraktbrev) 
 * 
 * @author oscardelatorre
 * @date Feb 19, 2018
 * 
 */

@Controller
@SessionAttributes(AppConstants.SYSTEMA_WEB_USER_KEY)
@Scope("session")
public class TrorMainOrderHeaderFlyControllerAirFreightBill {
	private static Logger logger = Logger.getLogger(TrorMainOrderHeaderFlyControllerAirFreightBill.class.getName());
	private ModelAndView loginView = new ModelAndView("redirect:logout.do");
	private static final JsonDebugger jsonDebugger = new JsonDebugger(1500);
	private UrlRequestParameterMapper urlRequestParameterMapper = new UrlRequestParameterMapper();
	private CodeDropDownMgr codeDropDownMgr = new CodeDropDownMgr();
	private StringManager strMgr = new StringManager();
	//
	private final String HEUR_TYPE_FLY_IMPORT = "C";
	private final String HEUR_TYPE_FLY_EXPORT = "D";
	//Converter for Dto's to Dao's
	private DaoConverter daoConverter = new DaoConverter();
		
	@PostConstruct
	public void initIt() throws Exception {
		//init managers
		
	}
	/**
	 * Main gate of redirection to either flyimport or flyexport ...
	 * 
	 * The reason is that both share the same dokef-table but only flyimport uses dokefim (as a pre-data view previous to dokef).
	 * In addition, both (import or export) must go through their own gates in order to go to a list (in case of several flyfraktbrev)
	 * or go directly to the view (if there is only one flyfraktbrev)
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="tror_mainorderfly_airfreightbill_gate.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tror_mainorderland_airfreightbill_gate(HttpSession session, HttpServletRequest request){
		ModelAndView successView = null; 
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map model = new HashMap();
		String avd = request.getParameter("avd");
		String opd = request.getParameter("opd");
		String sign = request.getParameter("sign");
		
		if (appUser == null) {
			return this.loginView;
		} else {
			JsonTrorOrderHeaderRecord headerOrderRecord = (JsonTrorOrderHeaderRecord)session.getAttribute(TrorConstants.SESSION_RECORD_ORDER_TROR_FLY);
			
			if(this.HEUR_TYPE_FLY_IMPORT.equals(headerOrderRecord.getHeur())){
				logger.info("Redirecting to import gate ...");
				successView = new ModelAndView("redirect:tror_mainorderfly_airfreightbill_imp_gate.do?" + "&imavd=" + avd + "&imopd=" + opd + "&sign=" + sign);
				
			}else{
				logger.info("Redirecting to export gate ...");
				successView = new ModelAndView("redirect:tror_mainorderfly_airfreightbill_exp_gate.do?" + "&dfavd=" + avd + "&dfopd=" + opd + "&sign=" + sign);
			}
			
			
		}
		return successView;
	}
	/**
	 * 
	 * @param recordToValidate
	 * @param bindingResult
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="tror_mainorderfly_airfreightbill_imp_gate.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tror_mainorderland_airfreightbill_imp_gate(@ModelAttribute ("record") DokefimDao recordToValidate, BindingResult bindingResult, HttpSession session, HttpServletRequest request){
		ModelAndView successView = null; 
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map model = new HashMap();
		String sign = request.getParameter("sign");
		
		if (appUser == null) {
			return this.loginView;
		} else {
			logger.info("inside <tror_mainorderland_airfreightbill_imp_gate>  < opd=" + recordToValidate.getImopd());
			List<DokefimDao> list = this.fetchFlyImportFraktbrevList(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
			if(list!=null && list.size()>=1){
				successView = new ModelAndView("tror_mainorderfly_airfreightbill_list");
				model.put("list", list);
				
				successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL, model);
			}else{
				
				//this will send the request with an implicit action of doFetch
				successView = new ModelAndView("redirect:tror_mainorderfly_airfreightbill_imp_edit.do?" + "&imavd=" + recordToValidate.getImavd() + "&imopd=" + recordToValidate.getImopd() + "&imlop=" + recordToValidate.getImlop());
			}
		}
		return successView;
	}
	/**
	 * 
	 * @param recordToValidate
	 * @param bindingResult
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="tror_mainorderfly_airfreightbill_list_edit.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tror_mainorderland_freightbill_list_edit(@ModelAttribute ("record") DokefimDao recordToValidate, BindingResult bindingResult, HttpSession session, HttpServletRequest request){
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map model = new HashMap();
		String action = request.getParameter("action");
		String updateId = request.getParameter("updateId");
		String sign = request.getParameter("sign");
		ModelAndView successView = new ModelAndView("redirect:tror_mainorderfly_airfreightbill_imp_gate.do?" + "&imavd=" + recordToValidate.getImavd() + "&sign=" + sign + "&imopd=" + recordToValidate.getImopd());
		
		StringBuffer errMsg = new StringBuffer();
		JsonTrorOrderHeaderRecord headf = new JsonTrorOrderHeaderRecord();
		
		int dmlRetval = 0;
		DokefimDao savedRecord = null;
		
		if (appUser == null) {
			return this.loginView;
		} else {
			
			if (MainMaintenanceConstants.ACTION_CREATE.equals(action)) {  //New
				logger.info("Inside - CREATE NEW");
				//TODO --> COVI this.adjustFields( recordToValidate,  headf);
				// Validate
				TrorOrderFlyFraktbrevImpValidator validator = new TrorOrderFlyFraktbrevImpValidator();
				validator.validate(recordToValidate, bindingResult);
				if (bindingResult.hasErrors()) {
					logger.info("[ERROR Validation] Record does not validate)");
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				} else {
					//TODO -->COVI recordToValidate.setDfsg(sign);
					//TODO -->COVI savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_ADD, errMsg);
					
					/*TODO -- error handling ... (change successview among others ...)
					if (savedRecord == null) {
						logger.info("[ERROR Validation] Record does not validate)");
						model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					} else {
						DokufDao record = fetchRecord(appUser, recordToValidate.getDfavd(), recordToValidate.getDfopd(), recordToValidate.getDffbnr(), model);
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, record);
					}*/
				}

			}  else if (MainMaintenanceConstants.ACTION_DELETE.equals(action)) { //Delete
				logger.info("Inside - DELETE");
				savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_DELETE, errMsg);
				if (savedRecord == null) {
					logger.info("[ERROR Validation] Record does not validate)");
					model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				} else {
					DokefimDao recordDokefimDao = this.fetchRecord(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefimDao);
				}
				

			} 
			
			return successView;		
		}

	}
	/**
	 * 
	 * @param recordToValidate
	 * @param bindingResult
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="tror_mainorderfly_airfreightbill_imp_edit.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tror_mainorderfly_airfreightbill_impr_edit(@ModelAttribute ("record") DokefimDao recordToValidate, BindingResult bindingResult, HttpSession session, HttpServletRequest request){
		ModelAndView successView = new ModelAndView("tror_mainorderfly_airfreightbill_imp");
		
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map<String,Object> model = new HashMap<String,Object>();
		String action = request.getParameter("action");
		String updateId = request.getParameter("updateId");
		StringBuffer errMsg = new StringBuffer();
		
		DokefimDao savedRecord = null;
		
		if (appUser == null) {
			return this.loginView;
		} else {
			
			if (MainMaintenanceConstants.ACTION_CREATE.equals(action)) {  //New
				logger.info("Inside - CREATE NEW");
				//this.adjustFields( recordToValidate,  headf);
				// Validate
				TrorOrderFlyFraktbrevImpValidator validator = new TrorOrderFlyFraktbrevImpValidator();
				validator.validate(recordToValidate, bindingResult);
				if (bindingResult.hasErrors()) {
					logger.info("[ERROR Validation] Record does not validate)");
					model.put("action", MainMaintenanceConstants.ACTION_CREATE);
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				} else {
					
					savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_ADD, errMsg);
					if (savedRecord == null) {
						logger.info("[ERROR Validation] Record does not validate)");
						model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
						model.put("action", MainMaintenanceConstants.ACTION_CREATE);
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					} else {
						
						DokefimDao recordDokefimDao = this.fetchRecord(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
						
						model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefimDao);
						session.setAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY, recordDokefimDao);
						session.setAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY_OWNSENDERNAME, model.get(recordDokefimDao.getHekns()));
						
						
					}
					
				}

			} else if (MainMaintenanceConstants.ACTION_UPDATE.equals(action)) { //Update
				logger.info("Inside - UPDATE...");
				//Validate
				TrorOrderFlyFraktbrevImpValidator validator = new TrorOrderFlyFraktbrevImpValidator();
				validator.validate(recordToValidate, bindingResult);
				if (bindingResult.hasErrors()) {
					logger.info("[ERROR Validation] Record does not validate)");
					model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					
				} else {
					
					savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_UPDATE, errMsg);
					if (savedRecord == null) {
						logger.info("[ERROR Validation] Record does not validate)");
						model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					} else {
						
						//get record now (refreshed)
						DokefimDao recordDokefimDao = this.fetchRecord(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
						model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefimDao);
						session.setAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY, recordDokefimDao);
						session.setAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY_OWNSENDERNAME, model.get(recordDokefimDao.getHekns()));
						
					}
					
				}
				
			} else if (MainMaintenanceConstants.ACTION_DELETE.equals(action)) { //Delete

					savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_DELETE, errMsg);
					if (savedRecord == null) {
						logger.info("[ERROR Validation] Record does not validate)");
						model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					} else {
						DokefimDao recordDokefimDao = this.fetchRecord(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefimDao);
						session.removeAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY);
						session.removeAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY_OWNSENDERNAME);
					}

			} else { // Fetch
				logger.info("FETCH branch");
				DokefimDao recordDokefimDao = this.fetchRecord(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
				
				if(recordDokefimDao!=null && recordDokefimDao.getImlop()>0){
					//get invoice data (currency & amount... 
					//12.Jan.2018: TODO--> after meeting (CB,JOVO,OT)a lot of issues CRUD must be resolved before we allow the end-user to input these 2 fields on GUI.
					model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefimDao);
					session.setAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY, recordDokefimDao);
					session.setAttribute(TrorConstants.SESSION_RECORD_FLYFRAKTBREV_IMPORT_HEADER_TROR_FLY_OWNSENDERNAME, model.get(recordDokefimDao.getHekns()));
					//logger.info("XXXX:" + model.get(recordDokefimDao.getHekns()));
					
				}else{
					//get the lopenr (increase +1 from the last lopnr in table)
					recordToValidate.setImlop(this.getNewLopenr(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop()));
					//Prepare the view for a future create-new fraktbrev.
					model.put("action", MainMaintenanceConstants.ACTION_CREATE);
					//Here we prepare the form with default values from the "Oppdrag"
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				}
				
			}
			//get dropdowns
			//this.setCodeDropDownMgr(appUser, model);
			
		
			//model.put("dfavd", recordToValidate.getDfavd());
			//model.put("dfopd", recordToValidate.getDfopd());
			//model.put("dffbnr", recordToValidate.getDffbnr());
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL, model);
			
			return successView;		
		}
		
	}
	/**
	 * 
	 * @param recordToValidate
	 * @param bindingResult
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="tror_mainorderfly_airfreightbill_edit.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tror_mainorderfly_airfreightbill_edit(@ModelAttribute ("record") DokefDto recordToValidate, BindingResult bindingResult, HttpSession session, HttpServletRequest request){
		ModelAndView successView = new ModelAndView("tror_mainorderfly_airfreightbill");
		
		boolean updateOk = true;
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map<String,Object> model = new HashMap<String,Object>();
		String action = request.getParameter("action");
		String updateId = request.getParameter("updateId");
		StringBuffer errMsg = new StringBuffer();
		//get mother HEADF from session 
		JsonTrorOrderHeaderRecord headerOrderRecord = (JsonTrorOrderHeaderRecord)session.getAttribute(TrorConstants.SESSION_RECORD_ORDER_TROR_FLY);
		
		//Convert DTO to DAO ... + mapper converters
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(this.daoConverter.doBigDecimal());
		modelMapper.addConverter(this.daoConverter.doInteger());
		//handover from dto to dao
		DokefDao daoSource = modelMapper.map(recordToValidate, DokefDao.class);
		
		if (appUser == null) {
			return this.loginView;
		} else {
			
			if (MainMaintenanceConstants.ACTION_CREATE.equals(action)) {  //New
				logger.info("Inside - CREATE NEW");
				// Validate
				//TODO TrorOrderFlyFraktbrevImpValidator validator = new TrorOrderFlyFraktbrevImpValidator();
				//TODO validator.validate(recordToValidate, bindingResult);
				if (bindingResult.hasErrors()) {
					//TODO updateOk = false;
					//TODO logger.info("[ERROR Validation] Record does not validate)");
					//TODO model.put("action", MainMaintenanceConstants.ACTION_CREATE);
					//TODO model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				} else {
					
					daoSource = this.updateRecordDokef(appUser, daoSource, MainMaintenanceConstants.MODE_ADD, errMsg);
					if (daoSource == null) {
						updateOk = false;
						this.setErrorsOnUpdate(model, recordToValidate, action, "[ERROR CREATE] Record create unsuccessful", errMsg);
					}
					
				}

			} else if (MainMaintenanceConstants.ACTION_UPDATE.equals(action)) { //Update
				logger.info("Inside - UPDATE...");
			
				//Validate
				//TrorOrderFlyFraktbrevImpValidator validator = new TrorOrderFlyFraktbrevImpValidator();
				//TODO ...validator.validate(recordToValidate, bindingResult);
				if (bindingResult.hasErrors()) {
					//TODO ...logger.info("[ERROR Validation] Record does not validate)");
					//TODO ...model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
					//TODO ...model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				} else {
					daoSource = this.updateRecordDokef(appUser, daoSource, MainMaintenanceConstants.MODE_UPDATE, errMsg);
					if (daoSource == null) {
						updateOk = false;
						this.setErrorsOnUpdate(model, recordToValidate, action, "[ERROR UPDATE] Record update unsuccessful", errMsg);
					}
				} 
				
			} else if (MainMaintenanceConstants.ACTION_DELETE.equals(action)) { 
				
				daoSource = this.updateRecordDokef(appUser, daoSource, MainMaintenanceConstants.MODE_DELETE, errMsg);
				if (daoSource == null) {
					updateOk = false;
					this.setErrorsOnUpdate(model, recordToValidate, action, "[ERROR DELETE] Record delete unsuccessful", errMsg);
				}
			} 
			
			//---------------------
			//FETCH record
			//---------------------
			if(updateOk){
				logger.info("FETCH branch");
				//get the fraktbrev's record
				DokefDao recordDokefDao = this.fetchRecordDokef(model, appUser, daoSource.getDfavd(), daoSource.getDfopd(), daoSource.getDflop());
				
				//Check for update or create new
				if(recordDokefDao!=null && recordDokefDao.getDflop()>0){
					model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefDao);
				}else{
					logger.info("getting default values");
					this.setFraktbrevDefaultValuesFromOrderHeader(recordToValidate, headerOrderRecord);
					//get the lopenr (increase +1 from the last lopnr in table)
					//TODO ---> recordToValidate.setDflop(1);
					//Prepare the view for a future create-new fraktbrev.
					model.put("action", MainMaintenanceConstants.ACTION_CREATE);
					model.put("firstAWB", "J");
					//Here we prepare the form with default values from the "Oppdrag"
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				}
			}
			
			//set tradevision flag if any
			if("J".equals(appUser.getTradevisionFlag())){
				if(this.isTradevisionUserValid(appUser)){
					model.put("tradevisionUserExists", "J");
					logger.info("tradevisionUser is valid!!!");
					//Fetch tradevision log
					this.getTradevisionLog(model, headerOrderRecord.getHegn(), appUser);
				}
			}
			//get dropdowns
			this.setCodeDropDownMgr(appUser, model);
			
		
			//model.put("dfavd", recordToValidate.getDfavd());
			//model.put("dfopd", recordToValidate.getDfopd());
			//model.put("dffbnr", recordToValidate.getDffbnr());
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL, model);
			
			return successView;		
		}
		
	}
	/**
	 * 
	 * @param model
	 * @param recordToValidate
	 * @param action
	 * @param errorLegend
	 * @param errMsg
	 */
	private void setErrorsOnUpdate(Map model, DokefDto recordToValidate, String action, String errorLegend, StringBuffer errMsg){
		logger.info("[ERROR CREATE NEW] Record creation unsuccessful ... ?)");
		model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
		model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
		model.put("action", action);
	}
	/**
	 * 
	 * @param recordToValidate
	 * @param headerOrderRecord
	 */
	private void setFraktbrevDefaultValuesFromOrderHeader(DokefDto recordToValidate, JsonTrorOrderHeaderRecord headerOrderRecord){
		//header values
		recordToValidate.setDftlfk(headerOrderRecord.getHefr());
		recordToValidate.setDftlfs(headerOrderRecord.getOwnSenderMobile());
		recordToValidate.setDftlfk(headerOrderRecord.getOwnReceiverMobile());
		
		recordToValidate.setDfdvca("NVD");
		recordToValidate.setDfdvcu("NVD");
		
		//item lines
		recordToValidate.setDfnt1(headerOrderRecord.getHent());
		recordToValidate.setDfvs1(headerOrderRecord.getHevs1());
		recordToValidate.setDfvkt1(headerOrderRecord.getHevkt());
		recordToValidate.setDffbv1(headerOrderRecord.getHevkt());
	}	
	/**
	 * 
	 * @param model
	 * @param awb
	 * @param appUser
	 */
	private void getTradevisionLog(Map model, String awb, SystemaWebUser appUser){
		AWBManager awbMgr = new AWBManager();
		if(strMgr.isNotNull(awb)){
			JsonReader<JsonDtoContainer<LogfDao>> jsonReader = new JsonReader<JsonDtoContainer<LogfDao>>();
			jsonReader.set(new JsonDtoContainer<LogfDao>());
			final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_LOGF_URL;
			StringBuilder urlRequestParams = new StringBuilder();
			urlRequestParams.append("user=" + appUser.getUser());
			urlRequestParams.append("&lgref2=" + awbMgr.getAwbPrefix(awb) + "-" + awbMgr.getAwbSuffix(awb));
			
			logger.info("URL: " + BASE_URL);
			logger.info("PARAMS: " + urlRequestParams.toString());
			String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
			logger.info("jsonPayload=" + jsonPayload);
			LogfDao record = null;
			JsonDtoContainer<LogfDao> container = (JsonDtoContainer<LogfDao>) jsonReader.get(jsonPayload);
			if (container != null) {
				if(container.getDtoList()!=null && container.getDtoList().size()>0){
					model.put("tradevisionLog", container.getDtoList());
					logger.info("tradevisionLog contains data ...");
				}
			}
		}
	}
	/**
	 * 
	 * @param appUser
	 * @param dfavd
	 * @param dfopd
	 * @param dffbnr
	 * @return
	 */
	
	private DokefimDao fetchRecord(Map model, SystemaWebUser appUser, int imavd, int imopd, int imlop) {
		DokefimDao dao = null;
		if(imlop>0){
			List<DokefimDao> list = this.fetchFlyImportFraktbrevList(model, appUser, imavd, imopd, imlop);
			for (DokefimDao record : list ){
				dao = record;
			}
		}
		return dao;
	
	}
	/**
	 * 
	 * @param model
	 * @param appUser
	 * @param avd
	 * @param opd
	 * @param lop
	 * @return
	 */
	private DokefDao fetchRecordDokef(Map model, SystemaWebUser appUser, int avd, int opd, int lop) {
		DokefDao dao = null;
		if(lop>0){
			List<DokefDao> list = this.fetchFlyFraktbrev(model, appUser, avd, opd, lop);
			for (DokefDao record : list ){
				dao = record;
			}
		}
		return dao;
	
	}
	/**
	 * Next counter
	 * @param model
	 * @param appUser
	 * @param imavd
	 * @param imopd
	 * @param imlop
	 * @return
	 */
	private int getNewLopenr(Map model, SystemaWebUser appUser, int imavd, int imopd, int imlop) {
		int retval = 0;
		List<DokefimDao> list = this.fetchFlyImportFraktbrevList(model, appUser, imavd, imopd, imlop);
		for (DokefimDao record : list ){
			//logger.info("imlop:" + record.getImlop());
			retval = record.getImlop();
		}
		
		return ++retval;
	
	}
	
	/**
	 * 
	 * @param model
	 * @param appUser
	 * @param imavd
	 * @param imopd
	 * @param imlop
	 * @return
	 */
	private List<DokefimDao> fetchFlyImportFraktbrevList(Map model, SystemaWebUser appUser, int imavd, int imopd, int imlop) {
		List<DokefimDao> retval = new ArrayList<DokefimDao>();
		
		JsonReader<JsonDtoContainer<DokefimDao>> jsonReader = new JsonReader<JsonDtoContainer<DokefimDao>>();
		jsonReader.set(new JsonDtoContainer<DokefimDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_DOKEFIM_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		urlRequestParams.append("&imavd=" + imavd);
		urlRequestParams.append("&imopd=" + imopd);
		if(imlop>0){
			urlRequestParams.append("&imlop=" + imlop);
		}
		
		
		logger.info("URL: " + BASE_URL);
		logger.info("PARAMS: " + urlRequestParams.toString());
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
		logger.info("jsonPayload=" + jsonPayload);
		DokefimDao record = null;
		JsonDtoContainer<DokefimDao> container = (JsonDtoContainer<DokefimDao>) jsonReader.get(jsonPayload);
		if (container != null) {
			retval = container.getDtoList();
			for(DokefimDao dao : container.getDtoList()){
				this.getCustomerInfo(appUser, String.valueOf(dao.getHekns()), model );
			}
		}
		return retval;
	
	}
	/**
	 * 
	 * @param model
	 * @param appUser
	 * @param imavd
	 * @param imopd
	 * @param imlop
	 * @return
	 */
	private List<DokefDao> fetchFlyFraktbrev(Map model, SystemaWebUser appUser, int dfavd, int dfopd, int dflop) {
		List<DokefDao> retval = new ArrayList<DokefDao>();
		
		JsonReader<JsonDtoContainer<DokefDao>> jsonReader = new JsonReader<JsonDtoContainer<DokefDao>>();
		jsonReader.set(new JsonDtoContainer<DokefDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_DOKEF_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		urlRequestParams.append("&dfavd=" + dfavd);
		urlRequestParams.append("&dfopd=" + dfopd);
		if(dflop>0){
			urlRequestParams.append("&dflop=" + dflop);
		}
		
		
		logger.info("URL: " + BASE_URL);
		logger.info("PARAMS: " + urlRequestParams.toString());
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
		logger.info("jsonPayload=" + jsonPayload);
		DokefDao record = null;
		JsonDtoContainer<DokefDao> container = (JsonDtoContainer<DokefDao>) jsonReader.get(jsonPayload);
		if (container != null) {
			
			List<DokefDao> tmpList = container.getDtoList();
			if(tmpList!=null && tmpList.size()>0){
				retval = tmpList;
				for(DokefDao dao : tmpList){
					if(dao!=null){
						//this variable is not serialized on db as all other totals...
						BigDecimal x = dao.getDffbv1().add(dao.getDffbv2().add(dao.getDffbv3().add(dao.getDffbv4().add(dao.getDffbv5().add(dao.getDffbv6())))));
						//logger.info("FVekt:!!!!!!!:" + x);
						model.put("fvektTotal", x);
					}
				}
			}	
			
		}
		return retval;
	
	}
	
	/**
	 * Checks if tradevision user exists
	 * @param model
	 * @param appUser
	 * @return
	 */
	private boolean isTradevisionUserValid(SystemaWebUser appUser) {
		boolean retval = false;
		
		JsonReader<JsonDtoContainer<LocfDao>> jsonReader = new JsonReader<JsonDtoContainer<LocfDao>>();
		jsonReader.set(new JsonDtoContainer<LocfDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_LOCF_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		
		logger.info("URL: " + BASE_URL);
		logger.info("PARAMS: " + urlRequestParams.toString());
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
		logger.info("jsonPayload=" + jsonPayload);
		JsonDtoContainer<LocfDao> container = (JsonDtoContainer<LocfDao>) jsonReader.get(jsonPayload);
		if (container != null) {
			
			List<LocfDao> tmpList = container.getDtoList();
			if(tmpList!=null && tmpList.size()>0){
				retval = true;
				
			}	
			
		}
		return retval;
	
	}
	/**
	 * 
	 * @param appUser
	 * @param kundnr
	 */
	private void getCustomerInfo(SystemaWebUser appUser, String kundnr, Map model ){
		//-------------------------------------------
		//Now get all info of the specific kund nr.
		//-------------------------------------------
		String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYCUNDFR_GET_LIST_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		if (kundnr != null ){
			urlRequestParams.append("&kundnr=" + kundnr);
			if(appUser.getCompanyCode() != null) {
				urlRequestParams.append("&firma=" + appUser.getCompanyCode());
			}
			//
			logger.info("URL: " + BASE_URL);
    		//logger.info("PARAMS: " + urlRequestParams.toString());
    		String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
    		Collection<JsonMaintMainCundfRecord> cundfList = new ArrayList<JsonMaintMainCundfRecord>();
    		if (jsonPayload != null) {
    			JsonMaintMainCundfContainer container = this.maintMainCundfService.getList(jsonPayload);
    			if (container != null) {
    				
    				for(JsonMaintMainCundfRecord  record : container.getList()){
    					//must be an integer key since DocefimDao.hekns = int
    					model.put(Integer.valueOf(kundnr), record.getKnavn());
    					break;
    				}
   
    			}
    		}
			
		}
	}
	/**
	 * 
	 * @param record
	 * @param model
	 */
	/*
	private void setSpecialValuesForPresentation(SystemaWebUser appUser, DokufDao record, Map model ){
		String UNITOFMEASURE_1 = "uom1";
		String UNITOFMEASURE_1_LENGTH = "uom1Length";
		
		
		String UOM_SEPARATOR = " ";
		if(strMgr.isNotNull(record.getDfvs())){
			int index = record.getDfvs().indexOf(UOM_SEPARATOR);
			if(index>=0){
				String uom = record.getDfvs().substring(0,index);
				//Check if uom is valid
				if(this.flyMgr.findUnitOfMeasure(this.urlCgiProxyService, this.maintNctsExportTrkodfService, appUser, uom)){
					model.put(UNITOFMEASURE_1, uom);
					model.put(UNITOFMEASURE_1_LENGTH, uom.length());
					//logger.info("UOM!!!!!!!!!!!!!!!!:" + uom);
				}else{
					//logger.info("INVALID uom!!!!!");
					model.put(UNITOFMEASURE_1, "");
					model.put(UNITOFMEASURE_1_LENGTH, 0);
				}
			}
		}
		
	}*/
	
	
	/**
	 * 
	 * @param appUser
	 * @param record
	 * @param mode
	 * @param errMsg
	 * @return
	 */
	
	private DokefimDao updateRecord(SystemaWebUser appUser, DokefimDao record, String mode, StringBuffer errMsg) {
		DokefimDao savedRecord = null;
		JsonReader<JsonDtoContainer<DokefimDao>> jsonReader = new JsonReader<JsonDtoContainer<DokefimDao>>();
		jsonReader.set(new JsonDtoContainer<DokefimDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_DOKEFIM_DML_UPDATE_URL;
		String urlRequestParamsKeys = "user=" + appUser.getUser() + "&mode=" + mode + "&lang=" +appUser.getUsrLang();
		String urlRequestParams = this.urlRequestParameterMapper.getUrlParameterValidString(record);
		urlRequestParams = urlRequestParamsKeys + urlRequestParams;

		logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
		logger.info("URL: " + jsonDebugger.getBASE_URL_NoHostName(BASE_URL));
		logger.info("URL PARAMS: " + urlRequestParams);
		List<DokefimDao> list = new ArrayList<DokefimDao>();
		String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
		logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
		
		if (jsonPayload != null) {
			JsonDtoContainer<DokefimDao> container = (JsonDtoContainer<DokefimDao>) jsonReader.get(jsonPayload);
			if (container != null) {
				if (container.getErrMsg() != null && !"".equals(container.getErrMsg())) {
					errMsg.append(container.getErrMsg());
					return null;
				}
				list = (List<DokefimDao>) container.getDtoList();
				for (DokefimDao dao : list) {
					savedRecord = dao;
				}
			}
			
		}
		logger.info("savedRecord="+ReflectionToStringBuilder.toString(savedRecord));
		return savedRecord;
	}	
	/**
	 * Updates the DOKEF-table (fraktbrevs update)
	 * @param appUser
	 * @param record
	 * @param mode
	 * @param errMsg
	 * @return
	 */
	private DokefDao updateRecordDokef(SystemaWebUser appUser, DokefDao record, String mode, StringBuffer errMsg) {
		DokefDao savedRecord = null;
		JsonReader<JsonDtoContainer<DokefDao>> jsonReader = new JsonReader<JsonDtoContainer<DokefDao>>();
		jsonReader.set(new JsonDtoContainer<DokefDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_DOKEF_DML_UPDATE_URL;
		String urlRequestParamsKeys = "user=" + appUser.getUser() + "&mode=" + mode + "&lang=" +appUser.getUsrLang();
		String urlRequestParams = this.urlRequestParameterMapper.getUrlParameterValidString(record);
		urlRequestParams = urlRequestParamsKeys + urlRequestParams;

		logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
		logger.info("URL: " + jsonDebugger.getBASE_URL_NoHostName(BASE_URL));
		logger.info("URL PARAMS: " + urlRequestParams);
		List<DokefDao> list = new ArrayList<DokefDao>();
		String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
		logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
		
		if (jsonPayload != null) {
			JsonDtoContainer<DokefDao> container = (JsonDtoContainer<DokefDao>) jsonReader.get(jsonPayload);
			if (container != null) {
				if (container.getErrMsg() != null && !"".equals(container.getErrMsg())) {
					errMsg.append(container.getErrMsg());
					return null;
				}
				list = (List<DokefDao>) container.getDtoList();
				for (DokefDao dao : list) {
					savedRecord = dao;
				}
			}
			
		}
		logger.info("savedRecord="+ReflectionToStringBuilder.toString(savedRecord));
		return savedRecord;
	}	
	
	
	/**
	 * 
	 * @param appUser
	 * @param model
	 */
	private void setCodeDropDownMgr(SystemaWebUser appUser, Map model){
		
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonString(urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser, this.codeDropDownMgr.CODE_TYPE_MLAPKOD);
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonProductLandimporFraktbrev(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonEnhet(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		
		//Sign / AVD
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonSignature(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonAvdelning(this.urlCgiProxyService, this.maintMainKodtaService, model, appUser);
		
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonCountry(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonIncoterms(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonOppdragsType(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		//this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonTransporttype(this.urlCgiProxyService, this.maintSadImportKodts4Service, model, appUser);
		this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonCurrency(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
		this.codeDropDownMgr.populateCodesHtmlDropDownsFromJsonRateClass(this.urlCgiProxyService, this.trorDropDownListPopulationService, model, appUser);
						
		
		
	}
	
	//SERVICES
	@Qualifier ("urlCgiProxyService")
	private UrlCgiProxyService urlCgiProxyService;
	@Autowired
	@Required
	public void setUrlCgiProxyService (UrlCgiProxyService value){ this.urlCgiProxyService = value; }
	public UrlCgiProxyService getUrlCgiProxyService(){ return this.urlCgiProxyService; }

	
	@Qualifier ("trorDropDownListPopulationService")
	private TrorDropDownListPopulationService trorDropDownListPopulationService;
	@Autowired
	@Required
	public void setTrorDropDownListPopulationService (TrorDropDownListPopulationService value){ this.trorDropDownListPopulationService = value; }
	public TrorDropDownListPopulationService getTrorDropDownListPopulationService(){ return this.trorDropDownListPopulationService; }
	

	
	@Qualifier ("trorMainOrderHeaderFlyimportService")
	private TrorMainOrderHeaderFlyimportService trorMainOrderHeaderFlyimportService;
	@Autowired
	@Required
	public void setTrorMainOrderHeaderFlyimportService (TrorMainOrderHeaderFlyimportService value){ this.trorMainOrderHeaderFlyimportService = value; }
	public TrorMainOrderHeaderFlyimportService getTrorMainOrderHeaderFlyimportService(){ return this.trorMainOrderHeaderFlyimportService; }
	
	
	@Qualifier ("maintMainKodtaService")
	private MaintMainKodtaService maintMainKodtaService;
	@Autowired
	@Required
	public void setMaintMainKodtaService (MaintMainKodtaService value){ this.maintMainKodtaService = value; }
	public MaintMainKodtaService getMaintMainKodtaService(){ return this.maintMainKodtaService; }
	
	@Qualifier ("maintMainCundfService")
	private MaintMainCundfService maintMainCundfService;
	@Autowired
	@Required
	public void setMaintMainCundfService (MaintMainCundfService value){ this.maintMainCundfService = value; }
	public MaintMainCundfService getMaintMainCundfService(){ return this.maintMainCundfService; }
	
	@Qualifier ("maintMainFirmService")
	private MaintMainFirmService maintMainFirmService;
	@Autowired
	@Required
	public void setMaintMainFirmService (MaintMainFirmService value){ this.maintMainFirmService = value; }
	public MaintMainFirmService getMaintMainFirmService(){ return this.maintMainFirmService; }
	
	
	
}

