<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="container">
		<h2>list Page</h2>
		<button id="regBtn" type="button">Register New Board</button>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>BNO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th>UPDATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.bno }</td>
						<!-- 제목을 클릭하면 글 상세 페이지로 가게 -->
						<td><a href='/board/get?bno=${board.bno }'>${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/>	</td>
						<td><fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd"/>	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}" />';
		
		//버튼누르면 register호출
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		})
	})

</script>
</body>
</html>