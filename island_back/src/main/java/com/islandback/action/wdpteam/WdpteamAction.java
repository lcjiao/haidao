package com.islandback.action.wdpteam;



import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jcl.core.module.ModuleRegistry;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.biz.WdpTeamBiz;
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

@Namespace("/wdpphototeam/wdpteam")
@ResultPath("/WEB-INF")
/**
 *摄影团队推荐
 *
 */
public class WdpteamAction extends ActionSupport implements ServletResponseAware {
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
	
	private List<Area> areaList = new ArrayList<Area>(0);
	private List<Island> islandList = new ArrayList<Island>(0);
	private List<Recommend> recommendList;
	
	WdpTeamBiz wdpTeamBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getWdpTeamBiz();
	WeddingPhotoBiz weddingPhotoBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getWeddingPhotoBiz();
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	
	
	private String getCreater(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			return sessionInfo.getUser().getUserName(); 
		}
		return "";
	}
	
	/**
	 * 进入  列表页
	 * @return
	 */
	public String list(){
		doList();
		return "list";
	}
	
	private void doList(){
		map.clear();
		map.put("moduleId", ModuleEnum.PHOTO_TEAM_RECOMMEND);
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		recommendList = wdpTeamBiz.queryByMap(map);
		if(recommendList != null && recommendList.size()>0){
			map.clear();
			map.put("moduleId", ModuleEnum.PHOTO_TEAM_RECOMMEND);
			map.put("valid", 1);
			this.totalSize = wdpTeamBiz.countByMap(map);
		}
		initTotalPageSize();
		Collections.sort(recommendList);
	}
	
	private void initTotalPageSize(){
		this.totalPageSize = (totalSize - 1)/pageSize + 1;
	}
	
	/**
	 * 进入 新增页面
	 * @return
	 */
	public String toAdd(){
		//RequestProcc.getSession().invalidate();
		//getRmdAreaList();
		return "add";
	}
	
	/**
	 * 保存摄影团队(师)信息
	 * @return
	 */
	public String addWdpTeamInfo(){
		//调用图片上传方法获取图片的url
		recommend.setImgUrl(UploadImgUtils.getImgUrl(image, imageFileName));		
		recommend.setCreatePerson(getCreater());
		recommend.setCreateTime((int)(System.currentTimeMillis()/1000));
		recommend.setValid(1);
		recommend.setModuleId(ModuleEnum.PHOTO_TEAM_RECOMMEND);
		//changeIndexBySys(recommend.getId(),recommend.getRecommendIndex());
		//recommend.setAreaName(areaIslandBiz.queryAreaById(recommend.getAreaId()).getName());
		//recommend.setIslandName(areaIslandBiz.queryIslandById(recommend.getIslandId()).getName());
		wdpTeamBiz.addRecommend(recommend);
		initAreaList();
		if("return".equals(flag)){
			return list();
		}
		return "add";
	}
	
	/**
	 * 删除推荐信息
	 * @return
	 */
	public String deleteWdpTeamInfo(){
		map.clear();
		map.put("valid", 0);
		map.put("id", rmdId);
		map.put("updPerson", getCreater());
		map.put("updTime",Calendar.getInstance().getTimeInMillis()/1000);
		wdpTeamBiz.updRecommend(map);
		return list();
	}
	
	/**
	 * 进入 修改图片推荐信息 页面
	 * @return
	 */
	public String toEditWdpTeamInfo(){
		map.clear();
		map.put("id", rmdId);
		recommend = wdpTeamBiz.queryById(Integer.valueOf(rmdId));
		
		return "edit";
	}
	
	/**
	 * 保存 修改图片推荐信息
	 * @return
	 */
	public String editWdpTeamInfo(){
		if(null != image){
			recommend.setImgUrl(UploadImgUtils.getImgUrl(image, imageFileName));
		}
		wdpTeamBiz.updateRecommend(recommend);
		return list();
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
	
	private void getRmdAreaList(){
		map.clear();
		map.put("valid", 1);
		map.put("moduleId", ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
		recommendList = recommendBiz.queryByMap(map);
		if(recommendList.size() > 0){
			for (Recommend rmd : recommendList) {
				int areaId = rmd.getAreaId();
				Area obj = areaIslandBiz.queryAreaById(areaId);
		    	areaList.add(obj);
			}
		}
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
