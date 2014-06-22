package com.island.domain.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.island.domain.dal.PackageQaIbatisDAOImpl;
import com.island.domain.model.PackageQa;

public class GuestQaBiz {

	private PackageQaIbatisDAOImpl guestQaDao;

	public void setGuestQaDao(PackageQaIbatisDAOImpl guestQaDao) {
		this.guestQaDao = guestQaDao;
	}
	
	public void addGuestQa(PackageQa obj){
		this.guestQaDao.insert(obj);
	}
	
	public void updGuestQaByMap(Map<String,Object> params){
		this.guestQaDao.updateByMap(params);
	}
	
	public PackageQa queryGuestQaById(Integer id){
		return this.guestQaDao.queryById(id);
	}
	
	public Integer countGuestQaByMap(Map<String,Object> params){
		return this.guestQaDao.countByMap(params);
	}
	
	public List<PackageQa> queryGuestQaByMap(Map<String,Object> params){
		return this.guestQaDao.queryByMap(params);
	}
	public Integer getUnAnswerNum(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		params.put("isAnswer", 0);
		return this.guestQaDao.countByMap(params);
	}
	
}
