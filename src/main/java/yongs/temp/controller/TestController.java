package yongs.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.service.TestService;
import yongs.temp.vo.TUserVo;

@Slf4j
@RestController
@RequestMapping("/tuser")
public class TestController {
	@Autowired
	TestService service;
	
	@GetMapping("/create")
	public void create() throws Exception {
		log.debug("<TestController> This is Transactional Test");
		service.insert();
	}
	
	@GetMapping("/selectlist")
	public List<TUserVo> selectList() throws Exception {
		log.debug("<TestController> list");
		return service.selectList();
	}
}
