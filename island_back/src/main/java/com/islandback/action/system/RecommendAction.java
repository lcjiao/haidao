package com.islandback.action.system;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.logging.LogUtil;
import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.CustomerCaseBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.biz.ModuleTypeBiz;
import com.island.domain.biz.RecommendBiz;
import com.island.domain.biz.WdpTeamBiz;
import com.island.domain.model.Area;
import com.island.domain.model.CasePicMapping;
import com.island.domain.model.CaseVideoMapping;
import com.island.domain.model.Country;
import com.island.domain.model.CustomerCase;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.island.domain.model.PackageImageRelation;
import com.island.domain.model.Recommend;
import com.island.domain.model.Workman;
import com.islandback.action.base.BaseAction;
import com.islandback.module.ModuleEnum;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;

@Namespace("/system")
@ResultPath("/WEB-INF")
public class RecommendAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer packageType;
	private String modueIds;
	AreaIslandBiz areaIslandBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getAreaIslandBiz();
	
	
	RecommendBiz recommendBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRecommendBiz();
	
	MarrayPackageBiz packageBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getMarrayPackageBiz();
	
	WdpTeamBiz wdpTeamBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getWdpTeamBiz();
	
	CustomerCaseBiz ctmcaseBiz = ModuleRegistry.getInstance()
			.getModule(DomainIslandModule.class).getCustomerCaseBiz();
	
	
	
	public void systemRecommend(){
		/**
		 *  初始化套餐信息  
		 *  套餐logo图片
		 *  套餐详情页url地址
		 */
		IslandPackage islandPackage = packageBiz.queryPackageById(id);
		Map<String,Object> imgParams = new HashMap<String,Object>(0);
		imgParams.put("valid", 1);
		imgParams.put("imgType", 1);
		imgParams.put("packageId", id);
		if( islandPackage != null){
			List<PackageImageRelation> list = packageBiz.queryPackageImgByMap(imgParams);
			if(list != null && list.size()>0  ){
				PackageImageRelation logo = list.get(0);
				islandPackage.setLogoUrl(logo.getImgUrl());
			}
			islandPackage.setDetailUrl( getDetailUrlByPackageId() );
			
		}
		
		
		
				
		String[] module_ids = modueIds.split(",");
		for(String moduleId : module_ids ){
			/**
			 * 初始化推荐对象
			 * 推荐人
			 * 推荐时间
			 * 是否有效
			 * 显示次序
			 * 所属模块编号
			 */
			Recommend obj = new Recommend();
			String creater = "";
			SessionInfo sessionInfo = RequestProcc.getSessionInfo();
			if(sessionInfo != null ){
				creater = sessionInfo.getUser().getUserName(); 
			}
			int now = (int)(System.currentTimeMillis()/1000);
			obj.setCreatePerson(creater);
			obj.setCreateTime(now);
			obj.setValid(1);
			obj.setModuleId( Integer.parseInt(moduleId) );
			Map<String,Object> params = new HashMap<String,Object>(0);
			params.put("moduleId", moduleId);
			params.put("valid", 1);
			Integer totalSize = recommendBiz.countByMap(params);
			Integer nextIndex = totalSize + 1;
			obj.setRecommendIndex(nextIndex);
			
			if( Integer.parseInt(moduleId) == ModuleEnum.PHOTO_TEAM_RECOMMEND){
				recommend106(obj);
			}
			else if(  Integer.parseInt(moduleId) == ModuleEnum.CUSTOMER_CASE_TOP_RECOMMEND ){
				recommend107(obj);
			}
			else if(  Integer.parseInt(moduleId) == ModuleEnum.CUSTOMER_CASE_FACE_VIDEO_RECOMMEND ){
				recommend108(obj);
			}
			else if(  Integer.parseInt(moduleId) == ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND ){
				recommend109(obj);
			}
			else{
				recommendByPackage(Integer.parseInt(moduleId),islandPackage,obj);
			}
			
			
			
		}
		
		Struts2Utils.renderText("ok");
	}
	
	private void recommendByPackage(Integer moduleId,IslandPackage islandPackage,Recommend obj){
		
		if( moduleId.intValue() == 1 ){
			recommend1(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 3){
			recommend3(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 4){
			recommend4(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 20){
			recommend20(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 21){
			recommend21(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 22){
			recommend22(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 23){
			recommend23(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 6){
			recommend6(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 7){
			recommend7(islandPackage,obj);
		}
		
		
		if( moduleId.intValue() == 8){
			recommend8(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 10){
			recommend10(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 11){
			recommend11(islandPackage,obj);
		}
		
		
		if( moduleId.intValue() == 12){
			recommend12(islandPackage,obj);
		}
		
		
		if( moduleId.intValue() == 14){
			recommend14(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 15){
			recommend15(islandPackage,obj);
		}
		
		
		if( moduleId.intValue() == 16){
			recommend16(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 101){
			recommend101(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 102){
			recommend102(islandPackage,obj);
		}
		
		if( moduleId.intValue() == 103){
			recommend103(islandPackage,obj);
		}
	}
	
	
	private void recommend1(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void recommend3(IslandPackage islandPackage,Recommend addObj){
		addObj.setTitle(islandPackage.getTitle());
		addObj.setTypeId(1);
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setRecommendTime(now+"");
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void recommend4(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setRecommendDesc(islandPackage.getTitle());
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void recommend20(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setPrice(islandPackage.getPriceSmall());
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void recommend21(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTitle(islandPackage.getTitle());
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setRecommendTime(now+"");
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void recommend22(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setTitle(islandPackage.getTitle());
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void recommend23(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setRecommendDesc("");
		this.recommendBiz.addMasterRecommend(addObj);
	}	
	
	private void recommend6(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setBigImgUrl("");
		addObj.setSmallImgUrl("");
		this.recommendBiz.addMasterRecommend(addObj);
	}	
	
	private void recommend10(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setBigImgUrl("");
		addObj.setSmallImgUrl("");
		this.recommendBiz.addMasterRecommend(addObj);
	}	
	
	private void recommend14(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setBigImgUrl("");
		addObj.setSmallImgUrl("");
		this.recommendBiz.addMasterRecommend(addObj);
	}	
	
	
	
	private void recommend7(IslandPackage islandPackage,Recommend addObj){
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setRecommendDesc("");
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(3);
		this.recommendBiz.addMasterRecommend(addObj);
		
		
		Map<String,Object> landParams = new HashMap<String,Object>(0);
		landParams.put("moduleId", ModuleEnum.MARRAY_PACKAGE_INDEX_SECOEND_RECOMMEND);
		landParams.put("valid", 1);
		landParams.put("typeId", 2);
		landParams.put("islandId", islandPackage.getIslandId());
		List<Recommend> islandList = recommendBiz.queryByMap(landParams);
		if( islandList == null || islandList.isEmpty() ){
			 Recommend islandRecommend = new Recommend();
			 islandRecommend.setCreatePerson(addObj.getCreatePerson());
			 islandRecommend.setCreateTime(addObj.getCreateTime());
			 islandRecommend.setValid(1);
			 islandRecommend.setModuleId(ModuleEnum.MARRAY_PACKAGE_INDEX_SECOEND_RECOMMEND);
			 islandRecommend.setTypeId(2);
			 islandRecommend.setAreaId(islandPackage.getAreaId());
			 islandRecommend.setAreaName(islandPackage.getAreaName());
			 islandRecommend.setIslandId(islandPackage.getIslandId());
			 islandRecommend.setIslandName(islandPackage.getIslandName());
			 Integer totalSize = recommendBiz.countByMap(landParams);
			 islandRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(islandRecommend);
		}
		
	}	
	
	private void recommend11(IslandPackage islandPackage,Recommend addObj){
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setRecommendDesc("");
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(3);
		this.recommendBiz.addMasterRecommend(addObj);
		
		
		Map<String,Object> landParams = new HashMap<String,Object>(0);
		landParams.put("moduleId", ModuleEnum.HOTEL_PACKAGE_INDEX_SECOEND_RECOMMEND);
		landParams.put("valid", 1);
		landParams.put("typeId", 2);
		landParams.put("islandId", islandPackage.getIslandId());
		List<Recommend> islandList = recommendBiz.queryByMap(landParams);
		if( islandList == null || islandList.isEmpty() ){
			 Recommend islandRecommend = new Recommend();
			 islandRecommend.setCreatePerson(addObj.getCreatePerson());
			 islandRecommend.setCreateTime(addObj.getCreateTime());
			 islandRecommend.setValid(1);
			 islandRecommend.setModuleId(ModuleEnum.HOTEL_PACKAGE_INDEX_SECOEND_RECOMMEND);
			 islandRecommend.setTypeId(2);
			 islandRecommend.setAreaId(islandPackage.getAreaId());
			 islandRecommend.setAreaName(islandPackage.getAreaName());
			 islandRecommend.setIslandId(islandPackage.getIslandId());
			 islandRecommend.setIslandName(islandPackage.getIslandName());
			 Integer totalSize = recommendBiz.countByMap(landParams);
			 islandRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(islandRecommend);
		}
		
	}	

	
	private void recommend15(IslandPackage islandPackage,Recommend addObj){
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setRecommendDesc("");
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(3);
		this.recommendBiz.addMasterRecommend(addObj);
		
		
		Map<String,Object> landParams = new HashMap<String,Object>(0);
		landParams.put("moduleId", ModuleEnum.FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND);
		landParams.put("valid", 1);
		landParams.put("typeId", 2);
		landParams.put("islandId", islandPackage.getIslandId());
		List<Recommend> islandList = recommendBiz.queryByMap(landParams);
		if( islandList == null || islandList.isEmpty() ){
			 Recommend islandRecommend = new Recommend();
			 islandRecommend.setCreatePerson(addObj.getCreatePerson());
			 islandRecommend.setCreateTime(addObj.getCreateTime());
			 islandRecommend.setValid(1);
			 islandRecommend.setModuleId(ModuleEnum.FREEWALK_PACKAGE_INDEX_SECOEND_RECOMMEND);
			 islandRecommend.setTypeId(2);
			 islandRecommend.setAreaId(islandPackage.getAreaId());
			 islandRecommend.setAreaName(islandPackage.getAreaName());
			 islandRecommend.setIslandId(islandPackage.getIslandId());
			 islandRecommend.setIslandName(islandPackage.getIslandName());
			 Integer totalSize = recommendBiz.countByMap(landParams);
			 islandRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(islandRecommend);
		}
		
	}	


	
	private void recommend8(IslandPackage islandPackage,Recommend addObj){
		addObj.setAreaId(islandPackage.getAreaId());
		addObj.setAreaName(islandPackage.getAreaName());
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setPriceBig(islandPackage.getPriceBig());
		addObj.setPriceSmall(islandPackage.getPriceSmall());
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(3);
		addObj.setRecommendDesc("");
		this.recommendBiz.addMasterRecommend(addObj);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.MARRAY_PACKAGE_INDEX_AREA_RECOMMEND);
		params.put("valid", 1);
		params.put("typeId", 1);
		params.put("areaId", islandPackage.getAreaId());
		List<Recommend> areaList = recommendBiz.queryByMap(params);
		if( areaList == null || areaList.isEmpty() ){
			 Recommend areaRecommend = new Recommend();
			 areaRecommend.setCreatePerson(addObj.getCreatePerson());
			 areaRecommend.setCreateTime(addObj.getCreateTime());
			 areaRecommend.setValid(1);
			 areaRecommend.setModuleId(ModuleEnum.MARRAY_PACKAGE_INDEX_AREA_RECOMMEND);
			 areaRecommend.setTypeId(1);
			 areaRecommend.setAreaId(islandPackage.getAreaId());
			 areaRecommend.setAreaName(islandPackage.getAreaName());
			 Integer totalSize = recommendBiz.countByMap(params);
			 areaRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(areaRecommend);
		}
		
		Map<String,Object> landParams = new HashMap<String,Object>(0);
		landParams.put("moduleId", ModuleEnum.MARRAY_PACKAGE_INDEX_AREA_RECOMMEND);
		landParams.put("valid", 1);
		landParams.put("typeId", 2);
		landParams.put("islandId",islandPackage.getIslandId() );
		List<Recommend> islandList = recommendBiz.queryByMap(landParams);
		if( islandList == null || islandList.isEmpty() ){
			 Recommend islandRecommend = new Recommend();
			 islandRecommend.setCreatePerson(addObj.getCreatePerson());
			 islandRecommend.setCreateTime(addObj.getCreateTime());
			 islandRecommend.setValid(1);
			 islandRecommend.setModuleId(ModuleEnum.MARRAY_PACKAGE_INDEX_AREA_RECOMMEND);
			 islandRecommend.setTypeId(2);
			 islandRecommend.setAreaId(islandPackage.getAreaId());
			 islandRecommend.setAreaName(islandPackage.getAreaName());
			 islandRecommend.setIslandId(islandPackage.getIslandId());
			 islandRecommend.setIslandName(islandPackage.getIslandName());
			 Integer totalSize = recommendBiz.countByMap(landParams);
			 islandRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(islandRecommend);
		}
		
	}	
	
	private void recommend12(IslandPackage islandPackage,Recommend addObj){
		addObj.setAreaId(islandPackage.getAreaId());
		addObj.setAreaName(islandPackage.getAreaName());
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setPriceBig(islandPackage.getPriceBig());
		addObj.setPriceSmall(islandPackage.getPriceSmall());
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(3);
		addObj.setRecommendDesc("");
		this.recommendBiz.addMasterRecommend(addObj);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.HOTEL_PACKAGE_INDEX_AREA_RECOMMEND);
		params.put("valid", 1);
		params.put("typeId", 1);
		params.put("areaId", islandPackage.getAreaId());
		List<Recommend> areaList = recommendBiz.queryByMap(params);
		if( areaList == null || areaList.isEmpty() ){
			 Recommend areaRecommend = new Recommend();
			 areaRecommend.setCreatePerson(addObj.getCreatePerson());
			 areaRecommend.setCreateTime(addObj.getCreateTime());
			 areaRecommend.setValid(1);
			 areaRecommend.setModuleId(ModuleEnum.HOTEL_PACKAGE_INDEX_AREA_RECOMMEND);
			 areaRecommend.setTypeId(1);
			 areaRecommend.setAreaId(islandPackage.getAreaId());
			 areaRecommend.setAreaName(islandPackage.getAreaName());
			 Integer totalSize = recommendBiz.countByMap(params);
			 areaRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(areaRecommend);
		}
		
		Map<String,Object> landParams = new HashMap<String,Object>(0);
		landParams.put("moduleId", ModuleEnum.HOTEL_PACKAGE_INDEX_AREA_RECOMMEND);
		landParams.put("valid", 1);
		landParams.put("typeId", 2);
		landParams.put("islandId",islandPackage.getIslandId() );
		List<Recommend> islandList = recommendBiz.queryByMap(landParams);
		if( islandList == null || islandList.isEmpty() ){
			 Recommend islandRecommend = new Recommend();
			 islandRecommend.setCreatePerson(addObj.getCreatePerson());
			 islandRecommend.setCreateTime(addObj.getCreateTime());
			 islandRecommend.setValid(1);
			 islandRecommend.setModuleId(ModuleEnum.HOTEL_PACKAGE_INDEX_AREA_RECOMMEND);
			 islandRecommend.setTypeId(2);
			 islandRecommend.setAreaId(islandPackage.getAreaId());
			 islandRecommend.setAreaName(islandPackage.getAreaName());
			 islandRecommend.setIslandId(islandPackage.getIslandId());
			 islandRecommend.setIslandName(islandPackage.getIslandName());
			 Integer totalSize = recommendBiz.countByMap(landParams);
			 islandRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(islandRecommend);
		}
		
	}	
	
	
	private void recommend16(IslandPackage islandPackage,Recommend addObj){
		addObj.setAreaId(islandPackage.getAreaId());
		addObj.setAreaName(islandPackage.getAreaName());
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setTitle(islandPackage.getTitle());
		addObj.setPriceBig(islandPackage.getPriceBig());
		addObj.setPriceSmall(islandPackage.getPriceSmall());
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(3);
		addObj.setRecommendDesc("");
		this.recommendBiz.addMasterRecommend(addObj);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.FREEWALK_PACKAGE_INDEX_AREA_RECOMMEND);
		params.put("valid", 1);
		params.put("typeId", 1);
		params.put("areaId", islandPackage.getAreaId());
		List<Recommend> areaList = recommendBiz.queryByMap(params);
		if( areaList == null || areaList.isEmpty() ){
			 Recommend areaRecommend = new Recommend();
			 areaRecommend.setCreatePerson(addObj.getCreatePerson());
			 areaRecommend.setCreateTime(addObj.getCreateTime());
			 areaRecommend.setValid(1);
			 areaRecommend.setModuleId(ModuleEnum.FREEWALK_PACKAGE_INDEX_AREA_RECOMMEND);
			 areaRecommend.setTypeId(1);
			 areaRecommend.setAreaId(islandPackage.getAreaId());
			 areaRecommend.setAreaName(islandPackage.getAreaName());
			 Integer totalSize = recommendBiz.countByMap(params);
			 areaRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(areaRecommend);
		}
		
		Map<String,Object> landParams = new HashMap<String,Object>(0);
		landParams.put("moduleId", ModuleEnum.FREEWALK_PACKAGE_INDEX_AREA_RECOMMEND);
		landParams.put("valid", 1);
		landParams.put("typeId", 2);
		landParams.put("islandId",islandPackage.getIslandId() );
		List<Recommend> islandList = recommendBiz.queryByMap(landParams);
		if( islandList == null || islandList.isEmpty() ){
			 Recommend islandRecommend = new Recommend();
			 islandRecommend.setCreatePerson(addObj.getCreatePerson());
			 islandRecommend.setCreateTime(addObj.getCreateTime());
			 islandRecommend.setValid(1);
			 islandRecommend.setModuleId(ModuleEnum.FREEWALK_PACKAGE_INDEX_AREA_RECOMMEND);
			 islandRecommend.setTypeId(2);
			 islandRecommend.setAreaId(islandPackage.getAreaId());
			 islandRecommend.setAreaName(islandPackage.getAreaName());
			 islandRecommend.setIslandId(islandPackage.getIslandId());
			 islandRecommend.setIslandName(islandPackage.getIslandName());
			 Integer totalSize = recommendBiz.countByMap(landParams);
			 islandRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(islandRecommend);
		}
		
	}	
	
	
	private void  recommend101(IslandPackage islandPackage,Recommend addObj){
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setBigImgUrl("");
		addObj.setSmallImgUrl("");
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void  recommend102(IslandPackage islandPackage,Recommend addObj){
		Map<String,Object> islandParams = new HashMap<String,Object>(0);
		islandParams.put("moduleId", ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
		islandParams.put("valid", 1);
		islandParams.put("typeId", 2);
		Integer islandTotalSize = recommendBiz.countByMap(islandParams);
		addObj.setRecommendIndex(islandTotalSize+1);
		
		addObj.setAreaId(islandPackage.getAreaId());
		addObj.setAreaName(islandPackage.getAreaName());
		addObj.setIslandId(islandPackage.getIslandId());
		addObj.setIslandName(islandPackage.getIslandName());
		addObj.setRecommendDesc("");
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		addObj.setTypeId(2);
		this.recommendBiz.addMasterRecommend(addObj);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("moduleId", ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
		params.put("valid", 1);
		params.put("typeId", 1);
		List<Recommend> areaList = recommendBiz.queryByMap(params);
		if( areaList == null || areaList.isEmpty() ){
			 Recommend areaRecommend = new Recommend();
			 areaRecommend.setCreatePerson(addObj.getCreatePerson());
			 areaRecommend.setCreateTime(addObj.getCreateTime());
			 areaRecommend.setValid(1);
			 areaRecommend.setModuleId(ModuleEnum.WEDDING_PHOTO_FACE_RECOMMEND);
			 areaRecommend.setTypeId(1);
			 areaRecommend.setAreaId(islandPackage.getAreaId());
			 areaRecommend.setAreaName(islandPackage.getAreaName());
			 areaRecommend.setTypeName("区域推荐");
			 Integer totalSize = recommendBiz.countByMap(params);
			 areaRecommend.setRecommendIndex(totalSize+1);
			 this.recommendBiz.addMasterRecommend(areaRecommend);
		}
		
	}
	
	private void  recommend103(IslandPackage islandPackage,Recommend addObj){
		addObj.setTitle(islandPackage.getTitle());
		addObj.setRecommendDesc("");
		addObj.setLinkUrl( islandPackage.getDetailUrl() );
		addObj.setImgUrl(islandPackage.getLogoUrl());
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void  recommend106(Recommend addObj){
		
		Workman workman = null;
		workman = wdpTeamBiz.queryWkmPackageBywkmId(id);
		Map<String,Object> workManImgParams = new HashMap<String,Object>(0);
		workManImgParams.put("valid", 1);
		workManImgParams.put("imgType", 1);
		workManImgParams.put("packageId", id);
		List<PackageImageRelation> workManImgList = packageBiz.queryPackageImgByMap(workManImgParams);
		if(workManImgList != null && workManImgList.size()>0){
			PackageImageRelation logo = workManImgList.get(0);
			workman.setLogoUrl(logo.getImgUrl());
		}
		workman.setDetailUrl( getDetailUrlByPackageId() );
		
		
		addObj.setTitle(workman.getName());
		addObj.setLinkUrl( workman.getDetailUrl() );
		addObj.setImgUrl(workman.getLogoUrl());
		addObj.setRecommendDesc("");//创建人
		addObj.setContent( workman.getContent());//创建人简介
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void  recommend107(Recommend addObj){
		CustomerCase customerCase = null;
		customerCase = ctmcaseBiz.queryCtmCaseById(id);
		Integer type = customerCase.getCasetype();
		this.packageType = type;
		addObj.setLinkUrl( getDetailUrlByPackageId() );
		addObj.setBigImgUrl("");
		addObj.setSmallImgUrl("");
		this.recommendBiz.addMasterRecommend(addObj);
	}
	
	private void  recommend108(Recommend addObj){
		CustomerCase customerCase = null;
		customerCase = ctmcaseBiz.queryCtmCaseById(id);
		Integer type = customerCase.getCasetype();
		if( type.intValue() == 131){
			Map<String,Object> caseVideoParam = new HashMap<String,Object>(0);
			caseVideoParam.put("valid", 1);
			caseVideoParam.put("caseid", id);
			List<CaseVideoMapping> videoCaseList = ctmcaseBiz.queryCaseVmByMap(caseVideoParam);
			if( videoCaseList != null && !videoCaseList.isEmpty()){
				CaseVideoMapping caseVideo = videoCaseList.get(0);
				addObj.setImgUrl(caseVideo.getLogourl());
				addObj.setViewLink(caseVideo.getVideourl());
				addObj.setRecommendDesc(caseVideo.getVideodesc());
			}
			this.packageType = type;
			addObj.setLinkUrl( getDetailUrlByPackageId() );
			addObj.setAreaId(customerCase.getAreaid());
			addObj.setAreaName(customerCase.getAreaname());
			addObj.setTypeId(3);
			
			Map<String,Object> videoParams = new HashMap<String,Object>(0);
			videoParams.put("moduleId", ModuleEnum.CUSTOMER_CASE_FACE_VIDEO_RECOMMEND);
			videoParams.put("valid", 1);
			videoParams.put("typeId", 3);
			Integer videoTotalSize = recommendBiz.countByMap(videoParams);
			addObj.setRecommendIndex(videoTotalSize+1);
			
			this.recommendBiz.addMasterRecommend(addObj);
			
			Map<String,Object> params = new HashMap<String,Object>(0);
			params.put("moduleId", ModuleEnum.CUSTOMER_CASE_FACE_VIDEO_RECOMMEND);
			params.put("valid", 1);
			params.put("typeId", 1);
			params.put("areaId", customerCase.getAreaid());
			List<Recommend> areaList = recommendBiz.queryByMap(params);
			if( areaList == null || areaList.isEmpty() ){
				 Recommend areaRecommend = new Recommend();
				 areaRecommend.setCreatePerson(addObj.getCreatePerson());
				 areaRecommend.setCreateTime(addObj.getCreateTime());
				 areaRecommend.setValid(1);
				 areaRecommend.setModuleId(ModuleEnum.CUSTOMER_CASE_FACE_VIDEO_RECOMMEND);
				 areaRecommend.setTypeId(1);
				 areaRecommend.setAreaId(customerCase.getAreaid());
				 areaRecommend.setAreaName(customerCase.getAreaname());
				 areaRecommend.setTypeName("区域推荐");
				 Integer totalSize = recommendBiz.countByMap(params);
				 areaRecommend.setRecommendIndex(totalSize+1);
				 this.recommendBiz.addMasterRecommend(areaRecommend);
			}
			
		}
		
	}
	
	private void  recommend109(Recommend addObj){
		CustomerCase customerCase = null;
		customerCase = ctmcaseBiz.queryCtmCaseById(id);
		Integer type = customerCase.getCasetype();
		if( type.intValue() == 130){
			Map<String,Object> caseVideoParam = new HashMap<String,Object>(0);
			caseVideoParam.put("valid", 1);
			caseVideoParam.put("caseid", id);
			List<CasePicMapping> imgCaseList = ctmcaseBiz.queryCasePmByMap(caseVideoParam);
			if( imgCaseList != null && !imgCaseList.isEmpty()){
				CasePicMapping imgCase = imgCaseList.get(0);
				addObj.setImgUrl(imgCase.getPictureurl());
				
			}
			this.packageType = type;
			addObj.setRecommendDesc(customerCase.getCasename());
			addObj.setLinkUrl( getDetailUrlByPackageId() );
			addObj.setAreaId(customerCase.getAreaid());
			addObj.setAreaName(customerCase.getAreaname());
			addObj.setTypeId(4);
			
			Map<String,Object> imgParams = new HashMap<String,Object>(0);
			imgParams.put("moduleId", ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND);
			imgParams.put("valid", 1);
			imgParams.put("typeId", 4);
			Integer imgTotalSize = recommendBiz.countByMap(imgParams);
			addObj.setRecommendIndex(imgTotalSize+1);
			
			this.recommendBiz.addMasterRecommend(addObj);
			
			Map<String,Object> params = new HashMap<String,Object>(0);
			params.put("moduleId", ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND);
			params.put("valid", 1);
			params.put("typeId", 1);
			params.put("areaId", customerCase.getAreaid());
			List<Recommend> areaList = recommendBiz.queryByMap(params);
			if( areaList == null || areaList.isEmpty() ){
				 Recommend areaRecommend = new Recommend();
				 areaRecommend.setCreatePerson(addObj.getCreatePerson());
				 areaRecommend.setCreateTime(addObj.getCreateTime());
				 areaRecommend.setValid(1);
				 areaRecommend.setModuleId(ModuleEnum.CUSTOMER_CASE_FACE_IMAGE_RECOMMEND);
				 areaRecommend.setTypeId(1);
				 areaRecommend.setAreaId(customerCase.getAreaid());
				 areaRecommend.setAreaName(customerCase.getAreaname());
				 areaRecommend.setTypeName("区域推荐");
				 Integer totalSize = recommendBiz.countByMap(params);
				 areaRecommend.setRecommendIndex(totalSize+1);
				 this.recommendBiz.addMasterRecommend(areaRecommend);
			}
			
		}
		
	}


	
	private String getDetailUrlByPackageId(){
		String frontUrl = ModuleEnum.getFrontWebUrl();
		//return frontUrl+"";
		return "http://www.baidu.com";
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

	public String getModueIds() {
		return modueIds;
	}

	public void setModueIds(String modueIds) {
		this.modueIds = modueIds;
	}
	
	
	
	
	
}
