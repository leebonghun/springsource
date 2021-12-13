<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/resources/css/upload.css" />
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="" method="post" role="form">
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno"
							readonly="readonly" value="${read.bno}">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value="${read.title}">
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" rows="3" name="content">${read.content}</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							readonly="readonly" value="${read.writer}">
					</div>
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- 첨부파일 등록  -->
<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-files-o"></i>파일첨부
			</div>
			<div class="panel-body">
			<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" id="" multiple />
				</div>
				<div class="uploadResult">
					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>
<%-- remove와 list를 위한 폼--%>


<form action="" id="actionForm">
	<input type="hidden" name="pageNum" value="${cri.pageNum}" /> <input
		type="hidden" name="amount" value="${cri.amount}" /> <input
		type="hidden" name="type" value="${cri.type}" /> <input type="hidden"
		name="keyword" value="${cri.keyword}" /> <input type="hidden"
		name="bno" value="${read.bno}" />
</form>
<script>
	//현재 글번호 가져오기
	let bno = ${read.bno};	
</script>   
<script src="/resources/js/modify.js"></script>


<%-- 스크립트 --%>
<%@include file="../includes/footer.jsp"%>










