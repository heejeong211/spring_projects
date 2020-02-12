package edu.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.bit.board.vo.BoardVO;

@Repository("boardDAO") //boardDAO 안붙여줘도 됨. boardDAO가 변수명임. 없으면 자기(스프링)가 알아서 클래스이름 보고 적음.
public class BoardDAO {
	
	DataSource dataSource;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> dtos = new ArrayList<BoardVO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				BoardVO dto = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public int write(String bName, String bTitle, String bContent) {
		
		Connection con = null;
		PreparedStatement prsmt = null;
		int rn = 0;
		
		try {
			
			con = dataSource.getConnection();
			
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			
			prsmt = con.prepareStatement(query);
			
			prsmt.setString(1, bName);
			prsmt.setString(2, bTitle);
			prsmt.setString(3, bContent);
			
			rn = prsmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(prsmt != null) {
					prsmt.close();
				} else if(con != null) {
					con.close();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return rn;
	}
	
	public BoardVO content(String strId) {
		
		BoardVO vo = null;
		
		Connection con = null;
		PreparedStatement prsmt = null;
		ResultSet res = null;
		
		try {
			
			con = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId = ?";
			
			prsmt = con.prepareStatement(query);
			
			prsmt.setInt(1, Integer.parseInt(strId));
			
			res = prsmt.executeQuery();
			
			while(res.next()) {
				int bId = res.getInt("bId");
				String bName = res.getString("bName");
				String bTitle = res.getString("bTitle");
				String bContent = res.getString("bContent");
				
				Timestamp bDate = res.getTimestamp("bDate");
				
				int bHit = res.getInt("bHit");
				int bGroup = res.getInt("bGroup");
				int bStep = res.getInt("bStep");
				int bIndent = res.getInt("bIndent");
				
				vo = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(res != null) {
					res.close();
				} else if(prsmt != null) {
					prsmt.close();
				} else if(con != null) {
					con.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return vo;
	}
}
