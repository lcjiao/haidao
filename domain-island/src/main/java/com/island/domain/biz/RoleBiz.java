package com.island.domain.biz;

import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;

import com.island.domain.dal.MenuIbatisDAOImpl;
import com.island.domain.dal.RoleIbatisDAOImpl;
import com.island.domain.dal.RoleRightIbatisDAOImpl;
import com.island.domain.dal.UserIbatisDAOImpl;
import com.island.domain.model.Menu;
import com.island.domain.model.Role;
import com.island.domain.model.RoleRight;
import com.island.domain.model.User;
import com.jcl.core.config.AbsCfgListener;

public class RoleBiz extends AbsCfgListener{

	
	/**
	 * 查询后台用户
	 * @return
	 */
	public List<User> queryUserByMap(Map<String,Object> params){
		return this.userDao.queryByMap(params);
	}
	
	
	public List<RoleRight> queryRoleRightByMap(Map<String,Object> params){
		return this.roleRightDao.queryByMap(params);
	}
	
	
	public List<Menu> queryMenuByIds(Map<String,Object> params){
		return this.menuDao.queryByIds(params);
	}
	
	
	public List<User> queryUserByPage(Map<String,Object> params){
		return this.userDao.queryByMap(params);
	}
	
	
	public Integer queryUserCount(Map<String,Object> params){
		return userDao.queryUserCount(params);
	}
	
	public void addUser(User obj){
		int now = (int)(System.currentTimeMillis()/1000);
		obj.setCreateTime(now);
		this.userDao.insert(obj);
	}
	
	public void updUser(Map<String,Object> params){
		int now = (int)(System.currentTimeMillis()/1000);
		params.put("updTime", now);
		this.userDao.updateByMap(params);
	}
	
	public List<Role> queryRoleByMap(Map<String,Object> params){
		return this.roleDao.queryByMap(params);
	}
	
	public void addMenu(Menu obj){
		int now = (int)(System.currentTimeMillis()/1000);
		obj.setCreateTime(now);
		this.menuDao.insert(obj);
	}
	
	public List<Menu> queryMenuByMap(Map<String,Object> params){
		return this.menuDao.queryByMap(params);
	}
	
	public void addRole(Role obj){
		int now = (int)(System.currentTimeMillis()/1000);
		obj.setCreateTime(now);
		this.roleDao.insert(obj);
	}
	
	public void updRole(Map<String,Object> params){
		int now = (int)(System.currentTimeMillis()/1000);
		params.put("updTime", now);
		this.roleDao.updateByMap(params);
	}
	
	public void updRoleRight(Map<String,Object> params){
		int now = (int)(System.currentTimeMillis()/1000);
		params.put("updTime", now);
		this.roleRightDao.updateByMap(params);
	}
	
	public void addRoleRight(RoleRight obj){
		int now = (int)(System.currentTimeMillis()/1000);
		obj.setCreateTime(now);
		this.roleRightDao.insert(obj);
	}
	
	public Menu queryMenuById(Integer  menuId){
		return this.menuDao.queryById(menuId);
	}
	
	public void updMenuByMap(Map  params){
		 this.menuDao.updateByMap(params);
	}
	
	public void updateUserByRoleId(Map<String,Object> params){
		this.userDao.updateByRoleId(params);
	}
	
	private MenuIbatisDAOImpl menuDao;
	private RoleIbatisDAOImpl roleDao;
	private RoleRightIbatisDAOImpl roleRightDao;
	private UserIbatisDAOImpl userDao;
	public void setMenuDao(MenuIbatisDAOImpl menuDao) {
		this.menuDao = menuDao;
	}
	public void setRoleDao(RoleIbatisDAOImpl roleDao) {
		this.roleDao = roleDao;
	}
	public void setRoleRightDao(RoleRightIbatisDAOImpl roleRightDao) {
		this.roleRightDao = roleRightDao;
	}
	public void setUserDao(UserIbatisDAOImpl userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void load() {
		Configuration config = this.getDependencyConfig().get(0);
	}
	
	
	
}
