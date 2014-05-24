package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.CompanyIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Company;
import com.island.domain.model.Recommend;

/**
 * 网站信息biz
 * @author lcjiao
 *
 */
public class GlobalNetBiz {

	private RecommendIbatisDAOImpl recommendDao;
	private CompanyIbatisDAOImpl companyDao;

	public void setRecommendDao(RecommendIbatisDAOImpl recommendDao) {
		this.recommendDao = recommendDao;
	}
	public void setCompanyDao(CompanyIbatisDAOImpl companyDao) {
		this.companyDao = companyDao;
	}
	
	public void addCompanyInfo(Company obj){
		this.companyDao.insert(obj);
	}
	
	public void updCompanyByMap(Map<String,Object> params){
		this.companyDao.updateByMap(params);
	}
	public List<Company> queryCompanyByMap(Map<String,Object> params){
		return this.companyDao.queryByMap(params);
	}
	
	public Company queryCompamyById(Integer id){
		return this.companyDao.queryById(id);
	}
	
	public List<Recommend> queryRecommendByMap(Map<String,Object> params){
		return this.recommendDao.queryByMap(params);
	}
	
	public Integer countRecommendByMap(Map<String,Object> params){
		return this.recommendDao.countByMap(params);
	}
	
	public void addMasterRecommend(Recommend obj){
		this.recommendDao.insert(obj);
	}
	
	public void updRecommend(Map<String,Object> params){
		this.recommendDao.updateByMap(params);
	}
	
	public Recommend queryRecommendById(Integer id){
		return this.recommendDao.queryById(id);
	}
	
}
