<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>共享题库智能组卷系统</title>

<script type="text/javascript" >
//下拉框连动  
function getSubject(form) {  
	//获取下拉框主键  
	//var subject=$("#subject").find('option:selected').val();  
	//$("#knowledge").empty();     //清空二级目录   
	//var knowledge=$("#knowledge");  
	var subject = form.subject.value;
	form.knowledge.options.length = 0;
	var knowledge = form.knowledge;
	form.que_type.options.length = 0;
	var que_type = form.que_type;
	$.ajax({    
	   	type: "post",    
	  	contentType:"application/json",    
		url : "${pageContext.request.contextPath}/getKnowledge?subject="+subject,   
		success: function (data) {
			//var data = JSON.parse(data);
			var data = eval('(' + data + ')');
			if(data.knowledge.length!="" && data.knowledge.length!=null){   
		    	for ( var i = 0; i < data.knowledge.length; i++) {  
		    		var html = knowledge.innerHTML;
		    		knowledge.innerHTML=html + "<option value="+data.knowledge[i].id+">"+data.knowledge[i].knowledgeName+"</option>";  
		      	}  
			}else{  
				knowledge.innerHTML="<option value="+subject+">---无---</option>";  
			}  
		}     
	});
	$.ajax({    
	   	type: "post",    
	  	contentType:"application/json",    
		url : "${pageContext.request.contextPath}/getQueType?subject="+subject,   
		success: function (data) {
			//var data = JSON.parse(data);
			var data = eval('(' + data + ')');
			if(data.que_type.length!="" && data.que_type.length!=null){   
		    	for ( var i = 0; i < data.que_type.length; i++) {  
		    		var html = que_type.innerHTML;
		    		que_type.innerHTML=html + "<option value="+data.que_type[i].id+">"+data.que_type[i].qtName+"</option>";  
		      	}  
			}else{  
				que_type.innerHTML="<option value="+subject+">---无---</option>";  
			}  
		}     
	});
}
</script>
</head>
	<body>

		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-12">
							<div class="card-box">
								
								<h4 class="header-title m-t-0 m-b-30">添加试题</h4>
								
								<div class="am-g">
									<div class="am-u-md-6">
										<button type="button" class="am-btn am-btn-default" onclick="xuanze()">选择题</button>
										<button type="button" class="am-btn am-btn-default" onclick="tiankong()">填空题</button>
										<button type="button" class="am-btn am-btn-default" onclick="qita()">其他</button><br><br />
										<form action="addxuanze" method="post" class="am-form am-text-sm" id="am-form-xuanze" style="display: ;" onSubmit="return checkForm()">
											
											<div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="subject">科目</label>
												      <select id="subject"  name="subject" onChange="getSubject(this.form)">
												        <c:forEach items="${subjectList }" var="subject">
															<option value="${subject.id }">${subject.subjectName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="que_type">题型</label>
												      <select id="que_type" name="que_type">
												        <c:forEach items="${que_typeList }" var="que_type">
															<option value="${que_type.id }">${que_type.qtName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="knowledge">知识点</label>
												      <select id="knowledge" name="knowledge">
												        <c:forEach items="${knowledgeList }" var="knowledge">
															<option value="${knowledge.id }">${knowledge.knowledgeName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="lv">难度系数</label>
												      <select id="lv" name="lv">
												        <c:forEach var="i" begin="1" end="10" step="1">
												<option value="${i }">${i }</option>
											</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
											<div class="am-form-group">
												<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="title">题目</label>
											      <input class="am-u-md-10 form-control" id="title" name="title" placeholder="输入标题信息">
										      </div>
										    </div>
										    <div class="am-form-group">
												<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="answer">答案</label>
											      <input class="am-u-md-10 form-control" id="answer" name="answer" placeholder="输入答案">
										      </div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt1">选项1</label>
											      <input class="am-u-md-10 form-control" name="txt" id="txt1" />
											    </div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt2">选项2</label>
											      <input class="am-u-md-10 form-control" name="txt" id="txt2" />
											    </div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt3">选项3</label>
											      <input class="am-u-md-10 form-control" name="txt" id="txt3" />
											    </div>
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txt4">选项4</label>
											      <input class="am-u-md-10 form-control" name="txt" id="txt4" />
											    </div>
										    </div>
										    <p>  
										    	<input type="button" value="添加选项" class="am-btn am-btn-default" onClick="addTextBox(this.form,this.parentNode)" />  
										    	<input type="button" value="删除选项" class="am-btn am-btn-default" onClick="removeTextBox(this.form)" />
										 	</p>
											<input type="submit" value="提交" class="am-btn am-btn-primary"/>
										</form>
										<form action="addtiankong" method="post" class="am-form am-text-sm" id="am-form-tiankong" style="display: none;" onSubmit="return checkForm()">
											
											<div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="subject">科目</label>
												      <select id="subject"  name="subject" onChange="getSubject(this.form)">
												        <c:forEach items="${subjectList }" var="subject">
															<option value="${subject.id }">${subject.subjectName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="que_type">题型</label>
												      <select id="que_type" name="que_type">
												        <c:forEach items="${que_typeList }" var="que_type">
															<option value="${que_type.id }">${que_type.qtName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="knowledge">知识点</label>
												      <select id="knowledge" name="knowledge">
												        <c:forEach items="${knowledgeList }" var="knowledge">
															<option value="${knowledge.id }">${knowledge.knowledgeName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="lv">难度系数</label>
												      <select id="lv" name="lv">
												        <c:forEach var="i" begin="1" end="10" step="1">
												<option value="${i }">${i }</option>
											</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
											<div class="am-form-group">
												<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="title">题目</label>
											      <input class="am-u-md-10 form-control" id="title" name="title" placeholder="输入标题信息">
										      </div>
										   </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txtt1">填空1</label>
											      <input class="am-u-md-10 form-control" name="txt" id="txtt1" />
											    </div>
										    </div>			    
										    <p>  
										    	<input type="button" value="添加选项" class="am-btn am-btn-default" onClick="addTextBoxtiankong(this.form,this.parentNode)" />  
										    	<input type="button" value="删除选项" class="am-btn am-btn-default" onClick="removeTextBoxtiankong(this.form)" />
										 	</p>
											<input type="submit" value="提交" class="am-btn am-btn-primary"/>					    
										</form>
										<form action="addqita" method="post" class="am-form am-text-sm" id="am-form-qita" style="display: none;" onSubmit="return checkForm()">
											
											<div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="subject">科目</label>
												      <select id="subject"  name="subject" onChange="getSubject(this.form)">
												        <c:forEach items="${subjectList }" var="subject">
															<option value="${subject.id }">${subject.subjectName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="que_type">题型</label>
												      <select id="que_type" name="que_type">
												        <c:forEach items="${que_typeList }" var="que_type">
															<option value="${que_type.id }">${que_type.qtName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="knowledge">知识点</label>
												      <select id="knowledge" name="knowledge">
												        <c:forEach items="${knowledgeList }" var="knowledge">
															<option value="${knowledge.id }">${knowledge.knowledgeName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="lv">难度系数</label>
												      <select id="lv" name="lv">
												        <c:forEach var="i" begin="1" end="10" step="1">
												<option value="${i }">${i }</option>
											</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
											<div class="am-form-group">
												<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="title">题目</label>
											      <textarea class="am-u-md-10 form-control" rows="5" id="title" name="title" placeholder="输入标题信息"></textarea>
										      </div>
										   </div>
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="txtq1">答案1</label>
											      <input class="am-u-md-10 form-control" name="txt" id="txtq1" />
											    </div>
										    </div>				    
										    <p>  
										    	<input type="button" value="添加选项" class="am-btn am-btn-default" onClick="addTextBoxqita(this.form,this.parentNode)" />  
										    	<input type="button" value="删除选项" class="am-btn am-btn-default" onClick="removeTextBoxqita(this.form)" />
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
			var title = document.getElementById("title"); 
			var answer = document.getElementById("answer"); 
			var txt = document.getElementsByName("txt");
			if(title.value.length == 0){ 
			    alert("题目不能为空！");
			    return false; 
		    }
			if(answer.value.length == 0){ 
			    alert("答案不能为空！");
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