package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class Workman extends AbsModel{

	public String get(){
		return "haidao_db.workman";
	}

	/**
	 * 工种类型 1摄影师 2化妆师 3影片师
	 */
  	private Integer workType;
  	/**
	 * 设置工种类型 1摄影师 2化妆师 3影片师
	 */
  	public void setWorkType(Integer workType){
  		this.workType=workType;
  	}
  	/**
	 * 获取工种类型 1摄影师 2化妆师 3影片师
	 */
  	public Integer getWorkType(){
  		return this.workType;
  	}
  	/**
	 * 名称
	 */
  	private String name;
  	/**
	 * 设置名称
	 */
  	public void setName(String name){
  		this.name=name;
  	}
  	/**
	 * 获取名称
	 */
  	public String getName(){
  		return this.name;
  	}
  	/**
	 * 个人简介
	 */
  	private String content;
  	/**
	 * 设置个人简介
	 */
  	public void setContent(String content){
  		this.content=content;
  	}
  	/**
	 * 获取个人简介
	 */
  	public String getContent(){
  		return this.content;
  	}
  	/**
	 * 负责人
	 */
  	private String principal;
  	/**
	 * 设置负责人
	 */
  	public void setPrincipal(String principal){
  		this.principal=principal;
  	}
  	/**
	 * 获取负责人
	 */
  	public String getPrincipal(){
  		return this.principal;
  	}
  	/**
	 * 头像
	 */
  	private String img;
  	/**
	 * 设置头像
	 */
  	public void setImg(String img){
  		this.img=img;
  	}
  	/**
	 * 获取头像
	 */
  	public String getImg(){
  		return this.img;
  	}
  	/**
	 * 电话
	 */
  	private String tel;
  	/**
	 * 设置电话
	 */
  	public void setTel(String tel){
  		this.tel=tel;
  	}
  	/**
	 * 获取电话
	 */
  	public String getTel(){
  		return this.tel;
  	}
  	/**
	 * 等级
	 */
  	private String level;
  	/**
	 * 设置等级
	 */
  	public void setLevel(String level){
  		this.level=level;
  	}
  	/**
	 * 获取等级
	 */
  	public String getLevel(){
  		return this.level;
  	}
	/**
	 * 所属团队
	 */
  	private Integer teamId;
  	/**
	 * 设置所属团队
	 */
  	public void setTeamId(Integer teamId){
  		this.teamId=teamId;
  	}
  	/**
	 * 获取所属团队
	 */
  	public Integer getTeamId(){
  		return this.teamId;
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
	 * 团队名称
	 */
  	private String teamName;
  	/**
	 * 设置团队名称
	 */
  	public void setTeamName(String teamName){
  		this.teamName=teamName;
  	}
  	/**
	 * 获取团队名称
	 */
  	public String getTeamName(){
  		return this.teamName;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
	
	private String workTypeStr;
	public String getWorkTypeStr() {
		if(this.workType == 1){
			return "摄影团队";
		}else if(this.workType == 2){
			return "摄影师";
		}else if(this.workType == 3){
			return "化妆师";
		}else{
			return "影片师";
		}
	}
	public void setWorkTypeStr(String workTypeStr) {
		this.workTypeStr = workTypeStr;
	}
	
}
