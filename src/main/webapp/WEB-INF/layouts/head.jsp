<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>head</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
    </head>
    <body>
    	<div class="tm_head">
    
        <div class="tm_head_logo"><a href="resources/images/logo.jpg" target="_blank"><img src="" /></a></div>
        <div class="tm_head_switch"><a href="" onclick=""><!-- <img src="resources/images/logo.jpg" /> --></a></div>
			<div class="tm_head_tools">
				<span style="cursor:pointer" title=''>
					${user.username }
				</span> |
				<a href="goMain"><img src="" align="absmiddle"/>账户</a> |
				
				<a href="goMain"><img src="" align="absmiddle"/>在线用户</a> |
				<a href="logout"><img src="" align="absmiddle"/>退出</a>
			</div> 
    </div>
 	</body>
</html>