package com.islandback.action.globalnet;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.GlobalNetBiz;
import com.island.domain.model.BlackWord;
import com.islandback.action.base.BaseAction;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;

//@SuppressWarnings("serial")
@Namespace("/globalnet/blackword")
@ResultPath("/WEB-INF")
public class BlackwordAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private BlackWord blackWord;
	private Integer id;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=20;
	
	
	GlobalNetBiz globalNetBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGlobalNetBiz();
	
	private List<BlackWord> blackwordList;
	
	

	
	
	public String tolist(){
		doList();
		return "list";
	}
	
	public String toAdd(){
		return "add";
	}
	
	public String add(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		blackWord.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		blackWord.setCreatePerson(creater);
		blackWord.setCreateTime(now);
		blackWord.setValid(1);
		this.globalNetBiz.addBlackWord(blackWord);
		doList();
		return "list";
		
	}
	
	public String toEdit(){
	    
	    blackWord = globalNetBiz.queryBlackWordById(id);
		
		
		return "edit";
	}
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		blackWord.setUpdPerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		blackWord.setUpdTime(now);
		this.globalNetBiz.updBlackWordByModel(blackWord);
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
		this.globalNetBiz.updBlackWordByMap(setParams);
		doList();
		return "list";
	}
	

	
	private void doList(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 20;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<BlackWord> list = globalNetBiz.queryBlackWordByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = globalNetBiz.countBlackWordByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.blackwordList = list;
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

	public BlackWord getBlackWord() {
		return blackWord;
	}

	public void setBlackWord(BlackWord blackWord) {
		this.blackWord = blackWord;
	}

	public List<BlackWord> getBlackwordList() {
		return blackwordList;
	}

	public void setBlackwordList(List<BlackWord> blackwordList) {
		this.blackwordList = blackwordList;
	}
	

	

	
}
