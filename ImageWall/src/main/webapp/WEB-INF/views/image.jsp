<%@ include file="/WEB-INF/views/include.jsp"%>

<c:set var="now" value="<%=new java.util.Date()%>" />

<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/themes/cool/css/bootstrap.css" />"
	type="text/css" />
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 60px;
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
		<img alt="Logo" src="getimage/${id}">
		<h2>Hello World!</h2>
		<br /> <small>Current time is: <fmt:formatDate value="${now}"
				pattern="hh:mm MMM d, yyyy" />
		</small>
	</div>
</body>
</html>
