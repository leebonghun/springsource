package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BookDTO;

public interface BookMapper {
	public BookDTO read(String code);
	
	public List<BookDTO> list();
	
	public int insertBook(BookDTO dto);
	
	public int updateBook(@Param("code") String code,@Param("price") int price);
	
	public int deleteBook(String code);
	
	//public List<BookDTO> getSelect(String criteria, String keyword);
}
