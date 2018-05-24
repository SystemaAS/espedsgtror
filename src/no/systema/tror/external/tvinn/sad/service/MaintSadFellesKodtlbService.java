/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadFellesKodtlbContainer;

/**
 * 
 * @author oscardelatorre
 * @date Okt 21, 2016
 * 
 *
 */
public interface MaintSadFellesKodtlbService {
	public JsonMaintSadFellesKodtlbContainer getList(String utfPayload);
	public JsonMaintSadFellesKodtlbContainer doUpdate(String utfPayload);
	
}
