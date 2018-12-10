<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>共享题库智能组卷系统<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amazeui.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/core.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/amazeui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/blockUI.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vote.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fenye.js" ></script>
<sitemesh:head/><!--会把被过滤页面head里面的东西（除了title）放在这个地方-->
</head>
<body>
    <div class="head">
        <%@ include file="/WEB-INF/layouts/head.jsp"%>
    	<div class="menu">
        	<%@ include file="/WEB-INF/layouts/stu_menu.jsp"%>
        </div>
        <div id="main" class="am-scrollable-vertical">
            <sitemesh:body/><!--被过滤的页面body里面的内容放在这里。-->
    	</div>
    </div>
</body>
</html>