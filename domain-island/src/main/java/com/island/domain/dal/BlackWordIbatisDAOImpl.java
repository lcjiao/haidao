package com.island.domain.dal;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.BlackWordMapper;
import com.island.domain.model.BlackWord;

public class BlackWordIbatisDAOImpl extends AbsiBatisDAOImpl<BlackWord> {
	static {
		SqlmapUtils.addMapper(BlackWordMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<BlackWord> getModelCls() {
		
		return BlackWord.class;
	}
	@Override
	public Class<BlackWordMapper> getMapperCls() {
		
		return BlackWordMapper.class;
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
