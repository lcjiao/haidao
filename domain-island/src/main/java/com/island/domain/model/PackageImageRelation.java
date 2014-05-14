package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class PackageImageRelation extends AbsModel{

	public String get(){
		return "haidao_db.package_image_relation";
	}

	/**
	 * 套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	 */
  	private Integer packageType;
  	/**
	 * 设置套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	 */
  	public void setPackageType(Integer packageType){
  		this.packageType=packageType;
  	}
  	/**
	 * 获取套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	 */
  	public Integer getPackageType(){
  		return this.packageType;
  	}
	/**
	 * 套餐编号
	 */
  	private Integer packageId;
  	/**
	 * 设置套餐编号
	 */
  	public void setPackageId(Integer packageId){
  		this.packageId=packageId;
  	}
  	/**
	 * 获取套餐编号
	 */
  	public Integer getPackageId(){
  		return this.packageId;
  	}
	/**
	 * 图片编号
	 */
  	private Integer imgId;
  	/**
	 * 设置图片编号
	 */
  	public void setImgId(Integer imgId){
  		this.imgId=imgId;
  	}
  	/**
	 * 获取图片编号
	 */
  	public Integer getImgId(){
  		return this.imgId;
  	}
	/**
	 * 图片类型
	 */
  	private Integer imgType;
  	/**
	 * 设置图片类型
	 */
  	public void setImgType(Integer imgType){
  		this.imgType=imgType;
  	}
  	/**
	 * 获取图片类型
	 */
  	public Integer getImgType(){
  		return this.imgType;
  	}
  	/**
	 * 图片描述
	 */
  	private String imgDes;
  	/**
	 * 设置图片描述
	 */
  	public void setImgDes(String imgDes){
  		this.imgDes=imgDes;
  	}
  	/**
	 * 获取图片描述
	 */
  	public String getImgDes(){
  		return this.imgDes;
  	}
	/**
	 * 图片展示次序
	 */
  	private Integer imgIndex;
  	/**
	 * 设置图片展示次序
	 */
  	public void setImgIndex(Integer imgIndex){
  		this.imgIndex=imgIndex;
  	}
  	/**
	 * 获取图片展示次序
	 */
  	public Integer getImgIndex(){
  		return this.imgIndex;
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
	 * 图片地址
	 */
  	private String imgUrl;
  	/**
	 * 设置图片地址
	 */
  	public void setImgUrl(String imgUrl){
  		this.imgUrl=imgUrl;
  	}
  	/**
	 * 获取图片地址
	 */
  	public String getImgUrl(){
  		return this.imgUrl;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
