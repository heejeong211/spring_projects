package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.dao.BoardDAO;
import edu.bit.board.vo.BoardVO;

@Service("boardService") //���񽺰����̶�� �˷��ִ� ������̼�
public class BoardServiceImpl implements BoardService { //BoardService�� �ִ� �͵��� ���⼭ �� ����
	
	@Autowired //��ü�� �ڵ����� ���Խ�Ű�� ��.
	BoardDAO boardDAO;// = new BoardDAO(); //�������� new�ؼ� ��ü �� �ȸ���.
	
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
