package com.api.rest.helper;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class upload {
	public final String dir= new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public upload() throws IOException {
		
	}

	public boolean uploadMyFile(MultipartFile file){
		boolean f=false;
		try {
			//FIRST METHOD
			/*
			 * InputStream is=file.getInputStream(); byte data[]=new byte[is.available()];
			 * is.read(data); FileOutputStream fos=new
			 * FileOutputStream(dir+File.separator+file.getOriginalFilename());
			 * fos.write(data); fos.close();
			 */
			//SECOND METHOD
			Files.copy(file.getInputStream(), Paths.get(dir+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
