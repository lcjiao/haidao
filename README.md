# use step

------------
		1:安装 maven  git  mysql jdk
		
-----------

		2:同步项目  git clone git@github.com:lcjiao/haidao.git
	        
------------
		3:将依赖jar导入本地仓库
		mvn install:install-file -Dfile=${your path}/island-dependencies.jar -DgroupId=com.jcl.dependen -DartifactId=island-dependen -Dversion=1.1 -Dpackaging=jar  -DgeneratePom=true -DcreateChecksum=true
	 	
