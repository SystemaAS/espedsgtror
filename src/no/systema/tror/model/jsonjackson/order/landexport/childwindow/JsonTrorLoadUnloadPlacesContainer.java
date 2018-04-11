/**
 * 
 */
package no.systema.tror.model.jsonjackson.order.landexport.childwindow;

import java.util.Collection;
/**
 * @author oscardelatorre
 * @date Feb 03, 2017
 */
public class JsonTrorLoadUnloadPlacesContainer {
	
	private String user = null;
	public void setUser(String value){ this.user = value;}
	public String getUser(){ return this.user; }
	
	
	private String soknvn = null;
	public void setSoknvn(String value){ this.soknvn = value;}
	public String getSoknvn(){ return this.soknvn; }
	
	private String sokkod = null;
	public void setSokkod(String value){ this.sokkod = value;}
	public String getSokkod(){ return this.sokkod; }
	
	private String caller = null;
	public void setCaller(String value){ this.caller = value;}
	public String getCaller(){ return this.caller; }
	
	private String errMsg = null;
	public void setErrMsg(String value){ this.errMsg = value;}
	public String getErrMsg(){ return this.errMsg; }
	
	private Collection<JsonTrorLoadUnloadPlacesRecord> inqlosslass = null;
	public void setInqlosslass(Collection<JsonTrorLoadUnloadPlacesRecord> value){ this.inqlosslass = value;}
	public Collection<JsonTrorLoadUnloadPlacesRecord> getInqlosslass(){ return this.inqlosslass; }
	
}
