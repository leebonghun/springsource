<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<form action="/book/update" method="post">
	
	<div class="form-group">
		<label for="code">Code</label>
		<input type="text" name="code" id="code" class="form-control" readonly="readonly" value="${bookDto.code}"/>
	</div>
	<div class="form-group">
		<label for="title">Title</label>
		<input type="text" name="title" id="title" class="form-control" readonly="readonly" value="${bookDto.title}"/>
	</div>
	<div class="form-group">
		<label for="writer">Writer</label>
		<input type="text" name="writer" id="writer" class="form-control" readonly="readonly" value="${bookDto.writer}"/>
	</div>
	<div class="form-group">
		<label for="price">Price</label>
		<input type="text" name="price" id="price" class="form-control"  value="${bookDto.price}"/>
	</div>
	
	<button type="submit" class="btn btn-primary">수정</button>
	<button type="button" class="btn btn-secondary" onclick="location.href='/book/list'">목록</button>


</form>
<%@include file="../includes/footer.jsp" %>
