package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardDTO;
import com.company.persistence.BoardDAO;
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;
	@Override
	public boolean insertBoard(BoardDTO insertDto) {
		// TODO Auto-generated method stub
		return dao.insert(insertDto);
	}

	@Override
	public boolean deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(bno);
	}

	@Override
	public BoardDTO getRow(int bno) {
		// TODO Auto-generated method stub
		return dao.getRow(bno);
	}

	@Override
	public List<BoardDTO> getRows() {
		// TODO Auto-generated method stub
		return dao.getRows();
	}

	@Override
	public boolean updateBoard(BoardDTO updateDto) {
		// TODO Auto-generated method stub
		return dao.updateBoard(updateDto);
	}

}
