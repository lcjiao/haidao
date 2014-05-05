package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.AreaMapper;
import com.island.domain.model.Area;

public class AreaIbatisDAOImpl extends AbsiBatisDAOImpl<Area> {
	static {
		SqlmapUtils.addMapper(AreaMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Area> getModelCls() {
		
		return Area.class;
	}
	@Override
	public Class<AreaMapper> getMapperCls() {
		
		return AreaMapper.class;
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
