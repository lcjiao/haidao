package com.islandback.action.customercase;



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
import com.island.domain.biz.CustomerCaseBiz;
import com.island.domain.biz.ModuleTypeBiz;
import com.island.domain.dal.PackageKepianliuyingIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.CasePicMapping;
import com.island.domain.model.CaseVideoMapping;
import com.island.domain.model.CustomerCase;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.IslandPackageType;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.PackageKepianliuying;
import com.island.domain.model.PhotoSubscribe;
import com.island.domain.util.IslandDateUtil;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;
import com.islandback.web.util.UploadImgUtils;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/customercase/ctmpkg")
@ResultPath("/WEB-INF")
/**
 *客户案例套餐action
 *
 */
public class CtmcasepkgAction extends BaseAction  {
	private static final long serialVersionUID = 1L;

	Map<String,Object> map = new HashMap<String,Object>(0);
	
	private CustomerCase ctmcase = new CustomerCase();
	private CasePicMapping casepm = new CasePicMapping();
	private CaseVideoMapping casevm = new CaseVideoMapping();
	
	
	private String flag;//判断是 保存返回，还是保存继续增加。
	
	private Integer csType;//案例类型  130：摄影案例 131视频案例
	private Integer ctmId;
	private Integer ctmImgId;
	private Integer ctmVideoId;
	
	private Integer areaId;
	
	private Integer islandId;
	
	private File image;
	
	private String imageFileName;

	private Integer totalPageSize;
	private Integer totalSize=0;
	private Integer pageNo=1;
	private Integer pageSize;
	
	private Integer defaultPS = 10;
	
	private String creater="";
	
	private List<Area> areaList = new ArrayList<Area>(0);
	private List<Island> islandList = new ArrayList<Island>(0);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private List<CustomerCase> ctmcaseList = new ArrayList<CustomerCase>(0);
	private List<IslandPackageType> pkgTypeList = new ArrayList<IslandPackageType>(0);
	private List<PackageImageRelation> wdpImgList = new ArrayList<PackageImageRelation>(0);
	
	private List<CasePicMapping> casePMList =  new ArrayList<CasePicMapping>(0);
	private List<CaseVideoMapping> caseVMList = new ArrayList<CaseVideoMapping>(0);
	
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	ModuleTypeBiz moduleTypeBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getModuleTypeBiz();
	
	CustomerCaseBiz ctmcaseBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getCustomerCaseBiz();
	
	
	
	private String getCreater(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		return creater;
	}
	
	/**
	 * 婚纱摄影套餐  搜索(查询) 功能
	 * @return
	 */
	public String ctmcasepkgSearch(){
		List<CustomerCase> ctcList = new ArrayList<CustomerCase>();
		map.clear();
		if(ctmcase.getCasename()=="" || "".equals(ctmcase.getCasename())){
			ctmcase.setCasename(null);
		}
		map.put("casenameSear",ctmcase.getCasename());
		map.put("valid", 1);
		map.put("casetype", ctmcase.getCasetype());
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize == null ? defaultPS : pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		ctcList = ctmcaseBiz.queryCtmcasePkgByMap(map);
		if(ctcList != null && ctcList.size()>0){
			this.totalSize = ctmcaseBiz.countCtmcasePkgByMap(map);
			for (CustomerCase ctc : ctcList) {
				ctc.setStrPhotoTime(IslandDateUtil.getDateStrByUnixTime(ctc.getPhototime(), "yyyy-MM-dd"));
				ctmcaseList.add(ctc);
			}
		}
		this.totalSize = ctmcaseBiz.countCtmcasePkgByMap(map);
		initTotalPageSize();
		initIslandList();
		return "list";
	}
	
