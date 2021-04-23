<%@ page import="pp.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://kit.fontawesome.com/9eb162ac0d.js"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%-- <link rel="stylesheet" href="${root}/css/user/style_boardRead2.css?ver=2"> --%>
<meta charset="UTF-8">
<title>BoardDetail</title>
<Style>
* {
	padding: 0;
	margin: 0;
}

.wrap {
	width: 100%;
}

.inner {
	width: 1200px;
	margin: 0 auto;
	overflow: hidden;
}

ul, li {
	list-style: none;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: gray;
}

.header {
	width: 100%;
	height: 120px;
	text-align: center;
	float: left;
}

.header .navbar_right {
	width: 300px;
	float: right;
	position: relative;
	top: 5px;
}

.header h1 {
	width: 200px;
	position: relative;
	top: 10px;
	left: 517px;
	text-align: center;
}

.header h1 img {
	height: 100px;
}

.header .navbar_right ul li {
	list-style-type: none;
	float: left;
	padding-left: 20px;
}

.header .navbar_right ul li a {
	text-decoration: none;
	color: black;
}

.middle_bar {
	width: 100%;
	float: left;
	background-color: rgb(194, 194, 194);
}

.middle_bar .inner ul {
	text-align: center;
}

.middle_bar .inner ul li {
	width: 10%;
	list-style-type: none;
	float: left;
	padding: 10px 0px 10px;
	text-align: center;
	position: relative;
	left: 310px;
	border-right: 1px solid rgb(161, 161, 161);
}

.middle_bar .inner ul li a {
	text-decoration: none;
	color: white;
}

.middle_bar .inner ul li:nth-child(5) {
	border-right: none;
}

.smallmenu {
	width: 100%;
	padding-top: 10px;
	padding-left: 170px;
	float: left;
	font-size: 14px;
	padding-bottom: 10px;
}

.inner .Rtable {
	text-align: center;
}

.tabletitle td {
	background-color: rgb(219, 238, 255);
}

.texttable {
	border: 1px solid rgb(131, 131, 131);
	border-collapse: collapse;
	/* 	border-right : none; */
	/* 	border-left: none; */
	/* 	text-align: center; */ margin-top : 20px;
	display: inline-block;
	margin-top: 20px;

	/* position: relative;
	top: 10px;
	left: 200px; */
}

.inner .texttable tr td {
	border-bottom: 1px solid rgb(131, 131, 131);
	padding: 5px 60px 5px;
}

.writing input {
	border: 1px solid rgb(131, 131, 131);
	text-align: center;
}

.inner .button {
	display: flex;
	justify-content: center;
}

.button>ul>li, .button>.aaa>ul li {
	float: left;
	padding: 1px 20px 1px;
}

.middlebutton {
	text-align: center;
}

.tabletitle2 {
	border: 1px solid rgb(131, 131, 131);
	float: left;
	width: 800px;
	font-size: 12px;
	margin-left: 170px;

}

.tabletitle2 #lefttitle {
	text-align: center;
}

.tabletitle2 #righttitle {
	float: right;
	color: gray;
}
.tabletitle2 #righttitle2 {
	float: right;
	color: gray;
}

.tabletitle2 #content {
	clear: both;
	width: 100%;
	height: 300px;
}

#ltrt {
	padding: 10px 10px;
	border-bottom: 1px dotted lightblue;
}

.tabletitle2 #contentarea {
	padding: 10px 10px;
}

.tabletitle2 #rly {
	padding: 10px 10px;
	border-top: 1px dotted lightblue;
}

.recomment {
	padding: 10px 10px;
}
.eachcomment {
	padding-bottom:10px;
}
.attfile {
	display:none;
}
</Style>
</head>
<body>

	<div class="wrap">
		<header class="header">
			<div class="inner">
				<c:if test="${sessionScope.name eq null}">
					<div class="navbar_right">
						<ul>
