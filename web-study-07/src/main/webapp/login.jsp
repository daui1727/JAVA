<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <c:choose>
		<c:when test="${param.radiock == 1}">
			<span>${param.id} 사용자로 로그인하셨습니다.</span>
		</c:when>
		
		<c:when test="${param.radiock == 2}">
			<span>${param.id} 관리자로 로그인하셨습니다.</span>
		</c:when>
	</c:choose> --%>
	
	<c:if test="${param.radiock == 1}">
		<span>${param.id} 사용자로 로그인하셨습니다.</span>
	</c:if>
	
	<c:if test="${param.radiock == 2}">
		<span>${param.id} 관리자로 로그인하셨습니다0.</span>
	</c:if>

</body>
</html>