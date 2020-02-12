package edu.bit.board.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired //자동으로 객체 생성해주는 어노테이션
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) { //form태그 안에 있는 것이 BoardVO를 호출하면 BoardVO는 해당하는 데이터의 set함수를 호출한다.
		System.out.println("write_view()");
		
		int rn = boardService.boardWrite(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent());
		System.out.println("결과값 : " + rn);
		
		return "redirect:list"; //@RequestMapping("/list") 이걸 다시 타야함. 그래서 redirect임.
	}
	
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		System.out.println("content_view()");
		
		BoardVO vo = boardService.content(Integer.toString(boardVO.getbId()));
		model.addAttribute("content_view", vo);
		
		return "content_view";
	}
}
