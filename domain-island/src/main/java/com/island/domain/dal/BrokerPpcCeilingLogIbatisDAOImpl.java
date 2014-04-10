package com.island.domain.dal;

import com.island.domain.dal.mapper.BrokerPpcCeilingLogMapper;
import com.island.domain.model.BrokerPpcCeilingLog;
import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;

public class BrokerPpcCeilingLogIbatisDAOImpl extends AbsiBatisDAOImpl<BrokerPpcCeilingLog> {
	static {
		SqlmapUtils.addMapper(BrokerPpcCeilingLogMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<BrokerPpcCeilingLog> getModelCls() {
		
		return BrokerPpcCeilingLog.class;
	}
	@Override
	public Class<BrokerPpcCeilingLogMapper> getMapperCls() {
		
		return BrokerPpcCeilingLogMapper.class;
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
