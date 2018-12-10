<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="resources/css/font-awesome.css">
		<link rel="stylesheet" href="resources/css/login.css">		
		<!-- google fonts  -->
		<link href="//fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700" rel="stylesheet">
	</head>
	<body>
		<div class="agile-login">
			<h1>共享题库智能组卷系统</h1>
			<div class="wrapper">
				<h2>找回密码</h2>
				<div class="login-form">
					<h3><font color="red" id="errormsg">${msg }</font></h3>
					<form action="updatePwd" method="post" id="updatePwdform" onSubmit="return checkForm()">
						<label>手机号</label>
						<input type="text" name="phone" id="phone" value="${phone }" readonly="true"/>
						<label>密码</label>
						<input type="password" name="password" id="password" placeholder="密码" required/>
						<label>再次输入</label>
						<input type="password" name="password2" id="password2" placeholder="再次输入" required/>
						<a href="login" class="login">登录</a>
						<input type="submit" value="确认" />
					</form>
				</div>
			</div>
		</div>			
		<script type="text/javascript">
		function checkForm() {
			var password = document.getElementById("password"); 
			var password2 = document.getElementById("password2"); 
	        var passwordRegex = /^[a-zA-Z0-9]{6,20}$/;
			if(password.value.length == 0){ 
			    alert("新密码不能为空！");
			    return false; 
		    }
			if(password2.value.length == 0){ 
			    alert("请再次输入密码！");
			    return false; 
		    }
			if(!passwordRegex.test(password.value)){ 
			    alert("密码不合法！请输入6-20位数字或字母！");
			    return false; 
		    }
			if(password.value != password2.value) {
				alert("两次密码输入不一致！");
			    return false; 
			}
			return true;
		}
        </script>
	</body>
</html>
