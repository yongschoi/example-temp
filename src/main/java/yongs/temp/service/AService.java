package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.exception.AppRuntimeException;
import yongs.temp.mapper.CompanyMapper;
import yongs.temp.mapper.ItemMapper;
import yongs.temp.vo.CompanyVo;
import yongs.temp.vo.ItemVo;

@Slf4j
@Service
public class AService {
	@Autowired
	ItemMapper itemMapper;
	@Autowired
	CompanyMapper companyMapper;	

	@Autowired
	BService service;
	
	@Transactional
	public String createSingle(ItemVo itemVo, CompanyVo companyVo) {
		log.debug("AService.createItem <" + itemVo.getId() + ">");
		var returnValue = "test"; 
		itemMapper.insert(itemVo);

		try {
			createCompany(companyVo);
			returnValue = "SUCCESS";
		} catch (AppRuntimeException are) {
			returnValue = "FAIL-AppRuntime";
		}
		return returnValue;
	}
	
	@Transactional
	public void createCompany(CompanyVo companyVo) {
		log.debug("AService.createCompany <" + companyVo.getId() + ">");
		companyMapper.insert(companyVo);
		throw new AppRuntimeException();
	}

	@Transactional
	public String createMulti(ItemVo itemVo, CompanyVo companyVo) {
		log.debug("AService.createMulti <" + itemVo.getId() + ">");
		var returnValue = "test"; 
		itemMapper.insert(itemVo);
		// service.createCompany(companyVo);

		try {
			service.createCompany(companyVo);
			returnValue = "SUCCESS";
		} catch (AppRuntimeException are) {
			returnValue = "FAIL-AppRuntime";
		}

		return returnValue;
	}
	@Transactional
	public void init() {
		log.debug("AService.init()");
		itemMapper.deleteAll();
		companyMapper.deleteAll();
	}
}
