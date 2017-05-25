<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Form</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link rel="stylesheet" type="text/css" href="/css/pikaday.css" />
<!-- <link
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet"> -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

</head>
<body>
	<div class="conatiner" style=" margin-bottom: 10%">

		<jsp:include page="header.jsp"></jsp:include>


		<div class="container" id="section1" style="margin-left: initial;">

			<row> <jsp:include page="left_menu_sub.jsp"></jsp:include>
			<div class="col-md-9">
				<div class="col-md-12">

					<form:form id="contact_form" class="contact_form_class"
						method="POST" action="/addNewCustomerContact"
						commandName="custContactAttributes">
						<div id="con_contact_form" class="container-fluid">
							<div class="row text-center contact_form_head">
								<h3>Customer Contact</h3>
							</div>

							<div class="row gropElements elementsBorder">

								<div>
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-6">
										<form:label path="communicationId">
											<spring:message code="cust_communicationid" />
										</form:label>
										<form:input path="communicationId" id="communicationId"
											class="form-control" readonly="true" />
										<form:errors path="communicationId" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-6">
										<div style="width: 92%; float: left;">
											<form:label path="agreementId">
												<spring:message code="cust_agreementid" />
											</form:label>
											<c:choose>
												<c:when test="${updateFlag == 'update'}">
													<form:input path="agreementId" id="agreementId"
														class="form-control" readonly="true" />
												</c:when>
												<c:otherwise>
													<form:input path="agreementId" id="agreementId"
														onclick="agreementPick()" class="form-control" />
												</c:otherwise>
											</c:choose>
											<form:errors path="agreementId" cssClass="error" />
											<br />
										</div>
									</div>
								</div>


								<div>

									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="datetime">
												<spring:message code="cust_datetime" />
											</form:label>
											<form:input path="datetime" id="datetime"  class="form-control"/>
											<form:errors path="datetime" cssClass="error" />
											<br />
										</div>
										<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="communicationclass">
											<spring:message code="cust_communicationclass" />
										</form:label>
										<%-- <form:input path="communicationclass" id="communicationclass" /> --%>
										<form:select path="communicationclass" id="communicationclass"
											class="form-control" value="${communicationclass.title}">
											<form:option value="" label="Select..." />
											<form:option value="CT" label="Customer" />
											<form:option value="CP" label="Company" />
											<form:options items="${communicationClassList}"
												itemValue="communicationClassid"
												itemLabel="communicationClasslbl" />
										</form:select>
										<form:errors path="communicationclass" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
										<form:label path="communicationtype">
											<spring:message code="cust_communicationtype" />
										</form:label>
										<%-- <form:input path="communicationtype" id="communicationtype" /> --%>
										<form:select path="communicationtype" id="communicationtype"
											class="form-control" value="${communicationtype.title}">
											<form:option value="" label="Select..." />
											<form:option value="M" label="Marketting" />
											<form:option value="C" label="Complaint" />
											<form:option value="Q" label="Query" />
											<form:option value="R" label="Rates" />
											<form:options items="${communicationTypeList}"
												itemValue="communicationTypeid"
												itemLabel="communicationTypelbl" />
										</form:select>
										<form:errors path="communicationtype" cssClass="error" />
										<br />
									</div>
								</div>


								<div>
									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="status">
											<spring:message code="cust_status" />
										</form:label>
										<c:choose>
											<c:when test="${updateFlag == 'update'}">
												<form:select path="status" id="status">
													<form:option value="10" label="Open" />
													<form:option value="20" label="Assigned" />
													<form:option value="30" label="Closed" />
													<form:option value="40" label="Cancelled" />
													<form:options items="${statusList}" itemValue="statusid"
														itemLabel="statuslbl" />
												</form:select>
											</c:when>
											<c:otherwise>
												<form:input path="status" id="status" class="form-control"
													readonly="true" value="Pending" />
											</c:otherwise>
										</c:choose>
										<form:errors path="status" cssClass="error" />
										<br />
									</div>
									<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
										<form:label path="priority">
											<spring:message code="cust_priority" />
										</form:label>
										<%-- <form:input path="priority" id="priority" /> --%>
										<form:select path="priority" id="priority"
											class="form-control" value="${status.title}">
											<form:option value="3" label="Low" />
											<form:option value="2" label="Medium" />
											<form:option value="1" label="High" />
											<form:options items="${priorityList}" itemValue="priorityid"
												itemLabel="prioritylbl" />
										</form:select>
										<form:errors path="priority" cssClass="error" />
										<br />
									</div>
								</div>


								<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
									<form:label path="comments">
										<spring:message code="cust_comments" />
									</form:label>
									<form:textarea path="comments" id="comments"
										class="form-control" />
									<form:errors path="comments" cssClass="error" />
									<br />
								</div>
							</div>
							<c:choose>
								<c:when test="${updateFlag == 'update'}">
									<input type="submit" id="submit_contactForm"
										class="btn  btn-primary" value="Update"
										formaction="/updateCustomerContact" />
								</c:when>
								<c:otherwise>
									<input type="submit" id="submit_contactForm"
										class="btn  btn-primary" value="Submit" />
								</c:otherwise>
							</c:choose>
							<input type="button" id="cancel_contactForm"
								class="btn btn-default" onclick="window.history.back()"
								value="Cancel" />
						</div>
					</form:form>
				</div>
			</div>
			</row>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<div class="modal fade" id="agreementPickModel" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 50%">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header alert-info">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title ">Agreements</h4>
				</div>
				<div class="modal-body">
					<div id="agreemnts"></div>
				</div>
			</div>

		</div>
	</div>
	<!-- Modal -->



	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/pikaday.js"></script>
	<script src="/js/moment.min.js"></script>
	<!-- <script
		src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script> -->
</body>

</body>
<script type="text/javascript">
	/* $(function() {
		var dateNow = new Date();
		$('#dateAndTime').datetimepicker({
			defaultDate:dateNow
		});

	}); */
	
	var picker = new Pikaday({
		field : document.getElementById('datetime'),
		defaultDate: moment().toDate(),
		format : 'DD/MM/YYYY HH:MM',
		showTime : true,
		yearRange : [ 1950, new Date().getFullYear() ],
		onSelect : function() {
			$('#datetime').val(moment(picker.getDate()).format("DD/MM/YYYY HH:MM"));
		}
	});
	if($('#datetime').val().length==0){
		$('#datetime').val(getCurDateTime());
	}
</script>
</body>
</html>
