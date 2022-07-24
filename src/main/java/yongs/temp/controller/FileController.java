package yongs.temp.controller;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FileController {
	@PostMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file) throws Exception {
		String fileName = file.getOriginalFilename();
		try(
				InputStream is = file.getInputStream();
				FileOutputStream fos = new FileOutputStream("./" + fileName); 
			){
			log.info("|" + fileName + "|");	
			IOUtils.copy(is, fos);
		} catch(Exception e){
			e.printStackTrace();
		} 
	}
}
