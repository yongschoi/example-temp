package yongs.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.service.AService;
import yongs.temp.vo.CompanyVo;
import yongs.temp.vo.ItemVo;

@Slf4j
@RestController
@RequestMapping("/temp")
public class TempController {
	@Autowired
	AService service;
	
	@GetMapping("/create")
	public String create() throws Exception {
		log.debug("<TempController> This is Transactional Test");
		ItemVo itemVo = new ItemVo();
		itemVo.setId(1);
		itemVo.setName("coffee");
		itemVo.setPrice(2900);
		
		CompanyVo companyVo = new CompanyVo();
		companyVo.setId(1);
		companyVo.setName("Yongs");
		companyVo.setSales(77700000);
		
		return service.insert(itemVo, companyVo);
	}
}
