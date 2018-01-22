<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/Login/styles.css" rel="stylesheet" type="text/css" />
<meta name="viewport"  content="width=device-width"/>
<title>Login</title>
	
</head>
<body>
	<div id="container">
	<br>
	<center>
	<br/><br/><br/>
	<img src="./resources/Image/Page_Group.jpg" id="imgLogo" width="270">
	</center>
	<br/>

		<form action="Login" id="Login" method="post">
			<label for="username" id="name"> Usuário: </label> 
			<input id="txtUser" name="User" type="text" value=""> 
			<label for="password" id="password"> Senha: </label> 
			<input id="txtPassword" name="Password" type="password">
			<div id="lower">
				<input type="submit" value="Login" id="btnLogin">
			</div>
		</form>
	</div>
</body>
</html>