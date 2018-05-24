/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadImportKodts1Container;

/**
 * 
 * @author oscardelatorre
 * @date May 20, 2016
 * 
 *
 */
public interface MaintSadImportKodts1Service {
	public JsonMaintSadImportKodts1Container getList(String utfPayload);
	public JsonMaintSadImportKodts1Container doUpdate(String utfPayload);
	
}
