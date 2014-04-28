<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页套餐推荐图片更换</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<div  class="creatcustomer" >
<s:form action="/front/packagerecommend/packagerecommend.action" enctype="multipart/form-data" method="post">  
	
	<table class="datalist" width="100%">
		<tr>
			 	 <s:file label="选择图片" name="image"></s:file>  
		</tr>
		<tr>
			 	  <s:submit value="更换图片" />  
		</tr>
	</table>
           
<input type="hidden" id="id" name="id" value="${id}"/>
<input type="hidden" id="type" name="type" value="changeImg"/>         
</s:form>  
</div>
</body>
<script>
	
</script>
</html>