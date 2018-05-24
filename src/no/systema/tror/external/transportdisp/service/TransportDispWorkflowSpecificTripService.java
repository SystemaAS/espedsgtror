/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripArchivedDocsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificTripMessageNoteContainer;


/**
 * 
 * @author oscardelatorre
 * @date Mar 31, 2015
 * 
 *
 */
public interface TransportDispWorkflowSpecificTripService {
	public JsonTransportDispWorkflowSpecificTripContainer getContainer(String utfPayload);
	public JsonTransportDispWorkflowSpecificTripContainer getUpdateContainer(String utfPayload);
	public JsonTransportDispWorkflowSpecificTripArchivedDocsContainer getArchivedDocsContainer(String utfPayload);
	public JsonTransportDispWorkflowSpecificTripMessageNoteContainer getMessageNoteContainer(String utfPayload);
	
	
}
