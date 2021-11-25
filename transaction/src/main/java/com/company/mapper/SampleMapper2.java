package com.company.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper2 {
	@Insert("insert into tbl_sample2(col1) values(#{data})") 
	public int insertCol1(String data);

}
