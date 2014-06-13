package com.island.domain.dal;

import com.island.domain.dal.mapper.PackageQaMapper;
import com.island.domain.model.PackageQa;
import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;

public class PackageQaIbatisDAOImpl extends AbsiBatisDAOImpl<PackageQa> {
	static {
		SqlmapUtils.addMapper(PackageQaMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<PackageQa> getModelCls() {
		
		return PackageQa.class;
	}
	@Override
	public Class<PackageQaMapper> getMapperCls() {
		
		return PackageQaMapper.class;
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
