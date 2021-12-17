package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.BookDTO;

public interface BookMapper {
	public List<BookDTO> list();
	
	public int insert(BookDTO bookDto);
	
	public BookDTO getRow(String code);
	
	public int delete(String code);
	
	public int update(BookDTO bookDto);
}
