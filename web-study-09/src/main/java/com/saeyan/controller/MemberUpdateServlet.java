package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		// MemberDAO 객체를 얻어와서 getMember() 메서드로 member 테이블에서 userid만이 아니라 회원정보를 모두 얻어온다.
		MemberVO mVo = mDao.getMember(userid);
		
		request.setAttribute("mVo", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		MemberVO mVo = new MemberVO();
		mVo.setUserid(request.getParameter("userid"));
		mVo.setPwd(request.getParameter("pwd"));
		mVo.setEmail(request.getParameter("email"));
		mVo.setPhone(request.getParameter("phone"));
		mVo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		mDao.updateMember(mVo);
		
		response.sendRedirect("login.do");
	
	}

}
