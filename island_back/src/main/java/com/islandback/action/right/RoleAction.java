package com.islandback.action.right;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.Role;
import com.island.domain.model.RoleRight;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/right/role")
@ResultPath("/WEB-INF")

public class RoleAction extends ActionSupport{
	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	
	
	private List<Role> roleList = new ArrayList<Role>(0); 
	private Integer roleId;
	private String roleName;
	private String rightIds;
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
	public String getRightIds() {
		return rightIds;
	}

	public void setRightIds(String rightIds) {
		this.rightIds = rightIds;
	}

	/**
	 * 角色列表页
	 * @return
	 */
	public String list(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
		return "list";
	}
	
	/**
	 * 跳转到角色创建页
	 * @return
	 */
	public String toAdd(){
		return "add";
	}
	
	/**
	 * 取消创建返回到角色列表页
	 * @return
	 */
	public String reset(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
		return "list";
	}
	
	/**
	 * 增加后台角色
	 * 添加后跳转到列表页
	 */
	public String addRole(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		Role addObj = new Role();
		addObj.setRoleName(roleName);
		addObj.setCreateTime(now);
		addObj.setCreatePerson(creater);
		this.roleBiz.addRole(addObj);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
		return "list";
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	public String delRole(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("valid", 0);
		setParams.put("updPerson", creater);
		setParams.put("id", roleId);
		this.roleBiz.updRole(setParams);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
		return "list";
	}
	
	/**
	 * 跳转到角色修改页面
	 * @return
	 */
	public String toEdit(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("id", roleId);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		Role role =  null;
		if(list != null ){
			role = list.get(0);
			this.roleName = role.getRoleName();
		}
		return "edit";
	}
	
	/**
	 * 更新角色信息(角色名称)
	 * @return
	 */
	public String updRole(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("roleName", roleName);
		setParams.put("updPerson", creater);
		setParams.put("id", roleId);
		this.roleBiz.updRole(setParams);
		
		/**
		 * 更新用户表对应得角色名称
		 */
		Map<String,Object> updUserParams = new HashMap<String,Object>(0);
		updUserParams.put("roleName", roleName);
		updUserParams.put("updPerson", creater);
		updUserParams.put("roleId", roleId);
		this.roleBiz.updateUserByRoleId(updUserParams);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
		return "list";
	}
	
	
	/**
	 * 变更角色的权限
	 * @return
	 */
	public String addRight(){
		String userName = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			userName = sessionInfo.getUser().getUserName(); 
		}
		
		Map<String,Object> queryMap = new HashMap<String,Object>(0);
		queryMap.put("valid", 1);
		queryMap.put("roleId", roleId);
		List<RoleRight> roleRightList = this.roleBiz.queryRoleRightByMap(queryMap);
		if(roleRightList != null && !roleRightList.isEmpty()){
			
			Map<String,Object> updMap = new HashMap<String,Object>(0);
			updMap.put("menuIds", rightIds);
			updMap.put("updPerson", userName);
			updMap.put("id", roleRightList.get(0).getId());
			this.roleBiz.updRoleRight(updMap);
		}else{
			RoleRight addObj = new RoleRight();
			addObj.setMenuIds(rightIds);
			addObj.setRoleId(roleId);
			addObj.setCreatePerson(userName);
			this.roleBiz.addRoleRight(addObj);
		}
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
		return "list";
	}
	
}
