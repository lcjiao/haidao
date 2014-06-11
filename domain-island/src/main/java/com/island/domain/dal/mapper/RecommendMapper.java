package com.island.domain.dal.mapper;


import java.util.Map;

import com.jcl.core.dal.ibatis.mapper.IMapper;
import com.island.domain.model.Recommend;

public interface RecommendMapper extends IMapper<Recommend>{

	public void updateByAreaIsland(Map<String,Object> params);
}
