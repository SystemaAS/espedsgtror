<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>

<!-- ======================= header =====================================-->
<jsp:include page="/WEB-INF/views/headerTrorChildWindows.jsp" />
<!-- =====================end header ====================================-->

	<%-- specific jQuery functions for this JSP (must reside under the resource map since this has been
	specified in servlet.xml as static <mvc:resources mapping="/resources/**" location="WEB-INF/resources/" order="1"/> --%>
	<SCRIPT type="text/javascript" src="resources/js/tror_mainorderflyimport_childwindow_airproducts.js?ver=${user.versionEspedsg}"></SCRIPT>
	
	<table width="90%" class="tableBorderWithRoundCorners3D_RoundOnlyOnBottom" cellspacing="0" border="0" cellpadding="0">
		<tr height="5"><td colspan="2"></td></tr>
		<tr>
			<td colspan="3" class="text14Bold">&nbsp;&nbsp;&nbsp;
				<img title="search" valign="bottom" src="resources/images/search.gif" width="24px" height="24px" border="0" alt="search">
				<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.title"/>
			</td>
		</tr>
		<tr height="20"><td colspan="2"></td></tr>
		<tr>
		<td valign="top">
			
				<form name="mainForm" id="mainForm" action="TODO_" method="post">
		
				<%-- ============================================  --%>
	          	<%-- Here we have the search  popup window --%>
	          	<%-- ============================================  --%>
          		<%-- this container table is necessary in order to separate the datatables element and the frame above, otherwise
			 	the cosmetic frame will not follow the whole datatable grid including the search field... --%>
				<table id="containerdatatableTable" cellspacing="2" align="left" width="100%">
				
					
					<tr class="text12" >
					<td class="ownScrollableSubWindowDynamicWidthHeight" width="90%" style="height:30em;">
					<%-- this is the datatables grid (content)--%>
					<table id="mainList" class="display compact cell-border" >
						<thead>
						<tr class="tableHeaderField" height="20">
							<th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.kode"/></th>   
		                    <th class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.name"/></th>
		                    <th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.counter"/></th>
		                    <th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.fsc"/></th>
		                    <th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.tdv"/></th>
		                    <th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.awbfe"/></th>
		                    <th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.sec"/></th>
		                    <th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.flyfraktbrev.childwindow.airproducts.label.war"/></th>
		                    
		                </tr> 
		                </thead>
		                
		                <tbody>
		                <c:forEach var="record" items="${model.mainList}" varStatus="counter">    
			               <tr class="text14" >
			               
			               <td width="2%" class="text14MediumBlue" style="cursor:pointer;" id="id_${record.kofmko}@name_${record.kofmnv}@counter_${counter.count}">
			               	 	${record.kofmko}
			               </td>
			               <td class="text14" >${record.kofmnv}</td>
			               <td width="5%" class="text14" >${record.kofmk2}</td>
			               <td width="5%" class="text14" >${record.kofmk3}</td>
			               <td width="5%" class="text14" >${record.kofmk4}</td>
			               <td width="5%" class="text14" >${record.kofmk5}</td>
			               <td width="5%" class="text14" >${record.kofmk6}</td>
			               <td width="5%" class="text14" >${record.kofmk7}</td> 
			                      
			            </tr> 
			            </c:forEach>
			            </tbody>
		            </table>
		            </td>
           		</tr>
   			</table>	
		</form>	
		</td>
		</tr>
	</table> 
