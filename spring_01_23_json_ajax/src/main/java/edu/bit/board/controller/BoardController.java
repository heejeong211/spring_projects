package edu.bit.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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

	@Inject
	BoardService boardService;
	
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
