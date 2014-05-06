package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.dal.AreaIbatisDAOImpl;
import com.island.domain.dal.IslandIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.Island;

public class AreaIslandBiz {
	
	private AreaIbatisDAOImpl areaDao;
	private IslandIbatisDAOImpl islandDao;
	public void setAreaDao(AreaIbatisDAOImpl areaDao) {
		this.areaDao = areaDao;
	}
	public void setIslandDao(IslandIbatisDAOImpl islandDao) {
		this.islandDao = islandDao;
	}
	
	public void addArea(Area obj){
		this.areaDao.insert(obj);
	}
	
	public void addIsland(Island obj){
		this.islandDao.insert(obj);
	}
	
	public void updArea(Map<String,Object> params){
		this.areaDao.updateByMap(params);
	}
	
	public void updIsland(Map<String,Object> params){
		this.islandDao.updateByMap(params);
	}
	
	public Area queryAreaById(Integer id){
		return this.areaDao.queryById(id);
	}
	
	public Island queryIslandById(Integer id){
		return this.islandDao.queryById(id);
	}
	
	public List<Area> queryAreaByMap(Map<String,Object> params){
		return this.areaDao.queryByMap(params);
	}
	
	public List<Island> queryIslandByMap(Map<String,Object> params){
		return this.islandDao.queryByMap(params);
	}
	
	public Integer countAreaByMap(Map<String,Object> params){
		return this.areaDao.countByMap(params);
	}
	
	public Integer countIslandByMap(Map<String,Object> params){
		return this.islandDao.countByMap(params);
	}
	
	public void updateIslandByAreaId(Map<String,Object> params){
		this.islandDao.updateByAreaId(params);
	}

}
