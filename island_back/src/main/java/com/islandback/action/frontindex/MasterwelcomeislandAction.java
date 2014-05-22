package com.islandback.action.frontindex;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RecommendBiz;
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
	
	private File image;
	private String imageFileName;
	private String imageServPath=ModuleEnum.IMAGE_SAVE_PATH;
	private String imageServPrefix=ModuleEnum.IMAGE_SERV_PREFIX;
	private File bigImage;
	private String bigImageFileName;
	private String type;
	
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	
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
		if("changeImg".equalsIgnoreCase(type)){
			Map<String,Object> setParams = new HashMap<String,Object>(0);
			setParams.put("updPerson", creater);
			setParams.put("id", id);
			if(image != null ){
				setParams.put("imgUrl", uploadImage());
			}
			if(bigImage != null){
				setParams.put("bigImgUrl", uploadBigImage());
				
			}
			setParams.put("recommendIndex", index);
			changeIndexBySys(creater);
			this.recommendBiz.updRecommend(setParams);	
			doList();
			return "list";
		}
		Recommend addObj = new Recommend();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setModuleId(ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
		addObj.setLinkUrl(link);
		if(bigImage != null){
			addObj.setBigImgUrl(uploadBigImage());
		}
		if(image != null ){
			addObj.setImgUrl(uploadImage());
			
		}
		addObj.setCreatePerson(creater);
		addObj.setCreateTime(now);
		addObj.setRecommendIndex(index);
		addObj.setValid(1);
		
		this.recommendBiz.addMasterRecommend(addObj);
		doList();
		return "list";
		
	}
	
	public String uploadBigImage() {  
		   if(bigImage == null){
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
	              FileUtils.copyFile(bigImage, new File(file, bigImageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return imageServPrefix+namePrefix+"/"+bigImageFileName;  
	  }  
	
	public String uploadImage() {  
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
		this.recommendBiz.updRecommend(setParams);		
		doList();
		return "list";
	}
	
	public String toEdit(){
		Recommend obj = recommendBiz.queryById(id);
		this.link=obj.getLinkUrl();
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
		if(image != null ){
			params.put("imgUrl", uploadImage());
		}
		if(bigImage != null){
			params.put("bigImgUrl", uploadBigImage());
			
		}
		params.put("recommendIndex", index);
		params.put("linkUrl", link);
		params.put("updPerson", creater);
		params.put("id", id);
		
		changeIndexBySys(creater);

		
		this.recommendBiz.updRecommend(params);		
		doList();
		return "list";
	}
	
	private void changeIndexBySys(String creater){
		Recommend thisObj = this.recommendBiz.queryById(id);
		/**
		 * 查询之前此排序得条目 如存在对调排序次序
		 */
		Map<String,Object> indexParams = new HashMap<String,Object>(0);
		indexParams.put("recommendIndex", index);
		indexParams.put("moduleId", ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
		indexParams.put("valid", 1);
		List<Recommend> list = recommendBiz.queryByMap(indexParams);
		Recommend oldIndexObj = null;
		if( list != null && !list.isEmpty()){
			oldIndexObj = list.get(0);
		}
		if( oldIndexObj != null && thisObj != null){
			Map<String,Object> oldObjParams = new HashMap<String,Object>(0);
			oldObjParams.put("recommendIndex", thisObj.getRecommendIndex());
			oldObjParams.put("updPerson", creater);
			oldObjParams.put("id", oldIndexObj.getId());
			this.recommendBiz.updRecommend(oldObjParams);
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
		params.put("moduleId", ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<Recommend> list = recommendBiz.queryByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("moduleId", ModuleEnum.FRONT_INDEX_MASTER_WELCOME_ISLAND);
			countParam.put("valid", 1);
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
	public String getImageServPath() {
		return imageServPath;
	}
	public void setImageServPath(String imageServPath) {
		this.imageServPath = imageServPath;
	}
	public File getBigImage() {
		return bigImage;
	}
	public void setBigImage(File bigImage) {
		this.bigImage = bigImage;
	}
	public String getBigImageFileName() {
		return bigImageFileName;
	}
	public void setBigImageFileName(String bigImageFileName) {
		this.bigImageFileName = bigImageFileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
