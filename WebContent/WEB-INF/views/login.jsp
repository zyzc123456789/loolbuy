<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form id="fromLogin" method="POST" action="login.jhtml" >
		<span>用户名</span><input id="username" name="username" value=""/>
		<span>密码</span><input id="password" name="password" value = ""/>
		<span id="errmsg">${message}</span>
        <button type="submit">登录</button>
	</form>
</body>
</html>