package com.islandback.web.interceptor;

import com.islandback.action.login.LoginAction;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.SessionListener;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/**
		 * 如果请求登录不验证是否已经登录
		*/
		Object action = invocation.getAction();
		if(action instanceof LoginAction){
			return invocation.invoke();
		}
		
		/**
		 * 判断是否已经登录
		 */
		if( SessionListener.isOnline(RequestProcc.getSession()) ){
			return invocation.invoke();
		}else{
			//return invocation.invoke();
			return "login";
		}
		
		
	}

}
