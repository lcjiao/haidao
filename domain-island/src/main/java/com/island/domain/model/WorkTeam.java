package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class WorkTeam extends AbsModel{

	public String get(){
		return "haidao_db.work_team";
	}

  	/**
	 * Ãû³Æ
	 */
  	private String name;
  	/**
	 * 设置Ãû³Æ
	 */
  	public void setName(String name){
  		this.name=name;
  	}
  	/**
	 * 获取Ãû³Æ
	 */
  	public String getName(){
  		return this.name;
  	}
  	/**
	 * ¼ò½é
	 */
  	private String content;
  	/**
	 * 设置¼ò½é
	 */
  	public void setContent(String content){
  		this.content=content;
  	}
  	/**
	 * 获取¼ò½é
	 */
  	public String getContent(){
  		return this.content;
  	}
  	/**
	 * ÍÅ¶Ó¹¹½¨
	 */
  	private String teamPerson;
  	/**
	 * 设置ÍÅ¶Ó¹¹½¨
	 */
  	public void setTeamPerson(String teamPerson){
  		this.teamPerson=teamPerson;
  	}
  	/**
	 * 获取ÍÅ¶Ó¹¹½¨
	 */
  	public String getTeamPerson(){
  		return this.teamPerson;
  	}
  	/**
	 * log
	 */
  	private String img;
  	/**
	 * 设置log
	 */
  	public void setImg(String img){
  		this.img=img;
  	}
  	/**
	 * 获取log
	 */
  	public String getImg(){
  		return this.img;
  	}
  	/**
	 * µç»°
	 */
  	private String tel;
  	/**
	 * 设置µç»°
	 */
  	public void setTel(String tel){
  		this.tel=tel;
  	}
  	/**
	 * 获取µç»°
	 */
  	public String getTel(){
  		return this.tel;
  	}
  	/**
	 * µÈ¼¶
	 */
  	private String level;
  	/**
	 * 设置µÈ¼¶
	 */
  	public void setLevel(String level){
  		this.level=level;
  	}
  	/**
	 * 获取µÈ¼¶
	 */
  	public String getLevel(){
  		return this.level;
  	}
  	/**
	 * µ­¼¾¼Û¸ñ
	 */
  	private String priceSmall;
  	/**
	 * 设置µ­¼¾¼Û¸ñ
	 */
  	public void setPriceSmall(String priceSmall){
  		this.priceSmall=priceSmall;
  	}
  	/**
	 * 获取µ­¼¾¼Û¸ñ
	 */
  	public String getPriceSmall(){
  		return this.priceSmall;
  	}
  	/**
	 * Íú¼¾¼Û¸ñ
	 */
  	private String priceBig;
  	/**
	 * 设置Íú¼¾¼Û¸ñ
	 */
  	public void setPriceBig(String priceBig){
  		this.priceBig=priceBig;
  	}
  	/**
	 * 获取Íú¼¾¼Û¸ñ
	 */
  	public String getPriceBig(){
  		return this.priceBig;
  	}
	/**
	 * ÊÇ·ñÓÐÐ§ 1ÓÐÐ§  0ÎÞÐ§
	 */
  	private Integer valid;
  	/**
	 * 设置ÊÇ·ñÓÐÐ§ 1ÓÐÐ§  0ÎÞÐ§
	 */
  	public void setValid(Integer valid){
  		this.valid=valid;
  	}
  	/**
	 * 获取ÊÇ·ñÓÐÐ§ 1ÓÐÐ§  0ÎÞÐ§
	 */
  	public Integer getValid(){
  		return this.valid;
  	}
	/**
	 * ´´½¨Ê±¼ä
	 */
  	private Integer createTime;
  	/**
	 * 设置´´½¨Ê±¼ä
	 */
  	public void setCreateTime(Integer createTime){
  		this.createTime=createTime;
  	}
  	/**
	 * 获取´´½¨Ê±¼ä
	 */
  	public Integer getCreateTime(){
  		return this.createTime;
  	}
  	/**
	 * ´´½¨ÈË
	 */
  	private String createPerson;
  	/**
	 * 设置´´½¨ÈË
	 */
  	public void setCreatePerson(String createPerson){
  		this.createPerson=createPerson;
  	}
  	/**
	 * 获取´´½¨ÈË
	 */
  	public String getCreatePerson(){
  		return this.createPerson;
  	}
	/**
	 * ¸üÐÂÊ±¼ä
	 */
  	private Integer updTime;
  	/**
	 * 设置¸üÐÂÊ±¼ä
	 */
  	public void setUpdTime(Integer updTime){
  		this.updTime=updTime;
  	}
  	/**
	 * 获取¸üÐÂÊ±¼ä
	 */
  	public Integer getUpdTime(){
  		return this.updTime;
  	}
  	/**
	 * ¸üÐÂÈË
	 */
  	private String updPerson;
  	/**
	 * 设置¸üÐÂÈË
	 */
  	public void setUpdPerson(String updPerson){
  		this.updPerson=updPerson;
  	}
  	/**
	 * 获取¸üÐÂÈË
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
}
