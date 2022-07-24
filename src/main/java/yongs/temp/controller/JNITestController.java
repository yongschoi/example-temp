package yongs.temp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chilkatsoft.CkZip;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dll")
public class JNITestController {
	@GetMapping("/test")
	public void test() throws Exception {
		log.debug("<JNITestController> This is JNI Test");
		// System.load("C:/temp/chilkat/chilkat.dll");

		CkZip zip = new CkZip();
		log.debug(zip.version());
	}
}
