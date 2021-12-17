package com.example.demo.domain;

import org.apache.ibatis.annotations.Mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Mapper
public class BookDTO {
	private String code;
	private String title;
	private String writer;
	private String price;
}
