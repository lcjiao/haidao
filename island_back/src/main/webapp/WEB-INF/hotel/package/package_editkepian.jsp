<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>套餐客片留影修改页</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/hotel/package/package!editKepian.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
		<tr>
			<td>链接</td>
			<td><input type=text class="text" value="${kepianLink}" id="link" name="kepianLink"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>描述</td>
			<td><input type=text class="text" value="${kepianDesc}" id="desc" name="kepianDesc"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="${kepianIndex}" id="index_num" name="kepianIndex"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${id}" id="p_id" name="id"/>
<input type="hidden" value="${kepianId}" id="kepian_id" name="kepianId"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="reset" onclick="resetData()"/> 
			<input type=button  value="保存" id="save" onclick="checkData()"/>
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

function resetData(){
	var packageId = $("#p_id").val();
	var url =  "${ctx}/hotel/package/package!toKepianList.action?id="+packageId;
	window.location.href = url; 
}
</script>
</html>