package com.island.domain.biz;


import org.apache.commons.configuration.Configuration;

import com.jcl.core.config.AbsCfgListener;

public class ConfBiz extends AbsCfgListener{
	private  Configuration config;
	
	public  String getValue(String key){
		return config.getString(key);
	}
	@Override
	public void load() {
		config = this.getDependencyConfig().get(0);
	}
	

}
