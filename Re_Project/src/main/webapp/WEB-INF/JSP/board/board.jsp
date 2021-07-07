<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${root}/css/user/style_board.css">
<script src="https://kit.fontawesome.com/9eb162ac0d.js"
   crossorigin="anonymous"></script>
<title>Insert title here</title>
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
					<a href="${root}/index"><img src="${root}/image/luggage.png" alt=""></a>
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
        <div class="smallmenu"><div class="inner"><i class="fas fa-home"></i><a href="index"> Home</a><a href="board"> > Board</a></div></div>
		<!-- list -->
		<div class="inner">
			<div class="d_table">
				<table class="texttable">
					<tr class="tabletitle">
<!-- 						<td>번호</td> -->
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
					<c:forEach var="n" items="${list}" varStatus="t">
						<tr>
<%-- 							<td>${n.bid}</td> --%>
							<td><a
								href="boardRead?bid=${n.bid}&f=${param.f}&q=${param.q}&p=${param.p}">${n.title}</a></td>
							<td>${n.writer_id}</td>
							<td><fmt:formatDate value="${n.regdate}"
									pattern="yyyy.MM.dd." /></td>
							<td><fmt:formatNumber value="${n.hit}" type="number"
									pattern="###,###" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- 삭제 -->
			<!-- 글쓰기 버튼 -->
			<c:if test="${sessionScope.User ne 1}">
			<div class="writing">
					
				</div>
				
			</c:if>
			<c:if test="${sessionScope.User eq 1}">
				<div class="writing">
					<input type="button" onclick="location.href = 'Reg'" value="글쓰기" />
				</div>
			</c:if>
			<!-- 변수 선언 -->
			<c:set var="page" value="${empty param?1:param.p}"></c:set>
			<!-- param == 파라미터 -->
			<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
			<c:set var="lastNum"
				value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>
			<!-- Math.ceil로 올림 substring으로 소수점 짜르기 -->


			<!-- 현재페이지 -->
			<%--    <div>
         <h3>현재 페이지</h3>
         <div><span>${(empty param.p)?1:param.p}</span>/${lastNum}pages</div>   
   </div> --%>

			<!-- 페이지 이동 -->

			<!-- Prev 버튼 -->
			<div class="button">
				<div class="aaa">
					<ul>
					<li><button type="button"><a href="Reg">글쓰기(후)</a></button></li>
						<li><c:if test="${bo.page> 1}">
								<a href="?p=${startNum-1}&f=${param.f}&q=${param.q}">Prev</a>
								<!-- p:페이지 f:필드(타이틀) q:query(검색내용) -->
							</c:if> <c:if test="${bo.page<= 1}">
								<a href="#" onclick="alert('첫번째 페이지 입니다.');">Prev</a>
							</c:if></li>
						<!-- 페이징 -->
						<li>
							<ul>
								<c:forEach var="i" begin="0" end="4">
									<!-- 현재 보고있는 페이지 색깔변경 -->
									<c:if test="${bo.page == (bo.pageStart+i)}">
										<c:set var="style" value="font-weight:bold; color:lightblue;" />
									</c:if>
									<c:if test="${bo.page != (bo.pageStart+i)}">
										<c:set var="style" value="" />
									</c:if>

									<c:if test="${(bo.pageStart)<=bo.pageEnd}">
										<li><a style="${style}"
											href="?page=${bo.pageStart+i}&f=${param.f}&q=${param.q}">${bo.pageStart+i}</a></li>
									</c:if>

								</c:forEach>
							</ul>
						</li>
						<li>
							<!-- Next 버튼 --> <c:if test="${bo.page < bo.pageEnd}">
								<a href="?page=${bo.page+1}&f=${param.f}&q=${param.q}">Next</a>
							</c:if> <c:if test="${bo.page >= bo.pageEnd}">
								<a href="#" onclick="alert('마지막 페이지 입니다.');">Next</a>
							</c:if>
						</li>
						<li><button type="button"><a href="write">글쓰기(전)</a></button></li>
					</ul>
				</div>
			</div>
			<!-- 검색 -->
			<div class="search">
				<form>
					<select name="searchType">
						<option ${(param.searchType == "title")?"selected":""} value="title">제목</option>
						<option ${(param.searchType == "writer_id")?"selected":""}
							value="writer_id">글쓴이</option>
					</select> <label>검색어</label> <input type="text" name="searchKeyword" value="${param.searchKeyword}" />
					<input type="submit" value="Search" />
				</form>
			</div>
			<br>
		</div>
	</div>
</body>
</html>