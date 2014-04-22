package com.islandback.web.util;

import javax.servlet.http.*;

import com.islandback.module.SessionInfo;

import java.util.*;

public class SessionListener implements HttpSessionListener {
	private static Hashtable UserNames = new Hashtable();//�?�?sessionID???username??????�?

	/**以�?????�????HttpSessionListener�??????��??**/
	public void sessionCreated(HttpSessionEvent se) {
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		Hashtable hUserName = getHUserName();
		hUserName.remove(se.getSession().getId());
		updateSessionCache(hUserName);
	}

	/*
	 *   isAlreadyEnter-??��????��????��?��?????已�????��??以�????��?????�??????��??
	 *   @param   sUserName   String-??��???????��?��??�?
	 *   @return   boolean-该�?��?��?????已�????��??�???????�?
	 */
	public static boolean isAlreadyEnter(HttpSession session, String sUserName) {
		System.out.println("session id:"+session.getId());
		boolean flag = false;
		Hashtable hUserName = getHUserName();
		if (hUserName.containsValue(sUserName)) {//�????该�?��?�已�???��??�?�????使�??次�?��???????��?��??�?(�????使�?��?��???????????hUserName�?)
			flag = true;
			//???????????��??hUserName�??????��????��?��??对�?????sessionID(??��????��????��??sessionID???username)
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
			hUserName.put(session.getId(), sUserName);//添�????��?��??sessionID???username
			System.out.println("hUserName   =   " + hUserName);
		} else {//�????该�?��?�没??��??�?�???��?�添?????��?��??sessionID???username
			flag = false;
			hUserName.put(session.getId(), sUserName);
			System.out.println("hUserName   =   " + hUserName);
		}
		return flag;
	}

	/*
	 *   isOnline-??��????��????��?��???????�线
	 *   @param   session   HttpSession-??��???????��?��??�?
	 *   @return   boolean-该�?��?��???????�线??????�?
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