package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardService {
	//등록
	public boolean insertBoard(BoardDTO insertDto);
	//삭제
	public boolean deleteBoard(int bno);
	//개별조회
	public BoardDTO getRow(int bno);
	//전체조회
	public List<BoardDTO> getRows();
	//수정
	public boolean updateBoard(BoardDTO updateDto);
}
