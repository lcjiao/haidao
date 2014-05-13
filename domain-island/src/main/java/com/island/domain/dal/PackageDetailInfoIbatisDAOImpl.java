package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.PackageDetailInfoMapper;
import com.island.domain.model.PackageDetailInfo;

public class PackageDetailInfoIbatisDAOImpl extends AbsiBatisDAOImpl<PackageDetailInfo> {
	static {
		SqlmapUtils.addMapper(PackageDetailInfoMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<PackageDetailInfo> getModelCls() {
		
		return PackageDetailInfo.class;
	}
	@Override
	public Class<PackageDetailInfoMapper> getMapperCls() {
		
		return PackageDetailInfoMapper.class;
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
