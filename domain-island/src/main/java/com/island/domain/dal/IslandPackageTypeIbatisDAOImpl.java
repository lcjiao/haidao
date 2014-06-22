package com.island.domain.dal;

import java.util.Map;

import org.apache.ibatis.session.SessionException;
import org.apache.ibatis.session.SqlSession;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.IslandPackageMapper;
import com.island.domain.dal.mapper.IslandPackageTypeMapper;
import com.island.domain.model.IslandPackageType;

public class IslandPackageTypeIbatisDAOImpl extends AbsiBatisDAOImpl<IslandPackageType> {
	static {
		SqlmapUtils.addMapper(IslandPackageTypeMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<IslandPackageType> getModelCls() {
		
		return IslandPackageType.class;
	}
	@Override
	public Class<IslandPackageTypeMapper> getMapperCls() {
		
		return IslandPackageTypeMapper.class;
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
			IslandPackageTypeMapper mapper = session.getMapper(IslandPackageTypeMapper.class);
			mapper.updateByAreaIsland(params);
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
	}
	
	

}
