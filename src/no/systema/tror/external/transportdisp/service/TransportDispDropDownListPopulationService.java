/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import java.util.List;

import org.apache.log4j.Logger;

import no.systema.main.context.TdsServletContext;
import no.systema.main.util.io.TextFileReaderService;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispChildWindowMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispCodeMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispFrankaturMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispOppdragTypeMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispSignatureMapper;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCodeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrankaturContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispGebyrCodeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispOppdragTypeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispOppdragTypeParametersContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSignatureContainer;
import no.systema.tror.external.transportdisp.util.TransportDispConstants;







/**
 * This service fetches values into drop downs in HTML
 * Criteria is based upon whether the drop down list is static or dynamic.
 * 
 * This class is used ONLY for STATIC lists (e.g. currency codes, country codes, etc)
 * 
 * The servlet context is necessary in order to get a text-xml file within the webb-application path...
 * All static lists are retrieved from a file on disk.
 *  
 * @author oscardelatorre
 * @date Apr 24, 2015
 * 
 */
public class TransportDispDropDownListPopulationService {
	private static final Logger logger = Logger.getLogger(TransportDispDropDownListPopulationService.class.getName());
	
	private final String FILE_RESOURCE_PATH = TransportDispConstants.RESOURCE_FILES_PATH;
	private TextFileReaderService textFileReaderService = new TextFileReaderService();
	private JsonTransportDispCodeMapper codeMapper = new JsonTransportDispCodeMapper();
	private JsonTransportDispSignatureMapper signMapper = new JsonTransportDispSignatureMapper();
	private JsonTransportDispFrankaturMapper frankaturMapper = new JsonTransportDispFrankaturMapper();
	private JsonTransportDispOppdragTypeMapper oppdragTypeMapper = new JsonTransportDispOppdragTypeMapper();
	private JsonTransportDispChildWindowMapper childWindowMapper = new JsonTransportDispChildWindowMapper();
	
	/**
	 * Years
	 * @return
	 */
	public List<String> getYearList(){
		String LIST_FILE = "yearList.txt";
		List<String> list = textFileReaderService.getFileLines(TdsServletContext.getTdsServletContext().getResourceAsStream(this.FILE_RESOURCE_PATH + LIST_FILE));
		//Debug
		/*
		for(String record : list){
			logger.info(record + "X");
		}*/
		return list;
	}
	
	/**
	 * Months
	 * @return
	 */
	public List<String> getMonthList(){
		String LIST_FILE = "monthList.txt";
		List<String> list = textFileReaderService.getFileLines(TdsServletContext.getTdsServletContext().getResourceAsStream(this.FILE_RESOURCE_PATH + LIST_FILE));
		//Debug
		/*
		for(String record : list){
			logger.info(record + "X");
		}*/
		return list;
	}
	/**
	 * 
	 * @return
	 */
	public List<String> getCurrencyList(){
		String LIST_FILE = "currencyList.txt";
		List<String> list = textFileReaderService.getFileLines(TdsServletContext.getTdsServletContext().getResourceAsStream(this.FILE_RESOURCE_PATH + LIST_FILE));
		//Debug
		/*
		for(String record : list){
			logger.info(record + "X");
		}*/
		return list;
	}
	
	/**
	 * 	
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispCodeContainer getCodeContainer(String utfPayload) throws Exception{
		return this.codeMapper.getContainer(utfPayload);
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispSignatureContainer getSignContainer(String utfPayload) throws Exception{
		return this.signMapper.getContainer(utfPayload);
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispFrankaturContainer getFrankaturContainer(String utfPayload) throws Exception{
		return this.frankaturMapper.getContainer(utfPayload);
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispOppdragTypeContainer getOppdragTypeContainer(String utfPayload) throws Exception{
		return this.oppdragTypeMapper.getContainer(utfPayload);
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispOppdragTypeParametersContainer getOppdragTypeTimeContainer(String utfPayload) throws Exception{
		return this.oppdragTypeMapper.getOppdragTypeParametersContainer(utfPayload);
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispGebyrCodeContainer getGebyrCodeContainer(String utfPayload) throws Exception{
		return this.childWindowMapper.getGebyrContainer(utfPayload);
	}
	
}
