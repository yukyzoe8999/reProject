<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<title>TourDetail</title>
<link rel="stylesheet" href="${root}/css/user/style_tour.css">
</head>
<body>
	<div class="wrap">
		<header class="header">
			<div class="inner">
				<c:if test="${sessionScope.name eq null}">
					<div class="navbar_right">
						<ul>
<%-- 						<li><a href="#"><s:message code="common.btnClose"/></a></li> --%>
							<li><a href="memberLogin">Login</a></li>
							<li><a href="memberLogout">Sign up</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${sessionScope.name ne null}">
					<div class="navbar_right">
						<ul>
						<li>${name}님환영합니다.</li>
							<li><a href="memberLogout">Log Out</a></li>
						</ul>
					</div>
				</c:if>
				<h1>
					<a href="index"><img
						src="${root}/image/luggage.png" alt=""></a>
				</h1>
			</div>
		</header>
		<section class="middle_bar">
			<div class="inner">
				<ul>
				 <li><a href="index">Home</a></li>
					<li><a href="tour">여행지소개</a></li>
					<li><a href="#">여행후기</a></li>
					<li><a href="board">Board</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
		</section>
		<section class="content">
			<div class="inner">
				<ul class="contentbox">
					<li class="contentlist">
						<div class="smallcontent">
							<span class=thum> <a class="imgover" href="#"><img src="${root}/image/cf2b6d07548849a1bfaf80010c0d34a0.jpg"
								alt=""></a></span>
							<div class="smallname">부산</div>
							<div class="smalldescrp"> 장소 설명</div>
						</div>
					</li>
				</ul>
			</div>
		</section>

		<section class="date">
		<form action="TourDetail" method="post"></form>
		<select name = "ppl">
		<option value="${param.r}">1명</option>
		<option value="${param.r}">2명</option>
		<option value="${param.r}">3명</option>
		<option value="${param.r}">4명</option>
		</select>
		<input type="text"  name="i" value="${param.i}" class="startDate"/>
		<input type="text"  name="o" value="${param.o}" class="endDate"/>
		<input type="submit" value="검색"/>
		</section>

	</div>
	<script type="text/javascript">
 $(function() {
    $( ".startDate" ).datepicker({
     showOn: "both",
     changeMonth: true,
     changeYear: true,
     closeText: '닫기',
     dateFormat: 'yy-mm-dd'
     });
    $( ".endDate" ).datepicker({
	     showOn: "both",
	     changeMonth: true,
	     changeYear: true,
	     closeText: '닫기',
	     dateFormat: 'yy-mm-dd'
	     });
 });

	   

 </script>


</body>
</html>