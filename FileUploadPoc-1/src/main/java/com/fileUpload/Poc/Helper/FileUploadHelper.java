package com.fileUpload.Poc.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
//	public final String  UPLOAD_DIRECTORY ="D:\\UAL_RTE\\Eclipse Workspace\\FileUploadPoc-1\\src\\main\\resources\\static\\image";
	
	public final String  UPLOAD_DIRECTORY = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	public FileUploadHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean uploadFile(MultipartFile multipaerFile) {
		
		boolean f = false;
		try {
			Files.copy(multipaerFile.getInputStream(),Paths.get(UPLOAD_DIRECTORY+"\\"+multipaerFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}	
}
