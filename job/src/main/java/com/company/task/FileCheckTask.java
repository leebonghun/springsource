package com.company.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileCheckTask {
	/*
	 * <ul>
	 * <li>second</li>
	 * <li>minute</li>
	 * <li>hour</li>
	 * <li>day of month</li>
	 * <li>month</li>
	 * <li>day of week</li>
	 * </ul>
	 * 
	 * */
	
	// @Scheduled : 메소드는 리턴타입은 void, 파라미터는 가지 않아야함.
	
	@Scheduled(cron="0 * * * * *")
	public void schedulerTest() {
		System.out.println("매 분 1초마다 스케쥴링");
		
	}
	//fixedDelay : 이전에 실행된 task의 종료 시간으로부터 정의된 시간만큼 지난 후 실행 (밀리 세컨드 단위)
	//fixedRate : 이전에 실행된 task의 시작 시간으로부터 정의된 시간만큼 지난 후 실행 (밀리 세컨드 단위)
	@Scheduled(fixedDelay = 10000)
	public void schedulerTest2() {
		System.out.println("10초마다 스케쥴링");
		
	}
	
}
