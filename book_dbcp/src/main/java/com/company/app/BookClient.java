package com.company.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.BookDTO;
import com.company.service.BookService;

public class BookClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		//서비스 호출 
		BookService service = (BookService)ctx.getBean("bookServiceImpl");
		//도서 정보 삽입
//		BookDTO insertDto = new BookDTO("1008","이것이 JSP이다","봉춘봉",11900);
//		System.out.println(service.insertBook(insertDto)?"입력 성공":"입력 실패");
//		
		//도서 정보 수정
//		System.out.println(service.updateBook("1008", 16000));
		
		//도서 정보 삭제
//		System.out.println(service.deleteBook("1003"));
		
		//도서 정보 검색
//		List<BookDTO> list1 = service.getSelect("1003", "이봉훈");
//		System.out.println(list1);
		
		//전체 도서 정보 표시
		List<BookDTO> list = service.getList();
		System.out.println("코드         제목          작가      가격");
		System.out.println("==========================================");
		for(BookDTO book:list) {
			System.out.print(book.getCode()+"\t");
			System.out.print(book.getTitle()+"\t");
			System.out.print(book.getWriter()+"\t");
			System.out.print(book.getPrice()+"\n");
		}
	}

}
