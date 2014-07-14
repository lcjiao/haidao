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
<form action="${ctx}/wedfront/islandmap!mapImg.action" enctype="multipart/form-data"  id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>背景图</td>
			<td><input type="file" name="backimage"/></td>
		</tr>
		<tr>
			<td>前景图</td>
			<td><input type="file" name="frontimage"/></td>
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
		var packageType = $("#packageType").val();
		var url =  "${ctx}/wedfront/islandmap!list.action?packageType="+packageType;
		window.location.href = url; 
	}
</script>
</html>