package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model,HttpSession session) {
		System.out.println("list()");
		
		/*
		 * UserVO member = (UserVO) session.getAttribute("member");
		 * 
		 * //첫번째 방법 if(member == null) { System.out.println("멤버세션값 없음"); return
		 * "redirect:/"; }
		 */
		
		List<BoardVO> list = boardService.selectBoardList();
		
		model.addAttribute("list",list);
		
		return "list";
	}

	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");

		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception {
		System.out.println("write()");


		boardService.insertVOBoard(boardVO);		
		//boardService.insertBoard(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent());
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) throws Exception{
		System.out.println("content_view()");

		String bId = request.getParameter("bId");		
		model.addAttribute("content_view", boardService.selectBoardOne(Integer.parseInt(bId)));
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST )
	public String modify(BoardVO boardVO, Model model){
		System.out.println("modify()");
		
		boardService.updateBoard(boardVO); 
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		String bId = request.getParameter("bId");		
		model.addAttribute("reply_view", boardService.selectBoardOne(Integer.parseInt(bId)));
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) {
		System.out.println("reply()");
		
		boardService.updateShape(boardVO); 
		boardService.insertReply(boardVO);	
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO, Model model) {
		System.out.println("delete()");
		

		
		return "redirect:list";
	}

}
