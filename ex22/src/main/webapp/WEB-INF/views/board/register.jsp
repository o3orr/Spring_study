<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>Register page</h1>
	<form action="/board/register" method="post">

		<div class="form-group">
			<label>title</label> 
			<input name="title" class="form-control">
		</div>

		<div class="form-group">
			<label>Text Area</label>
			<textarea name="content" rows="3" class="form-control"></textarea>
		</div>

		<div class="form-group">
			<label>Writer</label> 
			<input name="writer" class="form-control">
		</div>

		<button type="submit" class="btn btn-default">Submit Button</button>
		<button type="reset" class="btn btn-default">Reset Button</button>
	</form>

</body>
</html>