<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${root}/css/user/style_login.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${root}/js/user/signUp.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/9eb162ac0d.js"
   crossorigin="anonymous"></script>
<title>Insert title here</title>
 <script> 
<!-- // function fn_formSubmit(){ -->
<!-- // 	if ( ! chkInputValue("#userid")) return false; -->
<!-- // 	if ( ! chkInputValue("#userpw")) return false; -->

 	$("#form1").submit(); 
 } 
 </script> 
</head>
<body>
	<h2>Welcome! &nbsp&nbsp <a href="index">메인으로 돌아가기</a></h2>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form role="form" action="memberSignUpChk" method="post" id="joinsection" name="joinsection" onsubmit="return createFrom(this)">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="${K_apiURL}" class="social"><i style = "color: rgb(245, 201, 3);" class="fab fa-kickstarter-k"></i></a> 
<!-- 					<i style = "color: blue;" class="fab fa-facebook-f"></i> -->
					<a href="https://accounts.google.com/signin/v2/identifier?hl=ko&passive=true&continue=https%3A%2F%2Fwww.google.com%2Fsearch%3Fq%3D%25EA%25B5%25AC%25EA%25B8%2580%25EB%25A1%259C%25EA%25B7%25B8%25EC%259D%25B8%26oq%3D%25EA%25B5%25AC%25EA%25B8%2580%25EB%25A1%259C%26aqs%3Dchrome.1.69i57j0l9.4412j0j4%26sourceid%3Dchrome%26ie%3DUTF-8&ec=GAZAAQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin" class="social"><i style = "color: red;" class="fab fa-google-plus-g"></i></a> 
					<a href="${N_apiURL}" class="social"><i style = "color: green;" class="fab fa-neos"></i></a>
				</div>
				<span>or use your email for registration</span> 
				<input type="text" placeholder="ID" name="id" maxlength="20" /> 
				<button type="button" onclick="idCheck(joinsection, '${root}')">아이디 중복</button> 
				<input type="password" placeholder="PASSWORD" name="password" maxlength="20" />
				<input type="text" placeholder="NAME" name="name" maxlength="20" /> 
				<input type="email" placeholder="EMAIL" name="email" maxlength="20">
				<button type="submit" value="SignUp">Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form role="form" action="memberLoginChk" method="post" id="form1">
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="${K_apiURL}" class="social"><i style = "color: rgb(245, 201, 3);" class="fab fa-kickstarter-k"></i></a> 
					<a href="https://accounts.google.com/signin/v2/identifier?hl=ko&passive=true&continue=https%3A%2F%2Fwww.google.com%2Fsearch%3Fq%3D%25EA%25B5%25AC%25EA%25B8%2580%25EB%25A1%259C%25EA%25B7%25B8%25EC%259D%25B8%26oq%3D%25EA%25B5%25AC%25EA%25B8%2580%25EB%25A1%259C%26aqs%3Dchrome.1.69i57j0l9.4412j0j4%26sourceid%3Dchrome%26ie%3DUTF-8&ec=GAZAAQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin" class="social"><i style = "color: red;" class="fab fa-google-plus-g"></i></a> 
					<a href="${N_apiURL}" class="social"><i style = "color: green;" class="fab fa-neos"></i></a>
				</div>
				<span>or use your account</span>
				<input id="ID" type="text" placeholder="ID" name="id" maxlength="20" />
				<input id ="PASS" type="password" placeholder="PASSWORD" name="password"  maxlength="20" />
<!-- 				<div class="checkbox"> -->
<!-- 				<label> <input name="remember" type="checkbox" value="Y" -->
<%-- 					<c:if test='${ID != null && ID != ""}'>checked</c:if>>Remember Me</label> --%>
<!-- 			</div> -->
				<button type="submit" value="login">Sign In</button>
			</form>
		</div>
		 <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h2>바로 로그인 하시겠습니까?</h2>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h2>아직 회원이 아니신가요?</h2>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
	</div>
	<script src="${root}/js/user/login.js"></script>
	<c:if test="${ff eq 1}">
	   <script>
	    
        jQuery(function(){
        	const container = document.getElementById('container');
        	container.classList.add("right-panel-active");
        });
        </script>
       </c:if>
</body>
</html>