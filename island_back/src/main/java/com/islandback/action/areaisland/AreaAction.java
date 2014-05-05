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
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/areaisland/area")
@ResultPath("/WEB-INF")
/**
 *区域
 *
 */
public class AreaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer index;
	private String name;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageNo=1;
	private Integer pageSize=10;
	private List<Area> areaList;
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	public String list(){
		doList();
		return "list";
	}
	
	
	public String toAdd(){
		RequestProcc.getSession().invalidate();
		return "add";
	}
	
	public String addArea(){
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Area addObj = new Area();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setName(name);
		addObj.setCreatePerson(creater);
		addObj.setCreateTime(now);
		addObj.setValid(1);
		
		this.areaIslandBiz.addArea(addObj);
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
		this.areaIslandBiz.updArea(setParams);	
		doList();
		return "list";
	}
	
	public String toEdit(){
		Area obj = areaIslandBiz.queryAreaById(id);
		this.name=obj.getName();
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
		params.put("updPerson", creater);
		params.put("id", id);
		

		
		this.areaIslandBiz.updArea(params);		
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
		List<Area> list = areaIslandBiz.queryAreaByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = areaIslandBiz.countAreaByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.areaList = list;
	}
	

	private void initTotalPageSize(){
			if(totalSize % pageSize == 0 ){
				this.totalPageSize = totalSize / pageSize;
			}else{
				this.totalPageSize = ( totalSize / pageSize )+ 1;
			}
			
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
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
	
}
