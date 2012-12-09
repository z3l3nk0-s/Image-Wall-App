<%@ include file="/WEB-INF/views/include.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/themes/cool/css/bootstrap.css" />"
	type="text/css" />
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Email</th>
				<th>Username</th>
				<th>Roles</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="user" items="${users}">
				<spring:url value="/user/{user_id}" var="user_url">
					<spring:param name="user_id" value="${user.id}" />
				</spring:url>
				<tr>
					<td>
						<a href="${user_url}">${user.username}</a>
					</td>
					<td>${user.email}</td>
					<td><c:forEach var="role" items="${user.authorities}">     
						${role.role}
					</c:forEach></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>
</body>
</html>
