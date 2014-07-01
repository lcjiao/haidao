package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class Image extends AbsModel{

	public String get(){
		return "haidao_db.image";
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
	 * 备注
	 */
  	private String imgDesc;
  	/**
	 * 设置备注
	 */
  	public void setImgDesc(String imgDesc){
  		this.imgDesc=imgDesc;
  	}
  	/**
	 * 获取备注
	 */
  	public String getImgDesc(){
  		return this.imgDesc;
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
