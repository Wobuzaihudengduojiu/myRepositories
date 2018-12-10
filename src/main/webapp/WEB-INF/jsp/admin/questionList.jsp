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
		window.location.href='doQuestionList';
	} else {
		window.location.href='selectQuestion?name=' + name;
	}
}
</script>
</head>
<body>
	<div class="admin">

			<!-- Start content -->
			<div class="content">
				<div class="card-box">
					<h4 class="header-title m-t-0 m-b-30">试题库</h4>
					<!-- Row start -->
					<div class="am-g">
				        
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
				               <th class="table-id">#</th><th class="table-title">标题</th><th class="table-subject">科目</th><th class="table-knowledge">知识点</th><th class="table-quetype am-hide-sm-only">题型</th><th class="table-lv">难度系数</th><th class="table-username">出题用户</th><th class="table-set">操作</th>
				             </tr>
				             </thead>
				             <tbody id="news-lis">
				             <c:forEach items="${questionList }" var="question" varStatus="status">
				             <tr class="news-item">
				               <td>${status.count }</td>
				               <td><a href="getQuestion?queId=${question.queId }">${question.value }</a></td>
				               <td>${question.subjectName }</td>
				               <td class="am-hide-sm-only">${question.knowledgeName }</td>
				               <td class="am-hide-sm-only">${question.qtName }</td>
				               <td class="am-hide-sm-only">${question.lv }</td>
				               <td class="am-hide-sm-only">${question.username }</td>
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
				         </form>
				       </div>
				
				     </div>
								  <!-- Row end -->
								  
					</div>
			</div>
		</div>
</body>
</html>