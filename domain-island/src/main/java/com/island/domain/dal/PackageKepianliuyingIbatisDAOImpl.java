package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.PackageKepianliuyingMapper;
import com.island.domain.model.PackageKepianliuying;

public class PackageKepianliuyingIbatisDAOImpl extends AbsiBatisDAOImpl<PackageKepianliuying> {
	static {
		SqlmapUtils.addMapper(PackageKepianliuyingMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<PackageKepianliuying> getModelCls() {
		
		return PackageKepianliuying.class;
	}
	@Override
	public Class<PackageKepianliuyingMapper> getMapperCls() {
		
		return PackageKepianliuyingMapper.class;
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
