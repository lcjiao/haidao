package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.IslandPackageTypeIbatisDAOImpl;
import com.island.domain.model.IslandPackageType;

public class ModuleTypeBiz {
	private IslandPackageTypeIbatisDAOImpl islandPackageTypeDao;

	public List<IslandPackageType> queryPackageTypeByMap(Map<String,Object> params){
		return this.islandPackageTypeDao.queryByMap(params);
	}
	
	public Integer countPackageTypeByMap(Map<String,Object> params){
		return this.islandPackageTypeDao.countByMap(params);
	}
	
	public void addPackageType(IslandPackageType obj){
		this.islandPackageTypeDao.insert(obj);
	}
	public IslandPackageType queryPackageTypeById(Integer id){
		return this.islandPackageTypeDao.queryById(id);
	}
	public void updPackageTypeByMap(Map<String,Object> params){
		this.islandPackageTypeDao.updateByMap(params);
	}

	public IslandPackageTypeIbatisDAOImpl getIslandPackageTypeDao() {
		return islandPackageTypeDao;
	}

	public void setIslandPackageTypeDao(
			IslandPackageTypeIbatisDAOImpl islandPackageTypeDao) {
		this.islandPackageTypeDao = islandPackageTypeDao;
	}
	
	
}
