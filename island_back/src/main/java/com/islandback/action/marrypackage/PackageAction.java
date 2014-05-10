package com.islandback.action.marrypackage;




import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.model.IslandPackage;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/marrypackage/package")
@ResultPath("/WEB-INF")
/**
 *婚礼套餐
 *
 */
public class PackageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=5;
	private List<IslandPackage> packageList = new ArrayList<IslandPackage>(0);
	
	public String list(){
		for(int i=1;i<10;i++){
			IslandPackage p = new IslandPackage();
			p.setAreaName("区域"+i);
			p.setIslandName("岛屿"+i);
			p.setTitle("title"+i);
			p.setPriceBig(1000+"");
			p.setPriceSmall(2000+"");
			p.setId(i);
			packageList.add(p);
			this.totalSize=10;
			initTotalPageSize();
		}
		return "list";
	}
	
	public String toAdd(){
		return "add";
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
	
	
	
}
