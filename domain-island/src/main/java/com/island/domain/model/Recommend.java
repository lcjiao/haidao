package com.island.domain.model;

import com.island.domain.util.IslandDateUtil;
import com.jcl.core.dal.AbsModel;

public class Recommend extends AbsModel implements Comparable{

	public String get(){
		return "haidao_db.recommend";
	}

	/**
	 * 模块编号 页面得每一个推荐位设定1个编号 前端展示时候根据编号获取推荐数据
	 */
  	private Integer moduleId;
  	/**
	 * 设置模块编号 页面得每一个推荐位设定1个编号 前端展示时候根据编号获取推荐数据
	 */
  	public void setModuleId(Integer moduleId){
  		this.moduleId=moduleId;
  	}
  	/**
	 * 获取模块编号 页面得每一个推荐位设定1个编号 前端展示时候根据编号获取推荐数据
	 */
  	public Integer getModuleId(){
  		return this.moduleId;
  	}
  	/**
	 * 模块描述 如 首页大图推荐 
	 */
  	private String moduleDesc;
  	/**
	 * 设置模块描述 如 首页大图推荐 
	 */
  	public void setModuleDesc(String moduleDesc){
  		this.moduleDesc=moduleDesc;
  	}
  	/**
	 * 获取模块描述 如 首页大图推荐 
	 */
  	public String getModuleDesc(){
  		return this.moduleDesc;
  	}
  	/**
	 * 主题
	 */
  	private String title;
  	/**
	 * 设置主题
	 */
  	public void setTitle(String title){
  		this.title=title;
  	}
  	/**
	 * 获取主题
	 */
  	public String getTitle(){
  		return this.title;
  	}
  	/**
	 * 内容
	 */
  	private String content;
  	/**
	 * 设置内容
	 */
  	public void setContent(String content){
  		this.content=content;
  	}
  	/**
	 * 获取内容
	 */
  	public String getContent(){
  		return this.content;
  	}
  	/**
	 * 备注
	 */
  	private String recommendDesc;
  	/**
	 * 设置备注
	 */
  	public void setRecommendDesc(String recommendDesc){
  		this.recommendDesc=recommendDesc;
  	}
  	/**
	 * 获取备注
	 */
  	public String getRecommendDesc(){
  		return this.recommendDesc;
  	}
  	/**
	 * 图片地址
	 */
  	private String imgUrl;
  	/**
	 * 设置图片地址
	 */
  	public void setImgUrl(String imgUrl){
  		this.imgUrl=imgUrl;
  	}
  	/**
	 * 获取图片地址
	 */
  	public String getImgUrl(){
  		return this.imgUrl;
  	}
  	/**
	 * 链接地址
	 */
  	private String linkUrl;
  	/**
	 * 设置链接地址
	 */
  	public void setLinkUrl(String linkUrl){
  		this.linkUrl=linkUrl;
  	}
  	/**
	 * 获取链接地址
	 */
  	public String getLinkUrl(){
  		return this.linkUrl;
  	}
  	/**
	 * 价格
	 */
  	private String price;
  	/**
	 * 设置价格
	 */
  	public void setPrice(String price){
  		this.price=price;
  	}
  	/**
	 * 获取价格
	 */
  	public String getPrice(){
  		return this.price;
  	}
  	/**
	 * 联系电话
	 */
  	private String tel;
  	/**
	 * 设置联系电话
	 */
  	public void setTel(String tel){
  		this.tel=tel;
  	}
  	/**
	 * 获取联系电话
	 */
  	public String getTel(){
  		return this.tel;
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
	 * 排序
	 */
  	private Integer recommendIndex;
  	/**
	 * 设置排序
	 */
  	public void setRecommendIndex(Integer recommendIndex){
  		this.recommendIndex=recommendIndex;
  	}
  	/**
	 * 获取排序
	 */
  	public Integer getRecommendIndex(){
  		return this.recommendIndex;
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
	 * 大图地址
	 */
  	private String bigImgUrl;
  	/**
	 * 设置大图地址
	 */
  	public void setBigImgUrl(String bigImgUrl){
  		this.bigImgUrl=bigImgUrl;
  	}
  	/**
	 * 获取大图地址
	 */
  	public String getBigImgUrl(){
  		return this.bigImgUrl;
  	}
  	/**
	 * 小图图地址
	 */
  	private String smallImgUrl;
  	/**
	 * 设置小图图地址
	 */
  	public void setSmallImgUrl(String smallImgUrl){
  		this.smallImgUrl=smallImgUrl;
  	}
  	/**
	 * 获取小图图地址
	 */
  	public String getSmallImgUrl(){
  		return this.smallImgUrl;
  	}
  	/**
	 * 链接地址预留
	 */
  	private String linkObligate;
  	/**
	 * 设置链接地址预留
	 */
  	public void setLinkObligate(String linkObligate){
  		this.linkObligate=linkObligate;
  	}
  	/**
	 * 获取链接地址预留
	 */
  	public String getLinkObligate(){
  		return this.linkObligate;
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
	 * 推荐类型
	 */
  	private Integer typeId;
  	/**
	 * 设置推荐类型
	 */
  	public void setTypeId(Integer typeId){
  		this.typeId=typeId;
  	}
  	/**
	 * 获取推荐类型
	 */
  	public Integer getTypeId(){
  		return this.typeId;
  	}
  	/**
	 * 推荐类型名称
	 */
  	private String typeName;
  	/**
	 * 设置推荐类型名称
	 */
  	public void setTypeName(String typeName){
  		this.typeName=typeName;
  	}
  	/**
	 * 获取推荐类型名称
	 */
  	public String getTypeName(){
  		return this.typeName;
  	}
  	/**
	 * 视频地址
	 */
  	private String viewLink;
  	/**
	 * 设置视频地址
	 */
  	public void setViewLink(String viewLink){
  		this.viewLink=viewLink;
  	}
  	/**
	 * 获取视频地址
	 */
  	public String getViewLink(){
  		return this.viewLink;
  	}
  	/**
	 * 推荐时间
	 */
  	private String recommendTime;
  	/**
	 * 设置推荐时间
	 */
  	public void setRecommendTime(String recommendTime){
  		this.recommendTime=recommendTime;
  	}
  	/**
	 * 获取推荐时间
	 */
  	public String getRecommendTime(){
  		return this.recommendTime;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
	@Override
	public int compareTo(Object arg) {
		Recommend obj = (Recommend)arg;
		if(this.recommendIndex ==null || obj.getRecommendIndex() == null){
			return 0;
		}
		if( this.recommendIndex > obj.getRecommendIndex()){
			return 1;
		}
		if( this.recommendIndex < obj.getRecommendIndex()){
			return -1;
		}
		return 0;
	}
	
	private String recommendTimeStr;
	public String getRecommendTimeStr() {
		
		if( this.recommendTime!= null){
			if( this.recommendTime.startsWith("1") ){
				return IslandDateUtil.getDateStrByUnixTime(Integer.parseInt(this.recommendTime), "yyyy-MM-dd");
			}
		}
		return recommendTime;
	}
	public void setRecommendTimeStr(String recommendTimeStr) {
		this.recommendTimeStr = recommendTimeStr;
	}
	
}
