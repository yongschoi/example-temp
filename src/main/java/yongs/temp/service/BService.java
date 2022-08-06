package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.exception.AppRuntimeException;
import yongs.temp.mapper.CompanyMapper;
import yongs.temp.vo.CompanyVo;

@Slf4j
@Service
public class BService {
	@Autowired
	CompanyMapper mapper;
	
	@Transactional
	public void insert(CompanyVo companyVo) throws Exception {
		log.debug("<BService" + companyVo.getId() + "> This is Transactional Test");
		mapper.insert(companyVo);
		throw new AppRuntimeException();
	}
}
