package com.island.domain.util;


import com.jcl.core.dal.ibatis.SqlSessionWrapper;
import com.jcl.core.logging.LogUtil;
import com.jcl.core.logging.LoggerFactory;
import com.jcl.core.logging.Logger;
import com.jcl.core.util.ContextHolder;
import com.jcl.core.util.Executor;
/**
 * 高性能控制器
 * @author jcl
 *
 */
public class AsynBizExecutor implements Runnable{
	protected static Logger _logger = LoggerFactory.getLogger("trace");
	
	private String id = (String)ContextHolder.getReqId();
	private boolean logger = true;
	private String biz="";
	@Deprecated
	private AsynBizExecutor(){
		start();	
	}
	@Deprecated
	public AsynBizExecutor(String biz){
		this.biz = biz;
		start();
	}
	@Deprecated
	public AsynBizExecutor(boolean logger){
		this.logger=logger;
		start();
	}
	public AsynBizExecutor(String biz,boolean logger){
		this.biz = biz;
		this.logger=logger;
		start();
	}
	private void start(){
		
		String threadName = Thread.currentThread().getName();
		boolean deferClose = "true".equalsIgnoreCase(System.getProperty("batch.asyn","true"));
		LogUtil.trace("@Thread"+threadName+":AsynBizExecutor:batch.asyn:"+deferClose);
		if(deferClose){
			/**
			 * 异步执行
			 */			
			Executor.execute(this);
		}
		else{
			/**
			 * 同步执行
			 */
			final long start = System.currentTimeMillis();	
			execute();
			if(logger){
				_logger.info(id+"AsynBizExecutor.execute("+biz+") timeused="+(System.currentTimeMillis()-start));
			}
		}	
	}
	
	public void run() {
		final long start = System.currentTimeMillis();
		ContextHolder.set(this.getId());
		try{
			execute();
		}
		catch(Exception ex){
			onException(ex);
		}
		finally{
			SqlSessionWrapper.closeAll();
			if(logger){
				_logger.info(id+"AsynBizExecutor.execute("+biz+") timeused="+(System.currentTimeMillis()-start));
			}
		}		
	}
	public void execute(){}
	
	public void onException(Exception ex){
		LogUtil.error(ex);
	}
	
	public String getId(){
		return id;
	}
	
}
