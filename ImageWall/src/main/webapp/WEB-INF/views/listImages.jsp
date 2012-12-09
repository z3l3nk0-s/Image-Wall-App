<%@ include file="/WEB-INF/views/include.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/themes/cool/css/bootstrap.css" />"
	type="text/css" />
</head>
<body>

<div class="container">
kkk <br>
${hashTag.name}
${hashTag.id}
	<br>
			<c:forEach var="image" items="${images}">
				<spring:url value="/image/{id}" var="image_url">
					<spring:param name="id" value="${image.id}" />
				</spring:url>
						<a href="${image_url}">
						<img alt="thumbnail" src="/ImageWall/image/getthumbnail/${image.id}"></a>
						<br>					
				
			</c:forEach>
</div>

</body>
</html>
