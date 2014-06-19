package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.GlobalQaMapper;
import com.island.domain.model.GlobalQa;

public class GlobalQaIbatisDAOImpl extends AbsiBatisDAOImpl<GlobalQa> {
	static {
		SqlmapUtils.addMapper(GlobalQaMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<GlobalQa> getModelCls() {
		
		return GlobalQa.class;
	}
	@Override
	public Class<GlobalQaMapper> getMapperCls() {
		
		return GlobalQaMapper.class;
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
