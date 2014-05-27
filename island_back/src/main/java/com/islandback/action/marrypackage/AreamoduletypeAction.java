package com.islandback.action.marrypackage;



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
import com.anjuke.core.util.ObjectUtils;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.ModuleTypeBiz;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackageType;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/marrypackage/moduletype")
@ResultPath("/WEB-INF")
public class AreamoduletypeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IslandPackageType moduleType=new IslandPackageType();//首页主推
	private Integer packageType=1;
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
	private Integer islandId;
	private String content;
	
	
	ModuleTypeBiz moduleTypeBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getModuleTypeBiz();
	
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	private List<Island> islandList=new ArrayList<Island>(0);
	private List<Area> areaList = new ArrayList<Area>(0);
	private List<IslandPackageType> moduleTypeList;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	private ObjectMapper mapper = new ObjectMapper();
	

	
	
	public String tolist(){
		doAreaList();
		doIslandList();
		doList();
		
		return "list";
	}
	
	public String toAdd(){
	    doAreaList();
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
		moduleType.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		moduleType.setCreatePerson(creater);
		moduleType.setCreateTime(now);
		moduleType.setValid(1);
		moduleType.setPackageType(packageType);
		this.moduleTypeBiz.addPackageType(moduleType);
		doList();
		doAreaList();
		doIslandList();
		return "list";
		
	}
	
	public String toEdit(){
		moduleType = moduleTypeBiz.queryPackageTypeById(id);
	    doAreaList();
	    doIslandList();
		return "edit";
	}
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		moduleType.setUpdPerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		moduleType.setUpdTime(now);
		this.moduleTypeBiz.updPackageTypeByModule(moduleType);
		doAreaList();
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
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("valid", 0);
		setParams.put("updPerson", creater);
		setParams.put("id", id);
		this.moduleTypeBiz.updPackageTypeByMap(setParams);	
		doAreaList();
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
	 
	 private void doAreaList(){
		 Map<String,Object> params = new HashMap<String,Object>(0);
			params.put("valid", 1);
		    areaList = areaIslandBiz.queryAreaByMap(params);
	}

	 private void doIslandList(){
		 if(moduleType.getAreaId() != null && moduleType.getAreaId().intValue() > 0 ){
			 Map<String,Object> params = new HashMap<String,Object>(0);
			 params.put("valid", 1);
			 params.put("areaId", moduleType.getAreaId());
			 islandList = areaIslandBiz.queryIslandByMap(params);
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
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		params.put("packageType", packageType);
		if(moduleType != null && moduleType.getAreaId() != null  && moduleType.getAreaId().intValue() > 0 ){
			params.put("areaId", moduleType.getAreaId());
			
			if(moduleType != null && moduleType.getIslandId() != null  && moduleType.getIslandId().intValue() > 0 ){
				params.put("islandId", moduleType.getIslandId());
			}
		}
		
		List<IslandPackageType> list = moduleTypeBiz.queryPackageTypeByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			countParam.put("packageType", packageType);
			if(moduleType != null && moduleType.getAreaId() != null  && moduleType.getAreaId().intValue() > 0 ){
				countParam.put("areaId", moduleType.getAreaId());
				if(moduleType != null && moduleType.getIslandId() != null  && moduleType.getIslandId().intValue() > 0 ){
					countParam.put("islandId", moduleType.getIslandId());
				}
			}
			
			this.totalSize = moduleTypeBiz.countPackageTypeByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.moduleTypeList = list;
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

	public Integer getIslandId() {
		return islandId;
	}
	public void setIslandId(Integer islandId) {
		this.islandId = islandId;
	}

	public String getContent() {
		return content;
	}

	public IslandPackageType getModuleType() {
		return moduleType;
	}

	public void setModuleType(IslandPackageType moduleType) {
		this.moduleType = moduleType;
	}

	public List<IslandPackageType> getModuleTypeList() {
		return moduleTypeList;
	}

	public void setModuleTypeList(List<IslandPackageType> moduleTypeList) {
		this.moduleTypeList = moduleTypeList;
	}
	
	

	
}
