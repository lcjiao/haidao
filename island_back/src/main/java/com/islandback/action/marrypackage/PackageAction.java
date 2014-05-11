package com.islandback.action.marrypackage;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.AreaIslandBiz;
import com.island.domain.biz.MarrayPackageBiz;
import com.island.domain.model.Island;
import com.island.domain.model.IslandPackage;
import com.islandback.module.Page;
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
	private Integer islandId;
	private String title;
	private Integer price;
	private List<IslandPackage> packageList = new ArrayList<IslandPackage>(0);
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
		return "addbase";
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
		if(title != null){
			params.put("titleSear", "%"+title+"%");
		}
		if(price != null){
			params.put("price", price);
		}
		if(islandId != null ){
			params.put("islandId", islandId);
		}
		List<IslandPackage> list = packageBiz.queryPackageByMap(params);
		if(list != null && list.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			if(title != null){
				countParam.put("title", title);
			}
			if(price != null){
				countParam.put("price", price);
			}
			if(islandId != null ){
				countParam.put("islandId", islandId);
			}
			this.totalSize = packageBiz.countPackageByMap(countParam);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		this.packageList = list;
		
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
	public String getTitle() {
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
	
	
	
}
