<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例顶部推荐图片修改</title>
<link rel="stylesheet"  href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>


<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmtop/ctmcasetop!editCtmCaseImgRmd.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
	<!-- 	<tr>
			<td>所属区域</td>
			<td>
			<select id="area_id" name="recommend.areaId" style="width: 80px">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}"  <c:if test="${recommend.areaId==area.id }">selected</c:if> >${area.name}</option>
				    </c:forEach>
				</select>
				<span style="color: red"><b>*</b></span>
			</td>
		</tr>
		<tr>
			<td>所属岛屿</td>
			<td>
			<select id="island_id" name="recommend.islandId" style="width: 80px">
				<c:forEach var="island" items="${islandList}">
							<option value="${island.id}"  <c:if test="${recommend.islandId==island.id }">selected</c:if> >${island.name}</option>
				    </c:forEach>
			</select>
			</td>
		</tr>
		 -->
		<tr>
			<td>大图片</td>
			<td><input id="bigImg" type="file" name="image"/>
				<span style="color: red"><b>*</b></span>
				<input type="hidden" id="img_url" name="recommend.bigImgUrl" value="${recommend.bigImgUrl }">
			</td>					
		</tr>
		<tr>
			<td>小图片</td>
			<td><input id="smallImg" type="file" name="smallImage"/>
				<span style="color: red"><b>*</b></span>
				<input type="hidden" id="img_url" name="recommend.smallImgUrl" value="${recommend.smallImgUrl }">
			</td>					
		</tr>
		<tr>
			<td>链接</td>
			<td><input type=text class="text" value="${recommend.linkUrl}" id="link" name="recommend.linkUrl"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value='${recommend.recommendIndex}' id="recommend_index" name="recommend.recommendIndex"  style="_width:316px;"/>
				<span style="color: red"><b>*</b></span>
				<input type="hidden" id="id" name="recommend.id" value="${recommend.id }"/>
			</td>					
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="返回" onclick="_return()" />
			<input type=button  value="修改" id="save_edit" />
		 </td>
	</tfoot>
</table>
<input type="hidden" id="area_name" name="areaName" value=""/>
<input type="hidden" id="island_desc" name="desc" value=""/>
</form>
</body>
<script>
	$(function(){
		$("#area_id").bind('change',setIsland);
		$('#save_edit').bind('click',_saveEdit);
	});
	
	function setIsland(){
		var areaId = $('#area_id').val();
		if(areaId != null){
			var islandSelect = $("#island_id");
			islandSelect.removeAttr('disabled');
			islandSelect.find("option").remove();
			islandSelect.append("<option  value=\"0\">"+"-请选择-"+"</option>");
			var data = {"areaId":areaId};
			$.ajax({
				url:"${ctx}/customercase/ctmtop/ctmcasetop!getIslandSelect.action",
				type: "POST",
		        dataType: "json",
		        data: data,
		        success: function(date) {	
		            if(date.length !=0) {
		            	for(var i=0;i<date.length;i++){
							var data = date[i];
							var key = "";
							var value = "";
							var option = "";
							var selected = "";
							for(var j in data){
								
								if(j=="id"){
									key = data[j];
								}
								if(j=="name"){
									value = data[j];
								}
							}
							option = "<option value="+key+" "+selected+">"+value+"</option>";
							islandSelect.append(option);					
						}
					}
				}
			});		
		}
	}
	
	function _return(){
		history.go(-1);
	}
	
	function _saveEdit(){
		if(checkrmdIndex()){
			$("#form").submit();
		}
	}
	
	//校验排序。只能为数字 
	function checkrmdIndex(){
		var r = /^[0-9]+$/;
		var rmdIndex = $("#recommend_index").val();
		if(!r.test(rmdIndex)){
			alert('排序只能填写数字且不能为空!!!');
			return false;
		}
		return true;
	}
	
	
</script>
</html>