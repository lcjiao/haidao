package com.islandback.action.order;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.anjuke.core.util.ObjectUtils;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.OrderBiz;
import com.jcl.core.module.ModuleRegistry;
import com.island.domain.model.IslandOrder;
import com.islandback.action.base.BaseAction;
import com.islandback.module.Page;


@Namespace("/order")
@ResultPath("/WEB-INF")
public class OrderAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private IslandOrder order;
	
	
	private List<IslandOrder> orderList = new ArrayList<IslandOrder>(0);
	
	OrderBiz orderBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getOrderBiz();
	
	
	public String tolist(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		
		if( order != null  ){
			if( ! ObjectUtils.isEmpty(order.getWedName())  ){
				params.put("webName", "%"+order.getWedName()+"%");
			}
			if(  ! ObjectUtils.isEmpty(order.getTel())){
				params.put("tel", "%"+order.getTel()+"%");
			}
			if(! ObjectUtils.isEmpty(order.getQq()) ){
				params.put("qq", "%"+order.getQq()+"%");
			}
			if( ! ObjectUtils.isEmpty(order.getMail()) ){
				params.put("mail", "%"+order.getMail()+"%");
			}

		}
		orderList = orderBiz.queryOrderByMap(params);
		if(orderList != null && orderList.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			
			if( order != null  ){
				if( ! ObjectUtils.isEmpty(order.getWedName())  ){
					countParam.put("webName", "%"+order.getWedName()+"%");
				}
				if(  ! ObjectUtils.isEmpty(order.getTel())){
					countParam.put("tel", "%"+order.getTel()+"%");
				}
				if(! ObjectUtils.isEmpty(order.getQq()) ){
					countParam.put("qq", "%"+order.getQq()+"%");
				}
				if( ! ObjectUtils.isEmpty(order.getMail()) ){
					countParam.put("mail", "%"+order.getMail()+"%");
				}

			}
			
			this.totalSize = orderBiz.countOrderByMap(params);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		
		return "list";
	}
	
	private void initTotalPageSize(){
		if(totalSize % pageSize == 0 ){
			this.totalPageSize = totalSize / pageSize;
		}else{
			this.totalPageSize = ( totalSize / pageSize )+ 1;
		}
		
	}
	
	public String detail(){
		order = this.orderBiz.queryOrderById(id);
		return "detail";
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(Integer totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public IslandOrder getOrder() {
		return order;
	}

	public void setOrder(IslandOrder order) {
		this.order = order;
	}

	public List<IslandOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<IslandOrder> orderList) {
		this.orderList = orderList;
	}

	
	
	
	
}
