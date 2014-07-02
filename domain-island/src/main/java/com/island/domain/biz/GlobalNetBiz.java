package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.BlackWordIbatisDAOImpl;
import com.island.domain.dal.CompanyIbatisDAOImpl;
import com.island.domain.dal.CountryIbatisDAOImpl;
import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.BlackWord;
import com.island.domain.model.Company;
import com.island.domain.model.Country;
import com.island.domain.model.Recommend;

/**
 * 网站信息biz
 * @author lcjiao
 *
 */
public class GlobalNetBiz {

	private RecommendIbatisDAOImpl recommendDao;
	private CompanyIbatisDAOImpl companyDao;
	private CountryIbatisDAOImpl countryDao;
	private BlackWordIbatisDAOImpl blackWordDao;

	
	public void setBlackWordDao(BlackWordIbatisDAOImpl blackWordDao) {
		this.blackWordDao = blackWordDao;
	}
	public void setRecommendDao(RecommendIbatisDAOImpl recommendDao) {
		this.recommendDao = recommendDao;
	}
	public void setCompanyDao(CompanyIbatisDAOImpl companyDao) {
		this.companyDao = companyDao;
	}
	
	public void setCountryDao(CountryIbatisDAOImpl countryDao) {
		this.countryDao = countryDao;
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
	
	public void addCountry(Country obj){
		this.countryDao.insert(obj);
	}
	
	public void updConutryByModel(Country model){
		this.countryDao.update(model);
	}
	public void updCountryByMap(Map<String,Object> parasm){
		this.countryDao.updateByMap(parasm);
	}
	public Country queryCountryById(Integer id){
		return this.countryDao.queryById(id);
	}
	public List<Country> queryCountryByMap(Map<String,Object> params){
		return this.countryDao.queryByMap(params);
	}
	public Integer countCountryByMap(Map<String,Object> params){
		return this.countryDao.countByMap(params);
	}
	
	public void addBlackWord(BlackWord obj){
		this.blackWordDao.insert(obj);
	}
	
	public void updBlackWordByMap(Map<String,Object> parasm){
		this.blackWordDao.updateByMap(parasm);
	}
	
	public Integer countBlackWordByMap(Map<String,Object> parasm){
		return this.blackWordDao.countByMap(parasm);
	}
	
	public BlackWord queryBlackWordById(Integer id){
		return this.blackWordDao.queryById(id);
	}
	
	public List<BlackWord> queryBlackWordByMap(Map<String,Object> parasm){
		return this.blackWordDao.queryByMap(parasm);
	}
	
	public void updBlackWordByModel(BlackWord model){
		this.blackWordDao.update(model);
	}
}
