/**
 * 
 */
package no.systema.tror.service.flyexport;

import no.systema.tror.model.jsonjackson.order.invoice.JsonTrorOrderFlyExportInvoiceContainer;
//import no.systema.tror.model.jsonjackson.order.invoice.JsonTrorOrderInvoiceReadyMarkContainer;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderContainer;
import no.systema.tror.model.jsonjackson.JsonTrorOrderHeaderDummyContainer;


/**
 * 
 * @author oscardelatorre
 * @date Jan 2018
 * 
 *
 */
public interface TrorMainOrderHeaderFlyexportService {
	public JsonTrorOrderHeaderContainer getOrderHeaderContainer(String utfPayload);
	public JsonTrorOrderHeaderDummyContainer getOrderHeaderDummyContainer(String utfPayload);
	public JsonTrorOrderFlyExportInvoiceContainer getOrderInvoiceContainer(String utfPayload);
	public JsonTrorOrderHeaderContainer getOrderHeaderContainerStatusUpdate(String utfPayload);
	//public JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer getOrderInvoiceReadyMarkContainer(String utfPayload);
	

}
