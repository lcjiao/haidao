package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.IslandMapMapper;
import com.island.domain.model.IslandMap;

public class IslandMapIbatisDAOImpl extends AbsiBatisDAOImpl<IslandMap> {
	static {
		SqlmapUtils.addMapper(IslandMapMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<IslandMap> getModelCls() {
		
		return IslandMap.class;
	}
	@Override
	public Class<IslandMapMapper> getMapperCls() {
		
		return IslandMapMapper.class;
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
