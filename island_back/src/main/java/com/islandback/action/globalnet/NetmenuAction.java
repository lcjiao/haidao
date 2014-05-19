package com.islandback.action.globalnet;



import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.GlobalNetBiz;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/globalnet/menu")
@ResultPath("/WEB-INF")
public class NetmenuAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String link;
	private Integer index;
	private String title;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private List<Recommend> recommendList;
	
	GlobalNetBiz globalNetBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGlobalNetBiz();
	
	
	
	public String list(){
		doList();
		return "list";
	}
	
	
	/**
	 * 跳转至前台菜单添加
	 */
	public String toAdd(){
		RequestProcc.getSession().invalidate();
		return "add";
	}
	
	public String add(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		
		Recommend addObj = new Recommend();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setModuleId(ModuleEnum.NET_MENU);
		addObj.setLinkUrl(link);
		addObj.setTitle(title);
		addObj.setCreatePerson(creater);
		addObj.setCreateTime(now);
		addObj.setRecommendIndex(index);
		addObj.setValid(1);
		changeIndexBySys(creater);
		this.globalNetBiz.addMasterRecommend(addObj);
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
		this.globalNetBiz.updRecommend(setParams);		
		doList();
		return "list";
	}
	
	public String toEdit(){
		Recommend obj = globalNetBiz.queryRecommendById(id);
		this.link=obj.getLinkUrl();
		this.title=obj.getTitle();
		this.index=obj.getRecommendIndex();
		return "edit";
	}
	
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("title", title);
		params.put("recommendIndex", index);
		params.put("linkUrl", link);
		params.put("updPerson", creater);
		params.put("id", id);
		
		changeIndexBySys(creater);
		
		this.globalNetBiz.updRecommend(params);		
		doList();
		return "list";
	}
	
	private void changeIndexBySys(String creater){
		Recommend thisObj = this.globalNetBiz.queryRecommendById(id);
		/**
		 * 查询之前此排序得条目 如存在对调排序次序
		 */
		Map<String,Object> indexParams = new HashMap<String,Object>(0);
		indexParams.put("recommendIndex", index);
		indexParams.put("moduleId", ModuleEnum.NET_MENU);
		indexParams.put("valid", 1);
		List<Recommend> list = globalNetBiz.queryRecommendByMap(indexParams);
		Recommend oldIndexObj = null;
		if( list != null && !list.isEmpty()){
			oldIndexObj = list.get(0);
		}
		if( oldIndexObj != null && thisObj != null){
			Map<String,Object> oldObjParams = new HashMap<String,Object>(0);
			oldObjParams.put("recommendIndex", thisObj.getRecommendIndex());
			oldObjParams.put("updPerson", creater);
			oldObjParams.put("id", oldIndexObj.getId());
			this.globalNetBiz.updRecommend(oldObjParams);
		}	
	}
	private void doList(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.NET_MENU);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<Recommend> list = globalNetBiz.queryRecommendByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("moduleId", ModuleEnum.NET_MENU);
			countParam.put("valid", 1);
			this.totalSize = globalNetBiz.countRecommendByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		Collections.sort(list);
		this.recommendList = list;
	}
	

	private void initTotalPageSize(){
			if(totalSize % pageSize == 0 ){
				this.totalPageSize = totalSize / pageSize;
			}else{
				this.totalPageSize = ( totalSize / pageSize )+ 1;
			}
			
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Recommend> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<Recommend> recommendList) {
		this.recommendList = recommendList;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	
}
