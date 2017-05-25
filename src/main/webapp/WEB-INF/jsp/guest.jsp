<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
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

	<div class="conatiner" style="width: 100%; margin-bottom: 5.5%">

		<!-- HEADER -->
		<jsp:include page="header.jsp"></jsp:include>

		<div id="section1" class="container"
			style="margin-left: 35px; width: 97%">

			<div class="row">

				<jsp:include page="left_menu_main.jsp"></jsp:include>

				<!-- </div> -->
				<div class="col-lg-10 no-float">
					<div id="rental_section"
						class="col-xs-3 col-sm-10 col-md-4 col-lg-3 col-offset-xs-2 col-offset-sm-2 col-offset-md-2 col-offset-lg-2 ">
						<div class="row">
							<h3 class="text-center section1_heading">RENTAL</h3>
						</div>
						<div class="row">
							<input type="submit" id="prospective_tenant"
								class="btn btn-primary btn-block section1_button"
								value="Prospective Tenant"
								onclick="location.href='/rentalFormController?type=tenant'" />
							<input type="submit" id="rent_owner"
								class="btn btn-primary btn-block section1_button"
								value="Rent Owner"
								onclick="location.href='/rentalFormController?type=owner'" />
						</div>
					</div>

					<div id="sale_section"
						class="col-xs-3 col-sm-10 col-md-4 col-lg-3 col-offset-xs-2 col-offset-sm-2 col-offset-md-2 col-offset-lg-2">

						<div class="row">
							<h3 class="text-center section1_heading">SALE</h3>
						</div>
						<div class="row">
							<input type="submit" id="buy_id"
								class="btn btn-primary btn-block section1_button" value="Buy"
								onclick="location.href='/saleFormController?type=buy'" /> <input
								type="submit" id="sell_id"
								class="btn btn-primary btn-block section1_button" value="Sell"
								onclick="location.href='/saleFormController?type=sell'" />
						</div>
					</div>
					<div id="matrimony_section"
						class="col-xs-3 col-sm-10 col-md-4 col-lg-3 col-offset-xs-2 col-offset-sm-2 col-offset-md-2 col-offset-lg-2">

						<div class="row">
							<h3 class="text-center section1_heading">MATRIMONY</h3>
						</div>
						<div class="row">
							<input type="submit" id="bride_id"
								class="btn btn-primary btn-block section1_button" value="Bride"
								onclick="location.href='/matrimonyFormController?type=bride'" />
							<input type="submit" id="groom_id"
								class="btn btn-primary btn-block section1_button" value="Groom"
								onclick="location.href='/matrimonyFormController?type=groom'" />
						</div>
					</div>
				</div>

				<div class="col-sm-10 no-float">
					<div id="custcontact_section"
						class="col-xs-3 col-sm-10 col-md-4 col-lg-3 col-offset-xs-2 col-offset-sm-2 col-offset-md-2 col-offset-lg-2 ">
						<div class="row">
							<h3 class="text-center section1_heading">CONTACT</h3>
						</div>
						<div class="row">
							<input type="submit"
								class="btn btn-primary btn-block section1_button"
								value="Customer Contact"
								onclick="location.href='/custContactFormController'" />

						</div>
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