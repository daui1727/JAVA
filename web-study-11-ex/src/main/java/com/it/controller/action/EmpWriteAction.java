package com.it.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.MemberDAO;
import com.it.dto.MemberVO;

public class EmpWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO mVo = new MemberVO();
		
		mVo.setId(request.getParameter("id"));
		mVo.setPass(request.getParameter("pass"));
		mVo.setName(request.getParameter("name"));
		mVo.setLev(request.getParameter("lev"));
		mVo.setGender(request.getParameter("gender"));
		mVo.setPhone(request.getParameter("phone"));
	
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.insertEmployees(mVo);
		
		new EmpListAction().execute(request, response);
		
	}

}
