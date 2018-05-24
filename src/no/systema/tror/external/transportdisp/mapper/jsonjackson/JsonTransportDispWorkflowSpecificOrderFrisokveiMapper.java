/**
 * 
 */
package no.systema.tror.external.transportdisp.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiGiltighetsListContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiGiltighetsListRecord;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFrisokveiContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFrisokveiRecord;

/**
 * @author oscardelatorre
 * @date Jun 09, 2017
 * 
 */
public class JsonTransportDispWorkflowSpecificOrderFrisokveiMapper extends ObjectMapperAbstractGrandFather{
	private static final Logger logger = Logger.getLogger(JsonTransportDispWorkflowSpecificOrderFrisokveiMapper.class.getName());
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispWorkflowSpecificOrderFrisokveiContainer getContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderFrisokveiContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderFrisokveiContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		if(container!=null && container.getAwblinelist()!=null){
			for (JsonTransportDispWorkflowSpecificOrderFrisokveiRecord record : container.getAwblinelist()){
				//DEBUG
			}
		}
		return container;
	}
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispFrisokveiGiltighetsListContainer getContainerGiltighetsLista(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonTransportDispFrisokveiGiltighetsListContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispFrisokveiGiltighetsListContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		if(container!=null && container.getGyldigliste()!=null){
			for (JsonTransportDispFrisokveiGiltighetsListRecord record : container.getGyldigliste()){
				//DEBUG
			}
		}
		return container;
	}
	
}
