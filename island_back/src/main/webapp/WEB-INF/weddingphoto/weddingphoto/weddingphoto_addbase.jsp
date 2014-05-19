<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱套餐基本信息录入页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>

<form action="${ctx}/weddingphoto/weddingphoto/weddingphoto!addBaseInfo.action"   id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>所属岛屿</td>
			<td>
				<select id="island_id" name="islandId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>套餐标题</td>
			<td><input type="text" name="islandPackage.title" id="p_title" value=""/></td>					
		</tr>
		<tr>
			<td>淡季价格</td>
			<td><input type="text" name="islandPackage.smallPrice" id="p_s_price" value=""/></td>					
		</tr>
		<tr>
			<td>旺季价格</td>
			<td><input type="text" name="islandPackage.bigPrice" id="p_b_price" value=""/></td>					
		</tr>
		<tr>
			<td>是否售卖</td>
			<td>
				<input style="width:20px" type=radio name="islandPackage.online"  value = "1" checked="checked"/> 售卖
				<input style="width:20px" type=radio name="islandPackage.online" value = "2"/>非售卖
			</td>
		</tr>
	</tbody>	
</table>
</div>

<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="保存并返回" id="add_base" onclick="addBaseAndToList()"/>
			<input type=button  value="保存并添加详情" id="add_detail" onclick="addBaseAndToDetail()"/>
			<input type="hidden" id="flag" name="flag" value="">
		</td>
</tfoot>
</table>
</form>



</body>
<script>
function addBaseAndToList(){
	$("#flag").val("toList");
	$("#form").submit();
}	

function addBaseAndToDetail(){
	$("#flag").val("toDetail");
	$("#form").submit();
}	
</script>
</html>