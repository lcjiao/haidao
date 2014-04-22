package com.islandback.action.right;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.Menu;
import com.island.domain.model.Role;
import com.island.domain.model.RoleRight;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/right/roleright")
@ResultPath("/WEB-INF")

public class RolerightAction extends ActionSupport{
	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	
	private List<Role> roleList = new ArrayList<Role>(0); 
	private List<Menu> menuList = new ArrayList<Menu>(0); 
	private Integer roleId;
	private String roleName;
	private String menuIds;
	
	
	
	public String manager(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Menu> list  = this.roleBiz.queryMenuByMap(params);
		Map<Menu,List<Menu>> menuTree = new HashMap<Menu,List<Menu>>(0);
		Map<Integer,Menu> parentMap = new HashMap<Integer,Menu>(0);
		if(list != null && !list.isEmpty()){
			Collections.sort(list);
			for(Menu menu : list ){
				if( menu.getMenuParent().intValue() == 0 ){//主菜单
					parentMap.put(menu.getId(), menu);
					List<Menu> childList = menuTree.get(menu);
					if(childList == null ){
						List<Menu> sonList = new ArrayList<Menu>(0);
						menuTree.put(menu, sonList);
					}
				}else{
					Menu parent = parentMap.get(menu.getMenuParent());
					List<Menu> sonList = menuTree.get(parent);
					sonList.add(menu);
				}
			}
		}
		
		Set<Entry<Menu,List<Menu>>> set = menuTree.entrySet();
		for(Entry<Menu,List<Menu>> entry : set ){
			Menu parentMenu = entry.getKey();
			List<Menu> sonMenus = entry.getValue();
			parentMenu.setChildList(sonMenus);
			this.menuList.add(parentMenu);
		}
		Collections.sort(this.menuList);
		
		
		Map<String,Object> queryMap = new HashMap<String,Object>(0);
		queryMap.put("valid", 1);
		queryMap.put("roleId", roleId);
		List<RoleRight> roleRightList = this.roleBiz.queryRoleRightByMap(queryMap);
		if(roleRightList != null && !roleRightList.isEmpty()){
			this.menuIds = roleRightList.get(0).getMenuIds();
		}
		return "manager";
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
