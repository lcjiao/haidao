package com.islandback.action.islandmap;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.IslandMapBiz;
import com.island.domain.model.Island;
import com.island.domain.model.IslandMap;
import com.island.domain.model.IslandPackageType;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;

@Namespace("/wedfront")
@ResultPath("/WEB-INF")
/**
 *岛屿
 *
 */
public class IslandmapAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer islandId;
	private Integer packageType;
	private IslandMap islandMap = new IslandMap();
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageNo=1;
	private Integer pageSize=10;
	private List<Island> islandList;
	private List<IslandMap> islandMapList;
	
	private String backImgUrl;
	private String frontImgUrl;
	
	private File backimage;
	private String backimageFileName;
	
	
	private File frontimage;
	private String frontimageFileName;
	
	
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	IslandMapBiz islandMapBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getIslandMapBiz();
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public String list(){
		doList();
		return "list";
	}
	
	public String toAddImg(){
		return "img";
	}
	
	public String toAddLng(){
		return "addlng";
	}
	
	public String toEditLng(){
		islandMap = this.islandMapBiz.queryMapById(id);
		return "editlng";
	}
	
	public String toLngList(){
		Map<String,Object> lngParams = new HashMap<String,Object>(0);
		lngParams.put("packageType", packageType);
		lngParams.put("islandId", islandId);
		lngParams.put("areaId", 2);
		lngParams.put("valid", 1);
		islandMapList = islandMapBiz.queryMapByMap(lngParams);
		
		return "lnglist";
	}
	
	
	public String mapImg(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("packageType", packageType);
		params.put("islandId", islandId);
		params.put("valid", 1);

		List<IslandMap> islandMapList = islandMapBiz.queryMapByMap(params);
		if( islandMapList != null && !islandMapList.isEmpty()){
			
			for(IslandMap obj :islandMapList ){
				
				if( backimage != null ){
					obj.setMapBigImg(uploadback());
				}
				if( frontimage != null ){
					obj.setMapSmallImg(uploadfront());
				}
				obj.setUpdPerson(creater);
				obj.setUpdTime(now);
				obj.setId(obj.getId());
				obj.setIslandId(islandId);
				obj.setPackageType(packageType);
				
				this.islandMapBiz.updMapByModel(obj);
			}
			
		}else{
			
			if( backimage != null ){
				islandMap.setMapBigImg(uploadback());
			}
			if( frontimage != null ){
				islandMap.setMapSmallImg(uploadfront());
			}
			islandMap.setIslandId(islandId);
			islandMap.setPackageType(packageType);
			islandMap.setCreatePerson(creater);
			islandMap.setCreateTime(now);
			islandMap.setValid(1);
			islandMap.setAreaId(1);
			this.islandMapBiz.addMap(islandMap);
		}
		
		
		
		doList();
		return "list";
		
		
	}
	
	
	public String addMapLng(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("packageType", packageType);
		params.put("islandId", islandId);
		params.put("areaId", 1);
		params.put("valid", 1);

		List<IslandMap> islandMapImgList = islandMapBiz.queryMapByMap(params);
		String frontImgUrl ="";
		String backImgUrl = "";
			
		if( islandMapImgList != null && !islandMapImgList.isEmpty() ){
			IslandMap imgMap = islandMapImgList.get(0);
			frontImgUrl = imgMap.getMapSmallImg();
			backImgUrl = imgMap.getMapBigImg();
		}
		
		islandMap.setMapBigImg(backImgUrl);
		islandMap.setMapSmallImg(frontImgUrl);
		islandMap.setPackageType(packageType);
		islandMap.setIslandId(islandId);
		islandMap.setAreaId(2);
		islandMap.setCreatePerson(creater);
		islandMap.setCreateTime(now);
		islandMap.setValid(1);
		
		this.islandMapBiz.addMap(islandMap);
		
		
		//this.packageType=islandMap.getPackageType();
		toLngList();
		return "lnglist";
		
		
	}
	
	
	public String editMapLng(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		
			
		islandMap.setUpdPerson(creater);
		islandMap.setUpdTime(now);
		islandMap.setValid(1);
		
		this.islandMapBiz.updMapByModel(islandMap);
		
		
		//this.packageType=islandMap.getPackageType();
		toLngList();
		return "lnglist";
		
		
	}
	
	
	public String delMapLng(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		
			
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("id", id);
		params.put("valid", 0);
		params.put("updPerson", creater);
		params.put("updTime", now);
		this.islandMapBiz.updMapByMap(params);
		
		
		toLngList();
		return "lnglist";
		
		
	}
	public String seeMap(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("packageType", packageType);
		params.put("islandId", islandId);
		params.put("areaId", 1);
		params.put("valid", 1);

		List<IslandMap> islandMapImgList = islandMapBiz.queryMapByMap(params);
			
		if( islandMapImgList != null && !islandMapImgList.isEmpty() ){
			IslandMap imgMap = islandMapImgList.get(0);
			frontImgUrl = imgMap.getMapSmallImg();
			backImgUrl = imgMap.getMapBigImg();
		}
		
		Map<String,Object> lngParams = new HashMap<String,Object>(0);
		lngParams.put("packageType", packageType);
		lngParams.put("islandId", islandId);
		lngParams.put("areaId", 2);
		lngParams.put("valid", 1);
		islandMapList = islandMapBiz.queryMapByMap(lngParams);
		
		return "see";
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
	
	
	 public String uploadback() {  
		   if(backimage == null){
			   return "";
		   }
		   Date date = new Date();
	   	   String namePrefix=format.format(date);
	       String path = ModuleEnum.getImageSavePath()+namePrefix;
	       File file = new File(path);  
	       if (!file.exists()) {  
	           file.mkdirs();  
	       }  
	       try {  
	              FileUtils.copyFile(backimage, new File(file, backimageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return ModuleEnum.getImageServUrl()+namePrefix+"/"+backimageFileName;  
	  }  
	 
	 
	 public String uploadfront() {  
		   if(frontimage == null){
			   return "";
		   }
		   Date date = new Date();
	   	   String namePrefix=format.format(date);
	       String path = ModuleEnum.getImageSavePath()+namePrefix;
	       File file = new File(path);  
	       if (!file.exists()) {  
	           file.mkdirs();  
	       }  
	       try {  
	              FileUtils.copyFile(frontimage, new File(file, frontimageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return ModuleEnum.getImageServUrl()+namePrefix+"/"+frontimageFileName;  
	  }  

	 public void checkHasBackImg() throws JsonGenerationException, JsonMappingException, IOException{
		 Map<String,Object> params = new HashMap<String,Object>(0);
			params.put("packageType", packageType);
			params.put("islandId", islandId);
			params.put("areaId", 1);
			params.put("valid", 1);

			List<IslandMap> islandMapImgList = islandMapBiz.queryMapByMap(params);
				
			if( islandMapImgList != null && !islandMapImgList.isEmpty() ){
				Struts2Utils.renderText("has");
			}else{
				Struts2Utils.renderText("no");
			}
		}
		
	public String testKindeditor(){
		return "demo";
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
	public List<Island> getIslandList() {
		return islandList;
	}
	public void setIslandList(List<Island> islandList) {
		this.islandList = islandList;
	}


	public Integer getIslandId() {
		return islandId;
	}


	public void setIslandId(Integer islandId) {
		this.islandId = islandId;
	}


	public Integer getPackageType() {
		return packageType;
	}


	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}


	public IslandMap getIslandMap() {
		return islandMap;
	}


	public void setIslandMap(IslandMap islandMap) {
		this.islandMap = islandMap;
	}

	public File getBackimage() {
		return backimage;
	}

	public void setBackimage(File backimage) {
		this.backimage = backimage;
	}

	public String getBackimageFileName() {
		return backimageFileName;
	}

	public void setBackimageFileName(String backimageFileName) {
		this.backimageFileName = backimageFileName;
	}

	public File getFrontimage() {
		return frontimage;
	}

	public void setFrontimage(File frontimage) {
		this.frontimage = frontimage;
	}

	public String getFrontimageFileName() {
		return frontimageFileName;
	}

	public void setFrontimageFileName(String frontimageFileName) {
		this.frontimageFileName = frontimageFileName;
	}

	public String getBackImgUrl() {
		return backImgUrl;
	}

	public void setBackImgUrl(String backImgUrl) {
		this.backImgUrl = backImgUrl;
	}

	public String getFrontImgUrl() {
		return frontImgUrl;
	}

	public void setFrontImgUrl(String frontImgUrl) {
		this.frontImgUrl = frontImgUrl;
	}

	public List<IslandMap> getIslandMapList() {
		return islandMapList;
	}

	public void setIslandMapList(List<IslandMap> islandMapList) {
		this.islandMapList = islandMapList;
	}
	
	
}
