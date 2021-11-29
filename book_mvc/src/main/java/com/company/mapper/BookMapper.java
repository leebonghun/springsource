package com.company.mapper;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookMapper {
	public List<BookDTO> list();
	
	public int insertBook(BookDTO bookDto);
	
	public BookDTO read(String code);
}
