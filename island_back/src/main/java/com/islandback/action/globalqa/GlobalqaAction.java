package com.islandback.action.globalqa;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.GlobalQaBiz;
import com.island.domain.model.GlobalQa;
import com.island.domain.model.GlobalQaType;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/globalqa/globalqa")
@ResultPath("/WEB-INF")
public class GlobalqaAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private GlobalQa globalQa;
	private Integer id;
	private File image;
	private String imageFileName;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	
	
	private List<GlobalQa> globalQaList;
	private List<GlobalQaType> globalQaTypeList;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	GlobalQaBiz globalQaBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGlobalQaBiz();
	
	
	public void doGlobalQaTypeList(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		globalQaTypeList = this.globalQaBiz.queryGlobalQaTypeByMap(params);
	}
	
	
	public String tolist(){
		doList();
		doGlobalQaTypeList();
		return "list";
	}
	
	public String toAdd(){
		doGlobalQaTypeList();
		return "add";
	}
	
	public String add(){
		//管理员身份验证
		
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		globalQa.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		globalQa.setCreatePerson(creater);
		globalQa.setCreateTime(now);
		globalQa.setValid(1);
		this.globalQaBiz.addGlobalQa(globalQa);
		doList();
		doGlobalQaTypeList();
		return "list";
		
	}
	
	public String toEdit(){
		doGlobalQaTypeList();
		globalQa =this.globalQaBiz.queryGlobalQaById(id);
		return "edit";
	}
	
	public String toSee(){
		doGlobalQaTypeList();
		globalQa =this.globalQaBiz.queryGlobalQaById(id);
		return "see";
	}
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		globalQa.setUpdPerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		globalQa.setUpdTime(now);
		this.globalQaBiz.updGlobalQaByModel(globalQa);
		doGlobalQaTypeList();
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
		this.globalQaBiz.updGlobalQaByMap(setParams);
		doGlobalQaTypeList();
		doList();
		return "list";
	}
	
	 public String upload() {  
		   if(image == null){
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
	              FileUtils.copyFile(image, new File(file, imageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return ModuleEnum.getImageServUrl()+namePrefix+"/"+imageFileName;  
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
		List<GlobalQa> list = globalQaBiz.queryGlobalQaByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			this.totalSize = globalQaBiz.countGlobalQaByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.globalQaList = list;
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


	public GlobalQa getGlobalQa() {
		return globalQa;
	}


	public void setGlobalQa(GlobalQa globalQa) {
		this.globalQa = globalQa;
	}


	public List<GlobalQa> getGlobalQaList() {
		return globalQaList;
	}


	public void setGlobalQaList(List<GlobalQa> globalQaList) {
		this.globalQaList = globalQaList;
	}


	public List<GlobalQaType> getGlobalQaTypeList() {
		return globalQaTypeList;
	}


	public void setGlobalQaTypeList(List<GlobalQaType> globalQaTypeList) {
		this.globalQaTypeList = globalQaTypeList;
	}

	
	
}
