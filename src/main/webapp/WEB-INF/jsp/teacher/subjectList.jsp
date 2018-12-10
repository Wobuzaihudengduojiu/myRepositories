<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>共享题库智能组卷系统</title>
<script type="text/javascript">
function select() {
	var name = document.getElementById("select").value;
	if (name == null) {
		window.location.href='doSubjectList';
	} else {
		window.location.href='selectSubject?name=' + name;
	}
}
</script>
</head>
<body>
	<div class="admin">

			<!-- Start content -->
			<div class="content">
				<div class="card-box">
					<h4 class="header-title m-t-0 m-b-30">科目列表</h4>
					<!-- Row start -->
					<div class="am-g">
						<div class="am-u-sm-12 am-u-md-6">
				          <div class="am-btn-toolbar">
				            <div class="am-btn-group am-btn-group-xs">
				              <button type="button" class="am-btn am-btn-default" onclick="window.location.href='doAddSubject'"><span class="am-icon-plus"></span> 新增</button>
				            </div>
				          </div>
				        </div>	
				        
						<div class="am-u-sm-12 am-u-md-3">
				          <div class="am-input-group am-input-group-sm">
				            <input type="text" class="am-form-field" id="select">
				          <span class="am-input-group-btn">
				            <button class="am-btn am-btn-default" type="button" onclick="select()">搜索</button>
				          </span>
				          </div>
				        </div>
				      </div>
					  <!-- Row end -->
					  
					  <!-- Row start -->
					  	<div class="am-g">
				       <div class="am-u-sm-12">
				           <table class="am-table am-table-striped am-table-hover table-main">
				             <thead>
				             <tr>
				               <th class="table-check"><input type="checkbox" /></th><th class="table-id">#</th><th class="table-subject">科目名称</th><th class="table-porfession">专业</th><th class="table-username">创建者</th><th class="table-set">操作</th>
				             </tr>
				             </thead>
				             <tbody id="news-lis">
				             <c:forEach items="${subjectList }" var="subject" varStatus="status">
				             <tr class="news-item">
				               <td><input type="checkbox" /></td>
				               <td>${status.count }</td>
				               <td><a href="getSubjectById?id=${subject.id }">${subject.subjectName }</a></td>
				               <td>${subject.professionName }</td>
				               <td class="am-hide-sm-only">${subject.username }</td>
				               <td>
				                 <div class="am-btn-toolbar">
				                   <div class="am-btn-group am-btn-group-xs">
				                     <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
				                     <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>
				                     <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
				                   </div>
				                 </div>
				               </td>
				             </tr>
				             </c:forEach>
				             </tbody>
				           </table>
				           <!--分页控件，将此代码添加到网页上即可-->
							<div  class="c-pages">
							    <div class="cp-item">
							        <span>共</span>
							        <span id="cp-count">0</span>
							        <span>条</span>
							    </div>
							    <div class="cp-item">
							        <span id="curr-page">1</span>
							        <span>/</span>
							        <span id="total-page">1</span>
							    </div>
							    <div class="cp-item">
							        <button id="home">首页</button>
							        <button id="prev">上页</button>
							        <button id="next">下页</button>
							        <button id="last">尾页</button>
							    </div>
							    <div class="cp-item">
							        <button id="goTo">转到</button>
							        <input type="number" id="goToPage" />
							        <span>页</span>
							    </div>
				             </div>
				           <hr />
				       </div>
				
				     </div>
								  <!-- Row end -->
								  
					</div>
				
			</div>
		</div>
</body>
</html>