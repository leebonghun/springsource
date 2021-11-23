package com.company.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.domain.BookDTO;

public class BookRowMapper implements RowMapper<BookDTO> {

	@Override
	public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		BookDTO dto = new BookDTO();
		dto.setCode(rs.getString("code"));
		dto.setTitle(rs.getString("title"));
		dto.setWriter(rs.getString("writer"));
		dto.setPrice(rs.getInt("price"));
		return dto;
	}

}
