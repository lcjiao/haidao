package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.IslandMapIbatisDAOImpl;
import com.island.domain.model.IslandMap;

public class IslandMapBiz {

	private IslandMapIbatisDAOImpl islandMapDao;

	public void setIslandMapDao(IslandMapIbatisDAOImpl islandMapDao) {
		this.islandMapDao = islandMapDao;
	}
	
	public void addMap(IslandMap obj){
		this.islandMapDao.insert(obj);
	}
	
	public void updMapByModel(IslandMap obj){
		this.islandMapDao.update(obj);
	}
	
	public void updMapByMap(Map<String,Object> params){
		this.islandMapDao.updateByMap(params);
	}
	
	public IslandMap queryMapById(Integer id){
		return this.islandMapDao.queryById(id);
	}
	
	public List<IslandMap> queryMapByMap(Map<String,Object> params){
		return this.islandMapDao.queryByMap(params);
	}
	
	public Integer countMap(Map<String,Object> params){
		return this.countMap(params);
	}
}
