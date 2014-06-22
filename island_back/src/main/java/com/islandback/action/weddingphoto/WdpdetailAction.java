package com.islandback.action.weddingphoto;



import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.codehaus.jackson.map.ObjectMapper;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/weddingphoto/wdpdetail")
@ResultPath("/WEB-INF")
public class WdpdetailAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Recommend recommend;
	private Integer id;
	
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	
	public String toManager(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.WEDDING_PHOTO_SINGLE_PAGE_RECOMMEND);
		params.put("valid", 1);
		List<Recommend> list = recommendBiz.queryByMap(params);
		if(list != null && list.size()>0){
			this.recommend = list.get(0);
		}
		return "manager";
	}
	
	private String getCreater(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			return sessionInfo.getUser().getUserName(); 
		}
		return "";
	}
	
	public String add(){
		//管理员身份验证
		
		recommend.setCreatePerson(getCreater());
		int now = (int)(System.currentTimeMillis()/1000);
		recommend.setModuleId(ModuleEnum.WEDDING_PHOTO_SINGLE_PAGE_RECOMMEND);
		recommend.setCreatePerson(getCreater());
		recommend.setCreateTime(now);
		recommend.setValid(1);
		this.recommendBiz.addMasterRecommend(recommend);
		return "list";
		
	}
	
	
	public String edit(){
		
		recommend.setUpdPerson(getCreater());
		int now = (int)(System.currentTimeMillis()/1000);
		recommend.setUpdTime(now);
		this.recommendBiz.updRecommendByModel(recommend);
		return "list";
	}
	
	
	

	
	public String  managerDetailRecommend(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.WEDDING_PHOTO_SINGLE_PAGE_RECOMMEND);
		params.put("valid", 1);
		List<Recommend> list = recommendBiz.queryByMap(params);
		if(list != null && list.size()>0){
			edit();
		}else{
			add();
		}
		return "manager";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Recommend getRecommend() {
		return recommend;
	}
	public void setRecommend(Recommend recommend) {
		this.recommend = recommend;
	}
	

	
}
