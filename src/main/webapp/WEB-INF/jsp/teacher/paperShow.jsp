<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>共享题库智能组卷系统</title>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/test.css" rel="stylesheet" type="text/css" />

<style>
.hasBeenAnswer {
	background: #5d9cec;
	color:#fff;
}
</style>

</head>
<body>
	<div class="content">
	<div class="card-box">
	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">
					<form action="" method="post">
						<div class="test_title">
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
							<font><input type="button" name="test_jiaojuan" value="交卷"></font>
						</div>
							<div class="test_content">
								<div class="test_content_title">
									<h2>${teaPaper.tpName }</h2>
									<p>
										<span>共</span><i class="content_lit">${num }</i><span>题，</span><span>合计</span><i class="content_fs">${teaPaper.score }</i><span>分</span>
									</p>
								</div>
							</div>
							<br>
						<c:forEach items="${paperQuestionList }" var="paper" varStatus="status">
							<div class="test_content_nr">
								<ul>
									
										<li id="qu_0_${status.count }">
											<div class="test_content_nr_tt">
												<i>${status.count }</i><span>( ${paper.score }分 )</span><font>${paper.title }</font><b class="icon iconfont">&#xe881;</b>
											</div>
	
											<div class="test_content_nr_main">
												<ul>
													<c:forEach items="${paper.option }" var="option" varStatus="status1">
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer${status.count }"
																	id="${status.count }_answer_1_option_${status1.count }"
																/>
															
															
															<label for="${status.count }_answer_1_option_${status1.count }">
																${option.option }
																<p class="ue" style="display: inline;">${option.value }</p>
															</label>
														</li>
													</c:forEach>
												</ul>
											</div>
										</li>
								</ul>
							</div>
						</c:forEach>
							<div class="test_content">
								<div class="test_content_title">
									<h2>多选题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题，</span><span>合计</span><i class="content_fs">30</i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
									
										<li id="qu_1_0">
											<div class="test_content_nr_tt">
												<i>1</i><span>(1分)</span><font>以下属于南方电网员工职业操守中明文规定的有()</font><b class="icon iconfont">&#xe881;</b>
											</div>
	
											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_1"
																/>
															
															<label for="1_answer_1_option_1">
																A.
																<p class="ue" style="display: inline;">热爱祖国、热爱南网、热爱岗位</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_2"
																/>
															
															<label for="1_answer_1_option_2">
																B.
																<p class="ue" style="display: inline;">遵纪守法、忠于职守、令行禁止</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_3"
																/>
															
															<label for="1_answer_1_option_3">
																C.
																<p class="ue" style="display: inline;">客户至上、诚实守信、优质服务</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_4"
																/>
															
															<label for="1_answer_1_option_4">
																D.
																<p class="ue" style="display: inline;">公平竞争、互相监督、服从监管</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
								</ul>
							</div>
						
					</form>
				</div>
	
			</div>
			<!-- <div class="nr_right">
				<div class="nr_rt_main">
					<div class="rt_nr1">
						<div class="rt_nr1_title">
							<h1>
								<i class="icon iconfont">&#xe692;</i>答题卡
							</h1>
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
						</div>
						
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">60</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
											<li><a href="#qu_0_0">1</a></li>
										
											<li><a href="#qu_0_1">2</a></li>
										
											<li><a href="#qu_0_2">3</a></li>
										
											<li><a href="#qu_0_3">4</a></li>
										
											<li><a href="#qu_0_4">5</a></li>
										
											<li><a href="#qu_0_5">6</a></li>
										
											<li><a href="#qu_0_6">7</a></li>
										
											<li><a href="#qu_0_7">8</a></li>
										
											<li><a href="#qu_0_8">9</a></li>
										
											<li><a href="#qu_0_9">10</a></li>
										
											<li><a href="#qu_0_10">11</a></li>
										
											<li><a href="#qu_0_11">12</a></li>
										
											<li><a href="#qu_0_12">13</a></li>
										
											<li><a href="#qu_0_13">14</a></li>
										
											<li><a href="#qu_0_14">15</a></li>
										
											<li><a href="#qu_0_15">16</a></li>
										
											<li><a href="#qu_0_16">17</a></li>
										
											<li><a href="#qu_0_17">18</a></li>
										
											<li><a href="#qu_0_18">19</a></li>
										
											<li><a href="#qu_0_19">20</a></li>
										
											<li><a href="#qu_0_20">21</a></li>
										
											<li><a href="#qu_0_21">22</a></li>
										
											<li><a href="#qu_0_22">23</a></li>
										
											<li><a href="#qu_0_23">24</a></li>
										
											<li><a href="#qu_0_24">25</a></li>
										
											<li><a href="#qu_0_25">26</a></li>
										
											<li><a href="#qu_0_26">27</a></li>
										
											<li><a href="#qu_0_27">28</a></li>
										
											<li><a href="#qu_0_28">29</a></li>
										
											<li><a href="#qu_0_29">30</a></li>
										
											<li><a href="#qu_0_30">31</a></li>
										
											<li><a href="#qu_0_31">32</a></li>
										
											<li><a href="#qu_0_32">33</a></li>
										
											<li><a href="#qu_0_33">34</a></li>
										
											<li><a href="#qu_0_34">35</a></li>
										
											<li><a href="#qu_0_35">36</a></li>
										
											<li><a href="#qu_0_36">37</a></li>
										
											<li><a href="#qu_0_37">38</a></li>
										
											<li><a href="#qu_0_38">39</a></li>
										
											<li><a href="#qu_0_39">40</a></li>
										
											<li><a href="#qu_0_40">41</a></li>
										
											<li><a href="#qu_0_41">42</a></li>
										
											<li><a href="#qu_0_42">43</a></li>
										
											<li><a href="#qu_0_43">44</a></li>
										
											<li><a href="#qu_0_44">45</a></li>
										
											<li><a href="#qu_0_45">46</a></li>
										
											<li><a href="#qu_0_46">47</a></li>
										
											<li><a href="#qu_0_47">48</a></li>
										
											<li><a href="#qu_0_48">49</a></li>
										
											<li><a href="#qu_0_49">50</a></li>
										
											<li><a href="#qu_0_50">51</a></li>
										
											<li><a href="#qu_0_51">52</a></li>
										
											<li><a href="#qu_0_52">53</a></li>
										
											<li><a href="#qu_0_53">54</a></li>
										
											<li><a href="#qu_0_54">55</a></li>
										
											<li><a href="#qu_0_55">56</a></li>
										
											<li><a href="#qu_0_56">57</a></li>
										
											<li><a href="#qu_0_57">58</a></li>
										
											<li><a href="#qu_0_58">59</a></li>
										
											<li><a href="#qu_0_59">60</a></li>
										
									</ul>
								</div>
							</div>
						
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>多选题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
											<li><a href="#qu_1_0">1</a></li>
										
											<li><a href="#qu_1_1">2</a></li>
										
											<li><a href="#qu_1_2">3</a></li>
										
											<li><a href="#qu_1_3">4</a></li>
										
											<li><a href="#qu_1_4">5</a></li>
										
											<li><a href="#qu_1_5">6</a></li>
										
											<li><a href="#qu_1_6">7</a></li>
										
											<li><a href="#qu_1_7">8</a></li>
										
											<li><a href="#qu_1_8">9</a></li>
										
											<li><a href="#qu_1_9">10</a></li>
										
											<li><a href="#qu_1_10">11</a></li>
										
											<li><a href="#qu_1_11">12</a></li>
										
											<li><a href="#qu_1_12">13</a></li>
										
											<li><a href="#qu_1_13">14</a></li>
										
											<li><a href="#qu_1_14">15</a></li>
										
											<li><a href="#qu_1_15">16</a></li>
										
											<li><a href="#qu_1_16">17</a></li>
										
											<li><a href="#qu_1_17">18</a></li>
										
											<li><a href="#qu_1_18">19</a></li>
										
											<li><a href="#qu_1_19">20</a></li>
										
											<li><a href="#qu_1_20">21</a></li>
										
											<li><a href="#qu_1_21">22</a></li>
										
											<li><a href="#qu_1_22">23</a></li>
										
											<li><a href="#qu_1_23">24</a></li>
										
											<li><a href="#qu_1_24">25</a></li>
										
											<li><a href="#qu_1_25">26</a></li>
										
											<li><a href="#qu_1_26">27</a></li>
										
											<li><a href="#qu_1_27">28</a></li>
										
											<li><a href="#qu_1_28">29</a></li>
										
											<li><a href="#qu_1_29">30</a></li>
										
									</ul>
								</div>
							</div>
						
					</div>
	
				</div> -->
			</div>
		</div>
		<!--nr end-->
		<div class="foot"></div>
	</div>
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.easy-pie-chart.js"></script>
	<!--时间js-->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.countdown.js"></script>
	<script>
		window.jQuery(function($) {
			"use strict";
			
			$('time').countDown({
				with_separators : false
			});
			$('.alt-1').countDown({
				css_class : 'countdown-alt-1'
			});
			$('.alt-2').countDown({
				css_class : 'countdown-alt-2'
			});
			
		});
		
		
		//$(function() {
		//	$('li.option label').click(function() {
		//	debugger;
		//		var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
		//		var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
		//		// 设置已答题
		//		if(!cardLi.hasClass('hasBeenAnswer')){
		//			cardLi.addClass('hasBeenAnswer');
		//		}
		//		});
		//});
	</script>
	
	</div>
</body>
</html>