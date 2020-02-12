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
	
	@Autowired //�ڵ����� ��ü �������ִ� ������̼�
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
	public String write(BoardVO boardVO) { //form�±� �ȿ� �ִ� ���� BoardVO�� ȣ���ϸ� BoardVO�� �ش��ϴ� �������� set�Լ��� ȣ���Ѵ�.
		System.out.println("write_view()");
		
		int rn = boardService.boardWrite(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent());
		System.out.println("����� : " + rn);
		
		return "redirect:list"; //@RequestMapping("/list") �̰� �ٽ� Ÿ����. �׷��� redirect��.
	}
	
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		System.out.println("content_view()");
		
		BoardVO vo = boardService.content(Integer.toString(boardVO.getbId()));
		model.addAttribute("content_view", vo);
		
		return "content_view";
	}
}
