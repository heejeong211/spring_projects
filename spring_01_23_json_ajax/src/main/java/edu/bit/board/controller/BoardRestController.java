package edu.bit.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

//@Controller + @ResponseBody -> 옛날버전 Json
//@RestController -> 요즘버전
@RestController
@RequestMapping("/rest/*")
public class BoardRestController {

	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public List<BoardVO> list(Model model) { //리턴타입을 객체로 넣어줌
		System.out.println("list()");
		
		//model.addAttribute("list", boardService.selectBoardList());
		
		return boardService.selectBoardList();
	}
	
}
