<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>档期预约</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<%@ include file="/common/menu.jsp"%>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>

<form action="${ctx}/wdpphototeam/subscribe/subscribe!addSubscribeInfo.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td width="38">摄影类型</td>
			<td width="20">
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
			<td>名称</td>
			<td width="10">
				<select id="position_id" name="ptoSubscribe.positionId">
					<option value="0" selected="selected">--请选择--</option>
						<c:forEach var="position" items="${positionList}">
								<option value="${position.positionId}" >${position.positionName}</option>
					    </c:forEach>
				</select>
			</td>
		</tr>		
		<tr>
			<td>预约开始时间</td>
			<td>
				<input type="text" id="start_time" name="ptoSubscribe.startT" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:150px"/>
			</td>					
		</tr>
		<tr>
			<td>预约结束时间</td>
			<td>
				<input type="text" id="end_time" name="ptoSubscribe.endT" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:150px"/>
			</td>					
		</tr>
		<tr>
			<td>显示名称1</td>
			<td>
				<input type=text class="text" id="strnamef" name="ptoSubscribe.strnamef" />
			</td>
		</tr>
		<tr>
			<td>显示名称2</td>
			<td><input type="text" class="text" id="strnamet" name="ptoSubscribe.strnamet"/></td>	
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="type_name" name="ptoSubscribe.typeName"/>
<input type="hidden" id="position_name" name="ptoSubscribe.positionName"/>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="保存并返回" id="save_return" />
			<input type="button" value="保存并继续添加" id="save_add" />
			<input type="hidden" id="flag" name="flag" value="">
		 </td>
	</tfoot>
</table>
</form>
</body>
<script>
	$(function(){
		//$("#type_id").bind('change',setIsland);
		$("#save_return").bind('click',save_return);
		$("#save_add").bind('click',save_add);
		var d = new Date();
	    function addzero(v) {
	    	if (v < 10) 
	    		return '0' + v;
	    	return v.toString();
	    }
	    var s = d.getFullYear().toString() +"-"+ addzero(d.getMonth() + 1);
	   // document.getElementById('photo_time').value=s;
	    $('#start_time').val(s);
				  
	});
	
	$(function(){
		$("#type_id").bind('change',setTypeName);
		$("#position_id").bind('change',setPositionName);
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
				if(json.length > 0){
					$("#position_id").find("option").remove();
					$("#position_id").prepend("<option value='0'>--请选择--</option>")
					for( var i=0 ; i<json.length; i++){
						$("#position_id").append("<option value='"+json[i].positionId+"'>"+json[i].positionName+"</option>")
					}
				}else{
					$("#position_id").find("option").remove();
					$("#position_id").prepend("<option value='0'>--请选择--</option>")
				}
			}
		});
	}

	function setPositionName(){
		var positionName=$("#position_id").find("option:selected").text();  
		$("#position_name").val(positionName);
		
	}
	
	function save_return(){
		$('#flag').val("return");
		/* if( checkData() && checkrmdIndex()){
			$("#form").submit();
		} 测试时暂时不核验*/
		$("#form").submit();
	}
	
	function save_add(){
		$('#flag').val("add");
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
		var areaId = $('type_id').val();
		var islandId = $('position_id').val();
		var rmdIndex = $('recommend_index').val();
		if(null == areaId || areaId == '0' || islandId == null || null == rmdIndex){
			alert('请检查区域、排序等栏位！！！');
			return false;
		}
		return true;
		
	}
	
</script>
</html>