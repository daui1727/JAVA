package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();	// 업로드할 파일 경로를
		String path = context.getRealPath("upload");  // 서버 상의 실제 경로로 찾아온다.
		String encType = "UTF-8";
		int sizeLimit = 20*1024*1024;  // 업로드 파일크기 지정 최대 20MB
		
		// multipartRequest 객체가 생성되는 순간 서버로 파일이 업로드된다.
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		// 파일 폼에서 선택한 파일의 이름을 얻어오기 위해서는 <input type="file"> 태그의 
		// name 속성 값을 MultipartRequest 객체로 getFilesystemName()메서드의 매개변수로 전달해준다.
		String pictureurl = multi.getFilesystemName("pictureurl");
		
		ProductVO pVo = new ProductVO();
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureurl(pictureurl);
		
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.insertProduct(pVo);
		
		System.out.println(result);
		if(result == 1) {
			response.sendRedirect("productList.do");
		}else {
			response.sendRedirect("product/productWrite.jsp");
		}
		
		
	}

}
