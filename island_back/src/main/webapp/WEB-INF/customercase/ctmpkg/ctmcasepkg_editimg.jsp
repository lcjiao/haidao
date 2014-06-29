<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import = "com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例图片修改页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmpkg/ctmcasepkg!editImgcase.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
		<td width="48">图片类型</td>
			<td width="10">
				<select id="img_type" name="casepm.imgType">
					<option value="0" selected="selected">--请选择--</option>
					<option value="1" >logo图</option>
					<option value="2" >套餐图片集</option>
					<option value="3" >套餐大图</option>
				</select>
				<input type="hidden" id="type_name" name="casepm.typeName" value="${casepm.typeName }" />
			</td>
		</tr>
		<tr>
			<td>描述</td>
			<td><input type=text class="text" id="desc" name="casepm.picturedesc" value="${casepm.picturedesc }" style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>链接地址</td>
			<td><input type=text class="text" id="pic_link" name="casepm.picLink" value="${casepm.picLink }" style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="p_id" name="casepm.caseid" value='${casepm.caseid }'/>
<input type="hidden" id="_id" name="casepm.id" value='<s:property value="casepm.id"/>' />
<input type="hidden" id="img_url" name="casepm.pictureurl" value='<s:property value="casepm.pictureurl"/>' />
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
	var imgType = '${casepm.imgType}';
	$("#img_type option[value='"+imgType+"']").attr('selected',true);
	
	$("#img_type").bind('click',changeImgType);
});

function changeImgType(){
	var imgTypeName = $("#img_type").find("option:selected").text();  
	$("#type_name").val(imgTypeName);
}
function checkData(){
	var imgType = $('#img_type').val();
	if(imgType == 0 || null == imgType){
		alert('图片类型必选!');
		return false;
	}
	$("#form").submit();
}
</script>
</html>