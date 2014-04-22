package com.islandback.module;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.island.domain.model.User;


public class SessionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6301525619221080115L;
	private String isAdmin;//系�??管�????????�?
	private String loginTime;
	private List<LoginParams> loginParamList =null;
	private String enCodePwd = null;
	private Map<String,String> jspMaps = null;
	private User user;
	
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getEnCodePwd() {
		return enCodePwd;
	}
	public void setEnCodePwd(String enCodePwd) {
		this.enCodePwd = enCodePwd;
	}
	
	public Map<String, String> getJspMaps() {
		return jspMaps;
	}
	public void setJspMaps(Map<String, String> jspMaps) {
		this.jspMaps = jspMaps;
	}
	public List<LoginParams> getLoginParamList() {
		return loginParamList;
	}
	public void setLoginParamList(List<LoginParams> loginParamList) {
		this.loginParamList = loginParamList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}