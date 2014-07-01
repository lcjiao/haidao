package com.islandback.action.right;



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

import com.jcl.core.module.ModuleRegistry;
import com.anjuke.core.util.ObjectUtils;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.ImageBiz;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.model.Image;
import com.island.domain.model.Recommend;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/right/image")
@ResultPath("/WEB-INF")
public class ImageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Image img;
	private File image;
	private String imageFileName;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=5;
	private List<Image> imgList = new ArrayList<Image>(0);
	ImageBiz imgBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getImageBiz();
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
		int now = (int)(System.currentTimeMillis()/1000);
		if(image != null ){
			img.setImgUrl(upload());
		}
		img.setCreatePerson(creater);
		img.setCreateTime(now);
		img.setValid(1);
		this.imgBiz.addImage(img);
		
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
		this.imgBiz.updImageByMap(setParams);		
		doList();
		return "list";
	}
	
	public String toEdit(){
		img = imgBiz.queryImgById(id);
		return "edit";
	}
	
	
	public String edit(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("imgDesc", img.getImgDesc());
		params.put("updTime", now);
		params.put("updPerson", creater);
		params.put("id", id);
		
		
		this.imgBiz.updImageByMap(params);	
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
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		if( img != null && img.getImgDesc() != null ){
			params.put("imgDesc", img.getImgDesc());
		}
		List<Image> list = imgBiz.queryImgByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			if( img !=null && img.getImgDesc() != null ){
				countParam.put("imgDesc", img.getImgDesc());
			}
			this.totalSize = imgBiz.countImgByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.imgList = list;
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


	public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
	}


	public List<Image> getImgList() {
		return imgList;
	}


	public void setImgList(List<Image> imgList) {
		this.imgList = imgList;
	}
	

	
}
