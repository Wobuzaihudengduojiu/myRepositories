<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>menu</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
		<script type="text/javascript">
		function tm_toggle_menu(obj){
			$(obj).parent().siblings().toggle();
		}
		function tm_mark_current_menuitem(){
			
		}

		$(document).ready(function() { 
			$(".tm_menu_item ul li a").click(function(){
				$(".tm_menu_item ul li").removeClass("itemon");
				$(this).parent().addClass("itemon");
			});
			
		});

		document.oncontextmenu= function(){return false;}
		</script>
    </head>
    <body>
    	<div class="tm_menu">
    	
		
		<div class="tm_menu_item clearfix">
			<h2><a href="javascript:void(0);" onclick="tm_toggle_menu(this)" class="tmc_menu_qdb">题库管理</a></h2>
			<ul>
				<li><a href="doQuestionList">试题库</a></li>
			</ul>
		</div>
				
		<div class="tm_menu_item clearfix">
			<h2><a href="javascript:void(0);" onclick="tm_toggle_menu(this)" class="tmc_menu_paper">试卷管理</a></h2>
			<ul>
				<li><a href="goTeaPaperList">查看试卷</a></li>
			</ul>
		</div>

		<div class="tm_menu_item clearfix">
			<h2><a href="javascript:void(0);" onclick="tm_toggle_menu(this)" class="tmc_menu_paper">科目管理</a></h2>
			<ul>
				<li><a href="doSubjectList">科目列表</a></li>
				<li><a href="getNoSubject">未审核科目列表</a></li>
			</ul>
		</div>

		<div class="tm_menu_item clearfix">
			<h2><a href="javascript:void(0);" onclick="tm_toggle_menu(this)" class="tmc_menu_analysis">个人中心</a></h2>
			<ul>
				<li><a href="getAdminInfo">个人信息</a></li>
				<li><a href="doUpdateAdminInfo">修改信息</a></li>
				<li><a href="doUpdatePwd">修改密码</a></li>
			</ul>
		</div>

		<div class="tm_menu_item clearfix">
			<h2><a href="javascript:void(0);" onclick="tm_toggle_menu(this)" class="tmc_menu_learn">充值管理</a></h2>
			<ul>
				<li><a href="getNoRecharge">充值审核</a></li>
			</ul>
		</div>
			
		<div class="tm_menu_item clearfix">
			<h2><a href="javascript:void(0);" onclick="tm_toggle_menu(this)" class="tmc_menu_user">推广管理</a></h2>
			<ul>
				<li><a href="">推广审核</a></li>
			</ul>
		</div>
			
		      
    </div>
 	</body>
</html>