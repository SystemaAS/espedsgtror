package no.systema.tror.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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


import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.LocfDao;
import no.systema.jservices.common.dao.LogfDao;
import no.systema.jservices.common.dto.KostaDto;
import no.systema.tror.model.jsonjackson.Ffr00fDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

import no.systema.jservices.common.json.JsonDtoContainer;
import no.systema.jservices.common.json.JsonReader;

import no.systema.main.model.SystemaWebUser;
import no.systema.main.util.StringManager;
import no.systema.main.util.NumberFormatterLocaleAware;

import no.systema.main.validator.UserValidator;

import no.systema.main.service.UrlCgiProxyService;
import no.systema.main.util.AppConstants;
import no.systema.main.util.JsonDebugger;
import no.systema.main.util.MessageNoteManager;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderRecord;
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
 * Tror - Air Freight Bill - Tradevision Controller (flyfraktbrev) 
 * 
 * @author oscardelatorre
 * @date Feb, 2019
 * 
 */

@Controller
@SessionAttributes(AppConstants.SYSTEMA_WEB_USER_KEY)
@Scope("session")
public class TrorMainOrderHeaderFlyControllerAirFreightBillTrvision {
	private static Logger logger = Logger.getLogger(TrorMainOrderHeaderFlyControllerAirFreightBillTrvision.class.getName());
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
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	@PostConstruct
	public void initIt() throws Exception {
		//init managers
		
	}

