package com.company.mapper;

import java.util.List;

import com.company.domain.ReplyDTO;

public interface ReplyMapper {
	public int insertReply(ReplyDTO insertDto);

	
	public ReplyDTO get(int rno);
	public int updateReply(ReplyDTO updateDto);
	public int deleteReply(int rno);
	public List<ReplyDTO> list(int bno);
}
