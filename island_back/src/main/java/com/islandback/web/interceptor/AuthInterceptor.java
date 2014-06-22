package com.islandback.web.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		 ActionContext actionContext = invocation.getInvocationContext();
	        HttpServletRequest request = (HttpServletRequest) actionContext
	                .get(StrutsStatics.HTTP_REQUEST);
	       String contextPath = request.getContextPath();
	       String servletPath = request.getServletPath();
	       String askUrl = contextPath +servletPath;
	       System.out.println(askUrl);
	       
		return invocation.invoke();
	}

}
