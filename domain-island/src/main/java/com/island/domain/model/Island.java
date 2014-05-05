package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class Island extends AbsModel{

	public String get(){
		return "haidao_db.island";
	}

	/**
	 * 归属区域编号
	 */
  	private Integer areaId;
  	/**
	 * 设置归属区域编号
	 */
  	public void setAreaId(Integer areaId){
  		this.areaId=areaId;
  	}
  	/**
	 * 获取归属区域编号
	 */
  	public Integer getAreaId(){
  		return this.areaId;
  	}
  	/**
	 * 岛屿名称
	 */
  	private String name;
  	/**
	 * 设置岛屿名称
	 */
  	public void setName(String name){
  		this.name=name;
  	}
  	/**
	 * 获取岛屿名称
	 */
  	public String getName(){
  		return this.name;
  	}
  	/**
	 * 归属国家
	 */
  	private String country;
  	/**
	 * 设置归属国家
	 */
  	public void setCountry(String country){
  		this.country=country;
  	}
  	/**
	 * 获取归属国家
	 */
  	public String getCountry(){
  		return this.country;
  	}
	/**
	 * 是否有效 1有效  0无效
	 */
  	private Integer valid;
  	/**
	 * 设置是否有效 1有效  0无效
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取是否有效 1有效  0无效
	 */
  	public Integer getValid(){
  		return this.valid;
  	}
	/**
	 * 创建时间
	 */
  	private Integer createTime;
  	/**
	 * 设置创建时间
	 */
  	public void setCreateTime(Integer createTime){
  		this.createTime=createTime;
  	}
  	/**
	 * 获取创建时间
	 */
  	public Integer getCreateTime(){
  		return this.createTime;
  	}
  	/**
	 * 创建人
	 */
  	private String createPerson;
  	/**
	 * 设置创建人
	 */
  	public void setCreatePerson(String createPerson){
  		this.createPerson=createPerson;
  	}
  	/**
	 * 获取创建人
	 */
  	public String getCreatePerson(){
  		return this.createPerson;
  	}
	/**
	 * 更新时间
	 */
  	private Integer updTime;
  	/**
	 * 设置更新时间
	 */
  	public void setUpdTime(Integer updTime){
  		this.updTime=updTime;
  	}
  	/**
	 * 获取更新时间
	 */
  	public Integer getUpdTime(){
  		return this.updTime;
  	}
  	/**
	 * 更新人
	 */
  	private String updPerson;
  	/**
	 * 设置更新人
	 */
  	public void setUpdPerson(String updPerson){
  		this.updPerson=updPerson;
  	}
  	/**
	 * 获取更新人
	 */
  	public String getUpdPerson(){
  		return this.updPerson;
  	}
  	/**
	 * 岛屿描述
	 */
  	private String islandDesc;
  	/**
	 * 设置岛屿描述
	 */
  	public void setIslandDesc(String islandDesc){
  		this.islandDesc=islandDesc;
  	}
  	/**
	 * 获取岛屿描述
	 */
  	public String getIslandDesc(){
  		return this.islandDesc;
  	}
  	/**
	 * 区域名称
	 */
  	private String areaName;
  	/**
	 * 设置区域名称
	 */
  	public void setAreaName(String areaName){
  		this.areaName=areaName;
  	}
  	/**
	 * 获取区域名称
	 */
  	public String getAreaName(){
  		return this.areaName;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
