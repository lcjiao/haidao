package com.islandback.action.weddingphoto;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.ModuleTypeBiz;
import com.island.domain.biz.WeddingPhotoBiz;
import com.island.domain.dal.PackageKepianliuyingIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.IslandPackageType;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.PackageKepianliuying;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;
import com.islandback.web.util.UploadImgUtils;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/weddingphoto/wdppackage")
@ResultPath("/WEB-INF")
/**
 *婚纱摄影套餐action
 *
 */
public class WdppackageAction extends BaseAction  {
	private static final long serialVersionUID = 1L;

	private IslandPackage wdpPackage;
	private PackageDetailInfo pkgDetailInfo;
	private PackageImageRelation pkgImgRelation;
	private PackageKepianliuying pkgKPLY;
	Map<String,Object> map = new HashMap<String,Object>(0);
	
	
	private String flag;//判断是 保存返回，还是保存继续增加。
	private Integer wdpId;
	private Integer wdpImgId;
	private Integer kplyId;
	private Integer actionType;
	private String detailInfo;
	private Integer islandId;
	
	private File image;
	
	private String imageFileName;

	private Integer totalPageSize;
	private Integer totalSize=0;
	private Integer pageNo=1;
	private Integer pageSize=10;
	
	private String creater="";
	
	private List<Area> areaList = new ArrayList<Area>(0);
	private List<Island> islandList = new ArrayList<Island>(0);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private List<IslandPackage> wdpPackageList = new ArrayList<IslandPackage>(0);
	private List<PackageDetailInfo> pkgDetailInfoList = new ArrayList<PackageDetailInfo>(0);
	private List<PackageImageRelation> wdpImgList = new ArrayList<PackageImageRelation>(0);
	private List<PackageKepianliuying> pkgKPLYList = new ArrayList<PackageKepianliuying>(0);
	private List<IslandPackageType> packageTypeList = new ArrayList<IslandPackageType>(0);

