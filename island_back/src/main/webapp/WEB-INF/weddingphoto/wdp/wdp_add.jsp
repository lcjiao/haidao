<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱摄影图片推荐</title>
<link rel="stylesheet"  href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

<%@ include file="/common/menu.jsp"%>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/weddingphoto/wdp/wdp!addWdpRecommend.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>推荐图片</td>
			<td><input type="file" name="image"/>
				<span style="color: red"><b>*</b></span>
			</td>					
		</tr>
		<tr>
			<td>所属区域</td>
			<td>
			<select id="area_id" name="recommend.areaId" style="width: 80px">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
				<span style="color: red"><b>*</b></span>
			</td>
		</tr>
		<tr>
			<td>所属岛屿</td>
			<td>
			<select id="island_id" name="recommend.islandId" style="width: 80px" disabled="disabled">
				</select>
			</td>
		</tr>
		<tr>
			<td>图片链接</td>
			<td><input type="text" class="text" id="link_url" name="recommend.linkUrl"/></td>	
		</tr>
		<tr>
			<td>描述</td>
			<td><input type=text class="text" value="" id="recommend_desc" name="recommend.recommendDesc"  style="_width:316px;"/></td>
		</tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="" id="recommend_index" name="recommend.recommendIndex"  style="_width:316px;"/>
				<span style="color: red"><b>*</b></span>
			</td>					
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="保存并返回" id="save_return" />
			<input type="button" value="保存并继续添加" id="save_add" />
			<input type="hidden" id="flag" name="flag" value="">
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
		$("#save_return").bind('click',save_return);
		$("#save_add").bind('click',save_add);
				  
	});
	
		
	function setIsland(){
		var areaName=$("#area_id").find("option:selected").text();  
		var areaId = $("#area_id").val();
		$("#area_name").val(areaName);
		var islandSelect = $("#island_id");
		islandSelect.removeAttr('disabled');
		
		
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
				}else{
					var html = "";
					html +="<option value='0' selected='selected'>--请选择--</option>";
					$("#island_id").html(html);
				}
			}
		});
	}
	
	function save_return(){
		$('#flag').val("return");
		if( checkData() && checkrmdIndex()){
			$("#form").submit();
		}
	}
	
	function save_add(){
		$('#flag').val("add");
		if( checkData() && checkrmdIndex()){
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
	
	//表单提交前数据验证
	function checkData(){
		var areaId = $('#area_id').val();
		var islandId = $('#island_id').val();
		if(null == areaId || areaId == '0' || islandId == null || islandId == '0' ){
			alert('请检查区域、岛屿等栏位！！！');
			return false;
		}
		return true;
		
	}
	
	function setAreaName(){
		var checkText=$("#area_id").find("option:selected").text();  //获取Select选择的Text
		$("#area_name").val(checkText);
	}
	
	
</script>
</html>