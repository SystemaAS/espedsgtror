package no.systema.tror.util.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import no.systema.jservices.common.dao.DokufDao;
import no.systema.jservices.common.dao.KodtfsDao;
import no.systema.jservices.common.dao.TrackfDao;
import no.systema.jservices.common.json.JsonDtoContainer;
import no.systema.jservices.common.json.JsonReader;
import no.systema.main.model.SystemaWebUser;
import no.systema.main.service.UrlCgiProxyService;
import no.systema.main.util.JsonDebugger;
import no.systema.main.util.StringManager;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintNctsTrkodfContainer;
import no.systema.tror.external.tvinn.sad.model.jsonjackson.dbtable.JsonMaintNctsTrkodfRecord;
import no.systema.tror.external.tvinn.sad.service.MaintNctsExportTrkodfService;
import no.systema.tror.external.tvinn.sad.url.store.TvinnNctsMaintenanceExportUrlDataStore;
import no.systema.tror.mapper.url.request.UrlRequestParameterMapper;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderRecord;
import no.systema.tror.url.store.TrorUrlDataStore;
import no.systema.tror.util.TrorConstants;

public class AWBManager {
	
	private static Logger logger = Logger.getLogger(AWBManager.class.getName());
	private StringManager strMgr = new StringManager();
	
	/**
	 * awb-nr (always 11 characters long = prefix(3), suffix(8);
	 * 
	 * Gets the 3-characters awb-prefix
	 * @param awb
	 * @return
	 */
	public Integer getAwbPrefix (String awb){
		Integer retval = 0;
		
		if(strMgr.isNotNull(awb)){
			//check length (the airline prefix can be between 1-999 therefore the triple check in length
			if(awb.length()==11){
				String prefix = awb.substring(0, awb.length()-8);
				retval = Integer.valueOf(prefix);
			}
		}
		return retval;
	}
	/**
	 * awb-nr (always 11 characters long = prefix(3), suffix(8);
	 * 
	 * Gets the 8-characters awb-suffix
	 * @param awb
	 * @return
	 */
	public Integer getAwbSuffix (String awb){
		Integer retval = 0;
		
		if(strMgr.isNotNull(awb)){
			//check length (the airline prefix can be between 1-999 therefore the triple check in length
			if(awb.length()==11){
				String suffix = awb.substring(awb.length()-8, awb.length());
				retval = Integer.valueOf(suffix);
			}
		}
		return retval;
	}
	
}
