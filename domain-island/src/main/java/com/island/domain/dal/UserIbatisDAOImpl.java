package com.island.domain.dal;

import java.util.Map;

import org.apache.ibatis.session.SessionException;
import org.apache.ibatis.session.SqlSession;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.MenuMapper;
import com.island.domain.dal.mapper.UserMapper;
import com.island.domain.model.User;

public class UserIbatisDAOImpl extends AbsiBatisDAOImpl<User> {
	static {
		SqlmapUtils.addMapper(UserMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<User> getModelCls() {
		
		return User.class;
	}
	@Override
	public Class<UserMapper> getMapperCls() {
		
		return UserMapper.class;
	}
	
	@Override
	public DataSourceDefinition getDefWriteDB() {		
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	@Override
	public DataSourceDefinition getDefQueryDB() {
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	public Integer queryUserCount(Map<String,Object> params){
		SqlSession session = SqlmapUtils.openSession(DataSourceDefinition.HAIDAO_DB);
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.queryUserCount(params);
		} catch (SessionException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public void updateByRoleId(Map<String,Object> params){
		SqlSession session = SqlmapUtils.openSession(DataSourceDefinition.HAIDAO_DB);
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.updateByRoleId(params);
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
	}
}
