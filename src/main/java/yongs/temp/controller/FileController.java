package yongs.temp.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.vo.Message;

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
	
	@PostMapping("/download")
	public void download(@RequestBody Message message, HttpServletResponse response) throws Exception {
		log.info("|" + message.getContents() + "|");	
		
		  try (
				  InputStream is = new ByteArrayInputStream(message.getContents().getBytes());
				  OutputStream os = response.getOutputStream();
			    ){		  
			  		response.addHeader("Content-Disposition", "attachment;filename=\""+message.getTitle()+"\"");
			        // 응답 크기 명시
			        // response.setContentLength((int)file.length());

			        int read = 0;
			        
			        // 실제 데이터 전송
			        // OutputStream 의 Deafult 버퍼 사이즈는 8192 Byte
			        // 이 루프를 8000 번 정도 돌때마다 약 8KB 정도의 데이터가 전송 
			        while((read = is.read()) != -1) {
			            os.write(read);
			        }		        
			    } catch(IOException e) {
			        e.printStackTrace();
			    }
		
	}
	
}
