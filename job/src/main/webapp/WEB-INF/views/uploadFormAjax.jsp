<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 연습</title>
<link rel="stylesheet" href="/resources/css/upload.css" />
</head>
<body>
<form action="" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile" id="" multiple/>
	<button id="uploadBtn">보내기</button>
</form>
<div class="uploadResult">
	<ul></ul>
</div>
<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>





<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="/resources/js/upload.js"></script>
</body>
</html>