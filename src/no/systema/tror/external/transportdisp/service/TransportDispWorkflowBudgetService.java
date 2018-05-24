/**
 * 
 */
package no.systema.tror.external.transportdisp.service;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificBudgetContainer;
 

/**
 * 
 * @author oscardelatorre
 * @date Oct 12, 2015
 * 
 *
 */
public interface TransportDispWorkflowBudgetService {
	public JsonTransportDispWorkflowSpecificBudgetContainer getContainer(String utfPayload);
	
}
