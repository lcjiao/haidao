<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页最受欢迎岛屿添加</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<div  class="creatcustomer" >
<s:form action="/front/masterwelcomeisland/masterwelcomeisland.action" enctype="multipart/form-data" method="post">  
	
	<table class="datalist" width="100%">
		<tr>
			 	<s:textfield label="链接地址" name="link"></s:textfield> 
		</tr>
		<tr>
			 	<s:textfield label="岛屿名称 " name="title"></s:textfield> 
		</tr>
		<tr>
			 	<s:textfield label="排序" name="index"></s:textfield> 
		</tr>
		<tr>
			 	  <s:submit value="提交" />  
		</tr>
	</table>
           
           
</s:form>  
</div>
</body>
<script>
	
</script>
</html>