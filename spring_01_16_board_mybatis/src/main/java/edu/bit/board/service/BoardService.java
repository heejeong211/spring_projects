package edu.bit.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.board.vo.BoardVO;

//@Param�� �� �ִ� ����
//mybatis���� ������ �ҷ��� �� ������� �ҷ����� ����. �׷��� @Param �� ����� �Ǵ� ����.

public interface BoardService {
	
	public List<BoardVO> selectBoardList();
	
//	public void insertBoard(@Param("boardVO") BoardVO boardVO);
	public void insertBoard(@Param ("bName") String bName, @Param ("bTitle") String bTitle,@Param ("bContent") String bContent);
	
//	@Select("select * from mvc_board where bId = #{bId}") // �ϳ��ۿ� �ȸ��� ��
//	public BoardVO contentBoard(int bId);
	public BoardVO contentBoard(@Param ("bId") String getbId);

	public void modifyBoard(@Param ("bName") String getbName, @Param ("bTitle") String getbTitle, @Param ("bContent") String getbContent, @Param ("bId") String getbId);
	
	@Delete("delete from mvc_board where bId = #{bId}")
	public void deleteBoard(String bId);

	@Select("select * from mvc_board where bId = #{bId}")
	public BoardVO reply_viewBoard(String bId);

	public void replyBoard(@Param("boardVO") BoardVO boardVO);

	public void replyShapeBoard(@Param ("bGroup") String getbGroup, @Param ("bStep")String getbStep);

	
}
