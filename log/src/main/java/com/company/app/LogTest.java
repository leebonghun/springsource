package com.company.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class LogTest {
	
	//로그를 기록할 대상 클래스를 지정하는 구문
	//static final Logger logger = LogManager.getLogger(LogTest.class);
	public static void main(String[] args) {
//		logger.error("error 레벨");
//		logger.warn("warn 레벨");
//		logger.info("info 레벨");
//		logger.debug("debug 레벨");
//		logger.trace("trace 레벨");
		
		log.error("error 레벨");
		log.warn("warn 레벨");
		log.info("info 레벨");
		log.debug("debug 레벨");
		log.trace("trace 레벨");
	}

}
