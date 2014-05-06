package com.island.domain.dal.mapper;


import java.util.Map;

import com.jcl.core.dal.ibatis.mapper.IMapper;
import com.island.domain.model.Island;

public interface IslandMapper extends IMapper<Island>{

	public void updateByAreaId(Map<String,Object> params);
}
