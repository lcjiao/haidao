package com.islandback.action.login;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.User;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.SessionListener;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@ResultPath("/WEB-INF")
@Results({  
		  @Result(name="input", location="/index.jsp"),
		  @Result(name="main", location="/WEB-INF/page/mainpage.jsp"),
		  @Result(name="exit", location="/exit.jsp"),
		  @Result(name="left", location="/WEB-INF/page/page_left.jsp"),
		 }) 
public class LoginAction extends ActionSupport {
	private String userName;
	private String userPass;
	private String loginErr = "false";
	private String errMsg = "";
	
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

	public String getLoginErr() {
		return loginErr;
	}

	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	
	public String login(){
		SessionInfo loginSession = RequestProcc.getSessionInfo();
		User loginUser = null;
		if( loginSession != null ){
			loginUser = loginSession.getUser();
		}
		if(StringUtils.isBlank(userName))
		{
			if(loginUser != null ){
				userName = loginUser.getUserName();
			}
			if(StringUtils.isBlank(userName)){
				this.loginErr = "true";
				this.errMsg = "用户名不存在或密码错误";
				return ActionSupport.INPUT;
			}
			
		}

		if(StringUtils.isBlank(userPass))
		{
			if(loginUser != null ){
				userPass = loginUser.getUserPass();
			}
			if(StringUtils.isBlank(userPass)){
				this.loginErr = "true";
				this.errMsg = "用户名不存在或密码错误";
				return ActionSupport.INPUT;
			}
			
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("userName", userName);
		params.put("userPass", userPass);
		List<User> list = roleBiz.queryUserByMap(params);
		if(list == null || list.isEmpty()){
			this.loginErr = "true";
			this.errMsg = "用户名不存在或密码错误";
			return ActionSupport.INPUT;
		}
		SessionInfo sessinInfo = new SessionInfo();
		User user = list.get(0);
		sessinInfo.setUser(user);
		RequestProcc.setSessionInfo(sessinInfo);
		SessionListener.isAlreadyEnter(RequestProcc.getSession(), user.getUserName() );
		return "main";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String exit(){
		RequestProcc.getSession().invalidate();
		return ActionSupport.INPUT;
	}
	
}
