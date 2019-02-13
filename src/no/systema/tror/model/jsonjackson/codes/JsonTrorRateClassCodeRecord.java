/**
 * 
 */
package no.systema.tror.model.jsonjackson.codes;
import lombok.Data;
/**
 * @author oscardelatorre
 * @date Feb, 2019
 * 
 */
@Data
public class JsonTrorRateClassCodeRecord  {
	
	private String rast; //1 VARCHAR - Status  
	private String raracd; 		//1 VARCHAR - Rate Class Code
	private String rabesk; 		//30  VARCHAR - Rate description	
	
	

}
