package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.ReplyDTO;
import com.company.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;

	@Override
	public boolean insertReply(ReplyDTO insertDto) {
		// TODO Auto-generated method stub
		return mapper.insertReply(insertDto)>0?true:false;
	}

	@Override
	public ReplyDTO getRow(int rno) {
		// TODO Auto-generated method stub
		return mapper.get(rno);
	}

	@Override
	public boolean updateReply(ReplyDTO updateDto) {
		// TODO Auto-generated method stub
		return mapper.updateReply(updateDto)>0?true:false;
	}

	@Override
	public boolean deleteReply(int rno) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(rno)>0?true:false;
	}

	@Override
	public List<ReplyDTO> list(int bno) {
		// TODO Auto-generated method stub
		return mapper.list(bno);
	}

	
}
