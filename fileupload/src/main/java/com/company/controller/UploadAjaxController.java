package com.company.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

@Log4j2
@RestController
public class UploadAjaxController {
	
	@PostMapping("/uploadAjax")
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile){
		//서버 폴더에 첨부 파일 저장 
		String uploadFolder ="c:\\upload";
		String uploadFileName = "";
		//첨부파일 목록 리스트
		List<AttachFileDTO> attachList = new ArrayList<AttachFileDTO>();
		
		
		
		
		
		String uploadFolderPath = getFolder();
		// "c:\\upload\\2021\\12\\08"
		File uploadPath = new File(uploadFolder,uploadFolderPath);
		
		
		//디렉토리 생성
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		
		
		
		//upload 폴더 결정
		for(MultipartFile f: uploadFile) {
			log.info("ajax upload : "+f.getOriginalFilename());
			
			//UUID 값을 파일에 추가
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
			
			
			File savefile = new File(uploadPath,uploadFileName);
			
			AttachFileDTO attachFileDTO = new AttachFileDTO();
			attachFileDTO.setUuid(uuid.toString());
			attachFileDTO.setUploadPath(uploadFolderPath);
			attachFileDTO.setFileName(f.getOriginalFilename());
			
			//이미지 파일 여부 확인
			if(checkImageType(savefile)) {
				attachFileDTO.setFileType(true);
				
				
				try {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					InputStream in = f.getInputStream();
					Thumbnailator.createThumbnail(in,thumbnail,100,100);
					in.close();
					thumbnail.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			attachList.add(attachFileDTO);
			
			try {
				f.transferTo(savefile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return new ResponseEntity<List<AttachFileDTO>>(attachList,HttpStatus.OK);
		
	}
	//이미지 파일 여부 확인 메소드
	private boolean checkImageType(File file) {
		String contentType;
		
		try {
			contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//폴더 명을 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		String str = sdf.format(date);// "2021-12-08"
		
		// windows : \, unix : /
		return str.replace("-", File.separator); //2021/12/08
	}
	
	
	
	
	
	
	
}
