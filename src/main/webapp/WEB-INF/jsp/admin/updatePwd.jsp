<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>共享题库智能组卷系统</title>
</head>
<body>
	<div class="content-page">
		<!-- Start content -->
		<div class="content">
			<div class="am-g">
				<!-- Row start -->
					<div class="am-u-sm-12">
						<div class="card-box">
							
							<h4 class="header-title m-t-0 m-b-30">修改密码</h4>
							
							<div class="am-g">
								<div class="am-u-md-6">
									<form action="" method="post" class="am-form am-text-sm" id="am-form-updatePwd" onSubmit="return checkForm()">
										
										<div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="phone">手机号</label>
										      <input class="am-u-md-10 form-control" name="phone" id="phone" value="${user.phone }"/>
										    </div>
									    </div>
									    <div class="am-g">
											<div class="am-u-sm-12 am-u-md-6">
									          <div class="am-btn-toolbar">
									            <div class="am-btn-group am-btn-group-xs">
									              <button type="button" class="am-btn am-btn-default" onclick="">发送验证码</button>
									            </div>
									          </div>
									        </div>	
								        </div>
								        <br>
									    <div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="check">验证码</label>
										      <input class="am-u-md-10 form-control" name="check" id="check"/>
										    </div>
									    </div>
									   	<div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="password">新密码</label>
										      <input class="am-u-md-10 form-control" name="password" id="password"/>
										    </div>
									    </div>
									    <div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="password2">新密码</label>
										      <input class="am-u-md-10 form-control" name="password2" id="password2"/>
										    </div>
									    </div>
									    
									 	<input type="submit" value="提交" class="am-btn am-btn-primary"/>						    
									</form>
								</div>
																	
							</div>
						</div>
					</div>
				<!-- Row end -->
			</div>	
		</div>
	</div>
	<script type="text/javascript">
	function checkForm() {
		var phone = document.getElementById("phone"); 
		var check = document.getElementById("check"); 
		var password = document.getElementById("password"); 
		var password2 = document.getElementById("password2"); 
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
		if(check.value.length == 0){ 
		    alert("验证码不能为空！");
		    return false; 
	    }
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