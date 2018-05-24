/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import no.systema.main.model.jsonjackson.general.postalcodes.JsonPostalCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispAvdContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispBilCodeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispBilNrContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCustomerContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispDangerousGoodsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispDriverContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFileUploadValidationContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiDocCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiGiltighetsListContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispGebyrCodeContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispLoadUnloadPlacesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispPackingCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSendSmsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispSupplierContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispTollstedCodesContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispTranspCarrierContainer;




/**
 * 
 * @author oscardelatorre
 * @date Apr 1, 2015
 * 
 *
 */
public interface TransportDispChildWindowService {
	public JsonTransportDispAvdContainer getAvdContainer(String utfPayload);
	public JsonTransportDispBilCodeContainer getBilCodeContainer(String utfPayload);
	public JsonTransportDispBilNrContainer getBilNrContainer(String utfPayload);
	public JsonTransportDispDriverContainer getDriverContainer(String utfPayload);
	public JsonTransportDispTranspCarrierContainer getTranspCarrierContainer(String utfPayload);
	public JsonPostalCodesContainer getPostalCodesContainer(String utfPayload);
	public JsonTransportDispCustomerContainer getCustomerContainer(String utfPayload);
	public JsonTransportDispLoadUnloadPlacesContainer getLoadUnloadPlacesContainer(String utfPayload);
	public JsonTransportDispFileUploadValidationContainer getFileUploadValidationContainer(String utfPayload);
	public JsonTransportDispDangerousGoodsContainer getDangerousGoodsContainer(String utfPayload);
	public JsonTransportDispPackingCodesContainer getPackingCodesContainer(String utfPayload);
	public JsonTransportDispTollstedCodesContainer getTollstedCodesContainer(String utfPayload);
	public JsonTransportDispSupplierContainer getSupplierContainer(String utfPayload);
	public JsonTransportDispGebyrCodeContainer getGebyrCodeContainer(String utfPayload);
	public JsonTransportDispFrisokveiCodesContainer getFrisokveiCodesContainer(String utfPayload);
	public JsonTransportDispFrisokveiDocCodesContainer getFrisokveiDocCodesContainer(String utfPayload);
	public JsonTransportDispSendSmsContainer getSendSmsContainer(String utfPayload);
	public JsonTransportDispFrisokveiGiltighetsListContainer getOrderFrisokveiContainerGiltighetsLista(String utfPayload);
	
	
}
