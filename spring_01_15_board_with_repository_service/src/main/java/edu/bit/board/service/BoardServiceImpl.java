package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.dao.BoardDAO;
import edu.bit.board.vo.BoardVO;

@Service("boardService") //서비스계층이라고 알려주는 어노테이션
public class BoardServiceImpl implements BoardService { //BoardService에 있는 것들을 여기서 다 구현
	
	@Autowired //객체를 자동으로 주입시키는 것.
	BoardDAO boardDAO;// = new BoardDAO(); //스프링은 new해서 객체 잘 안만듦.
	
	@Override
	public List<BoardVO> getBoardList() {
		
		return boardDAO.getBoardList();
	}

	@Override
	public int boardWrite(String bName, String bTitle, String bContent) {
		
		return boardDAO.write(bName, bTitle, bContent);
	}

	@Override
	public BoardVO content(String strId) {
		
		return boardDAO.content(strId);
	}
	
	
}