	WeddingPhotoBiz weddingPhotoBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getWeddingPhotoBiz();
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	ModuleTypeBiz moduleTypeBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getModuleTypeBiz();
	
	
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
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		wdpPackageList = weddingPhotoBiz.queryWdpPackageByMap(map);
		if(wdpPackageList != null && wdpPackageList.size()>0){
			this.totalSize = weddingPhotoBiz.countIslandPackageByMap(map);
		}
		initTotalPageSize();
	}
	
	private void initTotalPageSize(){
		this.totalPageSize = (totalSize - 1)/pageSize + 1;
	}
	
	public void doPackageTypeList(){
		map.clear();
		map.put("valid", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		if(wdpPackage.getAreaId() != null  && wdpPackage.getAreaId().intValue() > 0 ){
			map.put("areaId", wdpPackage.getAreaId());
			
			if(wdpPackage.getIslandId() != null  && wdpPackage.getIslandId().intValue() > 0 ){
				map.put("islandId", wdpPackage.getIslandId());
			}
		}
		
		packageTypeList = moduleTypeBiz.queryPackageTypeByMap(map);
		
	}
	
	/**
	 * 婚纱摄影套餐  搜索(查询) 功能
	 * @return
	 */
	public String wdpPackageSearch(){
		map.clear();
		if(wdpPackage.getTitle()=="" || "".equals(wdpPackage.getTitle())){
			wdpPackage.setTitle(null);
		}
		if(wdpPackage.getPriceSmall()=="" || "".equals(wdpPackage.getPriceSmall())){
			wdpPackage.setPriceSmall(null);
		}
		map.put("titleSear",wdpPackage.getTitle());
		map.put("price", wdpPackage.getPriceSmall());
		map.put("islandId", wdpPackage.getIslandId());
		map.put("valid", 1);
		map.put("isOnline", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		wdpPackageList = weddingPhotoBiz.queryWdpPackageByMap(map);
		this.totalSize = weddingPhotoBiz.countIslandPackageByMap(map);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		initTotalPageSize();
		initIslandList();
		return "list";
	}
	
	/**
	 * 图片 搜索 功能。
	 */
	public String wdpImgSearch(){
		map.clear();
		map.put("imgType",pkgImgRelation.getImgType());
		map.put("valid", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		wdpImgList = weddingPhotoBiz.queryPkgImgRelationByMap(map);
		this.totalSize = weddingPhotoBiz.countPkgImgRelationByMap(map);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		initTotalPageSize();
		return "imglist";
	}
	
	/**
	 * 客片留影 搜索功能 
	 */
	public String kplySearch(){
		map.clear();
		map.put("kepianDescSear","%"+ pkgKPLY.getKepianDesc() +"%");
		map.put("valid", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		pkgKPLYList = weddingPhotoBiz.queryPkgKPLYByMap(map);
		this.totalSize = weddingPhotoBiz.countPkgKPLYByMap(map);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		initTotalPageSize();
		return "kepianlist";
	}
	
	/**
	 * 新增 页面
	 * @return
	 */
	public String toAddBase(){
		// RequestProcc.getSession().invalidate();
		initIslandList();
		initAreaList();
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
		wdpPackage.setIslandName(getAreaIsland().getName());
		wdpPackage.setAreaName(getAreaIsland().getAreaName());
		//wdpPackage.setAreaId(getAreaIsland().getAreaId());
		wdpPackage.setTypeName(getChildTypeName().getTitle());
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
			pkgDetailInfo.setUpdPerson(getCreater());
			pkgDetailInfo.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
			weddingPhotoBiz.updatePkgDetailInfo(pkgDetailInfo);
		}else{//不存在,新增此婚纱摄影套餐详细信息
			pkgDetailInfo.setCreatePerson(getCreater());
			pkgDetailInfo.setCreateTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
			pkgDetailInfo.setValid(1);
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
		initAreaList();
		initIslandList();
		doPackageTypeList();
		return "editbase";
	}
	
	/**
	 * 保存 婚纱摄影套餐基本信息 的修改
	 * @return
	 */
	public String editBaseInfo(){
		wdpPackage.setAreaName(getAreaIsland().getAreaName());
		wdpPackage.setIslandName(getAreaIsland().getName());
		wdpPackage.setTypeName(getChildTypeName().getTitle());
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
	 * 进入图片列表页
	 */
	public String toImgList(){
		doImgList();
		return "imglist";
	}
	
	private void doImgList() {
		map.clear();
		map.put("valid", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		if(wdpId == null && wdpPackage != null){
			this.wdpId = wdpPackage.getId();
		}
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
		//根据 套餐id获取对应的套餐
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(wdpId);
		return "addimg";
	}
	
	/**
	 * 保存图片 并返回 图片列表或继续添加图片
	 */
	public String saveImg(){
		pkgImgRelation.setCreatePerson(getCreater());
		pkgImgRelation.setCreateTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		pkgImgRelation.setPackageType(ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		pkgImgRelation.setValid(1);
		pkgImgRelation.setImgUrl(UploadImgUtils.getImgUrl(image, imageFileName));
		weddingPhotoBiz.addPkgImgRelation(pkgImgRelation);
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(pkgImgRelation.getPackageId());
		if("continue".equals(flag)){//保存并继续添加
			return "addimg";
		}
		return toImgList();
	}
	
	/**
	 * 进入 修改 图片信息 页面
	 */
	public String toEditImg(){
		pkgImgRelation = weddingPhotoBiz.queryPkgImgRelationByWdpImgId(wdpImgId);
		return "editimg";
	}
	
	/**
	 * 保存修改 图片信息
	 */
	public String editImg(){
		if(null != image){//如何修改时图片不为空,则保存新的图片地址。
			pkgImgRelation.setImgUrl(UploadImgUtils.getImgUrl(image, imageFileName));
		}
		pkgImgRelation.setUpdPerson(getCreater());
		pkgImgRelation.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		weddingPhotoBiz.updatePkgImgRelation(pkgImgRelation);
		this.wdpId = pkgImgRelation.getPackageId();
		return toImgList();
	}
	
	/**
	 * 删除 图片信息
	 */
	public String delImg(){
		map.clear();
		map.put("updPerson", getCreater());
		map.put("updTime", new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		map.put("valid",0);
		map.put("id", wdpImgId);
		weddingPhotoBiz.updatePkgImgRelation(map);
		pkgImgRelation = weddingPhotoBiz.queryPkgImgRelationByWdpImgId(wdpImgId);
		this.wdpId = pkgImgRelation.getPackageId();
		return toImgList();
	}
	
	/**
	 * 进入 婚纱客片留影 列表页
	 */
	public String toKepianList(){
		doKepianList();
		return "kepianlist";
	}
	
	private void doKepianList() {
		map.clear();
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		if(wdpId == null && wdpPackage != null){
			this.wdpId = wdpPackage.getId();
		}
		map.put("packageId", wdpId);
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		pkgKPLYList = weddingPhotoBiz.queryPkgKPLYByMap(map);
		if(pkgKPLYList != null && pkgKPLYList.size()>0){
			this.totalSize = weddingPhotoBiz.countPkgKPLYByMap(map);
		}
		//拿到对应 套餐的基本信息
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(wdpId);
		initTotalPageSize();
	}
	
	/**
	 * 进入 新增 客片留影 页面
	 */
	public String toAddKepian(){
		//根据 套餐id获取对应的套餐
		wdpPackage = weddingPhotoBiz.queryWdpPackageByWdpId(wdpId);
		return "addkepian";
	}
	
	/**
	 * 保存 客片留影 信息
	 */
	public String saveKepian(){
		pkgKPLY.setCreatePerson(getCreater());
		pkgKPLY.setCreateTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		pkgKPLY.setPackageType(ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		pkgKPLY.setValid(1);
		pkgKPLY.setImg(UploadImgUtils.getImgUrl(image, imageFileName));
		weddingPhotoBiz.addPkgKPLY(pkgKPLY);
		if("continue".equals(flag)){//保存并继续添加
			pkgKPLY = weddingPhotoBiz.queryPkgKPLYByWdpId(pkgKPLY.getPackageId());
			return "addkepian";
		}
		return toKepianList();
	}
	
	/**
	 * 进入 修改客片留影 页面
	 */
	public String toEditKepian(){
		pkgKPLY = weddingPhotoBiz.queryPkgKPLYByKplyId(kplyId);
		return "editkepian";
	}
	
	/**
	 * 保存 修改客片留影 信息
	 */
	public String editKepian(){
		if(null != image){//如何修改时图片不为空,则保存新的图片地址。
			pkgKPLY.setImg(UploadImgUtils.getImgUrl(image, imageFileName));
		}
		pkgKPLY.setUpdPerson(getCreater());
		pkgKPLY.setUpdTime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		weddingPhotoBiz.updatePkgKPLY(pkgKPLY);
		return toKepianList();
	}
	
	/**
	 * 删除 客片留影
	 */
	public String delKepian(){
		map.clear();
		map.put("updPerson", getCreater());
		map.put("updTime", new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		map.put("valid",0);
		map.put("id", kplyId);
		weddingPhotoBiz.updatePkgKPLY(map);
		return toKepianList();
	}
	
	/**
	 * 热推
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void setHot() throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("isHot", 1);
		map.put("id", wdpId);
		weddingPhotoBiz.updHotFlagByMap(map);
		Struts2Utils.renderText("ok");
	}
	/**
	 * 取消热推
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void resetHot() throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("isHot", 0);
		map.put("id", wdpId);
		weddingPhotoBiz.updHotFlagByMap(map);
		Struts2Utils.renderText("ok");
	}

	/**
	 * 进入套餐列表页
	 * @return
	 */
	public String back(){
		return list();
	}

	private Island getAreaIsland() {
		return areaIslandBiz.queryIslandById(wdpPackage.getIslandId());
	}
	

	private IslandPackageType getChildTypeName() {
		return moduleTypeBiz.queryPackageTypeById(wdpPackage.getTypeId());
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
	
	public void getPackageTypeByIsland() throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("valid", 1);
		map.put("packageType", ModuleEnum.PACKAGE_TYPE_WEDDINGPHOTO);
		List<IslandPackageType >list =new ArrayList<IslandPackageType>(0);
		if(islandId != null  && islandId.intValue() > 0 ){
			map.put("islandId", islandId);
			list = moduleTypeBiz.queryPackageTypeByMap(map);
		}
		
		Struts2Utils.renderJson(mapper.writeValueAsString(list));
	}
	
	public List<IslandPackageType> getPackageTypeList() {
		return packageTypeList;
	}

	public void setPackageTypeList(List<IslandPackageType> packageTypeList) {
		this.packageTypeList = packageTypeList;
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

	public List<PackageKepianliuying> getPkgKPLYList() {
		return pkgKPLYList;
	}

	public void setPkgKPLYList(List<PackageKepianliuying> pkgKPLYList) {
		this.pkgKPLYList = pkgKPLYList;
	}

	public PackageKepianliuying getPkgKPLY() {
		return pkgKPLY;
	}

	public void setPkgKPLY(PackageKepianliuying pkgKPLY) {
		this.pkgKPLY = pkgKPLY;
	}

	public Integer getKplyId() {
		return kplyId;
	}

	public void setKplyId(Integer kplyId) {
		this.kplyId = kplyId;
	}

	public Integer getIslandId() {
		return islandId;
	}

	public void setIslandId(Integer islandId) {
		this.islandId = islandId;
	}

}
