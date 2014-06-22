<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站菜单添加</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/globalnet/menu/netmenu!add.action"  id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>标题</td>
			<td><input type=text class="text" value="" id="title" name="title"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>链接地址</td>
			<td><input type=text class="text" value="" id="link" name="link"  style="_width:316px;"/></td>					
		</tr>
		
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="" id="index_num" name="index"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value=" " id="role_name" name="roleName"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
			<input type=button  value="返回" id="reset" onclick="resetData()"/> 
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
	var link = "${ctx}/globalnet/menu/netmenu!list.action";
	window.location.href = link; 
}
</script>
</html>