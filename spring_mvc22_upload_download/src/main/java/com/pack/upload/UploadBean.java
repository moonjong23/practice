package com.pack.upload;

import org.springframework.web.multipart.MultipartFile;

public class UploadBean { //form bean
	private MultipartFile file;
	
	public MultipartFile getFile(){ //복수개는 List로 받을 것
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
