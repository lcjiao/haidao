package com.island.domain.biz;

import com.island.domain.dal.CasePicMappingIbatisDAOImpl;
import com.island.domain.dal.CaseVideoMappingIbatisDAOImpl;
import com.island.domain.dal.CustomerCaseIbatisDAOImpl;
import com.island.domain.dal.IslandPackageIbatisDAOImpl;

public class CustomerCaseBiz {

	private IslandPackageIbatisDAOImpl islandPackageDao;
	
	private CustomerCaseIbatisDAOImpl customerCaseDao;
	
	private CasePicMappingIbatisDAOImpl casePicMappingDao;
	
	private CaseVideoMappingIbatisDAOImpl caseVideoMappingDao;

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
	
}
