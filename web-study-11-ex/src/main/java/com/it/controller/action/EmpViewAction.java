package com.it.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.MemberDAO;
import com.it.dto.MemberVO;

public class EmpViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "emp/emp_view.jsp";
		
		String id = request.getParameter("id");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectViewEmployees(id);
		request.setAttribute("emp", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
