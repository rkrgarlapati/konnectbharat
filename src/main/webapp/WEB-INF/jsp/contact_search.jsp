<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Guest Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link rel="stylesheet" type="text/css" href="/css/pikaday.css" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/main.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/js/pikaday.js"></script>

</head>
<body>

	<div class="conatiner" style="width: 100%; margin-bottom: 5%">

		<!-- HEADER -->
		<jsp:include page="header.jsp"></jsp:include>

		<div id="section1" class="container"
			style="margin-left: 35px; width: 100%">

			<div class="row">

				<jsp:include page="search_menu.jsp"></jsp:include>

				<!-- </div> -->
				<div class="col-sm-9" id="searchDataDiv">
					<div class="container" id="section1" style="width: 73%;margin-left: 29px">

	<form:form id="contactsearch_form" class="contactsearch_form_class"
		method="POST" action="/contactSearchSubmit" commandName="contactSearchForm">

	<div class="text-center emppage_font"> Contact Search</div>

		<div style="display: inline-block;">
			<div class="alert alert-danger" id="success-alert"
				 style="margin:6px 0px 6px 0px;padding :9px 9px 9px 9px;display:none">
				Created Date From, Created Date To must not be left blank and within 7 days range.
			</div>
		</div>
							<fieldset>
			<div class="form-group">
				<form:label path="contactStatus">
					<spring:message code="contact_status" />
				</form:label>
				<form:select path="contactStatus" id="contactStatus"
					class="form-control" value="accessType">
					<form:option value="10" label="OPEN" />
					<form:option value="20" label="ASSIGNED" />
					<form:option value="30" label="CLOSED" />
					<form:option value="40" label="CANCELLED" />
				</form:select>
				<form:errors path="contactStatus" cssClass="error" />
			</div>

			<div class="form-group">
				<form:label path="contactCreateDateFrom">
					<spring:message code="contact_createdfromdt" />
				</form:label>
				<form:input path="contactCreateDateFrom" id="contactCreateDateFrom"
					class="form-control" />
				<form:errors path="contactCreateDateFrom" cssClass="error" />
			</div>

			<div class="form-group">
				<form:label path="contactCreateDateTo">
					<spring:message code="contact_createdtodt" />
				</form:label>
				<form:input path="contactCreateDateTo" id="contactCreateDateTo"
					class="form-control" />
				<form:errors path="contactCreateDateTo" cssClass="error" />
			</div>


			<div class="form-group">
				<form:label path="contactAssignedTo">
					<spring:message code="contact_assignedto" />
				</form:label>
				<form:input path="contactAssignedTo" id="contactAssignedTo"
					class="form-control" />
				<form:errors path="contactAssignedTo" cssClass="error" />
				<br />
			</div>

			<div class="form-group">
				<form:label path="contactType">
					<spring:message code="contact_type" />
				</form:label>
				<form:select path="contactType" id="contactType"
					class="form-control" value="accessType">
					<form:option value="" label="Select..." />
					<form:option value="CT" label="CUSTOMER" />
					<form:option value="CP" label="COMPANY" />
				</form:select>
				<form:errors path="contactType" cssClass="error" />
			</div>




			<div class="form-group">
				<input class="btn btn-success"
					style="background-color: #44B3C2; width: 70%; margin: 3% 0% 0% 10%" type="button" onclick="performContactSearch()"
					name="submit_contact_search" value="Search">
			</div>

		</fieldset>

	</form:form>

</div>
				</div>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
<script>
$("#success-alert").hide();
var picker = new Pikaday({
	field : $('#contactCreateDateFrom')[0],
	format : 'DD/MM/YYYY',
	showTime : false,
	yearRange : [ 1950, new Date().getFullYear() ],
	onSelect : function() {
		$('#contactCreateDateFrom').val(moment(picker.getDate()).format("DD/MM/YYYY"));
	}
});

var picker1 = new Pikaday({
	field : $('#contactCreateDateTo')[0],
	format : 'DD/MM/YYYY',
	showTime : false,
	yearRange : [ 1950, new Date().getFullYear() ],
	onSelect : function() {
		$('#contactCreateDateTo').val(moment(picker1.getDate()).format("DD/MM/YYYY"));
	}
});
</script>
</html>