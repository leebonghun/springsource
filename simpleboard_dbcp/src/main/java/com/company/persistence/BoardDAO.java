package com.company.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.company.persistence.jdbcUtil.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.company.domain.BoardDTO;

import oracle.jdbc.proxy.annotation.Pre;

@Repository
public class BoardDAO {
	
	@Autowired
	private DataSource ds;
	public boolean insert(BoardDTO insertDto) {
		boolean insertFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, insertDto.getBno()); 시퀀스로 받기 때문에
			pstmt.setString(1, insertDto.getTitle());
			pstmt.setString(2, insertDto.getContent());
			pstmt.setString(3, insertDto.getWriter());
			
			
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				insertFlag = true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(con);
		}
		
		
		return insertFlag;
	}
	public BoardDTO getRow(int bno) {
		BoardDTO dto = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String sql = "select * from spring_board where bno =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setContent(rs.getString("writer"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setUpdatedate(rs.getDate("updatedate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
		return dto;
	}
	public List<BoardDTO> getRows(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			String sql = "select * from spring_board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setUpdatedate(rs.getDate("updatedate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
		
				
		return list;
	}
	//게시물 업데이트
	public boolean updateBoard(BoardDTO updateDto) {
		
		boolean updateFlag = false;
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ds.getConnection();
			String sql = "update spring_board set title=?,content=?,updatedate=sysdate where bno =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, updateDto.getTitle());
			pstmt.setString(2, updateDto.getContent());
			pstmt.setInt(3, updateDto.getBno());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				updateFlag = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(con);
		}
		
		return updateFlag;
	}
	public boolean deleteBoard(int bno) {
		boolean deleteFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "delete from spring_board where bno = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				deleteFlag=true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(con);
		}
		
		
		return deleteFlag;
	}
}
