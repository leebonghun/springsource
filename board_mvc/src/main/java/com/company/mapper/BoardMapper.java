package com.company.mapper;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardMapper {
	public int insertBoard(BoardDTO dto);
	
	public List<BoardDTO> list();
	
	public BoardDTO read(String bno);
	
	public int modify(BoardDTO dto);
	
	public int remove(String bno);
	
}
