package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.mapper.TestMapper;

@Slf4j
@Service
public class SubService {
	@Autowired
	TestMapper mapper;
	// @Transactional
	public void insert(int id, String name) throws Exception {
		log.debug("<SubService" + id + "> This is Transactional Test");
		mapper.insert(id, name);
	}
}
