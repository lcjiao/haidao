package com.islandback.action.globalnet;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.codehaus.jackson.map.ObjectMapper;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.GlobalNetBiz;
import com.island.domain.model.Area;
import com.island.domain.model.Country;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/globalnet/country")
@ResultPath("/WEB-INF")
public class CountryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Country country;
	private Integer id;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private Integer areaId;
	
	
	GlobalNetBiz globalNetBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGlobalNetBiz();
	
	
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	private List<Area> areaList;
	private List<Country> countryList;
	
	

	
	
	public String tolist(){
		doList();
		return "list";
	}
	
	public String toAdd(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		return "add";
	}
	
	public String add(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		country.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		country.setCreatePerson(creater);
		country.setCreateTime(now);
		country.setValid(1);
		this.globalNetBiz.addCountry(country);
		doList();
		return "list";
		
	}
	
	public String toEdit(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		
	    
	    country = globalNetBiz.queryCountryById(id);
		
		
		return "edit";
	}
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		country.setUpdPerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		country.setUpdTime(now);
		this.globalNetBiz.updConutryByModel(country);
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
		this.globalNetBiz.updCountryByMap(setParams);
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
		List<Country> list = globalNetBiz.queryCountryByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = globalNetBiz.countCountryByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.countryList = list;
	}
	private void initTotalPageSize(){
		if(totalSize % pageSize == 0 ){
			this.totalPageSize = totalSize / pageSize;
		}else{
			this.totalPageSize = ( totalSize / pageSize )+ 1;
		}
		
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	

	
}
