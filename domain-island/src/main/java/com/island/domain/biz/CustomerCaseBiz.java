package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.CasePicMappingIbatisDAOImpl;
import com.island.domain.dal.CaseVideoMappingIbatisDAOImpl;
import com.island.domain.dal.CustomerCaseIbatisDAOImpl;
import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.IslandPackageTypeIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.CasePicMapping;
import com.island.domain.model.CaseVideoMapping;
import com.island.domain.model.CustomerCase;
import com.island.domain.model.IslandPackageType;
import com.island.domain.model.Recommend;

public class CustomerCaseBiz {

	private IslandPackageIbatisDAOImpl islandPackageDao;
	
	private IslandPackageTypeIbatisDAOImpl islandPackageTypeDao;
	
	private CustomerCaseIbatisDAOImpl customerCaseDao;
	
	private CasePicMappingIbatisDAOImpl casePicMappingDao;
	
	private CaseVideoMappingIbatisDAOImpl caseVideoMappingDao;

	private RecommendIbatisDAOImpl recommendDao;

	public IslandPackageTypeIbatisDAOImpl getIslandPackageTypeDao() {
		return islandPackageTypeDao;
	}

	public void setIslandPackageTypeDao(
			IslandPackageTypeIbatisDAOImpl islandPackageTypeDao) {
		this.islandPackageTypeDao = islandPackageTypeDao;
	}

	public RecommendIbatisDAOImpl getRecommendDao() {
		return recommendDao;
	}

	public void setRecommendDao(RecommendIbatisDAOImpl recommendDao) {
		this.recommendDao = recommendDao;
	}
	
	public IslandPackageIbatisDAOImpl getIslandPackageDao() {
		return islandPackageDao;
	}

	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}

	public CustomerCaseIbatisDAOImpl getCustomerCaseDao() {
		return customerCaseDao;
	}

	public void setCustomerCaseDao(CustomerCaseIbatisDAOImpl customerCaseDao) {
		this.customerCaseDao = customerCaseDao;
	}

	public CasePicMappingIbatisDAOImpl getCasePicMappingDao() {
		return casePicMappingDao;
	}

	public void setCasePicMappingDao(CasePicMappingIbatisDAOImpl casePicMappingDao) {
		this.casePicMappingDao = casePicMappingDao;
	}

	public CaseVideoMappingIbatisDAOImpl getCaseVideoMappingDao() {
		return caseVideoMappingDao;
	}

	public void setCaseVideoMappingDao(
			CaseVideoMappingIbatisDAOImpl caseVideoMappingDao) {
		this.caseVideoMappingDao = caseVideoMappingDao;
	}
	

	public List<Recommend> queryByMap(Map<String,Object> params){
		return this.recommendDao.queryByMap(params);
	}
	
	public Integer countByMap(Map<String,Object> params){
		return this.recommendDao.countByMap(params);
	}

	public Integer addRecommend(Recommend recommend) {
		return this.recommendDao.insert(recommend);
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

	public List<CustomerCase> queryCtmcasePkgByMap(Map<String, Object> map) {
		return this.customerCaseDao.queryByMap(map);
	}

	public Integer countCtmcasePkgByMap(Map<String, Object> map) {
		return this.customerCaseDao.countByMap(map);
	}

	public Integer addCtmcase(CustomerCase ctmcase) {
		return this.customerCaseDao.insert(ctmcase);
	}

	public List<IslandPackageType> queryAreaListByCaseType(Map<String, Object> map) {
		return this.islandPackageTypeDao.queryByMap(map); 
	}

	public CustomerCase queryCtmCaseById(Integer ctmId) {
		return this.customerCaseDao.queryById(ctmId);
	}

	public Integer updateCtmcase(CustomerCase ctmcase) {
		return this.customerCaseDao.update(ctmcase);
	}

	public Integer addImgcase(CasePicMapping casepm) {
		return this.casePicMappingDao.insert(casepm);
	}

	public List<CasePicMapping> queryCasePmByMap(Map<String, Object> map) {
		return this.casePicMappingDao.queryByMap(map);
	}

	public Integer countCasePmByMap(Map<String, Object> map) {
		return this.casePicMappingDao.countByMap(map);
	}

	public List<CaseVideoMapping> queryCaseVmByMap(Map<String, Object> map) {
		return this.caseVideoMappingDao.queryByMap(map);
	}

	public Integer countCaseVmByMap(Map<String, Object> map) {
		return this.caseVideoMappingDao.countByMap(map);
	}

	public CasePicMapping queryCasePmByCtmImgId(Integer ctmImgId) {
		return this.casePicMappingDao.queryById(ctmImgId);
	}

	public Integer updateCaseImgMapping(CasePicMapping casepm) {
		return this.casePicMappingDao.update(casepm);
	}

	public CaseVideoMapping queryCaseVmByCtmImgId(Integer ctmVideoId) {
		return this.caseVideoMappingDao.queryById(ctmVideoId);
	}

	public Integer updateCaseVideoMapping(CaseVideoMapping casevm) {
		return this.caseVideoMappingDao.update(casevm);
	}

	public Integer addVideocase(CaseVideoMapping casevm) {
		return this.caseVideoMappingDao.insert(casevm);
	}

}
