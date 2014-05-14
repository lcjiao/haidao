package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.PackageImageRelationMapper;
import com.island.domain.model.PackageImageRelation;

public class PackageImageRelationIbatisDAOImpl extends AbsiBatisDAOImpl<PackageImageRelation> {
	static {
		SqlmapUtils.addMapper(PackageImageRelationMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<PackageImageRelation> getModelCls() {
		
		return PackageImageRelation.class;
	}
	@Override
	public Class<PackageImageRelationMapper> getMapperCls() {
		
		return PackageImageRelationMapper.class;
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
