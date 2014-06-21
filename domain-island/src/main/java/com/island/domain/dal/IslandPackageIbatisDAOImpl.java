package com.island.domain.dal;

import java.util.Map;

import org.apache.ibatis.session.SessionException;
import org.apache.ibatis.session.SqlSession;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.IslandPackageMapper;
import com.island.domain.dal.mapper.RecommendMapper;
import com.island.domain.model.IslandPackage;

public class IslandPackageIbatisDAOImpl extends AbsiBatisDAOImpl<IslandPackage> {
	static {
		SqlmapUtils.addMapper(IslandPackageMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<IslandPackage> getModelCls() {
		
		return IslandPackage.class;
	}
	@Override
	public Class<IslandPackageMapper> getMapperCls() {
		
		return IslandPackageMapper.class;
	}
	
	@Override
	public DataSourceDefinition getDefWriteDB() {		
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	@Override
	public DataSourceDefinition getDefQueryDB() {
		return DataSourceDefinition.HAIDAO_DB;
	}
	public void updateByAreaIsland(Map<String,Object> params){
		SqlSession session = SqlmapUtils.openSession(DataSourceDefinition.HAIDAO_DB);
		try {
			IslandPackageMapper mapper = session.getMapper(IslandPackageMapper.class);
			mapper.updateByAreaIsland(params);
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
	}
	public void updateByType(Map<String,Object> params){
		SqlSession session = SqlmapUtils.openSession(DataSourceDefinition.HAIDAO_DB);
		try {
			IslandPackageMapper mapper = session.getMapper(IslandPackageMapper.class);
			mapper.updateByType(params);
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
	}
}
