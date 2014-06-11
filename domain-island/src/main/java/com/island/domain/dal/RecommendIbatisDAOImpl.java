package com.island.domain.dal;

import java.util.Map;

import org.apache.ibatis.session.SessionException;
import org.apache.ibatis.session.SqlSession;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.RecommendMapper;
import com.island.domain.dal.mapper.UserMapper;
import com.island.domain.model.Recommend;

public class RecommendIbatisDAOImpl extends AbsiBatisDAOImpl<Recommend> {
	static {
		SqlmapUtils.addMapper(RecommendMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Recommend> getModelCls() {
		
		return Recommend.class;
	}
	@Override
	public Class<RecommendMapper> getMapperCls() {
		
		return RecommendMapper.class;
	}
	
	@Override
	public DataSourceDefinition getDefWriteDB() {		
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	@Override
	public DataSourceDefinition getDefQueryDB() {
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	public void updateByAreaIsland(Map<String,Object> params){
		SqlSession session = SqlmapUtils.openSession(DataSourceDefinition.HAIDAO_DB);
		try {
			RecommendMapper mapper = session.getMapper(RecommendMapper.class);
			mapper.updateByAreaIsland(params);
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
	}
}
