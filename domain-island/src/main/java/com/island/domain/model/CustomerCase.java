package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class CustomerCase extends AbsModel{

	public String get(){
		return "haidao_db.customer_case";
	}

	/**
	 * 案例类型 1、视频 2、客片
	 */
  	private Integer casetype;
  	/**
	 * 设置案例类型 1、视频 2、客片
	 */
  	public void setCasetype(Integer casetype){
  		this.casetype=casetype;
  	}
  	/**
	 * 获取案例类型 1、视频 2、客片
	 */
  	public Integer getCasetype(){
  		return this.casetype;
  	}
  	/**
	 * 案例名称
	 */
  	private String casename;
  	/**
	 * 设置案例名称
	 */
  	public void setCasename(String casename){
  		this.casename=casename;
  	}
  	/**
	 * 获取案例名称
	 */
  	public String getCasename(){
  		return this.casename;
  	}
  	/**
	 * 新人名称
	 */
  	private String newperson;
  	/**
	 * 设置新人名称
	 */
  	public void setNewperson(String newperson){
  		this.newperson=newperson;
  	}
  	/**
	 * 获取新人名称
	 */
  	public String getNewperson(){
  		return this.newperson;
  	}
	/**
	 * 拍摄时间
	 */
  	private Integer phototime;
  	/**
	 * 设置拍摄时间
	 */
  	public void setPhototime(Integer phototime){
  		this.phototime=phototime;
  	}
  	/**
	 * 获取拍摄时间
	 */
  	public Integer getPhototime(){
  		return this.phototime;
  	}
  	/**
	 * 套餐项目1名称
	 */
  	private String pkgpjtname1;
  	/**
	 * 设置套餐项目1名称
	 */
  	public void setPkgpjtname1(String pkgpjtname1){
  		this.pkgpjtname1=pkgpjtname1;
  	}
  	/**
	 * 获取套餐项目1名称
	 */
  	public String getPkgpjtname1(){
  		return this.pkgpjtname1;
  	}
  	/**
	 * 套餐项目1url
	 */
  	private String pkgpjturl1;
  	/**
	 * 设置套餐项目1url
	 */
  	public void setPkgpjturl1(String pkgpjturl1){
  		this.pkgpjturl1=pkgpjturl1;
  	}
  	/**
	 * 获取套餐项目1url
	 */
  	public String getPkgpjturl1(){
  		return this.pkgpjturl1;
  	}
  	/**
	 * 套餐项目2名称
	 */
  	private String pkgpjtname2;
  	/**
	 * 设置套餐项目2名称
	 */
  	public void setPkgpjtname2(String pkgpjtname2){
  		this.pkgpjtname2=pkgpjtname2;
  	}
  	/**
	 * 获取套餐项目2名称
	 */
  	public String getPkgpjtname2(){
  		return this.pkgpjtname2;
  	}
  	/**
	 * 套餐项目2url
	 */
  	private String pkgpjturl2;
  	/**
	 * 设置套餐项目2url
	 */
  	public void setPkgpjturl2(String pkgpjturl2){
  		this.pkgpjturl2=pkgpjturl2;
  	}
  	/**
	 * 获取套餐项目2url
	 */
  	public String getPkgpjturl2(){
  		return this.pkgpjturl2;
  	}
  	/**
	 * 套餐项目3名称
	 */
  	private String pkgpjtname3;
  	/**
	 * 设置套餐项目3名称
	 */
  	public void setPkgpjtname3(String pkgpjtname3){
  		this.pkgpjtname3=pkgpjtname3;
  	}
  	/**
	 * 获取套餐项目3名称
	 */
  	public String getPkgpjtname3(){
  		return this.pkgpjtname3;
  	}
  	/**
	 * 套餐项目3url
	 */
  	private String pkgpjturl3;
  	/**
	 * 设置套餐项目3url
	 */
  	public void setPkgpjturl3(String pkgpjturl3){
  		this.pkgpjturl3=pkgpjturl3;
  	}
  	/**
	 * 获取套餐项目3url
	 */
  	public String getPkgpjturl3(){
  		return this.pkgpjturl3;
  	}
  	/**
	 * 子类型名称
	 */
  	private String childname;
  	/**
	 * 设置子类型名称
	 */
  	public void setChildname(String childname){
  		this.childname=childname;
  	}
  	/**
	 * 获取子类型名称
	 */
  	public String getChildname(){
  		return this.childname;
  	}
	/**
	 * 子类型id
	 */
  	private Integer childid;
  	/**
	 * 设置子类型id
	 */
  	public void setChildid(Integer childid){
  		this.childid=childid;
  	}
  	/**
	 * 获取子类型id
	 */
  	public Integer getChildid(){
  		return this.childid;
  	}
  	/**
	 * 摄影师
	 */
  	private String photoworker;
  	/**
	 * 设置摄影师
	 */
  	public void setPhotoworker(String photoworker){
  		this.photoworker=photoworker;
  	}
  	/**
	 * 获取摄影师
	 */
  	public String getPhotoworker(){
  		return this.photoworker;
  	}
  	/**
	 * 化妆师
	 */
  	private String dresser;
  	/**
	 * 设置化妆师
	 */
  	public void setDresser(String dresser){
  		this.dresser=dresser;
  	}
  	/**
	 * 获取化妆师
	 */
  	public String getDresser(){
  		return this.dresser;
  	}
	/**
	 * 岛屿id
	 */
  	private Integer islandid;
  	/**
	 * 设置岛屿id
	 */
  	public void setIslandid(Integer islandid){
  		this.islandid=islandid;
  	}
  	/**
	 * 获取岛屿id
	 */
  	public Integer getIslandid(){
  		return this.islandid;
  	}
  	/**
	 * 岛屿名称
	 */
  	private String islandname;
  	/**
	 * 设置岛屿名称
	 */
  	public void setIslandname(String islandname){
  		this.islandname=islandname;
  	}
  	/**
	 * 获取岛屿名称
	 */
  	public String getIslandname(){
  		return this.islandname;
  	}
	/**
	 * 区域id
	 */
  	private Integer areaid;
  	/**
	 * 设置区域id
	 */
  	public void setAreaid(Integer areaid){
  		this.areaid=areaid;
  	}
  	/**
	 * 获取区域id
	 */
  	public Integer getAreaid(){
  		return this.areaid;
  	}
  	/**
	 * 区域名称
	 */
  	private String areaname;
  	/**
	 * 设置区域名称
	 */
  	public void setAreaname(String areaname){
  		this.areaname=areaname;
  	}
  	/**
	 * 获取区域名称
	 */
  	public String getAreaname(){
  		return this.areaname;
  	}
	/**
	 * 是否有效,1:有效,0:无效
	 */
  	private Integer valid;
  	/**
	 * 设置是否有效,1:有效,0:无效
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取是否有效,1:有效,0:无效
	 */
  	public Integer getValid(){
  		return this.valid;
  	}
	/**
	 * 创建时间
	 */
  	private Integer createtime;
  	/**
	 * 设置创建时间
	 */
  	public void setCreatetime(Integer createtime){
  		this.createtime=createtime;
  	}
  	/**
	 * 获取创建时间
	 */
  	public Integer getCreatetime(){
  		return this.createtime;
  	}
  	/**
	 * 创建人
	 */
  	private String createperson;
  	/**
	 * 设置创建人
	 */
  	public void setCreateperson(String createperson){
  		this.createperson=createperson;
  	}
  	/**
	 * 获取创建人
	 */
  	public String getCreateperson(){
  		return this.createperson;
  	}
	/**
	 * 更新时间
	 */
  	private Integer updtime;
  	/**
	 * 设置更新时间
	 */
  	public void setUpdtime(Integer updtime){
  		this.updtime=updtime;
  	}
  	/**
	 * 获取更新时间
	 */
  	public Integer getUpdtime(){
  		return this.updtime;
  	}
  	/**
	 * 更新人
	 */
  	private String updperson;
  	/**
	 * 设置更新人
	 */
  	public void setUpdperson(String updperson){
  		this.updperson=updperson;
  	}
  	/**
	 * 获取更新人
	 */
  	public String getUpdperson(){
  		return this.updperson;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
	
	private String caseTypeStr;
	public String getCaseTypeStr() {
		if(this.casetype == 130){
			return "摄影案例";
		}else{
			return "视频案例";
		}
	}
	public void setCaseTypeStr(String caseTypeStr) {
		this.caseTypeStr = caseTypeStr;
	}
	
	private String strPhotoTime;
	public String getStrPhotoTime() {
		return strPhotoTime;
	}
	public void setStrPhotoTime(String strPhotoTime) {
		this.strPhotoTime = strPhotoTime;
	}
	
}
