<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
		<meta charset="utf-8">
		<!-- stylesheets -->
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
				<h2>注册</h2>
				<div class="login-form">
					<h3><font color="red" id="errormsg">${msg }</font></h3>
					<form action="register" method="post" id="registerform" onSubmit="return checkForm()">
						<label>学校</label>
						<select id="school" name="school" >
	                       <c:forEach items="${schoolList }" var="school">
								<option value="${school.id }">${school.schoolName }</option>
							</c:forEach>
	                    </select>
	                    <label>专业</label>
						<select id="profession" name="profession" >
	                       <c:forEach items="${professionList }" var="profession">
								<option value="${profession.id }">${profession.professionName }</option>
							</c:forEach>
	                    </select>
	                    <label>身份</label>
						<select id="identity" name="identity">
							<option value="0">学生</option>
							<option value="1">教师</option>
	                    </select>
						<label>手机号</label>
						<input type="text" name="phone" id="phone" placeholder="手机号" required/>
						<label>用户名</label>
						<input type="text" name="username" id="username" placeholder="用户名" required/>
						<label>密码</label>
						<input type="password" name="password" id="password" placeholder="密码" required />
						<a href="login" class="login">登录</a>
						<input type="submit" value="注册" />
					</form>
				</div>
			</div>
		</div>
		<script>
		function checkForm() {
			var phone = document.getElementById("phone"); 
			var username = document.getElementById("username"); 
			var password = document.getElementById("password"); 
			var phoneRegex = /^1[3|4|5|8][0-9]\d{8}$/;
			var usernameRegex = /^[\u4E00-\u9FA5A-Za-z0-9]{1,11}$/;
	        var passwordRegex = /^[a-zA-Z0-9]{6,20}$/;
			if(phone.value.length == 0){ 
			    alert("手机号不能为空！");
			    return false; 
		    }
			if(!phoneRegex.test(phone.value)){ 
			    alert("请输入正确的手机号格式！");
			    return false; 
		    }
			if(username.value.length == 0){ 
			    alert("用户名不能为空！");
			    return false; 
		    }
			if(!usernameRegex.test(username.value)){ 
			    alert("用户名不合法！请输入1-11位中文、英文、数字但不包括下划线等符号");
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
