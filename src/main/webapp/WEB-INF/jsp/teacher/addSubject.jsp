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
							
							<h4 class="header-title m-t-0 m-b-30">创建科目</h4>
							
							<div class="am-g">
								<div class="am-u-md-6">
									<form action="addSubject" method="post" class="am-form am-text-sm" id="am-form-subject" onSubmit="return checkForm()">
										
										
									   <div class="am-form-group">
									    	<div class="am-g">
									    		<label class="am-u-md-2 am-md-text-right" for="lv">专业</label>
											      <select id="lv" name="profession">
											        <c:forEach items="${professionList }" var="profession">
														<option value="${profession.id }">${profession.professionName }</option>
													</c:forEach>
											      </select>
											      <span class="am-form-caret"></span>
									    	</div>					      
									    </div>
										<div class="am-form-group">
											<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="subject">科目名称</label>
										      <input class="am-u-md-10 form-control" name="subject" id="subject" placeholder="输入科目名称">
									      </div>
									   </div>
									    <div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt1">知识点1</label>
										      <input class="am-u-md-10 form-control" name="txt" id="txt1" />
										    </div>
									    </div>
									    <div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt2">知识点2</label>
										      <input class="am-u-md-10 form-control" name="txt" id="txt2" />
										    </div>
									    </div>
									    <div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt3">知识点3</label>
										      <input class="am-u-md-10 form-control" name="txt" id="txt3" />
										    </div>
									    </div>
									    <div class="am-form-group">
									    	<div class="am-g">
										      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt4">知识点4</label>
										      <input class="am-u-md-10 form-control" name="txt" id="txt4" />
										    </div>
									    </div>
									    <p>  
									    	<input type="button" value="添加选项" class="am-btn am-btn-default" onClick="addText(this.form,this.parentNode)" />  
									    	<input type="button" value="删除选项" class="am-btn am-btn-default" onClick="removeText(this.form)" />
									 	</p>
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
			var subject = document.getElementById("subject"); 
			var txt = document.getElementsByName("txt");
			if(subject.value.length == 0){ 
			    alert("科目名称不能为空！");
			    return false; 
		    }
			for(var i = 0;i<txt.length;i++) { 
				if (txt[i].value=="") { 
					alert("选项不能为空！"); 
					return false; 
				} 
			} 
			return true;
		}
		</script>
</body>
</html>