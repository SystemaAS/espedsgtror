<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!-- ======================= header ===========================-->
<jsp:include page="/WEB-INF/views/headerTror.jsp" />
<!-- =====================end header ==========================-->
	<%-- specific jQuery functions for this JSP (must reside under the resource map since this has been
		specified in servlet.xml as static <mvc:resources mapping="/resources/**" location="WEB-INF/resources/" order="1"/> --%>
	<SCRIPT type="text/javascript" src="resources/js/trorglobal_edit.js?ver=${user.versionEspedsg}"></SCRIPT>	
	<SCRIPT type="text/javascript" src="resources/js/tror_mainorderflyexport.js?ver=${user.versionEspedsg}"></SCRIPT>
	<SCRIPT type="text/javascript" src="resources/js/trorFkeys_flyexport.js?ver=${user.versionEspedsg}"></SCRIPT>
	
	
	<style type = "text/css">
	.ui-dialog{font-size:10pt;}
	.ui-datepicker { font-size:9pt;}
	</style>
	


<table id="topTableLocal" width="100%"  class="text11" cellspacing="0" border="0" cellpadding="0">
	<tr>
	<td>
	<%-- tab container component --%>
	<table width="100%"  class="text11" cellspacing="0" border="0" cellpadding="0">
		<tr height="2"><td></td></tr>
		<tr height="25"> 
			<td width="15%" valign="bottom" class="tabDisabled" align="center" nowrap>
				<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderlist.do?action=doFind&avd=${model.record.heavd}&sign=${model.record.hesg}" > 	
					<img style="vertical-align:middle;" src="resources/images/bulletGreen.png" width="6px" height="6px" border="0" alt="open orders">
					<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.orderlist.tab"/></font>&nbsp;<font class="text10Orange">F2</font>
				</a>
			</td>
			<c:choose>
				<c:when test="${empty model.record.heopd}">
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tab" align="center" nowrap>
						<img style="vertical-align:middle;" src="resources/images/airplaneBlue.png" width="18px" height="18px" border="0" alt="create new">
						<font class="tabLink"><spring:message code="systema.tror.createnew.order.tab"/></font>
					</td>
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderland_fellesutskrift.do?avd=${model.record.heavd}&sign=${model.record.hesg}" > 	
							<img style="vertical-align:middle;" src="resources/images/printer2.png" width="12px" height="12px" border="0" alt="create new">
							<font class="tabDisabledLink"><spring:message code="systema.tror.fellesprint.tab"/></font>
						</a>
					</td>
					
				</c:when>
				<c:otherwise>
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tab" align="center" nowrap>
						<img style="vertical-align:middle;" src="resources/images/airplaneBlue.png" width="18px" height="18px" border="0" alt="update">
						<font class="tabLink"><spring:message code="systema.tror.order.tab"/></font><font class="text14">&nbsp;${model.record.heavd}/${model.record.heopd}</font>&nbsp;<font class="text10Orange">F4</font>
					</td>
					
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderflyexport_invoice.do?action=doFetch&heavd=${model.record.heavd}&heopd=${model.record.heopd}" > 	
							<img style="vertical-align: bottom" src="resources/images/invoice.png" width="16" height="16" border="0" alt="show invoice">
							<font class="tabDisabledLink"><spring:message code="systema.tror.order.faktura.tab"/></font>&nbsp;<font class="text10Orange">F9</font>
						</a>
					</td>
					
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" onClick="setBlockUI(this);" href="editNotisblock.do?action=doFetch&subsys=${subSystem}&avd=${model.record.heavd}&opd=${model.record.heopd}&sign=${model.record.hesg}" > 	
							<img style="vertical-align: bottom" src="resources/images/veiledning.png" width="16" height="16" border="0" alt="show messages">
							<font class="tabDisabledLink"><spring:message code="systema.tror.order.notisblock.tab"/></font>&nbsp;<font class="text10Orange">F10</font>
						</a>
					</td>
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_frisokvei.do?action=doFetch&avd=${model.record.heavd}&sign=${model.record.hesg}&opd=${model.record.heopd}">
							<img style="vertical-align: bottom" src="resources/images/lightbulb.png" width="14" height="14" border="0" alt="show log">
							<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.frisokvei.tab"/></font>&nbsp;<font class="text10Orange">F7</font>
						</a>
					</td>
					<%--
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_budget.do?avd=${model.record.heavd}&sign=${model.record.hesg}&opd=${model.record.heopd}">
							<img style="vertical-align: bottom" src="resources/images/budget.png" width="16" height="16" border="0" alt="show budget">
							<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.budget.tab"/></font>&nbsp;<font class="text10Orange">F8</font>
						</a>
					</td>
					--%>
					<c:if test="${model.record.hepk8 == 'J' || model.record.hepk8 == 'P'}">
						<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
						<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
							<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_airfreightbill_edit.do?dfavd=${model.record.heavd}&sign=${model.record.hesg}&dfopd=${model.record.heopd}&dflop=1">
								<img style="vertical-align: bottom" src="resources/images/pen.png" width="16" height="16" border="0" alt="Awb">
								<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.flyfraktbrev.tab"/></font>&nbsp;<font class="text10Orange">F8</font>
							</a>
						</td>
					</c:if>
					<c:if test="${model.record.hepk1 == 'J' || model.record.hepk1 == 'P'}">
						<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
						<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
							<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_freightbill_gate.do?dfavd=${model.record.heavd}&sign=${model.record.hesg}&dfopd=${model.record.heopd}">
								<img style="vertical-align: bottom" src="resources/images/fraktbrev.png" width="14" height="14" border="0" alt="show freight doc">
								<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.fraktbrev.tab"/></font>&nbsp;<font class="text10Orange">F3</font>
							</a>
						</td>
					</c:if>
					
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
					<td width="12%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" onClick="setBlockUI(this);" href="tror_mainorderfly_ttrace.do?avd=${model.record.heavd}&sign=${model.record.hesg}&opd=${model.record.heopd}">
							<img style="vertical-align: bottom" src="resources/images/sort_down.png" width="10" height="10" border="0" alt="show more">
							<font class="tabDisabledLink">&nbsp;<spring:message code="systema.tror.order.more.tab"/></font>
						</a>
					</td>
					
				</c:otherwise>
			</c:choose>
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
		<td>
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
		<td>
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
	
	
	<%-- ------------------------------- --%>
	<%-- Floating window for file upload --%>
	<%-- ------------------------------- --%>
		<c:if test="${not empty model.record.heopd}">
			<tr>
				<td valign="bottom" >
						<div id="dialogDraggableFileUpload" title="Last opp fil">
		           		<p>
		           		<table align="left" class="popupFloatingWithRoundCorners3D">
						    <tr height="2"><td></td></tr>
					    	<tr>
							<td valign="top">
							<form name="uploadFileForm" id="uploadFileForm" method="post" enctype="multipart/form-data">
								<input type="hidden" name="applicationUserUpload" id="applicationUserUpload" value='${user.user}'>
								<input type="hidden" name="wsavd" id="wsavd" value='${model.record.heavd}'>
								<input type="hidden" name="wsopd" id="wsopd" value='${model.record.heopd}'>
								<input type="hidden" name="userDate" id="userDate" value=''>
								<input type="hidden" name="userTime" id="userTime" value=''>
								<input type="hidden" name="callerModule" id="callerModule" value='trorFlyexport'>
								
									<table id="containerdatatableTable" cellspacing="2" align="left">
										<tr>
											<td colspan="3" class="text12Bold">&nbsp;
												<img style="vertical-align:bottom;" src="resources/images/upload.png" border="0" width="20" height="20" alt="upload">
												&nbsp;Last opp&nbsp;							
											</td>
										</tr>
										<tr>
										<tr height="5"><td></td></tr>
										<tr>
										<td>
											<table>
											<%--
											<tr>
												<td class="text11">&nbsp;Nytt filnavn:</td>
												<td class="text11">&nbsp;<input tabindex=-1 type="text" class="inputText" name="fileNameNew" id="fileNameNew" size="20" maxlength="20" value=""></td>
											</tr>
											 --%>
											<tr>
												<td class="text14">&nbsp;Arkiv typen:</td>
												<td class="text14">&nbsp;
													<select class="inputText" tabindex=-1 name="wstype" id="wstype">
														<c:forEach var="record" items="${user.arkivKodOpdList}" >
								                       	 	<option value="${record.arkKod}">${record.arkKod}-${record.arkTxt}</option>
														</c:forEach> 
													</select>	
												</td>
											</tr>
											<tr>	
												<td class="text14">&nbsp;Fil:</td>
												<td class="text14">
					           						&nbsp;<input ondragenter="myFileUploadDragEnter(event)" ondragleave="myFileUploadDragLeave(event)" tabindex=-1 class="tableBorderWithRoundCornersLightYellow3D noFileChosenTransparent" style="width:220px;height:120px;display:block;" type="file" name="file" id="file" />
					       						</td>
							           		</tr>
							           		</table>
										</td>
										</tr>
										<tr height="5"><td></td></tr>
					       			</table>
							</form>	
							</td>
							</tr>
						</table>
						</p>
					  </div>
				</td>
			</tr>
		</c:if>
		
		<tr>
		<td>
			<form action="tror_mainorderflyexport.do" name="trorOrderForm" id="trorOrderForm" method="post">
			<%-- this table wrapper is necessary to apply the css class with the thin border --%>
			<table style="width:100%" id="wrapperTable" class="tabThinBorderWhite" cellspacing="0" border="0">
			<tr height="10"><td>&nbsp;</td></tr> 
			<%-- FORM HEADER --%>
	 		<tr>
           		<td>
           			
        			<table class="formFrameHeader" width="98%" align="left" border="0" cellspacing="0" cellpadding="0">
			 		<tr height="15">
			 			<c:choose>
				 			<c:when test="${not empty model.record.heopd}">
					 			<td align="left" class="text14White">
									&nbsp;<img style="vertical-align:bottom;" src="resources/images/update.gif" border="0" alt="edit">	
									&nbsp;<spring:message code="systema.tror.orders.form.update.label.header.edit"/>
									&nbsp;&nbsp;<font style="color: yellow"><b>${model.record.heavd} / ${model.record.heopd} / ${model.record.hesg}</b></font>
									&nbsp;&nbsp;&nbsp;<b><spring:message code="systema.tror.order.suborder.flyexport"/></b>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="systema.tror.orders.form.update.label.hawb"/>:&nbsp;${model.record.hehawb}
									
				 				</td >
			 				</c:when>
			 				<c:otherwise>
								<td align="left" class="text14White">
									&nbsp;<spring:message code="systema.tror.orders.form.update.label.header.add"/>
				 				</td>	
			 				</c:otherwise>
		 				</c:choose>
		 				<td align="right" class="text12White" width="50%">
		 					<img style="vertical-align: middle;" onMouseOver="showPop('status_info');" onMouseOut="hidePop('status_info');" width="9px" height="9px" src="resources/images/info3.png" border="0" alt="info">
							STATUS
							<img id="updateStatusImg" style="vertical-align: middle; cursor:pointer;" src="resources/images/changeStatus.png" width="11px" height="11px" border="0" alt="change status">
		 					&nbsp;&nbsp;<font style="color: orangered"><b>${model.record.hest}</b></font>&nbsp;&nbsp;
		 					<div class="text11" style="position: relative; display: inline;" align="left" >
				 				<span style="position:absolute;left:-40px; top:5px; width:400px;" id="status_info" class="popupWithInputText text11"  >
					           		<p>Status på oppdraget. Denne koden forteller hvor langt et oppdrag har kommet i
										"syklusen" fra det første gang registreres til det er ferdig fakturert og avsluttet.</p> 
				           			<ul>
				           				<li><b>' '</b>&nbsp;(blank) "Åpent". Oppdraget er ikke fakturert og det er åpent for alle typer endringer.
				           				<li><b>U</b>&nbsp;Booking / B/L er laget, men oppdrag er ikke bearbeidet. Hvis et oppdrag i sjø-modulen er påbegynt via Booking eller B/L, vill oppdraget inntil man går inn og jobber med det, ha denne statusen.</li>
				           				<li><b>K</b>&nbsp;"Ferdigmeldt". Oppdraget ligger i kø for ferdigmeldte oppdrag. Man har fortsatt mulighet for å endre på fakturaen, eller omgjøre klarmeldingen.</li>
				           				<li><b>C</b>&nbsp;"Klar for samlefaktura". Oppdraget ligger i kø for samlefaktura. Man har fremdeles mulighet for å endre på fakturaen eller fjerne fra samlefakturakø.</li>	
				           				
				           				<li><b>F</b>&nbsp;"Fakturert". Oppdraget er fakturert, men ennå ikke overført til økonomisystemet. Oppdraget kan hverken krediteres eller slettes i denne status. De enkelte fakturaer kan derimot slettes (MENU INV, punkt 6).Fakturanummerene merkes da i fakturajournalen med "**** SLETTET ***".</li>	
				           				<li><b>G</b>&nbsp;"Merket for overføring". Oppdragene har denne status i tiden mellom merking for overføring til regnskap og selve overføringen.Ved denne status kan fakturaer slettes. Fakturanummerene merkes da i fakturajournalen med "**** SLETTET ****".Ordinær kreditering - se under.</li>	
				           				<li><b>T</b>&nbsp;Overført men ikke oppdatert i statistikk. Et oppdrag med denne statusen er ferdig overført til regnskap, men ennå ikke oppdatert i statistikk.</li>	
				           				<li><b>O</b>&nbsp;"Overført". Ferdig overført til regnskap. I denne status kan en faktura i sin helhet krediteres, men ikke slettes.</li>	
				           				<li><b>S</b>&nbsp;"Slettet". Oppdraget er slettet via funksjon for sletting av oppdrag.</li>	
				           				<li><b>X</b>&nbsp;"Under oppdatering ". Noen arbeider med oppdraget, og oppholder seg på oppdragsbildet. Hvis man, mens man er inne på et oppdrag, "mister" kontakten med systemet, eller det oppstår en feilsituasjon, vil oppdraget kunne bli "hengende" i status X.</li>	
				           				<li><b>M</b>&nbsp;"Under oppdatering ". Oppdraget er låst fordi en overføring av import-MVA fra fortollingsprogrammet foregår akkurat nå. OBS! Som man forstår skal et oppdrag ha status 'X' eller 'M' kun en begrenset tidsperiode. Dersom oppdrag har denne status permanent skyldes dette unormalt jobbavbrudd - f.eks strømbrudd.
				           						Ta i så fall kontakt med dataansvarlig slik at hun eller han kan rette statusen på oppdraget til ' '.</li>	
				           							
				           			</ul>
								</span>	
							</div>
		 					
		 					
		 				</td>
	 				</tr>
 					</table>
           		</td>
            </tr>
            <%-- FORM DETAIL --%>
            <tr ondrop="drop(event)" ondragover="allowDrop(event)" >
            		<td>
            		<input type="hidden" name="applicationUser" id="applicationUser" value='${user.user}'>
					<input type="hidden" name="action" id="action" value='doUpdate'>
					<input type="hidden" name="selectedType" id="selectedType" value='${model.selectedType}'>
					<input type="hidden" name="heur" id="heur" value='${model.record.heur}'> <%--delsystem --%>
					<c:choose>
					<c:when test="${empty model.record.hedtr || model.record.hedtr == '0' }">
						<jsp:useBean id="now" class="java.util.Date" />
						<fmt:formatDate var="today" value="${now}" pattern="yyyyMMdd" />
						<input type="hidden" name="hedtr" id="hedtr" value='${today}'> <%--log time (today) --%>
					</c:when>
					<c:otherwise>
						<input type="hidden" name="hedtr" id="hedtr" value='${model.record.hedtr}'> <%--log time at the time of the registration --%>
					</c:otherwise>
					</c:choose>
					
					
					<c:if test="${not empty model.record.heopd}">
						<%--for F-Keys shortcuts. Used only in trorFkeys_...js --%>
						<input type="hidden" name="fkeysavd" id="fkeysavd" value='${model.record.heavd}'>
						<input type="hidden" name="fkeysopd" id="fkeysopd" value='${model.record.heopd}'>
						<input type="hidden" name="fkeyssign" id="fkeyssign" value='${model.record.hesg}'>
						<c:choose>
							<c:when test="${model.record.heur == 'C'}">
								<input type="hidden" name="fkyessubsys" id="fkyessubsys" value='mainorderflyimport'>
							</c:when>
							<c:otherwise>
								<c:if test="${model.record.heur == 'D'}">
									<input type="hidden" name="fkyessubsys" id="fkyessubsys" value='mainorderflyexport'>
								</c:if>
							</c:otherwise>
						</c:choose>
						<input type="hidden" name="heopd" id="heopd" value='${model.record.heopd}'>
						<input type="hidden" name="heavd" id="heavd" value='${model.record.heavd}'>
						<input type="hidden" name="hesg" id="hesg" value='${model.record.hesg}'> <%--sign --%>
						<input type="hidden" name="hest" id="hest" value='${model.record.hest}'> <%--status --%>
					</c:if>
					
					<table class="formFrame" width="98%" align="left" border="0" cellspacing="0" cellpadding="0">
				 		<tr>
							<td colspan="8">
									<c:if test="${empty model.record.heopd}">
										<table class="tableBorderWithRoundCornersLightGray" border="0">
							 			<tr>
							 				<td width="5px" class="text14" >&nbsp;</td>
							 				<td class="text14"><spring:message code="systema.tror.orders.form.update.label.delsystem"/></td>
							 				<td class="text14" ><b><spring:message code="systema.tror.order.suborder.flyexport"/></b></td>
							 				<td class="text14" width="15px" >&nbsp;</td>
							 				<td class="text14" >
							 					&nbsp;<font class="text16RedBold" >*</font><span title="heavd"><spring:message code="systema.tror.orders.form.update.label.avdelning"/></span>
							 					<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_avd.do?action=doFind&ctype=tror_flyexport','customerWin','top=300px,left=150px,height=600px,width=800px,scrollbars=no,status=no,location=no')">
		 											<img id="imgAvdList" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 										</a>
							 				</td>
							 				<td class="text14">
												<select autofocus name="heavd" id="heavd" required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" class="inputTextMediumBlueMandatoryField" >
							 						<option value="">-velg-</option>
								 				  	<c:forEach var="record" items="${model.avdList}" >
								 				  		<option value="${record.koaavd}"<c:if test="${model.record.heavd == record.koaavd}"> selected </c:if> >${record.koaavd}</option>
													</c:forEach>  
												</select>

												&nbsp;&nbsp;<font class="text16RedBold" >*</font><span title="hesg"><spring:message code="systema.tror.orders.form.update.label.signature"/></span>
							 					<select name="hesg" id="hesg" required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" class="inputTextMediumBlueMandatoryField" >
							 						<option value="">-velg-</option>
								 				  	<c:forEach var="record" items="${model.signatureList}" >
								 				  		<option value="${record.kosfsi}"<c:if test="${model.record.hesg == record.kosfsi}"> selected </c:if> >${record.kosfsi}</option>
													</c:forEach>  
												</select>							 					
							 				</td>
							 				<td width="5px" class="text14" >&nbsp;</td>
							 			</tr>
							 			</table>
						 			</c:if>
						 			
					 			
					 			<table width="100%" border="0">
					 			<tr>
					 				<td valign="top" align="left" width="50%">
					 					<table width="100%" border="0">
					 						
					 					<tr>
					 						<td class="text14" title="hedtop"><font class="text16RedBold" >*</font><spring:message code="systema.tror.orders.form.update.label.date"/></td>
							 				<td class="text14" >	
							 					<input type="text" required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" class="inputTextMediumBlueMandatoryField" name="hedtop" id="hedtop" size="9" maxlength="8" value="${model.record.hedtop}">
							 				</td>
							 				<td class="text14" title="hepro">
							 					<img onMouseOver="showPop('turnr_info');" onMouseOut="hidePop('turnr_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 					<spring:message code="systema.tror.orders.form.update.label.turnr"/>
							 					<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="turnr_info" class="popupWithInputText text11"  >
										           		<p><b>Turnr</b></p> 
									           			Turnr hentes automatisk fra teller ved tasting av F-9. Feltet er tilgjengelig slik at en allerede
														eksisterende tur kan tastes inn
													</span>	
												</div>
							 				
							 				</td>
							 				<td class="text14">
							 					<c:choose>
						 						<c:when test="${'0' != model.record.hepro}">
							 						<input <c:if test="${ not empty model.record.heopd }"> autofocus </c:if>  type="text" class="inputTextMediumBlue" name="hepro" id="hepro" size="9" maxlength="8" value="${model.record.hepro}">
							 					</c:when>
							 					<c:otherwise>
							 						<input type="text" class="inputTextMediumBlue" name="hepro" id="hepro" size="9" maxlength="8" value="">
							 					</c:otherwise>
							 					</c:choose>
							 				</td>
							 				<%--
							 				<td class="text14" title="hepos1">
							 					<img onMouseOver="showPop('hepos_info');" onMouseOut="hidePop('hepos_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 					<spring:message code="systema.tror.orders.form.update.label.position"/>
							 				</td>
							 				<td>	
							 					<input type="text" class="inputTextMediumBlue" name="hepos1" id="hepos1/hepos2" size="8" maxlength="7" value="${model.record.hepos1}">
							 					<c:choose>
						 						<c:when test="${'0' != model.record.hepos2}">
							 						<input type="text" class="inputTextMediumBlue" name="hepos2" id="hepos2" size="5" maxlength="4" value="${model.record.hepos2}">
							 					</c:when>
							 					<c:otherwise>
							 						<input type="text" class="inputTextMediumBlue" name="hepos2" id="hepos2" size="5" maxlength="4" value="">
							 					</c:otherwise>
							 					</c:choose>
							 					<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="hepos_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.position"/></b></p> 
									           			Hovedposisjon er 4 lang. Underposisjon er 4 lang. Overføres til rubrikk 49 på SAD-dokumentet
														( konnossement nr. ).
													</span>	
												</div>
							 					
							 				</td>
							 				 --%>
							 				 <td class="text14">
							 					<img onMouseOver="showPop('hesdl_info');" onMouseOut="hidePop('hesdl_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 					<span title="hesdl"><spring:message code="systema.tror.orders.form.update.label.load"/></span>
				 								<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_loadunloadplaces.do?action=doFind&ctype=tror_flyexport','loadunloadWin','top=300px,left=50px,height=600px,width=800px,scrollbars=no,status=no,location=no')">						 				
						 							<img id="imgToSearch" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
						 						</a>
						 						<img style="vertical-align:middle;" src="resources/images/loading.png" width="15px" height="15px" border="0" alt="load/unload">
				 								
						 					</td>
						 					<td>	
				 								<input type="text" class="inputTextMediumBlue" name="hesdl" id="hesdl" size="25" maxlength="20" value="${model.record.hesdl}">
				 								<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="hesdl_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.load"/></b></p> 
									           			Lastested. F.eks: <b>L</b> = Eget lager, <b>S</b> = Speditørterminalen
														Det er ikke krav til feltet.
													</span>	
												</div>
											</td>
							 			</tr>
							 			<tr>	
							 				<td class="text14" title="hegn:${model.record.hegn}">
							 					<img onMouseOver="showPop('hegn_info');" onMouseOut="hidePop('hegn_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 					<spring:message code="systema.tror.orders.form.update.label.mawb"/>
							 					<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="hegn_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.godsnr"/></b></p> 
									           			Her tastes forsendelsens Mawb.
													</span>	
												</div>
							 				</td>
							 				
							 				<td colspan="3" class="text14">
							 					<input type="text" class="inputTextMediumBlue" name="hegn" id="hegn" size="12" maxlength="11" value="${model.record.hegn}">
							 				</td>
							 				
							 				<td class="text14" title="trsta4">
							 					<img onMouseOver="showPop('trsta4_info');" onMouseOut="hidePop('trsta4_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 					<spring:message code="systema.tror.orders.form.update.label.produktkode"/>
							 					<a tabindex="-1" id="produktkodeAirIdLink" >
		 											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 										</a>
							 					<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="trsta4_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.produktkode"/></b></p> 
									           			 E=eksport I=innland J=jetpakke, eller andre koder dere selv har bygget opp.
													</span>	
												</div>
							 				</td>
							 				
							 				<td class="text14">
							 					<select class="inputText" name="trsta4" id="trsta4">
								 					<option value="" >-velg-</option>
								 					<c:forEach var="record" items="${model.produktAirList}" varStatus="counter">
								 						<option value='${record.kofmko}' <c:if test="${ model.record.trsta4 == record.kofmko }"> selected </c:if> >${record.kofmko}</option>
								 					</c:forEach>
												</select>
												
							 				</td>
							 				
						 				</tr>
						 				
						 				
						 				</table>
					 				</td>
					 				
					 				<td valign="top" align="left" width="50%">
						 				<table width="100%" border="0">
						 				<tr>
						 					<td class="text14" title="hekna">
						 						<img onMouseOver="showPop('hekna_info');" onMouseOut="hidePop('hekna_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 						<spring:message code="systema.tror.orders.form.update.label.agent"/>/
						 						<spring:message code="systema.tror.orders.form.update.label.baerer"/>
						 						
						 						<a tabindex="-1" id="trorAgentIdLink" >
		 											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 										</a>
		 										<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="hekna_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.agent"/></b></p> 
									           			Tast agents kundenr eller søk i kunderegister.
													</span>	
												</div>
		 										
		 									</td>
		 									<td class="text14" >
		 										<c:choose>
						 						<c:when test="${'0' != model.record.hekna}">	
						 							<input type="text" class="inputTextMediumBlue" name="hekna" id="hekna" size="9" maxlength="8" value="${model.record.hekna}">
						 						</c:when>
						 						<c:otherwise>
						 							<input type="text" class="inputTextMediumBlue" name="hekna" id="hekna" size="9" maxlength="8" value="">
						 						</c:otherwise>
						 						</c:choose>
						 					</td>
						 					<td class="text14" title="henaa">	
						 						<input type="text" class="inputTextReadOnly" name="henaa" id="henaa" size="20" maxlength="30" value="${model.record.henaa}">
							 				</td>
									 		<td class="text14" title="herfa">
									 			<img onMouseOver="showPop('herfa_info');" onMouseOut="hidePop('herfa_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
									 			<spring:message code="systema.tror.orders.form.update.label.agentRef"/>&nbsp;
									 			<input type="text" class="inputTextMediumBlue" name="herfa" id="herfa" size="15" maxlength="14" value="${model.record.herfa}">
									 			<div class="text11" style="position: relative;" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="herfa_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.mawb"/></b></p> 
									           			Mawb referanse kan tastes her.
													</span>	
												</div>
									 		</td>
							 				
							 			</tr>
							 			<tr>
							 				<td class="text14" title="heknt/ownHeknt">
							 					<img onMouseOver="showPop('heknt_info');" onMouseOut="hidePop('heknt_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 					<spring:message code="systema.tror.orders.form.update.label.flyselskap"/>
							 					<a tabindex="-1" id="flyselskapIdLink" >
		 											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 										</a>
		 										<div class="text11" style="position: relative;"" align="left" >
									 				<span style="position:absolute; top:2px; width:200px;" id="heknt_info" class="popupWithInputText text11"  >
										           		<p><b><spring:message code="systema.tror.orders.form.update.label.transport"/></b></p> 
									           			Tast transportørs kundenr eller søk i kunderegister.
													</span>	
												</div>
		 									</td>
		 									<td class="text14" >
		 										<c:choose>
						 						<c:when test="${'0' != model.record.heknt}">	
							 						<input type="text" class="inputTextMediumBlue" name="heknt" id="heknt" size="9" maxlength="8" value="${model.record.heknt}">
							 					</c:when>
							 					<c:otherwise>
							 						<input type="text" class="inputTextMediumBlue" name="heknt" id="heknt" size="9" maxlength="8" value="">
							 					</c:otherwise>
							 					</c:choose>
							 				</td>
							 				<td class="text14" title="ownheknt">	
							 					<input type="text" class="inputTextReadOnly" name="ownHeknt" id="ownHeknt" size="30" maxlength="30" value="${model.record.ownHeknt}">
							 				</td>
							 				<c:if test="${not empty model.record.heopd}">
								 				<td class="text14" title="file upload">	
								 					<button tabindex=-1 name="fileUpladButton" class="buttonGrayWithGreenFrame" type="button" onClick="showDialogFileUploadDraggable();" >Last opp fil</button>
								 					
								 				</td>
							 				</c:if>
							 			</tr>
							 			</table>
						 			</td>
					 			</tr>
					 			
					 			
					 			</table>
						 			
							</td>
						</tr>
						
						<tr height="2"><td ></td></tr>
						<tr height="2"><td colspan="2" style="border-bottom:1px solid;border-color:#DDDDDD;" class="text"></td></tr>
						<tr height="2"><td ></td></tr>
						<tr>
							<td class="text14Bold">&nbsp;<font class="text16RedBold" >*</font><spring:message code="systema.tror.orders.form.update.label.shipper"/></td>
							<td class="text14Bold">&nbsp;<font class="text16RedBold" >*</font><spring:message code="systema.tror.orders.form.update.label.consignee"/></td>
						</tr>
						<tr height="5"><td ></td></tr>
						
						
						<tr>
				 			<td valign="top" width="50%" >
				 			 <table style="width:97%" class="tableBorderWithRoundCornersGray" cellspacing="2" cellpadding="0" border="0">
						 		<tr height="10"><td ></td></tr>
						 		<tr>
						 			<td class="text14">
					 					&nbsp;<span title="hekns"><spring:message code="systema.tror.orders.form.update.label.shipper.id"/>&nbsp;</span>
					 					<a tabindex="-1" id="trorSellerIdLink" >
											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
 										</a>
					 				</td>
					 				<td class="text14">
					 					&nbsp;<span title="whenas"><spring:message code="systema.tror.orders.form.update.label.shipper.seller"/>&nbsp;</span>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td class="text14" >
				 						<c:choose>
						 				<c:when test="${'0' != model.record.hekns}">
				 							<input type="text" class="inputTextMediumBlue" name="hekns" id="hekns" size="10" maxlength="8" value="${model.record.hekns}">
				 						</c:when>
				 						<c:otherwise>
				 							<input type="text" class="inputTextMediumBlue" name="hekns" id="hekns" size="10" maxlength="8" value="">
				 						</c:otherwise>
				 						</c:choose>
				 					</td>
					 				
								 	<td colspan="4" class="text14" ><input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="whenas" id="whenas" size="50" value="${XXmodel.record.heknsNavn}&nbsp;-&nbsp;${XXmodel.record.heknsPnSt}"></td>
				 				</tr>
								<tr height="5"><td ></td></tr>
						 		<tr>
					 				<td class="text14">&nbsp;<font class="text16RedBold" >*</font><span title="henas"><spring:message code="systema.tror.orders.form.update.label.shipper.name"/></span>
					 					<%-- <c:if test="${Xmodel.record.fakBetExists}">
						 					<a href="javascript:void(0);" onClick="window.open('tror_childwindow_customer_addresses.do?action=doFind&ctype=s&wkundnr=${user.custNr}','customerWin','top=300px,left=150px,height=800px,width=900px,scrollbars=no,status=no,location=no')">
		 										<img id="imgShipperSearch" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 									</a>
		 								</c:if> --%>
	 									<a tabindex="-1" id="trorSellerAddressesIdLink" >
											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
										</a>	 									
					 				</td>
					 				<td class="text14">&nbsp;<font class="text16RedBold" >*</font><span title="heads1"><spring:message code="systema.tror.orders.form.update.label.shipper.adr1"/></span></td>
					 			</tr>
					 			<tr>	
				 					<td class="text14"><input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="henas" id="henas" size="25" maxlength="30" value="${model.record.henas}"></td>
				 					<td class="text14"><input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="heads1" id="heads1" size="25" maxlength="30" value="${model.record.heads1}"></td>
				 				</tr>
					 			<tr>	
					 				<td class="text14">&nbsp;<span title="heads2"><spring:message code="systema.tror.orders.form.update.label.shipper.adr2"/></span></td>
					 				<td class="text14">&nbsp;<span title="heads3"><spring:message code="systema.tror.orders.form.update.label.shipper.adr3"/></span></td>
		 							<td class="text14">&nbsp;
			 							<img onMouseOver="showPop('heans_info');" onMouseOut="hidePop('heans_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 				<span title="heans">Avt.nr.</span>
						 				<div class="text11" style="position: relative;" align="left">
											<span style="position:absolute; left:0px; top:0px; width:250px" id="heans_info" class="popupWithInputText"  >
												<font class="text11">
							           			<b>Avt.nr.</b>
							           			<div>
							           			<p>Hver kunde kan ha 10 forskjellige avtaler (0-9).</p>
												Dersom det ikke tastes avtalenr forsøker systemet å hente fram avtale 0 for kunden.
												Har ikke kunden (selger-)avtale på det avtalenr som tastes, går systemet til "hvem belastes hva
							           			
							           			</div>
						           			</font>
										</span>
										</div>
		 							
		 							
		 							
		 							</td>
					 				<td class="text14">&nbsp;
					 					<img onMouseOver="showPop('hekdfs_info');" onMouseOut="hidePop('hekdfs_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 				<span title="hekdfs">Fakt.mot selger?</span>
						 				<div class="text11" style="position: relative;" align="left">
											<span style="position:absolute; left:0px; top:0px; width:250px" id="hekdfs_info" class="popupWithInputText"  >
												<font class="text11">
							           			<b>Fakt.mot selger ?</b>
							           			<div>
							           			<p>Tast en <b>X</b> i dette feltet dersom du ønsker at selger ikke skal faktureres. 
							           			En <b>E</b> i feltet vil medføre at selgers avtale blir benyttet, ikke selgers fakturamottagers avtale som er det vanlige. 
							           			En <b>B</b> i feltet vil medføre at "motpartens" (kjøpers/kjøpers fmots) avtale brukes.
							           			</p>
							           			</div>
						           			</font>
										</span>
										</div>
					 				</td>
					 				<td class="text14" width="100px">&nbsp;</td>
					 			</tr>
								<tr>	
				 					<td class="text14" >
				 						<input type="text" class="inputTextMediumBlueUPPERCASE" name="heads2" id="heads2" size="25" maxlength="30" value="${model.record.heads2}">
				 					</td>
				 					<td class="text14"><input type="text" class="inputTextMediumBlue" name="heads3" id="heads3" size="25" maxlength="30" value="${model.record.heads3}"></td>
				 					<td class="text14">
				 						<select class="inputText" name="heans" id="heans" >
				 							  <option value="0" <c:if test="${ empty model.record.heans || model.record.heans == '0' }"> selected </c:if> >0</option>
											  <option value="1" <c:if test="${ model.record.heans == '1' }"> selected </c:if> >1</option>
											  <option value="2" <c:if test="${ model.record.heans == '2' }"> selected </c:if> >2</option>
											  <option value="3" <c:if test="${ model.record.heans == '3' }"> selected </c:if> >3</option>
											  <option value="4" <c:if test="${ model.record.heans == '4' }"> selected </c:if> >4</option>
											  <option value="5" <c:if test="${ model.record.heans == '5' }"> selected </c:if> >5</option>
											  <option value="6" <c:if test="${ model.record.heans == '6' }"> selected </c:if> >6</option>
											  <option value="7" <c:if test="${ model.record.heans == '7' }"> selected </c:if> >7</option>
											  <option value="8" <c:if test="${ model.record.heans == '8' }"> selected </c:if> >8</option>
											  <option value="9" <c:if test="${ model.record.heans == '9' }"> selected </c:if> >9</option>
										</select>
				 					</td>
				 					<td class="text14">
				 						<select class="inputText" name="hekdfs" id="hekdfs" >
				 							  <option value="" <c:if test="${ empty model.record.hekdfs }"> selected </c:if> >-velg-</option>	
						 					  <option value="X" <c:if test="${ model.record.hekdfs == 'X' }"> selected </c:if> >X</option>
											  <option value="E" <c:if test="${ model.record.hekdfs == 'E' }"> selected </c:if> >E</option>
											  <option value="B" <c:if test="${ model.record.hekdfs == 'B' }"> selected </c:if> >B</option>
											  
										</select>
				 					</td>
				 					<td class="text14" width="100px">&nbsp;</td>
				 				</tr>
				 				<tr height="5"><td ></td></tr>
				 				<tr>	
					 				<td class="text14">&nbsp;<span title="ownSenderContactName"><spring:message code="systema.tror.orders.form.update.label.shipper.contactName"/></span></td>
					 				<td class="text14">&nbsp;<span title="ownSenderMobile"><spring:message code="systema.tror.orders.form.update.label.shipper.mobile"/></span></td>
		 						</tr>
		 						<tr>	
				 					<td class="text14" >
				 						<input type="hidden" name="ownSenderPartId" id="ownSenderPartId" value='CN'>
				 						<input type="text" class="inputTextMediumBlue" name="ownSenderContactName" id="ownSenderContactName" size="25" maxlength="60" value="${model.record.ownSenderContactName}">
				 					</td>
				 					<td class="text14">
				 						<input type="text" class="inputTextMediumBlue" name="ownSenderMobile" id="ownSenderMobile" size="25" maxlength="60" value="${model.record.ownSenderMobile}">
				 					</td>
		 						</tr>	
		 						<tr>	
					 				<td class="text14">&nbsp;<span title="ownSenderEmail"><spring:message code="systema.tror.orders.form.update.label.shipper.email"/></span></td>
		 						</tr>
		 						<tr>	
				 					<td class="text14" >
				 						<input type="text" class="inputTextMediumBlue" name="ownSenderEmail" id="ownSenderEmail" size="25" maxlength="60" value="${model.record.ownSenderEmail}">
				 					</td>
		 						</tr>	
				 				
				 				<tr height="5"><td ></td></tr>	
				 				
				 																 				
								<tr>
				 					<td class="text12Bold">&nbsp;
				 						<img style="vertical-align: bottom;" width="24px" height="24px" src="resources/images/invoice.png" border="0" alt="invoice">
				 						<spring:message code="systema.tror.orders.form.update.label.shipper.invoicee"/>
			 						</td>
								</tr>
				 				<tr>
				 					<td colspan="4">
				 					<table class="tableBorderWithRoundCornersLightGray">
					 					<tr>
							 				<td class="text14">
							 					&nbsp;<span title="heknsf"><spring:message code="systema.tror.orders.form.update.label.shipper.invoicee.id"/>&nbsp;</span>
							 					<a tabindex="-1" id="trorSellerFmIdLink" >
		 											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 										</a>
							 				</td>
							 				<td class="text14">
							 					&nbsp;<span title="whenasf"><spring:message code="systema.tror.orders.form.update.label.shipper.invoicee.name"/>&nbsp;</span>
							 				</td>
							 				<td class="text14">
							 					<img onMouseOver="showPop('shipperCurr_info');" onMouseOut="hidePop('shipperCurr_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
								 				<span title="hevals"><spring:message code="systema.tror.orders.form.update.label.shipper.invoicee.currencyCode"/>&nbsp;</span>
								 				<div class="text11" style="position: relative;" align="left">
													<span style="position:absolute; left:0px; top:0px; width:250px" id="shipperCurr_info" class="popupWithInputText"  >
														<font class="text11">
									           			<b>Valuta</b>
									           			<div>
									           			<p>Valuta for fakturautstedelse - hentes fra kunderegister, kan overstyres. 
									           				Ved ulik NOK går fremmedvaluta inn i reskontro.
									           			</p>
									           			</div>
								           			</font>
												</span>
												</div>
							 				</td>
							 				
						 				</tr>
						 				<tr>	
						 					<td class="text14" >
						 						<c:choose>
						 						<c:when test="${'0' != model.record.heknsf}">
						 							<input type="text" class="inputTextMediumBlue" name="heknsf" id="heknsf" size="10" maxlength="8" value="${model.record.heknsf}">
						 						</c:when>
						 						<c:otherwise>
						 							<input type="text" class="inputTextMediumBlue" name="heknsf" id="heknsf" size="10" maxlength="8" value="">
						 						</c:otherwise>
						 						</c:choose>
						 					</td>
										 	<td class="text14" ><input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="whenasf" id="whenasf" size="50" value="${Xmodel.record.heknsfNavn} - ${Xmodel.record.heknsfPnSt}"></td>
						 					<td class="text14" >
						 						<select class="inputText" name="hevals" id="hevals">
							 						<option value="">-valuta-</option>
								 				  	<c:forEach var="record" items="${model.currencyCodeList}" >
								 				  		<option value="${record.kvakod}"<c:if test="${model.record.hevals == record.kvakod || (empty model.record.hevals && record.kvakod=='NOK')}"> selected </c:if> >${record.kvakod}</option>
													</c:forEach>  
												</select>
						 					</td>
						 					
					 					</tr>
									</table>
									</td>				 				
					 			</tr>
				 				<tr height="10"><td ></td></tr>
							 </table>
						 	</td>
						 	<td valign="top" width="50%">
				 			 <table style="width:97%" class="tableBorderWithRoundCornersGray" cellspacing="2" cellpadding="0">
					 			<tr height="10"><td ></td></tr>
						 		<tr>
					 				<td class="text14">
					 					&nbsp;<span title="heknk"><spring:message code="systema.tror.orders.form.update.label.consignee.id"/>&nbsp;</span>
					 					<a tabindex="-1" id="trorBuyerIdLink" >
 											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
 										</a>
					 				</td>
					 				<td class="text14">
					 					&nbsp;<span title="whenak"><spring:message code="systema.tror.orders.form.update.label.consignee.buyer"/>&nbsp;</span>
					 				</td>	
					 			</tr>
					 			<tr>	
				 					<td class="text14">
				 						<c:choose>
						 				<c:when test="${'0' != model.record.heknk}">
				 							<input type="text" class="inputTextMediumBlue" name="heknk" id="heknk" size="10" maxlength="8" value="${model.record.heknk}">
				 						</c:when>
				 						<c:otherwise>
				 							<input type="text" class="inputTextMediumBlue" name="heknk" id="heknk" size="10" maxlength="8" value="">
				 						</c:otherwise>
				 						</c:choose>
				 					</td>
				 					<td colspan="4" class="text14" ><input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="whenak" id="whenak" size="50" value="${Xmodel.record.heknkNavn}&nbsp;-&nbsp;${Xmodel.record.heknkPnSt}"></td>
				 				</tr>
				 				<tr height="5"><td ></td></tr>
						 		<tr>
					 				<td class="text14">&nbsp;<font class="text16RedBold" >*</font><span title="henak"><spring:message code="systema.tror.orders.form.update.label.consignee.name"/></span>
					 					<%-- <c:if test="${Xmodel.record.fakBetExists}">
						 					<a href="javascript:void(0);" onClick="window.open('tror_childwindow_customer_addresses.do?action=doFind&ctype=c&wkundnr=${user.custNr}','customerWin','top=300px,left=150px,height=800px,width=900px,scrollbars=no,status=no,location=no')">
		 										<img id="imgConsigneeSearch" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 									</a>
	 									</c:if> --%>
	 									<a tabindex="-1" id="trorBuyerAddressesIdLink" >
											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
										</a>
					 				</td>
					 				<td class="text14">&nbsp;<font class="text16RedBold" >*</font><span title="headk1"><spring:message code="systema.tror.orders.form.update.label.consignee.adr1"/></span></td>
					 			</tr>
					 			<tr>	
				 					<td class="text14"><input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="henak" id="henak" size="25" maxlength="30" value="${model.record.henak}"></td>
				 					<td class="text14"><input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="headk1" id="headk1" size="25" maxlength="30" value="${model.record.headk1}"></td>
				 				</tr>
					 			<tr>	
					 				<td class="text14">&nbsp;<span title="headk2"><spring:message code="systema.tror.orders.form.update.label.consignee.adr2"/></span></td>
					 				<td class="text14">&nbsp;<span title="headk3"><spring:message code="systema.tror.orders.form.update.label.consignee.adr3"/></span></td>
					 				<td class="text14">
					 					<img onMouseOver="showPop('heank_info');" onMouseOut="hidePop('heank_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 				<span title="heank">Avt.nr.</span>
						 				<div class="text11" style="position: relative;" align="left">
											<span style="position:absolute; left:0px; top:0px; width:250px" id="heank_info" class="popupWithInputText"  >
												<font class="text11">
							           			<b>Avt.nr.</b>
							           			<div>
							           			<p>Hver kunde kan ha 10 forskjellige avtaler (0-9).</p>
												Dersom det ikke tastes avtalenr forsøker systemet å hente fram avtale 0 for kunden.
												Har ikke kunden (selger-)avtale på det avtalenr som tastes, går systemet til "hvem belastes hva
							           			
							           			</div>
						           			</font>
										</span>
										</div>
					 				</td>
					 				<td class="text14">&nbsp;
					 					<img onMouseOver="showPop('hekdfk_info');" onMouseOut="hidePop('hekdfk_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 				<span title="hekdfk">Fakt.mot selger?</span>
						 				<div class="text11" style="position: relative;" align="left">
											<span style="position:absolute; left:0px; top:0px; width:250px" id="hekdfk_info" class="popupWithInputText"  >
												<font class="text11">
							           			<b>Fakt.mot Kjøper ?</b>
							           			<div>
							           			<p>Tast en <b>X</b> i dette feltet dersom du ønsker at kjøper ikke skal faktureres. 
							           			En <b>E</b> i feltet vil medføre at kjøpers avtale blir benyttet, ikke selgers fakturamottagers avtale som er det vanlige. 
							           			En <b>B</b> i feltet vil medføre at "motpartens" (selgers/kjøpers fmots) avtale brukes.
							           			</p>
							           			</div>
						           			</font>
										</span>
										</div>
					 				</td>
					 				<td class="text14" width="100px">&nbsp;</td>
					 				
					 			</tr>
								<tr>	
				 					<td class="text14"><input type="text" class="inputTextMediumBlue" name="headk2" id="headk2" size="25" maxlength="30" value="${model.record.headk2}"></td>
				 					<td class="text14"><input type="text" class="inputTextMediumBlue" name="headk3" id="headk3" size="25" maxlength="30" value="${model.record.headk3}"></td>
				 					
					 				<td class="text14">
				 						<select class="inputText" name="heank" id="heank" >
				 							  <option value="0" <c:if test="${ empty model.record.heank || model.record.heank == '0' }"> selected </c:if> >0</option>
											  <option value="1" <c:if test="${ model.record.heank == '1' }"> selected </c:if> >1</option>
											  <option value="2" <c:if test="${ model.record.heank == '2' }"> selected </c:if> >2</option>
											  <option value="3" <c:if test="${ model.record.heank == '3' }"> selected </c:if> >3</option>
											  <option value="4" <c:if test="${ model.record.heank == '4' }"> selected </c:if> >4</option>
											  <option value="5" <c:if test="${ model.record.heank == '5' }"> selected </c:if> >5</option>
											  <option value="6" <c:if test="${ model.record.heank == '6' }"> selected </c:if> >6</option>
											  <option value="7" <c:if test="${ model.record.heank == '7' }"> selected </c:if> >7</option>
											  <option value="8" <c:if test="${ model.record.heank == '8' }"> selected </c:if> >8</option>
											  <option value="9" <c:if test="${ model.record.heank == '9' }"> selected </c:if> >9</option>
										</select>
				 					</td>
				 					<td class="text14">
				 						<select class="inputText" name="hekdfk" id="hekdfk" >
				 							  <option value="" <c:if test="${ empty model.record.hekdfk }"> selected </c:if> >-velg-</option>	
						 					  <option value="X" <c:if test="${ model.record.hekdfk == 'X' }"> selected </c:if> >X</option>
											  <option value="E" <c:if test="${ model.record.hekdfk == 'E' }"> selected </c:if> >E</option>
											  <option value="B" <c:if test="${ model.record.hekdfk == 'B' }"> selected </c:if> >B</option>
										</select>
				 					</td>
				 					<td class="text14" width="100px">&nbsp;</td>
					 				
				 				</tr>
				 				<tr height="5"><td ></td></tr>
				 				<tr>	
					 				<td class="text14">&nbsp;<span title="ownReceiverContactName"><spring:message code="systema.tror.orders.form.update.label.consignee.contactName"/></span></td>
					 				<td class="text14">&nbsp;<span title="ownReceiverMobile"><spring:message code="systema.tror.orders.form.update.label.consignee.mobile"/></span></td>
		 						</tr>
		 						<tr>	
				 					<td class="text14" >
				 						<input type="hidden" name="ownReceiverPartId" id="ownReceiverPartId" value='CZ'>
				 						<input type="text" class="inputTextMediumBlue" name="ownReceiverContactName" id="ownReceiverContactName" size="25" maxlength="60" value="${model.record.ownReceiverContactName}">
				 					</td>
				 					<td class="text14">
				 						<input type="text" class="inputTextMediumBlue" name="ownReceiverMobile" id="ownReceiverMobile" size="25" maxlength="60" value="${model.record.ownReceiverMobile}">
				 					</td>
		 						</tr>	
		 						<tr>	
					 				<td class="text14">&nbsp;<span title="ownReceiverEmail"><spring:message code="systema.tror.orders.form.update.label.consignee.email"/></span></td>
		 						</tr>
		 						<tr>	
				 					<td class="text14" >
				 						<input type="text" class="inputTextMediumBlue" name="ownReceiverEmail" id="ownReceiverEmail" size="25" maxlength="60" value="${model.record.ownReceiverEmail}">
				 					</td>
		 						</tr>	
				 				<tr height="5"><td ></td></tr>
				 				
				 				
								<tr>
				 					<td class="text12Bold">&nbsp;
				 						<img style="vertical-align: bottom;" width="24px" height="24px" src="resources/images/invoice.png" border="0" alt="invoice">
				 						<spring:message code="systema.tror.orders.form.update.label.consignee.invoicee"/>
				 					</td>
								</tr>
				 				<tr>
				 					<td colspan="4">
				 					<table class="tableBorderWithRoundCornersLightGray">
					 					<tr>
							 				<td class="text14">
							 					&nbsp;<span title="heknkf"><spring:message code="systema.tror.orders.form.update.label.consignee.invoicee.id"/>&nbsp;</span>
						 						<a tabindex="-1" id="trorBuyerFmIdLink" >
		 											<img align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
		 										</a>
							 				</td>
							 				<td class="text14">
							 					&nbsp;<span title="whenakf"><spring:message code="systema.tror.orders.form.update.label.consignee.invoicee.name"/>&nbsp;</span>
							 				</td>
							 				<td class="text14">
							 					<img onMouseOver="showPop('consigneeCurr_info');" onMouseOut="hidePop('consigneeCurr_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
								 				<span title="hevalk"><spring:message code="systema.tror.orders.form.update.label.consignee.invoicee.currencyCode"/>&nbsp;</span>
								 				<div class="text11" style="position: relative;" align="left">
													<span style="position:absolute; left:0px; top:0px; width:250px" id="consigneeCurr_info" class="popupWithInputText"  >
														<font class="text11">
									           			<b>Valuta</b>
									           			<div>
									           			<p>Valuta for fakturautstedelse - hentes fra kunderegister, kan overstyres. 
									           				Ved ulik NOK går fremmedvaluta inn i reskontro.
									           			</p>
									           			</div>
								           			</font>
												</span>
												</div>
							 				</td>
						 				</tr>
						 				<tr>	
						 					<td class="text14" >
						 						<c:choose>
						 						<c:when test="${'0' != model.record.heknkf}">
						 							<input type="text" class="inputTextMediumBlue" name="heknkf" id="heknkf" size="10" maxlength="8" value="${model.record.heknkf}">
						 						</c:when>
						 						<c:otherwise>
						 							<input type="text" class="inputTextMediumBlue" name="heknkf" id="heknkf" size="10" maxlength="8" value="">
						 						</c:otherwise>
						 						</c:choose>
						 					</td>
										 	<td class="text14" ><input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="whenakf" id="whenakf" size="50" value="${Xmodel.record.heknkfNavn} - ${Xmodel.record.heknkfPnSt}"></td>
						 					<td class="text14" >
						 						<select class="inputText" name="hevalk" id="hevalk">
							 						<option value="">-valuta-</option>
								 				  	<c:forEach var="record" items="${model.currencyCodeList}" >
								 				  		<option value="${record.kvakod}"<c:if test="${model.record.hevalk == record.kvakod || (empty model.record.hevalk && record.kvakod=='NOK')}"> selected </c:if> >${record.kvakod}</option>
													</c:forEach>  
												</select>
						 					</td>
					 					</tr>
									</table>
									</td>				 				
					 			</tr>
					 						 
				 				<tr height="10"><td ></td></tr>
			 				</table>
						 	</td>
					 	</tr>
					 	<tr height="10"><td ></td></tr>
					 </table>
				</td>
			</tr>
			<tr>
            		<td>
	        			<table style="width:98%;" align="left" class="tableBorderWithRoundCornersGray" cellspacing="0" cellpadding="0">
				 		<tr height="5"><td colspan="2" ></td></tr>
				 		<tr>
							<td valign="top" style="width:50%;border-right:1px solid;border-color:#FFFFFF;""  >
								<table>
						 		<tr height="2"><td ></td></tr>
							 	<tr>	
						 			<td class="text14">
						 				<img onMouseOver="showPop('helka_info');" onMouseOut="hidePop('helka_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 				<font class="text12RedBold" >*</font><span title="helka/hesdf"><spring:message code="systema.tror.orders.form.update.label.from"/>&nbsp;</span>
						 				<div class="text11" style="position: relative;" align="left">
											<span style="position:absolute;top:0px; width:250px" id="helka_info" class="popupWithInputText"  >
												<font class="text11">
							           			<b>Fra sted</b>
							           			<div>
							           			<p>Landkode + postnr / kode for "kundefraktens" frasted. Ved IKKE postnr.basert er det kun ett kodefelt (5 langt)
												</p>
							           			</div>
						           			</font>
										</span>
										</div>
				 					</td>
					 				<td class="text14">
					 					<select required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" class="inputTextMediumBlueMandatoryField" name="helka" id="helka">
					 						<option value="">-landkode-</option>
					 						<c:forEach var="record" items="${model.countryCodeList}" >
						 				  		<option value="${record.klklk}"<c:if test="${model.record.helka == record.klklk}"> selected </c:if> >${record.klklk}</option>
											</c:forEach>  
											
										</select>
										
					 				</td>
						 			<td class="text14" nowrap>
						 				<input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="hesdf" id="hesdf" size="6" maxlength="5" value="${model.record.hesdf}">
						 				<a tabindex=0 id="hesdfIdLink">
	 										<img id="imgFromSearch" align="bottom" style="cursor:pointer;" src="resources/images/find.png" width="13px" height="13px" border="0" alt="search">
	 									</a>
					 				</td>
					 				<td class="text14" colspan="2">
						 				<input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="OWNwppns1" id="OWNwppns1" size="20" maxlength="35" value="${XXmodel.record.wppns1}">
					 				</td>
					 				<td class="text11">&nbsp;&nbsp;</td>
					 			</tr>
					 				 			
							 	</table>
							</td>
							<td align="left">
							<table >
								<tr>
									<td colspan="4">
									<table>
							 			<tr>	
								 			<td class="text11">
								 				<img onMouseOver="showPop('hetri_info');" onMouseOut="hidePop('hetri_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
								 				<font class="text12RedBold" >*</font><span title="hetri/hesdt"><spring:message code="systema.tror.orders.form.update.label.to"/></span>
								 				<div class="text11" style="position: relative;" align="left">
													<span style="position:absolute;top:0px; width:250px" id="hetri_info" class="popupWithInputText"  >
														<font class="text11">
									           			<b>Til sted</b>
									           			<div>
									           			<p>Landkode + postnr / kode for "kundefraktens" tilsted. Ved IKKE postnr.basert er det kun ett kodefelt (5 langt).
														</p>
									           			</div>
								           			</font>
												</span>
												</div>
							 				</td>
							 				<td class="text14">
							 					<%--
							 					<select required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" class="inputTextMediumBlueMandatoryField" name="hetri" id="hetri">
							 						<option value="">-landkode-</option>
								 				  	<c:forEach var="record" items="${model.countryCodeList}" >
						 				  				<option value="${record.klklk}"<c:if test="${model.record.hetri == record.klklk}"> selected </c:if> >${record.klklk}</option>
													</c:forEach>  
												</select>
												 --%>
												 <%-- ALWAYS NORWAY(NO) --%>
												<input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="hetri" id="hetri" size="20" maxlength="35" value="NO">
							 				</td>
								 			<td class="text14" nowrap>
								 				<input type="text" required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" class="inputTextMediumBlueMandatoryField" name="hesdt" id="hesdt" size="6" maxlength="5" value="${model.record.hesdt}">
								 				<a tabindex=0 id="hesdtIdLink" >
			 										<img id="imgToSearch" align="bottom" style="cursor:pointer;" src="resources/images/find.png" width="13px" height="13px" border="0" alt="search">
			 									</a>
							 				</td>
											<td class="text14" colspan="2">
								 				<input readonly tabindex=-1 type="text" class="inputTextReadOnly" name="OWNwppns2" id="OWNwppns2" size="20" maxlength="35" value="${XXmodel.record.wppns2}">
							 				</td>
							 				<td class="text14">&nbsp;&nbsp;</td>
							 			</tr>			
							 		</table>
							 		</td>
							 	</tr>
							</table>
							</td>
						</tr>

						<tr height="6"><td colspan="2" ></td></tr>
						<tr height="1"><td colspan="2" style="border-bottom:1px solid;border-color:#FFFFFF;" class="text"></td></tr>
						<tr height="6"><td colspan="2" ></td></tr>
						<tr>
							<td colspan="10">
							<table width="100%" border="0">	
								<tr>
									<td align="left" width="100%" valign="top">
									<table class="tableBorderWithRoundCornersLightGray" border="0">
									<tr>
						 				<td class="text14">
						 					<img onMouseOver="showPop('heot_info');" onMouseOut="hidePop('heot_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 					<span title="heot"><spring:message code="systema.tror.orders.form.update.label.oppdragstype"/></span>
						 					<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_oppdragstype.do?action=doFind&ctype=flyexport','opptypeWin','top=300px,left=150px,height=600px,width=800px,scrollbars=no,status=no,location=no')">
	 											<img id="imgOpptype" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
	 										</a>
	 										<div class="text11" style="position: relative;" align="left">
												<span style="position:absolute;top:2px; width:250px" id="heot_info" class="popupWithInputText"  >
													<font class="text11">
								           			<b><spring:message code="systema.tror.orders.form.update.label.oppdragstype"/></b>
								           			<ul>
								           				<c:forEach var="record" items="${model.oppdragstypeList}" varStatus="counter">
								           					<li><font class="text10"><b>${record.ko1kod}</b>&nbsp;${record.ko1ntx}</font></li>
								           				</c:forEach>
								           			</ul>
							           			</font>
												</span>
											</div>
						 				</td>
							 			<td class="text14">
							 				<select class="inputText" name="heot" id="heot">
							 					<option value="" >-velg-</option>
							 					<c:forEach var="record" items="${model.oppdragstypeList}" varStatus="counter">
							 						<option title="${record.ko1ntx}" value='${record.ko1kod}' <c:if test="${record.ko1kod == model.record.heot}"> selected </c:if> >${record.ko1kod}</option>
							 						<c:set var="listSizeHeot" value="${counter.count}" scope="request" /> 
							 					</c:forEach>
											</select>
											
							 			</td>
										<td class="text14">
											<img onMouseOver="showPop('hefr_info');" onMouseOut="hidePop('hefr_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
						 					<span title="hefr"><spring:message code="systema.tror.orders.form.update.label.incoterms"/></span>
											<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_incoterms.do?action=doFind&ctype=flyexport','incotermsWin','top=300px,left=150px,height=600px,width=800px,scrollbars=no,status=no,location=no')">
	 											<img id="imgIncoterms" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
	 										</a>
	 										<div class="text11" style="position: relative;" align="left">
												<span style="position:absolute;top:2px; width:200px" id="hefr_info" class="popupWithInputText"  >
													<font class="text11">
								           			<b><spring:message code="systema.tror.orders.form.update.label.incoterms"/></b>
								           			<ul>
								           				<c:forEach var="record" items="${model.incotermsList}" varStatus="counter">
								           					<li><font class="text10"><b>${record.kfrkod}</b>&nbsp;${record.kfrntx}</font></li>
								           				</c:forEach>
								           			</ul>
							           			</font>
												</span>
											</div>
										</td>
							 			<td class="text14">
							 				<select class="inputText" name="hefr" id="hefr">
							 					<option value="" >-velg-</option>
							 					<c:forEach var="record" items="${model.incotermsList}" varStatus="counter">
							 						<option value='${record.kfrkod}' <c:if test="${record.kfrkod == model.record.hefr}"> selected </c:if> >${record.kfrkod}</option>
							 						<c:set var="listSizeHefr" value="${counter.count}" scope="request" />
							 					</c:forEach>
							 					
											</select>
							 			</td>
							 			<%--
										<td class="text14">
											<img onMouseOver="showPop('hekdpl_info');" onMouseOut="hidePop('hekdpl_info');"style="vertical-align:middle;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
											<span title="hekdpl"><spring:message code="systema.tror.orders.form.update.label.productcode"/></span>
											<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_productcodes.do?action=doFind&ctype=flyexport','customerWin','top=300px,left=150px,height=600px,width=800px,scrollbars=no,status=no,location=no')">
	 											<img id="imgProductcodes" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="13px" width="13px" border="0" alt="search">
	 										</a>
	 										<div class="text11" style="position: relative;" align="left">
												<span style="position:absolute;top:2px; width:200px" id="hekdpl_info" class="popupWithInputText"  >
													<font class="text11">
								           			<b><spring:message code="systema.tror.orders.form.update.label.productcode"/></b>
								           			<ul>
								           				<c:forEach var="record" items="${model.produktList}" varStatus="counter">
								           					<li><font class="text10"><b>${record.kfkod}</b>&nbsp;${record.kftxt}</font></li>
								           				</c:forEach>
								           			</ul>
							           			</font>
												</span>
											</div>
	 										
										</td>
							 			<td class="text14">
							 				<select class="inputText" name="hekdpl" id="hekdpl">
							 					<option value="" >-velg-</option>
							 					<c:forEach var="record" items="${model.produktList}" varStatus="counter">
							 						<option value='${record.kfkod}' <c:if test="${record.kfkod == model.record.hekdpl}"> selected </c:if> >${record.kfkod}</option>
							 					</c:forEach>
											</select>
							 			</td>
							 			--%> 
									<td class="text14" width="50px">&nbsp;</td>
										
							    		<td class="text14" title="hepk3">&nbsp;<spring:message code="systema.tror.orders.form.update.label.henteorder"/></td>
							    		<td class="text14">
							    			<select class="inputText" name="hepk3" id="hepk3" >
							 				  <option value="">-velg-</option>
											  <option value="J"<c:if test="${model.record.hepk3 == 'J'}"> selected </c:if> >Ja</option>
											  <option value="N"<c:if test="${model.record.hepk3 == 'N'}"> selected </c:if> >Nei</option>
											  <option value="P"<c:if test="${model.record.hepk3 == 'P'}"> selected </c:if> >P</option>
											</select>
						    			</td>
							    			
						    			<td class="text14" title="hepk6">&nbsp;<spring:message code="systema.tror.orders.form.update.label.tolldekl"/></td>
							    		<td class="text14">
							    			<select class="inputText" name="hepk6" id="hepk6" >
							 				  <option value="">-velg-</option>
											  <option value="J"<c:if test="${model.record.hepk6 == 'J'}"> selected </c:if> >Ja</option>
											  <option value="N"<c:if test="${model.record.hepk6 == 'N'}"> selected </c:if> >Nei</option>
											  <option value="P"<c:if test="${model.record.hepk6 == 'P'}"> selected </c:if> >P</option>
											</select>
						    			</td>
						    			<td class="text14" title="hepk8">&nbsp;<spring:message code="systema.tror.orders.form.update.label.flyfraktbrev"/></td>
							    		<td class="text14">
							    			<select class="inputText" name="hepk8" id="hepk8" >
							 				  <option value="">-velg-</option>
											  <option value="J"<c:if test="${model.record.hepk8 == 'J'}"> selected </c:if> >Ja</option>
											  <option value="N"<c:if test="${model.record.hepk8 == 'N'}"> selected </c:if> >Nei</option>
											  <option value="P"<c:if test="${model.record.hepk8 == 'P'}"> selected </c:if> >P</option>
											</select>
						    			</td>
						 			
							 			<%-------------------------- --%>
							 			<%-- START Fraktbrev section --%>
							 			<%-------------------------- --%>
							 			<td class="text14">&nbsp;&nbsp;
							 				<img onMouseOver="showPop('fraktbrev_info');" onMouseOut="hidePop('fraktbrev_info');"style="vertical-align:bottom;" width="12px" height="12px" src="resources/images/info3.png" border="0" alt="info">
							 				<span title="hepk1"><b><spring:message code="systema.tror.orders.form.update.label.fraktbrev"/></b></span>
							 				<div class="text14" style="position: relative;" align="left">
												<span style="position:absolute; left:0px; top:0px; width:450px" id="fraktbrev_info" class="popupWithInputText"  >
													<font class="text11">
								           			<b>Fraktbrev</b>
								           			<div>
								           				todo
								           			</div>
							           			</font>
											</span>
											</div>
							 			</td>
							 			<td class="text14">
							 				<a tabindex=-1 id="fraktbrevRenderPdfLink" name="fraktbrevRenderPdfLink" target="_new" href="transportdisp_mainorderlist_renderFraktbrev.do?user=${user.user}&wsavd=${model.record.heavd}&wsopd=${model.record.heopd}&wstoll=${Xmodel.record.dftoll}">
		    									<img id="imgFraktbrevPdf" title="Fraktbr.PDF" style="vertical-align:middle;" src="resources/images/pdf.png" width="16" height="16" border="0" alt="Fraktbr. PDF">
											</a>
										</td>
							 			<td nowrap class="text14">
							 				<select class="inputText" name="hepk1" id="hepk1" >
							 				  <option value="">-velg-</option>
											  <option value="J"<c:if test="${model.record.hepk1 == 'J'}"> selected </c:if> >Ja</option>
											  <option value="N"<c:if test="${model.record.hepk1 == 'N'}"> selected </c:if> >Nei</option>
											  <option value="P"<c:if test="${model.record.hepk1 == 'P'}"> selected </c:if> >P</option>
											</select>
											
							 				<%--
							 				<input type="checkbox" id="hepk1" name="hepk1" value="J" <c:if test="${model.record.hepk1 == 'J'}"> checked </c:if>>
							 				<input readonly type="text" class="inputText11ReadOnly" size="1" maxlength="1" name="hepk1RO" id="hepk1RO" value="${model.record.hepk1}">
							 				 --%>
							 			</td>
							 			<%--
							 			<td nowrap class="text14">&nbsp;&nbsp;<span title="dftoll"><spring:message code="systema.tror.orders.form.update.label.tollsted"/></span>
							 				<a tabindex=0 id="dftollIdLink" >
	 											<img id="imgToSearch" align="bottom" style="cursor:pointer;" src="resources/images/find.png" width="13px" height="13px" border="0" alt="search">
	 										</a>
							 			</td>
							 			<td class="text14">
							 				<input onKeyPress="return numberKey(event)" type="text" class="inputTextMediumBlue" size="5" maxlength="4" name="dftoll" id="dftoll" value="${Xmodel.record.dftoll}">
							 			</td>
							 			
							 			<td class="text14">&nbsp;&nbsp;<span title="todo"><spring:message code="systema.tror.orders.form.update.label.merkelapp"/></span></td>
							 			<td nowrap class="text14">
							 				<input type="checkbox" id="todo" name="todo" value="S" <c:if test="${Xmodel.record.dfkdme == 'S'}"> checked </c:if>>
							 				
						 				</td>
							 			<td class="text14">&nbsp;<span title="todo"><spring:message code="systema.tror.orders.form.update.label.etterkrav"/></span></td>
							 			<td nowrap class="text14">
							 				<input type="checkbox" id="todo" name="todo" value="S" <c:if test="${Xmodel.record.dfkdme == 'S'}"> checked </c:if>>
						 				</td>
						 				<td class="text14">&nbsp;<span title="hentvs"><spring:message code="systema.tror.orders.form.update.label.antalVarelinjer"/></span></td>
						 				<td class="text14">
							 				<input onKeyPress="return numberKey(event)" type="text" class="inputTextMediumBlue" size="5" maxlength="3" name="hentvs" id="hentvs" value="${model.record.hentvs}">
							 			</td>
							 			<td>&nbsp;</td>
							 			 --%>
							 			<%------------------------ --%>
							 			<%-- END Fraktbrev section --%>
							 			<%------------------------ --%>
							 		
							 		<%-- CMR --%>
							 		<td class="text14" title="hepk7">&nbsp;<spring:message code="systema.tror.orders.form.update.label.cmr"/></td>
							    		<td class="text14">
							    			<select class="inputText" name="hepk7" id="hepk7" >
							 				  <option value="">-velg-</option>
											  <option value="C"<c:if test="${model.record.hepk7 == 'C'}"> selected </c:if> >Ja -Bilfraktb.</option>
											  <option value="B"<c:if test="${model.record.hepk7 == 'B'}"> selected </c:if> >Ja -Bill of lading</option>
											  <option value="P"<c:if test="${model.record.hepk7 == 'P'}"> selected </c:if> >P</option>
											</select>
						    			</td>
						    			
						    			<td class="text14" width="20px">&nbsp;</td>
						    			<%-- Lager --%>
							 		<td class="text14" title="hekdl">&nbsp;<spring:message code="systema.tror.orders.form.update.label.lager"/></td>
							    		<td class="text14">
							    			<input  type="text" class="inputTextMediumBlue" name="hekdl" id="hekdl" size="15" maxlength="15" value="${model.record.hekdl}">
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
			            		<td>
				        			<table width="98%" id="containerdatatableTable" cellspacing="0" align="left" >
			
									<%-- <c:if test="${not empty Xmodel.record.heunik}"> --%>
										<tr height="5"><td align="left" ></td></tr>
										
								 		<tr >
											<td align="bottom" colspan="3" class="text14">&nbsp;&nbsp;<img style="vertical-align:bottom;" src="resources/images/update.gif" width="10px" height="10px" border="0" alt="update item line">
											&nbsp;<spring:message code="systema.tror.orders.form.detail.update.label.itemLine"/>
											</td>
										</tr>
								 		<tr>
											<td colspan="2" style="padding: 0px;">
												<table align="left" border="0" style="width:100%;" >
												<tr class="tableHeaderField" >
													
										 			<td align="left" valign="bottom" class="tableHeaderFieldFirst"><span title="hegm1/hegm2">&nbsp;<spring:message code="systema.tror.orders.form.detail.update.label.marks"/></span></td>
										 			<td align="right" valign="bottom" class="tableHeaderField"><span title="hent">&nbsp;<font class="text12RedBold" >*</font><spring:message code="systema.tror.orders.form.detail.update.label.antal"/>&nbsp;</span></td>
										 			<td align="center" valign="bottom" class="tableHeaderField"><span title="ownEnhet1/ownEnhet2">&nbsp;<spring:message code="systema.tror.orders.form.detail.update.label.forpak"/></span></td>
										 			<td align="left" valign="bottom" class="tableHeaderField"><span title="hevs1/hevs2">&nbsp;<font class="text12RedBold" >*</font><spring:message code="systema.tror.orders.form.detail.update.label.goodsDesc"/></span></td>
										 			<td align="right" valign="bottom" class="tableHeaderField"><span title="hevkt">&nbsp;<font class="text12RedBold" >*</font><spring:message code="systema.tror.orders.form.detail.update.label.weight"/>&nbsp;</span></td>
										 			<td align="right" valign="bottom" class="tableHeaderField"><span title="hem3">&nbsp;<spring:message code="systema.tror.orders.form.detail.update.label.m3"/>&nbsp;</span></td>
										 			<td align="right" valign="bottom" class="tableHeaderField"><span title="helm">&nbsp;<spring:message code="systema.tror.orders.form.detail.update.label.lm.fa"/>&nbsp;</span></td>
										 		</tr>
										 		<tr class="tableRow">
										 			<td align="left" class="tableCell" nowrap>
									 					<input type="text" class="inputTextMediumBlue" name="hegm1" id="hegm1" size="16" maxlength="15" value="${model.record.hegm1}">
									 				</td>
									 				<td align="right" class="tableCell" nowrap>
										 				<input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" onKeyPress="return numberKey(event)" type="text" class="inputTextMediumBlueMandatoryField" style="text-align:right;" name="hent" id="hent" size="8" maxlength="7" value="${model.record.hent}">
									 				</td>
									 				<td align="center" class="tableCell" nowrap>
										 				<select class="inputText" name="ownEnhet1" id="ownEnhet1">
										 					<option value="" >-velg-</option>
										 					<c:forEach var="record" items="${model.enhetList}" varStatus="counter">
										 						<c:choose>
											 						<c:when test="${not empty model.uom1}" >
											 							<option value='${record.tkkode}' <c:if test="${ model.uom1 == record.tkkode }"> selected </c:if> >${record.tkkode}</option>
											 						</c:when>
											 						<c:otherwise>
											 							<option value='${record.tkkode}'>${record.tkkode}</option>
											 						</c:otherwise>
										 						</c:choose>
										 					</c:forEach>
														</select>
														
														<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_unitcodes.do?action=doFind&ctype=tror_flyexport_e1','unitWin','top=300px,left=150px,height=600px,width=800px,scrollbars=no,status=no,location=no')">
				 											<img id="imgTransporttype" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="12px" width="12px" border="0" alt="search">
				 										</a>
														
									 				</td>
									 				<td align="left" class="tableCell" nowrap>
									 					<fmt:parseNumber scope="request" var="uom1Length" type="number" value="${model.uom1Length}" />
									 					<c:choose>
										 					<c:when test="${not empty model.uom1 && not empty model.record.hevs1 && fn:length(model.record.hevs1) > uom1Length}" >
										 						<input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="hevs1" id="hevs1" size="30" maxlength="25" value="${ fn:substring(model.record.hevs1, uom1Length, fn:length(model.record.hevs1)) }">		
										 					</c:when>
										 					<c:otherwise>
										 						<input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" type="text" class="inputTextMediumBlueMandatoryField" name="hevs1" id="hevs1" size="30" maxlength="25" value="${ model.record.hevs1 }">
										 					</c:otherwise>
									 					</c:choose>
									 				</td>
									 				<td align="right" class="tableCell" nowrap>
										 				<input required oninvalid="this.setCustomValidity('Obligatorisk')" oninput="setCustomValidity('')" onKeyPress="return numberKey(event)" type="text" class="inputTextMediumBlueMandatoryField" style="text-align:right;" name="hevkt" id="hevkt" size="10" maxlength="9" value="${model.record.hevkt}">
									 				</td>
									 				
									 				<td align="right" class="tableCell" nowrap>
										 				<input onFocus="calculateVolume(this);" onBlur="checkVolumeNewLine(this);" onKeyPress="return amountKey(event)" type="text" class="inputTextMediumBlue" style="text-align:right;" name="hem3" id="hem3" size="12" maxlength="11" value="${ fn:replace(model.record.hem3,'.',',') }">
									 				</td>
									 				<td align="right" class="tableCell" nowrap>
										 				<input onBlur="checkLmNewLine(this);validateNewItemLine();" onKeyPress="return amountKey(event)" type="text" class="inputTextMediumBlue" style="text-align:right;" name="helm" id="helm" size="8" maxlength="7" value="${ fn:replace(model.record.helm,'.',',') }"> 
									 				</td>
									 			</tr>
									 			<tr class="tableRow">
										 			<td align="left" class="tableCell" nowrap>
									 					<input type="text" class="inputTextMediumBlue" name="hegm2" id="hegm2" size="16" maxlength="15" value="${model.record.hegm2}">
									 				</td>
									 				<td align="right" class="tableCell" nowrap>&nbsp;</td>
									 				<td align="center" class="tableCell" >&nbsp;
									 					<%-- OBSOLETE ?
										 				<select name="ownEnhet2" id="ownEnhet2">
										 					<option value="" >-velg-</option>
										 					<c:forEach var="record" items="${model.enhetList}" varStatus="counter">
											 					<c:choose>
											 						<c:when test="${not empty model.record.hevs2 && fn:length(model.record.hevs2) > 2}" >
											 							<option value='${record.tkkode}' <c:if test="${ fn:substring(model.record.hevs2, 0, 2) == record.tkkode }"> selected </c:if> >${record.tkkode}</option>
											 						</c:when>
											 						<c:otherwise>
											 							<option value='${record.tkkode}' >${record.tkkode}</option>
											 						</c:otherwise>
										 						</c:choose>
									 						</c:forEach>
														</select>
														<a href="javascript:void(0);" onClick="window.open('tror_mainorder_childwindow_unitcodes.do?action=doFind&ctype=tror_flyimport_e2','unitWin','top=300px,left=150px,height=600px,width=800px,scrollbars=no,status=no,location=no')">
				 											<img id="imgTransporttype" align="bottom" style="cursor:pointer;" src="resources/images/find.png" height="12px" width="12px" border="0" alt="search">
				 										</a>
										 				 --%>
									 				</td>
									 				<td align="left" class="tableCell" nowrap>
									 					<c:choose>
										 					<c:when test="${not empty model.record.hevs2 && fn:length(model.record.hevs2) > 3}" >
										 						<input type="text" class="inputTextMediumBlue" name="hevs2" id="hevs2" size="30" maxlength="25" value="${ fn:substring(model.record.hevs2, 3, fn:length(model.record.hevs2)) }">		
										 					</c:when>
										 					<c:otherwise>
										 						<input type="text" class="inputTextMediumBlue" name="hevs2" id="hevs2" size="30" maxlength="25" value="${ model.record.hevs2 }">
										 					</c:otherwise>
									 					</c:choose>
									 					
									 				</td>
									 				<td align="right" class="tableCell" nowrap>&nbsp;</td>
									 				<td align="right" class="tableCell" nowrap>&nbsp;</td>
									 				<td align="right" class="tableCell" nowrap>&nbsp;</td>
									 			</tr>
									 			
									 			</table>
								 			</td>
							 			</tr>
							 			<%-- </c:if>  --%>
									<tr height="5"><td ></td></tr>
				 				</table>
			           		</td>
			            </tr>
						
						<tr>
							<td colspan="2">
								<table style="width:98%;">
								<tr>
									<td align="right">
					 				    <label class="text11Red" id="orderLineErrMsgPlaceHolder"></label>
				 				    </td>
									<td align="right">
										<c:choose>
						 				    <c:when test="${ not empty model.record.heopd }">
						 				    	<c:if test="${empty model.record.hest || model.record.hest == 'U' || model.record.hest == 'O' || model.record.hest == 'F' || model.record.hest == 'C' || model.record.hest == 'K' }">
						 				    		<input class="inputFormSubmit submitSaveClazz" type="submit" name="submit" id="submit" value='<spring:message code="systema.tror.submit.save"/>'/>
						 				    	</c:if>
						 				    	<c:if test="${model.record.hepk4 == 'J' }">
						 				    		<input class="inputFormSubmit submitSaveClazz" type="button" name="buttonToSad" id="buttonToSad" value='Til SAD'/>
						 				    	</c:if>
						 				    	
						 				    </c:when>
						 				    <c:otherwise>
					 				    		<input tabindex=-1 class="inputFormSubmit submitSaveClazz" type="submit" name="submitnew" id="submitnew" value='<spring:message code="systema.tror.submit.createnew.order"/>'/>
						 				    </c:otherwise>	
					 				    </c:choose>
				 				    </td>
							    </tr>
							    </table>
						    </td>
						</tr>
						
	 				</table>
	 				</form>
            		</td>
            </tr>
            <tr height="2"><td></td></tr>
            
			<tr height="10"><td ></td></tr>
			
			<%-- change status dialog --%>	
			 <tr>
				<td>
					<div id="dialogUpdateStatus" title="Dialog">
						 	<form action="tror_mainorderflyexport_updateStatus.do" name="updateStatusForm" id="updateStatusForm" >
						 	<input type="hidden" name="currentAvd" id="currentAvd" value='${model.record.heavd}'>
						 	<input type="hidden" name="currentOpd" id="currentOpd" value='${model.record.heopd}'>
							<p class="text14" >Change status as needed.</p>
							<table>
								<tr>
									<td class="text14" align="left" >
										Status
									</td>
									<td class="text12MediumBlue">
										<select class="inputText" name="selectedStatus" id="selectedStatus">
					            			<option value="">-vælg-</option>
					            			<option value=" ">Åpent</option>
					            			<option value="U">U</option>
											<option value="K">K</option>
											<option value="C">C</option>
											<option value="F">F</option>
											<option value="G">G</option>
											<option value="T">T</option>
											<option value="O">O</option>
											<option value="S">S</option>
											<option value="X">X</option>
											<option value="M">M</option>
										</select>	
									</td>
								</tr>
							</table>
							</form>
					</div>
				</td>
			</tr>

			
	</table>

		
<!-- ======================= footer ===========================-->
<jsp:include page="/WEB-INF/views/footer.jsp" />
<!-- =====================end footer ==========================-->
