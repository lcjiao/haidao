package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.CasePicMappingMapper;
import com.island.domain.model.CasePicMapping;

public class CasePicMappingIbatisDAOImpl extends AbsiBatisDAOImpl<CasePicMapping> {
	static {
		SqlmapUtils.addMapper(CasePicMappingMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<CasePicMapping> getModelCls() {
		
		return CasePicMapping.class;
	}
	@Override
	public Class<CasePicMappingMapper> getMapperCls() {
		
		return CasePicMappingMapper.class;
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
