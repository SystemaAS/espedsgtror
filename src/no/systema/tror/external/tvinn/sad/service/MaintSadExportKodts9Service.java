/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintSadExportKodts9Container;

/**
 * 
 * @author oscardelatorre
 * @date May 20, 2016
 * 
 *
 */
public interface MaintSadExportKodts9Service {
	public JsonMaintSadExportKodts9Container getList(String utfPayload);
	public JsonMaintSadExportKodts9Container doUpdate(String utfPayload);
	
}
