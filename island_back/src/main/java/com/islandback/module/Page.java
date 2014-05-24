package com.islandback.module;

public class Page {
	private int pageNo;
	private int begin;
	private int pageSize;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getBegin() {
		if(pageNo < 2 ){
			begin = 0;
		}else{
			begin = (pageNo-1)*pageSize;
		}
		
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
