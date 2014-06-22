<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐辅推产品</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
</head>
<body>
<form action="${ctx}/marrypackage/secondpackage/secondpackagerecommend!add.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>所属岛屿</td>
			<td>
			<select id="island_id" name="recommend.islandId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>标题</td>
			<td><input type=text class="text" value="" id="title" name="recommend.title"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>描述</td>
			<td><textarea style="width:264px;height:50px;" class="text" id="desc" name="recommend.recommendDesc" ></textarea></td>					
		</tr>
		<tr>
			<td>图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
		<tr>
			<td>链接</td>
			<td><input type=text class="text" value="" id="link" name="recommend.linkUrl"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="" id="index_num" name="recommend.recommendIndex"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value=" " id="island_name" name="recommend.islandName"/>

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
	//$("#area_id").bind('change',setAreaName);
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

function resetData(){
	var url =  "${ctx}/marrypackage/secondpackage/secondpackagerecommend!tolist.action";
	window.location.href = url; 
}
</script>
</html>