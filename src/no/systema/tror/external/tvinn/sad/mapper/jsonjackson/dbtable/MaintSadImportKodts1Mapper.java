/**
 * 
 */
package no.systema.tror.external.tvinn.sad.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadImportKodts1Container;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadImportKodts1Record;

//
import java.util.*;

/**
 * @author oscardelatorre
 * @date May 20, 2016
 * 
 */
public class MaintSadImportKodts1Mapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintSadImportKodts1Mapper.class.getName());
	
	public JsonMaintSadImportKodts1Container getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintSadImportKodts1Container container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintSadImportKodts1Container.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintSadImportKodts1Record> list = container.getList();
		for(JsonMaintSadImportKodts1Record record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
