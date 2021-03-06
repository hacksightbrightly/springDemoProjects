package com.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.rest.helper.upload;

@RestController
public class FileUploadController {
	@Autowired
	private upload up;
	@PostMapping("/uploadfile")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is empty");
			}
			if(up.uploadMyFile(file))
			{
				//return ResponseEntity.ok("File Uploaded Successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
 }
