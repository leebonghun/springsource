package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.domain.AttachFileDTO;
import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.mapper.BoardAttachMapper;
import com.company.mapper.BoardMapper;
import com.company.mapper.ReplyMapper;
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper boardAttachMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Transactional
	@Override
	public boolean insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		//게시물 등록
		boolean result=mapper.insertBoard(dto)>0?true:false;
		//첨부파일 등록
		if(dto.getAttachList() == null || dto.getAttachList().size() <=0) {
			return false;
		}
		dto.getAttachList().forEach(attach -> {
			attach.setBno(dto.getBno());
			boardAttachMapper.insert(attach);
		});
		
		return result;
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
	@Transactional
	@Override
	public boolean modify(BoardDTO dto) {
		
		//기존 첨부파일 삭제
		boardAttachMapper.deleteAll(dto.getBno());
		//게시물 수정
		boolean modifyResult = mapper.modify(dto)==1;
		
		if(dto.getAttachList()==null || dto.getAttachList().size()<=0) {
			return false;
		}
		
		
		if(modifyResult && dto.getAttachList().size() > 0) {
			dto.getAttachList().forEach(attach ->{
				attach.setBno(dto.getBno());
				boardAttachMapper.insert(attach);
			});
		}
		
		
		// TODO Auto-generated method stub
		return modifyResult;
	}
	
	@Transactional
	@Override
	public boolean remove(int bno) {
		
		replyMapper.deleteAll(bno);
		//첨부물 삭제
		boardAttachMapper.deleteAll(bno);
		
		
		// TODO Auto-generated method stub
		return mapper.remove(bno)>0?true:false;
	}

	@Override
	public int totalCnt(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.totalCnt(cri);
	}

	@Override
	public List<AttachFileDTO> findByBno(int bno) {
		// TODO Auto-generated method stub
		return boardAttachMapper.read(bno);
	}

	@Override
	public boolean deleteAll(int bno) {
		// TODO Auto-generated method stub
		return boardAttachMapper.deleteAll(bno)==1;
	}

	

	

}
