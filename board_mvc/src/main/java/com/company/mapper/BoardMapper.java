package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BoardDTO;
import com.company.domain.Criteria;

public interface BoardMapper {
	public int insertBoard(BoardDTO dto);
	
	public List<BoardDTO> list(Criteria cri);
	
	public BoardDTO read(String bno);
	
	public int modify(BoardDTO dto);
	
	public int remove(int bno);
	
	public int totalCnt(Criteria cri);
	
	public int updateReplyCnt(@Param("bno")int bno,@Param("amount")int amount);
	
}
