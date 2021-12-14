<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    
    
    
<link rel="stylesheet" href="/resources/css/login.css"/>
</head>
<body>
<div class="container center-contents">
	<div class="row">
	<form class="form-signin" method="post" action="">
		<div class="form-group">
			<label for="userid" class="sr-only">아이디</label> 
			<input type="text" id="userid" name="userid" class="form-control" placeholder="아이디" required autofocus /> 
		</div>
		<div class="form-group">
			<label for="inputPassword" class="sr-only">비밀번호</label> 
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="비밀번호" required />
		</div>
		<div class="form-group">
			<label for="email" class="sr-only">이메일</label> 
			<input type="email" id="email" name="email" class="form-control" placeholder="email" required />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="form-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
		</div>
	</form>
	</div>
</div>
</body>
</html>