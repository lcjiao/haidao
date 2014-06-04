package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.CaseVideoMappingMapper;
import com.island.domain.model.CaseVideoMapping;

public class CaseVideoMappingIbatisDAOImpl extends AbsiBatisDAOImpl<CaseVideoMapping> {
	static {
		SqlmapUtils.addMapper(CaseVideoMappingMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<CaseVideoMapping> getModelCls() {
		
		return CaseVideoMapping.class;
	}
	@Override
	public Class<CaseVideoMappingMapper> getMapperCls() {
		
		return CaseVideoMappingMapper.class;
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
