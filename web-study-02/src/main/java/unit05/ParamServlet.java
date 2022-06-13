package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
//		String id = request.getParameter("id");
		int id = Integer.parseInt(request.getParameter("id"));
		// String age = request.getParameter("age");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		out.println("name = " + name);
		out.println("id = " + id);
		out.println("age = " + age + "<br><br>");
		
		
		out.println(id + age + "<br>");
		out.println(id * age + "<br>");
		out.println(id - age + "<br>");
		out.println(id / age);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		
	}

}
