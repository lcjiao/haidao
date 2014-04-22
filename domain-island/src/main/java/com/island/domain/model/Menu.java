package com.island.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.jcl.core.dal.AbsModel;

public class Menu extends AbsModel implements Comparable{

	public String get(){
		return "haidao_db.menu";
	}

  	/**
	 * 菜单名称
	 */
  	private String menuName;
  	/**
	 * 设置菜单名称
	 */
  	public void setMenuName(String menuName){
  		this.menuName=menuName;
  	}
  	/**
	 * 获取菜单名称
	 */
  	public String getMenuName(){
  		return this.menuName;
  	}
  	/**
	 * 菜单链接
	 */
  	private String menuUrl;
  	/**
	 * 设置菜单链接
	 */
  	public void setMenuUrl(String menuUrl){
  		this.menuUrl=menuUrl;
  	}
  	/**
	 * 获取菜单链接
	 */
  	public String getMenuUrl(){
  		return this.menuUrl;
  	}
	/**
	 * 父菜单编号
	 */
  	private Integer menuParent;
  	/**
	 * 设置父菜单编号
	 */
  	public void setMenuParent(Integer menuParent){
  		this.menuParent=menuParent;
  	}
  	/**
	 * 获取父菜单编号
	 */
  	public Integer getMenuParent(){
  		return this.menuParent;
  	}
	/**
	 * 创建时间
	 */
  	private Integer createTime;
  	/**
	 * 设置创建时间
	 */
  	public void setCreateTime(Integer createTime){
  		this.createTime=createTime;
  	}
  	/**
	 * 获取创建时间
	 */
  	public Integer getCreateTime(){
  		return this.createTime;
  	}
	/**
	 * 是否有效
	 */
  	private Integer valid=Integer.parseInt("1");
  	/**
	 * 设置是否有效
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取是否有效
	 */
  	public Integer getValid(){
  		return this.valid;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
	
	private List<Menu> childList = new ArrayList<Menu>(0);
	public List<Menu> getChildList() {
		return childList;
	}
	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}
	
	
	public int compareTo(Object obj) {
		Menu menu = (Menu) obj;
		if(menu.getId() > this.id ){
			return -1;
		}
		if( menu.getId() < this.id){
			return 1;
		}
		return 0;
	}
	
}
