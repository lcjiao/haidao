package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.RecommendIbatisDAOImpl;
import com.island.domain.model.Recommend;

public class RecommendBiz {

	private RecommendIbatisDAOImpl recommendDao;

	public void setRecommendDao(RecommendIbatisDAOImpl recommendDao) {
		this.recommendDao = recommendDao;
	}
	
	public List<Recommend> queryByMap(Map<String,Object> params){
		return this.recommendDao.queryByMap(params);
	}
	
	public Integer countByMap(Map<String,Object> params){
		return this.recommendDao.countByMap(params);
	}
	
	public void addMasterRecommend(Recommend obj){
		this.recommendDao.insert(obj);
	}
	
	public void updRecommend(Map<String,Object> params){
		this.recommendDao.updateByMap(params);
	}
	
	public void updRecommendByModel(Recommend obj){
		this.recommendDao.update(obj);
	}
	
	public Recommend queryById(Integer id){
		return this.recommendDao.queryById(id);
	}
	
}
