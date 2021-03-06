<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例顶部图片推荐</title>
<link rel="stylesheet"  href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

<%@ include file="/common/menu.jsp"%>

<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmtop/ctmcasetop!addCtmCaseImgRmd.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
	<!-- 	<tr>
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
		 -->
		<tr>
			<td>大图片</td>
			<td><input id = "bigImg" type="file" name="image"/></td>					
		</tr>
		<tr>
			<td>小图片</td>
			<td><input id = "smallImg" type="file" name="smallImage"/></td>					
		</tr>
		<tr>
			<td>链接</td>
			<td><input type=text class="text" value="" id="link" name="recommend.linkUrl"  style="_width:316px;"/></td>					
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
		var bigImg = $('#bigImg').val();
		var smallImg = $('#smallImg').val();
		if(null == bigImg || bigImg == '' || null == smallImg || smallImg == ''){
			alert('大、小图片必选！！');
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