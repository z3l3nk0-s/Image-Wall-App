<%@ include file="/WEB-INF/views/include.jsp"%>


<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/themes/cool/css/bootstrap.css" />"
	type="text/css" />
<title>Upload a file please</title>
</head>
<body>
	<div class="container">
		<h1>Please upload a file</h1>

		<form:form method="POST" modelAttribute="data"
			enctype="multipart/form-data">
			<table>

				<tr>
					<td><label for="tag_name"> Tag name</label></td>
					<td><form:input path="tag" id="tag_name" /></td>
				</tr>
				<tr>
					<td><label for="longitude"> longitude</label></td>
					<td><form:input path="geoLongitude" id="longitude" /></td>
				</tr>
				<tr>
					<td><label for="latitude"> latitude</label></td>
					<td><form:input path="geoLatitude" id="latitude" /></td>
				</tr>
				<tr>
					<td><label for="image"> Profile image</label></td>
					<td><input name="image" type="file"></td>
				</tr>

				<tr>
					<td><input name="batn" type="submit"></td>
				</tr>

			</table>


		</form:form>
	</div>
</body>
</html>
