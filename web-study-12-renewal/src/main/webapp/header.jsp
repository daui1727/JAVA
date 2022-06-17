<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Shop</title>
<link href="css/shopping.css" rel="stylesheet">
<link >
</head>

<body>

	<div id="wrap">
	
	<!-- header -->
	<header>
	
		<!-- logo -->
		<div id="logo">
			<a href="NonageServelet?command=index">Nonage</a>
		</div>
		<!-- //logo -->
		<!-- nav 1 -->
		<nav id="category_menu">
			<ul>
				<c:choose>
					<c:when test="${empty sessionScope.loginUser}">
						<li>
							<a href="NonageServlet?command=login_form" style="width:110px;">LOGIN(CUSTOMER)</a>
							&nbsp;&nbsp; |
							<a href="NonageServlet?command=admin_login_form" style="width:110px;">(ADMIN)</a>
						</li>
					</c:when>
					<c:otherwise>
						<li style="color:#F4E06D">
							${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
						</li>
						<li><a href="NonageServlet?command=logout">LOGOUT</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="NonageServlet?command=cart_list">CART</a></li>
				<li><a href="NonageServlet?command=mypage">MY PAGE</a></li>
				<li><a href="NonageServlet?command=qna_list">Q&amp;A(1:1)</a></li>
			</ul>
		</nav>
		<!-- //nav 1 -->
		
		<!-- nav 2 -->
		<nav id="top_menu">
			<ul>
				<li><a href="NonageServlet?command=category&kind=1">Heels</a></li>
				<li><a href="NonageServlet?command=category&kind=2">Boots</a></li>
				<li><a href="NonageServlet?command=category&kind=3">Sandals</a></li>
				<li><a href="NonageServlet?command=category&kind=4">Sneakers</a></li>
				<li><a href="NonageServlet?command=category&kind=5">On Sale</a></li>
			</ul>
		</nav>
		<!-- //nav 2 -->
		<div class="clear"></div>
	</header>
	<!-- //header -->
	

</body>
</html>