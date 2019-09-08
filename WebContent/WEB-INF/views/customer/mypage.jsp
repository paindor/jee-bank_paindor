<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>환영합니다</h1>'
	<h2>환영합니다.${customer.name}님</h2>
	<h2>아이디 ${customer.id}</h2>
	<h2>비밀번호 ${customer.pw}</h2>
	<h2>주민번호${customer.ssn}</h2>
	<h2>신용등급${customer.credit}</h2>
	<input type="hidden" name = "action" value = "mypage"  />
	
	

</body>
</html>