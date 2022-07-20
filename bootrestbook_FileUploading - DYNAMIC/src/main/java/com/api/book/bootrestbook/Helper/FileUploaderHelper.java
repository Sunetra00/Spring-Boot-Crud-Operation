package com.api.book.bootrestbook.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
	// public final String UPLOAD_DIR = "F:\\STS Workspace\\REST_API_Workspace\\bootrestbook_FileUploading\\src\\main\\resources\\static\\Image";
    //Upload image dynamically
   public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploaderHelper () throws IOException{

    }

    public boolean uploadFile(MultipartFile  multipart) {
        boolean f= false;
        try{
            Files.copy(multipart.getInputStream(),Paths.get(UPLOAD_DIR+"\\"+multipart.
            getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

}
