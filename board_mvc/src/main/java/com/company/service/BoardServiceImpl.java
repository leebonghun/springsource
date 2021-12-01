package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.mapper.BoardMapper;
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(dto)>0?true:false;
	}

	@Override
	public List<BoardDTO> list(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.list(cri);
	}

	@Override
	public BoardDTO read(String bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
		
	}

	@Override
	public boolean modify(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.modify(dto)>0?true:false;
	}

	@Override
	public boolean remove(String bno) {
		// TODO Auto-generated method stub
		return mapper.remove(bno)>0?true:false;
	}

	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return mapper.totalCnt();
	}

	

}
