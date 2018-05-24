/**
 * 
 */
package no.systema.tror.external.transportdisp.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificOrderFrisokveiMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificOrderInvoiceMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificOrderLoggingMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificOrderMapper;
import no.systema.tror.external.transportdisp.mapper.jsonjackson.JsonTransportDispWorkflowSpecificOrderValidationBackendMapper;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispCustomerDeliveryAddressContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispFrisokveiGiltighetsListContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFraktbrevContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderFrisokveiContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderInvoiceContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderLoggingContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderMessageNoteContainer;
import no.systema.tror.external.transportdisp.model.jsonjackson.JsonTransportDispWorkflowSpecificOrderValidationBackendContainer;

/**
 * 
 * @author oscardelatorre
 * @date Mar 31, 2015
 * 
 * 
 */
public class TransportDispWorkflowSpecificOrderServiceImpl implements TransportDispWorkflowSpecificOrderService {
	private static final Logger logger = Logger.getLogger(JsonTransportDispWorkflowSpecificOrderMapper.class.getName());
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificOrderContainer getContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderMapper mapper = new JsonTransportDispWorkflowSpecificOrderMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		return container;
	}
	
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificOrderMessageNoteContainer getMessageNoteContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderMessageNoteContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderMapper mapper = new JsonTransportDispWorkflowSpecificOrderMapper();
			container = mapper.getMessageNoteContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
		
	}
	
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificOrderFraktbrevContainer getFraktbrevContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderFraktbrevContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderMapper mapper = new JsonTransportDispWorkflowSpecificOrderMapper();
			container = mapper.getFraktbrevContainer(utfPayload);
			
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}
	/**
	 *
	 */
	public JsonTransportDispCustomerDeliveryAddressContainer getDeliveryAddressContainer(String utfPayload){
		JsonTransportDispCustomerDeliveryAddressContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderMapper mapper = new JsonTransportDispWorkflowSpecificOrderMapper();
			container = mapper.getDeliveryAddressContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}
	
	/**
	 * Invoice
	 */
	public JsonTransportDispWorkflowSpecificOrderInvoiceContainer getOrderInvoiceContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderInvoiceContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderInvoiceMapper mapper = new JsonTransportDispWorkflowSpecificOrderInvoiceMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer getOrderInvoiceReadyMarkContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderInvoiceReadyMarkContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderInvoiceMapper mapper = new JsonTransportDispWorkflowSpecificOrderInvoiceMapper();
			container = mapper.getReadyMarkContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		return container;
	}
	

	/**
	 * Validation Back-end
	 */
	public JsonTransportDispWorkflowSpecificOrderValidationBackendContainer getOrderValidationBackendContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderValidationBackendContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderValidationBackendMapper mapper = new JsonTransportDispWorkflowSpecificOrderValidationBackendMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}

	/**
	 * renders fraktbrev PDF
	 */
	public JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer getOrderFraktbrevPdfContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderFraktbrevPdfContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderMapper mapper = new JsonTransportDispWorkflowSpecificOrderMapper();
			container = mapper.getFraktbrevPdfContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
		
	}
	/**
	 * Gets a list of uploaded docs
	 */
	public JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer getOrderArchivedDocsContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderArchivedDocsContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderMapper mapper = new JsonTransportDispWorkflowSpecificOrderMapper();
			container = mapper.getArchivedDocsContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}

	/**
	 * Track and trace logging
	 */
	public JsonTransportDispWorkflowSpecificOrderLoggingContainer getOrderLoggingContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderLoggingContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderLoggingMapper mapper = new JsonTransportDispWorkflowSpecificOrderLoggingMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}
	
	/**
	 * 
	 */
	public JsonTransportDispWorkflowSpecificOrderFrisokveiContainer getOrderFrisokveiContainer(String utfPayload){
		JsonTransportDispWorkflowSpecificOrderFrisokveiContainer container = null;
		try{
			JsonTransportDispWorkflowSpecificOrderFrisokveiMapper mapper = new JsonTransportDispWorkflowSpecificOrderFrisokveiMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info(errors);
		}
		
		return container;
	}
	
	
}
