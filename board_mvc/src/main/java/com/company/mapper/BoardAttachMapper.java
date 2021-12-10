package com.company.mapper;

import java.util.List;

import com.company.domain.AttachFileDTO;

public interface BoardAttachMapper {
	public int insert(AttachFileDTO attachFileDTO);
	
	public List<AttachFileDTO> read(int bno);
	
	public int deleteAll(int bno);
	
	public List<AttachFileDTO> getOldFiles();
}
