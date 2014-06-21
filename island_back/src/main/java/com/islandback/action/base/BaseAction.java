package com.islandback.action.base;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.Menu;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	
	
	
	private static Integer menuId;
	private static String menuAddress;
	

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuAddress() {
		String gradeFather = "";
		String father = "";
		String son = "";
		
		
		Menu sonM = this.roleBiz.queryMenuById(menuId);
		son = sonM.getMenuName();
		Menu sonF = this.roleBiz.queryMenuById(sonM.getMenuParent());
		father = sonF.getMenuName();
		if( sonF != null && sonF.getMenuParent() != null && sonF.getMenuParent().intValue() > 0 ){
			Menu sonGF = this.roleBiz.queryMenuById(sonF.getMenuParent());
			gradeFather = sonGF.getMenuName();
		}
		
		if( gradeFather != null && !"".equals(gradeFather)){
			gradeFather = gradeFather +"--";
		}
		if( father != null && !"".equals(father)){
			father = father +"--";
		}
		menuAddress =gradeFather +  father + son;
		return menuAddress;
	}

	public void setMenuAddress(String menuAddress) {
		this.menuAddress = menuAddress;
	}

	
	
	
}
