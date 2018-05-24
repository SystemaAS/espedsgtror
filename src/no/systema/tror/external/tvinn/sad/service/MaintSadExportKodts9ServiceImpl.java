/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.mapper.jsonjackson.dbtable.MaintSadExportKodts9Mapper;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadExportKodts9Container;

/**
 * 
 * @author oscardelatorre
 * @date May 20, 2016
 * 
 * 
 */
public class MaintSadExportKodts9ServiceImpl implements MaintSadExportKodts9Service {
	/**
	 * 
	 */
	public JsonMaintSadExportKodts9Container getList(String utfPayload) {
		JsonMaintSadExportKodts9Container container = null;
		try{
			MaintSadExportKodts9Mapper mapper = new MaintSadExportKodts9Mapper();
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
	public JsonMaintSadExportKodts9Container doUpdate(String utfPayload) {
		JsonMaintSadExportKodts9Container container = null;
		try{
			MaintSadExportKodts9Mapper mapper = new MaintSadExportKodts9Mapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
