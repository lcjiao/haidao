package com.islandback.web.util;

import javax.servlet.http.*;

import com.islandback.module.SessionInfo;

import java.util.*;

public class SessionListener implements HttpSessionListener {
	private static Hashtable UserNames = new Hashtable();//ä¿?å­?sessionID???username??????å°?

	/**ä»¥ä?????å®????HttpSessionListenerä¸??????¹æ??**/
	public void sessionCreated(HttpSessionEvent se) {
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		Hashtable hUserName = getHUserName();
		hUserName.remove(se.getSession().getId());
		updateSessionCache(hUserName);
	}

	/*
	 *   isAlreadyEnter-??¨ä????¤æ????¨æ?·æ?????å·²ç????»å??ä»¥å????¸å?????å¤??????¹æ??
	 *   @param   sUserName   String-??»å???????¨æ?·å??ç§?
	 *   @return   boolean-è¯¥ç?¨æ?·æ?????å·²ç????»å??è¿???????å¿?
	 */
	public static boolean isAlreadyEnter(HttpSession session, String sUserName) {
		System.out.println("session id:"+session.getId());
		boolean flag = false;
		Hashtable hUserName = getHUserName();
		if (hUserName.containsValue(sUserName)) {//å¦????è¯¥ç?¨æ?·å·²ç»???»å??è¿?ï¼????ä½¿ä??æ¬¡ç?»å???????¨æ?·æ??çº?(ä¾????ä½¿ç?¨æ?·å???????????hUserNameä¸?)
			flag = true;
			//???????????¥ç??hUserNameï¼??????¤å????¨æ?·å??å¯¹å?????sessionID(??³å????¤å????¥ç??sessionID???username)
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(sUserName)) {
					hUserName.remove(key);
					updateSessionCache(hUserName);
					break;
				}
			}
			hUserName.put(session.getId(), sUserName);//æ·»å????°å?¨ç??sessionID???username
			System.out.println("hUserName   =   " + hUserName);
		} else {//å¦????è¯¥ç?¨æ?·æ²¡??»å??è¿?ï¼???´æ?¥æ·»?????°å?¨ç??sessionID???username
			flag = false;
			hUserName.put(session.getId(), sUserName);
			System.out.println("hUserName   =   " + hUserName);
		}
		return flag;
	}

	/*
	 *   isOnline-??¨ä????¤æ????¨æ?·æ???????¨çº¿
	 *   @param   session   HttpSession-??»å???????¨æ?·å??ç§?
	 *   @return   boolean-è¯¥ç?¨æ?·æ???????¨çº¿??????å¿?
	 */
	public static boolean isOnline(HttpSession session) {
		if(session != null){
			boolean flag = true;
			if (getHUserName().containsKey(session.getId())) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		}else{
			return false;
		}

	}
	
	public static String getLogUserName(){
		SessionInfo userInfo = RequestProcc.getSessionInfo();
		String userName = userInfo.getUser().getUserName();
		return userName;
	}
	
	public static Integer getLogUserId(){
		SessionInfo userInfo = RequestProcc.getSessionInfo();
		Integer userId = userInfo.getUser().getId();
		return userId;
	}

	public static Hashtable getHUserName() {
		return UserNames;
	}
	public static void updateSessionCache(Hashtable hUserName){
		
	}
	private static Date getNextDayZeroHourExpireTime(){
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,1);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		Date expire = cal.getTime();
		return expire;
	}
}