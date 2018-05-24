/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowListContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowListGodsAndLastListContainer;

/**
 * 
 * @author oscardelatorre
 * @date Mar 31, 2015
 * 
 *
 */
public interface TransportDispWorkflowListService {
	public JsonTransportDispWorkflowListContainer getWorkflowListContainer(String utfPayload);
	public JsonTransportDispWorkflowListGodsAndLastListContainer getWorkflowGodsAndListContainer(String utfPayload);
	
}
