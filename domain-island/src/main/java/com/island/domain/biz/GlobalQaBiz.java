package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.GlobalQaIbatisDAOImpl;
import com.island.domain.dal.GlobalQaTypeIbatisDAOImpl;
import com.island.domain.model.GlobalQa;
import com.island.domain.model.GlobalQaType;

public class GlobalQaBiz {

	private GlobalQaIbatisDAOImpl globalQaDao;
	private GlobalQaTypeIbatisDAOImpl globalQaTypeDao;
	public GlobalQaIbatisDAOImpl getGlobalQaDao() {
		return globalQaDao;
	}
	public void setGlobalQaDao(GlobalQaIbatisDAOImpl globalQaDao) {
		this.globalQaDao = globalQaDao;
	}
	public GlobalQaTypeIbatisDAOImpl getGlobalQaTypeDao() {
		return globalQaTypeDao;
	}
	public void setGlobalQaTypeDao(GlobalQaTypeIbatisDAOImpl globalQaTypeDao) {
		this.globalQaTypeDao = globalQaTypeDao;
	}
	
	
	
	public void addGlobalQaType(GlobalQaType obj){
		this.globalQaTypeDao.insert(obj);
	}
	public void addGlobalQa(GlobalQa obj){
		this.globalQaDao.insert(obj);
	}
	
	public void updGlobalQaTypeByMap(Map<String,Object> params){
		this.globalQaTypeDao.updateByMap(params);
	}
	public void updGlobalQaByMap(Map<String,Object> params){
		this.globalQaDao.updateByMap(params);
	}
	
	public void updGlobalQaTypeByModel(GlobalQaType model){
		this.globalQaTypeDao.update(model);
	}
	
	public void updGlobalQaByModel(GlobalQa model){
		this.globalQaDao.update(model);
	}
	
	public GlobalQaType queryGlobalQaTypeById(Integer id){
		return this.globalQaTypeDao.queryById(id);
	}
	public GlobalQa queryGlobalQaById(Integer id){
		return this.globalQaDao.queryById(id);
	}
	
	
	public Integer countGlobalQaTypeByMap(Map<String,Object> params){
		return this.globalQaTypeDao.countByMap(params);
	}
	public Integer countGlobalQaByMap(Map<String,Object> params){
		return this.globalQaDao.countByMap(params);
	}
	
	public List<GlobalQaType> queryGlobalQaTypeByMap(Map<String,Object> params){
		return this.globalQaTypeDao.queryByMap(params);
	}
	
	public List<GlobalQa> queryGlobalQaByMap(Map<String,Object> params){
		return this.globalQaDao.queryByMap(params);
	}
	
	
}
