package com.islandback.action.areaisland;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/areaisland/island")
@ResultPath("/WEB-INF")
/**
 *岛屿
 *
 */
public class IslandAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer index;
	private String name;
	private Integer areaId;
	private String areaName;
	private String country;
	private String desc;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageNo=1;
	private Integer pageSize=10;
	private List<Island> islandList;
	private List<Area> areaList;
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	public String list(){
		doList();
		return "list";
	}
	
	
	public String toAdd(){
		RequestProcc.getSession().invalidate();
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		
		return "add";
	}
	
	public String addIsland(){
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Island addObj = new Island();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setName(name);
		addObj.setAreaId(areaId);
		addObj.setAreaName(areaName);
		addObj.setCountry(country);
		addObj.setIslandDesc(desc);
		addObj.setCreatePerson(creater);
		addObj.setCreateTime(now);
		addObj.setValid(1);
		
		this.areaIslandBiz.addIsland(addObj);
		doList();
		return "list";
		
	}
	
	public String del(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("valid", 0);
		setParams.put("updPerson", creater);
		setParams.put("id", id);
		this.areaIslandBiz.updIsland(setParams);	
		doList();
		return "list";
	}
	
	public String toEdit(){
		Island obj = areaIslandBiz.queryIslandById(id);
		this.name=obj.getName();
		this.areaId=obj.getAreaId();
		this.areaName=obj.getAreaName();
		this.country=obj.getCountry();
		this.desc=obj.getIslandDesc();
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		return "edit";
	}
	
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("name", name);
		params.put("areaId", areaId);
		params.put("areaName", areaName);
		params.put("country", country);
		params.put("islandDesc", desc);
		params.put("updPerson", creater);
		params.put("id", id);
		

		
		this.areaIslandBiz.updIsland(params);		
		doList();
		return "list";
	}
	

	
	private void doList(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 5;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<Island> list = areaIslandBiz.queryIslandByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = areaIslandBiz.countIslandByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.islandList = list;
	}
	

	private void initTotalPageSize(){
			if(totalSize % pageSize == 0 ){
				this.totalPageSize = totalSize / pageSize;
			}else{
				this.totalPageSize = ( totalSize / pageSize )+ 1;
			}
			
	}
	
	public String testKindeditor(){
		return "demo";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(Integer totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Island> getIslandList() {
		return islandList;
	}
	public void setIslandList(List<Island> islandList) {
		this.islandList = islandList;
	}
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	
}
