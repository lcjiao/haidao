<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>疑难解答</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
</head>
<body>
<form action="${ctx}/globalqa/globalqatype/globalqatype!add.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>名称</td>
			<td><input type=text class="text" value="" id="type_name" name="globalQaType.typeName"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>

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

$(function(){
});


function checkData(){
	$("#form").submit();
}
function resetData(){
	var link = "${ctx}/globalqa/globalqatype/globalqatype!tolist.action";
	window.location.href = link; 
}	
</script>
</html>