package com.company.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.company.persistence.jdbcUtil.*;


import com.company.domain.BookDTO;

@Repository // == @Component 
public class BookDAO {
	
	
	
	@Autowired //객체 주입
	private DataSource ds;
	
	//insert
	public boolean insert(BookDTO insertDto) {
		String sql = "insert into bookTBL values(?,?,?,?)";
		PreparedStatement pstmt =null;
		boolean insertFlag = false;
		Connection con = null;
		try {
			con = ds.getConnection();
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				insertFlag = true;
			//	commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
		
		
	}
	
	//delete
	public boolean delete(String code) {
		String sql = "delete from bookTBL where code =?";
		PreparedStatement pstmt = null;
		boolean deleteFlag = false;
		Connection con = null;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				deleteFlag=true;
				//commit(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteFlag;
		
	}
	public boolean update(String code,int price) {
		String sql = "update bookTBL set price = ? where code =? ";
		PreparedStatement pstmt = null;
		boolean updateFlag=false;
		Connection con = null;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, code);
			int result = pstmt.executeUpdate();
			
			if(result>0) { 
				updateFlag = true;
				//commit(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag;
	}
	//update
	
	public List<BookDTO> select(){
		List<BookDTO> bookList = new ArrayList<BookDTO>(); 
		String sql = "select* from bookTBL";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			BookDTO dto = new BookDTO();
			dto.setCode(rs.getString("code"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			dto.setPrice(rs.getInt("price"));
			
			bookList.add(dto);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs);
			close(pstmt);
		}
		return bookList;
	}
	public List<BookDTO> search(String criteria,String keyword) {
		List<BookDTO> list = new ArrayList<BookDTO>();
		String sql = "select * from bookTBL where "+criteria+"=?";	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
}
