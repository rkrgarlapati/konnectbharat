<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Customer Confirmation...</title>
</head>
<body>

	Customer ID :
	<b>${customer.per_id}</b> created successfull...
	<a href="/login">Back to HomePage</a>
	<table>
		<tr>
			<td>Name :</td>
			<td>${customer.per_name}</td>
		</tr>
	</table>
</body>
</html>