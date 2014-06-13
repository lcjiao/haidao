package com.islandback.action.guestqa;




import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.ConfBiz;
import com.island.domain.biz.GuestQaBiz;
import com.islandback.module.ModuleEnum;
import com.jcl.core.module.ModuleRegistry;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("serial")
@Namespace("/guestqa")
@ResultPath("/WEB-INF")
/**
 * http://blog.csdn.net/redarmy_chen/article/details/7342247
 * @author lcjiao
 *
 */
public class GuestqaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	GuestQaBiz guestqaBiz = ModuleRegistry.getInstance()
            .getModule(DomainIslandModule.class).getGuestQaBiz();
	
	public void test(){
		Map<String,Object> params = new HashMap<String,Object>(0);
		this.guestqaBiz.queryGuestQaByMap(params);
	}
	
	public static void main(String arg[]) throws InterruptedException{
		for(int i=0;i<10000;i++){
			Thread.sleep(5000);
			System.out.println(ModuleEnum.getImageSavePath());
			System.out.println(ModuleEnum.getImageServUrl());
		}
	}
	
}
