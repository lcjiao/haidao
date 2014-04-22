package com.islandback.module;

public class BackUser {
	private static final long serialVersionUID = -3994999387398804100L;
	private Integer id;
	private String userName;
	private String userPass;
	private Integer roleId;
	private Integer createTime;
	private String createPerson;
	private Integer updTime;
	private String updPerson;
	private String roleName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public Integer getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Integer updTime) {
		this.updTime = updTime;
	}
	public String getUpdPerson() {
		return updPerson;
	}
	public void setUpdPerson(String updPerson) {
		this.updPerson = updPerson;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
