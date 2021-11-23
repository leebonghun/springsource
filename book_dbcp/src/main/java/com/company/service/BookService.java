package com.company.service;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookService {
	//전체 도서 목록 요청
	public List<BookDTO> getList();
	
	public boolean insertBook(BookDTO dto);
	
	public boolean updateBook(String code,int price);
	
	public boolean deleteBook(String code);
	
	public List<BookDTO> getSelect(String criteria,String keyword);
}
