package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class PackageKepianliuying extends AbsModel{

	public String get(){
		return "haidao_db.package_kepianliuying";
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
	 * 图片地址
	 */
  	private String img;
  	/**
	 * 设置图片地址
	 */
  	public void setImg(String img){
  		this.img=img;
  	}
  	/**
	 * 获取图片地址
	 */
  	public String getImg(){
  		return this.img;
  	}
  	/**
	 * 描述
	 */
  	private String desc;
  	/**
	 * 设置描述
	 */
  	public void setDesc(String desc){
  		this.desc=desc;
  	}
  	/**
	 * 获取描述
	 */
  	public String getDesc(){
  		return this.desc;
  	}
  	/**
	 * 链接地址
	 */
  	private String link;
  	/**
	 * 设置链接地址
	 */
  	public void setLink(String link){
  		this.link=link;
  	}
  	/**
	 * 获取链接地址
	 */
  	public String getLink(){
  		return this.link;
  	}
	/**
	 * 排序
	 */
  	private Integer index;
  	/**
	 * 设置排序
	 */
  	public void setIndex(Integer index){
  		this.index=index;
  	}
  	/**
	 * 获取排序
	 */
  	public Integer getIndex(){
  		return this.index;
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