	/**
	 * 摄影案例图片搜索功能
	 */
	public String imgCaseSearch(){
		map.clear();
		map.put("imgType",casepm.getImgType());
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize == null ? defaultPS : pageSize);
		map.put("caseid",ctmId);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		casePMList = ctmcaseBiz.queryCasePmByMap(map);
		this.totalSize = ctmcaseBiz.countCasePmByMap(map);
		ctmcase.setId(ctmId);
		initTotalPageSize();
		initIslandList();
		return "imglist";
	}
	
	
	/**
	 * 视频案例 视频搜索功能 
	 */
	public String videoCaseSearch(){
		map.clear();
		if(casevm.getVideodesc()=="" || "".equals(casevm.getVideodesc())){
			casevm.setVideodesc(null);
		}
		map.put("videodesc",casevm.getVideodesc());
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize == null ? defaultPS : pageSize);
		map.put("caseid",ctmId);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		caseVMList = ctmcaseBiz.queryCaseVmByMap(map);
		this.totalSize = ctmcaseBiz.countCaseVmByMap(map);
		ctmcase.setId(ctmId);
		initTotalPageSize();
		initIslandList();
		return "videolist";
	}
	/**
	 * 进入客片案例 列表页面
	 * @return
	 */
	public String list(){
		doList();
		initIslandList();
		return "list";
	}
	
	private void doList(){
		List<CustomerCase> ctcList = new ArrayList<CustomerCase>();
		map.clear();
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize == null ? defaultPS : pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		ctcList = ctmcaseBiz.queryCtmcasePkgByMap(map);
		if(ctcList != null && ctcList.size()>0){
			this.totalSize = ctmcaseBiz.countCtmcasePkgByMap(map);
			for (CustomerCase ctc : ctcList) {
				ctc.setStrPhotoTime(IslandDateUtil.getDateStrByUnixTime(ctc.getPhototime(), "yyyy-MM-dd"));
				ctmcaseList.add(ctc);
			}
		}
		initTotalPageSize();
	}
	
	private void initTotalPageSize(){
		this.totalPageSize = (totalSize - 1)/(pageSize == null ? defaultPS : pageSize) + 1;
	}
	
	public String toAddBase(){
		
		return "addbase";
	}
	
	public String addCtmcase(){
		ctmcase.setValid(1);
		ctmcase.setCreateperson(getCreater());
		ctmcase.setCreatetime(getTime());
		ctmcase.setPhototime(IslandDateUtil.getUnixTimeByDateStr(ctmcase.getStrPhotoTime()));
		ctmcaseBiz.addCtmcase(ctmcase);
		return list(); 
	}
	
	public String toEditBase(){
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		ctmcase.setStrPhotoTime(IslandDateUtil.getDateStrByUnixTime(ctmcase.getPhototime(), "yyyy-MM-dd"));
		initAreaList();
		initIslandList();
		initPkgTypeList(ctmcase.getAreaid(),ctmcase.getIslandid(),ctmcase.getCasetype());
		return "editbase";
	}

	public String editCtmcase(){
		ctmcase.setUpdperson(getCreater());
		ctmcase.setUpdtime(getTime());
		ctmcase.setPhototime(IslandDateUtil.getUnixTimeByDateStr(ctmcase.getStrPhotoTime()));
		ctmcaseBiz.updateCtmcase(ctmcase);
		return list();
	}
	
	public String delCtmcase(){
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		ctmcase.setValid(0);
		ctmcase.setUpdperson(getCreater());
		ctmcase.setUpdtime(getTime());
		ctmcaseBiz.updateCtmcase(ctmcase);
		//删除 此案例 下所有的图片及视频
		map.clear();
		map.put("caseid", ctmId);
		casePMList = ctmcaseBiz.queryCasePmByMap(map);
		if(casePMList !=null && casePMList.size()>0){
			for (CasePicMapping cpm : casePMList) {
				cpm.setValid(0);
				cpm.setUpdperson(getCreater());
				cpm.setUpdtime(getTime());
				ctmcaseBiz.updateCaseImgMapping(cpm);
			}
		}
		caseVMList = ctmcaseBiz.queryCaseVmByMap(map);
		if(caseVMList !=null && caseVMList.size()>0){
			for (CaseVideoMapping cvm : caseVMList) {
				cvm.setValid(0);
				cvm.setUpdperson(getCreater());
				cvm.setUpdtime(getTime());
				ctmcaseBiz.updateCaseVideoMapping(cvm);
			}
		}
		return list();
	}
	
	public String imglist(){
		docasePmlist();
		return "imglist";
	}
	
	private void docasePmlist() {
		map.clear();
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize == null ? defaultPS : pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		map.put("caseid",ctmId);//拿对应案例下的图片
		casePMList = ctmcaseBiz.queryCasePmByMap(map);
		if(casePMList != null && casePMList.size()>0){
			this.totalSize = ctmcaseBiz.countCasePmByMap(map);
		}
		//拿到对应案例的基本信息
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		initTotalPageSize();
	}

	public String editImgOrVideo(){
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		if(ctmcase.getCasetype() == 130){//图片
			return imglist();
		}		
		return videolist();
	}
	

	public String toAddImg(){
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		return "addimg";
	}
	
	public String saveImg(){
		casepm.setCreateperson(getCreater());
		casepm.setCreatetime(getTime());
		casepm.setValid(1);
		casepm.setPictureurl(UploadImgUtils.getImgUrl(image, imageFileName));
		ctmcaseBiz.addImgcase(casepm);
		ctmcase = ctmcaseBiz.queryCtmCaseById(casepm.getCaseid());
		if("continue".equals(flag)){//保存并继续添加
			return "addimg";
		}
		this.ctmId = ctmcase.getId();
		return imglist();
	}
	
	public String toEditImg(){
		casepm = ctmcaseBiz.queryCasePmByCtmImgId(ctmImgId);
		return "editimg";
	}
	
	public String editImgcase(){
		if(null != image){//如何修改时图片不为空,则保存新的图片地址。
			casepm.setPictureurl(UploadImgUtils.getImgUrl(image, imageFileName));
		}
		casepm.setUpdperson(getCreater());
		casepm.setUpdtime(getTime());
		ctmcaseBiz.updateCaseImgMapping(casepm);
		this.ctmId = casepm.getCaseid();
		return imglist();
	}
	
	public String delImgcase(){
		casepm = ctmcaseBiz.queryCasePmByCtmImgId(ctmImgId);
		casepm.setValid(0);
		casepm.setUpdperson(getCreater());
		casepm.setUpdtime(getTime());
		ctmcaseBiz.updateCaseImgMapping(casepm);
		this.ctmId = casepm.getCaseid();
		return imglist();
	}
	
	private String videolist() {
		docaseVMlist();
		return "videolist";
	}

	private void docaseVMlist() {
		map.clear();
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize == null ? defaultPS : pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		map.put("caseid",ctmId);//拿对应案例下的视频
		caseVMList = ctmcaseBiz.queryCaseVmByMap(map);
		if(caseVMList != null && caseVMList.size()>0){
			this.totalSize = ctmcaseBiz.countCaseVmByMap(map);
		}
		//拿到对应案例的基本信息
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		initTotalPageSize();
	}

	public String toAddVideo(){
		ctmcase = ctmcaseBiz.queryCtmCaseById(ctmId);
		return "addvideo";
	}
	
	public String saveVideo(){
		casevm.setCreateperson(getCreater());
		casevm.setCreatetime(getTime());
		casevm.setLogourl(UploadImgUtils.getImgUrl(image, imageFileName));
		casevm.setValid(1);
		ctmcaseBiz.addVideocase(casevm);
		ctmcase = ctmcaseBiz.queryCtmCaseById(casevm.getCaseid());
		if("continue".equals(flag)){//保存并继续添加
			return "addvideo";
		}
		this.ctmId = ctmcase.getId();
		return videolist();
	}
	
	public String toEditVideo(){
		casevm = ctmcaseBiz.queryCaseVmByCtmImgId(ctmVideoId);
		return "editvideo";
	}
	
	public String editVideocase(){
		if(null != image){//如何修改时视频图片不为空,则保存新的图片地址。
			casevm.setLogourl(UploadImgUtils.getImgUrl(image, imageFileName));
		}
		casevm.setUpdperson(getCreater());
		casevm.setUpdtime(getTime());
		ctmcaseBiz.updateCaseVideoMapping(casevm);
		this.ctmId = casevm.getCaseid();
		return videolist();
	}
	
	public String delVideoCase(){
		casevm = ctmcaseBiz.queryCaseVmByCtmImgId(ctmVideoId);
		casevm.setValid(0);
		casevm.setUpdperson(getCreater());
		casevm.setUpdtime(getTime());
		ctmcaseBiz.updateCaseVideoMapping(casevm);
		this.ctmId = casevm.getCaseid();
		return videolist();
	}



	private int getTime() {
		return (int)(System.currentTimeMillis()/1000);
	}
	
	
	public void getArea() throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("valid", 1);
		List<Area> areaList = areaIslandBiz.queryAreaByMap(map);
		Struts2Utils.renderJson(mapper.writeValueAsString(areaList));
	}
	
	public void getIslandByAreaId() throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("valid", 1);
		map.put("areaId", areaId);
		List<Island> islandList = areaIslandBiz.queryIslandByMap(map);
		Struts2Utils.renderJson(mapper.writeValueAsString(islandList));
	}
	
	public void getChildType() throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("valid", 1);
		map.put("areaId", areaId);
		map.put("packageType", csType);
		map.put("islandId", islandId);
		List<IslandPackageType> typeList= ctmcaseBiz.queryAreaListByCaseType(map);
		Struts2Utils.renderJson(mapper.writeValueAsString(typeList));
	}
	

	private void initPkgTypeList(Integer areaId, Integer islandId, Integer csType) {
		map.clear();
		map.put("valid", 1);
		map.put("areaId", areaId);
		map.put("islandId", islandId);
		map.put("packageType", csType);
		this.pkgTypeList = ctmcaseBiz.queryAreaListByCaseType(map);
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

	public List<PackageImageRelation> getWdpImgList() {
		return wdpImgList;
	}

	public void setWdpImgList(List<PackageImageRelation> wdpImgList) {
		this.wdpImgList = wdpImgList;
	}

	public CustomerCase getCtmcase() {
		return ctmcase;
	}

	public void setCtmcase(CustomerCase ctmcase) {
		this.ctmcase = ctmcase;
	}

	public List<IslandPackageType> getPkgTypeList() {
		return pkgTypeList;
	}

	public void setPkgTypeList(List<IslandPackageType> pkgTypeList) {
		this.pkgTypeList = pkgTypeList;
	}

	public Integer getCsType() {
		return csType;
	}

	public void setCsType(Integer csType) {
		this.csType = csType;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getIslandId() {
		return islandId;
	}

	public void setIslandId(Integer islandId) {
		this.islandId = islandId;
	}

	public List<CustomerCase> getCtmcaseList() {
		return ctmcaseList;
	}

	public void setCtmcaseList(List<CustomerCase> ctmcaseList) {
		this.ctmcaseList = ctmcaseList;
	}

	public Integer getCtmId() {
		return ctmId;
	}

	public void setCtmId(Integer ctmId) {
		this.ctmId = ctmId;
	}

	public CasePicMapping getCasepm() {
		return casepm;
	}

	public void setCasepm(CasePicMapping casepm) {
		this.casepm = casepm;
	}

	public CaseVideoMapping getCasevm() {
		return casevm;
	}

	public void setCasevm(CaseVideoMapping casevm) {
		this.casevm = casevm;
	}

	public List<CasePicMapping> getCasePMList() {
		return casePMList;
	}

	public void setCasePMList(List<CasePicMapping> casePMList) {
		this.casePMList = casePMList;
	}

	public List<CaseVideoMapping> getCaseVMList() {
		return caseVMList;
	}

	public void setCaseVMList(List<CaseVideoMapping> caseVMList) {
		this.caseVMList = caseVMList;
	}

	public Integer getCtmImgId() {
		return ctmImgId;
	}

	public void setCtmImgId(Integer ctmImgId) {
		this.ctmImgId = ctmImgId;
	}

	public Integer getCtmVideoId() {
		return ctmVideoId;
	}

	public void setCtmVideoId(Integer ctmVideoId) {
		this.ctmVideoId = ctmVideoId;
	}

}
