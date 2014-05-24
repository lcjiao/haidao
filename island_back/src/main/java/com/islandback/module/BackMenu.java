package com.islandback.module;

import java.util.ArrayList;
import java.util.List;

public class BackMenu implements Comparable{

	private static final long serialVersionUID = -3994999387398804102L;
	private String name;
	private String url;
	private Integer parentId;
	private Integer id;
	private List<BackMenu> childList = new ArrayList<BackMenu>(0); 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<BackMenu> getChildList() {
		return childList;
	}
	public void setChildList(List<BackMenu> childList) {
		this.childList = childList;
	}
	public int compareTo(Object obj) {
		BackMenu menu = (BackMenu) obj;
		if(menu.getId() > this.id ){
			return -1;
		}
		if( menu.getId() < this.id){
			return 1;
		}
		return 0;
	}
	
	
}
