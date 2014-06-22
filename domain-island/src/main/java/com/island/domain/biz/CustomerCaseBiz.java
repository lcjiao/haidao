package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.CasePicMappingIbatisDAOImpl;
import com.island.domain.dal.CaseVideoMappingIbatisDAOImpl;
import com.island.domain.dal.CustomerCaseIbatisDAOImpl;
import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Recommend;

public class CustomerCaseBiz {

	private IslandPackageIbatisDAOImpl islandPackageDao;
	
	private CustomerCaseIbatisDAOImpl customerCaseDao;
	
	private CasePicMappingIbatisDAOImpl casePicMappingDao;
	
	private CaseVideoMappingIbatisDAOImpl caseVideoMappingDao;

	private RecommendIbatisDAOImpl recommendDao;

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
	
}
