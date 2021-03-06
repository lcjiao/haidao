package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class CasePicMapping extends AbsModel{

	public String get(){
		return "haidao_db.case_pic_mapping";
	}

	/**
	 * 案例id
	 */
  	private Integer caseid;
  	/**
	 * 设置案例id
	 */
  	public void setCaseid(Integer caseid){
  		this.caseid=caseid;
  	}
  	/**
	 * 获取案例id
	 */
  	public Integer getCaseid(){
  		return this.caseid;
  	}
  	/**
	 * 图片描述
	 */
  	private String picturedesc;
  	/**
	 * 设置图片描述
	 */
  	public void setPicturedesc(String picturedesc){
  		this.picturedesc=picturedesc;
  	}
  	/**
	 * 获取图片描述
	 */
  	public String getPicturedesc(){
  		return this.picturedesc;
  	}
  	/**
	 * 图片url
	 */
  	private String pictureurl;
  	/**
	 * 设置图片url
	 */
  	public void setPictureurl(String pictureurl){
  		this.pictureurl=pictureurl;
  	}
  	/**
	 * 获取图片url
	 */
  	public String getPictureurl(){
  		return this.pictureurl;
  	}
	/**
	 * 是否有效,1:有效,0:无效
	 */
  	private Integer valid;
  	/**
	 * 设置是否有效,1:有效,0:无效
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取是否有效,1:有效,0:无效
	 */
  	public Integer getValid(){
  		return this.valid;
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
	 * 链接地址
	 */
  	private String picLink;
  	/**
	 * 设置链接地址
	 */
  	public void setPicLink(String picLink){
  		this.picLink=picLink;
  	}
  	/**
	 * 获取链接地址
	 */
  	public String getPicLink(){
  		return this.picLink;
  	}
  	/**
	 * 扩展1
	 */
  	private String extend1;
  	/**
	 * 设置扩展1
	 */
  	public void setExtend1(String extend1){
  		this.extend1=extend1;
  	}
  	/**
	 * 获取扩展1
	 */
  	public String getExtend1(){
  		return this.extend1;
  	}
  	/**
	 * 扩展2
	 */
  	private String extend2;
  	/**
	 * 设置扩展2
	 */
  	public void setExtend2(String extend2){
  		this.extend2=extend2;
  	}
  	/**
	 * 获取扩展2
	 */
  	public String getExtend2(){
  		return this.extend2;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
