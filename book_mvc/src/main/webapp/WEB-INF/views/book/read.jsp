<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<form action="" method="post">
	
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
		<input type="text" name="price" id="price" class="form-control" readonly="readonly" value="${bookDto.price}"/>
	</div>
	
	<button type="button" class="btn btn-primary">수정</button>
	<button type="button" class="btn btn-danger">삭제</button>
	<button type="button" class="btn btn-secondary">목록</button>





</form>
<form action="" id="actionForm">
	<input type="hidden" name="code" value="${bookDto.code}"/>
</form>

<script src="/resources/js/read.js"></script>
<%@include file="../includes/footer.jsp" %>
