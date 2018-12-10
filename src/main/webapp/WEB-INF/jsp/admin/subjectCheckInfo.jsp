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
	<div class="admin">

		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-u-md-8">
					<div class="card-box">
						<h4 class="header-title m-t-0 m-b-30">科目审核情况</h4>
						<div class="am-scrollable-horizontal am-text-ms" style="font-family: '微软雅黑';">
		                        <table class="am-table   am-text-nowrap">
		                            <thead>
		                            <tr>
		                                <th>#</th>
		                                <th>科目名称</th>
		                                <th>审核情况</th>
		                                <th>审核人</th>
		                            </tr>
		                            </thead>
		                            <tbody>
		                            	<c:forEach items="${subjectCheckList }" var="subject" varStatus="status">
		                                <tr>
		                                    <td>${status.count }</td>
		                                    <td>${subject.subjectName }</td>
		                                    <c:choose>
											    <c:when test="${subject.ischeck == '0'}">
											    	<td><span class="label label-danger">不通过</span></td>
											    </c:when>
											    <c:otherwise>
											    	<td><span class="label label-success">通过</span></td>
											    </c:otherwise>
											</c:choose>
		                                    <td>${subject.username }</td>
		                                </tr>
		                                </c:forEach>
		                            </tbody>
		                        </table>
		                    </div>
					</div>
				</div>
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
		              <button type="button" class="am-btn am-btn-primary" onclick="window.location.href='doCheckSubject?ischeck=1'">通过</button>
		              <button type="button" class="am-btn am-btn-default" onclick="window.location.href='doCheckSubject?ischeck=0'">不通过</button>
		            </div>
			     </div>
			     <br>
			     <div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
			          <div class="am-btn-toolbar">
			            <div class="am-btn-group am-btn-group-xs">
			              <button type="button" class="am-btn am-btn-default" onclick="window.location.href='getNoSubject'">返回</button>
			            </div>
			          </div>
			        </div>	
		        </div>
			</div>
		</div>
	</div>
</body>
</html>