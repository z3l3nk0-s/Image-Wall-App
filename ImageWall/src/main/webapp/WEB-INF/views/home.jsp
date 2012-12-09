<%@ include file="/WEB-INF/views/include.jsp"%>


<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/themes/cool/css/bootstrap.css" />"
	type="text/css" />
	<link rel="stylesheet"
	href="<c:url value="/resources/themes/cool/css/bootstrap-responsive.css" />"
	type="text/css" />

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 6s0px;
}
</style>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">Image wall</a>
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		aaaaaaaaaaaaaaaaaaaaa
		<c:forEach var="tag" items="${tags}">
			<spring:url value="/tag/{name}" var="tag_url">
				<spring:param name="name" value="${tag.name}" />
			</spring:url>
			<a href="${tag_url}">${tag.name}</a>
			<br>

		</c:forEach>
	</div>
</body>
</html>
