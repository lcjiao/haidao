package com.jcl.gen.config;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import com.jcl.core.logging.Logger;
import com.jcl.core.logging.LoggerFactory;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;

public class TemplateFactoryBean extends Configuration implements
		InitializingBean, FactoryBean, ApplicationContextAware {
	
	private TemplateLoader temp;
	private String path;

	public void setPath(String path) {
		this.path = path;
	}

	private ApplicationContext _context;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this._context = applicationContext;
	}

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return TemplateFactoryBean.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean _throwExceptionOnMissing = false;

	public void setThrowExceptionOnMissing(boolean value) {
		_throwExceptionOnMissing = value;
	}

	private String encoding;

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		Assert.hasLength(path);
		if(path.startsWith("file:")){
			path = path.substring(5);
			this.setTemplateLoader(new FileTemplateLoader(new File(path)));
		}
		else if(path.startsWith("classpath:")){
			path = path.substring(10);
			this.setTemplateLoader(new ClassTemplateLoader(TemplateFactoryBean.class,path));
		}
	}

	private transient static Logger _logger = LoggerFactory
			.getLogger(TemplateFactoryBean.class);
}
