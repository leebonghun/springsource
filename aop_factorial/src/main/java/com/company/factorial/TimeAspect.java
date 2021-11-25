package com.company.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TimeAspect {
	@Around(value="execution(* com.company.factorial..*(..))")
	public Object measure(ProceedingJoinPoint pjp) throws Throwable {
		
		//시작시간
		
		long start = System.nanoTime(); //currentTimemiles 도있음
		
		//실제 수행 메소드 호출
		try {
			Object obj=pjp.proceed();
			return obj;
		} finally {
			//종료 시간
			long end = System.nanoTime();
			System.out.println("걸린 시간 : "+(end-start));
		}
		
	}
}
