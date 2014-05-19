package com.islandback.action.weddingphoto;



import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.serializer.JSONSerializer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.biz.WeddingPhotoBiz;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.UploadImgUtils;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/weddingphoto/wdp")
@ResultPath("/WEB-INF")
/**
 *婚纱摄影首页图片推荐action
 *
 */
public class WdpAction extends ActionSupport implements ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private Recommend recommend;
	private HttpServletResponse response;
	Map<String,Object> map = new HashMap<String,Object>(0);
	
	private String areaId;
	private String rmdId;
	
	private String flag;//判断是 保存返回，还是保存继续增加。
	
	private File image;
	
	private String imageFileName;

	private Integer totalPageSize;
	private Integer totalSize=0;
	private Integer pageNo=1;
	private Integer pageSize=5;
	
	private SessionInfo sessionInfo = RequestProcc.getSessionInfo();
	private String creater="";
	
	private List<Area> areaList = new ArrayList<Area>(0);
	private List<Island> islandList = new ArrayList<Island>(0);
	private List<Recommend> recommendList;
	WeddingPhotoBiz weddingPhotoBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getWeddingPhotoBiz();
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	MarrayPackageBiz packageBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getMarrayPackageBiz();
	
	
	private String getCreater(){
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		return creater;
	}
	
	public String list(){
		doList();
		
		return "list";
	}
	
	private void doList(){
		map.clear();
		map.put("moduleId", ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		List<Recommend> list = weddingPhotoBiz.queryByMap(map);
		if(list != null && list.size()>0){
			map.clear();
			map.put("moduleId", ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
			map.put("valid", 1);
			this.totalSize = weddingPhotoBiz.countByMap(map);
		}
		initTotalPageSize();
		Collections.sort(list);
		this.recommendList = list;
	}
	
	private void initTotalPageSize(){
		this.totalPageSize = totalSize % pageSize == 0 ? totalSize / pageSize : ( totalSize / pageSize )+ 1;
	}
	
	public String toAdd(){
		RequestProcc.getSession().invalidate();
		initAreaList();
		return "add";
	}
	
	/**
	 * 保存婚纱摄影图片信息
	 * @return
	 */
	public String addWdpRecommend(){
		//调用图片上传方法获取图片的url
		recommend.setImgUrl(UploadImgUtils.getImgUrl(image, imageFileName));		
		recommend.setCreatePerson(getCreater());
		recommend.setCreateTime((int)System.currentTimeMillis()/1000);
		recommend.setValid(1);
		recommend.setModuleId(ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
		//changeIndexBySys(creater,recommend.getId(),recommend.getRecommendIndex());
		recommend.setAreaName(areaIslandBiz.queryAreaById(recommend.getAreaId()).getName());
		recommend.setIslandName(areaIslandBiz.queryIslandById(recommend.getIslandId()).getName());
		weddingPhotoBiz.addRecommend(recommend);
		initAreaList();
		if("return".equals(flag)){
			return list();
		}
		return "add";
	}
	
	public String deleteWdp(){
		map.clear();
		map.put("valid", 0);
		map.put("id", rmdId);
		map.put("updPerson", getCreater());
		map.put("updTime",Calendar.getInstance().getTimeInMillis()/1000);
		weddingPhotoBiz.updRecommend(map);
		doList();
		return "list";
	}
	
	public String toEditWdp(){
		map.clear();
		map.put("id", rmdId);
		recommend = weddingPhotoBiz.queryById(Integer.valueOf(rmdId));
		initAreaList();
		map.clear();
		map.put("areaId", recommend.getAreaId());
		islandList = areaIslandBiz.queryIslandByMap(map);
		return "edit";
	}
	
	public String editRecommend(){
		if(null != image){
			recommend.setImgUrl(UploadImgUtils.getImgUrl(image, imageFileName));
		}
		weddingPhotoBiz.updateRecommend(recommend);
		doList();
		return "list";
	}
		
	private void changeIndexBySys(int id,int index){
		Recommend thisObj = weddingPhotoBiz.queryById(id);
		// 查询之前此排序得条目 如存在对调排序次序		 
		map.clear();
		map.put("recommendIndex", index);
		map.put("moduleId", ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
		map.put("valid", 1);
		List<Recommend> list = weddingPhotoBiz.queryByMap(map);
		if( list.size() > 0 && null != list){
			map.clear();
			map.put("recommendIndex", thisObj.getRecommendIndex());
			map.put("updPerson", getCreater());
			map.put("id", list.get(0).getId());
			weddingPhotoBiz.updRecommend(map);
		}	
	}

	private void initAreaList(){
		map.clear();
		map.put("valid", 1);
		areaList = areaIslandBiz.queryAreaByMap(map);
	}
	
	/**
	 * 根据传入的areaId,动态获取岛屿
	 * @throws Exception
	 */
	public void getIslandSelect() throws Exception{
		map.clear();
		map.put("areaId", areaId);
		map.put("valid", 1);
		islandList = areaIslandBiz.queryIslandByMap(map);
		JSONSerializer	serializer = new JSONSerializer();
		serializer.write(islandList);
		response.setContentType("text/xml;charset=utf-8");
		Writer writer = response.getWriter();
		writer.write(serializer.toString());
	}
	
	public List<Island> getIslandList() {
		return islandList;
	}

	public void setIslandList(List<Island> islandList) {
		this.islandList = islandList;
	}

	private void initIslandList(){
		Map<String,Object> map = new HashMap<String,Object>(0);
		map.put("valid", 1);
		List<Island> list = areaIslandBiz.queryIslandByMap(map);
		this.islandList = list;
	}
	
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
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
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public Recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(Recommend recommend) {
		this.recommend = recommend;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public List<Recommend> getRecommendList() {
		return recommendList;
	}

	public void setRecommendList(List<Recommend> recommendList) {
		this.recommendList = recommendList;
	}

	public String getRmdId() {
		return rmdId;
	}

	public void setRmdId(String rmdId) {
		this.rmdId = rmdId;
	}
	
}
