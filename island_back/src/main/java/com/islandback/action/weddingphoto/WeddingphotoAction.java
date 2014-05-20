package com.islandback.action.weddingphoto;



import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.WeddingPhotoBiz;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/weddingphoto/weddingphoto")
@ResultPath("/WEB-INF")
/**
 *婚纱摄影套餐action
 *
 */
public class WeddingphotoAction extends ActionSupport  {
	private static final long serialVersionUID = 1L;

	private IslandPackage wdpPackage;
	private PackageDetailInfo pkgDetailInfo;
	private PackageImageRelation pkgImgRelation;
	Map<String,Object> map = new HashMap<String,Object>(0);
	
	
	private String flag;//判断是 保存返回，还是保存继续增加。
	private Integer wdpId;
	private Integer wdpImgId;
	private Integer actionType;
	private String detailInfo;
	
	private File image;
	
	private String imageFileName;

	private Integer totalPageSize;
	private Integer totalSize=0;
	private Integer pageNo=1;
	private Integer pageSize=10;
	
	
	private String creater="";
	
	private List<Area> areaList = new ArrayList<Area>(0);
	private List<Island> islandList = new ArrayList<Island>(0);
	private List<IslandPackage> wdpPackageList = new ArrayList<IslandPackage>(0);
	private List<PackageDetailInfo> pkgDetailInfoList = new ArrayList<PackageDetailInfo>(0);
	private List<PackageImageRelation> wdpImgList = new ArrayList<PackageImageRelation>(0);
	
	WeddingPhotoBiz weddingPhotoBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getWeddingPhotoBiz();
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	
	private String getCreater(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		return creater;
	}
	
	/**
	 * 进入 婚纱套餐 列表页面
	 * @return
	 */
	public String list(){
		doList();
		initIslandList();
		return "list";
	}
	
