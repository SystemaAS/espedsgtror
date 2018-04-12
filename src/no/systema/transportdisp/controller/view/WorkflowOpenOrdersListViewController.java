package no.systema.transportdisp.controller.view;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//application imports
import no.systema.main.model.SystemaWebUser;
import no.systema.main.util.AppConstants;
import no.systema.transportdisp.model.jsonjackson.workflow.shippinglists.JsonTransportDispWorkflowShippingPlanningCurrentOrdersListRecord;
import no.systema.transportdisp.util.TransportDispConstants;


/**
 * Working controller for the child-list non JSP-pages
 * The controller will manage all export functionality to different view formats such as:
 * 
 * (1) Excel, PDF, other are implemented here
 * 
 * 
 * 
 * @author oscardelatorre
 * @date Maj 4, 2015
 * 
 */

@Controller
public class WorkflowOpenOrdersListViewController {
	private static final Logger logger = Logger.getLogger(WorkflowOpenOrdersListViewController.class.getName());
	private ModelAndView loginView = new ModelAndView("redirect:logout.do");
	
	/**
	 * 
	 * @param user
	 * @param result
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value="transportDispWorkflowOpenOrdersListExcelView.do", method={RequestMethod.GET})
	public ModelAndView getTripListExcelView(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		//this name is the one configured in /WEB-INF/views.xml
		final String EXCEL_VIEW = "transportDispWorkflowOpenOrdersListExcelView";
		
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		List<JsonTransportDispWorkflowShippingPlanningCurrentOrdersListRecord> list = null;
		
        //--> with browser dialogbox: response.setHeader ("Content-disposition", "attachment; filename=\"edifactPayload.txt\"");
        response.setHeader ("Content-disposition", "filename=\"" + EXCEL_VIEW + ".xls\"");

		if(appUser==null){
			return this.loginView;
		}else{
			list = (List)session.getAttribute(session.getId() + TransportDispConstants.SESSION_LIST);
		}	
		
		return new ModelAndView(EXCEL_VIEW, TransportDispConstants.DOMAIN_LIST_OPEN_ORDERS, list);
	}
}

