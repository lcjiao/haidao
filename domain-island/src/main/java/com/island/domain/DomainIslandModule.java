package com.island.domain;

import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.FrontIndexBiz;
import com.island.domain.biz.RoleBiz;
import com.jcl.core.module.annotation.Bean;

public interface DomainIslandModule {

	@Bean("roleBiz")
	public RoleBiz getRoleBiz();
	
	@Bean("frontIndexBiz")
	public FrontIndexBiz getFrontIndexBiz();

	@Bean("areaIslandBiz")
	public AreaIslandBiz getAreaIslandBiz();

	

}