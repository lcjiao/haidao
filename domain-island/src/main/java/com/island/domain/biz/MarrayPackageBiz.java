package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.model.IslandPackage;

public class MarrayPackageBiz {
	private IslandPackageIbatisDAOImpl islandPackageDao;

	public IslandPackageIbatisDAOImpl getIslandPackageDao() {
		return islandPackageDao;
	}

	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}
	
	public List<IslandPackage> queryPackageByMap(Map<String,Object> params){
		return this.islandPackageDao.queryByMap(params);
	}
	
	public Integer countPackageByMap(Map<String,Object> params){
		return this.islandPackageDao.countByMap(params);
	}
	public void addPackage(IslandPackage model){
		this.islandPackageDao.insert(model);
	}
	public IslandPackage queryById(Integer id){
		return this.islandPackageDao.queryById(id);
	}
	
	public void updByMap(Map<String,Object> params){
		this.islandPackageDao.updateByMap(params);
	}

}
