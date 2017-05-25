<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<table class="table table-bordered table-hover" id="agreements">
		<thead>
			<tr>
				<th width="10%">Agreement ID</th>
				<th width="10%">Name</th>
				<th width="10%">Type</th>
				<th width="10%">Created Date</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty accountDetails}">
				<c:forEach var="account" items="${accountDetails}">
					<tr style="cursor: pointer">
						<td width="5%">${account.sa_id}</td>
						<td width="10%">${account.actual_party_name}</td>
						<td width="10%">${account.type}</td>
						<td width="10%">${account.start_dt}</td>
					</tr>
				</c:forEach>
			</c:if>

		</tbody>
	</table>
</div>
<script>
	$("#agreements  tr").click(function() {
		$('#agreementPickModel').modal('hide');
		$('#agreementId').val($(this).children(":first").text())
	});
</script>