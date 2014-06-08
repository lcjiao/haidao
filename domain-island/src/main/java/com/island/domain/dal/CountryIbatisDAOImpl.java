package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.CountryMapper;
import com.island.domain.model.Country;

public class CountryIbatisDAOImpl extends AbsiBatisDAOImpl<Country> {
	static {
		SqlmapUtils.addMapper(CountryMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Country> getModelCls() {
		
		return Country.class;
	}
	@Override
	public Class<CountryMapper> getMapperCls() {
		
		return CountryMapper.class;
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
