package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class Company extends AbsModel{

	public String get(){
		return "haidao_db.company";
	}

  	/**
	 * 公司名称
	 */
  	private String name;
  	/**
	 * 设置公司名称
	 */
  	public void setName(String name){
  		this.name=name;
  	}
  	/**
	 * 获取公司名称
	 */
  	public String getName(){
  		return this.name;
  	}
  	/**
	 * 公司logo图片地址
	 */
  	private String logo;
  	/**
	 * 设置公司logo图片地址
	 */
  	public void setLogo(String logo){
  		this.logo=logo;
  	}
  	/**
	 * 获取公司logo图片地址
	 */
  	public String getLogo(){
  		return this.logo;
  	}
  	/**
	 * 公司介绍
	 */
  	private String introduction;
  	/**
	 * 设置公司介绍
	 */
  	public void setIntroduction(String introduction){
  		this.introduction=introduction;
  	}
  	/**
	 * 获取公司介绍
	 */
  	public String getIntroduction(){
  		return this.introduction;
  	}
  	/**
	 * 联系电话
	 */
  	private String tel;
  	/**
	 * 设置联系电话
	 */
  	public void setTel(String tel){
  		this.tel=tel;
  	}
  	/**
	 * 获取联系电话
	 */
  	public String getTel(){
  		return this.tel;
  	}
  	/**
	 * 座机
	 */
  	private String phone;
  	/**
	 * 设置座机
	 */
  	public void setPhone(String phone){
  		this.phone=phone;
  	}
  	/**
	 * 获取座机
	 */
  	public String getPhone(){
  		return this.phone;
  	}
  	/**
	 * 联系人名称
	 */
  	private String person;
  	/**
	 * 设置联系人名称
	 */
  	public void setPerson(String person){
  		this.person=person;
  	}
  	/**
	 * 获取联系人名称
	 */
  	public String getPerson(){
  		return this.person;
  	}
  	/**
	 * 公司地址
	 */
  	private String address;
  	/**
	 * 设置公司地址
	 */
  	public void setAddress(String address){
  		this.address=address;
  	}
  	/**
	 * 获取公司地址
	 */
  	public String getAddress(){
  		return this.address;
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
