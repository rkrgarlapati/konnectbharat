<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="/js/pikaday.js"></script>
<script src="/js/moment.min.js"></script>

<form:form id="contact_form" class="contact_form_class" method="POST"
	action="/updateCustomerContact" commandName="custContactAttributes">
	<div id="con_contact_form" class="container-fluid">
		<div class="row text-center contact_form_head">
			<h3>Customer Contact</h3>
		</div>

		<div class="row gropElements elementsBorder">
			<div id="message" style="text-align: center">
				<div style="display: inline-block;">
					<div class="alert alert-success" id="success-alert"
						 style="padding: 15px">

					</div>
				</div>
			</div>
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
						<form:input path="agreementId" id="agreementId"
							onclick="agreementPick()" class="form-control" />
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
					<form:input path="datetime" id="datetime"
						class="form-control" />
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
					<%-- <form:input path="communicationType" id="communicationType" /> --%>
					<form:select path="communicationtype" id="communicationtype"
						class="form-control" value="${communicationtype.title}">
						<form:option value="" label="Select..." />
						<form:option value="M" label="Marketting" />
						<form:option value="C" label="Complaint" />
						<form:option value="Q" label="Query" />
						<form:option value="R" label="Rates" />
						<form:options items="${communicationTypeList}"
							itemValue="communicationTypeid" itemLabel="communicationTypelbl" />
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
					<%-- <form:input path="status" id="status" /> --%>
					<form:select path="status" id="status" value="${status.title}">
						<form:option value="10" label="Open" />
						<form:option value="20" label="Assigned" />
						<form:option value="30" label="Work In Progress" />
						<form:option value="40" label="Cancelled" />
						<form:option value="50" label="Closed" />
						<form:options items="${statusList}" itemValue="statusid"
							itemLabel="statuslbl" />
					</form:select>
					<form:errors path="status" cssClass="error" />
					<br />
				</div>
				<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
					<form:label path="priority">
						<spring:message code="cust_priority" />
					</form:label>
					<%-- <form:input path="priority" id="priority" /> --%>
					<form:select path="priority" id="priority" class="form-control"
						value="${status.title}">
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

			<div>
				<div class="col-xm-12 col-sm-12 col-md-4 col-lg-6">
					<form:label path="assignedTo">
						<spring:message code="cust_asignto" />
					</form:label>
					<form:input path="assignedTo" id="assignedTo"
						class="form-control"  />
					<form:errors path="assignedTo" cssClass="error" />
					<br />
				</div>
				<div class="col-xm-12 col-sm-12 col-md-4 col-lg-6">
			
					<form:label path="assignedDate">
						<spring:message code="cust_asigndt" />
					</form:label>
					<form:input path="assignedDate" id="assignedDate"
						 class="form-control" />
					<form:errors path="assignedDate" cssClass="error" />
					<br />
				
				</div>
			</div>
				<div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
				<form:label path="comments">
					<spring:message code="cust_comments" />
				</form:label>
				<form:textarea path="comments" id="comments" class="form-control" />
				<form:errors path="comments" cssClass="error" />
				<br />
			</div>
		</div>

		<input type="submit" id="submit_contactForm" class="btn  btn-primary" style="width: 50%; margin: 2% 2% 1% 25%"
			value="Update" />

	</div>
	<input type="hidden" id="contactpopupflg" value="true">


	<input type="hidden" id="elementId" value="${custContactAttributes.communicationId}">
</form:form>
<div class="modal fade" id="agreementPickModel" role="dialog">
		<div class="modal-dialog modal-sm" style="width: 70%">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header alert-info">
					<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
					<i class="fa fa-times" id="aggreement_close_ico" aria-hidden="true" style="float: right;cursor: pointer"></i>
					<h4 class="modal-title ">Agreements</h4>
				</div>
				<div class="modal-body">
					<div id="agreemnts"></div>
				</div>
			</div>

		</div>
	</div>
<div class="modal fade" id="emp_infobox" role="dialog" style="top:35%">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Contact</h4>
			</div>
			<div class="modal-body">
				<p id="emp_infobox_msg"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
			</div>
		</div>

	</div>
</div>
<script src="/js/main.js"></script>
<script type="text/javascript">	
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
	
	var pickerAsignedDt = new Pikaday({
		field : document.getElementById('assignedDate'),
		defaultDate: moment().toDate(),
		format : 'DD/MM/YYYY HH:MM',
		yearRange : [ 1950, new Date().getFullYear() ],
		onSelect : function() {
			$('#assignedDate').val(moment(pickerAsignedDt.getDate()).format("DD/MM/YYYY HH:MM"));
		}
	});
	
	
	if($('#datetime').val().length==0){
		$('#datetime').val(getCurDateTime());
	}
</script>
<script>$("#success-alert").hide();</script>