package com.myapp.myapp;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	@Resource(name = "uploads")
	private String uploadPath;
	
	@GetMapping("uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploads) {
//		String uploadFolder = "C:\\Users\\admin\\Desktop\\창현\\FirstSpring\\ex02\\src\\main\\resources";
				
		for(MultipartFile multipartFile : uploads) {
			log.info("-------------------------------");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());
//			File saveFile = new File(uploadFoler, multipartFile.getOriginalFilename());
			// UUID : 파일 이름 중복을 피하게 하면서 이름을 바꿔주는 기능
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString()+"_"+multipartFile.getOriginalFilename();
			// File saveFile = new File(uploadFolder, uploadFileName);
			File saveFile = new File(uploadPath, uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
			}catch (Exception e) {
				log.error(e.getMessage());
			}
			
			
			
			
			
		}
		
		
				
				
	}
	
		

}
