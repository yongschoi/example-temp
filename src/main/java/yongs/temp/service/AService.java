package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.exception.AppRuntimeException;
import yongs.temp.mapper.ItemMapper;
import yongs.temp.vo.CompanyVo;
import yongs.temp.vo.ItemVo;

@Slf4j
@Service
public class AService {
	@Autowired
	ItemMapper mapper;
	@Autowired
	BService service;
	
	@Transactional
	public String insert(ItemVo itemVo, CompanyVo companyVo) throws Exception {
		log.debug("<AService" + itemVo.getId() + "> This is Transactional Test");
		var returnValue = ""; 
		mapper.insert(itemVo);
		
		try {
			service.insert(companyVo);
			returnValue = "SUCCESS";
		} catch (AppRuntimeException are) {
			returnValue = "FAIL";
		}
		return returnValue;
	}
}
