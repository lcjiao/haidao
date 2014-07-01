package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.ImageMapper;
import com.island.domain.model.Image;

public class ImageIbatisDAOImpl extends AbsiBatisDAOImpl<Image> {
	static {
		SqlmapUtils.addMapper(ImageMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Image> getModelCls() {
		
		return Image.class;
	}
	@Override
	public Class<ImageMapper> getMapperCls() {
		
		return ImageMapper.class;
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
