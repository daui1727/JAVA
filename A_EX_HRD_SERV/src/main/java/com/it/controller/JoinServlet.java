package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.MemberDAO;
import com.it.dto.MemberVO;

@WebServlet("/joinForm.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "joinForm.jsp";
		
		int custno = 100001;
		MemberDAO mDao = MemberDAO.getInstance();
		
		MemberVO mVo = mDao.getSeq(custno);
		request.setAttribute("mVo", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberVO mVo = new MemberVO();
		mVo.setCustno(Integer.parseInt(request.getParameter("custno")));
		mVo.setCustname(request.getParameter("custname"));
		mVo.setPhone(request.getParameter("phone"));
		mVo.setAddress(request.getParameter("address"));
		mVo.setJoindate(request.getParameter("joindate"));  //
		mVo.setGrade(request.getParameter("grade"));
		mVo.setCity(request.getParameter("city"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.insertMember(mVo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('정보 등록 성공'); location.href='memberForm.do';</script>"); 
		writer.close();
		
	}

}





