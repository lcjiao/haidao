package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.AreaIbatisDAOImpl;
import com.island.domain.dal.IslandIbatisDAOImpl;
import com.island.domain.dal.PackageDetailInfoIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.Recommend;

public class WeddingPhotoBiz {
	
	private PackageDetailInfoIbatisDAOImpl packageDetailInfoDao;

	public void setPackageDetailInfoDao(
			PackageDetailInfoIbatisDAOImpl packageDetailInfoDao) {
		this.packageDetailInfoDao = packageDetailInfoDao;
	}
	private RecommendIbatisDAOImpl recommendDao;

	public void setRecommendDao(RecommendIbatisDAOImpl recommendDao) {
		this.recommendDao = recommendDao;
	}

	public List<Recommend> queryByMap(Map<String, Object> params) {
		return this.recommendDao.queryByMap(params);
	}

	public Integer countByMap(Map<String, Object> params) {
		return this.recommendDao.countByMap(params);
	}
	
	
	    
	
}
