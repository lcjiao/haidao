package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.WorkmanMapper;
import com.island.domain.model.Workman;

public class WorkmanIbatisDAOImpl extends AbsiBatisDAOImpl<Workman> {
	static {
		SqlmapUtils.addMapper(WorkmanMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Workman> getModelCls() {
		
		return Workman.class;
	}
	@Override
	public Class<WorkmanMapper> getMapperCls() {
		
		return WorkmanMapper.class;
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
