package com.island.domain.util;

import java.util.Calendar;

import com.jcl.core.util.DateUtil;

public class IslandDateUtil {

	public static String getDateStrByUnixTime(Integer time,String pattern){
		long ltime = time*1000l;
		return DateUtil.unix2DStr(ltime, pattern);
	}
	
	public static Integer getUnixTimeByDateStr(String date){
		Calendar c = DateUtil.string2Cal(date);
		return (int) (c.getTimeInMillis() /1000);
	}
	
	public static void main(String arg[]){
		System.out.println( getUnixTimeByDateStr("2014-06-09") );
		System.out.println(getDateStrByUnixTime(1402243200,"yyyy-MM-dd"));
	}
}
