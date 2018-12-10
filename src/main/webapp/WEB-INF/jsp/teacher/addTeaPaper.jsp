<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>共享题库智能组卷系统</title>

<script type="text/javascript" >
//下拉框连动  
function getSubject(form) {
	var profession = form.profession.value;
	form.subject.options.length = 0;
	var subject = form.subject;
	$.ajax({    
	   	type: "post",    
	  	contentType:"application/json",    
		url : "${pageContext.request.contextPath}/getSubject?profession="+profession,   
		success: function (data) {
			//var data = JSON.parse(data);
			var data = eval('(' + data + ')');
			if(data.subject.length!="" && data.subject.length!=null){   
		    	for ( var i = 0; i < data.subject.length; i++) {  
		    		var html = subject.innerHTML;
		    		subject.innerHTML=html + "<option value="+data.subject[i].id+">"+data.subject[i].subjectName+"</option>";  
		      	}  
			}else{  
				subject.innerHTML="<option value="+subject+">---无---</option>";  
			}  
		}     
	});
}
function getKnowledge(form) {
	var subject = form.subject.value;
	var knowledge = form.knowledgeList;
	var queType = form.queType;
	$.ajax({    
	   	type: "post",    
	  	contentType:"application/json",    
		url : "${pageContext.request.contextPath}/getKnowledge?subject="+subject,   
		success: function (data) {
			document.getElementById('knowledgeList').innerHTML="";
			//var data = JSON.parse(data);
			var data = eval('(' + data + ')');
			if(data.knowledge.length!="" && data.knowledge.length!=null){   
		    	for ( var i = 0; i < data.knowledge.length; i++) {  
		    		var html = document.getElementById('knowledgeList').innerHTML;
		    		document.getElementById('knowledgeList').innerHTML=html + "<label class='am-checkbox-inline'><input type='checkbox' value="+data.knowledge[i].id
		    		+" name='knowledge' class='knowledge'> "+data.knowledge[i].knowledgeName+"</label>";
		    	}  
			}else{  
				knowledge.innerHTML="无";  
			}  
		}     
	});
	$.ajax({    
	   	type: "post",    
	  	contentType:"application/json",    
		url : "${pageContext.request.contextPath}/getQueType?subject="+subject,   
		success: function (data) {
			document.getElementById('que_typeList').innerHTML="";
			//var data = JSON.parse(data);
			var data = eval('(' + data + ')');
			if(data.que_type.length!="" && data.que_type.length!=null){   
		    	for ( var i = 0; i < data.que_type.length; i++) {  
		    		var html = document.getElementById('que_typeList').innerHTML;
		    		document.getElementById('que_typeList').innerHTML=html + "<label class='am-checkbox-inline'>"+
			        "<input type='checkbox' value="+data.que_type[i].id+" name='que_type' class='que_type'> "+data.que_type[i].qtName+"</label>"+
				      "<input class='form-control' name='qtnum' id='qtnum' placeholder='题目数量'/>"+
				      "<input class='form-control' name='qtscore' id='qtscore' placeholder='题目分值'/><br />"+
			      "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		      	}  
			}else{  
				que_type.innerHTML="无";  
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
								
								<h4 class="header-title m-t-0 m-b-30">智能组卷</h4>
								
								<div class="am-g">
									<div class="am-u-md-6">
										<form action="addTeaPaper" method="post" class="am-form am-text-sm" id="am-form-subject"  onSubmit="return checkForm()">
											
											<div class="am-form-group">
												<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="teaPaper">试卷名称</label>
											      <input class="am-u-md-10 form-control"  id="teaPaper" name="teaPaper" placeholder="输入试卷名称">
										      </div>
										   </div>
										   <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="lv">专业</label>
												      <select id="lv" name="profession" onChange="getSubject(this.form)">
												        <c:forEach items="${professionList }" var="profession">
															<option value="${profession.id }">${profession.professionName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
										    <div class="am-form-group">
										    	<div class="am-g">
										    		<label class="am-u-md-2 am-md-text-right" for="subject ">科目</label>
												      <select id="subject" name="subject" onChange="getKnowledge(this.form)">
												        <c:forEach items="${subjectList }" var="subject">
															<option value="${subject.id }">${subject.subjectName }</option>
														</c:forEach>
												      </select>
												      <span class="am-form-caret"></span>
										    	</div>					      
										    </div>
											<div class="am-form-group">
											      <label class="am-u-md-2 am-md-text-right">知识点</label>
											      <label class="am-checkbox-inline">
											        <input type="checkbox" value="全选" name="all" onclick="knowledgeAll()"/> 全选
											      </label>
											      <div class="knowledgeList" id="knowledgeList">
											      <c:forEach items="${knowledgeList }" var="knowledge">
												      <label class="am-checkbox-inline">
												        <input type="checkbox" value="${knowledge.id }" name="knowledge" class="knowledge"> ${knowledge.knowledgeName }
												      </label>
												  </c:forEach>
												  </div>
										    </div>
										    
										    <div class="am-form-group">
										      <label class="am-u-md-2 am-md-text-right">题型</label>
										      <label class="am-checkbox-inline">
										        <input type="checkbox" value="全选" name="all" onclick="queTypeAll()"/> 全选
										      </label><br />
										      <div class="que_typeList" id="que_typeList">
										      <c:forEach items="${que_typeList }" var="que_type">
											      <label class="am-checkbox-inline">
											        <input type="checkbox" value="${que_type.id }" name="que_type" class="que_type"> ${que_type.qtName }
											      </label>
											      <input class="form-control" name="qtnum" id="qtnum" placeholder="题目数量" />
											      <input class="form-control" name="qtscore" id="qtscore" placeholder="题目分值"/>
										      <br />
										      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											  </c:forEach>
											  </div>
										    </div>
										    <div class="am-form-group">
										      <label class="am-u-md-2 am-md-text-right">难度系数 </label>
										      <label class="am-radio-inline">
										        <input type="radio"  value="1" name="lv" required> 简单（1-3）
										      </label>
										      <label class="am-radio-inline">
										        <input type="radio" value="2" name="lv"> 一般（4-6）
										      </label>
										      <label class="am-radio-inline">
										        <input type="radio" value="3" name="lv"> 难（7-10）
										      </label>
										    </div>
										    <!-- <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="score">分值</label>
											      <input class="am-u-md-10 form-control" name="score" id="score" />
											    </div>
										    </div> 
										    <div class="am-form-group">
										    	<div class="am-g">
											      <label class="am-u-md-2 am-md-text-right am-padding-left-0" for="openTime">开放时间</label>
											      <input class="am-u-md-10 form-control" name="openTime" id="openTime" placeholder="20XX-XX-XX" />
											    </div>
										    </div>-->
										    <input type="submit" value="智能组卷" class="am-btn am-btn-secondary"/>			    
										    	    
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
			var teaPaper = document.getElementById("teaPaper"); 
			var knowledge = document.getElementsByName("knowledge"); 
			var knowledgevalue = new Array();
			for(var i = 0; i < knowledge.length; i++){
			     if(knowledge[i].checked)
			     	knowledgevalue.push(knowledge[i].value);
			}
			var que_type = document.getElementsByName("que_type");
			var que_typevalue = new Array();
			for(var i = 0; i < que_type.length; i++){
			     if(que_type[i].checked)
			     	que_typevalue.push(que_type[i].value);
			}
			if(teaPaper.value.length == 0){ 
			    alert("试卷名称不能为空！");
			    return false; 
		    }
			if(knowledgevalue.length == 0){ 
			    alert("请选择知识点！");
			    return false; 
		    }
			if(que_typevalue.length == 0){ 
			    alert("请选择题型！");
			    return false; 
		    }
			return true;
		}
		</script>
</body>
</html>