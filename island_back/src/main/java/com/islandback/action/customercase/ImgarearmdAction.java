package com.islandback.action.customercase;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.islandback.action.base.BaseAction;

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
import com.islandback.web.util.UploadImgUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 区域、图片推荐 (中间块)
 * @author zhbl
 *
 */

//@SuppressWarnings("serial")
@Namespace("/customercase/imgarea")
@ResultPath("/WEB-INF")
public class ImgarearmdAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Recommend recommend;
	private Integer packageType=1;
	private Integer id;
	private File image;
	private String imageFileName;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private Integer areaId;
	private Integer recommendType = 1;
	private String recommendTypeName="区域推荐";
	
	
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	private List<Island> islandList;
	private List<Area> areaList;
	private List<Recommend> recommendList;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	private ObjectMapper mapper = new ObjectMapper();
	
	private String getCreater(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			return sessionInfo.getUser().getUserName(); 
		}
		return "";
	}
	
	
	public String tolist(){
		doList();
		return "list";
	}
	
	public String toAdd(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		return "add";
	}
	
	public String add(){
		//管理员身份验证
		
		recommend.setCreatePerson(getCreater());
		int now = (int)(System.currentTimeMillis()/1000);
		recommend.setModuleId(ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND);
		if(image != null ){
			recommend.setImgUrl(UploadImgUtils.getImgUrl(image, getCreater()));
		}
		recommend.setCreatePerson(getCreater());
		recommend.setCreateTime(now);
		recommend.setValid(1);
		recommend.setAreaName(areaIslandBiz.queryAreaById(recommend.getAreaId()).getName());
		recommend.setTypeId(recommendType);
		recommend.setTypeName(recommendTypeName);
		this.recommendBiz.addMasterRecommend(recommend);
		doList();
		return "list";
		
	}
	
	public String toEdit(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
	    areaList = areaIslandBiz.queryAreaByMap(params);
		
	    
		recommend = recommendBiz.queryById(id);
		
		if( recommend.getAreaId() != null && recommend.getAreaId() > 0){
			Map<String,Object> islandparams = new HashMap<String,Object>(0);
			islandparams.put("valid", 1);
			islandparams.put("areaId", recommend.getAreaId());
			islandList = areaIslandBiz.queryIslandByMap(islandparams);
		}
		
		return "edit";
	}
	
	public String edit(){
		
		recommend.setUpdPerson(getCreater());
		int now = (int)(System.currentTimeMillis()/1000);
		if(image != null  ){
			recommend.setImgUrl(UploadImgUtils.getImgUrl(image, getCreater()));
		}
		recommend.setUpdTime(now);
		this.recommendBiz.updRecommendByModel(recommend);
		doList();
		return "list";
	}
	
	
	public String del(){
		
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("valid", 0);
		setParams.put("updPerson", getCreater());
		setParams.put("id", id);
		this.recommendBiz.updRecommend(setParams);		
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
		
	private void doList(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 5;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		params.put("typeId", recommendType);
		List<Recommend> list = recommendBiz.queryByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("moduleId", ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND);
			countParam.put("valid", 1);
			countParam.put("typeId", recommendType);
			this.totalSize = recommendBiz.countByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		Collections.sort(list);
		this.recommendList = list;
	}
	private void initTotalPageSize(){
		this.totalPageSize = (totalSize - 1) / pageSize + 1;
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
