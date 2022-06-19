package yongs.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.service.TestService;

@Slf4j
@RestController
@RequestMapping("/temp")
public class TempController {
	@Autowired
	TestService service;
	
	@GetMapping("/create")
	public void create() throws Exception {
		log.debug("<Controller> This is Transactional Test");
		service.insert();
	}
}
