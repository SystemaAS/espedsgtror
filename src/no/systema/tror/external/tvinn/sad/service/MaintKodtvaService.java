/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintKodtvaContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jun 7, 2016
 * 
 *
 */
public interface MaintKodtvaService {
	public JsonMaintKodtvaContainer getList(String utfPayload);
	public JsonMaintKodtvaContainer doUpdate(String utfPayload);
	
}
