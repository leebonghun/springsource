<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet" />
</head>
<body>
	<form class="form-signin" method="post" action="/login">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputId" class="sr-only">아이디</label>
      <input
        type="text"
        id="inputId"
        name="username"
        class="form-control"
        placeholder="아이디"
        required
        autofocus
      />
      <label for="inputPassword" class="sr-only">비밀번호</label>
      <input
        type="password"
        id="inputPassword"
        name="password"
        class="form-control"
        placeholder="비밀번호"
        required
      />
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" name="remember-me" /> Remember me
          
          
        </label>
      </div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Sign in
      </button>
      <div class="error-message">
      	<span>${loginError}</span>
      </div>
      
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
</body>
</html>