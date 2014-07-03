package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import com.island.domain.model.IslandOrder;
import com.island.domain.dal.IslandOrderIbatisDAOImpl;

public class OrderBiz {

	private IslandOrderIbatisDAOImpl  orderDao;

	public IslandOrderIbatisDAOImpl getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IslandOrderIbatisDAOImpl orderDao) {
		this.orderDao = orderDao;
	}
	
	public List<IslandOrder> queryOrderByMap(Map<String,Object> params){
		return this.orderDao.queryByMap(params);
	}
	
	public Integer countOrderByMap(Map<String,Object> params){
		return this.orderDao.countByMap(params);
	}
	
	public IslandOrder queryOrderById(Integer id){
		return this.orderDao.queryById(id);
	}
	
}
