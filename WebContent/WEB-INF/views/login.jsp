<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
	function login(){
		 $.ajax({
		        type: "POST",
		        async: false,
		        url: "/login.jhtml" ,
		        data: {
		        	userNm:$("#userNm").val(),
		 			password:$("#password").val()
		        },
		        success: function (data) {
		           alert(data);
		        }
		    });
	}
</script>
</head>
<body>
	<span>用户名</span><input id="userNm" value=""/>
	<span>密码</span><input id="password" value = ""/>
	<span id="errmsg"></span>
	<input type="button" value="登录" onclick="login();"></button>
</body>
</html>