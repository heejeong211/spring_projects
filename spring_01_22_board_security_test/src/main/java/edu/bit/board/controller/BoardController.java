package edu.bit.board.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageMaker;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/login/loginForm")
	public String loginForm(Model model) {
		logger.info("Welcome Login Form!");
		
		return "login/loginForm2";
	}
	
	@RequestMapping("/user/userHome")
	public String userHome(Model model) {
		logger.info("Welcome userHome!");
		
		return "user/user";
	}
	
	@RequestMapping("/admin/adminHome")
	public String adminHome(Model model) {
		logger.info("Welcome adminHome!");
		
		return "admin/adminHome";
	}
	
	@RequestMapping("/login/accessDenied")
	public String accessDenied(Model model) {
		logger.info("accessDenied!");
		
		return "/login/accessDenied";
	}
	
	//어떤 유저가 로그인 했는지 알고 싶을 때(3가지 방법)
	@RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
	public String loginInfo(Principal principal,Model model) {
		
		//1.Controller를 통하여 Pincipal객체로 가져오는 방법 - Authentication 안에 Principal 이거 있음.
		String user_id = principal.getName();
		System.out.println("유저 아이디:" + user_id   );
		
		//2.SpringContextHolder를 통하여 가져오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user_id = auth.getName();
        System.out.println("유저 아이디:" + user_id   );
        
    	//3.User 클래스로 변환 하여 가져오는 방법 - springSecurity에 있는 User임.
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user_id = user.getUsername();
        System.out.println("유저 아이디:" + user_id   );
        
        return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		model.addAttribute("list", boardService.selectBoardList());
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO, Model model) {
		System.out.println("write()");
		
		boardService.insertBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		String bId = request.getParameter("bId");
		model.addAttribute("content_view", boardService.selectBoardOne(bId));
		
		return "content_view";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO boardVO, Model model) {
		System.out.println("modify()");
		
		boardService.updateBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		String bId = request.getParameter("bId");
		model.addAttribute("reply_view", boardService.selectBoardOne(bId));
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) {
		System.out.println("reply()");
		
		boardService.writeReply(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO, Model model) { //BoardVO에 컬럼이름이랑 변수명이 일치될 때 boardVO에 저장됨
		System.out.println("delete()");
		
		boardService.deleteBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/list2")
	public String list2(Criteria criteria, Model model) { //Model은 주소 넣어서 IoC컨테이너가 주입시켜줌.
		System.out.println("list2()");
		
		PageMaker pageMaker = new PageMaker(); //bean을 이용해서 객체 생성 안함
		pageMaker.setCri(criteria);
		
		System.out.println(criteria.getPerPageNum());
		System.out.println(criteria.getPage());
		
		//전체 게시글 카운팅해주는 함수 불러옴
		int totalCount = boardService.selectCountBoard();
		System.out.println("전체 게시물 수를 구함: " + totalCount);
		
		//전체값 세팅
		pageMaker.setTotalCount(totalCount);
		
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria); //Criteria는 어떻게 넘어올까? PageMaker에서 Criteria가 세팅되서 넘어옴. IoC 컨테이너가 디폴트 생성자를 보고 알아서 객체 생성해서 가지고 옴. 그래서 처음값은 1하고 10이다.
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageMaker", pageMaker);
		
		return "list2";
	}
	
}
