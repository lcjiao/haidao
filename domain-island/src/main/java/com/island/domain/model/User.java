package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class User extends AbsModel{

	public String get(){
		return "haidao_db.user";
	}

  	/**
	 * 用户名称
	 */
  	private String userName;
  	/**
	 * 设置用户名称
	 */
  	public void setUserName(String userName){
  		this.userName=userName;
  	}
  	/**
	 * 获取用户名称
	 */
  	public String getUserName(){
  		return this.userName;
  	}
  	/**
	 * 用户密码
	 */
  	private String userPass;
  	/**
	 * 设置用户密码
	 */
  	public void setUserPass(String userPass){
  		this.userPass=userPass;
  	}
  	/**
	 * 获取用户密码
	 */
  	public String getUserPass(){
  		return this.userPass;
  	}
	/**
	 * 用户角色编号
	 */
  	private Integer userRoleId;
  	/**
	 * 设置用户角色编号
	 */
  	public void setUserRoleId(Integer userRoleId){
  		this.userRoleId=userRoleId;
  	}
  	/**
	 * 获取用户角色编号
	 */
  	public Integer getUserRoleId(){
  		return this.userRoleId;
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
	 * 是否有效
	 */
  	private Integer valid=Integer.parseInt("1");
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
	 * 角色名称
	 */
  	private String roleName;
  	/**
	 * 设置角色名称
	 */
  	public void setRoleName(String roleName){
  		this.roleName=roleName;
  	}
  	/**
	 * 获取角色名称
	 */
  	public String getRoleName(){
  		return this.roleName;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
