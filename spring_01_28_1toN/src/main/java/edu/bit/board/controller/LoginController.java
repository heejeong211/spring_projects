package edu.bit.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;

@Controller
@RequestMapping("/member")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//로그인
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req,RedirectAttributes rttr) {
		
		System.out.println("login 호출");
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserVO login = loginService.loginUser(id, pw);
		
		if(login == null) {
			
			//RedirectAttributes
			//새로고침하면 날라가는 데이터(일회성)
			rttr.addFlashAttribute("msg", false);
		}else {
			 session.setAttribute("member", login);			
		}
		
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String login(HttpSession session) {
		
		System.out.println("login 호출");
		
		session.invalidate();
		
		return "redirect:/";
	}

}
