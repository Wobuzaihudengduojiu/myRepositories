<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="resources/css/font-awesome.css">
		<link rel="stylesheet" href="resources/css/login.css">		
		<!-- google fonts  -->
	</head>
	<body>
		<div class="agile-login">
			<h1>共享题库智能组卷系统</h1>
			<div class="wrapper">
				<h2>登录</h2>
				<div class="login-form">
					<h3><font color="red" id="errormsg">${msg }</font></h3>
					<form action="main" method="post" id="loginform" onSubmit="return checkForm()">
						<label>手机号</label>
						<input type="text" name="phone" id="phone" placeholder="手机号" required/>
						<label>密码</label>
						<input type="password" name="password" id="password" placeholder="密码" required />
						<a href="doRegister" class="register">注册</a>
						<a href="findPwd" class="pass">忘记密码?</a>
						<input type="submit" value="登录" />
					</form>
				</div>
			</div>
		</div>		
		<script type="text/javascript">
		function checkForm() {
			var phone = document.getElementById("phone"); 
			var password = document.getElementById("password"); 
			var phoneRegex = /^1[3|4|5|8][0-9]\d{8}$/;
	        var passwordRegex = /^[a-zA-Z0-9]{6,20}$/;
			if(phone.value.length == 0){ 
			    alert("手机号不能为空！");
			    return false; 
		    }
			if(!phoneRegex.test(phone.value)){ 
			    alert("请输入正确的手机号格式！");
			    return false; 
		    }
			if(password.value.length == 0){ 
			    alert("密码不能为空！");
			    return false; 
		    }
			
			if(!passwordRegex.test(password.value)){ 
			    alert("密码不合法！请输入6-20位数字或字母！");
			    return false; 
		    }
			return true;
		}
        </script>
	</body>
</html>
