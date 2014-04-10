package com.island.domain;

import com.island.domain.biz.TestBiz;
import com.jcl.core.module.annotation.Bean;

public interface DomainIslandModule {

	@Bean("testBiz")
	public TestBiz getTestBiz();

	

}