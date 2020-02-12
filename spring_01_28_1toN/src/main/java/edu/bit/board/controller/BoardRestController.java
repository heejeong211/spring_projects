package edu.bit.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@RestController
@RequestMapping("/rest/*")
public class BoardRestController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public  List<BoardVO> list(Model model){		
		System.out.println("list()");		
		//model.addAttribute("list", boardService.selectBoardList());
		return boardService.selectBoardList();
	}	

}
