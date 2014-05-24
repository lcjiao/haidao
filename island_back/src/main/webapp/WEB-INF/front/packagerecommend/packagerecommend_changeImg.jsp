<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页套餐推荐图片更换</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/front/packagerecommend/packagerecommend.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>更换图片</td>
			<td><input type="file" name="image" id="file"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="id" name="id" value="${id}"/>
<input type="hidden" id="type" name="type" value="changeImg"/>         
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="更换图片" id="save" onclick="checkData()"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>
function checkData(){
	$("#form").submit();
}
</script>
</html>