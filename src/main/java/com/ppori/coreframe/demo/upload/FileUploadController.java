package com.ppori.coreframe.demo.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class FileUploadController {
/**
 * <dependency>
	<groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.3.1</version>
</dependency>


@Bean
public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setDefaultEncoding("UTF-8"); // 파일 인코딩 설정
    multipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 파일당 업로드 크기 제한 (5MB)
    return multipartResolver;
}

spring:
  servlet:
    multipart:
      max-file-size: 1MB
      max-request-size: 10MB
file:
  dir: c:/tmp-download/      

 */
    private final FileUploadService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("files") List<MultipartFile> files) throws IOException {
    	log.info("################## Post /upload");
        fileService.saveFile(file);

        for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile);
        }

        return "redirect:/upload.html";
    }
    
    
    
    @GetMapping("/download")
	public ResponseEntity<Object> download() {
		String path = "c:/tmp/cap.png";
		
		try {
			Path filePath = Paths.get(path);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
			
			File file = new File(path);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
			
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
    
    
    @GetMapping("/display")
    public ResponseEntity<Resource> display() {
    	String path = "C:\\tmp\\";
    	String folder = "";
    	String filename = "cap.png";
    	Resource resource = new FileSystemResource(path + folder + filename);
    	if(!resource.exists()) 
    		return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
    	HttpHeaders header = new HttpHeaders();
    	Path filePath = null;
    	try{
    		filePath = Paths.get(path + folder + filename);
    		header.add("Content-type", Files.probeContentType(filePath));
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }
    
    
}