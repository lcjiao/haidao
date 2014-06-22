package com.islandback.action.frontindex;

import java.util.Calendar;

import com.jcl.core.util.DateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateUtil.unix2DStr(1402321105*1l, "yyyy-MM-dd"));
		long time = 1402243200*1000l;
		String s = DateUtil.unix2DStr(time, "yyyy-MM-dd");
		
		Calendar c = DateUtil.string2Cal("2014-06-09");
		System.out.println(s);
		System.out.println(c.getTimeInMillis() /1000);
		
	}

}
