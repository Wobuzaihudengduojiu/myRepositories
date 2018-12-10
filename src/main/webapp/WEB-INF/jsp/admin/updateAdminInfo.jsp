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
							
							<h4 class="header-title m-t-0 m-b-30">修改个人信息</h4>
							
							<div class="am-g">
								<div class="am-u-md-6">
									<form action="updateAdminInfo" method="post" class="am-form am-text-sm" id="am-form-update" onSubmit="return checkForm()">
										
										<div class="am-form-group">
											<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="username">用户名</label>
										      <input class="am-u-md-10 form-control" name="username" id="username" value="${user.username }">
									      	</div>
									   	</div>
										<div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="phone">手机号</label>
										      <input class="am-u-md-10 form-control" name="phone" id="phone" value="${user.phone }"/>
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
		var username = document.getElementById("username"); 
		var phone = document.getElementById("phone"); 
		if(username.value.length == 0){ 
		    alert("用户名不能为空！");
		    return false; 
	    }
		if(phone.value.length == 0){ 
		    alert("手机号不能为空！");
		    return false; 
	    }
		return true;
	}
	</script>
</body>
</html>