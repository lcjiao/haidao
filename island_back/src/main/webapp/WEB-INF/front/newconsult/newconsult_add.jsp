<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页咨询内容添加</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>


</head>
<body>
<form action="${ctx}/front/newconsult/newconsult.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>标题</td>
			<td><input type=text class="text" value="" id="title" name="title" style="width:255px;" /></td>					
		</tr>
		
		<tr>
			<td>链接地址</td>
			<td><input type=text class="text" value="" id="link" name="link" style="width:255px;" /></td>					
		</tr>
		
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="" id="index" name="index" style="width:255px;" /></td>					
		</tr>
		<tr>
			<td>时间</td>
			 <td><input type="text" id = "time"  value=""  class="Wdate" onfocus="WdatePicker()" name="time"/></td>
		 </tr>
	</tbody>	
</table>
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