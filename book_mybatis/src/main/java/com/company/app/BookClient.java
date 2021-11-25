package com.company.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.BookDTO;
import com.company.service.BookService;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class BookClient {
	private static BookDTO dto;
	private static BookService service;

	public static void main(String[] args) {
		log.info("main 시작");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// 서비스 호출
		service = (BookService) ctx.getBean("bookServiceImpl");
		// 도서 정보 삽입
//		BookDTO insertDto = new BookDTO("1008","이것이 JSP이다","봉춘봉",11900);
//		System.out.println(service.insertBook(insertDto)?"입력 성공":"입력 실패");
//		
		// 도서 정보 수정
//		System.out.println(service.updateBook("1008", 16000));

		// 도서 정보 삭제
//		System.out.println(service.deleteBook("1003"));

		// 도서 정보 검색
//		List<BookDTO> list1 = service.getSelect("1003", "이봉훈");
//		System.out.println(list1);

		menu();
	}

	public static void menu() {
		String code;
		String title;
		String writer;
		int price;
		boolean flag = true;
		while (flag) {
			System.out.println("================================================");
			System.out.println("1. 도서 정보 조회");
			System.out.println("2. 도서 정보 추가");
			System.out.println("3. 도서 정보 삭제");
			System.out.println("4. 도서 목록 전체 조회");
			System.out.println("5. 도서 정보 수정");
			System.out.println("6. 종료");
			System.out.println("================================================");

			Scanner sc = new Scanner(System.in);
			System.out.print("메뉴 선택 >> ");
			int no = Integer.parseInt(sc.nextLine());

			switch (no) {
			case 1:
				System.out.println("조회할 도서 코드 입력");
				code = sc.next();
				dto = service.read(code);
				System.out.println("코드\t  제목\t\t작가\t  가격");
				System.out.print(dto.getCode() + "\t");
				System.out.print(dto.getTitle() + "\t");
				System.out.print(dto.getWriter() + "\t");
				System.out.println(dto.getPrice());
				break;
			case 2:
				System.out.print("코드를 입력해주세요 : \n");
				code=sc.nextLine();
				System.out.print("제목을 입력해주세요 : \n");
				title = sc.nextLine();
				System.out.print("작가를 입력해주세요 : \n");
				writer = sc.nextLine();
				System.out.print("가격을 입력해주세요 : \n");
				price = Integer.parseInt(sc.next());
				
				dto = new BookDTO(code,title,writer,price);
				System.out.println(service.insertBook(dto) ? "입력 성공" : "입력 실패");
				break;

			case 3:
				System.out.println("삭제할 코드 입력");
				code = sc.nextLine();
				System.out.println(service.deleteBook(code)?"삭제 성공":"삭제 실패");
				break;
			case 4:
				List<BookDTO> list = service.list();

				for (BookDTO dto : list) {
					System.out.println(dto);
				}
				break;
				
			case 5:
				System.out.println("수정할 코드 입력");
				String code1 = sc.next();
				System.out.println("수정할 가격 입력");
				int price1 = sc.nextInt();
				System.out.println(service.updateBook(code1, price1));
				break;

			case 6:
				flag = false;
				break;
			}

		}

	}

}
