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
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/front/packagerecommend")
@ResultPath("/WEB-INF")
/**
 * http://blog.csdn.net/redarmy_chen/article/details/7342247
 * @author lcjiao
 *
 */
public class PackagerecommendAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String link;
	private Integer index;
	private String desc;
	private File image;
	private String imageFileName;
	//private String imageServPath=ModuleEnum.IMAGE_SAVE_PATH;
	//private String imageServPrefix=ModuleEnum.IMAGE_SERV_PREFIX;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=5;
	private String type;
	private List<Recommend> recommendList;
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	
	public String list(){
		doList();
		return "list";
	}
	
	
	/**
	 * 跳转至增加首页主打产品添加
	 */
	public String toAdd(){
		return "add";
	}
	/**
	 * 增加首页主打产品
	 * 添加后跳转到列表页
	 */
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
			if(image != null){
				setParams.put("imgUrl", upload());
			}
			this.recommendBiz.updRecommend(setParams);	
			doList();
			return "list";
		}
		Recommend addObj = new Recommend();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setModuleId(ModuleEnum.FRONT_PACKAGE_RECOMMEND);
		addObj.setLinkUrl(link);
		addObj.setRecommendDesc(desc);
		if(image != null ){
			addObj.setImgUrl(upload());
		}
		addObj.setCreatePerson(creater);
		addObj.setCreateTime(now);
		addObj.setRecommendIndex(index);
		addObj.setValid(1);
		
		//changeIndexBySys(creater);
		
		this.recommendBiz.addMasterRecommend(addObj);
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
		this.recommendBiz.updRecommend(setParams);		
		doList();
		return "list";
	}
	
	public String toEdit(){
		Recommend obj = recommendBiz.queryById(id);
		this.link=obj.getLinkUrl();
		this.desc=obj.getRecommendDesc();
		this.index=obj.getRecommendIndex();
		return "edit";
	}
	
	public String toChangeImg(){
		return "changeImg";
	}
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("recommendDesc", desc);
		params.put("recommendIndex", index);
		params.put("linkUrl", link);
		params.put("updPerson", creater);
		params.put("id", id);
		if(image != null ){
			params.put("imgUrl", (upload()));
		}
		
		//changeIndexBySys(creater);
		
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
		indexParams.put("moduleId", ModuleEnum.FRONT_PACKAGE_RECOMMEND);
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
		params.put("moduleId", ModuleEnum.FRONT_PACKAGE_RECOMMEND);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		List<Recommend> list = recommendBiz.queryByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("moduleId", ModuleEnum.FRONT_PACKAGE_RECOMMEND);
			countParam.put("valid", 1);
			this.totalSize = recommendBiz.countByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		Collections.sort(list);
		this.recommendList = list;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
}
