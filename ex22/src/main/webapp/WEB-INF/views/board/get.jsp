<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

  <div class="form-group">
    <label>bno</label>
    <input name="bno" class="form-control" value="${board.bno }" readonly="readonly">
  </div>
  
  <div class="form-group">
    <label>title</label>
	<input name="title" class="form-control" value="<c:out value='${board.title}'/>" readonly="readonly">
  </div>
  
  <div class="form-group">
    <label>Text Area</label>
    <textarea name="content" rows="3" class="form-control" readonly="readonly">
	${board.content}
	</textarea>
  </div>
  
  <div class="form-group">
    <label>Writer</label>
    <input name="writer" class="form-control" value="${board.writer }" readonly="readonly"></textarea>
  </div>
  
  <button data-oper='modify' class="btn btn-default">Modify</button>
  <button data-oper="list" class="btn btn-info">List</button>
  
  <!-- modify, list로 요청할때 pageNum과 amount가 같이 가도록 -->
  <form id="operForm" action="/board/modify" method="get">
  	<input type="hidden" id="bno" name="bno" value="${board.bno }">
  	<input type="hidden" name="pageNum" value="${cri.pageNum }">
  	<input type="hidden" name="amount" value="${cri.amount }">
  </form>
<script>
	$(document).ready(function(){
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		})
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit()
		})
	})
	
</script>
</body>
</html>