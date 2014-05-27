package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class IslandPackageType extends AbsModel{

	public String get(){
		return "haidao_db.island_package_type";
	}

	/**
	 * 套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐 6:客户案例图片  7:客户案例视频
	 */
  	private Integer packageType;
  	/**
	 * 设置套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐 6:客户案例图片  7:客户案例视频
	 */
  	public void setPackageType(Integer packageType){
  		this.packageType=packageType;
  	}
  	/**
	 * 获取套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐 6:客户案例图片  7:客户案例视频
	 */
  	public Integer getPackageType(){
  		return this.packageType;
  	}
  	/**
	 * 类别名称
	 */
  	private String title;
  	/**
	 * 设置类别名称
	 */
  	public void setTitle(String title){
  		this.title=title;
  	}
  	/**
	 * 获取类别名称
	 */
  	public String getTitle(){
  		return this.title;
  	}
	/**
	 * 区域编号
	 */
  	private Integer areaId;
  	/**
	 * 设置区域编号
	 */
  	public void setAreaId(Integer areaId){
  		this.areaId=areaId;
  	}
  	/**
	 * 获取区域编号
	 */
  	public Integer getAreaId(){
  		return this.areaId;
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
	 * 岛屿编号
	 */
  	private Integer islandId;
  	/**
	 * 设置岛屿编号
	 */
  	public void setIslandId(Integer islandId){
  		this.islandId=islandId;
  	}
  	/**
	 * 获取岛屿编号
	 */
  	public Integer getIslandId(){
  		return this.islandId;
  	}
  	/**
	 * 岛屿名称
	 */
  	private String islandName;
  	/**
	 * 设置岛屿名称
	 */
  	public void setIslandName(String islandName){
  		this.islandName=islandName;
  	}
  	/**
	 * 获取岛屿名称
	 */
  	public String getIslandName(){
  		return this.islandName;
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
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
