<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱套餐基本信息管理页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>

<form action="${ctx}/weddingphoto/wdppackage/wdppackage!editBaseInfo.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>区域</td>
			<td>
			<select id="area_id" name="wdpPackage.areaId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>所属岛屿</td>
			<td>
				<select id="island_id" name="wdpPackage.islandId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>所属类别</td>
			<td>
				<select id="package_type_id" name="wdpPackage.typeId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="packageType" items="${packageTypeList}">
							<option value="${packageType.id}" >${packageType.title}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>套餐标题</td>
			<td><input type="text" name="wdpPackage.title" id="p_title" value="${wdpPackage.title}"/></td>					
		</tr>
		<tr>
			<td>淡季价格</td>
			<td><input type="text" name="wdpPackage.priceSmall" id="p_s_price" value="${wdpPackage.priceSmall}"/></td>					
		</tr>
		<tr>
			<td>旺季价格</td>
			<td><input type="text" name="wdpPackage.priceBig" id="p_b_price" value="${wdpPackage.priceBig}"/></td>					
		</tr>
		<tr>
			<td>是否售卖</td>
			<td>
				<input style="width:20px" type=radio name="wdpPackage.isOnline"  value = "1" checked="checked"/> 售卖
				<input style="width:20px" type=radio name="wdpPackage.isOnline" value = "2"/>非售卖
				<input type="hidden" name="wdpPackage.id" value='${wdpPackage.id }'/>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${id}" id="p_id" name="id"/>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="modify_" onclick="javascript:history.go(-1);"/>
			<input type=button  value="修改" id="modify_base" onclick="editBase()"/>
		</td>
</tfoot>
</table>
</form>



</body>
<script>
$(function(){
	$("#area_id").bind('change',setAreaName);
	$("#island_id").bind('change',setIslandName);
});
$(function(){
	var areaId = '${wdpPackage.areaId}';
	$("#area_id option[value='"+areaId+"']").attr('selected',true);
	
	var islandId ='${wdpPackage.islandId}';
	$("#island_id option[value='"+islandId+"']").attr('selected',true);
	
	var packageDetailType ='${wdpPackage.typeId}';
	$("#package_type_id option[value='"+packageDetailType+"']").attr('selected',true);
	
	var online = '${wdpPackage.isOnline}';
	$("input[type=radio][value='"+online+"']").attr('checked',true);
	
	
});
function setAreaName(){
	var areaName=$("#area_id").find("option:selected").text();  
	var areaId = $("#area_id").val();
	$("#area_name").val(areaName);
	
	
	$.ajax({
		type:"get",
		url:"${ctx}/marrypackage/index/marraymasterrecomend!getIslandByArea.action?areaId="+areaId,
		dataType:"json",
		success:function(json){
			if( json.length > 0){
				var html = "";
				html +="<option value='0' selected='selected'>--请选择--</option>";
				for( var i=0 ; i<json.length; i++){
					html +="<option value='"+json[i].id+"'>"+json[i].name+"</option>";
				}
				$("#island_id").html(html);
			}else{
				var html = "";
				html +="<option value='0' selected='selected'>--请选择--</option>";
				$("#island_id").html(html);
			}
		}
	});
}

function setIslandName(){
	var islandName=$("#island_id").find("option:selected").text();  
	var islandId = $("#island_id").val();
	$("#island_name").val(islandName);
	
	$.ajax({
		type:"get",
		url:"${ctx}/marrypackage/package/package!getPackageTypeByIsland.action?islandId="+islandId,
		dataType:"json",
		success:function(json){
			if( json.length > 0){
				var html = "";
				html +="<option value='0' selected='selected'>--请选择--</option>";
				for( var i=0 ; i<json.length; i++){
					html +="<option value='"+json[i].id+"'>"+json[i].title+"</option>";
				}
				$("#package_type_id").html(html);
			}else{
				var html = "";
				html +="<option value='0' selected='selected'>--请选择--</option>";
				$("#package_type_id").html(html);
			}
		}
	});
	
}
function editBase(){
	$("#form").submit();
}	

</script>
</html>