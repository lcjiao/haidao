package com.island.domain.dal.mapper;


import java.util.List;
import java.util.Map;

import com.jcl.core.dal.ibatis.mapper.IMapper;
import com.island.domain.model.Menu;

public interface MenuMapper extends IMapper<Menu>{

	public List<Menu> queryByIds(Map<String,Object> params);
}
