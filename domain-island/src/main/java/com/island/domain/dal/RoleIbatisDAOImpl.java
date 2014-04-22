package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.RoleMapper;
import com.island.domain.model.Role;

public class RoleIbatisDAOImpl extends AbsiBatisDAOImpl<Role> {
	static {
		SqlmapUtils.addMapper(RoleMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Role> getModelCls() {
		
		return Role.class;
	}
	@Override
	public Class<RoleMapper> getMapperCls() {
		
		return RoleMapper.class;
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
