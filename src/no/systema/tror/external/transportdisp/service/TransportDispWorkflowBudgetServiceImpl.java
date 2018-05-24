/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowBudgetMapper;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificBudgetContainer;

/**
 * 
 * @author oscardelatorre
 * @date Oct 12, 2015
 * 
 * 
 */
public class TransportDispWorkflowBudgetServiceImpl implements TransportDispWorkflowBudgetService {

	public JsonTransportDispWorkflowSpecificBudgetContainer getContainer(String utfPayload) {
		JsonTransportDispWorkflowSpecificBudgetContainer container = null;
		try{
			JsonTransportDispWorkflowBudgetMapper mapper = new JsonTransportDispWorkflowBudgetMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
