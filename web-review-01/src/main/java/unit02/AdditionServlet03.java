package unit02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionServlet03")
public class AdditionServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = 20;
		int n2 = 10;
		
		int add = n1 + n2;
		
		request.setAttribute("num1", n1);
		request.setAttribute("num2", n2);
		request.setAttribute("add", add);
		
		// 															이동할 페이지 지정
		RequestDispatcher dispatcher = request.getRequestDispatcher("addition03.jsp");
		// forward 방식은 서버 상에서 페이지기 이동되기 때문에 브라우저는 알아채지 못하고 URL도 변경되지 않는다. 
		dispatcher.forward(request, response);
		
	}

}
