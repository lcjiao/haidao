package com.island.domain.dal.mapper;


import java.util.Map;

import com.jcl.core.dal.ibatis.mapper.IMapper;
import com.island.domain.model.User;

public interface UserMapper extends IMapper<User>{

	public Integer queryUserCount(Map<String,Object> params);
	
	public void updateByRoleId(Map<String,Object> params);
}
