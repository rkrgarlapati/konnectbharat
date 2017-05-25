<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Matrimony Form</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link rel="stylesheet" type="text/css" href="/css/pikaday.css" />

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/js/moment.min.js"></script>
<script src="/js/main.js"></script>

</head>
<body>
	<div class="conatiner" style=" margin-bottom: 2.5%">

		<jsp:include page="header.jsp"></jsp:include>


		<div class="container" id="section1" style="margin-left: initial;">

			<row> <jsp:include page="left_menu_sub.jsp"></jsp:include>
			<div class="col-md-9">
				<div class="col-md-12">

					<form:form id="matrimony_form" class="matrimony_form_class"
						method="POST" action="/matrimonyRegister"
						commandName="matrimonyAttributes">
						<div id="matri_form" class="container-fluid">
							<div class="row text-center matrimonyForm_head">
								<h3>Matrimony Form</h3>
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
										<form:label path="matri_party_name"
											style="padding:1px 0% 0% 20%;color: #FF6600;">
											<spring:message code="agreement_id" /> ${saId}
							</form:label>
									</c:if>

								</div>
							</div>
							<div class="row gropElements elementsBorder">

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="matri_party_name">
										<spring:message code="matri_party_name" />
									</form:label>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<form:input path="matri_party_name" id="matri_party_name"
												class="form-control" readonly="true" />
										</c:when>
										<c:otherwise>
											<form:input path="matri_party_name" id="matri_party_name" />
										</c:otherwise>
									</c:choose>
									<form:errors path="matri_party_name" cssClass="error" />
									<br />
								</div>
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
									<br />
								</div>
								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="matri_phone">
										<spring:message code="matri_phone" />
									</form:label>
									<div class="input-group input-group-pNumber">
										<span class="input-group-addon pNumber">+91</span>
										<c:choose>
											<c:when test="${updateFlag == 'update'}">
												<form:input path="matri_phone" id="matri_phone"
													class="form-control" readonly="true" />
											</c:when>
											<c:otherwise>
												<form:input path="matri_phone" id="matri_phone"
													class="form-control" />
											</c:otherwise>
										</c:choose>
									</div>
									<form:errors path="matri_phone" cssClass="error" />
									<br />
								</div>
							</div>
							<div class="row gropElements elementsBorder">
								<div class="row address_section_row">

									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="address1">
											<spring:message code="matri_address1" />
										</form:label>
										<form:textarea path="address1" id="matri_address1" />
										<form:errors path="address1" cssClass="error" />
										<br />
									</div>

									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="address2">
											<spring:message code="address2" />
										</form:label>
										<form:textarea path="address2" id="matri_address2" />
										<form:errors path="address2" cssClass="error" />
										<br />

									</div>
								</div>

								<div class="row address_section_row">
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="area">
											<spring:message code="matri_area" />
										</form:label>
										<form:input path="area" id="matri_area" />
										<form:errors path="area" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="city">
											<spring:message code="matri_city" />
										</form:label>
										<form:input path="city" id="matri_city" />
										<form:errors path="city" cssClass="error" />
										<br />
									</div>

									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="state">
											<spring:message code="matri_state" />
										</form:label>
										<form:input path="state" id="matri_state" />
										<form:errors path="state" cssClass="error" />
										<br />
									</div>

								</div>
								<div class="row address_section_row">
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="postal">
											<spring:message code="matri_postal" />
										</form:label>
										<form:input path="postal" id="matri_postal" />
										<form:errors path="postal" cssClass="error" />
										<br />
									</div>

									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="country">
											<spring:message code="matri_country" />
										</form:label>
										<form:input path="country" id="matri_country" />
										<form:errors path="country" cssClass="error" />
										<br />
									</div>
								</div>

							</div>

							<div class="row gropElements elementsBorder">

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="bride_name">
										<spring:message code="matri_bride_name" />
									</form:label>
									<form:input path="bride_name" id="matri_bride_name" />
									<form:errors path="bride_name" cssClass="error" />
									<br />
								</div>

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<div class="row">
										<form:label path="dob">
											<spring:message code="matri_dob" />
										</form:label>
										<form:input path="dob" id="matri_dob" />
									</div>
									<form:errors path="dob" cssClass="error" />
									<br />
								</div>

								<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
									<form:label path="highest_education">
										<spring:message code="matri_higher_edu" />
									</form:label>
									<%-- <form:input path="highest_education" id="matri_higher_edu" /> --%>
									<form:select path="highest_education" id="matri_higher_edu"
										value="highest_education">
										<form:option value="" label="Select..." />
										<form:option value="UD" label="Uneducated"/>
										<form:option value="BS" label="Basic School"/>
										<form:option value="BL" label="Bachelors"/>
										<form:option value="MA" label="Masters"/>
									</form:select>
									<form:errors path="highest_education" cssClass="error" />
									<br />
								</div>
							</div>

							<div class="row gropElements elementsBorder">
								<div class="row address_section_row">
									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="religion">
											<spring:message code="matri_religion" />
										</form:label>
										<%-- <form:input path="religion" id="matri_religion" /> --%>
										<form:select path="religion" id="matri_religion"
											value="religion">
											<form:option value="" label="Select..." />
											<form:option value="HIN" label="Hindu"/>
											<form:option value="CHR" label="Christian"/>
											<form:option value="MUS" label="Muslim"/>
											<form:option value="SIK" label="Sikh"/>
											<form:option value="OTR" label="Other"/>
										</form:select>
										<form:errors path="religion" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="caste">
											<spring:message code="matri_caste" />
										</form:label>
										<form:input path="caste" id="matri_caste" />
										<form:errors path="caste" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="sub_caste">
											<spring:message code="matri_sub_caste" />
										</form:label>
										<form:input path="sub_caste" id="matri_sub_caste" />
										<form:errors path="sub_caste" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="height">
											<spring:message code="matri_height" />
										</form:label>
										<form:input path="height" id="matri_height" />
										<form:errors path="height" cssClass="error" />
										<br />
									</div>
								</div>
							</div>
							<div class="row gropElements elementsBorder">


								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="family_details">
										<spring:message code="matri_family_det" />
									</form:label>
									<form:textarea path="family_details" id="matri_family_det" />
									<form:errors path="family_details" cssClass="error" />
									<br />
								</div>
								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="additional_details">
										<spring:message code="matri_add_details" />
									</form:label>
									<form:textarea path="additional_details" id="matri_add_details" />
									<form:errors path="additional_details" cssClass="error" />
									<br />
								</div>
								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="employment">
										<spring:message code="matri_employment" />
									</form:label>
									<%-- <form:input path="employment" id="matri_employment" /> --%>
									<form:select path="employment" id="matri_employment"
										value="employment">
										<form:option value="" label="Select..." />
										<form:option value="UNE" label="Unemployed"/>
										<form:option value="EMP" label="Employed"/>
										<form:option value="SFE" label="Self-Employed"/>
										<form:option value="BIS" label="Business"/>
									</form:select>
									<form:errors path="employment" cssClass="error" />
									<br />
								</div>


								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="marital_status">
										<spring:message code="matri_marital_status" />
									</form:label>
									<%-- <form:input path="marital_status" id="matri_marital_status" /> --%>
									<form:select path="marital_status" id="matri_marital_status"
										value="marital_status">
										<form:option value="" label="Select..." />
										<form:option value="NVM" label="Never married"/>
										<form:option value="DIS" label="Divorced"/>
										<form:option value="ANL" label="Annulled"/>
										<form:option value="WID" label="Waiting for Divorce"/>
									</form:select>
									<form:errors path="marital_status" cssClass="error" />
									<br />
								</div>
							</div>

							<div class="row gropElements elementsBorder">


								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="food">
										<spring:message code="matri_food" />
									</form:label>
									<%-- <form:input path="food" id="matri_food" /> --%>
									<form:select path="food" id="matri_food" value="food">
										<form:option value="" label="Select..." />
										<form:option value="VE" label="Vegetarian"/>
										<form:option value="NV" label="Non-Vegetarian"/>
										<form:option value="EG" label="Eggetarian"/>
									</form:select>
									<form:errors path="food" cssClass="error" />
									<br />
								</div>
								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="smoking">
										<spring:message code="matri_smoking" />
									</form:label>
									<%-- <form:input path="smoking" id="matri_smoking" /> --%>
									<form:select path="smoking" id="matri_smoking" value="smoking">
										<form:option value="" label="Select..." />
										<form:option value="N" label="Non-Smoker" />
										<form:option value="L" label="Light/Social-Smoker" />
										<form:option value="R" label="Regular Smoker" />
									</form:select>
									<form:errors path="smoking" cssClass="error" />
									<br />
								</div>

								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="drinking">
										<spring:message code="matri_drinking" />
									</form:label>
									<%-- <form:input path="drinking" id="matri_drinking" /> --%>
									<form:select path="drinking" id="drinking_status"
										value="drinking">
										<form:option value="" label="Select..." />
										<form:option value="NOND" label="Non-Drinker"/>
										<form:option value="LIGD" label="Light/Social-Drinker"/>
										<form:option value="REGD" label="Regular Drinker"/>
									</form:select>
									<form:errors path="drinking" cssClass="error" />
									<br />
								</div>

								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="horoscope_available">
										<spring:message code="matri_horoscope_available" />
									</form:label>
									<%-- <form:input path="horoscope_available"
								id="matri_horoscope_available" /> --%>
									<form:select path="horoscope_available"
										id="matri_horoscope_available" value="horoscope_available">
										<form:option value="" label="Select..." />
										<form:option value="NVRM" label="Never married"/>
										<form:option value="DIVR" label="Divorced"/>
										<form:option value="ANNL" label="Annulled"/>
										<form:option value="WITD" label="Waiting for Divorce"/>
									</form:select>
									<form:errors path="horoscope_available" cssClass="error" />
									<br />
									<form:hidden path="sa_status_flg" id="sa_status_flg" />
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
											<input type="submit" id="submit_matrimonyForm"
												class="btn  btn-primary"
												style="width: 28%; margin: 2% 2% 1% 2%" value="Update"
												formaction="/saleAgreementupdated/${saId}" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="submit_matrimonyForm"
												class="btn  btn-primary"
												style="width: 28%; margin: 2% 2% 1% 2%" value="Submit" />
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${updateFlag == 'update'}">
											<input type="submit" id="submit_matrimonyForm"
												class="btn  btn-primary" style="width: 41%" value="Update"
												formaction="/saleAgreementupdated/${saId}" />
										</c:when>
										<c:otherwise>
											<input type="submit" id="submit_matrimonyForm"
												class="btn  btn-primary" style="width: 41%" value="Submit" />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

							<c:if test="${activate == 'activate'}">
								<input type="submit" id="submit_matrimonyForm"
									class="btn  btn-primary"
									style="width: 28%; margin: 2% 2% 1% 2%" value="activate"
									formaction="/activateUser/${saId}" />
							</c:if>
							<c:choose>
								<c:when test="${activate == 'activate'}">
									<input type="button" id="cancel_matrimonyForm"
										class="btn btn-default"
										style="width: 28%; margin: 2% 2% 1% 2%"
										onclick="window.history.back()" value="Cancel" />
								</c:when>
								<c:otherwise>
									<input type="button" id="cancel_matrimonyForm"
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
	<!-- <script src="/js/main.js"></script> -->
	<script src="/js/pikaday.js"></script>
</body>
<script src="/js/moment.min.js"></script>
</body>
</html>
<script>
	var picker = new Pikaday({
		field : $('#matri_dob')[0],
		format : 'DD/MM/YYYY HH:MM',
		showTime : false,
		yearRange : [ 1950, new Date().getFullYear() ],
		onSelect : function() {
			$('#matri_dob').val(moment(picker.getDate()).format("DD/MM/YYYY HH:MM"));
		}
	});

	$('#agreement_type')
			.on(
					'change',
					function() {
						$(this).parent().find('.innerErrSpn').remove();

						var checkElement = $("#agreement_type");
						var x = checkElement[0].id;
						var span_id = 'showError' + x;

						if (this.value == 0) {
							showErrIcon(1, $(this).attr('id'));
							$("<span/>", {
								'id' : span_id
							})
									.addClass(
											'error glyphicon glyphicon-warning-sign span-error')
									.text(' Please select a Agreement Type ')
									.insertAfter(checkElement);
							checkElement.removeClass("valid").addClass(
									"invalid");
						} else {
							showErrIcon(2, $(this).attr('id'));
							checkElement.removeClass("invalid").addClass(
									"valid");
							$('#' + span_id).remove();
						}

					})
</script>