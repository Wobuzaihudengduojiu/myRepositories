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
					<form action="check" method="post" id="findPwdform" onSubmit="return checkForm()">
						<label>手机号</label>
						<input type="text" name="phone" name="phone" placeholder="手机号" required/>
						<label>验证码</label>
						<input type="text" name="check" name="check" placeholder="验证码" required/>
						<a href="login" class="login">登录</a>
						<input type="submit" value="提交" />
					</form>
				</div>
			</div>
		</div>			
		<script type="text/javascript">
		function checkForm() {
			var phone = document.getElementById("phone"); 
			var check = document.getElementById("check"); 
			var phoneRegex = /^1[3|4|5|8][0-9]\d{8}$/;
			if(phone.value.length == 0){ 
			    alert("手机号不能为空！");
			    return false; 
		    }
			if(!phoneRegex.test(phone.value)){ 
			    alert("请输入正确的手机号格式！");
			    return false; 
		    }
			if(check.value.length == 0){ 
			    alert("验证码不能为空！");
			    return false; 
		    }
			return true;
		}
        </script>
	</body>
</html>
