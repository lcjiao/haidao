<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import = "com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱摄影套餐图片修改页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/weddingphoto/wdppackage/wdppackage!editImg.action" enctype="multipart/form-data" id="form" method="post">
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
			<td><input type=text class="text" id="des" value='<s:property value="pkgImgRelation.imgDes"/>' name="pkgImgRelation.imgDes"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" id="index_num" value='<s:property value="pkgImgRelation.imgIndex"/>' name="pkgImgRelation.imgIndex"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="p_id" name="pkgImgRelation.packageId" value='<s:property value="pkgImgRelation.packageId"/>'/>
<input type="hidden" id="_id" name="pkgImgRelation.id" value='<s:property value="pkgImgRelation.id"/>' />
<input type="hidden" id="img_url" name="pkgImgRelation.imgUrl" value='<s:property value="pkgImgRelation.imgUrl"/>' />
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="修改" id="save" onclick="checkData()"/>
			<input type=button  value="返回" id="_return" onclick="javascript:history.go(-1);"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>

$(function(){
	var imgType = '${pkgImgRelation.imgType}';
	$("#img_type option[value='"+imgType+"']").attr('selected',true);
	
});
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