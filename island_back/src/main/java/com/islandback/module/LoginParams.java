package com.islandback.module;

import java.io.Serializable;
import java.util.Map;

public class LoginParams implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pwdLabel;
	private String nameLable;
	private String userName;
	private String pwd;
	private String url;
	private String formName;
	private String iframeName;
	private Map<String,Object> extendParams;
	
	public Map<String, Object> getExtendParams() {
		return extendParams;
	}
	public void setExtendParams(Map<String, Object> extendParams) {
		this.extendParams = extendParams;
	}
	public String getPwdLabel() {
		return pwdLabel;
	}
	public void setPwdLabel(String pwdLabel) {
		this.pwdLabel = pwdLabel;
	}
	public String getNameLable() {
		return nameLable;
	}
	public void setNameLable(String nameLable) {
		this.nameLable = nameLable;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getIframeName() {
		return iframeName;
	}
	public void setIframeName(String iframeName) {
		this.iframeName = iframeName;
	}
}
