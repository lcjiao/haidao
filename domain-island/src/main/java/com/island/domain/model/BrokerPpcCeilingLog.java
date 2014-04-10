package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class BrokerPpcCeilingLog extends AbsModel{

	public String get(){
		return "haidao_db.test_tab";
	}

  	private Integer brokerId=Integer.parseInt("0");
  	public void setBrokerId(Integer brokerId){
  		this.brokerId=brokerId;
  	}
  	public Integer getBrokerId(){
  		return this.brokerId;
  	}
  	private Integer ceilingDay=Integer.parseInt("0");
  	public void setCeilingDay(Integer ceilingDay){
  		this.ceilingDay=ceilingDay;
  	}
  	public Integer getCeilingDay(){
  		return this.ceilingDay;
  	}
  	private Integer siteType=Integer.parseInt("0");
  	public void setSiteType(Integer siteType){
  		this.siteType=siteType;
  	}
  	public Integer getSiteType(){
  		return this.siteType;
  	}
	/**
	 * 
	 */
  	private Integer updTime=Integer.parseInt("0");
  	/**
	 * 设置
	 */
  	public void setUpdTime(Integer updTime){
  		this.updTime=updTime;
  	}
  	/**
	 * 获取
	 */
  	public Integer getUpdTime(){
  		return this.updTime;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
