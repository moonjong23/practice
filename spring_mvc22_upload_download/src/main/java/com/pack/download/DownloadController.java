package com.pack.download;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadController {
	@RequestMapping("download")
	@ResponseBody //http로 내보내는 것 : 다운로드가 됨
	public byte[] getDownloadfile(HttpServletResponse response, @RequestParam("filename") String filename) throws IOException{
		//System.out.println("filename : " + filename);
		File newFile = new File("c:/my/upload/" + filename); //Unix 방식
		byte[] bytes = FileCopyUtils.copyToByteArray(newFile);
		
		String fn = new String(newFile.getName().getBytes(),"iso_8859_1"); //파일명 얻기
		response.setHeader("Content-Disposition", "attatchment;filename=\"" + fn + "\""); //전송되는 파일명 명시
		response.setContentLength(bytes.length);
		return bytes;

	}
}
