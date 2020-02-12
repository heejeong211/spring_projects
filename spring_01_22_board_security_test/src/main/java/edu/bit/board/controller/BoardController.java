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
	
	//� ������ �α��� �ߴ��� �˰� ���� ��(3���� ���)
	@RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
	public String loginInfo(Principal principal,Model model) {
		
		//1.Controller�� ���Ͽ� Pincipal��ü�� �������� ��� - Authentication �ȿ� Principal �̰� ����.
		String user_id = principal.getName();
		System.out.println("���� ���̵�:" + user_id   );
		
		//2.SpringContextHolder�� ���Ͽ� �������� ���
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user_id = auth.getName();
        System.out.println("���� ���̵�:" + user_id   );
        
    	//3.User Ŭ������ ��ȯ �Ͽ� �������� ��� - springSecurity�� �ִ� User��.
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user_id = user.getUsername();
        System.out.println("���� ���̵�:" + user_id   );
        
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
	public String delete(BoardVO boardVO, Model model) { //BoardVO�� �÷��̸��̶� �������� ��ġ�� �� boardVO�� �����
		System.out.println("delete()");
		
		boardService.deleteBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/list2")
	public String list2(Criteria criteria, Model model) { //Model�� �ּ� �־ IoC�����̳ʰ� ���Խ�����.
		System.out.println("list2()");
		
		PageMaker pageMaker = new PageMaker(); //bean�� �̿��ؼ� ��ü ���� ����
		pageMaker.setCri(criteria);
		
		System.out.println(criteria.getPerPageNum());
		System.out.println(criteria.getPage());
		
		//��ü �Խñ� ī�������ִ� �Լ� �ҷ���
		int totalCount = boardService.selectCountBoard();
		System.out.println("��ü �Խù� ���� ����: " + totalCount);
		
		//��ü�� ����
		pageMaker.setTotalCount(totalCount);
		
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria); //Criteria�� ��� �Ѿ�ñ�? PageMaker���� Criteria�� ���õǼ� �Ѿ��. IoC �����̳ʰ� ����Ʈ �����ڸ� ���� �˾Ƽ� ��ü �����ؼ� ������ ��. �׷��� ó������ 1�ϰ� 10�̴�.
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageMaker", pageMaker);
		
		return "list2";
	}
	
}
