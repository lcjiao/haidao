package com.islandback.web.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SqlUtil {

	public static String getQueryCondition(Map<String,Object> params){
		String sql = "";
		if(params != null ){
			Set<Entry<String,Object>> set = params.entrySet();
			for(Entry<String,Object> entry : set){
				String name = entry.getKey();
				if(name.endsWith("_jdbcids")){
					String value = (String) entry.getValue();
					String column = name.substring(0, name.length()-8);
					sql = sql + column+" in "+value+" and ";
				}else{
					sql = sql + name+"=:"+name+" and ";
				}
				
			}
		}
		if(sql.length() > 4 ){
			sql = sql.substring(0,sql.length()-4);
		}
		return sql;
	}
	
	public static String getUpdateRst(Map<String,Object> params){
		String sql = "";
		if(params != null ){
			Set<Entry<String,Object>> set = params.entrySet();
			for(Entry<String,Object> entry : set){
				String name = entry.getKey();
				Object value = entry.getValue();
				if(value instanceof String){
					sql = sql + name+"='"+value+"',";
				}else{
					sql = sql + name+"="+value+",";
				}
				
			}
		}
		if(sql.length() > 1 ){
			sql = sql.substring(0,sql.length()-1);
		}
		return sql;
	}
}
