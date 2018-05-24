/**
 * 
 */
package no.systema.tror.external.tvinn.sad.service;

import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintNctsTransitKodeTypeContainer;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintNctsTrkodfContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Okt 17, 2016
 * 
 *
 */
public interface MaintNctsExportTrkodfService {
	public JsonMaintNctsTrkodfContainer getList(String utfPayload);
	public JsonMaintNctsTrkodfContainer doUpdate(String utfPayload);
	
	/**
	 * Retrieving TransitKoder for dropdown
	 * 
	 * @param utfPayload
	 * @return
	 */
	public JsonMaintNctsTransitKodeTypeContainer getTransitKoderList(String utfPayload);

}
