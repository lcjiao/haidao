<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐基本信息录入页</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>

<form action="${ctx}/hotel/package/package!addBaseInfo.action"   id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>区域</td>
			<td>
			<select id="area_id" name="areaId">
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
				<select id="island_id" name="islandId">
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
				<select id="package_type_id" name="packageDetailType">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="packageType" items="${packageTypeList}">
							<option value="${packageType.id}" >${packageType.title}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>套餐标题</td>
			<td><input type="text" name="title" id="p_title" value=""/></td>					
		</tr>
		<tr>
			<td>淡季价格</td>
			<td><input type="text" name="smallPrice" id="p_s_price" value=""/></td>					
		</tr>
		<tr>
			<td>旺季价格</td>
			<td><input type="text" name="bigPrice" id="p_b_price" value=""/></td>					
		</tr>
		<tr>
			<td>是否售卖</td>
			<td>
				<input style="width:20px" type=radio name="online"  value = "1" checked="checked"/> 售卖
				<input style="width:20px" type=radio name="online" value = "2"/>非售卖
			</td>
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value=" " id="action_type" name="actionType"/>

<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="back_list" onclick="resetData()"/>
			<input type=button  value="保存并返回" id="add_base" onclick="addBaseAndToList()"/>
			<input type=button  value="保存并添加详情" id="add_detail" onclick="addBaseAndToDetail()"/>
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

function setAreaName(){
	var areaName=$("#area_id").find("option:selected").text();  
	var areaId = $("#area_id").val();
	$("#area_name").val(areaName);
	
	
	$.ajax({
		type:"get",
		url:"${ctx}/hotel/index/marraymasterrecomend!getIslandByArea.action?areaId="+areaId,
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
		url:"${ctx}/hotel/package/package!getPackageTypeByIsland.action?islandId="+islandId,
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

function addBaseAndToList(){
	$("#action_type").val(1);
	$("#form").submit();
}	

function addBaseAndToDetail(){
	$("#action_type").val(2);
	$("#form").submit();
}	

function resetData(){
	var url = "${ctx}/hotel/package/package!list.action";
	window.location.href = url;
}
</script>
</html>