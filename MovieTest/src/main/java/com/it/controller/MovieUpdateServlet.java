package com.it.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.MemberDAO;
import com.it.dto.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/movieUpdate.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectMovieByCode(code);
		
		request.setAttribute("movie", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieUpdate.jsp");
		dispatcher.forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// cos file upload 하기 위해서
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		String code = multi.getParameter("code");
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis = multi.getParameter("synopsis");
		String poster = multi.getFilesystemName("poster");
		if(poster == null) {
			poster = multi.getParameter("nonmakeImg");
		}
		
		MemberVO mVo = new MemberVO();
		mVo.setCode(Integer.parseInt(code));
		mVo.setTitle(title);
		mVo.setPrice(price);
		mVo.setDirector(director);
		mVo.setActor(actor);
		mVo.setSynopsis(synopsis);
		mVo.setPoster(poster);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMovie(mVo);
		
		response.sendRedirect("movieList.do");
	}

}
