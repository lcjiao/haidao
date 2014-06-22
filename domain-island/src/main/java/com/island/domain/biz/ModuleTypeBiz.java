package com.island.domain.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.island.domain.dal.IslandPackageIbatisDAOImpl;
import com.island.domain.dal.IslandPackageTypeIbatisDAOImpl;
import com.island.domain.model.IslandPackageType;
import com.island.domain.util.AsynBizExecutor;
import com.jcl.core.logging.LogUtil;

public class ModuleTypeBiz {
	private IslandPackageTypeIbatisDAOImpl islandPackageTypeDao;
	private IslandPackageIbatisDAOImpl islandPackageDao;

	public List<IslandPackageType> queryPackageTypeByMap(Map<String,Object> params){
		return this.islandPackageTypeDao.queryByMap(params);
	}
	
	public Integer countPackageTypeByMap(Map<String,Object> params){
		return this.islandPackageTypeDao.countByMap(params);
	}
	
	public void addPackageType(IslandPackageType obj){
		this.islandPackageTypeDao.insert(obj);
	}
	public IslandPackageType queryPackageTypeById(Integer id){
		return this.islandPackageTypeDao.queryById(id);
	}
	public void updPackageTypeByMap(Map<String,Object> params){
		this.islandPackageTypeDao.updateByMap(params);
	}
	
	public void updPackageTypeByModule(IslandPackageType obj){
		this.islandPackageTypeDao.update(obj);
		
		if( obj.getTitle() != null ){
			
			
			final IslandPackageType temp = obj;
			final IslandPackageIbatisDAOImpl dao = this.islandPackageDao;
			new AsynBizExecutor("modifyTypeNameById", true){
				@Override
				public void execute() {
					long start = System.currentTimeMillis();
					try {
						Map<String,Object> params = new HashMap<String,Object>(0);
						params.put("typeId", temp.getId());
						params.put("typeName", temp.getTitle());
						dao.updateByType(params);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					long end = System.currentTimeMillis();
					LogUtil.trace("modifyTypeNameById use:"+(end - start));
				}
			};
			
			
		}
		
	}

	public IslandPackageTypeIbatisDAOImpl getIslandPackageTypeDao() {
		return islandPackageTypeDao;
	}

	public void setIslandPackageTypeDao(
			IslandPackageTypeIbatisDAOImpl islandPackageTypeDao) {
		this.islandPackageTypeDao = islandPackageTypeDao;
	}
	
	public void updateByAreaIsland(Map<String,Object> params){
		this.islandPackageTypeDao.updateByAreaIsland(params);
	}

	public IslandPackageIbatisDAOImpl getIslandPackageDao() {
		return islandPackageDao;
	}

	public void setIslandPackageDao(IslandPackageIbatisDAOImpl islandPackageDao) {
		this.islandPackageDao = islandPackageDao;
	}
	
}
