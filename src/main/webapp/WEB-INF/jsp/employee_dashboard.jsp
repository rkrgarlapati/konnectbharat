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
<script src="/js/main.js"></script>
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
					<!-- <div class="page-header"
						style="color: #337ab7; text-align: center;border-bottom: 0;">
						<h3>Employee Dashboard</h3>
					</div>
					<div>
						
					</div> -->
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
	<script type="text/javascript">
	loadSearchDivAjax(1);
		
	</script>

</body>
</html>