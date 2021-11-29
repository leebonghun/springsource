package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BookDTO;
import com.company.mapper.BookMapper;

@Service("service")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;
	
	
	@Override
	public List<BookDTO> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}


	@Override
	public boolean insertBook(BookDTO bookDto) {
		// TODO Auto-generated method stub
		return mapper.insertBook(bookDto)>0?true:false;
	}


	@Override
	public BookDTO read(String code) {
		// TODO Auto-generated method stub
		return mapper.read(code);
	}

}
