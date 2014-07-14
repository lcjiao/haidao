<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱摄影套餐类型</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/weddingphoto/moduletype/areamoduletype!add.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>区域</td>
			<td>
			<select id="area_id" name="moduleType.areaId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>岛屿</td>
			<td>
			<select id="island_id" name="moduleType.islandId">
				<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>类别名称</td>
			<td><input type=text class="text" value="" id="title" name="moduleType.title"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value=" " id="island_name" name="moduleType.islandName"/>
<input type="hidden" value=" " id="area_name" name="moduleType.areaName"/>

<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="_return" onclick="javascript:history.go(-1);"/>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
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
		url:"${ctx}/marrypackage/index/marraymasterrecomend!getIslandByArea.action?areaId="+areaId,
		dataType:"json",
		success:function(json){			
			if(json.length > 0){
				$("#island_id").find("option").remove();
				$("#island_id").prepend("<option value='0'>--请选择--</option>")
				for( var i=0 ; i<json.length; i++){
					$("#island_id").append("<option value='"+json[i].id+"'>"+json[i].name+"</option>");
				}
			}else{
				$("#island_id").find("option").remove();
				$("#island_id").prepend("<option value='0'>--请选择--</option>")
			}
		}
	});
}

function setIslandName(){
	var islandName=$("#island_id").find("option:selected").text();  
	$("#island_name").val(islandName);
	
}

function checkData(){
	var islandId = $("#island_id").val();
	var areaId = $("#area_id").val();
	var title = $("#title").val(); 
	if(areaId == 0 || areaId == null){
		alert('区域必填！');
		return;
	}
	if(islandId == 0 || islandId == null){
		alert('岛屿必填！');
		return;
	}
	if("" == title.trim()){
		alert('类别名称不能为空！');
		return;
	}
	$("#form").submit();
}
</script>
</html>