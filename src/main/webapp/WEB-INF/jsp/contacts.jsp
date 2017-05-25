<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contacts</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/guest.css" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

	<div class="conatiner" style="width: 100%; margin-bottom: 8%">

		<!-- HEADER -->
		<jsp:include page="header.jsp"></jsp:include>

		<div id="section1" class="container"
			style="margin-left: 35px; width: 100%">

			<div class="row">

				<jsp:include page="left_menu_main.jsp"></jsp:include>

				<!-- </div> -->
				<div class="col-sm-9 no-float">
					<div class="page-header"
						style="color: #337ab7; text-align: center;">
						<h3>${pagename}</h3>
					</div>
					<div>
					<table class="table table-bordered">
						<thead>
							<tr>						
								<th width="5%">Communication ID</th>
								<th width="10%">Agreement ID</th>
								<th width="10%">Date/Time</th>
								<th width="10%">Class</th>
								<th width="10%">Type</th>
								<th width="10%">Status</th>
								<th width="10%">Priority</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${not empty customerList}">
							<c:forEach var="customer" items="${customerList}">
								<tr style="cursor: pointer">
									<td width="5%"><a href="/editCustContact/${customer.communicationId}">${customer.communicationId}</a></td>
									<td width="10%">${customer.agreementId}</td>
									<td width="10%">${customer.datetime}</td>
									<td width="10%"><c:if test="${not empty customer.communicationclass}"><spring:message code="${customer.communicationclass}"/></c:if></td>
									<td width="10%"><c:if test="${not empty customer.communicationtype}"><spring:message code="${customer.communicationtype}"/></c:if></td>
									<td width="10%"><c:if test="${not empty customer.status}"><spring:message code="${customer.status}"/></c:if></td>
									<td width="10%"><spring:message code="${customer.priority}"/></td>
								</tr>
							</c:forEach>
						</c:if>
						</tbody>
					</table>
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