package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class IslandMap extends AbsModel{

	public String get(){
		return "haidao_db.island_map";
	}

	/**
	 * 套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐
	 */
  	private Integer packageType;
  	/**
	 * 设置套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐
	 */
  	public void setPackageType(Integer packageType){
  		this.packageType=packageType;
  	}
  	/**
	 * 获取套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐
	 */
  	public Integer getPackageType(){
  		return this.packageType;
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
	 * 地图背景大图
	 */
  	private String mapBigImg;
  	/**
	 * 设置地图背景大图
	 */
  	public void setMapBigImg(String mapBigImg){
  		this.mapBigImg=mapBigImg;
  	}
  	/**
	 * 获取地图背景大图
	 */
  	public String getMapBigImg(){
  		return this.mapBigImg;
  	}
  	/**
	 * 地图背景小图
	 */
  	private String mapSmallImg;
  	/**
	 * 设置地图背景小图
	 */
  	public void setMapSmallImg(String mapSmallImg){
  		this.mapSmallImg=mapSmallImg;
  	}
  	/**
	 * 获取地图背景小图
	 */
  	public String getMapSmallImg(){
  		return this.mapSmallImg;
  	}
  	/**
	 * left距离
	 */
  	private String mapLeft;
  	/**
	 * 设置left距离
	 */
  	public void setMapLeft(String mapLeft){
  		this.mapLeft=mapLeft;
  	}
  	/**
	 * 获取left距离
	 */
  	public String getMapLeft(){
  		return this.mapLeft;
  	}
  	/**
	 * top距离
	 */
  	private String mapTop;
  	/**
	 * 设置top距离
	 */
  	public void setMapTop(String mapTop){
  		this.mapTop=mapTop;
  	}
  	/**
	 * 获取top距离
	 */
  	public String getMapTop(){
  		return this.mapTop;
  	}
  	/**
	 * 链接
	 */
  	private String linkUrl;
  	/**
	 * 设置链接
	 */
  	public void setLinkUrl(String linkUrl){
  		this.linkUrl=linkUrl;
  	}
  	/**
	 * 获取链接
	 */
  	public String getLinkUrl(){
  		return this.linkUrl;
  	}
  	/**
	 * 描述
	 */
  	private String mapDesc;
  	/**
	 * 设置描述
	 */
  	public void setMapDesc(String mapDesc){
  		this.mapDesc=mapDesc;
  	}
  	/**
	 * 获取描述
	 */
  	public String getMapDesc(){
  		return this.mapDesc;
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
