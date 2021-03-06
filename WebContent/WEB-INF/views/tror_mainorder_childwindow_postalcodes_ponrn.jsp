<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>

<!-- ======================= header =====================================-->
<jsp:include page="/WEB-INF/views/headerTrorChildWindows.jsp" />
<!-- =====================end header ====================================-->

	<%-- specific jQuery functions for this JSP (must reside under the resource map since this has been
	specified in servlet.xml as static <mvc:resources mapping="/resources/**" location="WEB-INF/resources/" order="1"/> --%>
	<SCRIPT type="text/javascript" src="resources/js/tror_childwindow.js?ver=${user.versionEspedsg}"></SCRIPT>
	
	<table width="90%" class="tableBorderWithRoundCorners3D_RoundOnlyOnBottom" cellspacing="0" border="0" cellpadding="0">
		<tr height="5"><td colspan="2"></td></tr>
		<tr>
			<td colspan="3" class="text14Bold">&nbsp;&nbsp;&nbsp;
				<img title="search" valign="bottom" src="resources/images/search.gif" width="24px" height="24px" border="0" alt="search">
				<spring:message code="systema.tror.childwindow.postalcodes.label.title"/>
			</td>
		</tr>
		<tr height="20"><td colspan="2"></td></tr>
		<tr>
		<td valign="top">
			<%-- ============================================  --%>
          	<%-- Here we have the search  popup window --%>
          	<%-- ============================================  --%>
          		<%-- this container table is necessary in order to separate the datatables element and the frame above, otherwise
			 	the cosmetic frame will not follow the whole datatable grid including the search field... --%>
				<table id="containerdatatableTable" cellspacing="2" align="left" width="100%">
					<tr>
					<td>
						<table>
						<form name="trorPostalCodeForm" id="trorPostalCodeForm" action="tror_mainorder_childwindow_postalcodes_ponrn.do?action=doFind" method="post">
						<input type="hidden" name="ctype" id="ctype" value="${model.ctype}">
						<tr>
							<td class="text14">&nbsp;<spring:message code="systema.tror.childwindow.postalcodes.label.postnr"/></td>
							<td class="text14">&nbsp;<input type="text" class="inputText" name="ponnr" id="ponnr" size="10" maxlength="10" value="${model.record.ponnr}"></td>
							
							<td class="text12">&nbsp;</td>
	           				<td align="right">&nbsp;<input class="inputFormSubmit" type="submit" name="submit" value='<spring:message code="search.label"/>'></td>
		           		</tr>
		           		</form>
		           		</table>
					</td>
					</tr>								           		
	           		<tr height="10"><td></td></tr>
					<tr class="text14" >
					<td class="ownScrollableSubWindowDynamicWidthHeight" width="100%" style="height:50em;">
					<%-- this is the datatables grid (content)--%>
					<table id="postalCodePonrnList" class="display compact cell-border" width="100%">
						<thead>
						<tr class="tableHeaderField" height="20">
							<th width="5%" class="text14">&nbsp;<spring:message code="systema.tror.childwindow.postalcodes.label.postnr"/></th>   
		                    <th class="text14">&nbsp;<spring:message code="systema.tror.childwindow.postalcodes.label.name"/></th>
		                    <th class="text14">&nbsp;Beskr.</th>
		                    <th class="text14">&nbsp;Type kort</th>
		                    <th class="text14">&nbsp;Type</th>
		                    <th width="5%" align="center" class="text14">&nbsp;Kommunenr.</th>
		                    <th class="text14">&nbsp;Kommunenavn</th>
		                    
		                </tr> 
		                </thead>
		                
		                <tbody>
		                <c:forEach var="record" items="${model.postalCodePonrnList}" varStatus="counter">    
			               <tr class="text14">
			               <%-- 
			               <td class="text11MediumBlue" style="cursor:pointer;" id="vadrnr_${record.vadrnr}@navn_${record.vadrna}@adr1_${record.vadrn1}@adr2_${record.vadrn2}@postnrsted_${record.vadrn3}@counter_${counter.count}img">
			               	 <img style="vertical-align:middle;" src="resources/images/bebullet.gif" border="0" >
			               </td>
			               --%>
			               <td width="5%" align="center" class="text14MediumBlue" style="cursor:pointer;" id="id_${record.ponnr}@name_${record.ponnav}@counter_${counter.count}">
			               	 	${record.ponnr}
			               </td>
			               <td class="text14" >&nbsp;${record.ponnav}</td> 
			               <td class="text14" >&nbsp;${record.ponbes}</td>
			               <td class="text14" >&nbsp;${record.pontyk}</td>
			               <td class="text14" >&nbsp;${record.pontyp}</td>
			               <td width="5%" align="center" class="text14" >&nbsp;${record.ponknr}</td>
			               <td class="text14" >&nbsp;${record.ponkna}</td>
			               
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
