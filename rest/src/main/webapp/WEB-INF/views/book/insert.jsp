<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<form action="" method="post">
	
	<div class="form-group">
		<label for="code">Code</label>
		<input type="text" name="code" id="code" class="form-control" required="required" placeholder="Code"/>
	</div>
	<div class="form-group">
		<label for="title">Title</label>
		<input type="text" name="title" id="title" class="form-control" required="required" placeholder="Title"/>
	</div>
	<div class="form-group">
		<label for="writer">Writer</label>
		<input type="text" name="writer" id="writer" class="form-control" required="required" placeholder="Writer"/>
	</div>
	<div class="form-group">
		<label for="price">Price</label>
		<input type="text" name="price" id="price" class="form-control" required="required" placeholder="Price"/>
	</div>
	
	<button type="submit" class="btn btn-primary">입력</button>
	<button type="reset" class="btn btn-secondary">취소</button>










</form>
<script src="/resources/js/insert.js"></script>
<%@include file="../includes/footer.jsp" %>
