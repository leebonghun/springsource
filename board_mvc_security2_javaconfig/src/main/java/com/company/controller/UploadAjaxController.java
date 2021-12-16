package com.company.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

@RestController
@Log4j2
public class UploadAjaxController {
   
	@PreAuthorize("isAuthenticated()")
   @PostMapping("/uploadAjax")
   public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile){
      // 서버 폴더에 첨부된 첨부 파일 저장
      String uploadFolder = "c:\\upload";
      String uploadFileName="";
      
      // 첨부파일 목록 리스트 생성
      List<AttachFileDTO> attachList = new ArrayList<AttachFileDTO>();
      
      //upload 폴더 결정
      String uploadFolderPath=getFolder();
      File uploadPath = new File(uploadFolder,uploadFolderPath);
      
      //디렉토리 생성
      if(!uploadPath.exists()) {
         uploadPath.mkdirs();
      }
      
      for(MultipartFile f:uploadFile) {
         log.info("ajax upload "+f.getOriginalFilename());
         
         // uuid 값 파일에 추가하기
         UUID uuid = UUID.randomUUID(); 
         uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
         
         File saveFile = new File(uploadPath,uploadFileName);
         
         AttachFileDTO attachFileDto = new AttachFileDTO();
         attachFileDto.setUuid(uuid.toString());
         attachFileDto.setUploadPath(uploadFolderPath);
         attachFileDto.setFileName(f.getOriginalFilename());
         
         //이미지 파일 여부 확인
         if(checkImageType(saveFile)) {
            attachFileDto.setFileType(true);
         
            //썸네일 저장
            try {
               FileOutputStream thumbnail= new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
               InputStream in = f.getInputStream();
               Thumbnailator.createThumbnail(in, thumbnail, 100, 100);
               in.close();
               thumbnail.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         
         attachList.add(attachFileDto);
                  
         try {
            f.transferTo(saveFile);
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
            
      return new ResponseEntity<List<AttachFileDTO>>(attachList,HttpStatus.OK);
   }
   
   //썸네일 이미지 가져오기
   @GetMapping("/display")
   public ResponseEntity<byte[]> getFile(String fileName) {
      log.info("썸네일 요청 "+fileName);
      
      File file = new File("c:\\upload\\",fileName);
      
      ResponseEntity<byte[]> result = null;
      
      HttpHeaders headers = new HttpHeaders();
      try {
         headers.add("Content-Type", Files.probeContentType(file.toPath()));
         result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return result;
   }
   
   
   //서버 폴더의 파일 삭제
   @PreAuthorize("isAuthenticated()")
   @PostMapping("/deleteFile")
   public ResponseEntity<String> deleteFile(String fileName,String type) {
	   //파일 이름과 타입이 도착
	   log.info("파일 삭제  fileName "+fileName+" type"+type);
	   //이미지 파일인 경우 - 원본 이미지와 썸네일 이미지를 삭제
	   try {
		File file = new File("c:\\upload\\"+URLDecoder.decode(fileName, "utf-8"));
		file.delete(); //썸네일 이미지, 일반파일 삭제
		
		
		
		
		if(type.equals("image")) {
			String largeName = file.getAbsolutePath().replace("s_", "");
			new File(largeName).delete();
		}
	   } catch (UnsupportedEncodingException e) {
		e.printStackTrace();
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	   return new ResponseEntity<String>("success",HttpStatus.OK);
	   
	   
	   //일반 파일인 경우 - 원본 파일만 삭제
   }
   
   @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName) {
		log.info("download File Name : " + fileName);

		// 서버 폴더에 접근해서 해당 파일 가져오기
		Resource resource = new FileSystemResource("C:\\upload\\" + fileName);
		String resourceUidName = resource.getFilename();
		
		
		//다운로드 할 때 UUID 값 제거하기
		String resourceName = resourceUidName.substring(resourceUidName.indexOf("_")+1); 

		// 헤더에 추가하기
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition",
					"attachment;fileName=" + new String(resourceName.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
   
   
   // 이미지 파일 여부 확인
   private boolean checkImageType(File file) {
      String contentType;
      try {
         contentType = Files.probeContentType(file.toPath());
         return contentType.startsWith("image");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return false;
   }
   
   //폴더명 생성
   private String getFolder() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
      Date date = new Date(); //Wed Dec 08 14:54:10 KST 2021로 가져옴 
      String str = sdf.format(date); //"2021-12-08" 
      
      return str.replace("-", File.separator); //2021/12/08
   }
   
}