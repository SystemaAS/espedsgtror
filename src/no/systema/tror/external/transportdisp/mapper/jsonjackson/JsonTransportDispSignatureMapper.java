/**
 * 
 */
package no.systema.tror.external.transportdisp.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSignatureContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSignatureRecord;

import java.util.*;

/**
 * @author oscardelatorre
 * @date Jun 10, 2015
 * 
 * 
 */
public class JsonTransportDispSignatureMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(JsonTransportDispSignatureMapper.class.getName());
	
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTransportDispSignatureContainer getContainer(String utfPayload) throws Exception{
		JsonTransportDispSignatureContainer container = null;
		if(utfPayload!=null){
			//At this point we now have an UTF-8 payload
			container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonTransportDispSignatureContainer.class); 
			//logger.info(mapper.writeValueAsString(topicListContainer));
			//logger.info("Mapping Code object from JSON payload...");
			//logger.info("[JSON-String payload status=OK]  " + taricCodeContainer.getUser());
			
			//DEBUG
			Collection<JsonTransportDispSignatureRecord> fields = container.getSignaturer();
			for(JsonTransportDispSignatureRecord record : fields){
				
			}
		}
			
		return container;
	}
	
}
