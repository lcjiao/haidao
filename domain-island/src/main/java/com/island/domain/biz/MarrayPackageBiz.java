package com.island.domain.biz;

import com.island.domain.dal.IslandPackageIbatisDAOImpl;

public class MarrayPackageBiz {
	private IslandPackageIbatisDAOImpl islandPackageDao;

	public IslandPackageIbatisDAOImpl getIslandPackageDao() {
		return islandPackageDao;
	}

	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}
	

}
