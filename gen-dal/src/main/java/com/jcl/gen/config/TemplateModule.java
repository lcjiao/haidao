package com.jcl.gen.config;

import org.apache.commons.configuration.Configuration;

import com.jcl.core.module.annotation.Bean;

public interface TemplateModule {
	@Bean("configuration")
	public Configuration getConfig();

	@Bean("templateFactory")
	public TemplateFactoryBean getTemplateFactoryBean();
}
