<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>套餐图片修改页</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/marrypackage/package/package!editImg.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
		<td width="48">图片类型</td>
			<td width="10">
				<select id="img_type" name="imgType">
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
			<td><input type=text class="text" value="${imgDesc}" id="desc" name="imgDesc"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="${imgIndex}" id="index_num" name="imgIndex"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${id}" id="p_id" name="id"/>
<input type="hidden" value="${imgId}" id="img_id" name="imgId"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
			<input style="display: none" type=button  value="继续添加" id="add_more"/>
			<!-- <input type=button  value="返回" id="reset"/> -->
		</td>
</tfoot>
</table>
</form>

</body>
<script>

$(function(){
	var imgType = '${imgType}';
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