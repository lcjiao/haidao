<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱套餐区域产品</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/weddingphoto/area/arearecommend!add.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>区域</td>
			<td>
			<select id="area_id" name="recommend.areaId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="" id="index_num" name="recommend.recommendIndex"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value=" " id="area_name" name="recommend.areaName"/>

<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
			<input style="display: none" type=button  value="继续添加" id="add_more"/>
			<!-- <input type=button  value="返回" id="reset"/> -->
		</td>
</tfoot>
</table>
</form>

</body>
<script>

$(function(){
	$("#area_id").bind('change',setAreaName);
});

function setAreaName(){
	var areaName=$("#area_id").find("option:selected").text();  
	var areaId = $("#area_id").val();
	$("#area_name").val(areaName);
	
	
	$.ajax({
		type:"get",
		url:"${ctx}/weddingphoto/index/marraymasterrecomend!getIslandByArea.action?areaId="+areaId,
		dataType:"json",
		success:function(json){
			if( json.length > 0){
				var html = "";
				html +="<option value='0' selected='selected'>--请选择--</option>";
				for( var i=0 ; i<json.length; i++){
					html +="<option value='"+json[i].id+"'>"+json[i].name+"</option>";
				}
				$("#island_id").html(html);
			}
		}
	});
}

function setIslandName(){
	var islandName=$("#island_id").find("option:selected").text();  
	$("#island_name").val(islandName);
	
}

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
</script>
</html>