<%-- 							<li><a href="#"><s:message code="common.btnClose" /></a></li> --%>
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
					<a href="${root}index"><img src="${root}/image/luggage.png"
						alt=""></a>
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
		<div class="smallmenu">
			<div class="inner">
				<i class="fas fa-home"></i><a href="index"> Home</a><a href="board">
					> Board</a>
			</div>
		</div>
		<!--LIST -->
		<div class="inner">
			<div class="tabletitle2">
				<p id="ltrt">
					<span id="lefttitle">${bo.title}</span> <span id="righttitle2">작성자
						${bo.writer_id} | 작성일 <fmt:formatDate value="${bo.regdate}"
							pattern="yyyy.MM.dd. hh:mm" /> | 조회수 <fmt:formatNumber
							value="${bo.hit}" type="number" pattern="###,###" />
					</span>
				</p>
				<div id="contentarea">
					<div id="righttitle">첨부파일
					<p class="attfile">
					<c:forTokens var="fileName" items="${bo.files}" delims="," varStatus="t">
		               <c:set var="style" value=""/>

		               <c:if test="${fn:endsWith(fileName, '.zip') }">
		                  <c:set var="style" value="font-weight:bold; color:red;" />
		               </c:if>

		               <a href="${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
		               <c:if test="${!t.last}">
		                  /
		               </c:if>

		            </c:forTokens>
		</p></div>
					<div id="content">${bo.content}</div>
				</div>
				
			    <!-- 댓글 -->
				<div id="rly">댓글</div>
				<div class="recomment">
					<form action="boardComment" method="post">
						<input type="hidden" name="mid" value="${param.bid}" />
						<c:set var="cnt" value="${count}" />
							<c:if test="${cnt == 0}"> 
							댓글이 없습니다.
							</c:if>
							<c:if test="${cnt != 0}">

									<c:forEach var="n" items="${co}">
										<tr id="eachcomment">
											<th id="writer">${n.writerID}</th>
											<td id="comment">${n.comment}</td>
											<td id="time"><fmt:formatDate pattern="yyyy.MM.dd"
										     value="${n.regdate}"></fmt:formatDate></td>
										</tr>
										<br>
									</c:forEach>

							</c:if>
						<table class="writing">
							<tr>

								<td><input type="hidden" name="writerID" value="${id}" />
									<!-- 글쓴이(로그인 한 사람) --> <input type="hidden" name="id" value="" />
									<!-- 글쓴이(로그인 한 사람) --> <input type="text" name="comment" /> <!-- comment --></td>
								<td>
								<c:if test="${sessionScope.id != null}">
										<input type="submit" value="등록" />
										<!-- date -->
									</c:if> <c:if test="${sessionScope.id eq null}">
										<input type="button" onClick="alert('로그인하세요.')" value="등록" />
									</c:if></td>
							</tr>
							
						</table>

						
					</form>
				</div>
			</div>
		</div>
		<!-- <div class="inner"> -->
		<!-- <div class = "Rtable"> -->
		<!--    <table class="texttable"> -->
		<!--       <tr> -->
		<!--          <td>제목</td> -->
		<%--          <td colspan="3">${bo.title}</td> --%>
		<!--       </tr> -->
		<!--       <tr> -->
		<!--          <td>작성일</td> -->
		<!--          <td colspan="3"> -->
		<%--          <fmt:formatDate value="${bo.regdate}" pattern="yyyy.MM.dd. hh:mm"/> --%>
		<!--          </td> -->
		<!--       </tr> -->
		<!--       <tr> -->
		<!--          <td>작성자</td> -->
		<%--          <td>${bo.writer_id}</td> --%>
		<!--          <td>조회수</td> -->
		<%--          <td><fmt:formatNumber value="${bo.hit}" type="number" pattern="###,###"/></td> --%>
		<!--       </tr> -->
		<!--       <tr> -->
		<!--          <td>첨부파일</td> -->
		<!--          <td colspan="3"> -->
		<%--             <c:forTokens var="fileName" items="${bo.files}" delims="," varStatus="t"> <!-- split 개념 (짜르기) delims는 구분자 --> --%>
		<%--                <c:set var="style" value=""/> --%>

		<%--                <c:if test="${fn:endsWith(fileName, '.zip') }"> --%>
		<%--                   <c:set var="style" value="font-weight:bold; color:red;" /> --%>
		<%--                </c:if> --%>

		<%--                <a href="${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a> --%>
		<%--                <c:if test="${!t.last}"> --%>
		<!--                   / -->
		<%--                </c:if> --%>

		<%--             </c:forTokens> --%>
		<!--          </td> -->
		<!--       </tr> -->
		<!--       <tr> -->
		<%--          <td colspan="4">${bo.content}</td> --%>
		<!--       </tr> -->

		<!--    </table> -->
		<!--    </div> -->
		<!--    </div> -->
		<div class="middlebutton">
			<div class="inner">
				<!-- 목록 버튼 -->
				<input type="button"
					onclick="location.href='board?f=${param.f}&q=${param.q}&p=${param.p}'"
					value="목록">
				<c:if test="${sessionScope.id eq bo.writer_id}">
					<!-- 글삭제 버튼 -->
					<script>
						function checkYN() {
							let yn = confirm("정말 삭제하시겠습니까?");
							console.log(yn);
							if (yn == true) {
								alert('글이 삭제되었습니다.');
								document.getElementById("delete").submit();
							} else {
								alert('글삭제를 취소합니다.');
							}
						}
					</script>

					<input type="button" onclick="checkYN()" value="글삭제" />
				</c:if>
			</div>


			<form id="delete" action="boarddelete">
				<input type="hidden" name="bid" value="${param.bid}" />
			</form>


		</div>
	</div>
	<script>
	$(document).ready(function(){
		  $('#righttitle').click(function(){
		    $('.attfile').toggle('slow');
		  });
		});
  </script>
</body>
</html>