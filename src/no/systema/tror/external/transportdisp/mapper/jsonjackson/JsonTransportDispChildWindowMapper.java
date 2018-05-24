/**
 * 
 */
package no.systema.tror.external.transportdisp.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispAvdContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispAvdRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispBilCodeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispBilCodeRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispBilNrContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispBilNrRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCustomerContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCustomerRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispDangerousGoodsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispDangerousGoodsRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispDriverContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispDriverRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFileUploadValidationContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiCodesRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiDocCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiDocCodesRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispGebyrCodeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispGebyrCodeRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispLoadUnloadPlacesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispLoadUnloadPlacesRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispPackingCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispPackingCodesRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSendSmsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSupplierContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSupplierRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispTollstedCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispTollstedCodesRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispTranspCarrierContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispTranspCarrierRecord;


/**
 * @author oscardelatorre
 * @date Apr 1, 2015
 * 
 */
public class JsonTransportDispChildWindowMapper extends ObjectMapperAbstractGrandFather{
	private static final Logger logger = Logger.getLogger(JsonTransportDispChildWindowMapper.class.getName());
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispAvdContainer getAvdContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispAvdContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispAvdContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispAvdRecord record : container.getAvdelningar()){
			//DEBUG
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispBilCodeContainer getBilCodeContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispBilCodeContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispBilCodeContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispBilCodeRecord record : container.getBilkodlist()){
			//DEBUG
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispBilNrContainer getBilNrContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispBilNrContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispBilNrContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispBilNrRecord record : container.getBilnrlist()){
			//DEBUG
		}
		return container;
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispTranspCarrierContainer getTranspCarrierContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispTranspCarrierContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispTranspCarrierContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispTranspCarrierRecord record : container.getTranslist()){
			//DEBUG
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispDriverContainer getDriverContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispDriverContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispDriverContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispDriverRecord record : container.getSjoflist()){
			//DEBUG
		}
		return container;
	}
	
	/**
	 * Get Customer
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispCustomerContainer getCustomerContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispCustomerContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispCustomerContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispCustomerRecord record : container.getInqcustomer()){
			//DEBUG
		}
		return container;
	}

	/**
	 * Load/Unload places
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispLoadUnloadPlacesContainer getLoadUnloadPlacesContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispLoadUnloadPlacesContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispLoadUnloadPlacesContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispLoadUnloadPlacesRecord record : container.getInqlosslass()){
			//DEBUG
		}
		return container;
	}
	
	/**
	 * File Upload
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispFileUploadValidationContainer getFileUploadValidationContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispFileUploadValidationContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispFileUploadValidationContainer.class); 
		logger.info("[JSON-String payload errMsg]:" + container.getErrMsg());
		
		return container;
	}
	
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispDangerousGoodsContainer getDangerousGoodsContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispDangerousGoodsContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispDangerousGoodsContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container);
		for (JsonTransportDispDangerousGoodsRecord record : container.getUnNumbers()){
			//record.getAdindx();
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispPackingCodesContainer getPackingCodesContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispPackingCodesContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispPackingCodesContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container);
		for (JsonTransportDispPackingCodesRecord record : container.getForpaknKoder()){
			//record.getAdindx();
		}
		return container;
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispTollstedCodesContainer getTollstedCodesContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispTollstedCodesContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispTollstedCodesContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container);
		for (JsonTransportDispTollstedCodesRecord record : container.getTollstedsKoder()){
			//record.getAdindx();
		}
		return container;
	}
	
	/**
	 * Leverantörregistret - Supplier
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispSupplierContainer getSupplierContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispSupplierContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispSupplierContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container);
		for (JsonTransportDispSupplierRecord record : container.getLeverandorer()){
			//record.getAdindx();
		}
		return container;
	}
	
	/**
	 * Gebyrkoder
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispGebyrCodeContainer getGebyrContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispGebyrCodeContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispGebyrCodeContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getGebyrKoder());
		for (JsonTransportDispGebyrCodeRecord record : container.getGebyrKoder()){
			//record.getAdindx();
		}
		return container;
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispFrisokveiCodesContainer getFrisokveiContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispFrisokveiCodesContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispFrisokveiCodesContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getGebyrKoder());
		for (JsonTransportDispFrisokveiCodesRecord record : container.getAwblinelist()){
			//record.getAdindx();
		}
		return container;
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispFrisokveiDocCodesContainer getFrisokveiDocContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispFrisokveiDocCodesContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispFrisokveiDocCodesContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getGebyrKoder());
		for (JsonTransportDispFrisokveiDocCodesRecord record : container.getAwblinelist()){
			//record.getAdindx();
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispSendSmsContainer getSendSmsContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispSendSmsContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispSendSmsContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getGebyrKoder());
		
		return container;
	}
}
