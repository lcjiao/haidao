package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.RoleRightMapper;
import com.island.domain.model.RoleRight;

public class RoleRightIbatisDAOImpl extends AbsiBatisDAOImpl<RoleRight> {
	static {
		SqlmapUtils.addMapper(RoleRightMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<RoleRight> getModelCls() {
		
		return RoleRight.class;
	}
	@Override
	public Class<RoleRightMapper> getMapperCls() {
		
		return RoleRightMapper.class;
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
