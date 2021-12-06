package com.company.service;

import java.util.List;

import com.company.domain.ReplyDTO;

public interface ReplyService {
	public boolean insertReply(ReplyDTO insertDto);
	
	public ReplyDTO getRow(int rno);
	
	public boolean updateReply(ReplyDTO updateDto);
	public boolean deleteReply(int rno);
	
	public List<ReplyDTO> list(int bno);
}
