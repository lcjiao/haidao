package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.IslandMapper;
import com.island.domain.model.Island;

public class IslandIbatisDAOImpl extends AbsiBatisDAOImpl<Island> {
	static {
		SqlmapUtils.addMapper(IslandMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Island> getModelCls() {
		
		return Island.class;
	}
	@Override
	public Class<IslandMapper> getMapperCls() {
		
		return IslandMapper.class;
	}
	
	@Override
	public DataSourceDefinition getDefWriteDB() {		
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	@Override
	public DataSourceDefinition getDefQueryDB() {
		return DataSourceDefinition.HAIDAO_DB;
	}
}
