package com.islandback.action.globalnet;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.GlobalNetBiz;
import com.island.domain.model.Company;
import com.island.domain.model.Recommend;
import com.islandback.module.ModuleEnum;
import com.islandback.module.SessionInfo;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/globalnet/company")
@ResultPath("/WEB-INF")
/**
 * http://blog.csdn.net/redarmy_chen/article/details/7342247
 * @author lcjiao
 *
 */
public class CompanyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;//公司名称
	private String intro;//公司简介
	private String tel;//联系电话 手机
	private String phone;//联系电话 座机
	private String person;//联系人
	private String address;//公司地址
	private String qq;
	private String mail;
	private File image;//公司logo
	private String imageFileName;
	//private String imageServPath=ModuleEnum.IMAGE_SAVE_PATH;
	//private String imageServPrefix=ModuleEnum.IMAGE_SERV_PREFIX;
	
	private List<Recommend> recommendList;
	private List<Company> companyList;
	private Company company;
	
	GlobalNetBiz globalNetBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGlobalNetBiz();
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	
	/**
	 * 进入公司管理首页
	 * @return
	 */
	public String toCompanyInfo(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		params.put("valid", 1);
		companyList  =  this.globalNetBiz.queryCompanyByMap(params);
		if( companyList != null && !companyList.isEmpty() ){
			this.company = companyList.get(0);
		}
		return "info";
	}
	
	public String manager(){
		if( this.id == null || this.id.intValue() < 1){
			addCompany();
		}
		if( this.id != null && this.id.intValue() > 0 ){
			updCompanyInfo();
		}
		return "info";
	}
	
	/**
	 * 创建公司信息
	 * @return
	 */
	public String addCompany(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Company addObj = new Company();
		if( this.name != null ){
			addObj.setName(name);
		}
		if( this.intro != null ){
			addObj.setIntroduction(intro);
		}
		if( this.image != null ){
			addObj.setLogo(upload());
		}
		if( this.address != null ){
			addObj.setAddress(address);
		}
		if(this.person != null){
			addObj.setPerson(person);
		}
		if( this.tel != null ){
			addObj.setTel(tel);
		}
		if( this.phone != null ){
			addObj.setPhone(phone);
		}
		if( this.mail != null ){
			addObj.setMail(mail);
		}
		if( this.qq != null ){
			addObj.setQq(qq);
		}
		addObj.setCreatePerson(creater);
		int now = (int)(System.currentTimeMillis()/1000);
		addObj.setCreateTime(now);
		addObj.setValid(1);
		this.globalNetBiz.addCompanyInfo(addObj);
		toCompanyInfo();
		return "info";
	}
	
	
	/**
	 * 更新公司信息
	 * @return
	 */
	public String updCompanyInfo(){
		String creater = "";
		SessionInfo sessionInfo = RequestProcc.getSessionInfo();
		if(sessionInfo != null ){
			creater = sessionInfo.getUser().getUserName(); 
		}
		Map<String,Object> params = new HashMap<String,Object>(0);
		if( this.name != null ){
			params.put("name", name);
		}
		if( this.intro != null ){
			params.put("introduction", intro);
		}
		if( this.image != null ){
			params.put("logo", upload());
		}
		if( this.address != null ){
			params.put("address", address);
		}
		if(this.person != null){
			params.put("person", person);
		}
		if( this.tel != null ){
			params.put("tel", tel);
		}
		if( this.phone != null ){
			params.put("phone", phone);
		}
		if( this.mail != null ){
			params.put("mail", mail);
		}
		if( this.qq != null ){
			params.put("qq", qq);
		}
		params.put("updPerson", creater);
		int now = (int)(System.currentTimeMillis()/1000);
		params.put("updTime", now);
		params.put("id", id);
		this.globalNetBiz.updCompanyByMap(params);
		toCompanyInfo();
		return "info";
	}
	
	
	 public String upload() {  
		   if(image == null){
			   return "";
		   }
		   Date date = new Date();
	   	   String namePrefix=format.format(date);
	       String path = ModuleEnum.getImageSavePath()+namePrefix;
	       File file = new File(path);  
	       if (!file.exists()) {  
	           file.mkdirs();  
	       }  
	       try {  
	              FileUtils.copyFile(image, new File(file, imageFileName));  
	        } catch (IOException e) {  
	              e.printStackTrace();  
	        }  
	       return ModuleEnum.getImageServUrl()+namePrefix+"/"+imageFileName;  
	  }


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public List<Recommend> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<Recommend> recommendList) {
		this.recommendList = recommendList;
	}
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public GlobalNetBiz getGlobalNetBiz() {
		return globalNetBiz;
	}
	public void setGlobalNetBiz(GlobalNetBiz globalNetBiz) {
		this.globalNetBiz = globalNetBiz;
	}
	public SimpleDateFormat getFormat() {
		return format;
	}
	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}  

	 

	
}
