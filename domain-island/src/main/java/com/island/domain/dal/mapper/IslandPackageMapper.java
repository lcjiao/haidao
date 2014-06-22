package com.island.domain.dal.mapper;


import java.util.Map;

import com.jcl.core.dal.ibatis.mapper.IMapper;
import com.island.domain.model.IslandPackage;

public interface IslandPackageMapper extends IMapper<IslandPackage>{
	public void updateByAreaIsland(Map<String,Object> params);
	public void updateByType(Map<String,Object> params);
}
