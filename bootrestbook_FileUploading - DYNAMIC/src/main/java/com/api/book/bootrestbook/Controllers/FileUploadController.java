package com.api.book.bootrestbook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.api.book.bootrestbook.Helper.FileUploaderHelper;

@RestController
public class FileUploadController {
	
	  	@Autowired
	    private FileUploaderHelper fileuploadhelper;

	    @PostMapping("/upload-file")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	        // System.out.println(file.getOriginalFilename());
	        // System.out.println(file.getSize());
	        // System.out.println(file.getContentType());
	        // System.out.println(file.getName());
	        try {
	            if (file.isEmpty()) {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Request must contain a file");

	            }
//	            if (!file.getContentType().equals("image/jpeg")) {
//	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                        .body("only JPEG is supported");
//
//	            }
	            boolean f = fileuploadhelper.uploadFile(file);
	            if (f) {
	            	//static image upload
	                return ResponseEntity.ok("Successfully Uploaded");

	                //Upload image dynamically
//	                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("/Image/")
//	                .path(file.getOriginalFilename())
//	                .toUriString());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!try again");
	    }
}
