/**
 * 
 */
package no.systema.tror.external.transportdisp.model.jsonjackson;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Sep 15, 2015
 *
 */
public class JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	                  
	private String avd = null;
	public void setAvd(String value) {  this.avd = value; }
	public String getAvd() { return this.avd;}
	
	private String opd = null;
	public void setOpd(String value) {  this.opd = value; }
	public String getOpd() { return this.opd;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonTransportDispWorkflowSpecificOrderArchivedDocsRecord> getdoc;
	public void setGetdoc(Collection<JsonTransportDispWorkflowSpecificOrderArchivedDocsRecord> value){ this.getdoc = value; }
	public Collection<JsonTransportDispWorkflowSpecificOrderArchivedDocsRecord> getGetdoc(){ return getdoc; }
	
	
}
