package com.island.domain.biz;

import com.island.domain.DomainIslandModule;
import com.island.domain.dal.BrokerPpcCeilingLogIbatisDAOImpl;
import com.island.domain.model.BrokerPpcCeilingLog;
import com.jcl.core.module.ModuleRegistry;

public class TestBiz {
	
	private BrokerPpcCeilingLogIbatisDAOImpl testDao;

	public void setTestDao(BrokerPpcCeilingLogIbatisDAOImpl testDao) {
		this.testDao = testDao;
	}
	
	public void addModel(){
		BrokerPpcCeilingLog model = new BrokerPpcCeilingLog();
		model.setBrokerId(5);
		model.setCeilingDay(20140403);
		model.setSiteType(1);
		model.setUpdTime(1);
		this.testDao.insert(model);
		System.out.println(model.getId());
	}

	public static void main(String arg[]){
		TestBiz biz = ModuleRegistry.getInstance()
				.getModule(DomainIslandModule.class).getTestBiz();
		biz.addModel();
	}
}
