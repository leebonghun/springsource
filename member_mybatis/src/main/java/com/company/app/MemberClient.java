package com.company.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.ChangeDTO;
import com.company.domain.MemberDTO;
import com.company.service.MemberService;

public class MemberClient {

	public static void main(String[] args) {

		// 스프링 컨테이너 로드
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		// 서비스 메소드 호출
		MemberService service = (MemberService) ctx.getBean("memberservice");

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {

			System.out.println("====================================================");
			System.out.println("1. 전체 멤버 조회");
			System.out.println("2. 특정 멤버 조회");
			System.out.println("3. 특정 멤버 수정");
			System.out.println("4. 특정 멤버 삭제");
			System.out.println("5. 특정 멤버 추가");
			System.out.println("6. 종료");
			System.out.println("=============================================================");
			System.out.print("메뉴 선택 >>");
			int no = Integer.parseInt(sc.nextLine());

			switch (no) {
			case 1:
				List<MemberDTO> list = service.list();
				System.out.println("=============================================================");
				System.out.println("아이디\t\t이름\t\t성별\t\t이메일");
				for (MemberDTO dto : list) {
					System.out.print(dto.getUserid() + "\t");
					System.out.print(dto.getName() + "\t\t");
					System.out.print(dto.getGender() + "\t\t");
					System.out.println(dto.getEmail());
				}

				break;
			case 2:
				System.out.print("아이디를 입력해주세요 \n");
				String userid = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요 \n");
				String password = sc.nextLine();
				MemberDTO list1 = service.read(userid, password);

				System.out.print(list1.getUserid() + "\t");
				System.out.print(list1.getGender() + "\t");
				System.out.println(list1.getEmail());
				break;
			case 3:
				ChangeDTO changeDto = new ChangeDTO();
				System.out.println("아이디를 입력해주세요");
				changeDto.setUserid(sc.nextLine());
				System.out.println("비밀번호를 입력해주세요");
				changeDto.setPassword(sc.nextLine());

				System.out.println("바꾸실 비밀번호를 입력해주세요");
				changeDto.setConfirm_password(sc.nextLine());

				System.out.println(service.updateMember(changeDto) ? "수정성공" : "수정실패");

				break;
			case 4:
				System.out.print("삭제하실 아이디를 입력해주세요 \n");
				String userid2 = sc.nextLine();

				System.out.println(service.deleteMember(userid2) ? "삭제성공" : "삭제실패");
				break;
			case 5:
				MemberDTO dto3 = new MemberDTO();
				System.out.print("새로운 아이디를 입력하세요");
				dto3.setUserid(sc.nextLine());
				System.out.print("새로운 비밀번호를 입력하세요");
				dto3.setPassword(sc.nextLine());
				System.out.print("이름을 입력하세요");
				dto3.setName(sc.nextLine());
				System.out.print("성별을 입력하세요");
				dto3.setGender(sc.nextLine());
				System.out.print("이메일을 입력해주세요");
				dto3.setEmail(sc.nextLine());

				System.out.println(service.insertMember(dto3) ? "가입성공" : "가입실패");

				break;

			case 6:
				flag = false;
				System.out.println("프로그램을 종료합니다");
				break;
			}

		}

	}

}
