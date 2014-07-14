package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class IslandPackage extends AbsModel{

	public String get(){
		return "haidao_db.island_package";
	}

	/**
	 * 套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐
	 */
  	private Integer packageType;
  	/**
	 * 设置套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐
	 */
  	public void setPackageType(Integer packageType){
  		this.packageType=packageType;
  	}
  	/**
	 * 获取套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐  5:自由行套餐
	 */
  	public Integer getPackageType(){
  		return this.packageType;
  	}
  	/**
	 * 套餐标题
	 */
  	private String title;
  	/**
	 * 设置套餐标题
	 */
  	public void setTitle(String title){
  		this.title=title;
  	}
  	/**
	 * 获取套餐标题
	 */
  	public String getTitle(){
  		return this.title;
  	}
  	/**
	 * 套餐内容
	 */
  	private String content;
  	/**
	 * 设置套餐内容
	 */
  	public void setContent(String content){
  		this.content=content;
  	}
  	/**
	 * 获取套餐内容
	 */
  	public String getContent(){
  		return this.content;
  	}
  	/**
	 * 旺季价格
	 */
  	private String priceBig;
  	/**
	 * 设置旺季价格
	 */
  	public void setPriceBig(String priceBig){
  		this.priceBig=priceBig;
  	}
  	/**
	 * 获取旺季价格
	 */
  	public String getPriceBig(){
  		return this.priceBig;
  	}
  	/**
	 * 淡季价格
	 */
  	private String priceSmall;
  	/**
	 * 设置淡季价格
	 */
  	public void setPriceSmall(String priceSmall){
  		this.priceSmall=priceSmall;
  	}
  	/**
	 * 获取淡季价格
	 */
  	public String getPriceSmall(){
  		return this.priceSmall;
  	}
	/**
	 * 区域编号
	 */
  	private Integer areaId;
  	/**
	 * 设置区域编号
	 */
  	public void setAreaId(Integer areaId){
  		this.areaId=areaId;
  	}
  	/**
	 * 获取区域编号
	 */
  	public Integer getAreaId(){
  		return this.areaId;
  	}
  	/**
	 * 区域名称
	 */
  	private String areaName;
  	/**
	 * 设置区域名称
	 */
  	public void setAreaName(String areaName){
  		this.areaName=areaName;
  	}
  	/**
	 * 获取区域名称
	 */
  	public String getAreaName(){
  		return this.areaName;
  	}
	/**
	 * 岛屿编号
	 */
  	private Integer islandId;
  	/**
	 * 设置岛屿编号
	 */
  	public void setIslandId(Integer islandId){
  		this.islandId=islandId;
  	}
  	/**
	 * 获取岛屿编号
	 */
  	public Integer getIslandId(){
  		return this.islandId;
  	}
  	/**
	 * 岛屿名称
	 */
  	private String islandName;
  	/**
	 * 设置岛屿名称
	 */
  	public void setIslandName(String islandName){
  		this.islandName=islandName;
  	}
  	/**
	 * 获取岛屿名称
	 */
  	public String getIslandName(){
  		return this.islandName;
  	}
	/**
	 * 是否有效 1上架  2下架
	 */
  	private Integer isOnline;
  	/**
	 * 设置是否有效 1上架  2下架
	 */
  	public void setIsOnline(Integer isOnline){
  		this.isOnline=isOnline;
  	}
  	/**
	 * 获取是否有效 1上架  2下架
	 */
  	public Integer getIsOnline(){
  		return this.isOnline;
  	}
  	
  	public String getOnlineStr(){
  		if(this.isOnline != null && this.isOnline.intValue()==1){
  			return "在售";
  		}else{
  			return "非在售";
  		}
  	}
	/**
	 * 是否有效 1有效  0无效
	 */
  	private Integer valid;
  	/**
	 * 设置是否有效 1有效  0无效
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取是否有效 1有效  0无效
	 */
  	public Integer getValid(){
  		return this.valid;
  	}
	/**
	 * 创建时间
	 */
  	private Integer createTime;
  	/**
	 * 设置创建时间
	 */
  	public void setCreateTime(Integer createTime){
  		this.createTime=createTime;
  	}
  	/**
	 * 获取创建时间
	 */
  	public Integer getCreateTime(){
  		return this.createTime;
  	}
  	/**
	 * 创建人
	 */
  	private String createPerson;
  	/**
	 * 设置创建人
	 */
  	public void setCreatePerson(String createPerson){
  		this.createPerson=createPerson;
  	}
  	/**
	 * 获取创建人
	 */
  	public String getCreatePerson(){
  		return this.createPerson;
  	}
	/**
	 * 更新时间
	 */
  	private Integer updTime;
  	/**
	 * 设置更新时间
	 */
  	public void setUpdTime(Integer updTime){
  		this.updTime=updTime;
  	}
  	/**
	 * 获取更新时间
	 */
  	public Integer getUpdTime(){
  		return this.updTime;
  	}
  	/**
	 * 更新人
	 */
  	private String updPerson;
  	/**
	 * 设置更新人
	 */
  	public void setUpdPerson(String updPerson){
  		this.updPerson=updPerson;
  	}
  	/**
	 * 获取更新人
	 */
  	public String getUpdPerson(){
  		return this.updPerson;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
	
	private Integer isHot=0;
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	
	private String hotStr;
	public String getHotStr() {
		if(this.isHot.intValue() == 1){
			return "热推";
		}else{
			return "非热推";
		}
	}
	public void setHotStr(String hotStr) {
		this.hotStr = hotStr;
	}
	
	private Integer typeId;
	private String typeName;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	private String logoUrl="";
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	private String detailUrl="";
	public String getDetailUrl() {
		return detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	
	
}
