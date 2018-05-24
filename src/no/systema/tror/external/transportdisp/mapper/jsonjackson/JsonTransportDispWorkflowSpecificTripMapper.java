/**
 * 
 */
package no.systema.tror.external.transportdisp.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripArchivedDocsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripArchivedDocsRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripMessageNoteContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripMessageNoteRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripRecord;


/**
 * @author oscardelatorre
 * @date Apr 1, 2015
 * 
 */
public class JsonTransportDispWorkflowSpecificTripMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(JsonTransportDispWorkflowSpecificTripMapper.class.getName());
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispWorkflowSpecificTripContainer getContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificTripContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificTripContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificTripRecord record : container.getGetonetrip()){
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
	public JsonTransportDispWorkflowSpecificTripContainer getUpdateContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificTripContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificTripContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificTripRecord record : container.getUpdatetrip()){
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
	public JsonTransportDispWorkflowSpecificTripArchivedDocsContainer getArchivedDocsContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificTripArchivedDocsContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificTripArchivedDocsContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificTripArchivedDocsRecord record : container.getGetdoctrip()){
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
	public JsonTransportDispWorkflowSpecificTripMessageNoteContainer getMessageNoteContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificTripMessageNoteContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificTripMessageNoteContainer.class); 
		logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificTripMessageNoteRecord record : container.getFreetextlist()){
			//DEBUG
		}
		return container;
	}
	
}
