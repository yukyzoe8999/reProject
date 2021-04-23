<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/9eb162ac0d.js"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<title>Main</title>
<link rel="stylesheet" href="${root}/css/user/style_main.css">
<style>
</style>
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
					<a href="${root}/index"><img
						src="${root}/image/luggage.png" alt=""></a>
				</h1>
			</div>
		</header>
		<section class="middle_bar">
			<div class="inner">
				<ul>
					<li><a href="index">Home</a></li>
					<li><a href="#tour">여행지소개</a></li>
					<li><a href="#">여행후기</a></li>
					<li><a href="board">Board</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
		</section>
		<section class="mainslider">
			<div class="firstslider">
				<div>
					<img src="${root}/image/CN-Tower-Stock.jpg" alt="">
				</div>
				<div>
					<img src="${root}/image/victoria_inner_harbour_flowers.jpg" alt="">
				</div>
			</div>
		</section>

		<a href="#section2" class="sliderbutton"> <i
			class="fas fa-arrow-circle-down"></i></a>



		<!-- 		<ul class="photo"> -->
		<%-- 		<c:forEach var="p" items="${plist}"> --%>
		<%-- 			<li><a href="photoview?pid=${p.id}"><img src="${root}/${p.pic}" width="250px" /></a> --%>
		<%-- 			<div>${p.country}</div> --%>
		<!-- 			</li> -->
		<%-- 		</c:forEach> --%>
		<!-- 	</ul> -->



		<section class="pic_info" id="section2">
			<div class="inner">
				<p id="tour">여행지 소개</p>
				<div class="information_box">
					<ul class="info">
						<li class="one_quarter">
						<c:forEach var="p" items="${plist}" varStatus="vs" begin="0" end="0">
								<figure>
									<img class="imgover1" src="${root}/${p.pic}" alt="">
									<figcaption>
										<strong>${p.country}</strong><br> <em>Korea~!</em>
									</figcaption>
								</figure>
							</c:forEach>
							<div class="koreadetail">
								<ul class="slider">
									<li>
										<figure>
											<a href="TourDetail"><img
												src="${root}/image/USA/LA.jpg" alt=""></a>
											<figcaption>
												<strong>서울</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href="TourDetail"><img
												src="${root}/image/korea/Busan.jpg" alt=""></a>
											<figcaption>
												<strong>부산</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a
												href="TourDetail"><img
												src="${root}/image/korea/jeju.jpg" alt=""></a>
											<figcaption>
												<strong>제주도</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a
												href="http://13.125.166.164:8080/Personal_Project/project/main"><img
												src="${root}/image/korea/Gyeongju.jpg" alt=""></a>
											<figcaption>
												<strong>경주</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a
												href="http://13.125.166.164:8080/Personal_Project/project/main"><img
												src="./Main_files/korea.jpg" alt=""></a>
											<figcaption>
												<strong>광주</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a
												href="http://13.125.166.164:8080/Personal_Project/project/main"><img
												src="${root}/image/korea/yongin.jpg" alt=""></a>
											<figcaption>
												<strong>용인</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a
												href="http://13.125.166.164:8080/Personal_Project/project/main"><img
												src="./Main_files/korea.jpg" alt=""></a>
											<figcaption>
												<strong>대전</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									
								</ul>
							</div></li>

						<li class="one_quarter">
						<c:forEach var="p" items="${plist}" varStatus="vs" begin="1" end="1">
								<figure>
									<img class="imgover2" src="${root}/${p.pic}" alt="">
									<figcaption>
										<strong>${p.country}</strong><br> <em>America~!</em>
									</figcaption>
								</figure>
							</c:forEach>
							<div class="usadetail">
								<ul class="slider">
									<li>
										<figure>
											<a href="TourDetail"><img src="${root}/image/USA/san_francisco.jpg"
												alt=""></a>
											<figcaption>
												<strong>샌프란시스코</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href="TourDetail"><img src="${root}/image/USA/san_diego.jpg"
												alt=""></a>
											<figcaption>
												<strong> 샌디에고</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href="TourDetail"><img src="${root}/image/USA/LA.jpg" alt=""></a>
											<figcaption>
												<strong>LA</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href="TourDetail"><img src="${root}/image/USA/las_vegas.jpg"
												alt=""></a>
											<figcaption>
												<strong>라스베가스</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href="TourDetail"><img src="${root}/image/USA/newyork.jpg"
												alt=""></a>
											<figcaption>
												<strong>뉴욕</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
								</ul>
							</div>
						</li>
						<li class="one_quarter">
							<c:forEach var="p" items="${plist}" varStatus="vs" begin="2" end="2">
								<figure>
									<img class="imgover3" src="${root}/${p.pic}" alt="">
									<figcaption>
										<strong>${p.country}</strong><br> <em>Japan~!</em>
									</figcaption>
								</figure>
							</c:forEach>
							<div class="japandetail">
								<ul class="slider">
									<li>
										<figure>
											<a href=""><img src="${root}/image/korea.jpg" alt=""></a>
											<figcaption>
												<strong>오사카</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href=""><img src="${root}/image/korea.jpg" alt=""></a>
											<figcaption>
												<strong>교토</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href=""><img src="${root}/image/korea.jpg" alt=""></a>
											<figcaption>
												<strong>후쿠오카</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href=""><img src="${root}/image/korea.jpg" alt=""></a>
											<figcaption>
												<strong>도쿄</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
									<li>
										<figure>
											<a href=""><img src="${root}/image/korea.jpg" alt=""></a>
											<figcaption>
												<strong>오키나와</strong><br> <em></em>
											</figcaption>
										</figure>
									</li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</section>


	</div>
	<script>
        $(document).ready(function () {
           var slider1 = $('.firstslider').bxSlider({
        	   auto:true,
        	   speed:1000,
        	   pause:3000,
           });
        });
    </script>
	<script>
        $(document).ready(function () {
          var slider2 =  $('.slider').bxSlider({
                minSlides: 3,
                maxSlides: 3,
                slideWidth: 360,
                slideMargin: 10,
            });
          $(".imgover1").click(function () {
          	$('.koreadetail .bx-wrapper').slideToggle();
          	
          });
          $(".imgover2").click(function () {
          	$('.usadetail .bx-wrapper').slideToggle();
          
          });
          $(".imgover3").click(function () {
          	$('.japandetail .bx-wrapper').slideToggle();
          
          });
        });
    </script>



	<script>
$(document).ready(function(){
  $("a").on('click', function(event) {
    if (this.hash !== "") {
      event.preventDefault();
     var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
        window.location.hash = hash;
      });
    } 

  });

});


</script>
	​

</body>

</html>