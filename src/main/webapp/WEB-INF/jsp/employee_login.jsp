<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link rel="stylesheet" type="text/css" href="/css/guest.css" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/js/main.js"></script>
</head>
<body>
	<div class="container">
		<div id="section1" class="container">
			<form:form id="emp_login_form" class="login_form_class" method="POST"
				action="/emplogin" commandName="newEmpLogin">
				<div class="row">
					<div id="login_section"
						class="col-xs-10 col-sm-10 col-md-4 col-lg-4 col-offset-xs-2 col-offset-sm-2 col-offset-md-2 col-offset-lg-2 "
						style="height: auto;border-radius: 0px">
						<div class="row">
							<h1 class="text-center" style="color:#44B3C2;font-size: 20px">Employee Login</h1>
						</div>
						<c:if test="${not empty fn:trim(errorMsg)}">
							<div class="alert alert-danger fade in"
								style="margin-bottom: 10px">
								<strong><i class="fa fa-exclamation-triangle"
									aria-hidden="true"></i> </strong> &nbsp;${errorMsg}
							</div>
						</c:if>
						<c:if test="${not empty fn:trim(logoutSuccessMsg)}">
							<div class="alert alert-success fade in"
								style="margin-bottom: 10px">
								<strong><i class="fa fa-check" aria-hidden="true"></i></i>
								</strong> &nbsp;${logoutSuccessMsg}
							</div>
						</c:if>
						<c:if test="${not empty fn:trim(successRegistration)}">
							<div class="alert alert-success fade in"
								style="margin-bottom: 10px">
								<strong><i class="fa fa-check" aria-hidden="true"></i></i>
								</strong> &nbsp;${successRegistration}
							</div>
						</c:if>
						<div id="emploginErrDiv" class="alert alert-danger fade in"
							style="margin-bottom: 10px; display: none">
							<strong><i class="fa fa-exclamation-triangle"
								aria-hidden="true"></i></strong> <span></span>
						</div>

						<div class="form-group">
							<form:input class="form-control" placeholder="User ID"
								path="emp_login_userid" id="emp_login_userid" />
						</div>
						<br>
						<div class="form-group">
							<form:password class="form-control" placeholder="Password"
								path="emp_login_password" id="emp_login_password" />
						</div>
						<br>
						<div class="form-buttons">
							<input type="button" name="signin" value="Sign In"
								class="btn btn-emplogin btn-lg btn-block" id="btn-primary" onclick="processEmpLogin()"
								> <br>
						</div>

					</div>
				</div>
			</form:form>
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
<script>
	document.onkeydown = function() {
		if (window.event.keyCode == '13') {
			validateAndLogin();
		}
	}
</script>