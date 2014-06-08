package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class CaseVideoMapping extends AbsModel{

	public String get(){
		return "haidao_db.case_video_mapping";
	}

	/**
	 * 案例id
	 */
  	private Integer caseid;
  	/**
	 * 设置案例id
	 */
  	public void setCaseid(Integer caseid){
  		this.caseid=caseid;
  	}
  	/**
	 * 获取案例id
	 */
  	public Integer getCaseid(){
  		return this.caseid;
  	}
  	/**
	 * 视频Logo图片Url
	 */
  	private String logourl;
  	/**
	 * 设置视频Logo图片Url
	 */
  	public void setLogourl(String logourl){
  		this.logourl=logourl;
  	}
  	/**
	 * 获取视频Logo图片Url
	 */
  	public String getLogourl(){
  		return this.logourl;
  	}
  	/**
	 * 视频描述
	 */
  	private String videodesc;
  	/**
	 * 设置视频描述
	 */
  	public void setVideodesc(String videodesc){
  		this.videodesc=videodesc;
  	}
  	/**
	 * 获取视频描述
	 */
  	public String getVideodesc(){
  		return this.videodesc;
  	}
  	/**
	 * 视频url
	 */
  	private String videourl;
  	/**
	 * 设置视频url
	 */
  	public void setVideourl(String videourl){
  		this.videourl=videourl;
  	}
  	/**
	 * 获取视频url
	 */
  	public String getVideourl(){
  		return this.videourl;
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
}
