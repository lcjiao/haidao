<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱摄影顶部推荐图片修改</title>
<link rel="stylesheet"  href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

<%@ include file="/common/menu.jsp"%>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/weddingphoto/wdptop/wdptop!editRecommend.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>推荐图片</td>
			<td><input type="file" name="image"/>
				<span style="color: red"><b>*</b></span>
				<input type="hidden" id="img_url" name="recommend.imgUrl" value="${recommend.imgUrl }">
			</td>					
		</tr>
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
			<td>图片链接</td>
			<td><input type="text" class="text" id="link_url" name="recommend.linkUrl" value="${recommend.linkUrl }"/></td>	
		</tr>
		<tr>
			<td>描述</td>
			<td><input type=text class="text" value="${recommend.recommendDesc }" id="recommend_desc" name="recommend.recommendDesc" style="_width:316px;"/></td>
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
			<input type=button  value="修改" id="save_edit" />
			<input type=button  value="返回" onclick="_return()" />
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
				url:"${ctx}/weddingphoto/wdptop/wdptop!getIslandSelect.action",
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
		/* if( checkData() && checkrmdIndex()){
			$("#form").submit();
		} 测试时暂时不核验*/
		$("#form").submit();
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
	
	//表单提交前数据验证
	function checkData(){
		/**var areaId = $('area_id').val();
		var islandId = $('island_id').val();
		var rmdIndex = $('recommend_index').val();
		if(null == areaId || areaId == '0' || islandId == null || null == rmdIndex){
			alert('请检查区域、排序等栏位！！！');
			return false;
		}*/
		return true;
		
	}	
	
</script>
</html>