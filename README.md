# 使用步骤

------------
		1:安装 maven  git  mysql jdk
		
-----------

		2:同步项目  git clone git@github.com:lcjiao/haidao.git
	        
------------
		3:将依赖jar导入本地仓库
		mvn install:install-file -Dfile=${your path}/island-dependencies.jar -DgroupId=com.jcl.dependen -DartifactId=island-dependen -Dversion=1.1 -Dpackaging=jar  -DgeneratePom=true -DcreateChecksum=true
	 	

# 使用说明

-------------

		1:gen-dal是个工具包 可根据表结构生成一套模版类
		DalGenFromDB hf = new DalGenFromDB("haidao_db","test_tab",
				new DataSourceDefinition[] {   		DataSourceDefinition.HAIDAO_DB,DataSourceDefinition.HAIDAO_DB});
		hf.process();
		
-------------
		2:domain-island 整合封装了 spring+ibatis ，将gen-dal生成得几个模版类放入相应包里即可
		domain-island 负责业务和数据库层交互不，不关心展示层使用何种框架
		domain-islan业务biz调用方式:
		TestBiz biz = ModuleRegistry.getInstance()
				.getModule(DomainIslandModule.class).getTestBiz();
		biz.addModel();
		
-------------
		3:island-dependencies.jar 是封装好得依赖包,database.properties 是数据库配置












