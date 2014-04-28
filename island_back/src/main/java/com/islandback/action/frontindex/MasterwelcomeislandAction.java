package com.islandback.action.frontindex;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.FrontIndexBiz;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/front/masterwelcomeisland")
@ResultPath("/WEB-INF")
/**
 *最受欢迎岛屿
 *
 */
public class MasterwelcomeislandAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String link;
	private Integer index;
	private String title;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageNo=1;
	private Integer pageSize=10;
	private List<Recommend> recommendList;
	FrontIndexBiz frontIndexBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getFrontIndexBiz();
	
	public String list(){
		doList();
		return "list";
	}
	
	
	public String toAdd(){
		RequestProcc.getSession().invalidate();
		return "add";
	}
	
	public String execute(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Recommend addObj = new Recommend();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setModuleId(ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
		addObj.setLinkUrl(link);
		addObj.setTitle(title);
		addObj.setCreatePerson(creater);
		addObj.setCreateTime(now);
		addObj.setRecommendIndex(index);
		addObj.setValid(1);
		this.frontIndexBiz.addMasterRecommend(addObj);
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
		this.frontIndexBiz.updRecommend(setParams);		
		doList();
		return "list";
	}
	
	public String toEdit(){
		Recommend obj = frontIndexBiz.queryById(id);
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
		
		
		this.frontIndexBiz.updRecommend(params);		
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
		params.put("moduleId", ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<Recommend> list = frontIndexBiz.queryByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("moduleId", ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
			countParam.put("valid", 1);
			this.totalSize = frontIndexBiz.countByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
}
