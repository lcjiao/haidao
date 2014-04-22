package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class RoleRight extends AbsModel{

	public String get(){
		return "haidao_db.role_right";
	}

	/**
	 * 角色编号
	 */
  	private Integer roleId;
  	/**
	 * 设置角色编号
	 */
  	public void setRoleId(Integer roleId){
  		this.roleId=roleId;
  	}
  	/**
	 * 获取角色编号
	 */
  	public Integer getRoleId(){
  		return this.roleId;
  	}
  	/**
	 * 拥有的权限菜单编号集合以逗号间隔如 3,6,8
	 */
  	private String menuIds;
  	/**
	 * 设置拥有的权限菜单编号集合以逗号间隔如 3,6,8
	 */
  	public void setMenuIds(String menuIds){
  		this.menuIds=menuIds;
  	}
  	/**
	 * 获取拥有的权限菜单编号集合以逗号间隔如 3,6,8
	 */
  	public String getMenuIds(){
  		return this.menuIds;
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
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
}
