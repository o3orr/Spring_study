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
<form role="form" action="/board/modify" method="post">
  <div class="form-group">
    <label>bno</label>
    <input name="bno" class="form-control" value="${board.bno }" readonly="readonly">
  </div>
  
  <div class="form-group">
    <label>title</label>
	<input name="title" class="form-control" value="<c:out value='${board.title}'/>">
  </div>
  
  <div class="form-group">
    <label>Text Area</label>
    <textarea name="content" rows="3" class="form-control">
	${board.content}
	</textarea>
  </div>
  
  <div class="form-group">
    <label>Writer</label>
    <input name="writer" class="form-control" value="${board.writer }" readonly="readonly"></textarea>
  </div>
  
  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
  
  </form>
<script  type="text/javascript">
$(document).ready(function(){
	
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		console.log("operation : " + operation);
		
		if(operation === 'remove'){
			formObj.attr("action", "/board/remove");
		}else if(operation === 'list'){
			formObj.attr("action", "/board/list").attr("method","get");
			formObj.empty();
		}
		formObj.submit();
	})
});
	
</script>
</body>
</html>