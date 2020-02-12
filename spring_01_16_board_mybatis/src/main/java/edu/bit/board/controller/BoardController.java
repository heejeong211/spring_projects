package edu.bit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		List<BoardVO> list = boardService.selectBoardList();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) {
		System.out.println("write()");
		
	//	boardService.insertBoard(boardVO); //파라미터에 넘겨야 되는 게 엄청 많을 때
		boardService.insertBoard(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent()); //서비스에 파라미터 넘겨야함
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		System.out.println("content_view()");
		
		BoardVO content_view = boardService.contentBoard(Integer.toString(boardVO.getbId()));
		model.addAttribute("content_view", content_view);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO, Model model) {
		System.out.println("modify()");
		
		boardService.modifyBoard(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent(), Integer.toString(boardVO.getbId()));
		
		return "redirect:content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO, Model model) {
		System.out.println("delete()");
		
		boardService.deleteBoard(Integer.toString(boardVO.getbId()));
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		System.out.println("reply_view()");
		
		BoardVO reply_view = boardService.reply_viewBoard(Integer.toString(boardVO.getbId()));
		model.addAttribute("reply_view", reply_view);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) {
		System.out.println("reply()");
		
		boardService.replyBoard(boardVO);
		boardService.replyShapeBoard(Integer.toString(boardVO.getbGroup()), Integer.toString(boardVO.getbStep()));
		
		return "redirect:list";
	}
	
	
}
