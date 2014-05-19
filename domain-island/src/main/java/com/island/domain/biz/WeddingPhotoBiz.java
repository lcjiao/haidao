package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.AreaIbatisDAOImpl;
import com.island.domain.dal.IslandIbatisDAOImpl;
import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.PackageDetailInfoIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
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
	
	private IslandPackageIbatisDAOImpl islandPackageDao;
	
	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}

	public Integer countByMap(Map<String, Object> params) {
		return this.recommendDao.countByMap(params);
	}

	public Integer addRecommend(Recommend recommend) {
		return this.recommendDao.insert(recommend);
	}

	public Recommend queryById(Integer id) {
		return recommendDao.queryById(id);
	}

	public void updRecommend(Map<String, Object> oldObjParams) {
		recommendDao.updateByMap(oldObjParams);
	}

	public List<Recommend> queryByMap(Map<String, Object> map) {
		return recommendDao.queryByMap(map);
	}

	public Integer updateRecommend(Recommend recommend) {
		return recommendDao.update(recommend);
	}

	public List<IslandPackage> queryIslandPackageByMap(Map<String, Object> map) {
		return islandPackageDao.queryByMap(map);
	}

	public Integer countIslandPackageByMap(Map<String, Object> map) {
		return islandPackageDao.countByMap(map);
	}

}
