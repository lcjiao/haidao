package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.AreaIbatisDAOImpl;
import com.island.domain.dal.IslandIbatisDAOImpl;
import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.PackageDetailInfoIbatisDAOImpl;
import com.island.domain.dal.PackageImageRelationIbatisDAOImpl;
import com.island.domain.dal.PackageKepianliuyingIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.PackageKepianliuying;
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
	
	private PackageImageRelationIbatisDAOImpl pkgImgRelationDao;
	
	public void setPkgImgRelationDao(
			PackageImageRelationIbatisDAOImpl pkgImgRelationDao) {
		this.pkgImgRelationDao = pkgImgRelationDao;
	}
	
	private PackageKepianliuyingIbatisDAOImpl pkgKepianliuyingDao;

	public void setPkgKepianliuyingDao(
			PackageKepianliuyingIbatisDAOImpl pkgKepianliuyingDao) {
		this.pkgKepianliuyingDao = pkgKepianliuyingDao;
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

	public List<IslandPackage> queryWdpPackageByMap(Map<String, Object> map) {
		return islandPackageDao.queryByMap(map);
	}

	public Integer countIslandPackageByMap(Map<String, Object> map) {
		return islandPackageDao.countByMap(map);
	}

	public Integer addWdpPackage(IslandPackage islandPackage) {
		return islandPackageDao.insert(islandPackage);
	}

	public IslandPackage queryWdpPackageByWdpId(Integer wdpId) {
		return islandPackageDao.queryById(wdpId);
	}

	public List<PackageDetailInfo> queryPackageDetailByMap(Map<String, Object> map) {
		return packageDetailInfoDao.queryByMap(map);
	}

	public int updatePkgDetailInfo(PackageDetailInfo packageDetailInfo) {
		return packageDetailInfoDao.update(packageDetailInfo);
	}

	public Integer addPkgDetailInfo(PackageDetailInfo pkgDetailInfo) {
		return packageDetailInfoDao.insert(pkgDetailInfo);
	}

	public Integer updateWdpPackage(IslandPackage wdpPackage) {
		return islandPackageDao.update(wdpPackage);
	}

	public List<PackageImageRelation> queryPkgImgRelationByMap(Map<String, Object> map) {
		return pkgImgRelationDao.queryByMap(map);
	}

	public Integer countPkgImgRelationByMap(Map<String, Object> map) {
		return pkgImgRelationDao.countByMap(map);
	}

	public Integer addPkgImgRelation(PackageImageRelation pkgImgRelation) {
		return pkgImgRelationDao.insert(pkgImgRelation);
	}

	public PackageImageRelation queryPkgImgRelationByWdpImgId(Integer wdpImgId) {
		return pkgImgRelationDao.queryById(wdpImgId);
	}

	public Integer updatePkgImgRelation(PackageImageRelation pkgImgRelation) {
		return pkgImgRelationDao.update(pkgImgRelation);
	}

	public Integer updatePkgImgRelation(Map<String, Object> map) {
		return pkgImgRelationDao.updateByMap(map);
	}

	public List<PackageKepianliuying> queryPkgKPLYByMap(Map<String, Object> map) {
		return pkgKepianliuyingDao.queryByMap(map);
	}

	public Integer countPkgKPLYByMap(Map<String, Object> map) {
		return pkgKepianliuyingDao.countByMap(map);
	}

	public Integer addPkgKPLY(PackageKepianliuying pkgKPLY) {
		return pkgKepianliuyingDao.insert(pkgKPLY);
	}

	public PackageKepianliuying queryPkgKPLYByWdpId(Integer packageId) {
		return pkgKepianliuyingDao.queryById(packageId);
	}

	public PackageKepianliuying queryPkgKPLYByKplyId(Integer kplyId) {
		return pkgKepianliuyingDao.queryById(kplyId);
	}

	public Integer updatePkgKPLY(PackageKepianliuying pkgKPLY) {
		return pkgKepianliuyingDao.update(pkgKPLY);
	}

	public Integer updatePkgKPLY(Map<String, Object> map) {
		return pkgKepianliuyingDao.updateByMap(map);
	}

	public Integer updHotFlagByMap(Map<String, Object> map) {
		return islandPackageDao.updateByMap(map);
	}

}
