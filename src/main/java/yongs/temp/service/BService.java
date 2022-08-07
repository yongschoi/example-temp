package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createCompany(CompanyVo companyVo) {
		log.debug("BService <" + companyVo.getId() + ">");
		mapper.insert(companyVo);
		throw new AppRuntimeException();
	}
}
