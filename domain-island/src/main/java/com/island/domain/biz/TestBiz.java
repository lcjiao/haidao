package com.island.domain.biz;

import org.apache.commons.configuration.Configuration;

import com.jcl.core.config.AbsCfgListener;
import com.island.domain.DomainIslandModule;
import com.island.domain.dal.BrokerPpcCeilingLogIbatisDAOImpl;
import com.island.domain.model.BrokerPpcCeilingLog;
import com.jcl.core.module.ModuleRegistry;

public class TestBiz extends AbsCfgListener{
	
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
	
	public void testConf(){
		for(int i=0;i<100;i++){
			System.out.println("index"+i+",confValue:"+confValue);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String arg[]){
		TestBiz biz = ModuleRegistry.getInstance()
				.getModule(DomainIslandModule.class).getTestBiz();
		biz.testConf();
	}

	private String confValue;
	@Override
	public void load() {
		Configuration config = this.getDependencyConfig().get(0);

		confValue = config
				.getString("test_conf");
	}
}
