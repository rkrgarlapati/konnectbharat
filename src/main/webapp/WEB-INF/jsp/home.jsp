<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Form</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css" />

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<div class="conatiner">

		<jsp:include page="header.jsp"></jsp:include>


		<div class="container" id="section1">
			<form:form id="registration_form" class="register_form_class"
				method="POST" action="/newCustomerRegis"
				commandName="newCustomerRegis">
				<div id="register_form" class="container-fluid">
					<c:if test="${not empty fn:trim(errorMsg)}">
						<p class="text-center error_show">${errorMsg}</p>
					</c:if>
					<div class="row text-center registerForm_head">
						<h3>Registration Form</h3>
					</div>

					<div class="row gropElements">

						<!-- <p class="mandatory">* All the fields are mandatory </p> -->
						<p class="alert alert-info" style="width: 25%; margin-left: 12px">
							* indicates mandatory fields</p>

						<div class="col-xm-6 col-sm-6 col-md-6 col-lg-6">
							<form:label path="first_name">
								<spring:message code="first_name" />
							</form:label>
							<form:input path="first_name" id="first_name" />
							<form:errors path="first_name" cssClass="error" />
							<br />
						</div>
						<div class="col-xm-6 col-sm-6 col-md-6 col-lg-6">
							<form:label path="second_name">
								<spring:message code="second_name" />
							</form:label>
							<form:input path="second_name" id="second_name" />
							<form:errors path="second_name" cssClass="error" />
							<br />
						</div>
					</div>
					<div class="row gropElements1 elementsBorder">
						<div class="col-xm-6 col-sm-6 col-md-6 col-lg-6">
							<form:label path="phone">
								<spring:message code="phone" />
							</form:label>
							<div class="input-group input-group-pNumber">
								<span class="input-group-addon pNumber">+91</span>
								<form:input path="phone" id="phone" class="form-control" />
							</div>
							<form:errors path="phone" cssClass="error" />
							<br />
						</div>
						<div class="col-xm-6 col-sm-6 col-md-6 col-lg-6 email-bottom">
							<form:label path="emailid">
								<spring:message code="emailid" />
							</form:label>
							<form:input path="emailid" id="emailid" />
							<form:errors path="emailid" cssClass="error" />
							<br />
						</div>
					</div>

					<div class="row gropElements1 elementsBorder"
						style="padding-top: 10px">
						<div class="col-xs-4 col-sm-4">
							<form:label path="password">
								<spring:message code="password" />
							</form:label>
							<form:password path="password" id="password" class="form-control" />
							<form:errors path="password" cssClass="error" />
							<br />

						</div>
						<div class="col-xs-4 col-sm-4">
							<form:label path="reenterPassword">
								<spring:message code="reenterPassword" />
							</form:label>
							<form:password path="reenterPassword" id="reenterPassword"
								class="form-control" />
							<form:errors path="reenterPassword" cssClass="error" />
							<br />
						</div>
						<div class="col-xs-4 col-sm-4" style="padding-top: 10px">
							<span style="font-size: 13px">Your password must have<br>
								<i style='color: #32CD32; font-size: 17px' class='fa fa-check'></i><label
								style='color: #32CD32; font-weight: normal'> &nbsp;7 or
									more characters</label>
							</span>
						</div>

					</div>

					<div class="row gropElements elementsBorder">

						<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
							<form:label path="panNumber">
								<spring:message code="panNumber" />
							</form:label>
							<form:input path="panNumber" id="panNumber" />
							<form:errors path="panNumber" cssClass="error" />
							<br />
						</div>
						<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
							<form:label path="license">
								<spring:message code="license" />
							</form:label>
							<form:input path="license" id="license" />
							<form:errors path="license" cssClass="error" />
							<br />
						</div>
						<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
							<form:label path="aadharNumber">
								<spring:message code="aadharNumber" />
							</form:label>
							<form:input path="aadharNumber" id="aadharNumber" />
							<form:errors path="aadharNumber" cssClass="error" />
							<br />
						</div>
					</div>

					<div class="row gropElements elementsBorder">

						<div class="row address_section_row">
							<div
								class="col-xm-12 col-sm-12 col-md-6 col-lg-6 address_section">
								<form:label path="address1">
									<spring:message code="address1" />
								</form:label>
								<form:input path="address1" id="address1" />
								<form:errors path="address1" cssClass="error" />
								<br />
							</div>
							<div
								class="col-xm-12 col-sm-12 col-md-6 col-lg-6 address_section">
								<form:label path="address2">
									<spring:message code="address2" />
								</form:label>
								<form:input path="address2" id="address2" />
								<form:errors path="address2" cssClass="error" />
								<br />
							</div>
						</div>
						<div class="row address_section_row">
							<div
								class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
								<form:label path="area">
									<spring:message code="area" />
								</form:label>
								<form:input path="area" id="area" />
								<form:errors path="area" cssClass="error" />
								<br />
							</div>
							<div
								class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
								<form:label path="city">
									<spring:message code="city" />
								</form:label>
								<form:input path="city" id="city" />
								<form:errors path="city" cssClass="error" />
								<br />
							</div>
							<div
								class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
								<form:label path="state">
									<spring:message code="state" />
								</form:label>
								<form:input path="state" id="state" />
								<form:errors path="state" cssClass="error" />
								<br />
							</div>
						</div>
						<div class="row address_section_row">
							<div
								class="col-xm-12 col-sm-12 col-md-4 col-lg-4 address_section">
								<form:label path="postal">
									<spring:message code="postal" />
								</form:label>
								<form:input path="postal" id="postal" />
								<form:errors path="postal" cssClass="error" />
								<br />
							</div>

						</div>
					</div>
					<div class="row">
						<input type="submit" id="submit_registerForm"
							class="btn  btn-primary" value="Submit" /> <input type="button"
							id="cancel_registerForm" class="btn btn-default"
							onclick="callCancelEvent(this)" value="Cancel" />
					</div>

				</div>
			</form:form>

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
					<h4 class="modal-title ">Warning</h4>
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