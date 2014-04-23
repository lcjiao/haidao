package com.islandback.action.frontindex;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.jcl.core.module.ModuleRegistry;
import com.island.domain.DomainIslandModule;
import com.island.domain.biz.RoleBiz;
import com.islandback.web.util.RequestProcc;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/front/masterecommend")
@ResultPath("/WEB-INF")
/**
 * http://blog.csdn.net/redarmy_chen/article/details/7342247
 * @author lcjiao
 *
 */
public class MasterecommendAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String link;
	private String desc;
	private File image;
	private String imageFileName;
	private String imageServPath="/Users/lcjiao/image/";
	RoleBiz roleBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getRoleBiz();
	
	
	/**
	 * 主页主打产品推荐
	 * @return
	 */
	public String add(){
		RequestProcc.getSession().invalidate();
		return "add";
	}
	 public String execute() {  
		  
	       // 把上传的文件放到指定的路径下  
	  
	       String path = imageServPath;
	  
	       // 写到指定的路径中  
	  
	       File file = new File(path);  
	  
	       // 如果指定的路径没有就创建  
	  
	       if (!file.exists()) {  
	  
	           file.mkdirs();  
	       }  
	       // 把得到的文件的集合通过循环的方式读取并放在指定的路径下  
	       try {  
	    		  
	  
	              FileUtils.copyFile(image, new File(file, imageFileName));  
	  
	           } catch (IOException e) {  
	  
	              e.printStackTrace();  
	          }  
	           
	  
	       return "add";  
	    }  

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	
	
	
	
}