/**
 * 
 */
package no.systema.tror.external.transportdisp.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCustomerDeliveryAddressContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCustomerDeliveryAddressRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderArchivedDocsRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFraktbrevContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFraktbrevRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderMessageNoteContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderMessageNoteRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderRecord;




/**
 * @author oscardelatorre
 * @date Maj 8, 2015
 * 
 */
public class JsonTransportDispWorkflowSpecificOrderMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(JsonTransportDispWorkflowSpecificOrderMapper.class.getName());
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispWorkflowSpecificOrderContainer getContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificOrderRecord record : container.getDspoppdrag()){
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
	public JsonTransportDispWorkflowSpecificOrderMessageNoteContainer getMessageNoteContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderMessageNoteContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderMessageNoteContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificOrderMessageNoteRecord record : container.getFreetextlistA()){
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
	public JsonTransportDispWorkflowSpecificOrderFraktbrevContainer getFraktbrevContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderFraktbrevContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderFraktbrevContainer.class); 
		//logger.info("[container]:" + container);
		if(container!=null){
			//logger.info("[JSON-String payload status=OK]  " + container.getUser());
			//logger.info("[JSON-String payload errMsg]  " + container.getErrMsg());
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispCustomerDeliveryAddressContainer getDeliveryAddressContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispCustomerDeliveryAddressContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispCustomerDeliveryAddressContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispCustomerDeliveryAddressRecord record : container.getInqdeladdr()){
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
	public JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer getFraktbrevPdfContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer getArchivedDocsContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificOrderArchivedDocsRecord record : container.getGetdoc()){
			//DEBUG
		}
		return container;
	}
	
	
	
	
}
