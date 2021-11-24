package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardDTO;
import com.company.mapper.BoardMapper;
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;
	@Override
	public boolean insertBoard(BoardDTO insertDto) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(insertDto)>0?true:false;
	}

	@Override
	public boolean deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(bno)>0?true:false;
	}

	@Override
	public BoardDTO getRow(int bno) {
		// TODO Auto-generated method stub
		return mapper.getRow(bno);
	}

	@Override
	public List<BoardDTO> getRows() {
		// TODO Auto-generated method stub
		return mapper.getRows();
	}

	@Override
	public boolean updateBoard(BoardDTO updateDto) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(updateDto)>0?true:false;
	}

}
