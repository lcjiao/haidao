package com.islandback.action.guestqa;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.GuestQaBiz;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;
import com.island.domain.model.PackageQa;
import com.islandback.action.base.BaseAction;
import com.islandback.module.Page;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.islandback.web.util.Struts2Utils;


//@SuppressWarnings("serial")
@Namespace("/guestqa")
@ResultPath("/WEB-INF")
/**
 * http://blog.csdn.net/redarmy_chen/article/details/7342247
 * @author lcjiao
 *
 */
public class GuestqaAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer pageNo;
	private Integer totalPageSize;
	private Integer totalSize;
	private Integer pageSize=10;
	private String answer;
	private String question;
	
	private Integer packageType;
	private Integer packageId;
	private Integer isAnswer;
	
	private List<PackageQa> qaList = new ArrayList<PackageQa>(0);
	
	GuestQaBiz guestqaBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGuestQaBiz();
	
	public String toAddAnswer(){
		PackageQa obj = this.guestqaBiz.queryGuestQaById(id);
		if(obj != null ){
			this.question=obj.getQuestion();
		}
		return "add";
	}
	
	public String toEditAnswer(){
		PackageQa obj = this.guestqaBiz.queryGuestQaById(id);
		if(obj != null ){
			this.question=obj.getQuestion();
			this.answer=obj.getAnswer();
		}
		return "edit";
	}
	
	public String toSeeAnswer(){
		PackageQa obj = this.guestqaBiz.queryGuestQaById(id);
		if(obj != null ){
			this.question=obj.getQuestion();
			this.answer=obj.getAnswer();
		}
		return "see";
	}
	
	public String tolist(){
		if(pageNo == null || pageNo < 1){
			pageNo = 1;
		}
		if( pageSize == null || pageSize < 1){
			pageSize = 10;
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		params.put("begin", page.getBegin());
		params.put("size", page.getPageSize());
		if( packageType != null && packageType.intValue() > 0 ){
			params.put("packageType", packageType);
		}
		if( packageId != null && packageId.intValue() > 0 ){
			params.put("packageId", packageId);
		}
		if( isAnswer != null && isAnswer.intValue() > -1){
			params.put("isAnswer", isAnswer);
		}
		qaList = guestqaBiz.queryGuestQaByMap(params);
		if(qaList != null && qaList.size()>0){
			Map<String,Object> countParam = new HashMap<String,Object>(0);
			countParam.put("valid", 1);
			if( packageType != null && packageType.intValue() > 0 ){
				countParam.put("packageType", packageType);
			}
			if( packageId != null && packageId.intValue() > 0 ){
				countParam.put("packageId", packageId);
			}
			if( isAnswer != null && isAnswer.intValue() > -1){
				countParam.put("isAnswer", isAnswer);
			}
			this.totalSize = guestqaBiz.countGuestQaByMap(params);
		}else{
			this.totalSize=0;
		}
		initTotalPageSize();
		
		return "list";
	}
	
	private void initTotalPageSize(){
		if(totalSize % pageSize == 0 ){
			this.totalPageSize = totalSize / pageSize;
		}else{
			this.totalPageSize = ( totalSize / pageSize )+ 1;
		}
		
	}
	
	public String del(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 0);
		params.put("id", id);
		this.guestqaBiz.updGuestQaByMap(params);
		tolist();
		return "list";
	}
	
	public String processAnswer(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		int now = (int)(System.currentTimeMillis()/1000);
		
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("answer", answer);
		params.put("id", id);
		params.put("answerPerson", creater);
		params.put("answerTime", now);
		params.put("isAnswer", 1);
		this.guestqaBiz.updGuestQaByMap(params);
		tolist();
		return "list";
	}

	
	public void getUnAnswerNum(){
		Integer num = guestqaBiz.getUnAnswerNum();
		Struts2Utils.renderText(num+"");
	}
	
	
	public List<PackageQa> getQaList() {
		return qaList;
	}

	public void setQaList(List<PackageQa> qaList) {
		this.qaList = qaList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getPackageType() {
		return packageType;
	}

	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(Integer isAnswer) {
		this.isAnswer = isAnswer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
	
}
