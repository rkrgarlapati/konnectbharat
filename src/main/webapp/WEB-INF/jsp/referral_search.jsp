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

	<form:form id="refsearch_form" class="refsearch_form_class"
		method="POST" action="/referralSearchSubmit" commandName="referralSearchForm">

		<div class="text-center emppage_font">Referral Search</div>
		<fieldset>
			<div class="form-group">
				<form:label path="referralType">
					<spring:message code="referral_type" />
				</form:label>
				<form:select path="referralType" id="referralType"
					class="form-control" value="accessType">
					<form:option value="OWNER" label="OWNER" />
					<form:option value="TENANT" label="TENANT" />
					<form:option value="BUY" label="BUY" />
					<form:option value="SELL" label="SELL" />
					<form:option value="GROOM" label="GROOM" />
					<form:option value="BRIDE" label="BRIDE" />
				</form:select>
				<form:errors path="referralType" cssClass="error" />
			</div>

			<div class="form-group">
				<form:label path="referralCity">
					<spring:message code="referral_city" />
				</form:label>
				<form:input path="referralCity" id="referralCity"
					class="form-control" />
				<form:errors path="referralCity" cssClass="error" />
			</div>

			<div class="form-group">
				<form:label path="referralLocation">
					<spring:message code="referral_location" />
				</form:label>
				<form:input path="referralLocation" id="referralLocation"
					class="form-control" />
				<form:errors path="referralLocation" cssClass="error" />
			</div>
			<div class="form-group">
				<form:label path="referralStatus">
					<spring:message code="referral_status" />
				</form:label>
				<form:select path="referralStatus" id="referralStatus"
					class="form-control" value="accessType">
					<form:option value="10" label="PENDING" />
					<form:option value="20" label="ACTIVE" />
					<form:option value="30" label="STOP" />
					<form:option value="40" label="CLOSED" />

				</form:select>
				<form:errors path="referralStatus" cssClass="error" />
			</div>


			<div class="form-group">
				<form:label path="referralUserid">
					<spring:message code="referral_userid" />
				</form:label>
				<form:input path="referralUserid" id="referralUserid"
					class="form-control" />
				<form:errors path="referralUserid" cssClass="error" />
				<br />
			</div>



			<div class="form-group">
				<input class="btn btn-success"
					style="background-color: #44B3C2; width: 70%; margin: 0% 0% 0% 10%" type="submit"
					name="submit_ref_search" value="Search">
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
</html>