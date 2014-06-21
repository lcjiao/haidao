package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.WorkTeamMapper;
import com.island.domain.model.WorkTeam;

public class WorkTeamIbatisDAOImpl extends AbsiBatisDAOImpl<WorkTeam> {
	static {
		SqlmapUtils.addMapper(WorkTeamMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<WorkTeam> getModelCls() {
		
		return WorkTeam.class;
	}
	@Override
	public Class<WorkTeamMapper> getMapperCls() {
		
		return WorkTeamMapper.class;
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
