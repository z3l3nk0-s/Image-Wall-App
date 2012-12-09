<%@ include file="/WEB-INF/views/include.jsp"%>

<c:set var="now" value="<%=new java.util.Date()%>" />

<html>
<body>
	<img alt="Logo" src="resources/images/logo.png">
	<h2>Hello World!</h2>
	<br />
	<small>Current time is: <fmt:formatDate value="${now}"
			pattern="hh:mm MMM d, yyyy" /> </small>

</body>
</html>
