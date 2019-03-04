<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!-- ======================= header ===========================-->
<jsp:include page="/WEB-INF/views/headerTror.jsp" />
<!-- =====================end header ==========================-->
	<%-- specific jQuery functions for this JSP (must reside under the resource map since this has been
		specified in servlet.xml as static <mvc:resources mapping="/resources/**" location="WEB-INF/resources/" order="1"/> --%>
	<SCRIPT type="text/javascript" src="resources/js/trorglobal_edit.js?ver=${user.versionEspedsg}"></SCRIPT>	
	<SCRIPT type="text/javascript" src="resources/js/tror_mainorderfly_airfreightbill_trvision.js?ver=${user.versionEspedsg}"></SCRIPT>
	<SCRIPT type="text/javascript" src="resources/js/trorFkeys_flyimport.js?ver=${user.versionEspedsg}"></SCRIPT>
	
	
	<style type = "text/css">
	.ui-dialog{font-size:10pt;}
	.ui-datepicker { font-size:9pt;}
	</style>
	

<form action="tror_mainorderfly_airfreightbill_trvision_edit.do" name="trorFlyfraktTradevisionForm" id="trorFlyfraktTradevisionForm"  method="post">
	
	<%-- tab container component --%>
	<table width="100%"  class="text11" cellspacing="0" border="0" cellpadding="0">
		<%-- This part right here allows for the dynamic allocation of a JSP depending on whether it is IMPORT or EXPORT --%>
		<c:choose>
			<c:when test="${recordOrderTrorFly.heur == 'C'}">
				<c:set var = "tabLinkJsp" scope = "request" value = "mainorderflyimport"/>	
			</c:when>
			<c:otherwise>
				<c:if test="${recordOrderTrorFly.heur == 'D'}">
					<c:set var = "tabLinkJsp" scope = "request" value = "mainorderflyexport"/>
				</c:if>
			</c:otherwise>
		</c:choose>
	
		<tr height="2"><td></td></tr>
		<tr height="25"> 
			<td width="15%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderlist.do?action=doFind&avd=${recordOrderTrorFly.heavd}&sign=${recordOrderTrorFly.hesg}" > 	
					<img style="vertical-align:middle;" src="resources/images/bulletGreen.png" width="6px" height="6px" border="0" alt="open orders">
					<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.orderlist.tab"/></font>&nbsp;<font class="text10Orange">F2</font>
				</a>
			</td>
			<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
			<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="tror_<c:out value="${tabLinkJsp}"/>.do?action=doFetch&heavd=${recordOrderTrorFly.heavd}&heopd=${recordOrderTrorFly.heopd}" > 	
					<c:choose>
						<c:when test="${recordOrderTrorFly.heur == 'C'}">
							<img style="vertical-align:middle;" src="resources/images/airplaneYellow.png" width="18px" height="18px" border="0" alt="update">
						</c:when>
						<c:otherwise>
							<c:if test="${recordOrderTrorFly.heur == 'D'}">
								<img style="vertical-align:middle;" src="resources/images/airplaneBlue.png" width="18px" height="18px" border="0" alt="update">
							</c:if>
						</c:otherwise>
					</c:choose>
					<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.tab"/>&nbsp;${recordOrderTrorFly.heavd}/${recordOrderTrorFly.heopd}</font>&nbsp;<font class="text10Orange">F4</font>
				</a>
			</td>
			<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
			<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="tror_<c:out value="${tabLinkJsp}"/>_invoice.do?action=doFetch&heavd=${recordOrderTrorFly.heavd}&heopd=${recordOrderTrorFly.heopd}" > 	
					<img style="vertical-align: bottom" src="resources/images/invoice.png" width="16" height="16" border="0" alt="show invoice">
					<font class="tabDisabledLink"><spring:message code="systema.tror.order.faktura.tab"/></font>&nbsp;<font class="text10Orange">F9</font>
				</a>
			</td>
			<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
			<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="editNotisblock.do?action=doFetch&subsys=${subSystem}&avd=${recordOrderTrorFly.heavd}&opd=${recordOrderTrorFly.heopd}&sign=${recordOrderTrorFly.hesg}" > 	
					<img style="vertical-align: bottom" src="resources/images/veiledning.png" width="16" height="16" border="0" alt="show messages">
					<font class="tabDisabledLink"><spring:message code="systema.tror.order.notisblock.tab"/></font>&nbsp;<font class="text10Orange">F10</font>
				</a>
			</td>
			<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
			<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
			<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_frisokvei.do?action=doFetch&avd=${recordOrderTrorFly.heavd}&sign=${recordOrderTrorFly.hesg}&opd=${recordOrderTrorFly.heopd}">
					<img style="vertical-align: bottom" src="resources/images/lightbulb.png" width="14" height="14" border="0" alt="show log">
					<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.frisokvei.tab"/></font>&nbsp;<font class="text10Orange">F7</font>
				</a>
			</td>
			<c:choose>
			<c:when test="${recordOrderTrorFly.heur == 'C'}">
				<c:if test="${recordOrderTrorFly.hepk5 == 'J' || recordOrderTrorFly.hepk5 == 'P'}">
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tab" align="center" nowrap>
						<img style="vertical-align: bottom" src="resources/images/pen.png" width="16" height="16" border="0" alt="Awb">
						<font class="tabLink">&nbsp;<spring:message code="systema.tror.order.flyfraktbrev.tab"/></font>&nbsp;<font class="text10Orange">F8</font>
					</td>
				</c:if>	
			</c:when>
			<c:otherwise> <%-- meaning Flyeksport --%>
				<c:if test="${recordOrderTrorFly.hepk8 == 'J' || recordOrderTrorFly.hepk8 == 'P'}">
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tab" align="center" nowrap>
						<img style="vertical-align: bottom" src="resources/images/pen.png" width="16" height="16" border="0" alt="Awb">
						<font class="tabLink">&nbsp;<spring:message code="systema.tror.order.flyfraktbrev.tab"/></font>&nbsp;<font class="text10Orange">F8</font>
					</td>
				</c:if>					
			</c:otherwise>
			</c:choose>
			
			<c:if test="${recordOrderTrorFly.hepk1 == 'J' || recordOrderTrorFly.hepk1 == 'P'}">		
				<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabLink">&nbsp;</font></td>
				<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
					<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_freightbill_gate.do?dfavd=${recordOrderTrorFly.heavd}&sign=${recordOrderTrorFly.hesg}&dfopd=${recordOrderTrorFly.heopd}">
						<img style="vertical-align:bottom;" src="resources/images/fraktbrev.png" width="14" height="14" border="0" alt="edit">
						<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.fraktbrev.tab"/></font>&nbsp;<font class="text10Orange">F3</font>
					</a>					
				</td>
			</c:if>
			<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
			<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_ttrace.do?subsys=${subSystem}&avd=${recordOrderTrorFly.heavd}&sign=${recordOrderTrorFly.hesg}&opd=${recordOrderTrorFly.heopd}">
					<img style="vertical-align: bottom" src="resources/images/sort_down.png" width="10" height="10" border="0" alt="show more">
					<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.more.tab"/></font>
				</a>
			</td>	
					
			<td width="80%" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>	
		</tr>
	</table>
	</td>
	</tr>
	
	<%-- --------------------------- --%>
	<%-- Validation errors FRONT END --%>
	<%-- --------------------------- --%>
	<spring:hasBindErrors name="record"> <%-- name must equal the command object name in the Controller --%>
	<tr height="5"><td></td></tr>
	<tr>
		<td colspan="10">
           	<table class="tabThinBorderWhiteWithSideBorders" width="100%" align="left" border="0" cellspacing="0" cellpadding="0">
           	<tr>
			<td valign="bottom" class="textError">					
	            <ul>
	            <c:forEach var="error" items="${errors.allErrors}">
	                <li >
	                	<spring:message code="${error.code}" text="${error.defaultMessage}"/>
	                </li>
	            </c:forEach>
	            </ul>
			</td>
			</tr>
			</table>
		</td>
	</tr>
	</spring:hasBindErrors>	
	
	<%-- -------------------------- --%>
	<%-- Validation errors BACK END --%>
	<%-- -------------------------- --%>
	<c:if test="${not empty model.containerValidationBackend && not empty model.containerValidationBackend.errMsgListFromValidationBackend}">
		<tr>
		<td colspan="10">
           	<table class="tabThinBorderWhiteWithSideBorders" width="100%" align="left" border="0" cellspacing="0" cellpadding="0">
           	<tr>
			<td valign="bottom" class="textError">					
	            <ul>
	            <c:forEach var="errMsg" items="${model.containerValidationBackend.errMsgListFromValidationBackend}">
	                <li >${errMsg}</li>
	            </c:forEach>
	            </ul>
			</td>
			</tr>
			</table>
		</td>
		</tr>		
	</c:if>
	<%-- -------------------------- --%>
	<%-- Validation errors on model --%>
	<%-- -------------------------- --%>
	<c:if test="${not empty model.errorMessage}">
		<tr>
		<td>
           	<table class="tabThinBorderWhiteWithSideBorders" width="100%" align="left" border="0" cellspacing="0" cellpadding="0">
           	<tr>
			<td valign="bottom" class="textError">					
	            <ul>
	            	<li >${model.errorMessage}</li>
	            </ul>
			</td>
			</tr>
			</table>
		</td>
		</tr>		
	</c:if>
	

		<tr>
		<td>
			<%-- this table wrapper is necessary to apply the css class with the thin border --%>
			<table style="width:100%" id="wrapperTable" class="tabThinBorderWhite" cellspacing="0">
			<tr height="10"><td>&nbsp;</td></tr> 
			
			<%-- Second tab row... ONLY export since Tradevision module MUST be handled --%>
			<tr> 
 	   	 		<td align="left" width="99%">
 					<table class="formFrameHeaderTransparent" width="98%" cellspacing="0" border="0" cellpadding="0">
						<tr height="20"> 	
							<td width="12%" valign="bottom" class="tabDisabledSub" align="center" nowrap>
								<a style="display:block" id="alinkTradevision" onClick="setBlockUI(this);" href="tror_mainorderfly_airfreightbill_edit.do?dfavd=${recordOrderTrorFly.heavd}&dfopd=${recordOrderTrorFly.heopd}&sign=${recordOrderTrorFly.hesg}&dflop=1">
									<font class="tabDisabledLinkMinor">&nbsp;<spring:message code="systema.tror.order.more.tab.flyfraktbrev.subtab"/></font>&nbsp;						
								</a>
							</td>
							<td width="12%" valign="bottom" class="tabSub" align="center" nowrap>
								<font class="tabLinkMinor">&nbsp;<spring:message code="systema.tror.order.more.tab.flyfraktbrev.tradevision.subtab"/></font>&nbsp;					
							</td>
							<td width="80%" class="tabFantomSpace" align="center" nowrap></td>
						</tr>
					</table>
				</td>
			</tr>	
			<!-- End second tab row -->	
			
			
			<%-- FORM HEADER --%>
	 		<tr>
           		<td>
        			<table class="dashboardFrameHeader" width="98%" align="left" border="0" cellspacing="0" cellpadding="0">
			 		<tr height="15">
			 			<td align="left" class="text14White">
			 				<c:choose>
			 				<c:when test="${not empty model.firstBooking}">
							&nbsp;<img style="vertical-align:bottom;" src="resources/images/add.png" width="14" height="14" border="0" alt="edit">
							</c:when>
							<c:otherwise>	
							&nbsp;<img style="vertical-align:bottom;" src="resources/images/complete-icon.png" width="14" height="14" border="0" alt="edit">
							</c:otherwise>
							</c:choose>	
			 				&nbsp;<spring:message code="systema.tror.flyfraktbrev.form.update.label.title"/>
							&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: black"><b>${recordOrderTrorFly.heavd} / ${recordOrderTrorFly.heopd} / ${recordOrderTrorFly.hesg}</b></font>
							&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="systema.tror.flyfraktbrev.form.update.label.mawb"/>:&nbsp;<font style="color: black"><b>${recordOrderTrorFly.hegn}</b></font>
							&nbsp;&nbsp;<spring:message code="systema.tror.flyfraktbrev.form.update.label.hawb"/>:&nbsp;<font style="color: black"><b>${recordOrderTrorFly.hehawb}</b></font>
							&nbsp;&nbsp;
		 				</td>
		 				<td align="right" class="text14White">
		 					<c:if test="${not empty model.bookingExists}">
		 						<img style="vertical-align:middle;" src="resources/images/airplaneBlue.png" height="12px" width="12px" border="0" alt="booking exists">
		 						<font style="color: yellow"><b>Booking exists</b></font>
		 					</c:if>
		 					&nbsp;&nbsp;TRADEVISION&nbsp;
		 				</td>
	 				</tr>
 					</table>
           		</td>
            </tr>
            <%-- FORM DETAIL --%>
            <tr ondrop="drop(event)" ondragover="allowDrop(event)" >
            		<td>
            		<input type="hidden" name="applicationUser" id="applicationUser" value='${user.user}'>
					<input type="hidden" name="action" id="action" value='${model.action}'>
					<input type="hidden" name="dfavd" id="dfavd" value='${recordOrderTrorFly.heavd}'>
					<input type="hidden" name="dfopd" id="dfopd" value='${recordOrderTrorFly.heopd}'>
					<input type="hidden" name="dflop" id="dflop" value='${recordFlyfraktbrevImportHeaderTrorFly.imlop}'>
					<input type="hidden" name="sign" id="sign" value='${recordOrderTrorFly.hesg}'>
						
					<%-- dfri = F as offsett. Always. Old rule in order to acquire status "active" ... --%>
					<input type="hidden" name="dfri" id="dfri" value='F'> 
					<%--for F-Keys shortcuts. Used only in trorFkeys_...js --%>
					<input type="hidden" name="fkeysavd" id="fkeysavd" value='${recordOrderTrorFly.heavd}'>
					<input type="hidden" name="fkeysopd" id="fkeysopd" value='${recordOrderTrorFly.heopd}'>
					<input type="hidden" name="fkeyssign" id="fkeyssign" value='${recordOrderTrorFly.hesg}'>
					<c:choose>
						<c:when test="${recordOrderTrorFly.heur == 'C'}">
							<input type="hidden" name="fkyessubsys" id="fkyessubsys" value='mainorderflyimport'>
						</c:when>
						<c:otherwise>
							<c:if test="${recordOrderTrorFly.heur == 'D'}">
								<input type="hidden" name="fkyessubsys" id="fkyessubsys" value='mainorderflyexport'>
							</c:if>
						</c:otherwise>
					</c:choose>
					
					<table class="tableBorderWithRoundCorners3D_RoundOnlyOnBottom" width="98%" align="left" border="0" cellspacing="0" cellpadding="0">
				 		<tr height="5"><td ></td></tr>
				 		<tr>
							<td colspan="8">
								
								<table class="text14" border="0">
								
					 			<tr>
					 				<td class="text14">
					 					<img style="vertical-align: middle;" onMouseOver="showPop('fwb_info');" onMouseOut="hidePop('fwb_info');" width="9px" height="9px" src="resources/images/info3.png" border="0" alt="info">
					 					<span title="f0211/f0213">AWB</span>
					 					<div class="text11" style="position: relative; display: inline;" align="left" >
							 				<span style="position:absolute;left:20px; width:250px;" id="fwb_info" class="popupWithInputText text11"  >
							           		<p>
							           		 todo
											</p> 
											</span>	
										</div>
					 				</td>
					 				<td class="text14" >
					 					<input type="text" class="inputTextMediumBlue" name="f0211" id="f0211" size="3" maxlength="3" value="${model.record.f0211}">
				 						<input type="text" class="inputTextMediumBlue" name="f0213" id="f0213" size="9" maxlength="8" value="${model.record.f0213}">
						 					
									</td>
									<td class="text14" >
					 					<input tabindex=-1 readonly type="text" class="inputTextReadOnly" name="f00rec" id="f00rec" size="11" value="${model.record.f00rec}">
									</td>									
									
					 			</tr>
					 			</table>
							</td>
						</tr>
						
						<tr height="10"><td ></td></tr>
						<tr>
							<td class="text14Bold">&nbsp;<spring:message code="systema.tror.flyfraktbrev.form.update.label.shipper"/></td>
							<td class="text14Bold">&nbsp;<spring:message code="systema.tror.flyfraktbrev.form.update.label.consignee"/></td>
						</tr>
						<tr height="5"><td ></td></tr>
						
						<tr>
				 			<td valign="top" width="50%" >
				 			 <table style="width:98%" class="tableBorderWithRoundCornersLightYellow" cellspacing="1" cellpadding="1" border="0">
						 		<tr height="10"><td ></td></tr>
						 		<tr>
						 			<td>
						 			<table style="width:100%" >
					 		 		<tr>
						 				<td class="text14">&nbsp;<span title="todo"><spring:message code="systema.tror.flyfraktbrev.form.update.label.name"/></span></td>
						 				<td class="text14">&nbsp;<span title="dftlfk"><spring:message code="systema.tror.flyfraktbrev.form.update.label.from"/></span></td>
						 				<td class="text14">&nbsp;<span title="dftlfk"><spring:message code="systema.tror.flyfraktbrev.form.update.label.to"/></span></td>
						 				<td class="text14">&nbsp;<span title="dftlfk"><spring:message code="systema.tror.flyfraktbrev.form.update.label.incoterms"/></span></td>
						 				<td class="text14">&nbsp;<span title="dftlfs"><spring:message code="systema.tror.flyfraktbrev.form.update.label.phone"/></span></td>
						 				
						 			</tr>
						 			<tr>	
						 				<td class="text14"><input readonly type="text" class="inputTextReadOnly" name="ownSenderName" id="ownSenderName" size="30" maxlength="50" value="${ownSenderName}"></td>
					 					<td class="text14"><input readonly type="text" class="inputTextReadOnly" name="header_imp.hesdf" id="header_imp.hesdf" size="4" maxlength="3" value="${recordFlyfraktbrevImportHeaderTrorFly.hesdf}"></td>
					 					<td class="text14"><input readonly type="text" class="inputTextReadOnly" name="header_imp.hesdt" id="header_imp.hesdt" size="4" maxlength="3" value="${recordFlyfraktbrevImportHeaderTrorFly.hesdt}"></td>
					 					<td class="text14"><input readonly type="text" class="inputTextReadOnly" name="header_imp.hefr" id="header_imp.hefr" size="4" maxlength="3" value="${recordFlyfraktbrevImportHeaderTrorFly.hefr}"></td>
					 					<td class="text14"><input type="text" class="inputTextMediumBlue" name="dftlfs" id="dftlfs" size="16" maxlength="15" value="${Xmodel.record.dftlfs}"></td>
					 				</tr>
					 				</table>
					 				</td>
					 			</tr>	
					 			<tr height="10"><td ></td></tr>
				 				
							 </table>
						 	</td>
						 	<td valign="top" width="50%">
				 			 <table style="width:98%" class="tableBorderWithRoundCornersLightYellow" cellspacing="1" cellpadding="1">
					 			<tr height="10"><td ></td></tr>
					 			<tr>
						 			<td>
						 			<table style="width:60%" >
							 		<tr>
						 				<td class="text14">&nbsp;<span title="todo"><spring:message code="systema.tror.flyfraktbrev.form.update.label.name"/></span></td>
						 				<td class="text14">&nbsp;<span title="todo"><spring:message code="systema.tror.flyfraktbrev.form.update.label.phone"/></span></td>
						 				
						 			</tr>
						 			<tr>	<%--${model[Xmodel.record.hekns]} --%>
					 					<td class="text14"><input readonly type="text" class="inputTextReadOnly" name="todo" id="todo" size="30" maxlength="50" value="${recordOrderTrorFly.henak}"></td>
					 					<td class="text14"><input type="text" class="inputTextMediumBlue" name="dftlfk" id="dftlfk" size="16" maxlength="15" value="${Xmodel.record.dftlfk}"></td>
					 				</tr>
					 				</table>
					 				</td>
				 				</tr>
				 				<tr height="10"><td ></td></tr>
			 				</table>
						 	</td>
					 	</tr>
					 	<tr height="10"><td ></td></tr>
					 	
					 	<tr>
				 			<td colspan="2" valign="top">
				 			<table class="tableBorderWithRoundCorners" width="99%">
				 				<tr>
				 					<td >
				 					<table border="0">
				 						<tr>
					 						<td valign="top" >
				 							<table class="tableBorderWithRoundCornersLightGray">
					 						<tr>
					 					
								 				<td class="text14">&nbsp;<span title="f0221"><b><spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.origin"/></b></span></td>
								 				<td class="text14" >
								 					<input type="text" class="inputTextMediumBlue" name="f0221" id="f0221" size="4" maxlength="3" value="${model.record.f0221}">
								 				</td>
							 					<td class="text14">&nbsp;<span title="f0222"><b><spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.destination"/></b></span></td>
								 				<td class="text14" >
								 					<input type="text" class="inputTextMediumBlue" name="f0222" id="f0222" size="4" maxlength="3" value="${model.record.f0222}">
							 					</td>
							 					<td class="text14">&nbsp;<span title="f0272"><b><spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.content"/></b></span></td>
								 				<td class="text14" >
								 					<input type="text" class="inputTextMediumBlue" name="f0272" id="f0272" size="20" maxlength="15" value="${model.record.f0272}">
							 					</td>
						 					</tr>
						 					</table>
						 					</td>
						 				</tr>

									</table>
									</td>				 				
					 			</tr>
						 	</table>
						 	</td>
					 	</tr>
					 	
					 	<tr>
				 			<td colspan="2" valign="top" width="100%" >
				 			<table width="99%">
				 				<tr height="4"><td ></td></tr>
					 					<tr>
					 					<td colspan="2">
					 					<table class="tableBorderWithRoundCorners" width="100%" border="0">
					 						<tr>
					 						<td width="100%">
					 							<table width="100%" >
					 								<tr>	
											 			<td class="text14">
											 				<span title="f0233/todo">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.nopieces"/></span>
									 					</td>
										 				<td class="text14">
										 					<input onKeyPress="return numberKey(event)" type="text" class="inputTextMediumBlue" name="f0233" id="f0233" size="5" maxlength="4" value="${model.record.f0233}">
										 				</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="todo" id="todo" size="1" maxlength="1" value="${Xmodel.record.todo}">
										 				</td>
										 				<td class="text14">
											 				<span title="f0235/f0234">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.weight"/></span>
									 					</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="f0235" id="f0235" size="10" maxlength="9" value="${model.record.f0235}">
										 				</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="f0234" id="f0234" size="1" maxlength="1" value="${model.record.f0234}">
										 				</td>
										 				<td class="text14">
											 				<span title="f0242/f0241">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.volume"/></span>
									 					</td>
										 				<td class="text14">
										 					<input onKeyPress="return amountKey(event)" type="text" class="inputTextMediumBlue" name="f0242" id="f0242" size="15" maxlength="13" value="${model.record.f0242}">
										 				</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="f0241" id="f0241" size="2" maxlength="2" value="${model.record.f0241}">
										 				</td>
										 			
											 			<td class="text14">
											 				<span title="f0282/f0283">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.spechandlecode"/></span>
									 					</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="f0282" id="f0282" size="3" maxlength="3" value="${model.record.f0282}">
										 				</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="f0283" id="f0283" size="3" maxlength="3" value="${model.record.f0283}">
										 				</td>
										 			
											 			<td class="text14">
											 				<span title="f0751">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.bookingref"/></span>
									 					</td>
										 				<td class="text14">
										 					<input type="text" class="inputTextMediumBlue" name="f0751" id="f0751" size="8" maxlength="7" value="${model.record.f0751}">
										 				</td>
										 				
										 				<td class="text14">
											 				<span title="f043">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.numberuld"/></span>
									 					</td>
										 				<td class="text14">
										 					<input onKeyPress="return numberKey(event)" type="text" class="inputTextMediumBlue" name="f043" id="f043" size="2" maxlength="2" value="${model.record.f043}">
										 				</td>
										 				
										 			</tr>
										 				
										 		</table>
										 	</td>
										 	</tr>		
										</table>
										</td>
										</tr>	 	
				 						<tr>
				 						<td width="50%">
				 							<table width="100%" >
				 								<tr>	
										 			<td class="text14">
										 				<span title="f0522">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.special.servreq"/>&nbsp;1</span>
								 					</td>
									 				<td colspan="10" class="text14">
									 					<input type="text" class="inputTextMediumBlue" name="f0522" id="f0522" size="70" maxlength="65" value="${model.record.f0522}">
									 				</td>
									 			</tr>	
									 			<tr>	
										 			<td class="text14">
										 				<span title="f0532">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.special.servreq"/>&nbsp;2</span>
								 					</td>
									 				<td colspan="10" class="text14">
									 					<input type="text" class="inputTextMediumBlue" name="f0532" id="f0532" size="70" maxlength="65" value="${model.record.f0532}">
									 				</td>
									 			</tr>
									 			<tr>	
										 			<td class="text14">
										 				<span title="f0622">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.other.servinfo"/>&nbsp;1</span>
								 					</td>
									 				<td colspan="10" class="text14">
									 					<input type="text" class="inputTextMediumBlue" name="f0622" id="f0622" size="70" maxlength="65" value="${model.record.f0622}">
									 				</td>
									 			</tr>	
				 								
									 			<tr height="5"><td colspan="2" ></td></tr>
									 		</table>
									 	</td>
									 	
									 	<td valign="top" width="50%">
				 							<table width="100%" >
				 								<tr>	
										 			<td class="text14">
										 				<span title="f0632">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.other.servinfo"/>&nbsp;2</span>
								 					</td>
									 				<td class="text14">
									 					<input type="text" class="inputTextMediumBlue" name="f0632" id="f0632" size="70" maxlength="65" value="${model.record.f0632}">
									 				</td>
									 			</tr>	
									 			<tr>	
										 			<td class="text14">
										 				<span title="f133">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.refno"/></span>
								 					</td>
									 				<td class="text14">
									 					<input type="text" class="inputTextMediumBlue" name="f133" id="f133" size="15" maxlength="14" value="${model.record.f133}">
									 				</td>
									 			</tr>
									 			<tr>	
										 			<td class="text14">
										 				<span title="f135/f137">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.label.supp.shipp.info"/></span>
								 					</td>
									 				<td class="text14">
									 					<input type="text" class="inputTextMediumBlue" name="f135" id="f135" size="15" maxlength="12" value="${model.record.f135}">
									 					&nbsp;&nbsp;
									 					<input type="text" class="inputTextMediumBlue" name="f137" id="f137" size="15" maxlength="12" value="${model.record.f137}">
									 				</td>
									 			</tr>
									 			
				 								
									 			<tr height="5"><td colspan="2" ></td></tr>
									 		</table>
									 	</td>
									 	
									 	<td valign="bottom" align="right">
											<input tabindex=-1 class="inputFormSubmit submitSaveClazz" type="submit" name="submit" id="submit" value='<spring:message code="systema.tror.submit.save"/>'/>
					 				    	</td>
									 	</tr>
									 	
									</table>
									</td>				 				 				
					 			</tr>
 							</table>
 							</td>
					 	</tr>
					 	
					 	<tr height="5"><td ></td></tr>
					 </table>
				</td>
			</tr>
			<tr height="5"><td ></td></tr>
			<%-- X --%>
			<tr>
            		<td>
	        			<table style="width:98%;" align="left" class="tableBorderWithRoundCornersLightYellow" cellspacing="0" cellpadding="0">
				 		
						<tr height="5"><td colspan="2" ></td></tr>
						<tr height="1"><td colspan="2" style="border-bottom:1px solid;border-color:#FFFFFF;" class="text"></td></tr>
						<tr height="3"><td colspan="2" ></td></tr>
						
						<tr>
			            		<td>
				        			<table width="98%" id="containerdatatableTable" cellspacing="0" align="left" >
								<tr height="5"><td align="left" ></td></tr>
								
						 		<tr>
									<td colspan="2" style="padding: 0px;">
										<table style="width:100%;" >
										<thead>
										<tr >
											<th align="left" width="2%" valign="bottom" class="tableHeaderFieldFirst12"><span title="f0311">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.carrier"/></span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f0312">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.flightnumber"/>&nbsp;</span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f0314">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.day"/>&nbsp;</span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f0315">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.month"/>&nbsp;</span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f0331">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.airport.departure"/>&nbsp;</span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f0332">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.airport.arrival"/>&nbsp;</span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f035">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.speccode"/>&nbsp;</span></th>
								 			<th align="left" width="2%" valign="bottom" class="tableHeaderField12"><span title="f0362">&nbsp;<spring:message code="systema.tror.flyfraktbrev.tradevision.form.update.itemlines.label.allotmentid"/>&nbsp;</span></th>
								 		</tr>
								 		</thead>
								 		<tbody>
								 		<tr class="tableRow">
								 			<td width="2%" class="tableCellFirst" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0311" id="f0311" size="3" maxlength="2" value="${model.record.f0311}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0312" id="f0312" size="6" maxlength="5" value="${model.record.f0312}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0314" id="f0314" size="3" maxlength="2" value="${model.record.f0314}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0315" id="f0315" size="4" maxlength="3" value="${model.record.f0315}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0331" id="f0331" size="4" maxlength="3" value="${model.record.f0331}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0332" id="f0332" size="4" maxlength="3" value="${model.record.f0332}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f035" id="f035" size="3" maxlength="2" value="${model.record.f035}">
							 				</td>
							 				<td width="2%" class="tableCell" >
							 					<input type="text" class="inputTextMediumBlue12" name="f0362" id="f0362" size="15" maxlength="14" value="${model.record.f0362}">
							 				</td>
							 			</tr>
							 			</tbody>
									<tr height="5"><td ></td></tr>
				 					</table>
			           			</td>
			            		</tr>
	 				</table>
            		</td>
            </tr>
            <tr height="2"><td></td></tr>
            
			<tr height="10"><td ></td></tr>
	</table>
</form>
		
<!-- ======================= footer ===========================-->
<jsp:include page="/WEB-INF/views/footer.jsp" />
<!-- =====================end footer ==========================-->
