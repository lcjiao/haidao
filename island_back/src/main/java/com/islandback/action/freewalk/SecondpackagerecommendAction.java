package com.islandback.action.freewalk;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/freewalk/secondpackage")
@ResultPath("/WEB-INF")
public class SecondpackagerecommendAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Recommend recommend;//首页主推
	private Integer packageType=5;
	private Integer id;
	private File image;
	private String imageFileName;
	private String imageServPath=ModuleEnum.IMAGE_SAVE_PATH;
	private String imageServPrefix=ModuleEnum.IMAGE_SERV_PREFIX;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private Integer areaId;
	private Integer recommendType = 3;
	private String recommendTypeName="岛屿推荐";
	
	
	
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	private List<Island> islandList=new ArrayList<Island>(0);
	private List<Area> areaList;
	private List<Recommend> recommendList;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	private ObjectMapper mapper = new ObjectMapper();
	

	
	
	public String tolist(){
		doIslandList();
		 
		doList();
		
		 
		
		return "list";
	}
	
	public String toAdd(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
	    
	    doIslandList();
	    
		return "add";
	}
	
	public String add(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		recommend.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		recommend.setModuleId(ModuleEnum.FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND);
		if(image != null ){
			recommend.setImgUrl(upload());
		}
		recommend.setCreatePerson(creater);
		recommend.setCreateTime(now);
		recommend.setValid(1);
		recommend.setTypeId(recommendType);
		recommend.setTypeName(recommendTypeName);
		this.recommendBiz.addMasterRecommend(recommend);
		doList();
		doIslandList();
		return "list";
		
	}
	
	public String toEdit(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		
	    doIslandList();
	    
		recommend = recommendBiz.queryById(id);
		
		
		return "edit";
	}
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		recommend.setUpdPerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		if(image != null  ){
			recommend.setImgUrl(upload());
		}
		recommend.setUpdTime(now);
		this.recommendBiz.updRecommendByModel(recommend);
		doIslandList();
		doList();
		return "list";
	}
	
	
	public String del(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		recommend = recommendBiz.queryById(id);
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("valid", 0);
		setParams.put("updPerson", creater);
		setParams.put("id", id);
		this.recommendBiz.updRecommend(setParams);
		doIslandList();
		doList();
		return "list";
	}
	public void getIslandByArea() throws JsonGenerationException, JsonMappingException, IOException{
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		params.put("areaId", areaId);
		List<Island> list = areaIslandBiz.queryIslandByMap(params);
		Struts2Utils.renderJson(mapper.writeValueAsString(list));
	}
	
	 public String upload() {  
		   if(image == null){
			   return "";
		   }
		   Date date = new Date();
	   	   String namePrefix=format.format(date);
	       String path = imageServPath+namePrefix;
	       File file = new File(path);  
	       if (!file.exists()) {  
	           file.mkdirs();  
	       }  
	       try {  
	              FileUtils.copyFile(image, new File(file, imageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return imageServPrefix+namePrefix+"/"+imageFileName;  
	  }  

	 private void doIslandList(){
			Map<String,Object> params = new HashMap<String,Object>(0);
			params.put("moduleId", ModuleEnum.FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND);
			params.put("valid", 1);
			params.put("typeId", 2);
			List<Recommend> list = recommendBiz.queryByMap(params);
			islandList = new ArrayList<Island>(0);
			for(Recommend recommend : list){
		    	Integer islandId = recommend.getIslandId();
		    	Island obj = areaIslandBiz.queryIslandById(islandId);
		    	islandList.add(obj);
		    }
		    
		}
	
	private void doList(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 5;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		params.put("typeId", recommendType);
		if(recommend != null && recommend.getIslandId() != null  && recommend.getIslandId().intValue() > 0 ){
			params.put("islandId", recommend.getIslandId());
		}
		
		List<Recommend> list = recommendBiz.queryByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("moduleId", ModuleEnum.FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND);
			countParam.put("valid", 1);
			countParam.put("typeId", recommendType);
			if(recommend != null && recommend.getIslandId() != null  && recommend.getIslandId().intValue() > 0 ){
				countParam.put("islandId", recommend.getIslandId());
			}
			this.totalSize = recommendBiz.countByMap(countParam);
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
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPackageType() {
		return packageType;
	}
	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}
	public Recommend getRecommend() {
		return recommend;
	}
	public void setRecommend(Recommend recommend) {
		this.recommend = recommend;
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
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	

	
}
