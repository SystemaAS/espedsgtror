package no.systema.tror.model.jsonjackson;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dto to Tradevision (flyeksport - flyfraktsbrev) FFR00F - main parent child for tradevision booking
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class Ffr00fDto {
	
	private String f00rec; 		//9,0 PAKKET - Rec.no/Trans ID.  
	private String f0211; 		//3,0 PAKKET - Airline prefix
	private String f0213; 		//8,0 PAKKET - AWB serial no
	private String f0221;  		//3 VARCHAR - Origin airport
	
	private String f0222;  		//3 VARCHAR - Dest. airport
	private String f0232;  		//1 VARCHAR - Ship. desc. code
	private String f0233;  		//4,0 PAKKET - No. of Pieces
	private String f0234;  		//1 VARCHAR - Weight code
	private String f0235;  		//8,1 PAKKET - Weight
	private String f0241;  		//2 VARCHAR - Volume code
	private String f0242; 		//11,2 PAKKET - Volume amount
	private String f0251;  		//2 VARCHAR - Density ind.
	
	private String f0252;  		//2,0 PAKKET - Density group
	private String f0262;  		//4,0 PAKKET - Tot. no. of pieces
	private String f0272;  		//15 VARCHAR - Manif.desc.of goods 
	
	private String f0282;  		//3 VARCHAR - Spes. handl. code-1
	private String f0283;  		//3 VARCHAR - Spes. handl. code-2
	
	private String f043;  		//2,0 PAKKET - No. of ULDs
	private String f0522;  		//65 VARCHAR - Spes. service req.1
	private String f0532;  		//65 VARCHAR - Spes. service req.2
	private String f0622;  		//65 VARCHAR - Other service inf.1 
	private String f0632;  		//65 VARCHAR - Other service inf.2
	
	private String f0731;  		//3 VARCHAR - Airport
	private String f0732;  		//3 VARCHAR - Office func. design.
	private String f0733;  		//2 VARCHAR - Company designator
	private String f0751;  		//15 VARCHAR - Booking File ref.
	private String f0762;  		//3 VARCHAR - Part ID
	private String f0764;  		//17 VARCHAR - Part code
	private String f0766;  		//3 VARCHAR - Airport
	
	private String f093;  		//1 VARCHAR - Service Code
	private String f0951;  		//3 VARCHAR - Rate class code 
	private String f0953a;  	//7,0 PAKKET - Commodity item no
	private String f0953b;  	//2 VARCHAR - ULD rate class type (Unit-Load-Device)
	
	private String f0953c;  	//1 VARCHAR - Rate class code
	private String f0953d;  	//3,0 PAKKET - Class rate perc
	private String f1022;  		//14 VARCHAR - Shipper acc. no.
	private String f1042;  		//35 VARCHAR - Shipper name
	
	private String f1052;  		//35 VARCHAR - Shipper street adr
	private String f1062;  		//17 VARCHAR - Shipper place
	private String f1064;  		//9 VARCHAR - Shipper state
	private String f1072;  		//2 VARCHAR - Shipper country
	private String f1074;  		//9 VARCHAR - Shipper postal code
	
	private String f1122;  		//14 VARCHAR - Shipper acc. no.
	private String f1142;  		//35 VARCHAR - Shipper name
	private String f1152;  		//35 VARCHAR - Shipper street adr.
	private String f1162;  		//17 VARCHAR - Shipper place
	private String f1164;  		//9 VARCHAR - Shipper state
	private String f1172;  		//2 VARCHAR - Shipper country
	private String f1174;  		//9 VARCHAR - Shipper postal code
	
	private String f1222;  		//14 VARCHAR - Acc.number
	private String f1224;  		//7,0 PAKKET - IATA Agent code 
	private String f1226;  		//4,0 PAKKET - Agent CASS addr
	private String f1228;  		//3 VARCHAR - Part id.
	
	private String f1242;  		//35 VARCHAR - Customer name
	private String f1252;  		//17 VARCHAR - Customer place
	
	private String f133;  		//14 VARCHAR - Ref.no
	private String f135;  		//12 VARCHAR - Suppl.Shp.Inf.
	private String f137;  		//12 VARCHAR - Suppl.Shp.Inf.
	
	
}
