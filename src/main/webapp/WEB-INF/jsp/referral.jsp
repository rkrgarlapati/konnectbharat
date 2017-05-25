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
									<th width="5%">ID</th>
									<th width="10%">Name</th>
									<th width="10%">Record Type</th>
									<th width="10%">Phone Number</th>
									<th width="10%">Status</th>
									<th width="10%">Area</th>
									<th width="10%">City</th>
									<th width="10%">Referred Date</th>
									<th width="10%">Activated Date</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${not empty referrals}">
									<c:forEach var="referral" items="${referrals}">
										<tr>
											<td width="5%"><a
												href="/referral/${fn:trim(referral.type)}/${referral.sa_id}">${referral.sa_id}</a></td>
											<td width="10%">${referral.actual_party_name}</td>
											<td width="10%">${referral.type}</td>
											<td width="10%">${referral.actual_party_contact}</td>
											<c:if test="${referral.statusflg == '10'}">
												<td width="10%">Pending Start</td>
											</c:if>
											<c:if test="${referral.statusflg == '20'}">
												<td width="10%">Active</td>
											</c:if>
											<td width="10%">${referral.area}</td>
											<td width="10%">${referral.city}</td>
											<td width="10%">${referral.list_dt}</td>
											<td width="10%">${referral.start_dt}</td>
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