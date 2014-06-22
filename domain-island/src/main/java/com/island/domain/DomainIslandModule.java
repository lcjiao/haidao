package com.island.domain;

import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.ConfBiz;
import com.island.domain.biz.CustomerCaseBiz;
import com.island.domain.biz.GlobalQaBiz;
import com.island.domain.biz.GuestQaBiz;
import com.island.domain.biz.ModuleTypeBiz;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.biz.GlobalNetBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.biz.WdpTeamBiz;
import com.island.domain.biz.WeddingPhotoBiz;
import com.island.domain.biz.RoleBiz;
import com.jcl.core.module.annotation.Bean;

public interface DomainIslandModule {

	@Bean("roleBiz")
	public RoleBiz getRoleBiz();
	
	@Bean("recommendBiz")
	public RecommendBiz getRecommendBiz();

	@Bean("areaIslandBiz")
	public AreaIslandBiz getAreaIslandBiz();

	@Bean("marrayPackageBiz")
	public MarrayPackageBiz getMarrayPackageBiz();
	
	@Bean("globalNetBiz")
	public GlobalNetBiz getGlobalNetBiz();
	
	@Bean("moduleTypeBiz")
	public ModuleTypeBiz getModuleTypeBiz();
	
	@Bean("guestQaBiz")
	public GuestQaBiz getGuestQaBiz();
	
	@Bean("confBiz")
	public ConfBiz getConfBiz();
	
	@Bean("globalQaBiz")
	public GlobalQaBiz getGlobalQaBiz();
	/**
	 * 婚纱摄影 业务类
	 * @return
	 */
	@Bean("weddingPhotoBiz")
	public WeddingPhotoBiz getWeddingPhotoBiz();
	
	/**
	 * 摄影团队(师)业务
	 */
	@Bean("wdpTeamBiz")
	public WdpTeamBiz getWdpTeamBiz();
	
	/**
	 * 客片案例业务
	 */
	@Bean("customerCaseBiz")
	public CustomerCaseBiz getCustomerCaseBiz();
	
	//test

	

}