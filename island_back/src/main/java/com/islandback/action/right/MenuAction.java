package com.islandback.action.right;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.Menu;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/right/menu")
@ResultPath("/WEB-INF")

public class MenuAction extends ActionSupport{
	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	
	private List<Menu> menuList = new ArrayList<Menu>(0); 
	private String menuName;
	private String menuUrl;
	private Integer parentId;
	private Integer menuId;
	private Integer showIndex;
	public String addMenu(){
		Menu addObj = new Menu();
		addObj.setMenuName(menuName);
		addObj.setMenuParent(parentId);
		addObj.setMenuUrl(menuUrl);
		addObj.setShowIndex(showIndex);
		this.roleBiz.addMenu(addObj);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		this.menuList = this.roleBiz.queryMenuByMap(params);
		return "list";
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String list(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		this.menuList = this.roleBiz.queryMenuByMap(params);
		return "list";
	}
	
	public String toEdit(){
		Menu menu = this.roleBiz.queryMenuById(menuId);
		this.menuName=menu.getMenuName();
		this.menuUrl=menu.getMenuUrl();
		this.parentId=menu.getMenuParent();
		this.showIndex=menu.getShowIndex();
		return "edit";
	}
	
	
	public String editMenu(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("id", menuId);
		params.put("menuName", menuName);
		params.put("menuUrl", menuUrl);
		params.put("menuParent", parentId);
		params.put("showIndex", showIndex);
		this.roleBiz.updMenuByMap(params);
		
		Map<String,Object> qparams = new HashMap<String,Object>(0);
		params.put("valid", 1);
		this.menuList = this.roleBiz.queryMenuByMap(qparams);
		return "list";
		
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(Integer showIndex) {
		this.showIndex = showIndex;
	}
	
	
	
}
