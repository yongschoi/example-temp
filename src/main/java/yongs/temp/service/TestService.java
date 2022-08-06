package yongs.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.mapper.TUserMapper;
import yongs.temp.vo.TUserVo;

@Slf4j
@Service
public class TestService {
	@Autowired
	SubService service;

	@Autowired
	TUserMapper mapper;
	
	@Transactional
	public void insert() throws Exception {
		log.debug("<TestService> This is Transactional Test");
		for(int idx=0; idx < 100; idx++) {
			service.insert(idx, "Name-" + idx);
		}
	}
	
	public List<TUserVo> selectList() throws Exception {
		return mapper.selectList();
	}
}
