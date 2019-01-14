/**
 * 
 */
package no.systema.tror.service.flyexport;

import no.systema.tror.mapper.jsonjackson.JsonTrorOrderHeaderMapperFlyexport;
import no.systema.tror.mapper.jsonjackson.order.invoice.JsonTrorOrderFlyExportInvoiceMapper;
import no.systema.tror.model.jsonjackson.order.invoice.JsonTrorOrderFlyExportInvoiceContainer;
import no.systema.tror.service.flyexport.TrorMainOrderHeaderFlyexportService;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderContainer;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderDummyContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jan 2018
 * 
 * 
 */
public class TrorMainOrderHeaderFlyexportServiceImpl implements TrorMainOrderHeaderFlyexportService {

	/**
	 * Gets default values from HEDUMMY/MEMBER (TABLE)
	 */
	public JsonTrorOrderHeaderDummyContainer getOrderHeaderDummyContainer(String utfPayload){
		JsonTrorOrderHeaderDummyContainer container = null;
		try{
			JsonTrorOrderHeaderMapperFlyexport mapper = new JsonTrorOrderHeaderMapperFlyexport();
			container = mapper.getDummyContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	/**
	 * 
	 */
	public JsonTrorOrderHeaderContainer getOrderHeaderContainer(String utfPayload) {
		JsonTrorOrderHeaderContainer container = null;
		try{
			JsonTrorOrderHeaderMapperFlyexport mapper = new JsonTrorOrderHeaderMapperFlyexport();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	/**
	 * 
	 */

	public JsonTrorOrderFlyExportInvoiceContainer getOrderInvoiceContainer(String utfPayload) {
		JsonTrorOrderFlyExportInvoiceContainer container = null;
		try{
			JsonTrorOrderFlyExportInvoiceMapper mapper = new JsonTrorOrderFlyExportInvoiceMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	/**
	 * 
	 */
	public JsonTrorOrderHeaderContainer getOrderHeaderContainerStatusUpdate(String utfPayload) {
		JsonTrorOrderHeaderContainer container = null;
		try{
			JsonTrorOrderHeaderMapperFlyexport mapper = new JsonTrorOrderHeaderMapperFlyexport();
			container = mapper.getContainerStatusUpdate(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}

}
