package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


@Controller
public class LoginController{

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		
		System.out.println("로그인 처리");
		
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if(userDAO.getUser(vo) != null) {
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
		
		
	}
	

}
