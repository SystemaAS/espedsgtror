/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificTripMapper;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripArchivedDocsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripMessageNoteContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 1, 2015
 * 
 * 
 */
public class TransportDispWorkflowSpecificTripServiceImpl implements TransportDispWorkflowSpecificTripService {
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificTripContainer getContainer(String utfPayload) {
		JsonTransportDispWorkflowSpecificTripContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificTripMapper mapper = new JsonTransportDispWorkflowSpecificTripMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Update record (after update)
	 */
	public JsonTransportDispWorkflowSpecificTripContainer getUpdateContainer(String utfPayload) {
		JsonTransportDispWorkflowSpecificTripContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificTripMapper mapper = new JsonTransportDispWorkflowSpecificTripMapper();
			container = mapper.getUpdateContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificTripArchivedDocsContainer getArchivedDocsContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificTripArchivedDocsContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificTripMapper mapper = new JsonTransportDispWorkflowSpecificTripMapper();
			container = mapper.getArchivedDocsContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificTripMessageNoteContainer getMessageNoteContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificTripMessageNoteContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificTripMapper mapper = new JsonTransportDispWorkflowSpecificTripMapper();
			container = mapper.getMessageNoteContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	
}
