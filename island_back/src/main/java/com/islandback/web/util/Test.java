package com.islandback.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.island.domain.util.AsynBizExecutor;

public class Test {

	public static void main(String[] args) {
		int now = (int)(System.currentTimeMillis()/1000);
		System.out.println(unix2DStr(now,"yyyyMMdd"));
		
		long l = System.currentTimeMillis();
		int i = (int)(l/1000);
		System.out.println(unix2DStr(i,"yyyyMMdd"));
	}
	
	public static void todo() throws InterruptedException{
		System.out.println("todo begin");
		Thread.sleep(10000);
		System.out.println("todo end");
	}
	
	public static String unix2DStr(Integer time_, String pattern) {
		if (time_ == null)
			return "";
		Long time = time_ * 1000l;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		SimpleDateFormat fd = new SimpleDateFormat(pattern);
		return (fd.format(calendar.getTime()));
	}

}
