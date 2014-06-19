package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class GlobalQa extends AbsModel{

	public String get(){
		return "haidao_db.global_qa";
	}

	/**
	 * 问题种类
	 */
  	private Integer questionType;
  	/**
	 * 设置问题种类
	 */
  	public void setQuestionType(Integer questionType){
  		this.questionType=questionType;
  	}
  	/**
	 * 获取问题种类
	 */
  	public Integer getQuestionType(){
  		return this.questionType;
  	}
  	/**
	 * 问题标题
	 */
  	private String title;
  	/**
	 * 设置问题标题
	 */
  	public void setTitle(String title){
  		this.title=title;
  	}
  	/**
	 * 获取问题标题
	 */
  	public String getTitle(){
  		return this.title;
  	}
  	/**
	 * 回答
	 */
  	private String answer;
  	/**
	 * 设置回答
	 */
  	public void setAnswer(String answer){
  		this.answer=answer;
  	}
  	/**
	 * 获取回答
	 */
  	public String getAnswer(){
  		return this.answer;
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
	
	private String questionTypeName;
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	
}
