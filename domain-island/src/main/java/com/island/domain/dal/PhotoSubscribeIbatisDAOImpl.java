package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.PhotoSubscribeMapper;
import com.island.domain.model.PhotoSubscribe;

public class PhotoSubscribeIbatisDAOImpl extends AbsiBatisDAOImpl<PhotoSubscribe> {
	static {
		SqlmapUtils.addMapper(PhotoSubscribeMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<PhotoSubscribe> getModelCls() {
		
		return PhotoSubscribe.class;
	}
	@Override
	public Class<PhotoSubscribeMapper> getMapperCls() {
		
		return PhotoSubscribeMapper.class;
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
