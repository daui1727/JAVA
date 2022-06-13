/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.53
 * Generated at: 2022-06-09 05:46:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.it.dto.MemberVO;
import java.util.*;
import com.it.dao.*;
import java.text.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.it.dao");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.it.dto.MemberVO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      com.it.dao.MemberDAO dao = null;
      dao = (com.it.dao.MemberDAO) _jspx_page_context.getAttribute("dao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dao == null){
        dao = new com.it.dao.MemberDAO();
        _jspx_page_context.setAttribute("dao", dao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");

	//1. 사용자 입력값 받기(page)
	String strpage = request.getParameter("page");
	if(strpage == null){
		strpage = "1";
	}
	
	int curpage = Integer.parseInt(strpage);
	// 2. DB로부터 데이터를 읽어온다.
	List<MemberVO> list = dao.memberListData(curpage);
	int totalPage = dao.memberTotalPage();
	
	
	// 3. 페이지 나누기

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원목록 조회 / 수정</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	\r\n");
      out.write("	*{margin:0; padding:0;}\r\n");
      out.write("	li{list-style:none;}\r\n");
      out.write("	a{text-decoration:none;}\r\n");
      out.write("	\r\n");
      out.write("	header,nav,section,footer{width:1000px; margin:0 auto;}\r\n");
      out.write("	\r\n");
      out.write("	header{height:100px; line-height:100px; background:#3557d5;}\r\n");
      out.write("	header h1{text-align:center; color:#fff;}\r\n");
      out.write("	\r\n");
      out.write("	nav{height: 40px; line-height:40px; background:#8f8ce7;}\r\n");
      out.write("	nav ul{float:left;}\r\n");
      out.write("	nav ul li{float:left; margin:0 50px;}\r\n");
      out.write("	nav ul li a{color: #fff;}\r\n");
      out.write("	\r\n");
      out.write("	section{height: 700px; background:#e5e5e5;}\r\n");
      out.write("	section h2{text-align:center; padding:40px 0;}\r\n");
      out.write("	section table{margin: 0 auto; width:700px;}\r\n");
      out.write("	section th{width:350px;}\r\n");
      out.write("	section th.adr{width:900px;}\r\n");
      out.write("	section tr{height:45px; text-align:center;}\r\n");
      out.write("	section td{font-size:12px;}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	footer{height: 50px; line-height:50px; background:#3665b5;}\r\n");
      out.write("	footer h2{color: #fff; text-align:center; font-size:12px;}\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<header>\r\n");
      out.write("		<h1>쇼핑몰 회원관리 ver1.0</h1>\r\n");
      out.write("	</header>\r\n");
      out.write("	\r\n");
      out.write("	<nav>\r\n");
      out.write("		<ul>\r\n");
      out.write("			<li><a href=\"register.jsp\">회원 등록</a></li>\r\n");
      out.write("			<li><a href=\"list.jsp\">회원목록조회 / 수정</a></li>\r\n");
      out.write("			<li><a href=\"sales.jsp\">회원매출조회</a></li>\r\n");
      out.write("			<li><a href=\"index.jsp\">홈으로</a></li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</nav>\r\n");
      out.write("	\r\n");
      out.write("	<section>\r\n");
      out.write("		<h2>회원목록 조회 / 수정</h2>\r\n");
      out.write("		<table border=\"1\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>회원번호</th>\r\n");
      out.write("				<th>회원성명</th>\r\n");
      out.write("				<th>전화번호</th>\r\n");
      out.write("				<th class=\"adr\">주소</th>\r\n");
      out.write("				<th>가입일자</th>\r\n");
      out.write("				<th>고객등급</th>\r\n");
      out.write("				<th>거주지역</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

				for(MemberVO vo : list){
			
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td><a href=\"#\">");
      out.print( vo.getCustno() );
      out.write("</a></td>\r\n");
      out.write("				<td>");
      out.print( vo.getCustname() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( vo.getPhone() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( vo.getAddress() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( vo.getJoindate() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( vo.getGrade() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print( vo.getCity() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("		</table>\r\n");
      out.write("	</section>\r\n");
      out.write("	\r\n");
      out.write("	<footer>\r\n");
      out.write("		<h2>HRDKOREA Copyright©2016 All rights reseved. Human Resources Devlopment Service of Korea</h2>\r\n");
      out.write("	</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
