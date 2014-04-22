package com.island.domain.dal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SessionException;
import org.apache.ibatis.session.SqlSession;

import com.jcl.core.dal.datasource.DataSourceDefinition;
import com.jcl.core.dal.ibatis.AbsiBatisDAOImpl;
import com.jcl.core.dal.ibatis.SqlmapUtils;
import com.island.domain.dal.mapper.MenuMapper;
import com.island.domain.model.Menu;

public class MenuIbatisDAOImpl extends AbsiBatisDAOImpl<Menu> {
	static {
		SqlmapUtils.addMapper(MenuMapper.class,DataSourceDefinition.HAIDAO_DB);
    }
    @Override
	public Class<Menu> getModelCls() {
		
		return Menu.class;
	}
	@Override
	public Class<MenuMapper> getMapperCls() {
		
		return MenuMapper.class;
	}
	
	@Override
	public DataSourceDefinition getDefWriteDB() {		
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	@Override
	public DataSourceDefinition getDefQueryDB() {
		return DataSourceDefinition.HAIDAO_DB;
	}
	
	public List<Menu> queryByIds(Map<String,Object> params){
		SqlSession session = SqlmapUtils.openSession(DataSourceDefinition.HAIDAO_DB);
		try {
			MenuMapper mapper = session.getMapper(MenuMapper.class);
			return mapper.queryByIds(params);
		} catch (SessionException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.commit();
			session.close();
		}

	}
}
