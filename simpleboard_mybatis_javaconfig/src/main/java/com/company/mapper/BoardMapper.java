package com.company.mapper;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardMapper {
	public int insertBoard(BoardDTO insertDto);
	
	public int deleteBoard(int bno);
	
	public BoardDTO getRow(int bno);
	
	public List<BoardDTO> getRows();
	
	public int updateBoard(BoardDTO updateDto);
}
