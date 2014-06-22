package com.island.domain.dal.mapper;


import java.util.Map;

import com.jcl.core.dal.ibatis.mapper.IMapper;
import com.island.domain.model.IslandPackageType;

public interface IslandPackageTypeMapper extends IMapper<IslandPackageType>{
	public void updateByAreaIsland(Map<String,Object> params);
}
