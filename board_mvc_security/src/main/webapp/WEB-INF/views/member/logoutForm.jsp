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
	<form class="form-signin" method="post" action="/customLogout">
     
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
       logout
      </button>
    </form>
</body>
</html>