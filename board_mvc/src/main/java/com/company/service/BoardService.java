package com.company.service;

import java.util.List;

import com.company.domain.AttachFileDTO;
import com.company.domain.BoardDTO;
import com.company.domain.Criteria;

public interface BoardService {
	public boolean insertBoard(BoardDTO dto);
	
	public List<BoardDTO> list(Criteria cri);
	
	public BoardDTO read(String bno);
	
	
	public boolean modify(BoardDTO dto);
	
	public boolean remove(int bno);
	
	public int totalCnt(Criteria cri);
	
	//첨부파일 관련
	public List<AttachFileDTO> findByBno(int bno);
	public boolean deleteAll(int bno);
	
	//댓글

	
	
}
