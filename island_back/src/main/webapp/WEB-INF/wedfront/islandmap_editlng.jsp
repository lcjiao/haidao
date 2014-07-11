<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>岛屿地图维护</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>


<%@ include file="/common/kindeditor.jsp"%>

</head>
<body>
<form action="${ctx}/wedfront/islandmap!editMapLng.action" enctype="multipart/form-data"  id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>距离顶端百分值</td>
			<td><input type="text" name="islandMap.mapTop" value="${islandMap.mapTop}"/></td>
		</tr>
		<tr>
			<td>距离左端百分值</td>
			<td><input type="text" name="islandMap.mapLeft" value="${islandMap.mapLeft}"/></td>
		</tr>
		<tr>
			<td>描述</td>
			<td><input type="text" name="islandMap.mapDesc" value="${islandMap.mapDesc}"/></td>
		</tr>
		<tr>
			<td>链接</td>
			<td><input type="text" name="islandMap.linkUrl" value="${islandMap.linkUrl}"/></td>
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="reset"/>
			<input type=button  value="保存" id="save"/>
		 </td>
</tfoot>
</table>
<input type="hidden" id="id" name="islandMap.id" value="${islandMap.id}"/>
<input type="hidden" id="islandId" name="islandId" value="${islandId}"/>
<input type="hidden" id="packageType" name="packageType" value="${packageType}"/>
</form>
</body>
<script>
	$(function(){
		$("#save").bind('click',submitSave);
		$("#reset").bind('click',resetData);
		  
	});
	
	function submitSave(){
		$("#form").submit();
	}
	
	function resetData(){
		var id = $("#islandId").val();
		var packageType = $("#packageType").val();
		var url ="${ctx}/wedfront/islandmap!toLngList.action?islandId="+id+"&packageType="+packageType;
		window.location.href = url; 
	}
</script>
</html>