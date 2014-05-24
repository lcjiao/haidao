package com.islandback.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.islandback.module.SessionInfo;


public class RequestProcc {

	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public static SessionInfo getSessionInfo() {
		return (SessionInfo)ServletActionContext.getRequest().getSession().getAttribute("sessionData");
	}

	public static void setSessionInfo(SessionInfo data) {
		//session????????¶é?´è?¾ä¸º12å°????
		//ServletActionContext.getRequest().getSession().setMaxInactiveInterval(43200);
		ServletActionContext.getRequest().getSession().setAttribute("sessionData",data);
	}

	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public static String getRemoteAddr() {
		HttpServletRequest request = getRequest();
		String ipAddr = request.getHeader("x-forwarded-for");
		if (ipAddr ==  null || ipAddr.isEmpty() || "unknown".equalsIgnoreCase(ipAddr))
			ipAddr = request.getHeader("Proxy-Client-IP");
		if (ipAddr ==  null || ipAddr.isEmpty() || "unknown".equalsIgnoreCase(ipAddr))
			ipAddr = request.getHeader("WL-Proxy-Client-IP");
		if (ipAddr ==  null || ipAddr.isEmpty() || "unknown".equalsIgnoreCase(ipAddr))
			ipAddr = request.getRemoteAddr();

		String[] ipArray = ipAddr.split(",");
		ipAddr = ipArray[0].trim();

		return ipAddr;
	}
}
