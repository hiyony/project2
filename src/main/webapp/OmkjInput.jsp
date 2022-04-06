<%@ page import = "omikuji.InputForm" %>
<%@ page import = "omikuji.ActionInput" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
<style>
	#input-form input{
		padding : 5px 10px;
		text-align : center;
	}
	p{
		color : red;
	}
</style>
</head>
<body>
	<% 
		request.setCharacterEncoding("UTF-8");
		String flag = String.valueOf(request.getAttribute("flag"));
	%>
	<h1>Omikuji Web Service</h1>
	<form action = "input.do" method = "POST" id = "input-form">
		<span>お誕生日を入力してください！</span>
		<input type = "text" name = "birthday" placeholder = "yyyyMMddの形式" />
		<input type = "submit" value = "確認" />
		<p><%= check(flag) %></p>
	</form>
</body>
</html>

<%!
	private String check(String flag){
		if(flag.equals("false")){
			return "入力された形式が正しくありません。yyyyMMdd形式の８文字でお願いします。";
		} else{
			return " ";
		}
	}
%>