	private void doList(){
		map.clear();
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		map.put("valid", 1);
		map.put("isOnline", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		wdpPackageList = weddingPhotoBiz.queryIslandPackageByMap(map);
		if(wdpPackageList != null && wdpPackageList.size()>0){
			this.totalSize = weddingPhotoBiz.countIslandPackageByMap(map);
		}
		initTotalPageSize();
	}
	
	private void initTotalPageSize(){
		this.totalPageSize = totalSize % pageSize == 0 ? totalSize / pageSize : ( totalSize / pageSize )+ 1;
	}
	
	/**
	 * 搜索(查询) 功能
	 * @return
	 */
	public String search(){
		if(null !=wdpPackage && !"".equals(wdpPackage)){
			map.clear();
			map.put("titleSear","%"+ wdpPackage.getTitle() +"%");
			map.put("price", wdpPackage.getPriceBig());
			map.put("islandId", wdpPackage.getIslandId());
		}
		wdpPackageList = weddingPhotoBiz.queryIslandPackageByMap(map);
		if(wdpPackageList != null && wdpPackageList.size()>0){
			map.clear();
			map.put("valid", 1);
			map.put("isOnline", 1);
			map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
			this.totalSize = weddingPhotoBiz.countIslandPackageByMap(map);
		}
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		initTotalPageSize();
		initIslandList();
		return "list";
	}
	
	/**
	 * 新增 页面
	 * @return
	 */
	public String toAddBase(){
		RequestProcc.getSession().invalidate();
		initIslandList();
		return "addbase";
	}
	
	/**
	 * 新增婚纱摄影套餐信息
	 * @return
	 */
	public String addWdpPackage(){
		wdpPackage.setValid(1);
		wdpPackage.setCreatePerson(getCreater());
		wdpPackage.setCreateTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		wdpPackage.setPackageType(ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		wdpPackage.setIslandName(getIsland().getName());
		wdpPackage.setAreaName(getIsland().getAreaName());
		wdpPackage.setAreaId(getIsland().getAreaId());
		weddingPhotoBiz.addWdpPackage(wdpPackage);
		initAreaList();
		if("toList".equals(flag)){
			return list();
		}
		return "detail";
	}
	
	/**
	 * 进入婚纱摄影信息详细页面
	 * @return
	 */
	public String wdpDetail(){
		//根据婚纱摄影id拿到其基本信息。
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(wdpId);
		map.clear();
		map.put("packageId", wdpId);
		map.put("valid", 1);
		pkgDetailInfoList = weddingPhotoBiz.queryPackageDetailByMap(map);
		if(null != pkgDetailInfoList && pkgDetailInfoList.size() > 0){
			pkgDetailInfo = pkgDetailInfoList.get(0);
			detailInfo = pkgDetailInfo.getContent();
		}
		actionType = 4;
		return "detail";
	}
	
	/**
	 * 新增或修改 婚纱摄影套餐详细信息
	 * @return
	 */
	public String saveWdpDetail(){		
		//到套餐详细信息表中,根据婚纱摄影id与套餐类型查询是否存在此套餐的详细信息,存在就修改操作,不存在就添加操作。
		map.clear();
		map.put("packageId", wdpPackage.getId());
		map.put("valid", 1);
		map.put("packageType", wdpPackage.getPackageType());
		pkgDetailInfoList = weddingPhotoBiz.queryPackageDetailByMap(map);
		if(null != pkgDetailInfoList && pkgDetailInfoList.size() > 0){//存在 就更新
			pkgDetailInfo = pkgDetailInfoList.get(0);
			pkgDetailInfo.setContent(pkgDetailInfo.getContent());
			pkgDetailInfo.setUpdPerson(getCreater());
			pkgDetailInfo.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
			weddingPhotoBiz.updatePkgDetailInfo(pkgDetailInfo);
		}else{//不存在,新增此婚纱摄影套餐详细信息
			pkgDetailInfo.setCreatePerson(getCreater());
			pkgDetailInfo.setCreateTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
			weddingPhotoBiz.addPkgDetailInfo(pkgDetailInfo);
		}
		return list();
	}
	
	/**
	 * 进入 婚纱摄影套餐基本信息 修改页面
	 * @return
	 */
	public String toEditBase(){
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(wdpId);
		initIslandList();
		return "editbase";
	}
	
	/**
	 * 保存 婚纱摄影套餐基本信息 的修改
	 * @return
	 */
	public String editBaseInfo(){
		Island island = areaIslandBiz.queryIslandById(wdpPackage.getIslandId());
		wdpPackage.setAreaId(island.getAreaId());
		wdpPackage.setAreaName(island.getAreaName());
		wdpPackage.setIslandId(island.getId());
		wdpPackage.setIslandName(island.getName());
		wdpPackage.setUpdPerson(getCreater());
		wdpPackage.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		weddingPhotoBiz.updateWdpPackage(wdpPackage);
		return list();
	}
	
	/**
	 * 删除 婚纱摄影套餐
	 */
	public String delWeddingPhoto(){
		wdpPackage.setUpdPerson(getCreater());
		wdpPackage.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		wdpPackage.setValid(0);//无效即表示删除。
		wdpPackage.setId(wdpId);
		weddingPhotoBiz.updateWdpPackage(wdpPackage);
		//删除 套餐详细信息表 中 与此 套餐对应 的详细信息。
		pkgDetailInfo.setPackageId(wdpId);
		pkgDetailInfo.setPackageType(ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		pkgDetailInfo.setUpdPerson(getCreater());
		pkgDetailInfo.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		pkgDetailInfo.setValid(0);
		weddingPhotoBiz.updatePkgDetailInfo(pkgDetailInfo);
		return list();
	}
	
	/**
	 * 进入图片管理 列表页
	 */
	public String toImgList(){
		doImgList();
		return "imglist";
	}
	
	private void doImgList() {
		map.clear();
		map.put("valid", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		map.put("packageId", wdpId);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		wdpImgList = weddingPhotoBiz.queryPkgImgRelationByMap(map);
		if(wdpImgList != null && wdpImgList.size()>0){
			this.totalSize = weddingPhotoBiz.countPkgImgRelationByMap(map);
		}
		//拿到对应 套餐的基本信息
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(wdpId);
		initTotalPageSize();		
	}
	
	/**
	 * 进入 新增 婚纱摄影图片 页面
	 */
	public String toAddImg(){
		
		return toImgList();
	}

	/**
	 * 进入套餐列表页
	 * @return
	 */
	public String back(){
		return list();
	}

	private Island getIsland() {
		return areaIslandBiz.queryIslandById(wdpPackage.getIslandId());
	}
	
	
	private void initAreaList(){
		map.clear();
		map.put("valid", 1);
		areaList = areaIslandBiz.queryAreaByMap(map);
	}
	
	private void initIslandList(){
		map.clear();
		map.put("valid", 1);
		islandList = areaIslandBiz.queryIslandByMap(map);
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

	public List<IslandPackage> getWdpPackageList() {
		return wdpPackageList;
	}

	public void setWdpPackageList(List<IslandPackage> wdpPackageList) {
		this.wdpPackageList = wdpPackageList;
	}

	public IslandPackage getWdpPackage() {
		return wdpPackage;
	}

	public void setWdpPackage(IslandPackage wdpPackage) {
		this.wdpPackage = wdpPackage;
	}

	public Integer getWdpId() {
		return wdpId;
	}

	public void setWdpId(Integer wdpId) {
		this.wdpId = wdpId;
	}

	public List<PackageDetailInfo> getPkgDetailInfoList() {
		return pkgDetailInfoList;
	}

	public void setPkgDetailInfoList(List<PackageDetailInfo> pkgDetailInfoList) {
		this.pkgDetailInfoList = pkgDetailInfoList;
	}

	public PackageDetailInfo getPkgDetailInfo() {
		return pkgDetailInfo;
	}

	public void setPkgDetailInfo(PackageDetailInfo pkgDetailInfo) {
		this.pkgDetailInfo = pkgDetailInfo;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public PackageImageRelation getPkgImgRelation() {
		return pkgImgRelation;
	}

	public void setPkgImgRelation(PackageImageRelation pkgImgRelation) {
		this.pkgImgRelation = pkgImgRelation;
	}

	public List<PackageImageRelation> getWdpImgList() {
		return wdpImgList;
	}

	public void setWdpImgList(List<PackageImageRelation> wdpImgList) {
		this.wdpImgList = wdpImgList;
	}

	public Integer getWdpImgId() {
		return wdpImgId;
	}

	public void setWdpImgId(Integer wdpImgId) {
		this.wdpImgId = wdpImgId;
	}

}
