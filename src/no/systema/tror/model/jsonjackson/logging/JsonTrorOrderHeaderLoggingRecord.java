/**
 * 
 */
package no.systema.tror.model.jsonjackson.logging;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author oscardelatorre
 * @date Sep 18, 2017
 *
 */
public class JsonTrorOrderHeaderLoggingRecord extends JsonAbstractGrandFatherRecord {
	
	private String mavd = null;
	public void setMavd(String value) {  this.mavd = value; }
	public String getMavd() {return this.mavd;}
	
	private String mtdn = null;
	public void setMtdn(String value) {  this.mtdn = value; }
	public String getMtdn() {return this.mtdn;}
	
	private String msn = null;
	public void setMsn(String value) {  this.msn = value; }
	public String getMsn() {return this.msn;}
	
	private String mmn = null;
	public void setMmn(String value) {  this.mmn = value; }
	public String getMmn() {return this.mmn;}
	
	private String msr = null;
	public void setMsr(String value) {  this.msr = value; }
	public String getMsr() {return this.msr;}
	
	private String m0004 = null;//Sender
	public void setM0004(String value) {  this.m0004 = value; }
	public String getM0004() {return this.m0004;}
	
	private String m0010 = null;//Receiver
	public void setM0010(String value) {  this.m0010 = value; }
	public String getM0010() {return this.m0010;}
	
	private String mven = null;
	public void setMven(String value) {  this.mven = value; }
	public String getMven() {return this.mven;}
	
	private String m0068 = null;
	public void setM0068 (String value) {  this.m0068 = value; }
	public String getM0068() {return this.m0068;}
	
	private String m0035 = null;
	public void setM0035(String value) {  this.m0035 = value; }
	public String getM0035() {return this.m0035;}
	
	private String m0065 = null;//CUSDEC eller CUSRES
	public void setM0065(String value) {  this.m0065 = value; }
	public String getM0065() {return this.m0065;}
	
	private String m0068a = null; //Dato
	public void setM0068a(String value) {  this.m0068a = value; }
	public String getM0068a() {return this.m0068a;}
	
	private String m0068b = null; //Sekv
	public void setM0068b(String value) {  this.m0068b = value; }
	public String getM0068b() {return this.m0068b;}
	
	private String m0068c = null; //Ver
	public void setM0068c(String value) {  this.m0068c = value; }
	public String getM0068c() {return this.m0068c;}
	
	private String m3039e = null; //Eksp
	public void setM3039e(String value) {  this.m3039e = value; }
	public String getM3039e() {return this.m3039e;}
	
	private String mst = null; //status
	public void setmMst(String value) {  this.mst = value; }
	public String getMst() {return this.mst;}
	
	private String m1225 = null;
	public void setM1225(String value) {  this.m1225 = value; }
	public String getM1225() {return this.m1225;}
	
	private String m1n07 = null; //DFU,DTK,etc
	public void setM1n07(String value) {  this.m1n07 = value; }
	public String getM1n07() {return this.m1n07;}
	
	private String mdt = null;//date
	public void setMdt(String value) {  this.mdt = value; }
	public String getMdt() {return this.mdt;}
	
	private String mtm = null;//time
	public void setMtm(String value) {  this.mtm = value; }
	public String getMtm() {return this.mtm;}
	
	private String wtxt = null;
	public void setWtxt(String value) {  this.wtxt = value; }
	public String getWtxt() {return this.wtxt;}
	
	private String wmore = null;
	public void setWmore(String value) {  this.wmore = value; }
	public String getWmore() {return this.wmore;}
	
	private String wurl = null;
	public void setWurl(String value) {  this.wurl = value; }
	public String getWurl() {return this.wurl;}
	
	
	/**
	 * Used for java reflection in other classes
	 * @return
	 * @throws Exception
	 */
	
	public List<Field> getFields() throws Exception{
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);
		
		return list;
	}

}
