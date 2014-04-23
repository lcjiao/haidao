<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>前端首页操作</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<div  class="creatcustomer" >
<s:form action="/front/masterecommend/masterecommend.action" enctype="multipart/form-data" method="post">  
	
	<table class="datalist" width="100%">
		<tr>
			 	<s:textfield label="链接地址" name="link"></s:textfield> 
		</tr>
		<tr>
			 	<s:textfield label="描述" name="desc"></s:textfield> 
		</tr>
		<tr>
			 	 <s:file label="上传文件" name="image"></s:file>  
		</tr>
		<tr>
			 	  <s:submit value="上传" />  
		</tr>
	</table>
           
           
</s:form>  
</div>
</body>
<script>
	
</script>
</html>