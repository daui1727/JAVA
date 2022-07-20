<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 게시판</title>
<!-- Link -->
<link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/assets/css/font-awesome.css">
<link rel="stylesheet" href="/resources/assets/css/basic.css">
<link rel="stylesheet" href="/resources/assets/css/main.css">
<link rel="stylesheet" href="/resources/assets/css/owl-carousel.css">


</head>
<body>

	<!-- Header -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- logo -->
                        <a href="index.jsp" class="logo">
                            <img src="assets/images/logo.png" alt="오이마켓">
                        </a>
                        <!--// logo-->
                        <!-- menu -->
                        <ul class="nav">
                            <li class="scroll-to-section"><a href="#">서비스 소개</a></li>
                            <li class="scroll-to-section"><a href="#popular">둘러보기</a></li>
                            <li class="scroll-to-section"><a href="#customer">고객센터</a></li>
                            <li><a href="login.jsp">로그인</a></li>
                            <li><a href="#"><i class="fa fa-search"></i></a></li>
                        </ul>
                        <!--// menu-->
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!--// header-->
    
    <!-- Board - popular -->
    <section class="section" id="popular">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="section-heading">
                        <h2>인기 오이 순 &nbsp;&nbsp;&nbsp;<a href="#">더 보기 > </a></h2>
                    </div>
                </div>
                <div class="col-lg-6">
                    <a href="insert.jsp" class="plus-button"><i class="fa fa-plus"></i></a>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="popular-item-carousel">
                        <div class="owl-popular-item owl-carousel">
                            <!-- 인기 게시글 01 -->
                            <div class="item">
                                <div class="thumb">
                                    <div class="hover-content">
                                        <ul>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-eye"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <img src="assets/images/board-01.jpg" alt="게시판 / 상품 등록 시 그림이 src에 올라가야한다.">
                                </div>

                                <div class="down-content">
                                    <h4>임영웅 인천콘서트 7월16일</h4>
                                    <span>60,000원</span>
                                </div>
                            </div>

                            <!-- 인기 게시글 02 -->
                            <div class="item">
                                <div class="thumb">
                                    <div class="hover-content">
                                        <ul>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-eye"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <img src="assets/images/board-02.jpg" alt="게시판 / 상품 등록 시 그림이 src에 올라가야한다.">
                                </div>

                                <div class="down-content">
                                    <h4>에어 써큘레이터</h4>
                                    <span>10,000원</span>
                                </div>
                            </div>

                            <!-- 인기 게시글 03 -->
                            <div class="item">
                                <div class="thumb">
                                    <div class="hover-content">
                                        <ul>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-eye"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <img src="assets/images/board-03.jpg" alt="게시판 / 상품 등록 시 그림이 src에 올라가야한다.">
                                </div>

                                <div class="down-content">
                                    <h4>저 내일 생일이에여!!!</h4>
                                    <span>500원</span>
                                </div>
                            </div>

                            <!-- 인기 게시글 04 -->
                            <div class="item">
                                <div class="thumb">
                                    <div class="hover-content">
                                        <ul>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-eye"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#번호 넘겨서 세부 페이지 받는"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <img src="assets/images/board-04.jpg" alt="게시판 / 상품 등록 시 그림이 src에 올라가야한다.">
                                </div>

                                <div class="down-content">
                                    <h4>다이슨 드라이기 미사용</h4>
                                    <span>250,000원</span>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--// Board - popular -->
    
    <!--footer-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="first-item">
                        <div class="logo">
                            <h2>오이마켓</h2>
                        </div>
                        <ul>
                            <li><a href="#">경기 수원시 팔달구 덕영대로 방탄오이단 (오이서비스)</a></li>
                            <li><a href="#">사업자 등록번호 : 52-52-525252</a></li>
                            <li><a href="#">010-123-4567</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-3">
                    <ul>
                        <li><a href="#">자주 묻는 질문</a></li>
                        <li><a href="#">믿을 수 있는 중고거래</a></li>
                        <li><a href="#">광고주센터</a></li>
                    </ul>
                </div>

                <div class="col-lg-2">
                    <ul>
                        <li><a href="#">회사 소개</a></li>
                        <li><a href="#">동네 가게</a></li>
                        <li><a href="#">채용</a></li>
                    </ul>
                </div>

                <div class="col-lg-3">
                    <ul>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">개인정보처리방침</a></li>
                        <li><a href="#">위치기반서비스 이용약관</a></li>
                    </ul>
                </div>

                <div class="col-lg-12">
                    <div class="under-footer">
                        <p>Copyright © 2022 52CucumberMarket Co., All Rights Reserved. 
                        <ul>
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-behance"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--// footer-->


    <!-- jQuery -->
    <script src="/resources/assets/js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="/resources/assets/js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="/resources/assets/js/owl-carousel.js"></script>
    <script src="/resources/assets/js/slick.js"></script>


    <!-- custom -->
    <script src="/resources/assets/js/custom.js"></script>
    

</body>
</html>