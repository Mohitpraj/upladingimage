package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.File;
import com.example.demo.service.FileService;

@RestController
public class FileController {
	
	@Autowired   
	FileService fileService;
	
	@PostMapping("upload")
	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws IOException   {
		   fileService.saveFile(file);
		   return new ResponseEntity("uploaded",HttpStatus.CREATED.CREATED);
	}
	
	@GetMapping("/download/{fileId}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("fileId") int fileId){
		  File file=fileService.getFile(fileId);
		  return ResponseEntity.ok().header("Content-type","file/jpeg" ).body(file.getFile());
		
	}

}
