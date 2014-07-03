package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class IslandOrder extends AbsModel{

	public String get(){
		return "haidao_db.island_order";
	}

  	/**
	 * 国家
	 */
  	private String country;
  	/**
	 * 设置国家
	 */
  	public void setCountry(String country){
  		this.country=country;
  	}
  	/**
	 * 获取国家
	 */
  	public String getCountry(){
  		return this.country;
  	}
  	/**
	 * 婚礼区域
	 */
  	private String wedArea;
  	/**
	 * 设置婚礼区域
	 */
  	public void setWedArea(String wedArea){
  		this.wedArea=wedArea;
  	}
  	/**
	 * 获取婚礼区域
	 */
  	public String getWedArea(){
  		return this.wedArea;
  	}
	/**
	 * 出发地
	 */
  	private String wedFrom;
  	/**
	 * 设置出发地
	 */
  	public void setWedFrom(String wedFrom){
  		this.wedFrom=wedFrom;
  	}
  	/**
	 * 获取出发地
	 */
  	public String getWedFrom(){
  		return this.wedFrom;
  	}
	/**
	 * 婚礼预算单位元
	 */
  	private Integer budget;
  	/**
	 * 设置婚礼预算单位元
	 */
  	public void setBudget(Integer budget){
  		this.budget=budget;
  	}
  	/**
	 * 获取婚礼预算单位元
	 */
  	public Integer getBudget(){
  		return this.budget;
  	}
	/**
	 * 婚礼人数
	 */
  	private Integer wedPersonNum;
  	/**
	 * 设置婚礼人数
	 */
  	public void setWedPersonNum(Integer wedPersonNum){
  		this.wedPersonNum=wedPersonNum;
  	}
  	/**
	 * 获取婚礼人数
	 */
  	public Integer getWedPersonNum(){
  		return this.wedPersonNum;
  	}
  	/**
	 * 新人姓名
	 */
  	private String wedName;
  	/**
	 * 设置新人姓名
	 */
  	public void setWedName(String wedName){
  		this.wedName=wedName;
  	}
  	/**
	 * 获取新人姓名
	 */
  	public String getWedName(){
  		return this.wedName;
  	}
  	/**
	 * 手机号码
	 */
  	private String tel;
  	/**
	 * 设置手机号码
	 */
  	public void setTel(String tel){
  		this.tel=tel;
  	}
  	/**
	 * 获取手机号码
	 */
  	public String getTel(){
  		return this.tel;
  	}
  	/**
	 * qq号码
	 */
  	private String qq;
  	/**
	 * 设置qq号码
	 */
  	public void setQq(String qq){
  		this.qq=qq;
  	}
  	/**
	 * 获取qq号码
	 */
  	public String getQq(){
  		return this.qq;
  	}
  	/**
	 * 邮箱地址
	 */
  	private String mail;
  	/**
	 * 设置邮箱地址
	 */
  	public void setMail(String mail){
  		this.mail=mail;
  	}
  	/**
	 * 获取邮箱地址
	 */
  	public String getMail(){
  		return this.mail;
  	}
  	/**
	 * ip地址
	 */
  	private String ip;
  	/**
	 * 设置ip地址
	 */
  	public void setIp(String ip){
  		this.ip=ip;
  	}
  	/**
	 * 获取ip地址
	 */
  	public String getIp(){
  		return this.ip;
  	}
  	/**
	 * 咨询内容
	 */
  	private String askMsg;
  	/**
	 * 设置咨询内容
	 */
  	public void setAskMsg(String askMsg){
  		this.askMsg=askMsg;
  	}
  	/**
	 * 获取咨询内容
	 */
  	public String getAskMsg(){
  		return this.askMsg;
  	}
  	/**
	 * 套餐编号列表  多个套餐用逗号间隔
	 */
  	private String packageIds;
  	/**
	 * 设置套餐编号列表  多个套餐用逗号间隔
	 */
  	public void setPackageIds(String packageIds){
  		this.packageIds=packageIds;
  	}
  	/**
	 * 获取套餐编号列表  多个套餐用逗号间隔
	 */
  	public String getPackageIds(){
  		return this.packageIds;
  	}
	/**
	 * 1已经发送邮件  0没有发送邮件
	 */
  	private Integer isSend;
  	/**
	 * 设置1已经发送邮件  0没有发送邮件
	 */
  	public void setIsSend(Integer isSend){
  		this.isSend=isSend;
  	}
  	/**
	 * 获取1已经发送邮件  0没有发送邮件
	 */
  	public Integer getIsSend(){
  		return this.isSend;
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
