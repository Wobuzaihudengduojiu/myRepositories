<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>共享题库智能组卷系统</title>

<link href="${pageContext.request.contextPath}/resources/css/base.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/help.css">

<!--js区域-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".fwmc_xxk li").click(function(){
		$(this).addClass("on").siblings().removeClass("on");
		tola();
		});
	//加
	$(".jia").click(function(){
		var fw_numb = $(".srkk").val();	
		fw_numb++;
		$(".srkk").val(fw_numb);		
		tola();
		})
		
	//减
	$(".jian").click(function(){
		var fw_numb = $(".srkk").val();	
		if(fw_numb <= 1){
			alert("数量不足了，请住手！")
			}else{
		fw_numb--;
		$(".srkk").val(fw_numb);		
			}
		tola();
		})	
	 
	
});

function tola(){
		var $li = $(".fwmc_xxk").children("li.on");
		var money = $li.children("i").text();
		var count = $(".srkk").val();
		$(".zwfb_zje span").text(money*count);
}

function addrecharge(){
	var $li = $(".fwmc_xxk").children("li.on");
	var gold = $li.children("p").text();
	var count = $(".srkk").val();
	window.location.href="doRecharge?gold="+gold+"&&count="+count;
}

</script>

</head>

<body>
 

<div class="w_1200 fw_box ">
  <div  class="fw_conent"> 
    <!--内容开始------------------------------>
    <div class="bzzx_bt"> <strong>金币充值</strong>用户可通过人民币来进行虚拟金币的充值、兑换</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="zwfb_shop_table">
      <tr valign="top">
        <td align="right" width="70">充值金额：</td>
        <td><ul class="fwmc_xxk">
            <li class="on">
              <p>1200金币</p>
              <i>100</i>元</li>
            <li >
              <p>550金币</p>
              <i>50</i>元</li>
            <li >
              <p>310金币</p>
              <i>30</i>元</li>
            <li >
              <p>100金币</p>
              <i>10</i>元</li>
            <li >
              <p>10金币</p>
              <i>1</i>元</li>
          </ul></td>
      </tr>
      <tr>
        <td height="20"></td>
        <td></td>
      </tr>
      <tr>
        <td align="right">购买数量：</td>
        <td><ul class="nmb_jj">
            <li class="jian">-</li>
            <li>
              <input name="" type="text" value="1" class="srkk" />
            </li>
            <li class="jia">+</li>  
          </ul></td>
      </tr>
      <tr>
        <td height="20"></td>
        <td></td>
      </tr>
      <tr>
        <td align="right">价格：</td>
        <td><div class="zwfb_zje"><span>100</span> <i>元</i></div></td>
      </tr>
      <tr>
        <td height="20"></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td><button class="am-btn am-btn-primary" onclick="addrecharge()">购 买</button></td>
      </tr>
    </table>
    <div class="gmxz_tip"> 购买须知：
      <p>1.购买后一个工作日内金币到账户。</p>
      <p> 2.本次购买后，不支持退费服务。</p>
    </div>
    
    <!--内容结束------------------------------> 
  </div>
</div>
</body>
</html>
