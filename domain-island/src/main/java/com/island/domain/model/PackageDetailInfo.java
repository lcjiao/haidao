package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class PackageDetailInfo extends AbsModel{

	public String get(){
		return "haidao_db.package_detail_info";
	}

	/**
	 * Ì×²Í±àºÅ
	 */
  	private Integer packageId;
  	/**
	 * 设置Ì×²Í±àºÅ
	 */
  	public void setPackageId(Integer packageId){
  		this.packageId=packageId;
  	}
  	/**
	 * 获取Ì×²Í±àºÅ
	 */
  	public Integer getPackageId(){
  		return this.packageId;
  	}
	/**
	 * Ì×²ÍÀà±ð  1:»éÀñÌ×²Í 2:»éÉ´ÉãÓ°Ì×²Í  3:»éÉ´ÉãÓ°ÉãÓ°Ê¦Ì×²Í 4:¾ÆµêÌ×²Í 5:×ÔÓÉÐÐÌ×²Í
	 */
  	private Integer packageType;
  	/**
	 * 设置Ì×²ÍÀà±ð  1:»éÀñÌ×²Í 2:»éÉ´ÉãÓ°Ì×²Í  3:»éÉ´ÉãÓ°ÉãÓ°Ê¦Ì×²Í 4:¾ÆµêÌ×²Í 5:×ÔÓÉÐÐÌ×²Í
	 */
  	public void setPackageType(Integer packageType){
  		this.packageType=packageType;
  	}
  	/**
	 * 获取Ì×²ÍÀà±ð  1:»éÀñÌ×²Í 2:»éÉ´ÉãÓ°Ì×²Í  3:»éÉ´ÉãÓ°ÉãÓ°Ê¦Ì×²Í 4:¾ÆµêÌ×²Í 5:×ÔÓÉÐÐÌ×²Í
	 */
  	public Integer getPackageType(){
  		return this.packageType;
  	}
  	/**
	 * Ì×²ÍÏêÏ¸½éÉÜ
	 */
  	private String content;
  	/**
	 * 设置Ì×²ÍÏêÏ¸½éÉÜ
	 */
  	public void setContent(String content){
  		this.content=content;
  	}
  	/**
	 * 获取Ì×²ÍÏêÏ¸½éÉÜ
	 */
  	public String getContent(){
  		return this.content;
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
