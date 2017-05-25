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


		<div class="container" id="section1" style="width: 60%">

			<form:form id="emp_registration_form" class="register_form_class"
				method="POST" action="/newEmpSubmit" commandName="newEmpRegis">
			<c:if test="${not empty fn:trim(errorMsg)}">
				<p class="text-center error_show">${errorMsg}</p>
			</c:if>
			<div class="text-center emppage_font"> Employee Registration </div>
				<fieldset>

					<div style="width:36%">
						<p class="alert alert-info" >*
							indicates mandatory fields</p>
					</div>
				
					<div class="form-group">
						<form:label path="emp_firstName">
							<spring:message code="emp_fname" />
						</form:label>
						<form:input path="emp_firstName" id="emp_firstName" class="form-control" />
						<form:errors path="emp_firstName" cssClass="error" />
					</div>

					<div class="form-group">
						<form:label path="emp_lastName">
							<spring:message code="emp_lname" />
						</form:label>
						<form:input path="emp_lastName" id="emp_lastName" class="form-control" />
						<form:errors path="emp_lastName" cssClass="error" />
					</div>

					<div class="form-group">
						<form:label path="emp_userid">
							<spring:message code="emp_userid" />
						</form:label>
						<form:input path="emp_userid" id="emp_userid" class="form-control" />
						<form:errors path="emp_userid" cssClass="error" />
					</div>


					<div class="form-group">
						<form:label path="emp_password">
							<spring:message code="emp_password" />
						</form:label>
						<form:password path="emp_password" id="emp_password"
							class="form-control" />
						<form:errors path="emp_password" cssClass="error" />
						<br />
					</div>

					<div class="form-group">
						<form:label path="emp_reenterpassword">
							<spring:message code="emp_reenterpassword" />
						</form:label>
						<form:password path="emp_reenterpassword" id="emp_reenterpassword"
							class="form-control" />
						<form:errors path="emp_reenterpassword" cssClass="error" />
					</div>

					<div class="form-group">
						<form:label path="emp_accesstype">
							<spring:message code="emp_accesstype" />
						</form:label>
						<form:select path="emp_accesstype" id="emp_accesstype"
							class="form-control" value="accessType">
							<form:option value="Level_1" label="Level 1" />
							<form:option value="Level_2" label="Level 2" />
							<form:option value="Level_3" label="Level 3" />
							<form:option value="Level_4" label="Level 4" />

						</form:select>
						<form:errors path="emp_accesstype" cssClass="error" />
					</div>


					<div class="form-group">
						<input class="btn btn-success" style="background-color: #44B3C2;width: 40%" type="submit" name="submit_reg"
							value="Register">
					</div>

				</fieldset>

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