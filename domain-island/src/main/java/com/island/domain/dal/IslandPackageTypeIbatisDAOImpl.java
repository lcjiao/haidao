package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
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
}
