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
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper BoardAttachMapper;
	
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
			BoardAttachMapper.insert(attach);
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
	public int totalCnt(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.totalCnt(cri);
	}

	@Override
	public List<AttachFileDTO> findByBno(int bno) {
		// TODO Auto-generated method stub
		return BoardAttachMapper.read(bno);
	}

	

	

}
