package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.File;
import com.example.demo.repo.FileRepo;

@Service
public class FileService {
	
	@Autowired
	FileRepo fileRepo;
	
	public void saveFile(MultipartFile file) throws IOException {
		File f = new File();
		f.setFile(file.getBytes());
		
		fileRepo.save(f);
	}
	
	public File getFile(int id) {
		 return fileRepo.findById(id).get();
		
	}

}