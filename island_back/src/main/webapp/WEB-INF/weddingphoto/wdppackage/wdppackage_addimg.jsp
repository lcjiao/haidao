<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱摄影套餐图片添加页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/weddingphoto/wdppackage/wdppackage!saveImg.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
		<td width="48">图片类型</td>
			<td width="10">
				<select id="img_type" name="pkgImgRelation.imgType">
					<option value="0" selected="selected">--请选择--</option>
					<option value="1" >logo图</option>
					<option value="2" >套餐图片集</option>
					<option value="3" >套餐大图</option>
					<option value="4" >套餐小图</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>描述</td>
			<td><input type=text class="text" value="" id="desc" name="pkgImgRelation.imgDes"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="" id="index_num" name="pkgImgRelation.imgIndex"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="保存并返回" id="add_return" onclick="saveImgAndReturn()"/>
			<input type=button  value="保存并继续添加" id="add_continue" onclick="saveImgAndContinue()"/>
			<input type="hidden" id="flag" name="flag" value="">
			<input type="hidden" value="${wdpPackage.id}" id="p_id" name="pkgImgRelation.packageId"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>

function saveImgAndReturn(){
	$("#flag").val("return");
	if(checkData()){
		$("#form").submit();
	}
}	

function saveImgAndContinue(){
	$("#flag").val("continue");
	if(checkData()){
		$("#form").submit();
	}
}	

function checkData(){
	var r = /^[0-9]+$/;
	var index_num = $("#index_num").val();
	if(!r.test(index_num)){
		alert('排序只能为数字');
		return false;
	}
	return true;
}
</script>
</html>