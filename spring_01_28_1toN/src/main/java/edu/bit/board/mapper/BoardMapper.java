package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> selectBoardList();
	
	public void insertBoard(@Param("bName") String bName, 
	      @Param("bTitle") String bTitle, @Param("bContent") String bContent);
	
	public void insertVOBoard(@Param("boardVO") BoardVO boardVO);
	
	@Select("select * from mvc_board where bId = #{bId}")	
	public BoardVO selectBoardOne(int bId);
	
	public void updateBoard(@Param("boardVO") BoardVO boardVO);
	
	public void updateShape(@Param("boardVO") BoardVO boardVO);
	public void insertReply(@Param("boardVO") BoardVO boardVO);
}
