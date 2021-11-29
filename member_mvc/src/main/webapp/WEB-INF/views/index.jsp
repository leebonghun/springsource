<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Spring WebMVC</h1>
			<hr class="my-4">
			<c:if test="${empty loginDto}">
				<a class="btn btn-primary btn-lg" href="/register/step1"
					role="button">회원가입</a>
				<a class="btn btn-success btn-lg" href="/member/signin"
					role="button">로그인</a>
			</c:if>

			<c:if test="${!empty loginDto}">
				<a class="btn btn-primary btn-lg" href="/member/changePwd"
					role="button">비밀번호변경</a>
				<a class="btn btn-success btn-lg" href="/member/logout"
					role="button">로그아웃</a>
				<a class="btn btn-danger btn-lg" href="/member/leave" role="button">회원탈퇴</a>
			</c:if>
		</div>
	</div>
</body>
</html>