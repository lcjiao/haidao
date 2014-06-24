package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.PackageDetailInfoIbatisDAOImpl;
import com.island.domain.dal.PackageImageRelationIbatisDAOImpl;
import com.island.domain.dal.PackageKepianliuyingIbatisDAOImpl;
import com.island.domain.dal.PhotoSubscribeIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.dal.WorkTeamIbatisDAOImpl;
import com.island.domain.dal.WorkmanIbatisDAOImpl;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.PackageKepianliuying;
import com.island.domain.model.PhotoSubscribe;
import com.island.domain.model.Recommend;
import com.island.domain.model.Workman;

public class WdpTeamBiz {

	private IslandPackageIbatisDAOImpl islandPackageDao;
	
	private WorkmanIbatisDAOImpl workmanDao;
	
	private WorkTeamIbatisDAOImpl workTeamDao;
	
	private PhotoSubscribeIbatisDAOImpl photoSubscribeDao;
	
	private RecommendIbatisDAOImpl recommendDao;
	
	private PackageDetailInfoIbatisDAOImpl packageDetailInfoDao;

	public void setPackageDetailInfoDao(
			PackageDetailInfoIbatisDAOImpl packageDetailInfoDao) {
		this.packageDetailInfoDao = packageDetailInfoDao;
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

	public void setRecommendDao(RecommendIbatisDAOImpl recommendDao) {
		this.recommendDao = recommendDao;
	}
	
	public WorkmanIbatisDAOImpl getWorkmanDao() {
		return workmanDao;
	}

	public void setWorkmanDao(WorkmanIbatisDAOImpl workmanDao) {
		this.workmanDao = workmanDao;
	}

	public WorkTeamIbatisDAOImpl getWorkTeamDao() {
		return workTeamDao;
	}

	public void setWorkTeamDao(WorkTeamIbatisDAOImpl workTeamDao) {
		this.workTeamDao = workTeamDao;
	}

	public PhotoSubscribeIbatisDAOImpl getPhotoSubscribeDao() {
		return photoSubscribeDao;
	}

	public void setPhotoSubscribeDao(PhotoSubscribeIbatisDAOImpl photoSubscribeDao) {
		this.photoSubscribeDao = photoSubscribeDao;
	}

	public IslandPackageIbatisDAOImpl getIslandPackageDao() {
		return islandPackageDao;
	}

	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}

	public List<Recommend> queryByMap(Map<String,Object> params){
		return this.recommendDao.queryByMap(params);
	}
	
	public Integer countByMap(Map<String,Object> params){
		return this.recommendDao.countByMap(params);
	}

	public Integer updRecommend(Map<String, Object> map) {
		return this.recommendDao.updateByMap(map);
	}

	public Recommend queryById(Integer id) {
		return this.recommendDao.queryById(id);
	}

	public Integer updateRecommend(Recommend recommend) {
		return this.recommendDao.update(recommend);
	}

	public Integer addRecommend(Recommend recommend) {
		return this.recommendDao.insert(recommend);
	}

	public Workman queryWkmPackageBywkmId(Integer wkmId) {
		return this.workmanDao.queryById(wkmId);
	}

	public List<Workman> queryWkmPackageByMap(Map<String, Object> map) {
		return this.workmanDao.queryByMap(map);
	}

	public Integer countWkmPackageByMap(Map<String, Object> map) {
		return this.workmanDao.countByMap(map);
	}

	public Integer addWkmPackage(Workman workman) {
		return this.workmanDao.insert(workman);
	}

	public Integer updateWkmPackage(Workman workman) {
		return this.workmanDao.update(workman);
	}

	public List<PackageDetailInfo> queryPackageDetailByMap(
			Map<String, Object> map) {
		return this.packageDetailInfoDao.queryByMap(map);
	}

	public Integer updatePkgDetailInfo(PackageDetailInfo pkgDetailInfo) {
		return this.packageDetailInfoDao.update(pkgDetailInfo);
	}

	public Integer addPkgDetailInfo(PackageDetailInfo pkgDetailInfo) {
		return this.packageDetailInfoDao.insert(pkgDetailInfo);
	}

	public List<PackageImageRelation> queryPkgImgRelationByMap(
			Map<String, Object> map) {
		return this.pkgImgRelationDao.queryByMap(map);
	}

	public Integer countPkgImgRelationByMap(Map<String, Object> map) {
		return this.pkgImgRelationDao.countByMap(map);
	}

	public List<PackageKepianliuying> queryPkgKPLYByMap(Map<String, Object> map) {
		return this.pkgKepianliuyingDao.queryByMap(map);
	}

	public Integer countPkgKPLYByMap(Map<String, Object> map) {
		return this.pkgKepianliuyingDao.countByMap(map);
	}

	public PackageKepianliuying queryPkgKPLYByKplyId(Integer kplyId) {
		return this.pkgKepianliuyingDao.queryById(kplyId);
	}

	public PackageKepianliuying queryPkgKPLYByWkmId(Integer wkmId) {
		return this.pkgKepianliuyingDao.queryById(wkmId);
	}

	public Integer addPkgKPLY(PackageKepianliuying pkgKPLY) {
		return this.pkgKepianliuyingDao.insert(pkgKPLY);
	}

	public Integer updatePkgKPLY(PackageKepianliuying pkgKPLY) {
		return this.pkgKepianliuyingDao.update(pkgKPLY);
	}

	public Integer updatePkgKPLY(Map<String, Object> map) {
		return this.pkgKepianliuyingDao.updateByMap(map);
	}

	public List<PhotoSubscribe> queryPtoSubscribeByMap(Map<String, Object> map) {
		return this.photoSubscribeDao.queryByMap(map);
	}

	public Integer countPtoSubscribeByMap(Map<String, Object> map) {
		return this.photoSubscribeDao.countByMap(map);
	}

	public Integer updateSubscribe(PhotoSubscribe ptoSubscribe) {
		return this.photoSubscribeDao.update(ptoSubscribe);
	}

	public Integer addSubscribe(PhotoSubscribe ptoSubscribe) {
		return this.photoSubscribeDao.insert(ptoSubscribe);
	}

	public List<Workman> queryWkmByWorkId(Map<String, Object> map) {
		return this.workmanDao.queryByMap(map);
	}

	public Integer updatePtoSubscribe(PhotoSubscribe ptoSubscribe) {
		return this.photoSubscribeDao.update(ptoSubscribe);
	}

	public PhotoSubscribe queryPtoSubscribeByPsbId(Integer subscribeId) {
		return this.photoSubscribeDao.queryById(subscribeId);
	}

	
}
