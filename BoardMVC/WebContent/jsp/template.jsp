<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="lib/bootstrap-4.1.3/css/bootstrap.css" />
<link rel="stylesheet" href="css/template.css" />
<link rel="stylesheet" href='css/${content}.css'>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top.jsp" />
	<jsp:include page="nav.jsp" />
	<div class="container">
		<jsp:include page='${content}.jsp' />
	</div>
	<jsp:include page="bottom.jsp" />

	<script src="lib/jQuery-3.3.1.js"></script>
	<script src="lib/bootstrap-4.1.3/js/bootstrap.bundle.js"></script>
</body>
</html>