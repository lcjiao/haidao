package com.islandback.web.util;

import com.island.domain.util.AsynBizExecutor;

public class Test {

	public static void main(String[] args) {
		System.out.println("test begin");
		new AsynBizExecutor("test", true){
			@Override
			public void execute() {
				long start = System.currentTimeMillis();
				try {
					todo();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long end = System.currentTimeMillis();
				_logger.info("clear prop cache in addPpcProp use:"+(end - start));
			}
		};
		System.out.println("test end");

	}
	
	public static void todo() throws InterruptedException{
		System.out.println("todo begin");
		Thread.sleep(10000);
		System.out.println("todo end");
	}

}
