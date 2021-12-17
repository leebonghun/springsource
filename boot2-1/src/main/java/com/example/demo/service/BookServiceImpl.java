package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BookDTO;
import com.example.demo.mapper.BookMapper;

@Service
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
		return mapper.insert(bookDto)>0?true:false;
	}


	@Override
	public BookDTO read(String code) {
		// TODO Auto-generated method stub
		return mapper.getRow(code);
	}


	@Override
	public boolean deleteBook(String code) {
		// TODO Auto-generated method stub
		return mapper.delete(code)>0?true:false;
	}


	@Override
	public boolean updateBook(BookDTO bookDto) {
		// TODO Auto-generated method stub
		return mapper.update(bookDto)>0?true:false;
	}

}
