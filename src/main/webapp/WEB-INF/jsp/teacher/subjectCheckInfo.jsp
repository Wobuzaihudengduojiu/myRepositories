<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
								
							<h4 class="header-title m-t-0 m-b-30">科目信息</h4>
							
							<div class="am-g">
								<div class="am-u-md-6">
									<div class="am-form-group">
								    	<div class="am-g">
								    		<table class="am-table  am-table-hover">
								              <tbody>
									              <tr>
									                <td>科目名称</td>
									                <td>${subjectInfo.subjectName }</td>
									              </tr>
									              <tr>
									                <td>专业</td>
									                <td>${subjectInfo.professionName }</td>
									              </tr>
									              <tr>
									                <td>知识点</td>
									              </tr>
									              <c:forEach items="${knowledgeList }" var="knowledge">
										              <tr>
										              	<td></td>
										                <td>${knowledge.knowledgeName }</td>
										              </tr>
									              </c:forEach>
								              </tbody>
								            </table>
								    	</div>					      
								    </div>    						    
								</div>
							</div>
							
							<div class="am-g">
								<div class="am-u-sm-12 am-u-md-6">
					              <button type="button" class="am-btn am-btn-default" onclick="window.location.href='addSub_check?ischeck=1'">通过</button>
					              <button type="button" class="am-btn am-btn-default" onclick="window.location.href='addSub_check?ischeck=0'">不通过</button>
					            </div>
						     </div>
						        </div>	
					        </div>
					        
						</div>
					</div>
					<!-- Row end -->
				</div>
			</div>
		</div>
	</body>

</html>