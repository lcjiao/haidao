package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.GlobalQaTypeMapper;
import com.island.domain.model.GlobalQaType;

public class GlobalQaTypeIbatisDAOImpl extends AbsiBatisDAOImpl<GlobalQaType> {
	static {
		SqlmapUtils.addMapper(GlobalQaTypeMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<GlobalQaType> getModelCls() {
		
		return GlobalQaType.class;
	}
	@Override
	public Class<GlobalQaTypeMapper> getMapperCls() {
		
		return GlobalQaTypeMapper.class;
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
