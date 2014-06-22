package com.islandback.action.right;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.island.domain.model.Role;
import com.island.domain.model.User;
import com.islandback.action.base.BaseAction;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.SessionListener;
import com.islandback.web.util.Struts2Utils;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/right/backuser")
@ResultPath("/WEB-INF")

public class BackuserAction extends BaseAction{
	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private List<User> userList = new ArrayList<User>(0);
	private List<Role> roleList = new ArrayList<Role>(0); 
	private String userName;
	private String userPass;
	private Integer roleId;
	private String roleName;
	private Integer userId;
	private String newPass;
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(Integer totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 后台用户列表信息
	 * @return
	 */
	public String list(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<User> list = roleBiz.queryUserByPage(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = roleBiz.queryUserCount(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.userList = list;
		return "list";
	}
	
	
	/**
	 * 跳转至增加后台用户
	 */
	public String toAdd(){
		//管理员身份验证
		initRoleList();
		return "add";
	}
	

	/**
	 * 增加后台用户
	 * 添加后跳转到列表页
	 */
	public String addUser(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		User addObj = new User();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setCreateTime(now);
		addObj.setUserName(userName);
		addObj.setUserPass(userPass);
		addObj.setUserRoleId(roleId);
		addObj.setRoleName(roleName);
		this.roleBiz.addUser(addObj);
		
		
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		Map<String,Object> queryParams = new HashMap<String,Object>(0);
		queryParams.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		queryParams.put("begin", page.getBegin());
		queryParams.put("size", page.getPageSize());
		List<User> list = roleBiz.queryUserByPage(queryParams);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = roleBiz.queryUserCount(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.userList = list;
		return "list";
		
	}
	
	/**
	 * 取消注册用户 跳转到列表页
	 * @return
	 */
	public String reset(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		Map<String,Object> queryParams = new HashMap<String,Object>(0);
		queryParams.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		queryParams.put("begin", page.getBegin());
		queryParams.put("size", page.getPageSize());
		List<User> list = roleBiz.queryUserByPage(queryParams);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = roleBiz.queryUserCount(countParam);
		
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.userList = list;
		return "list";
	}
	
	/**
	 * 删除用户
	 */
	public String delUser(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("valid", 0);
		setParams.put("updPerson", creater);
		setParams.put("id", userId);
		this.roleBiz.updUser(setParams);
		
		
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<User> list = roleBiz.queryUserByPage(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = roleBiz.queryUserCount(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.userList = list;
		return "list";
	}
	
	/**
	 * 跳转到编辑页
	 */
	public String toEdit(){
		initRoleList();
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("id", userId);
		List<User> list = this.roleBiz.queryUserByMap(params);
		User user =  null;
		if(list != null ){
			user = list.get(0);
			this.userName = user.getUserName();
			this.roleId = user.getUserRoleId();
			this.roleName=user.getRoleName();
		}
		return "edit";
	}
	
	/**
	 * 编辑用户
	 */
	public String updUser(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("userName", userName);
		setParams.put("userRoleId", roleId);
		setParams.put("roleName", roleName);
		setParams.put("updPerson", creater);
		setParams.put("id", userId);
		this.roleBiz.updUser(setParams);
		
		
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<User> list = roleBiz.queryUserByPage(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = roleBiz.queryUserCount(countParam);
	
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.userList = list;
		return "list";
	}
	
	public void getUserByRole(){
		boolean isHas = false;
		Map<String,Object> queryParams = new HashMap<String,Object>(0);
		queryParams.put("valid", 1);
		queryParams.put("userRoleId", roleId);
		List<User> list = roleBiz.queryUserByMap(queryParams);
		if(list != null && list.size()>0){
			isHas = true;
		}
		if( isHas ){
			Struts2Utils.renderText("has");
		}else{
			Struts2Utils.renderText("no");
		}
	}
	
	private void initTotalPageSize(){
		if(totalSize % pageSize == 0 ){
			this.totalPageSize = totalSize / pageSize;
		}else{
			this.totalPageSize = ( totalSize / pageSize )+ 1;
		}
		
	}
	
	private void initRoleList(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Role> list = this.roleBiz.queryRoleByMap(params);
		roleList = list;
	}
	
	
	public String toChangePass(){
		return "changepass";
	}
	
	public void changePass(){
		if( !newPassOne.equals(newPass)){
			Struts2Utils.renderText("密码不一致");
			return;
		}
		SessionInfo loginSession = RequestProcc.getSessionInfo();
		User loginUser = null;
		if( loginSession != null ){
			loginUser = loginSession.getUser();
		}else{
			Struts2Utils.renderText("请登录");
			return;
		}
		userName = loginUser.getUserName();

		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("userName", userName);
		params.put("userPass", userPass);
		List<User> list = roleBiz.queryUserByMap(params);
		if(list == null || list.isEmpty()){
			Struts2Utils.renderText("密码不正确");
			return;
		}else{
			User user = list.get(0);
			Map<String,Object> passParams = new HashMap<String,Object>(0);
			passParams.put("id", user.getId());
			passParams.put("userPass", newPass);
			roleBiz.updUser(passParams);
		}
		
		SessionInfo sessinInfo = new SessionInfo();
		User user = list.get(0);
		sessinInfo.setUser(user);
		RequestProcc.setSessionInfo(sessinInfo);
		SessionListener.isAlreadyEnter(RequestProcc.getSession(), user.getUserName() );
		Struts2Utils.renderText("密码修改成功");
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	private String newPassOne;
	public String getNewPassOne() {
		return newPassOne;
	}

	public void setNewPassOne(String newPassOne) {
		this.newPassOne = newPassOne;
	}
	
	
	
}
