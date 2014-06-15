package com.island.domain.model;

import com.jcl.core.dal.AbsModel;

public class PackageQa extends AbsModel{

	public String get(){
		return "haidao_db.package_qa";
	}

	/**
	 * 套餐编号
	 */
  	private Integer packageId;
  	/**
	 * 设置套餐编号
	 */
  	public void setPackageId(Integer packageId){
  		this.packageId=packageId;
  	}
  	/**
	 * 获取套餐编号
	 */
  	public Integer getPackageId(){
  		return this.packageId;
  	}
	/**
	 * 套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	 */
  	private Integer packageType;
  	/**
	 * 设置套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	 */
  	public void setPackageType(Integer packageType){
  		this.packageType=packageType;
  	}
  	/**
	 * 获取套餐类别  1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	 */
  	public Integer getPackageType(){
  		return this.packageType;
  	}
  	/**
	 * 咨询内容
	 */
  	private String question;
  	/**
	 * 设置咨询内容
	 */
  	public void setQuestion(String question){
  		this.question=question;
  	}
  	/**
	 * 获取咨询内容
	 */
  	public String getQuestion(){
  		return this.question;
  	}
  	/**
	 * 答复内容
	 */
  	private String answer;
  	/**
	 * 设置答复内容
	 */
  	public void setAnswer(String answer){
  		this.answer=answer;
  	}
  	/**
	 * 获取答复内容
	 */
  	public String getAnswer(){
  		return this.answer;
  	}
	/**
	 * 1:游客提问  2:客服提问
	 */
  	private Integer isGuest;
  	/**
	 * 设置1:游客提问  2:客服提问
	 */
  	public void setIsGuest(Integer isGuest){
  		this.isGuest=isGuest;
  	}
  	/**
	 * 获取1:游客提问  2:客服提问
	 */
  	public Integer getIsGuest(){
  		return this.isGuest;
  	}
	/**
	 * 是否回复 1回复 0没回复
	 */
  	private Integer isAnswer;
  	/**
	 * 设置是否回复 1回复 0没回复
	 */
  	public void setIsAnswer(Integer isAnswer){
  		this.isAnswer=isAnswer;
  	}
  	/**
	 * 获取是否回复 1回复 0没回复
	 */
  	public Integer getIsAnswer(){
  		return this.isAnswer;
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
	 * 提问时间
	 */
  	private Integer askTime;
  	/**
	 * 设置提问时间
	 */
  	public void setAskTime(Integer askTime){
  		this.askTime=askTime;
  	}
  	/**
	 * 获取提问时间
	 */
  	public Integer getAskTime(){
  		return this.askTime;
  	}
  	/**
	 * 咨询人
	 */
  	private String asker;
  	/**
	 * 设置咨询人
	 */
  	public void setAsker(String asker){
  		this.asker=asker;
  	}
  	/**
	 * 获取咨询人
	 */
  	public String getAsker(){
  		return this.asker;
  	}
	/**
	 * 答复时间
	 */
  	private Integer answerTime;
  	/**
	 * 设置答复时间
	 */
  	public void setAnswerTime(Integer answerTime){
  		this.answerTime=answerTime;
  	}
  	/**
	 * 获取答复时间
	 */
  	public Integer getAnswerTime(){
  		return this.answerTime;
  	}
  	/**
	 * 答复人
	 */
  	private String answerPerson;
  	/**
	 * 设置答复人
	 */
  	public void setAnswerPerson(String answerPerson){
  		this.answerPerson=answerPerson;
  	}
  	/**
	 * 获取答复人
	 */
  	public String getAnswerPerson(){
  		return this.answerPerson;
  	}
	/**
	 * 问题ID 如果为回复则有值 如果是问题则为0
	 */
  	private Integer questionId;
  	/**
	 * 设置问题ID 如果为回复则有值 如果是问题则为0
	 */
  	public void setQuestionId(Integer questionId){
  		this.questionId=questionId;
  	}
  	/**
	 * 获取问题ID 如果为回复则有值 如果是问题则为0
	 */
  	public Integer getQuestionId(){
  		return this.questionId;
  	}
	/**
	 * 1:表示问题  2:表示回复
	 */
  	private Integer questionType;
  	/**
	 * 设置1:表示问题  2:表示回复
	 */
  	public void setQuestionType(Integer questionType){
  		this.questionType=questionType;
  	}
  	/**
	 * 获取1:表示问题  2:表示回复
	 */
  	public Integer getQuestionType(){
  		return this.questionType;
  	}
	/**
	 * 保存时非空数据项校验；
	 */
	public boolean validate(){
		boolean passed = true;
		return true;
	}
	// 1:婚礼套餐 2:婚纱摄影套餐  3:婚纱摄影摄影师套餐 4:酒店套餐 5:自由行套餐
	private String packageTypeStr;
	public String getPackageTypeStr() {
		if( packageType != null ){
			if(packageType.intValue() ==1 ){
				return "婚礼套餐";
			}
			if(packageType.intValue() ==2 ){
				return "婚纱摄影套餐";
			}
			if(packageType.intValue() ==3 ){
				return "婚纱摄影摄影师套餐";
			}
			if(packageType.intValue() ==4 ){
				return "酒店套餐";
			}
			if(packageType.intValue() ==5 ){
				return "自由行套餐";
			}
			return "";
		}else{
			return "";
		}
	}
	public void setPackageTypeStr(String packageTypeStr) {
		this.packageTypeStr = packageTypeStr;
	}
	
	private String hasAnswer;
	public String getHasAnswer() {
		if(isAnswer != null){
			if(isAnswer.intValue() == 0 ){
				return "无回复";
			}
			if(isAnswer.intValue() == 1 ){
				return "已回复";
			}
		}else{
			return "无回复";
		}
		return "无回复";
	}
	public void setHasAnswer(String hasAnswer) {
		this.hasAnswer = hasAnswer;
	}
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
