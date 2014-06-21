package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class PhotoSubscribe extends AbsModel{

	public String get(){
		return "haidao_db.photo_subscribe";
	}

	/**
	 * 类型id 1、团队2、摄影师3、化妆师4、影片师
	 */
  	private Integer typeId;
  	/**
	 * 设置类型id 1、团队2、摄影师3、化妆师4、影片师
	 */
  	public void setTypeId(Integer typeId){
  		this.typeId=typeId;
  	}
  	/**
	 * 获取类型id 1、团队2、摄影师3、化妆师4、影片师
	 */
  	public Integer getTypeId(){
  		return this.typeId;
  	}
  	/**
	 * 类型名称
	 */
  	private String typeName;
  	/**
	 * 设置类型名称
	 */
  	public void setTypeName(String typeName){
  		this.typeName=typeName;
  	}
  	/**
	 * 获取类型名称
	 */
  	public String getTypeName(){
  		return this.typeName;
  	}
  	/**
	 * 名称1
	 */
  	private String strnamef;
  	/**
	 * 设置名称1
	 */
  	public void setStrnamef(String strnamef){
  		this.strnamef=strnamef;
  	}
  	/**
	 * 获取名称1
	 */
  	public String getStrnamef(){
  		return this.strnamef;
  	}
  	/**
	 * 名称2
	 */
  	private String strnamet;
  	/**
	 * 设置名称2
	 */
  	public void setStrnamet(String strnamet){
  		this.strnamet=strnamet;
  	}
  	/**
	 * 获取名称2
	 */
  	public String getStrnamet(){
  		return this.strnamet;
  	}
  	/**
	 * 职位ID
	 */
  	private String positionId;
  	/**
	 * 设置职位ID
	 */
  	public void setPositionId(String positionId){
  		this.positionId=positionId;
  	}
  	/**
	 * 获取职位ID
	 */
  	public String getPositionId(){
  		return this.positionId;
  	}
  	/**
	 * 职位名称
	 */
  	private String positionName;
  	/**
	 * 设置职位名称
	 */
  	public void setPositionName(String positionName){
  		this.positionName=positionName;
  	}
  	/**
	 * 获取职位名称
	 */
  	public String getPositionName(){
  		return this.positionName;
  	}
	/**
	 * 可预约开始时间
	 */
  	private Integer startTime;
  	/**
	 * 设置可预约开始时间
	 */
  	public void setStartTime(Integer startTime){
  		this.startTime=startTime;
  	}
  	/**
	 * 获取可预约开始时间
	 */
  	public Integer getStartTime(){
  		return this.startTime;
  	}
	/**
	 * 可预约结束时间
	 */
  	private Integer endTime;
  	/**
	 * 设置可预约结束时间
	 */
  	public void setEndTime(Integer endTime){
  		this.endTime=endTime;
  	}
  	/**
	 * 获取可预约结束时间
	 */
  	public Integer getEndTime(){
  		return this.endTime;
  	}
  	/**
	 * 图片url
	 */
  	private String imgUrl;
  	/**
	 * 设置图片url
	 */
  	public void setImgUrl(String imgUrl){
  		this.imgUrl=imgUrl;
  	}
  	/**
	 * 获取图片url
	 */
  	public String getImgUrl(){
  		return this.imgUrl;
  	}
  	/**
	 * 图片link
	 */
  	private String imgLink;
  	/**
	 * 设置图片link
	 */
  	public void setImgLink(String imgLink){
  		this.imgLink=imgLink;
  	}
  	/**
	 * 获取图片link
	 */
  	public String getImgLink(){
  		return this.imgLink;
  	}
	/**
	 * 是否有效
	 */
  	private Integer valid;
  	/**
	 * 设置是否有效
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取是否有效
	 */
  	public Integer getValid(){
  		return this.valid;
  	}
	/**
	 * 创建时间
	 */
  	private Integer createtime;
  	/**
	 * 设置创建时间
	 */
  	public void setCreatetime(Integer createtime){
  		this.createtime=createtime;
  	}
  	/**
	 * 获取创建时间
	 */
  	public Integer getCreatetime(){
  		return this.createtime;
  	}
  	/**
	 * 创建人
	 */
  	private String createperson;
  	/**
	 * 设置创建人
	 */
  	public void setCreateperson(String createperson){
  		this.createperson=createperson;
  	}
  	/**
	 * 获取创建人
	 */
  	public String getCreateperson(){
  		return this.createperson;
  	}
	/**
	 * 更新时间
	 */
  	private Integer updtime;
  	/**
	 * 设置更新时间
	 */
  	public void setUpdtime(Integer updtime){
  		this.updtime=updtime;
  	}
  	/**
	 * 获取更新时间
	 */
  	public Integer getUpdtime(){
  		return this.updtime;
  	}
  	/**
	 * 更新人
	 */
  	private String updperson;
  	/**
	 * 设置更新人
	 */
  	public void setUpdperson(String updperson){
  		this.updperson=updperson;
  	}
  	/**
	 * 获取更新人
	 */
  	public String getUpdperson(){
  		return this.updperson;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
