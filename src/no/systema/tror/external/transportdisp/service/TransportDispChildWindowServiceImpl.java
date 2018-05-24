/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import no.systema.main.model.jsonjackson.general.postalcodes.JsonPostalCodesContainer;

import java.io.PrintWriter;
import java.io.StringWriter;

import no.systema.main.mapper.jsonjackson.general.PostalCodesMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispChildWindowMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificOrderFrisokveiMapper;
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
public class TransportDispChildWindowServiceImpl implements TransportDispChildWindowService {

	public JsonTransportDispAvdContainer getAvdContainer(String utfPayload) {
		JsonTransportDispAvdContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getAvdContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

	public JsonTransportDispBilCodeContainer getBilCodeContainer(String utfPayload) {
		JsonTransportDispBilCodeContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getBilCodeContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
	public JsonTransportDispBilNrContainer getBilNrContainer(String utfPayload) {
		JsonTransportDispBilNrContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getBilNrContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
	public JsonTransportDispTranspCarrierContainer getTranspCarrierContainer(String utfPayload) {
		JsonTransportDispTranspCarrierContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getTranspCarrierContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
	public JsonTransportDispDriverContainer getDriverContainer(String utfPayload) {
		JsonTransportDispDriverContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getDriverContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * 
	 */
	public JsonPostalCodesContainer getPostalCodesContainer(String utfPayload){
		JsonPostalCodesContainer container = null;
		try{
			PostalCodesMapper mapper = new PostalCodesMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * Customer
	 */
	public JsonTransportDispCustomerContainer getCustomerContainer(String utfPayload){
		JsonTransportDispCustomerContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getCustomerContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Load/Unload places
	 * 
	 */
	public JsonTransportDispLoadUnloadPlacesContainer getLoadUnloadPlacesContainer(String utfPayload){
		JsonTransportDispLoadUnloadPlacesContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getLoadUnloadPlacesContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * File upload validation
	 * 
	 */
	public JsonTransportDispFileUploadValidationContainer getFileUploadValidationContainer(String utfPayload){
		JsonTransportDispFileUploadValidationContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getFileUploadValidationContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Dangerous goods
	 */
	public JsonTransportDispDangerousGoodsContainer getDangerousGoodsContainer(String utfPayload){
		JsonTransportDispDangerousGoodsContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getDangerousGoodsContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Packing codes
	 * 
	 */
	public JsonTransportDispPackingCodesContainer getPackingCodesContainer(String utfPayload){
		JsonTransportDispPackingCodesContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getPackingCodesContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Tollsted codes
	 */
	public JsonTransportDispTollstedCodesContainer getTollstedCodesContainer(String utfPayload){
		JsonTransportDispTollstedCodesContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getTollstedCodesContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	/**
	 * Supplier reg.
	 */
	public JsonTransportDispSupplierContainer getSupplierContainer(String utfPayload){
		JsonTransportDispSupplierContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getSupplierContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Gebyrkoder
	 */
	public JsonTransportDispGebyrCodeContainer getGebyrCodeContainer(String utfPayload){
		JsonTransportDispGebyrCodeContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getGebyrContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Frie søkeveier
	 */
	public JsonTransportDispFrisokveiCodesContainer getFrisokveiCodesContainer(String utfPayload){
		JsonTransportDispFrisokveiCodesContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getFrisokveiContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
		
	}
	/**
	 * Frie søkeveier Doks
	 */
	public JsonTransportDispFrisokveiDocCodesContainer getFrisokveiDocCodesContainer(String utfPayload){
		JsonTransportDispFrisokveiDocCodesContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getFrisokveiDocContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
		
	}
	
	/**
	 * 
	 */
	public JsonTransportDispSendSmsContainer getSendSmsContainer(String utfPayload){
		JsonTransportDispSendSmsContainer container = null;
		try{
			JsonTransportDispChildWindowMapper mapper = new JsonTransportDispChildWindowMapper();
			container = mapper.getSendSmsContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		return container;
		
	}
	
	/**
	 * 
	 */
	public JsonTransportDispFrisokveiGiltighetsListContainer getOrderFrisokveiContainerGiltighetsLista(String utfPayload){
		JsonTransportDispFrisokveiGiltighetsListContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderFrisokveiMapper mapper = new JsonTransportDispWorkflowSpecificOrderFrisokveiMapper();
			container = mapper.getContainerGiltighetsLista(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
		}
		
		return container;
	}
	
	
}
