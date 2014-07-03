package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.IslandOrderMapper;
import com.island.domain.model.IslandOrder;

public class IslandOrderIbatisDAOImpl extends AbsiBatisDAOImpl<IslandOrder> {
	static {
		SqlmapUtils.addMapper(IslandOrderMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<IslandOrder> getModelCls() {
		
		return IslandOrder.class;
	}
	@Override
	public Class<IslandOrderMapper> getMapperCls() {
		
		return IslandOrderMapper.class;
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
