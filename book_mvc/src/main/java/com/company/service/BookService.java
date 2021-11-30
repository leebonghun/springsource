package com.company.service;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookService {
	public List<BookDTO> list();
	
	public boolean insertBook(BookDTO bookDto);
	
	public BookDTO read(String code);
	
	public boolean deleteBook(String code);
	public boolean updateBook(BookDTO bookDto);
}
