package com.islandback.action.wdpteam;



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
import com.island.domain.biz.WdpTeamBiz;
import com.island.domain.biz.WeddingPhotoBiz;
import com.island.domain.dal.PackageKepianliuyingIbatisDAOImpl;
import com.island.domain.model.Area;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.IslandPackageType;
import com.island.domain.model.PackageDetailInfo;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.PackageKepianliuying;
import com.island.domain.model.PhotoSubscribe;
import com.island.domain.model.Workman;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;
import com.islandback.web.util.UploadImgUtils;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/wdpphototeam/subscribe")
@ResultPath("/WEB-INF")
/**
 *预约(档期)action
 *
 */
public class SubscribeAction extends BaseAction  {
	private static final long serialVersionUID = 1L;

	private PhotoSubscribe ptoSubscribe;
	Map<String,Object> map = new HashMap<String,Object>(0);
	
	
	private String flag;//判断是 保存返回，还是保存继续增加。
	private Integer typeId;
	private Integer subscribeId;
	private Integer actionType = 3;
	
	private File image;
	
	private String imageFileName;

	private Integer totalPageSize;
	private Integer totalSize=0;
	private Integer pageNo=1;
	private Integer pageSize=10;
	
	private String creater="";
	
	private List<IslandPackageType> packageTypeList = new ArrayList<IslandPackageType>(0);
	
	private List<Workman> wkmList = new ArrayList<Workman>(0);
	
	private List<PhotoSubscribe> ptoSubscribeList = new ArrayList<PhotoSubscribe>(0);
	
	private List<PhotoSubscribe> positionList = new ArrayList<PhotoSubscribe>(0);
	
	private ObjectMapper mapper = new ObjectMapper();
	

	WeddingPhotoBiz weddingPhotoBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getWeddingPhotoBiz();
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	ModuleTypeBiz moduleTypeBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getModuleTypeBiz();
	
	WdpTeamBiz wdpTeamBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getWdpTeamBiz();
	
	
	private String getCreater(){
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		return creater;
	}
	
	/**
	 * 进入 列表页面
	 * @return
	 */
	public String list(){
		doList();
		//initIslandList();
		return "list";
	}
	
	private void doList(){
		map.clear();
		map.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("size", page.getPageSize());
		ptoSubscribeList = wdpTeamBiz.queryPtoSubscribeByMap(map);
		if(ptoSubscribeList != null && ptoSubscribeList.size()>0){
			this.totalSize = wdpTeamBiz.countPtoSubscribeByMap(map);
		}
		initTotalPageSize();
	}
	
	private void initTotalPageSize(){
		this.totalPageSize = (totalSize - 1)/pageSize + 1;
	}
	
	
	/**
	 *  搜索(查询) 功能
	 * @return
	 */
	public String wdpPackageSearch(){
		map.clear();
		map.put("valid", 1);
		map.put("isOnline", 1);
		ptoSubscribeList = wdpTeamBiz.queryPtoSubscribeByMap(map);
		this.totalSize = wdpTeamBiz.countPtoSubscribeByMap(map);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		initTotalPageSize();
	
		return "list";
	}
	
	
	/**
	 * 新增 页面
	 * @return
	 */
	public String toAdd(){
		
		return "add";
	}
	
	/**
	 * 新增信息
	 * @return
	 */
	public String addSubscribeInfo(){
		ptoSubscribe.setValid(1);
		ptoSubscribe.setCreateperson(getCreater());
		ptoSubscribe.setCreatetime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		
		//wdpPackage.setAreaId(getAreaIsland().getAreaId());
		wdpTeamBiz.addSubscribe(ptoSubscribe);
		
		if("toList".equals(flag)){
			return list();
		}
		return "detail";
	}
	/**
	 * 进入 修改 图片信息 页面
	 */
	public String toEdit(){
		return "edit";
	}

	public String editSubscribeInfo(){
		ptoSubscribe.setUpdperson(getCreater());
		ptoSubscribe.setUpdtime((int)(System.currentTimeMillis()/1000));
		wdpTeamBiz.updatePtoSubscribe(ptoSubscribe);
		return list();
	}
	/**
	 * 删除 
	 */
	public String deleteSubscribeInfo(){
		ptoSubscribe.setUpdperson(getCreater());
		ptoSubscribe.setUpdtime(new Long(Calendar.getInstance().getTimeInMillis()/1000).intValue());
		ptoSubscribe.setValid(0);//无效即表示删除。
		ptoSubscribe.setId(subscribeId);
		wdpTeamBiz.updateSubscribe(ptoSubscribe);
		return list();
	}
	
	/**
	 *	摄影类型id
	 * @return
	 */
	public void getPositionByTypeId()throws JsonGenerationException, JsonMappingException, IOException{
		map.clear();
		map.put("workType", typeId);
		wkmList = wdpTeamBiz.queryWkmByWorkId(map);
		if(wkmList != null && wkmList.size() > 0){
			for (Workman wkm : wkmList) {
				PhotoSubscribe pts = new PhotoSubscribe();
				pts.setPositionId(wkm.getId());
				pts.setPositionName(wkm.getName());
				positionList.add(pts);
			}
		}		
		Struts2Utils.renderJson(mapper.writeValueAsString(positionList));
	}
	
	
	public List<IslandPackageType> getPackageTypeList() {
		return packageTypeList;
	}

	public void setPackageTypeList(List<IslandPackageType> packageTypeList) {
		this.packageTypeList = packageTypeList;
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


	public List<Workman> getWkmList() {
		return wkmList;
	}

	public void setWkmList(List<Workman> wkmList) {
		this.wkmList = wkmList;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public PhotoSubscribe getPtoSubscribe() {
		return ptoSubscribe;
	}

	public void setPtoSubscribe(PhotoSubscribe ptoSubscribe) {
		this.ptoSubscribe = ptoSubscribe;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public List<PhotoSubscribe> getPtoSubscribeList() {
		return ptoSubscribeList;
	}

	public void setPtoSubscribeList(List<PhotoSubscribe> ptoSubscribeList) {
		this.ptoSubscribeList = ptoSubscribeList;
	}

	public List<PhotoSubscribe> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<PhotoSubscribe> positionList) {
		this.positionList = positionList;
	}

	public Integer getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(Integer subscribeId) {
		this.subscribeId = subscribeId;
	}

}
