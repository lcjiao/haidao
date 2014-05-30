package com.islandback.action.login;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.Menu;
import com.island.domain.model.RoleRight;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/page")
@ResultPath("/WEB-INF")
public class PageAction extends ActionSupport{
	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	private List<Menu> menuList = new ArrayList<Menu>(0); 
	private String userName;
	//获取页面头部信息
	public String top(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		this.userName = sessionInfo.getUser().getUserName();
		return "top";
		
	}
	
	
	//获取页面左边的数的信息
	public String left(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		Integer roleId = sessionInfo.getUser().getUserRoleId();
		Map<String,Object> queryMap = new HashMap<String,Object>(0);
		queryMap.put("valid", 1);
		queryMap.put("roleId", roleId);
		List<RoleRight> roleRightList = roleBiz.queryRoleRightByMap(queryMap);
		String menuIds  = "";
		if(roleRightList != null && !roleRightList.isEmpty()){
			menuIds = roleRightList.get(0).getMenuIds();
			menuIds = menuIds.substring(0, menuIds.length()-1);
			menuIds = "("+menuIds+")";
		}
		Map<String,Object> menuQueryParam = new HashMap<String,Object>(0);
		if(menuIds.length() < 3){
			return "left";
		}
		menuQueryParam.put("ids",menuIds);
		menuQueryParam.put("valid", 1);
		
		List<Menu> list  = roleBiz.queryMenuByIds(menuQueryParam);//用户权限菜单树
		Set<Integer> setIds = new HashSet<Integer>(0);
		if(list != null && !list.isEmpty()){
			for(Menu menu : list){
				setIds.add(menu.getId());
				setIds.add(menu.getMenuParent());
			}
			menuIds = "";
			for(Integer menuId : setIds){
				menuIds = menuIds+ menuId+",";
			}
			menuIds = menuIds.substring(0, menuIds.length()-1);
			menuIds = "("+menuIds+")";
			menuQueryParam.put("ids",menuIds);
		}
		list  = roleBiz.queryMenuByIds(menuQueryParam);//用户权限菜单树 包含父级菜单
		
//		if(list != null && !list.isEmpty()){
//			Map<Menu,List<Menu>> menuTree = new HashMap<Menu,List<Menu>>(0);
//			Map<Integer,Menu> parentMap = new HashMap<Integer,Menu>(0);
//			if(list != null && !list.isEmpty()){
//				Collections.sort(list);
//				for(Menu menu : list ){
//					if( menu.getMenuParent().intValue() == 0 ){//主菜单
//						parentMap.put(menu.getId(), menu);
//						List<Menu> childList = menuTree.get(menu);
//						if(childList == null ){
//							List<Menu> sonList = new ArrayList<Menu>(0);
//							menuTree.put(menu, sonList);
//						}
//					}else{
//						Menu parent = parentMap.get(menu.getMenuParent());
//						List<Menu> sonList = menuTree.get(parent);
//						sonList.add(menu);
//					}
//				}
//			}
//			
//			Set<Entry<Menu,List<Menu>>> set = menuTree.entrySet();
//			for(Entry<Menu,List<Menu>> entry : set ){
//				Menu parentMenu = entry.getKey();
//				List<Menu> sonMenus = entry.getValue();
//				parentMenu.setChildList(sonMenus);
//				this.menuList.add(parentMenu);
//			}
//			Collections.sort(this.menuList);
//		}
		
		Map<Integer,Boolean> userMenuMap = new HashMap<Integer,Boolean>(0);
		for(Menu menu : list ){
			userMenuMap.put(menu.getId(), true);
		}
		
		
		
		
		Map<Integer,List<Menu>> menuTree = new HashMap<Integer,List<Menu>>(0);
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		for(Menu menu : list ){
			params.put("menuParent", menu.getId());
			List<Menu> sonList = this.roleBiz.queryMenuByMap(params);
			if( sonList != null && !sonList.isEmpty()){
				List<Menu> userSonList = new ArrayList<Menu>(0);
				for(Menu sonMenu : sonList){
					
					if( userMenuMap.get( sonMenu.getId() ) != null ){
						userSonList.add(sonMenu);
					}
				}
				if(userSonList.size() >  0 ){
					Collections.sort(userSonList);
					menu.setChildList(userSonList);
					menuTree.put(menu.getId(), userSonList);
				}
				
			}
		}
		for(Menu menu : list){
			if(menu.getMenuParent().intValue() == 0 ){
				for(Menu sonMenu : menuTree.get(menu.getId())){
					List<Menu>  threeMenuList = menuTree.get(sonMenu.getId());
					if( threeMenuList != null && !threeMenuList.isEmpty()){
						sonMenu.setChildList(threeMenuList);
						sonMenu.setHaschild(1);
					}
				}
				this.menuList.add(menu);
			}
		}

		Collections.sort(this.menuList);
		
		
		
		return "left";
	}
	
	//获取页面主版面的信息
	public String toMain(){
		return "main";
	}
	
	public String control(){
		return "control";
	}
	
	public String vipMain(){
		return "vipMain";
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public List<Menu> getMenuList() {
		return menuList;
	}


	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
	
	
}
