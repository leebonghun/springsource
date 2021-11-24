package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.company.domain.PersonDTO;

public interface PersonMapper {
	//입력
//	@Insert("insert into person(id,name) values(#{id},#{name})")	
//	public int insertPerson(@Param("id") String id,@Param("name") String name);
//	
//	@Select("select name from person where id = #{id}")
//	public String selectPerson(String id);
//	
//	@Update("update person set name=#{name} where id =#{id}")
//	public int updatePerson(@Param("id") String id,@Param("name") String name);
//	
//	@Delete("delete from person where id =#{id}")
//	public int deletePerson(String id);

	
	
	//인터페이스 + XML 조합	: 메소드명과 xml 아이디이름이 일치 해야함(대소문자 포함) ★★★
	public int insertPerson(@Param("id") String id,@Param("name") String name);
	
	public String selectPerson(String id);
	
	public int updatePerson(@Param("id") String id,@Param("name") String name);
	
	public int deletePerson(String id);
	
	public List<PersonDTO> all();

	
	
	
	
	
	
}
