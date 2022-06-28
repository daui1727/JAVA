<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ page import="com.springbook.biz.user.impl.*"%>
<%@ page import="com.springbook.biz.user.*"%>

<%
	session.invalidate();
	
	request.isRequestedSessionIdValid();
	
	if (session == null || !request.isRequestedSessionIdValid()) {
	    System.out.println("세션이 무효화 상태입니다.");
	}

	RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
	dis.forward(request, response);
%>