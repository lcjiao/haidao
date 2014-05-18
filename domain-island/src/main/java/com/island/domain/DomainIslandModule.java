package com.island.domain;

import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.FrontIndexBiz;
import com.island.domain.biz.GlobalNetBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.biz.WeddingPhotoBiz;
import com.island.domain.biz.RoleBiz;
import com.jcl.core.module.annotation.Bean;

public interface DomainIslandModule {

	@Bean("roleBiz")
	public RoleBiz getRoleBiz();
	
	@Bean("frontIndexBiz")
	public FrontIndexBiz getFrontIndexBiz();

	@Bean("areaIslandBiz")
	public AreaIslandBiz getAreaIslandBiz();

	@Bean("marrayPackageBiz")
	public MarrayPackageBiz getMarrayPackageBiz();
	
	@Bean("globalNetBiz")
	public GlobalNetBiz getGlobalNetBiz();
	/**
	 * 婚纱摄影 业务类
	 * @return
	 */
	@Bean("weddingPhotoBiz")
	public WeddingPhotoBiz getWeddingPhotoBiz();
	
	//test

	

}