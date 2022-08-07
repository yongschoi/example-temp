package yongs.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.exception.AppRuntimeException;
import yongs.temp.service.AService;
import yongs.temp.vo.CompanyVo;
import yongs.temp.vo.ItemVo;

@Slf4j
@RestController
@RequestMapping("/tx")
public class TXController {
	@Autowired
	AService service;

	@GetMapping("/init")
	public void init() throws Exception {
		service.init();
	}
	
	@GetMapping("/single")
	public String single() {
		log.debug("TempController.single() Transactional Test");
		var result = "";
		service.init();
		ItemVo itemVo = new ItemVo();
		itemVo.setId(1);
		itemVo.setName("coffee");
		itemVo.setPrice(2900);
		
		CompanyVo companyVo = new CompanyVo();
		companyVo.setId(1);
		companyVo.setName("Yongs");
		companyVo.setSales(77700000);
		
		try {
			result = service.createSingle(itemVo, companyVo);
		} catch (AppRuntimeException are) {
			result = "FAIL-AppRuntime";
		}
		return result;
	}
	@GetMapping("/multi")
	public String multi() {
		log.debug("TempController.multi() Transactional Test");
		var result = "";
		service.init();
		ItemVo itemVo = new ItemVo();
		itemVo.setId(1);
		itemVo.setName("coffee");
		itemVo.setPrice(2900);
		
		CompanyVo companyVo = new CompanyVo();
		companyVo.setId(1);
		companyVo.setName("Yongs");
		companyVo.setSales(77700000);
		try {
			result = service.createMulti(itemVo, companyVo);
		} catch (AppRuntimeException are) {
			result = "FAIL-AppRuntime";
		}
		return result;
	}
}
