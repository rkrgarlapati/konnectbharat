<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Rental Form</title>
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
					<form:form id="rental_form" class="rental_form_class" method="POST"
						action="/rentalForm" commandName="rentAttributes">
						<div id="rent_form" class="container-fluid">
							<div class="row text-center rentalForm_head">
								<h3>Rental Form</h3>
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
										<form:label path="rental_party"
											style="padding:1px 0% 0% 20%;color: #FF6600;">
											<spring:message code="agreement_id" /> ${saId}
						</form:label>
									</c:if>

								</div>
							</div>

							<div class="row gropElements_rental elementsBorder">


								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="rental_party">
										<spring:message code="rental_party" />
									</form:label>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<form:input path="rental_party" id="rental_party"
												class="form-control" readonly="true" />
										</c:when>
										<c:otherwise>
											<form:input path="rental_party" id="rental_party" />
										</c:otherwise>
									</c:choose>
									<form:errors path="rental_party" cssClass="error" />
									<br />
								</div>

								<!-- dropdown - Owner Tenant-->
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
									<form:errors path="agreement_type" cssClass="error" />
									<br />
								</div>

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="rental_phone">
										<spring:message code="rental_phone" />
									</form:label>
									<div class="input-group input-group-pNumber">
										<span class="input-group-addon pNumber">+91</span>
										<c:choose>
											<c:when test="${updateFlag == 'update'}">
												<form:input path="rental_phone" id="rental_phone"
													class="form-control" readonly="true" />
											</c:when>
											<c:otherwise>
												<form:input path="rental_phone" id="rental_phone"
													class="form-control" />
											</c:otherwise>
										</c:choose>
									</div>
									<form:errors path="rental_phone" cssClass="error" />
									<br />
								</div>
							</div>


							<div class="row gropElements elementsBorder">
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-6 col-lg-6 address_section">
										<form:label path="rental_address1">
											<spring:message code="rental_address1" />
										</form:label>
										<form:input path="rental_address1" id="rental_address1" />
										<form:errors path="rental_address1" cssClass="error" />
										<br />
									</div>
									<div
										class="col-xm-12 col-sm-12 col-md-6 col-lg-6 address_section">
										<form:label path="rental_address2">
											<spring:message code="rental_address2" />
										</form:label>
										<form:input path="rental_address2" id="rental_address2" />
										<form:errors path="rental_address2" cssClass="error" />
										<br />
									</div>
								</div>
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="rental_area">
											<spring:message code="rental_area" />
										</form:label>
										<form:input path="rental_area" id="rental_area" />
										<form:errors path="rental_area" cssClass="error" />
										<br />
									</div>
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="rental_city">
											<spring:message code="rental_city" />
										</form:label>
										<form:input path="rental_city" id="rental_city" />
										<form:errors path="rental_city" cssClass="error" />
										<br />
									</div>
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="rental_state">
											<spring:message code="rental_state" />
										</form:label>
										<form:input path="rental_state" id="rental_state" />
										<form:errors path="rental_state" cssClass="error" />
										<br />
									</div>
								</div>
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
										<form:label path="rental_postal">
											<spring:message code="rental_postal" />
										</form:label>
										<form:input path="rental_postal" id="rental_postal" />
										<form:errors path="rental_postal" cssClass="error" />
										<br />
									</div>
								</div>
							</div>


							<div class="row gropElements elementsBorder">

								<!-- dropdown - Commercial/Residential -->
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="usage">
											<spring:message code="usage" />
										</form:label>
										<form:select path="usage" id="usage" value="usage">
											<form:option value="" label="Select..." />
											<form:option value="C">Commercial</form:option>
											<form:option value="R">Residential</form:option>
											<form:option value="O">Other</form:option>
										</form:select>
										<form:errors path="usage" cssClass="error" />
										<br />
									</div>

									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4 pArea_height">
										<form:label path="r_prop_area">
											<spring:message code="r_prop_area" />
										</form:label>
										<form:input path="r_prop_area" id="r_prop_area"
											class="form-control" />
										<form:errors path="r_prop_area" cssClass="error" />
										<br />
									</div>

									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="rental_rent">
											<spring:message code="rental_rent" />
										</form:label>
										<div class="input-group input-group-rent">
											<span class="input-group-addon pRent">Rs.</span>
											<form:input path="rental_rent" id="rental_rent"
												class="form-control" />
											<form:errors path="rental_rent" cssClass="error" />
											<br />
										</div>
									</div>
								</div>

								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="rental_advance">
											<spring:message code="rental_advance" />
										</form:label>
										<div class="input-group input-group-advance">
											<span class="input-group-addon pAdvance">Rs.</span>
											<form:input path="rental_advance" id="rental_advance"
												class="form-control" />
											<form:errors path="rental_advance" cssClass="error" />
											<br />
										</div>
									</div>

									<!-- Dropdown - 1 to 12 -->
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="advance_months">
											<spring:message code="advance_months" />
										</form:label>
										<form:input path="advance_months" id="advance_months"
											class="form-control" />
										<form:errors path="advance_months" cssClass="error" />
										<br />
									</div>

									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="r_rent_period">
											<spring:message code="r_rent_period" />
										</form:label>
										<form:input path="r_rent_period" id="r_rent_period" />
										<form:errors path="r_rent_period" cssClass="error" />
										<br />
									</div>
								</div>
								<div class="row address_section_row">
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="r_park_two">
											<spring:message code="r_park_two" />
										</form:label>
										<form:select path="r_park_two" id="r_park_two"
											value="r_park_two" class="form-control">
											<form:option value="" label="Select..." />
											<form:option value="Y">Yes</form:option>
											<form:option value="N">No</form:option>
										</form:select>
										<form:errors path="r_park_two" cssClass="error" />
										<br />
									</div>

									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="r_park_four">
											<spring:message code="r_park_four" />
										</form:label>
										<form:select path="r_park_four" id="r_park_four"
											value="r_park_four" class="form-control">
											<form:option value="" label="Select..." />
											<form:option value="Y">Yes</form:option>
											<form:option value="N">No</form:option>
										</form:select>
										<form:errors path="r_park_four" cssClass="error" />
										<br />

									</div>
									<div
										class="col-xm-12 col-sm-12 col-md-4 col-lg-4 property_section">
										<form:label path="r_maintenance">
											<spring:message code="r_maintenance" />
										</form:label>
										<div class="input-group input-group-maintenance">
											<span class="input-group-addon pMaintenance">Rs.</span>
											<form:input path="r_maintenance" id="r_maintenance"
												class="form-control" />
											<form:errors path="r_maintenance" cssClass="error" />
											<br />
										</div>
									</div>
									<div class="col-xm-12 col-sm-12 col-md-12 col-lg-12">
										<form:label path="addl_dtls">
											<spring:message code="r_add_details" />
										</form:label>
										<form:textarea path="addl_dtls" id="additional_details"
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
											<input type="submit" id="submit_rentalForm"
												class="btn  btn-primary"
												style="width: 28%; margin: 2% 2% 1% 2%" value="Update"
												formaction="/rentalAgreementupdated/${saId}" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="submit_rentalForm"
												class="btn  btn-primary"
												style="width: 28%; margin: 2% 2% 1% 2%" value="Submit" />
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<input type="submit" id="submit_rentalForm"
												class="btn  btn-primary" style="width: 41%" value="Update"
												formaction="/rentalAgreementupdated/${saId}" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="submit_rentalForm"
												class="btn  btn-primary" style="width: 41%" value="Submit" />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

							<c:if test="${activate == 'activate'}">
								<input type="submit" id="submit_rentalForm"
									class="btn  btn-primary"
									style="width: 28%; margin: 2% 2% 1% 2%" value="activate"
									formaction="/activateUser/${saId}" />
							</c:if>

					
							<c:choose>
								<c:when test="${activate == 'activate'}">
									<input type="button" id="cancel_rentalForm"
										class="btn btn-default"
										style="width: 28%; margin: 2% 2% 1% 2%"
										onclick="window.history.back()" value="Cancel" />
								</c:when>
								<c:otherwise>
									<input type="button" id="cancel_rentalForm"
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