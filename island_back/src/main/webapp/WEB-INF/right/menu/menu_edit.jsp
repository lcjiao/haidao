<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建后台角色</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/right/menu/menu!editMenu.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>菜单名</td>
			<td><input type=text class="text" value="${menuName}" id="menu_name" name="menuName"  style="_width:316px;"/></td>					
		</tr>
		
		<tr>
			<td>菜单url</td>
			<td><input type=text class="text" value="${menuUrl}" id="menu_url" name="menuUrl"  style="_width:316px;"/></td>					
		</tr>
		
		<tr>
			<td>父菜单Id</td>
			<td><input type=text class="text" value="${parentId}" id="parent_id" name="parentId"  style="_width:316px;"/></td>					
		</tr>
		
		<tr>
			<td>显示次序</td>
			<td><input type=text class="text" value="${showIndex}" id="show_index" name="showIndex"  style="_width:316px;"/></td>					
		</tr>
		
		
	</tbody>	
</table>
<input type="hidden" id="menu_id" name="menuId" value="${menuId}"/>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td><input type=button  value="保存" id="save"/></td>
	</tfoot>
</table>
</form>
</body>
<script>
	$(function(){
		$("#save").bind('click',submitSave);
	});
	
	function submitSave(){
		$("#form").submit();
	}
	
</script>
</html>