package yongs.temp.mapper;

import java.util.List;

import yongs.temp.vo.TUserVo;

public interface TUserMapper {
	public void insert(int id, String name);
	public List<TUserVo> selectList();
}
