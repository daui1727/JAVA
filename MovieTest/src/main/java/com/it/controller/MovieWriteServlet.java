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

@WebServlet("/movieWrite.do")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext(); // 업로드할 파일 경로를
		String path = context.getRealPath("upload");  // 서버 상의 실제 경로로 찾아온다.
		String encType = "UTF-8";
		int sizeLimit = 20*1024*1024;
		
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis = multi.getParameter("synopsis");
		String poster = multi.getFilesystemName("poster");
		
		MemberVO mVo = new MemberVO();
		mVo.setTitle(title);
		mVo.setPrice(price);
		mVo.setDirector(director);
		mVo.setActor(actor);
		mVo.setSynopsis(synopsis);
		mVo.setPoster(poster);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMovie(mVo);
		
		if(result == 1) {
			response.sendRedirect("movieList.do");
		}else {
			response.sendRedirect("movie/movieWrite.jsp");
		}
		
		
	}

}
