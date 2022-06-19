package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.mapper.TestMapper;

@Slf4j
@Service
public class TestService {
	@Autowired
	SubService service;

	@Autowired
	TestMapper mapper;
	
	@Transactional
	public void insert() throws Exception {
		log.debug("<TestService> This is Transactional Test");
		for(int idx=0; idx < 10; idx++) {
			service.insert(idx, "AAA-" + idx);
		}
	}
}