	/**
	 * 
	 * @param recordToValidate
	 * @param bindingResult
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="tror_mainorderfly_airfreightbill_trvision_edit.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tror_mainorderfly_airfreightbill_trvision(@ModelAttribute ("record") Ffr00fDto recordToValidate, BindingResult bindingResult, HttpSession session, HttpServletRequest request){
		ModelAndView successView = new ModelAndView("tror_mainorderfly_airfreightbill_trvision");
		
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map<String,Object> model = new HashMap<String,Object>();
		String action = request.getParameter("action");
		String updateId = request.getParameter("updateId");
		StringBuffer errMsg = new StringBuffer();
		String mawb = request.getParameter("mawb");
		String awb = "";
		if(strMgr.isNotNull(mawb)){
			if(mawb.length()>=11){
				awb = mawb.substring(mawb.length()-11);
				model.put("awb",awb);
			}
		}
	
		if (appUser == null) {
			return this.loginView;
		} else {
			
			if (MainMaintenanceConstants.ACTION_CREATE.equals(action)) {  //New
				logger.info("Inside - CREATE NEW");
				
				/*
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
					}
					
				} */

			} else if (MainMaintenanceConstants.ACTION_UPDATE.equals(action)) { //Update
				logger.info("Inside - UPDATE...");
				/*
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
					}
					
				} */
				
			} else if (MainMaintenanceConstants.ACTION_DELETE.equals(action)) { //Delete
					/*
					savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_DELETE, errMsg);
					if (savedRecord == null) {
						logger.info("[ERROR Validation] Record does not validate)");
						model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					} else {
						DokefimDao recordDokefimDao = this.fetchRecord(model, appUser, recordToValidate.getImavd(), recordToValidate.getImopd(), recordToValidate.getImlop());
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefimDao);
					}
					*/
			} else { // Fetch
				logger.info("FETCH branch");
				//recordToValidate.setF0235("1,55");
				//recordToValidate.setF0221("aeo");
				//mapper converters
				ModelMapper modelMapper = new ModelMapper();
				modelMapper.addConverter(this.daoConverter.doBigDecimal());
				modelMapper.addConverter(this.daoConverter.doInteger());
				//handover from dto to dao
				Ffr00fDao daoSource = modelMapper.map(recordToValidate, Ffr00fDao.class);
				
				//Extract awb-numbers
				AWBManager mgr = new AWBManager();
				daoSource.setF0211(mgr.getAwbPrefix(awb));
				daoSource.setF0213(mgr.getAwbSuffix(awb));
				//Parent
				Ffr00fDao dao = this.fetchTrvisionParentRecord(appUser, daoSource);
				model.put(MainMaintenanceConstants.DOMAIN_RECORD, dao);
				
				//Check if the booking exists and if so: send a flag
				if(this.bookingExists( appUser, dao.getF00rec())){
					model.put("bookingExists", "J");
					logger.info("booking previously registrated ...");
				}
				
				/*DokefDao recordDokefDao = this.fetchRecordDokef(model, appUser, recordToValidate.getDfavd(), recordToValidate.getDfopd(), recordToValidate.getDflop());
				
				if("J".equals(appUser.getTradevisionFlag())){
					if(this.isTradevisionUserValid(appUser)){
						model.put("tradevisionUserExists", "J");
					}
				}
				if(recordDokefDao!=null && recordDokefDao.getDflop()>0){
					model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordDokefDao);
				}else{
					//get the lopenr (increase +1 from the last lopnr in table)
					//TODO ? -->> recordToValidate.setDflop(this.getNewLopenr(model, appUser, recordToValidate.getDfavd(), recordToValidate.getDfopd(), recordToValidate.getDflop()));
					//Prepare the view for a future create-new fraktbrev.
					model.put("action", MainMaintenanceConstants.ACTION_CREATE);
					//Here we prepare the form with default values from the "Oppdrag"
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				}
				*/
				
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
	 * @param appUser
	 * @param avd
	 * @param opd
	 * @param lop
	 * @return
	 */
	private Ffr00fDao fetchTrvisionParentRecord(SystemaWebUser appUser, Ffr00fDao recordToValidate) {
		Ffr00fDao record = new Ffr00fDao();
		
		JsonReader<JsonDtoContainer<Ffr00fDao>> jsonReader = new JsonReader<JsonDtoContainer<Ffr00fDao>>();
		jsonReader.set(new JsonDtoContainer<Ffr00fDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_FFR00F_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		urlRequestParams.append("&f0211=" + recordToValidate.getF0211());
		urlRequestParams.append("&f0213=" + recordToValidate.getF0213());
		
		logger.info("URL: " + BASE_URL);
		logger.info("PARAMS: " + urlRequestParams.toString());
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
		logger.info("jsonPayload=" + jsonPayload);
		JsonDtoContainer<Ffr00fDao> container = (JsonDtoContainer<Ffr00fDao>) jsonReader.get(jsonPayload);
		if (container != null) {
			
			List<Ffr00fDao> tmpList = container.getDtoList();
			if(tmpList!=null && tmpList.size()>0){
				for(Ffr00fDao dao : tmpList){
					if(dao!=null){
						dao.setF0235(numberFormatter.formatBigDecimal(2, dao.getF0235()));
						record = dao;
					}
				}
			}	
			
		}
		

		return record;
	
	}
	/**
	 * Check if the booking has previously been carried out ...
	 * @param model
	 * @param appUser
	 * @param id
	 * @return
	 */
	private boolean bookingExists(SystemaWebUser appUser, Integer id) {
		boolean retval = false;
		
		JsonReader<JsonDtoContainer<LogfDao>> jsonReader = new JsonReader<JsonDtoContainer<LogfDao>>();
		jsonReader.set(new JsonDtoContainer<LogfDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_LOGF_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		urlRequestParams.append("&lgrecn=" + id);
		
		logger.info("URL: " + BASE_URL);
		logger.info("PARAMS: " + urlRequestParams.toString());
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
		logger.info("jsonPayload=" + jsonPayload);
		
		JsonDtoContainer<LogfDao> container = (JsonDtoContainer<LogfDao>) jsonReader.get(jsonPayload);
		if (container != null) {
			List<LogfDao> tmpList = container.getDtoList();
			if(tmpList!=null && tmpList.size()>0){
				for(LogfDao dao : tmpList){
					if(dao!=null && "FFR".equals(dao.getLgmsid())){
						logger.info("MATCH!");
						retval = true;
						break;
					}
				}
			}		
		}
		return retval;
	
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
	/*
	private int getNewLopenr(Map model, SystemaWebUser appUser, int imavd, int imopd, int imlop) {
		int retval = 0;
		List<DokefimDao> list = this.fetchFlyImportFraktbrevList(model, appUser, imavd, imopd, imlop);
		for (DokefimDao record : list ){
			//logger.info("imlop:" + record.getImlop());
			retval = record.getImlop();
		}
		
		return ++retval;
	
	}
	*/
	
	
	
	
	
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

