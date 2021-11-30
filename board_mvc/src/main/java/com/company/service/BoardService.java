package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardService {
	public boolean insertBoard(BoardDTO dto);
	
	public List<BoardDTO> list();
	
	public BoardDTO read(String bno);
	
	
	public boolean modify(BoardDTO dto);
	
	public boolean remove(String bno);
}
