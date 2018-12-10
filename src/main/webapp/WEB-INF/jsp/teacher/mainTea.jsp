<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>老师中心</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet" />
<link title="" href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"  />
<link title="blue" href="${pageContext.request.contextPath}/resources/css/dermadefault.css" rel="stylesheet" type="text/css"/>
<script language="javascript">
function getCurDate()
{
 var d = new Date();
 var week;
 switch (d.getDay()){
 case 1: week="星期一"; break;
 case 2: week="星期二"; break;
 case 3: week="星期三"; break;
 case 4: week="星期四"; break;
 case 5: week="星期五"; break;
 case 6: week="星期六"; break;
 default: week="星期天";
 }
 var years = d.getFullYear();
 var month = add_zero(d.getMonth()+1);
 var days = add_zero(d.getDate());
 var hours = add_zero(d.getHours());
 var minutes = add_zero(d.getMinutes());
 var seconds=add_zero(d.getSeconds());
// var ndate = years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
var nweek=week;
var nyear=years+"年"+month+"月"+days+"日 ";
var nhour=hours+":"+minutes;
 divT.innerHTML= nweek;
 divH.innerHTML=nhour;
 divY.innerHTML=nyear;
}

function add_zero(temp)
{
 if(temp<10) return "0"+temp;
 else return temp;
}

setInterval("getCurDate()",100);

</script>
</head>

<body>

  <div class="right-product my-index right-full">
     <div class="container-fluid">
	   <div class="info-center">
       
       <!---title----->
            <div class="info-title">
              <div class="pull-left">
                <h4><strong>${user.username }</strong></h4>
                <p>欢迎登录系统！</p>
              </div>
              <div class="time-title pull-right">
                  <div class="year-month pull-left">
                    <p><div id="divT"></div></p>
                    <p><span><div id="divY"></div></span></p>
                  </div>
                  <div class="hour-minute pull-right">
                     <strong><div id="divH"></div></strong>
                  </div>
              </div>
              <div class="clearfix"></div>
            </div>
           <!----content-list----> 
            <div class="content-list">
               <div class="row">
                 <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file blue"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>添加试题</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default" onclick="window.location.href='doAddQuestion'">开始添加<span style="color:red;"></span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file violet"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>智能组卷</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default" onclick="window.location.href='goAddTeaPaper'">开始组卷<span style="color:red;"></span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file orange"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>查看试卷</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default" onclick="window.location.href='goTeaPaperList'">查看<span style="color:red;"></span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
                  <div class="col-md-3">
                    <div class="content">
                       <div class="w30 left-icon pull-left">
                          <span class="glyphicon glyphicon-file green"></span>
                       </div>
                       <div class="w70 right-title pull-right">
                       <div class="title-content">
                           <p>创建科目</p>
                           <h3 class="number">90</h3>
                           <button class="btn btn-default" onclick="window.location.href='doAddSubject'">开始创建<span style="color:red;"></span></button>
                       </div>
                       </div>
                       <div class="clearfix"></div>
                    </div>
                 </div>
               </div>
               <!-------信息列表------->
               <div class="row newslist" style="margin-top:20px;">
                 <div class="col-md-8">
                   <div class="panel panel-default">
                      <div class="panel-heading">
                       我的试卷<div class="caret"></div>
                       <a href="#" class="pull-right"><span class="glyphicon glyphicon-refresh"></span></a>
                      </div>
                      <c:forEach items="${paperList }" var="paper" varStatus="status" begin="0" end="4" step="1">
                      <div class="panel-body">
                           <div class="w15 pull-left">
                             <img src="${pageContext.request.contextPath}/resources/images/exam.png" width="25" height="25" alt="图片" class="img-circle">
                             第${status.count }套
                           </div>
                           <div class="w55 pull-left"><a href="getTeaPaperById?id=${paper.id }">${paper.tpName }</a></div>
                           <div class="w20 pull-left text-center">${paper.subjectName }</div>
                          <div class="w10 pull-left text-center"><span class="text-green-main"></span></div>
                      </div>
                      </c:forEach>
                      <div class="panel-body text-center">
                          <a href="goTeaPaperList" style="color:#5297d6;">查看全部</a>
                      </div>
                      
                    </div>
                 </div>
                 
                 <div class="col-md-4">
                     <div class="panel panel-default">
                      <div class="panel-heading">
                       我的事务统计
                       <a href="#" class="pull-right"><span class="glyphicon glyphicon-refresh"></span></a>
                      </div>     
                      <div class="panel-body">
                          
                      </div>
                    </div>
                    
                 </div>
               </div>
            </div>
            
       </div>			
	 </div>
  </div>
</div>
</body>
</html>