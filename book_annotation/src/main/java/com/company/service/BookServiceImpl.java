package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BookDTO;
import com.company.persistence.BookDAO;
//BookServiceImpl 객체 생성 단, id명은 bookServiceImpl(클래스명에서 앞에 소문자로)
@Service // == 서비스 역할을 하는 @Component
public class BookServiceImpl implements BookService { //데이터베이스 요청 담당
	
	@Autowired //객체를 하나만 주입할때, @Qualifier는 여러개 객체 주입
	private BookDAO dao;
	
	@Override
	public List<BookDTO> getList() {
		return dao.select();
	}

	@Override
	public boolean insertBook(BookDTO dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public boolean updateBook(String code,int price) {
		// TODO Auto-generated method stub
		return dao.update(code,price);
	}

	@Override
	public boolean deleteBook(String code) {
		// TODO Auto-generated method stub
		return dao.delete(code);
	}

	@Override
	public List<BookDTO> getSelect(String criteria, String keyword) {
		// TODO Auto-generated method stub
		return dao.select();
	}
	
	

}
