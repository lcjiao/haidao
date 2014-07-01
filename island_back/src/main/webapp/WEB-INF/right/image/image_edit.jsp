<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图片上传</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/right/image/image!edit.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
		<tr>
			<td>描述</td>
			<td><input type="text" name="img.imgDesc" value="${img.imgDesc}" /></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${id}" id="img_id" name="id"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
			<input type=button  value="返回" id="reset" onclick="resetDate()"/> 
		</td>
</tfoot>
</table>
</form>

</body>
<script>

function resetDate(){
	var url = "${ctx}/right/image/image!list.action";
	window.location.href = url;
}

function checkData(){
	$("#form").submit();
}


</script>
</html>