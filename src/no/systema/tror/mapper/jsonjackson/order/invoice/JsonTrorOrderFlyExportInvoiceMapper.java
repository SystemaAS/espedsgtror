/**
 * 
 */
package no.systema.tror.mapper.jsonjackson.order.invoice;

//jackson library
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper; 
//application library
import no.systema.tror.model.jsonjackson.order.invoice.JsonTrorOrderFlyExportInvoiceContainer;
import no.systema.tror.model.jsonjackson.order.invoice.JsonTrorOrderFlyExportInvoiceRecord;
//import no.systema.tror.model.jsonjackson.order.invoice.JsonTrorOrderLandImportInvoiceReadyMarkContainer;

/**
 * @author oscardelatorre
 * @date Jan 2019
 * 
 */
public class JsonTrorOrderFlyExportInvoiceMapper {
	private static final Logger logger = Logger.getLogger(JsonTrorOrderFlyExportInvoiceMapper.class.getName());
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	public JsonTrorOrderFlyExportInvoiceContainer getContainer(String utfPayload) throws Exception{
		ObjectMapper mapper = new ObjectMapper();  
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		//At this point we now have an UTF-8 payload
		JsonTrorOrderFlyExportInvoiceContainer container = mapper.readValue(utfPayload.getBytes(), JsonTrorOrderFlyExportInvoiceContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		if(container!=null && container.getInvoiceLineUpdate()!=null){
			for (JsonTrorOrderFlyExportInvoiceRecord record : container.getInvoiceLineUpdate()){
				//DEBUG
			}
		}else if(container!=null && container.getInvoiceLines()!=null){
			for (JsonTrorOrderFlyExportInvoiceRecord record : container.getInvoiceLines()){
				//DEBUG
			}
		}
		return container;
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 * @throws Exception
	 */
	/*
	public JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer getReadyMarkContainer(String utfPayload) throws Exception{
		ObjectMapper mapper = new ObjectMapper();  
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		//At this point we now have an UTF-8 payload
		JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer container = mapper.readValue(utfPayload.getBytes(), JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		
		return container;
	}
	*/
}
