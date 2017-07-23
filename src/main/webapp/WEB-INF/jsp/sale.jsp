<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sale Form</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/js/main.js"></script>
</head>
<body>
	<div class="conatiner" style=" margin-bottom: 2.5%">

		<jsp:include page="header.jsp"></jsp:include>

		<div class="container" id="section1" style="margin-left: initial;">

			<row> <jsp:include page="left_menu_sub.jsp"></jsp:include>
			<div class="col-md-9">
				<div class="col-md-12">
						<form:form id="sale_form" class="sale_form_class" method="POST"
						action="/saleForm" commandName="saleAttributes">
						<div id="sales_form" class="container-fluid">
							<div class="row text-center saleForm_head">
								<h3>Sale Form</h3>
							</div>
							<c:if test="${not empty fn:trim(errorMsg)}">
								<p class="text-center error_show">${errorMsg}</p>
							</c:if>
							<div class="row" style="margin-top: 5px">
								<div style="float: left">
									<p class="alert alert-info" style="margin-left: 12px">*
										indicates mandatory fields</p>
								</div>
								<div>
									<c:if test="${updateFlag == 'update'}">
										<form:label path="sale_party"
											style="padding:1px 0% 0% 20%;color: #FF6600;">
											<spring:message code="agreement_id" /> ${saId}
						</form:label>
									</c:if>
								</div>
							</div>
							<div class="row gropElements elementsBorder">

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="sale_party">
										<spring:message code="sale_party" />
									</form:label>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<form:input path="sale_party" id="sale_party"
												class="form-control" readonly="true" />
										</c:when>
										<c:otherwise>
											<form:input path="sale_party" id="sale_party" />
										</c:otherwise>
									</c:choose>
									<form:errors path="sale_party" cssClass="error" />
									<br />
								</div>
								<!-- dropdown - Buyer Seller-->
								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="agreement_type">
										<spring:message code="agreement_type" />
									</form:label>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<form:input path="agreement_type" id="agreement_type"
												class="form-control" readonly="true" />
										</c:when>
										<c:otherwise>
											<form:input path="agreement_type" id="agreement_type"
												readonly="true" value="${agreement_type}" />
											<form:errors path="agreement_type" cssClass="error" />
											<br />
										</c:otherwise>
									</c:choose>
								</div>

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="sale_phone">
										<spring:message code="sale_phone" />
									</form:label>
									<div class="input-group input-group-pNumber">
										<span class="input-group-addon pNumber">+91</span>
										<c:choose>
											<c:when test="${updateFlag == 'update'}">
												<form:input path="sale_phone" id="sale_phone"
													class="form-control" readonly="true" />
											</c:when>
											<c:otherwise>
												<form:input path="sale_phone" id="sale_phone"
													class="form-control" />
												<form:errors path="sale_phone" cssClass="error" />
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>

							<div class="row gropElements elementsBorder">
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-6 col-lg-6 address_section">
										<form:label path="sale_address1">
											<spring:message code="sale_address1" />
										</form:label>
										<form:input path="sale_address1" id="sale_address1" />
										<form:errors path="sale_address1" cssClass="error" />
										<br />
									</div>
									<div
										class="col-xm-12 col-sm-12 col-md-6 col-lg-6 address_section">
										<form:label path="sale_address2">
											<spring:message code="sale_address2" />
										</form:label>
										<form:input path="sale_address2" id="sale_address2" />
										<form:errors path="sale_address2" cssClass="error" />
										<br />
									</div>
								</div>
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="sale_area">
											<spring:message code="sale_area" />
										</form:label>
										<form:input path="sale_area" id="sale_area" />
										<form:errors path="sale_area" cssClass="error" />
										<br />
									</div>

									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="sale_city">
											<spring:message code="sale_city" />
										</form:label>
										<form:input path="sale_city" id="sale_city" />
										<form:errors path="sale_city" cssClass="error" />
										<br />
									</div>
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="sale_state">
											<spring:message code="sale_state" />
										</form:label>
										<form:input path="sale_state" id="sale_state" />
										<form:errors path="sale_state" cssClass="error" />
										<br />
									</div>
								</div>
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="sale_postal">
											<spring:message code="sale_postal" />
										</form:label>
										<form:input path="sale_postal" id="sale_postal" />
										<form:errors path="sale_postal" cssClass="error" />
										<br />
									</div>
								</div>
							</div>


							<div class="row gropElements elementsBorder">

								<!-- dropdown - Commercial/Residential/Agricultural -->
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="usage">
											<spring:message code="usage" />
										</form:label>
										<form:select path="usage" id="usage" value="usage">
											<form:option value="" label="Select..." />
											<form:option value="C">Commerical</form:option>
											<form:option value="R">Residential</form:option>
											<form:option value="O">Other</form:option>
										</form:select>
										<form:errors path="usage" cssClass="error" />
										<br />
									</div>

									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4 pArea_height">
										<form:label path="s_prop_area">
											<spring:message code="s_prop_area" />
										</form:label>
										<form:input path="s_prop_area" id="s_prop_area"
											class="form-control" />
										<form:errors path="s_prop_area" cssClass="error" />
										<br />
									</div>
                                    <div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="prop_type">
											<spring:message code="prop_type" />
										</form:label>
										<form:select path="prop_type" id="prop_type" value="${prop_type.title}">
										    <form:option value="" label="Select..." />
											<form:option value="F">FLAT</form:option>
											<form:option value="P">PLOT</form:option>
											<form:option value="B">BUILDING WITH MULTIPLE PORTIONS</form:option>
											<form:option value="O">OTHER</form:option>
										</form:select>
										<form:errors path="prop_type" cssClass="error" />
										<br />
									</div>

								</div>
								<div class="row address_section_row">
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="sale_amount">
											<spring:message code="sale_amount" />
										</form:label>
										<div class="input-group input-group-advance">
											<span class="input-group-addon pAdvance">Rs.</span>
											<form:input path="sale_amount" id="sale_amount"
												class="form-control" />
											<form:errors path="sale_amount" cssClass="error" />
											<br />
										</div>
									</div>

									<!-- Dropdown - Yes/No-->
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="loan">
											<spring:message code="loan" />
										</form:label>
										<form:select path="loan" id="loan" value="${loan.title}">
											<form:option value="" label="Select..." />
											<form:option value="Y">Yes</form:option>
											<form:option value="N">No</form:option>
										</form:select>
										<form:errors path="loan" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-12 col-lg-12">
										<form:label path="addl_dtls">
											<spring:message code="sale_add_details" />
										</form:label>
										<form:textarea path="addl_dtls" id="sale_add_details"
											class="form-control" style="height:90px" />
										<form:errors path="addl_dtls" cssClass="error" />
										<br />
									</div>

									<form:hidden path="sa_status_flg" id="sa_status_flg" />
									<%-- <form:hidden path="start_dt" id="start_dt"/> --%>
									<%
										Object obj = request.getAttribute("start_dt");
											session.setAttribute("start_dt", obj);
									%>
								</div>
							</div>

							<c:choose>
								<c:when test="${activate == 'activate'}">
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<input type="submit" id="submit_saleForm"
												class="btn  btn-primary"
												style="width: 28%; margin: 2% 2% 1% 2%" value="Update"
												formaction="/saleAgreementupdated/${saId}" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="submit_saleForm"
												class="btn  btn-primary"
												style="width: 28%; margin: 2% 2% 1% 2%" value="Submit" />
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<input type="submit" id="submit_saleForm"
												class="btn  btn-primary" style="width: 41%" value="Update"
												formaction="/saleAgreementupdated/${saId}" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="submit_saleForm"
												class="btn  btn-primary" style="width: 41%" value="Submit" />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

							<c:if test="${activate == 'activate'}">
								<input type="submit" id="submit_saleForm"
									class="btn  btn-primary"
									style="width: 28%; margin: 2% 2% 1% 2%" value="activate"
									formaction="/activateUser/${saId}" />
							</c:if>
					
							<c:choose>
								<c:when test="${activate == 'activate'}">
									<input type="button" id="cancel_saleForm"
										class="btn btn-default"
										style="width: 28%; margin: 2% 2% 1% 2%"
										onclick="window.history.back()" value="Cancel" />
								</c:when>
								<c:otherwise>
									<input type="button" id="cancel_saleForm"
										class="btn btn-default" style="width: 41%"
										onclick="window.history.back()" value="Cancel" />
								</c:otherwise>
							</c:choose>
							
						</div>
					</form:form>
				</div>
			</div>
			</row>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header alert-danger">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Warning</h4>
				</div>
				<div class="modal-body">
					<p>Please correct errors in form before proceeding!</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>

		</div>
	</div>
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>