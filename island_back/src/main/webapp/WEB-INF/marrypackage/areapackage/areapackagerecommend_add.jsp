<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐区域产品</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/marrypackage/areapackage/areapackagerecommend!add.action" enctype="multipart/form-data" id="form" method="post">
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
			<td>岛屿</td>
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
			<td>旺季价格</td>
			<td><input type=text class="text" value="" id="price_big" name="recommend.priceBig"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>淡季价格</td>
			<td><input type=text class="text" value="" id="price_small" name="recommend.priceSmall"  style="_width:316px;"/></td>					
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
			<td>简介</td>
			<td>
				<textarea name="recommend.recommendDesc" style="width:700px;height:200px;"></textarea>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value=" " id="island_name" name="recommend.islandName"/>
<input type="hidden" value=" " id="area_name" name="recommend.areaName"/>
<!-- <input type="hidden" value=" " id="package_desc" name="recommend.recommendDesc"/>
 -->
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
	$("#area_id").bind('change',setAreaName);
	$("#island_id").bind('change',setIslandName);
});

function setAreaName(){
	var areaName=$("#area_id").find("option:selected").text();  
	var areaId = $("#area_id").val();
	$("#area_name").val(areaName);
	
	
	$.ajax({
		type:"get",
		url:"${ctx}/marrypackage/areapackage/areapackagerecommend!getIslandByArea.action?areaId="+areaId,
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
	$("#island_name").val(islandName);
	
}

function checkData(){
	//$("#package_desc").val(editor.html());
	$("#form").submit();
}
function resetData(){
	var url =  "${ctx}/marrypackage/areapackage/areapackagerecommend!tolist.action";
	window.location.href = url; 
}
</script>
</html>