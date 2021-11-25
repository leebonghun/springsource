package com.company.factorial;

import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalulator implements Calculator {

	@Override
	public long factorial(long num) {
		long result = 1;
		for(int i=1;i<=num;i++) {
			
			result *=i;
			
		}
		return result;
	}

}
