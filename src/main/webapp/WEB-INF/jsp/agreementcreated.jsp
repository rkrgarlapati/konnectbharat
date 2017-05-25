<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="text-align: center;">
	<span> <c:if test="${updateFlag == 'update'}">
			Agreement Updated Successful  <a href="/guestFormController">Back
				to HomePage</a>
		</c:if> <c:if test="${updateFlag == 'activate'}">
			Agreement Activated Successful  <a href="/guestFormController">Back
				to HomePage</a>
		</c:if> <c:if test="${updateFlag == 'create'}">
			Agreement Created Successful  <a href="/guestFormController">Back
				to HomePage</a>
		</c:if>
	</span>
</div>