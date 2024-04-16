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
						<td><a class="move" href='${board.bno}'/> ${board.title}</td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/>	</td>
						<td><fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd"/>	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- 페이징 처리 -->
	<div class="container">
	  <ul class="pagination">
	  	
	  	<c:if test="${pageMaker.prev }">
	  	<!-- 아 15페이지에서 이전버튼을 누르면 그페이지 startpage보다 하나 적게가게그러니까 10페이지로 이동하게 -->
	  	 <li class="page-item"><a class="page-link" href="${pageMaker.startPage - 1 }">Previous</a></li>
	  	</c:if>
		   
		<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }"> 
		 <li class="page-item"><a class="page-link" href="${num }">${num }</a></li>
		</c:forEach>
	
		<c:if test="${pageMaker.next}">
		<!-- 이것도 같은 원리 -->
	  	 <li class="page-item"><a class="page-link" href="${pageMaker.endPage + 1 }">Next</a></li>
	  	</c:if>
	
	  </ul>
	</div>
	<!-- 페이징 End -->
	
	<form id="actionForm" action="/board/list" method="get">
		<!-- 서버에 pageNum과 amount를 파라미터로 넘겨줌 -->
		<!-- 그럼 boardlist에서 처리를 해서 프론트로 보냄 -->
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
	</form>
	
	
	
<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}" />';
		
		//버튼누르면 register호출
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
		
		/* 페이지 번호 클릭하면 페이지 이동 */
		var actionForm = $("#actionForm");
		$(".page-item a").on("click", function(e){
			e.preventDefault();
			console.log("click");
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
		
		
		/* 상세페이지(get.jsp)이동 시 pageNum, amount값이 가지고 이동 */
		$(".move").on("click", function(e){
		    e.preventDefault();
		    // 기존의 숨겨진 'bno' 입력을 지워 중복을 방지
		    actionForm.find("input[name='bno']").remove();
		    // 새로운 숨겨진 입력 추가
		    actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href") + "'>");
		    actionForm.attr("action", "/board/get");
		    actionForm.submit();
		});
		
	});

</script>
</body>
</html>