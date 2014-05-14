package com.islandback.action.marrypackage;




import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.Recommend;
import com.island.domain.model.User;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/marrypackage/package")
@ResultPath("/WEB-INF")
/**
 *婚礼套餐
 *
 */
public class PackageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer pageNo=1;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private Integer packageType=1;
	private Integer id;
	private Integer islandId;
	private String title;
	private Integer price;
	private Integer smallPrice;
	private Integer bigPrice;
	private Integer online;
	private Integer actionType;//1保存基本信息返回列表 2:保存基本信息返回详细信息添加页 
	//3保存详细信息并添加图片  4:管理详细信息
	
	private String detailInfo;
	
	private Integer imgId;
	private Integer imgType;
	private String imgDesc;
	private Integer imgIndex;
	private File image;
	private String imageFileName;
	private String imageServPath=ModuleEnum.IMAGE_SAVE_PATH;
	private String imageServPrefix=ModuleEnum.IMAGE_SERV_PREFIX;
	
	private List<IslandPackage> packageList = new ArrayList<IslandPackage>(0);
	private List<PackageImageRelation> packageImgList;
	private List<Island> islandList = new ArrayList<Island>(0);
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	MarrayPackageBiz packageBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getMarrayPackageBiz();
	
	/**
	 * 进入婚礼套餐列表页
	 * @return
	 */
	public String list(){
		dolist();
		return "list";
	}
	
	/**
	 * 进入婚礼套餐基本信息录入页
	 * @return
	 */
	public String toAddBase(){
		initIslandList();
		return "addbase";
	}
	
	
	/**
	 * 基本信息录入页
	 * @return
	 */
	public String addBaseInfo(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		IslandPackage addObj = new IslandPackage();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setCreateTime(now);
		if( title != null){
			addObj.setTitle(title);
		}
		if( smallPrice != null ){
			addObj.setPriceSmall(smallPrice+"");
		}
		if(bigPrice != null ){
			addObj.setPriceBig(bigPrice+"");
		}
		if(online != null){
			addObj.setIsOnline(online);
		}
		if( islandId != null ){
			Island island = areaIslandBiz.queryIslandById(islandId);
			addObj.setAreaId(island.getAreaId());
			addObj.setAreaName(island.getAreaName());
			addObj.setIslandId(islandId);
			addObj.setIslandName(island.getName());
		}
		addObj.setValid(1);
		addObj.setPackageType(1);
		this.packageBiz.addPackage(addObj);
		if( actionType.intValue() == 1){
			dolist();
			this.islandId=null;
			this.title=null;
			this.price=null;
			return "list";
		}
		if( actionType.intValue() == 2 ){
			this.id = addObj.getId();
			this.actionType=3;
			return "managerdetail";
		}
		return null;
	}
	
	/**
	 * 进入基本信息修改页
	 * @return
	 */
	public String toEditBase(){
		initIslandList();
		IslandPackage obj = this.packageBiz.queryById(id);
		this.title=obj.getTitle();
		this.islandId=obj.getIslandId();
		this.bigPrice=Integer.parseInt(obj.getPriceBig());
		this.smallPrice=Integer.parseInt(obj.getPriceSmall());
		this.online=obj.getIsOnline();
		return "editbase";
	}
	
	/**
	 * 基本信息修改
	 * @return
	 */
	public String editBaseInfo(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("id", id);
		params.put("updPerson", creater);
		int now = (int)(System.currentTimeMillis()/1000);
		params.put("updTime", now);
		if( title != null){
			params.put("title", title);
		}
		if( smallPrice != null ){
			params.put("priceSmall", smallPrice);
		}
		if(bigPrice != null ){
			params.put("priceBig", bigPrice);
		}
		if(online != null && online.intValue()>0){
			params.put("isOnline", online);
		}
		if( islandId != null ){
			Island island = areaIslandBiz.queryIslandById(islandId);
			params.put("areaId", island.getAreaId());
			params.put("areaName", island.getAreaName());
			params.put("islandId", islandId);
			params.put("islandName", island.getName());
		}
		this.packageBiz.updByMap(params);
		this.islandId=null;
		this.title=null;
		this.price=null;
		dolist();
		return "list";
	}
	
	
	/**
	 * 进入详情管理页
	 * @return
	 */
	public String toManagerDetail(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("packageId", id);
		params.put("valid", 1);
		List<PackageDetailInfo> list = packageBiz.queryPackageDetailByMap(params);
		if( list != null && !list.isEmpty()){//更新套餐详情
			PackageDetailInfo detail = list.get(0);
			this.detailInfo=detail.getContent();
		}
		this.actionType=4;
		return "managerdetail";
	}
	
	/**
	 * 详情信息管理
	 * @return
	 */
	public String managerDetail(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("packageId", id);
		params.put("valid", 1);
		List<PackageDetailInfo> list = packageBiz.queryPackageDetailByMap(params);
		if( list != null && !list.isEmpty()){//更新套餐详情
			Map<String,Object> updParams = new HashMap<String,Object>(0);
			updParams.put("packageId", id);
			updParams.put("content", detailInfo);
			updParams.put("updPerson", creater);
			updParams.put("updTime", now);
			this.packageBiz.updPackageDetailByMap(updParams);
		}else{//添加套餐详情
			PackageDetailInfo packageDetail = new PackageDetailInfo();
			packageDetail.setPackageId(id);
			packageDetail.setPackageType(packageType);
			packageDetail.setContent(detailInfo);
			packageDetail.setValid(1);
			packageDetail.setCreatePerson(creater);
			packageDetail.setCreateTime(now);
			this.packageBiz.addPackageDetail(packageDetail);
		}
		dolist();
		return "list";
	}
	
	public String toImgList(){
		doimgList();
		return "imglist";
	}
	
	public String toAddImg(){
		return "addimg";
	}
	
	public String addImg(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		PackageImageRelation addObj = new PackageImageRelation();
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setCreateTime(now);
		if( imgDesc != null){
			addObj.setImgDes(imgDesc);
		}
		if( imgIndex != null ){
			addObj.setImgIndex(imgIndex);
		}
		if( imgType != null ){
			addObj.setImgType(imgType);
		}
		addObj.setValid(1);
		addObj.setPackageType(1);
		addObj.setPackageId(id);
		addObj.setImgUrl(upload());
		this.packageBiz.addPackageImg(addObj);
		doimgList();
		return "imglist";
	}

	public String delImg(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		Map<String,Object> setParams = new HashMap<String,Object>(0);
		setParams.put("updTime", now);
		setParams.put("valid", 0);
		setParams.put("updPerson", creater);
		setParams.put("id", imgId);
		this.packageBiz.updPackageImgByMap(setParams);	
		doimgList();
		return "imglist";
	}
	
	public String toEditImg(){
		PackageImageRelation obj = packageBiz.queryPackageImgById(imgId);
		this.imgDesc=obj.getImgDes();
		this.imgIndex=obj.getImgIndex();
		this.imgType=obj.getImgType();
		return "editimg";
	}
	
	public String editImg(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		Map<String,Object> params = new HashMap<String,Object>(0);
		if( imgDesc != null ){
			params.put("imgDes", imgDesc);
		}
		if( imgIndex != null ){
			params.put("imgIndex", imgIndex);
		}
		if( imgType != null ){
			params.put("imgType", imgType);
		}
		if( image != null ){
			params.put("imgUrl", upload());
		}
		params.put("updPerson", creater);
		params.put("updTime", now);
		params.put("id", imgId);
		
		this.packageBiz.updPackageImgByMap(params);		
		doimgList();
		return "imglist";
	}
	
	public String back(){
		dolist();
		return "list";
	}
	public String dolist(){
		initIslandList();
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		if(title != null && !"".equals(title) ){
			params.put("titleSear", "%"+title+"%");
		}
		if(price != null && price.intValue() > 0){
			params.put("price", price);
		}
		if(islandId != null && islandId.intValue() > 0 ){
			params.put("islandId", islandId);
		}
		params.put("packageType", 1);
		List<IslandPackage> list = packageBiz.queryPackageByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			if(title != null && !"".equals(title)  ){
				countParam.put("titleSear", "%"+title+"%");
			}
			if(price != null && price.intValue() > 0 ){
				countParam.put("price", price);
			}
			if(islandId != null && islandId.intValue() > 0 ){
				countParam.put("islandId", islandId);
			}
			this.totalSize = packageBiz.countPackageByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.packageList = list;
		
		return "imglist";
	}
	
	
	/**
	 * 套餐图片列表
	 * @return
	 */
	public String doimgList(){
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		if(imgType != null && imgType.intValue() > 0 ){
			params.put("imgType", imgType);
		}
		params.put("packageId", id);
		List<PackageImageRelation> list = packageBiz.queryPackageImgByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			countParam.put("packageId", id);
			if(imgType != null && imgType.intValue() > 0 ){
				countParam.put("imgType", imgType);
			}
			
			this.totalSize = packageBiz.countPackageImgByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.packageImgList = list;
		
		return "list";
	}
	
	
	private void initIslandList(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		List<Island> list = areaIslandBiz.queryIslandByMap(params);
		this.islandList = list;
	}
	private void initTotalPageSize(){
		if(totalSize % pageSize == 0 ){
			this.totalPageSize = totalSize / pageSize;
		}else{
			this.totalPageSize = ( totalSize / pageSize )+ 1;
		}
	}
	
	
	
	public String upload() {  
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
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
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
	public List<IslandPackage> getPackageList() {
		return packageList;
	}
	public void setPackageList(List<IslandPackage> packageList) {
		this.packageList = packageList;
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
	public String getTitle() throws UnsupportedEncodingException {
		//this.title = new String (title.getBytes("ISO8859-1"),"utf-8");
		//System.out.println(title);
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSmallPrice() {
		return smallPrice;
	}
	public void setSmallPrice(Integer smallPrice) {
		this.smallPrice = smallPrice;
	}
	public Integer getActionType() {
		return actionType;
	}
	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}
	public MarrayPackageBiz getPackageBiz() {
		return packageBiz;
	}
	public void setPackageBiz(MarrayPackageBiz packageBiz) {
		this.packageBiz = packageBiz;
	}
	public Integer getBigPrice() {
		return bigPrice;
	}
	public void setBigPrice(Integer bigPrice) {
		this.bigPrice = bigPrice;
	}
	public Integer getPackageType() {
		return packageType;
	}
	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	public Integer getImgType() {
		return imgType;
	}
	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	}
	public List<PackageImageRelation> getPackageImgList() {
		return packageImgList;
	}
	public void setPackageImgList(List<PackageImageRelation> packageImgList) {
		this.packageImgList = packageImgList;
	}
	public String getImgDesc() {
		return imgDesc;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	public Integer getImgIndex() {
		return imgIndex;
	}
	public void setImgIndex(Integer imgIndex) {
		this.imgIndex = imgIndex;
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
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	
	
	
}
