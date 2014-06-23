<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>档期预约修改</title>
<link rel="stylesheet"  href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<%@ include file="/common/menu.jsp"%>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/wdpphototeam/subscribe/subscribe!editSubscribeInfo.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>	
		<tr>
			<td>摄影类型:</td>
			<td width="10">
				<select id="type_id" name="ptoSubscribe.typeId">
					<option value="0" selected="selected">--请选择--</option>
					<option value="1" >摄影团队</option>
					<option value="2" >摄影师</option>
					<option value="3" >化妆师</option>
					<option value="4" >影片师</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>名称:</td>
			<td width="10">
				<select id="position_id" name="ptoSubscribe.positionId">
					<option value="0" selected="selected">--请选择--</option>
						<c:forEach var="position" items="${positionList}">
								<option value="${position.id}" >${position.name}</option>
					    </c:forEach>
				</select>
			</td>
		</tr>	
		<tr>
			<td>预约开始时间</td>
			<td>
				<input type="text" id="start_time" value="${ptoSubscribe.startTime }" name="ptoSubscribe.startTime" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:300px"/>
			</td>					
		</tr>
		<tr>
			<td>预约结束时间</td>
			<td>
				<input type="text" id="end_time" value="${ptoSubscribe.endTime }" name="ptoSubscribe.endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:300px"/>
			</td>					
		</tr>
		<tr>
			<td>显示名称1</td>
			<td>
				<input type=text class="text" id="strnamef" value="${ptoSubscribe.strnamef }" name="ptoSubscribe.strnamef" />
			</td>
		</tr>
		<tr>
			<td>显示名称2</td>
			<td>
				<input type="text" class="text" id="strnamet" value="${ptoSubscribe.strnamet }" name="ptoSubscribe.strnamet"/>	
				<input type="hidden" id="id" name="ptoSubscribe.id" value="${ptoSubscribe.id }"/>	
			</td>	
		</tr>
		<!-- 
		<tr>
			<td>排序</td>
			<td>
				<input type=text class="text" value="${recommend.recommendIndex }" id="recommend_index" name="recommend.recommendIndex"  style="_width:316px;"/>
			</td>					
		</tr>
		 -->	
	</tbody>	
</table>
</div>
<input type="hidden" id="type_name" name="ptoSubscribe.typeName"/>
<input type="hidden" id="position_name" name="ptoSubscribe.positionName"/>
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
		//$("#area_id").bind('change',setIsland);
		$('#save_edit').bind('click',_saveEdit);
	});
	
	$(function(){
		var typeId = '${ptoSubscribe.typeId}';
		$("#type_id option[value='"+typeId+"']").attr('selected',true);
		
		var positionId = '${ptoSubscribe.positionId}';
		$("#position_id option[value='"+positionId+"']").attr('selected',true);
		
		$("#type_id").bind('change',setAreaName);
		$("#position_id").bind('change',setIslandName);
	});
	
	function setTypeName(){
		var typeName=$("#type_id").find("option:selected").text();  
		var typeId = $("#type_id").val();
		$("#type_name").val(typeName);
		
		
		$.ajax({
			type:"get",
			url:"${ctx}/wdpphototeam/subscribe/subscribe!getPositionByTypeId.action?typeId="+typeId,
			dataType:"json",
			success:function(json){
				if( json.length > 0){
					var html = "";
					html +="<option value='0' selected='selected'>--请选择--</option>";
					for( var i=0 ; i<json.length; i++){
						html +="<option value='"+json[i].positionId+"'>"+json[i].positionName+"</option>";
					}
					$("#position_id").html(html);
				}
			}
		});
	}

	function setPositionName(){
		var positionName=$("#position_id").find("option:selected").text();  
		$("#position_name").val(positionName);
		
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
		var areaId = $('area_id').val();
		var islandId = $('island_id').val();
		var rmdIndex = $('recommend_index').val();
		if(null == areaId || areaId == '0' || islandId == null || null == rmdIndex){
			alert('请检查区域、排序等栏位！！！');
			return false;
		}
		return true;
		
	}	
	
</script>
<s:debug></s:debug>
</html>