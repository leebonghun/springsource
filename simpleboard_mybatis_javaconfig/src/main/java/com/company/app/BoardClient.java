package com.company.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.config.BoardConfig;
import com.company.domain.BoardDTO;
import com.company.service.BoardService;

public class BoardClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BoardConfig.class);
		BoardService service = (BoardService)ctx.getBean("boardService");
		
		// * 정보 삽입
//		BoardDTO insertDto = new BoardDTO();
//		insertDto.setTitle("스프링 프레임워크");
//		insertDto.setContent("스프링 프레임워크 게시판");
//		insertDto.setWriter("이봉훔");
//
//		System.out.println(service.insertBoard(insertDto)?"입력성공":"입력실패");
		

		
		//*특정 정보 조회
		BoardDTO rowDto =service.getRow(1824122);
		System.out.print(rowDto.getBno()+"\t");
		System.out.print(rowDto.getTitle()+"\t");
		System.out.print(rowDto.getContent()+"\t");
		System.out.print(rowDto.getWriter()+"\t");
		System.out.print(rowDto.getRegdate()+"\t");
		System.out.print(rowDto.getUpdatedate()+"\n");
		
		//*특정 정보 수정
//		BoardDTO updateDto = new BoardDTO();
//		updateDto.setTitle("JSP");
//		updateDto.setContent("이것이 JSP다");
//		updateDto.setBno(1);
//		System.out.println(service.updateBoard(updateDto)?"수정성공":"수정실패");
		
		
		//*특정 번호 삭제
		//System.out.println(service.deleteBoard(1823620)?"삭제성공":"삭제실패");
		
		//*전체 정보조회
//		List<BoardDTO> list = service.getRows();
//		System.out.println("번호\t  제목\t\t\t내용\t\t작성자\t  작성날짜\t\t 수정날짜");
//		System.out.println("===================================================================================");
//		for(BoardDTO board : list) {
//			System.out.print(board.getBno()+"\t");
//			System.out.print(board.getTitle()+"\t");
//			System.out.print(board.getContent()+"\t");
//			System.out.print(board.getWriter()+"\t");
//			System.out.print(board.getRegdate()+"\t");
//			System.out.print(board.getUpdatedate()+"\n");
//		}
	}

}
