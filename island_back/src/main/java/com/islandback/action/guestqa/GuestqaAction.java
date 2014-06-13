package com.islandback.action.guestqa;




import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.island.domain.DomainIslandModule;
import com.island.domain.biz.GuestQaBiz;
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
	
	public static void main(String arg[]){
		GuestQaBiz guestqaBiz = ModuleRegistry.getInstance()
	            .getModule(DomainIslandModule.class).getGuestQaBiz();
		Map<String,Object> params = new HashMap<String,Object>(0);
		guestqaBiz.queryGuestQaByMap(params);
	}
	
}
