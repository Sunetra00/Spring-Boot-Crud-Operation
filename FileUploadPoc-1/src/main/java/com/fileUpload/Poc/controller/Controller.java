package com.fileUpload.Poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileUpload.Poc.Helper.FileUploadHelper;

@RestController
public class Controller {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/Xmldata-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		try {

			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must contain file");
			}
			if (!file.getContentType().equals("application/xml")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Xml is allowed");
			}

			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
			
				//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				return ResponseEntity.ok("File is uploaded");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}

}
