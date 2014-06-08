package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.CustomerCaseMapper;
import com.island.domain.model.CustomerCase;

public class CustomerCaseIbatisDAOImpl extends AbsiBatisDAOImpl<CustomerCase> {
	static {
		SqlmapUtils.addMapper(CustomerCaseMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<CustomerCase> getModelCls() {
		
		return CustomerCase.class;
	}
	@Override
	public Class<CustomerCaseMapper> getMapperCls() {
		
		return CustomerCaseMapper.class;
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
