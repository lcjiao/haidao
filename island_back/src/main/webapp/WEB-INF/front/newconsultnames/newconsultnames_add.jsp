<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>全站推荐</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
</head>
<body>
<form action="${ctx}/front/newconsultnames/newconsultnames!add.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>标题</td>
			<td><input type=text class="text" value="" id="title" name="recommend.title"  style="_width:316px;"/></td>					
		</tr>

		<tr>
			<td>展示列</td>
			<td>  
				<select id="typeId" name="recommend.typeId">
					<option value="1" selected="selected">--第一列--</option>
					<option value="2">--第二列--</option>
				</select>
			</td>					
		</tr>
	</tbody>	
</table>
</div>

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

$(function(){
});

function resetData(){
	var url = "${ctx}/front/newconsultnames/newconsultnames!tolist.action";
	window.location.href = url;
}
function checkData(){
	$("#form").submit();
}
</script>
</html>