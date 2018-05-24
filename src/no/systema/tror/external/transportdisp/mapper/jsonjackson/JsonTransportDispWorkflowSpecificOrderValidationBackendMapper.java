/**
 * 
 */
package no.systema.tror.external.transportdisp.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;

import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderValidationBackendContainer;
import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;

/**
 * @author oscardelatorre
 * @date Aug 21, 2015
 * 
 */
public class JsonTransportDispWorkflowSpecificOrderValidationBackendMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(JsonTransportDispWorkflowSpecificOrderValidationBackendMapper.class.getName());
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispWorkflowSpecificOrderValidationBackendContainer getContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderValidationBackendContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderValidationBackendContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		for (JsonTransportDispWorkflowSpecificOrderRecord record : container.getOrdervalidate()){
			//DEBUG
		}
		return container;
	}
	
	
}
