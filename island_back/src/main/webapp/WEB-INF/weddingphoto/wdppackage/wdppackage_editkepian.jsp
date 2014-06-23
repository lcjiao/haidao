<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import ="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>套餐客片留影修改页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/weddingphoto/wdppackage/wdppackage!editKepian.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
		<tr>
			<td>链接</td>
			<td><input type=text class="text" value="${pkgKPLY.link}" id="link" name="pkgKPLY.link"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>描述</td>
			<td><input type=text class="text" value="${pkgKPLY.kepianDesc}" id="desc" name="pkgKPLY.kepianDesc"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="${pkgKPLY.kepianIndex}" id="index_num" name="pkgKPLY.kepianIndex"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="p_id" name="pkgKPLY.packageId" value='<s:property value="pkgKPLY.packageId"/>'/>
<input type="hidden" id="_id" name="pkgKPLY.id" value='<s:property value="pkgKPLY.id"/>' />
<input type="hidden" id="img" name="pkgKPLY.img" value='<s:property value="pkgKPLY.imgUrl"/>' />
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="_return" onclick="javascript:history.go(-1);"/>
			<input type=button  value="修改" id="save" onclick="checkData()"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>

function checkData(){
	var r = /^[0-9]+$/;
	var index_num = $("#index_num").val();
	if(!r.test(index_num)){
		alert('排序只能为数字');
		return;
	}else{
		$("#form").submit();
	}
}
</script>
</html>