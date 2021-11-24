package com.company.service;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookService {
	//전체 도서 목록 요청
	public BookDTO read(String code);
	
	public boolean insertBook(BookDTO dto);
	
	public boolean updateBook(String code,int price);
	
	public boolean deleteBook(String code);
	
	public List<BookDTO> list();
	//public List<BookDTO> getSelect(String criteria,String keyword);
}
