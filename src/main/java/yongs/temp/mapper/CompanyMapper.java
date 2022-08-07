package yongs.temp.mapper;

import java.util.List;

import yongs.temp.vo.CompanyVo;

public interface CompanyMapper {
	public void insert(CompanyVo companyVo);
	public List<CompanyVo> selectList();
	public void deleteAll();
}
