package yongs.temp.mapper;

import java.util.List;

import yongs.temp.vo.ItemVo;

public interface ItemMapper {
	public void insert(ItemVo itemVo);
	public List<ItemVo> selectList();
	public void deleteAll();
}
