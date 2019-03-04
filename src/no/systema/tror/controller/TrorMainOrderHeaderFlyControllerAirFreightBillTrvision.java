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

import no.systema.jservices.common.dao.DokefDao;
import no.systema.jservices.common.dao.DokefimDao;
import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.LocfDao;
import no.systema.jservices.common.dao.LogfDao;
import no.systema.jservices.common.dto.KostaDto;
import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.modelmapper.converter.DaoConverter;
import org.modelmapper.ModelMapper;

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
import no.systema.tror.validator.TrorOrderFraktbrevBookingTradevisionValidator;

/**
 * Tror - Air Freight Bill - Tradevision Controller (flyfraktbrev) 
 * 
 * Tradevision model is as follows:
 * FFR00F: Parent file for booking - Key field: F00REC
 * FFR03F: Child file - Key field: F03REC
 * FFR04F: Child file (ULD) - Key field: F04REC
 * FFR08F: Child file (Dimensions) - Key field: F08REC
 * FFR10F: Child file (Shipper) - Key field: F10REC
 * FFR11F: Child file (Consignee) - Key field: F11REC
 * --adjacent files for a tradevision booking to work
 * LOGF: log file - Key field towards FFR00F: LGRECN
 * CNFF: config file - Key field towards FFR00F: CNRECN
 * PARF: participant file - Key field towards FFR00F: PAID
 * LOCF: local file - Key field towards FFR00F: LOID
 * ISUF: issuing carrier file (validation towards airlines)
 * NCTF: not valid city codes
 * CPFF: data on IATA return (to read the data text send by IATA)
 * 
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
	private AWBManager awbMgr = new AWBManager();
	
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
		//get mother HEADF from session 
		JsonTrorOrderHeaderRecord headerOrderRecord = (JsonTrorOrderHeaderRecord)session.getAttribute(TrorConstants.SESSION_RECORD_ORDER_TROR_FLY);
				
		Map<String,Object> model = new HashMap<String,Object>();
		String action = request.getParameter("action");
		String updateId = request.getParameter("updateId");
		StringBuffer errMsg = new StringBuffer();
		String mawb = request.getParameter("mawb");
		String avd = request.getParameter("opd");
		String opd = request.getParameter("avd");
		String sign = request.getParameter("sign");
		
		
		//adjust awb
		String awb = "";
		if(strMgr.isNotNull(mawb)){
			if(mawb.length()>=11){
				awb = mawb.substring(mawb.length()-11);
				recordToValidate.setF0211(String.valueOf(awbMgr.getAwbPrefix(awb)));
				recordToValidate.setF0213(String.valueOf(awbMgr.getAwbSuffix(awb)));
			}
		}
		
		//START process
		if (appUser == null) {
			return this.loginView;
		} else {
			Ffr00fDto savedRecord = new Ffr00fDto();
			TrorOrderFraktbrevBookingTradevisionValidator validator = new TrorOrderFraktbrevBookingTradevisionValidator();
			
			if (MainMaintenanceConstants.ACTION_CREATE.equals(action)) {  //New
				logger.info("Inside - CREATE NEW");
				// Validate
				validator.validate(recordToValidate, bindingResult);
				if (bindingResult.hasErrors()) {
					logger.info("[ERROR Validation] Record does not validate)");
					model.put("action", MainMaintenanceConstants.ACTION_CREATE);
					model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
				} else {
					//CREATE NEW
					savedRecord = updateRecord(appUser, recordToValidate, MainMaintenanceConstants.MODE_ADD, errMsg);
					if (savedRecord == null) {
						logger.info("[ERROR Validation] Record does not validate)");
						model.put(MainMaintenanceConstants.ASPECT_ERROR_MESSAGE, errMsg.toString());
						model.put("action", MainMaintenanceConstants.ACTION_CREATE);
						model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
					} 
				}

			} else if (MainMaintenanceConstants.ACTION_UPDATE.equals(action)) { //Update
				logger.info("Inside - UPDATE...");
				//Validate
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
					} 
				}
				
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
			}
			// Fetch
			logger.info("FETCH branch");
			//get tradevision parent record
			Ffr00fDto recordFfr00fDto = this.fetchTrvisionRecord(appUser, recordToValidate);
			//Check for update or create new
			if(recordFfr00fDto!=null){
				model.put("action", MainMaintenanceConstants.ACTION_UPDATE);
				model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordFfr00fDto);
				//Check if the booking exists and if so: send a flag
				if(this.bookingExists( appUser, recordFfr00fDto.getF00rec())){
					model.put("bookingExists", "J");
					logger.info("booking previously registrated ...");
				}
			}else{
				logger.info("getting default values");
				this.setDefaultValuesFromOrderHeader(awb, recordToValidate, headerOrderRecord);
				model.put("action", MainMaintenanceConstants.ACTION_CREATE);
				model.put("firstBooking", "J");
				model.put(MainMaintenanceConstants.DOMAIN_RECORD, recordToValidate);
			}
			
			//get dropdowns
			this.setCodeDropDownMgr(appUser, model);
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL, model);
			
			return successView;		
		}
		
	}
	/**
	 * 
	 * @param appUser
	 * @param dtoRecord
	 * @param mode
	 * @param errMsg
	 * @return
	 */
	private Ffr00fDto updateRecord(SystemaWebUser appUser, Ffr00fDto dtoRecord, String mode, StringBuffer errMsg) {
		Ffr00fDto dtoResult = new Ffr00fDto();
				
		JsonReader<JsonDtoContainer<Ffr00fDto>> jsonReader = new JsonReader<JsonDtoContainer<Ffr00fDto>>();
		jsonReader.set(new JsonDtoContainer<Ffr00fDto>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FFR00F_DML_UPDATE_URL;
		String urlRequestParamsKeys = "user=" + appUser.getUser() + "&mode=" + mode + "&lang=" +appUser.getUsrLang();
		String urlRequestParams = this.urlRequestParameterMapper.getUrlParameterValidString(dtoRecord);
		urlRequestParams = urlRequestParamsKeys + urlRequestParams;

		logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
		logger.info("URL: " + jsonDebugger.getBASE_URL_NoHostName(BASE_URL));
		logger.info("URL PARAMS: " + urlRequestParams);
		List<Ffr00fDto> list = new ArrayList<Ffr00fDto>();
		String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
		logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
		
		if (jsonPayload != null) {
			JsonDtoContainer<Ffr00fDto> container = (JsonDtoContainer<Ffr00fDto>) jsonReader.get(jsonPayload);
			if (container != null) {
				if (container.getErrMsg() != null && !"".equals(container.getErrMsg())) {
					errMsg.append(container.getErrMsg());
					return null;
				}
				list = (List<Ffr00fDto>) container.getDtoList();
				for (Ffr00fDto dtoLocal : list) {
					dtoResult = dtoLocal;
				}
			}
		}
		logger.info("dtoRecord="+ReflectionToStringBuilder.toString(dtoResult));
		
		return dtoResult;
		
	}	
	/**
	 * 
	 * @param awb
	 * @param recordToValidate
	 * @param headerOrderRecord
	 */
	private void setDefaultValuesFromOrderHeader(String awb, Ffr00fDto recordToValidate, JsonTrorOrderHeaderRecord headerOrderRecord){
		if(strMgr.isNotNull(awb)){
			recordToValidate.setF0211(this.awbMgr.getAwbPrefix(awb).toString());
			recordToValidate.setF0213(this.awbMgr.getAwbSuffix(awb).toString());
		}
		recordToValidate.setF0221(headerOrderRecord.getHesdf());
		recordToValidate.setF0222(headerOrderRecord.getHesdt());
		recordToValidate.setF0272(headerOrderRecord.getHevs1());
	}
	
	
	
	
	/**
	 * 
	 * @param appUser
	 * @param recordToValidate
	 * @return
	 */
	private Ffr00fDto fetchTrvisionRecord(SystemaWebUser appUser, Ffr00fDto recordToValidate) {
		Ffr00fDto dto = null;
		//1 - FFR00F - Parent table 
		Ffr00fDao dao = this.fetchFfr00f(appUser, recordToValidate);
		//2 - FFR03 - Child table
		//TODO
		
		
		//handover to DTO for GUI
		if(dao!=null){
			ModelMapper modelMapper = new ModelMapper();
			dto = modelMapper.map(dao, Ffr00fDto.class);
		}
		
		
		return dto;
	
	}
	
	/**
	 * 
	 * @param appUser
	 * @param recordToValidate
	 * @return
	 */
	private Ffr00fDao fetchFfr00f(SystemaWebUser appUser, Ffr00fDto recordToValidate){
		
		//ModelMapper
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(this.daoConverter.doBigDecimal());
		modelMapper.addConverter(this.daoConverter.doInteger());
		//handover
		Ffr00fDao dao = modelMapper.map(recordToValidate, Ffr00fDao.class);
		
		JsonReader<JsonDtoContainer<Ffr00fDao>> jsonReader = new JsonReader<JsonDtoContainer<Ffr00fDao>>();
		jsonReader.set(new JsonDtoContainer<Ffr00fDao>());
		final String BASE_URL = TrorUrlDataStore.TROR_BASE_FETCH_FFR00F_URL;
		StringBuilder urlRequestParams = new StringBuilder();
		urlRequestParams.append("user=" + appUser.getUser());
		urlRequestParams.append("&f0211=" + dao.getF0211());
		urlRequestParams.append("&f0213=" + dao.getF0213());
		
		logger.info("URL: " + BASE_URL);
		logger.info("PARAMS: " + urlRequestParams.toString());
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams.toString());
		logger.info("jsonPayload=" + jsonPayload);
		JsonDtoContainer<Ffr00fDao> container = (JsonDtoContainer<Ffr00fDao>) jsonReader.get(jsonPayload);
		if (container != null) {
			
			List<Ffr00fDao> tmpList = container.getDtoList();
			if(tmpList!=null && tmpList.size()>0){
				for(Ffr00fDao daoLocal : tmpList){
					if(daoLocal!=null){
						dao = daoLocal;
					}
				}
			}else{
				dao = null;
			}
		}
		return dao;
	}
	/**
	 * Check if the booking has previously been carried out ...
	 * @param model
	 * @param appUser
	 * @param id
	 * @return
	 */
	private boolean bookingExists(SystemaWebUser appUser, String id) {
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

