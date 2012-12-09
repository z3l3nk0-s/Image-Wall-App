<%@ include file="/WEB-INF/views/include.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%-- <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" --%>
<!-- 	type="text/css" /> -->

<link rel="stylesheet" href="<c:url value="/resources/themes/cool/css/bootstrap.css" />" 
	type="text/css" />

</head>
<body>
	<form:form commandName="user" >
		<legend>Edit person</legend>

		<label class="control-label" for="username">Username:</label>

		<div class="controls">
			<form:input path="username" />
			<span class="help-inline"><form:errors path="username" /></span>
		</div>

		<div class="control-group error">
			<label class="control-label" for="email">Email:</label>
			<div class="controls">
				<form:input path="email" />
				<span class="help-inline"><form:errors path="email" /></span>
			</div>
		</div>

<!-- 		<div class="control-group error"> -->
<!-- 			<label class="control-label" for="address">Password:</label> -->
<!-- 			<div class="controls"> -->
<%-- 				<form:textarea path="address" /> --%>
<%-- 				<span class="help-inline"><form:errors path="address" /></span> --%>
<!-- 			</div> -->
<!-- 		</div> -->

		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Save Changes</button>
			<button type="button" class="btn">Cancel</button>
		</div>
	</form:form>
</body>
</html>
