package com.company.mapper;

import java.util.List;

import com.company.domain.BoardDTO;
import com.company.domain.Criteria;

public interface BoardMapper {
	public int insertBoard(BoardDTO dto);
	
	public List<BoardDTO> list(Criteria cri);
	
	public BoardDTO read(String bno);
	
	public int modify(BoardDTO dto);
	
	public int remove(String bno);
	
	public int totalCnt(Criteria cri);
	
}
