<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Basic</h1>
<!-- UserDTO 가 userDTO 로 바꿔서 사용  -->
<h3>userid : ${userDTO.userid }</h3>
<h3>password : ${userDTO.password }</h3>

<hr/>

<h3>userid : ${login.userid }</h3>
<h3>password : ${login.password }</h3>
<h3>name : ${login.name }</h3>
<hr/>

<h3>userid : ${userid }</h3>
<h3>password : ${password }</h3>
</body>
</html>