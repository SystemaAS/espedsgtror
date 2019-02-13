/**
 * 
 */
package no.systema.tror.model.jsonjackson.codes;

import java.util.Collection;


/**
 * General Code Container for Tror flyeksport rate codes
 * 
 * 
 *
 * @author oscardelatorre
 * @date Feb, 2019
 *
 */
public class JsonTrorRateClassCodeContainer {
	private String user = null;
	public void setUser(String value){ this.user = value;}
	public String getUser(){ return this.user; }
	
	private String errMsg = null;
	public void setErrMsg(String value){ this.errMsg = value;}
	public String getErrMsg(){ return this.errMsg; }
	
	private Collection<JsonTrorRateClassCodeRecord> dtoList = null;
	public void setDtoList(Collection<JsonTrorRateClassCodeRecord> value){ this.dtoList = value;}
	public Collection<JsonTrorRateClassCodeRecord> getDtoList(){ return this.dtoList; }
	
}
