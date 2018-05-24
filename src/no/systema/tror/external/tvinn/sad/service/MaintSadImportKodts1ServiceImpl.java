/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.mapper.jsonjackson.dbtable.MaintSadImportKodts1Mapper;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadImportKodts1Container;

/**
 * 
 * @author oscardelatorre
 * @date May 20, 2016
 * 
 * 
 */
public class MaintSadImportKodts1ServiceImpl implements MaintSadImportKodts1Service {
	/**
	 * 
	 */
	public JsonMaintSadImportKodts1Container getList(String utfPayload) {
		JsonMaintSadImportKodts1Container container = null;
		try{
			MaintSadImportKodts1Mapper mapper = new MaintSadImportKodts1Mapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 */
	public JsonMaintSadImportKodts1Container doUpdate(String utfPayload) {
		JsonMaintSadImportKodts1Container container = null;
		try{
			MaintSadImportKodts1Mapper mapper = new MaintSadImportKodts1Mapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
