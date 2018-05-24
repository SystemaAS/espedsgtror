/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadImportKodts4Container;

/**
 * 
 * @author oscardelatorre
 * @date May 20, 2016
 * 
 *
 */
public interface MaintSadImportKodts4Service {
	public JsonMaintSadImportKodts4Container getList(String utfPayload);
	public JsonMaintSadImportKodts4Container doUpdate(String utfPayload);
	
}
