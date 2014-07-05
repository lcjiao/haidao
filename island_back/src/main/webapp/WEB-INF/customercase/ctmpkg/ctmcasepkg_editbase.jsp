<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例修改</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<%@ include file="/common/menu.jsp"%>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>

<form action="${ctx}/customercase/ctmpkg/ctmcasepkg!editCtmcase.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td width="48">案例类型</td>
			<td width="10">
				<select id="case_type" name="ctmcase.casetype">
					<option value="0" selected="selected">--请选择--</option>
					<option value="130" >摄影案例</option>
					<option value="131" >视频案例</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>区域</td>
			<td>
			<select id="area_id" name="ctmcase.areaid">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
				   <input id="area_name" name="ctmcase.areaname" type="hidden" value="${ctmcase.areaname }">
			</td>
		</tr>
		<tr>
			<td>岛屿</td>
			<td>
			<select id="island_id" name="ctmcase.islandid">
				<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
			</select>
				   <input id="island_name" name="ctmcase.islandname" type="hidden" value="${ctmcase.islandname }">
			</td>
		</tr>
		<tr>
			<td>案例类别</td>
			<td>
				<select id="child_id" name="ctmcase.childid">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="pkgType" items="${pkgTypeList}">
							<option value="${pkgType.id}" >${pkgType.title}</option>
				   </c:forEach>
				</select>
				<input id="child_name" name="ctmcase.childname" type="hidden" value="${ctmcase.childname }">
			</td>
		</tr>		
		<tr>
			<td>案例名称</td>
			<td><input type="text" name="ctmcase.casename" id="_casename" value="${ctmcase.casename }"/></td>					
		</tr>
		<tr>
			<td>新&nbsp;&nbsp;人</td>
			<td><input type="text" name="ctmcase.newperson" id="_newperson" value="${ctmcase.newperson }"/></td>					
		</tr>
		<tr>
			<td>时&nbsp;&nbsp;间</td>
			<td>
				<input type="text" value="${ctmcase.strPhotoTime }" id="photo_time" name="ctmcase.strPhotoTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:150px"/>
			</td>					
		</tr>
		<tr>
			<td>摄影师</td>
			<td><input type="text" name="ctmcase.photoworker" id="_photoworker" value="${ctmcase.photoworker }"/></td>					
		</tr>
		<tr>
			<td>化妆师</td>
			<td><input type="text" name="ctmcase.dresser" id="_dresser" value="${ctmcase.dresser }"/></td>					
		</tr>
		<tr>
			<td>套餐项目1</td>
			<td>
				<input type="text" name="ctmcase.pkgpjtname1" id="_pkgpjtname1" value="${ctmcase.pkgpjtname1 }"/>
			</td>
		</tr>
		<tr>
			<td>套餐项目链接1</td>
			<td>
				<input type="text" name="ctmcase.pkgpjturl1" id="_pkgpjturl1" value="${ctmcase.pkgpjturl1 }"/>
			</td>					
		</tr>
		<tr>
			<td>套餐项目2</td>
			<td>
				<input type="text" name="ctmcase.pkgpjtname2" id="_pkgpjtname2" value="${ctmcase.pkgpjtname2 }"/>
			</td>
		</tr>
		<tr>
			<td>套餐项目链接2</td>
			<td>
				<input type="text" name="ctmcase.pkgpjturl2" id="_pkgpjturl2" value="${ctmcase.pkgpjturl2 }"/>
			</td>					
		</tr>
		<tr>
			<td>套餐项目3</td>
			<td>
				<input type="text" name="ctmcase.pkgpjtname3" id="_pkgpjtname3" value="${ctmcase.pkgpjtname3 }"/>
			</td>
		</tr>
		<tr>
			<td>套餐项目链接3</td>
			<td>
				<input type="text" name="ctmcase.pkgpjturl3" id="_pkgpjturl3" value="${ctmcase.pkgpjturl3 }"/>
			</td>					
		</tr>		
		
	</tbody>	
</table>
</div>
<input type="hidden" value="${ctmcase.id}" id="p_id" name="ctmcase.id"/>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="modify_return" onclick="javascript:history.go(-1);"/>
			<input type=button  value="修改" id="modify_base" onclick="editBase()"/>
		</td>
</tfoot>
</table>
</form>



</body>
<script>
$(function(){	
	var caseType ='${ctmcase.casetype}';
	$("#case_type option[value='"+caseType+"']").attr('selected',true);
	var areaId = '${ctmcase.areaid}';
	$("#area_id option[value='"+areaId+"']").attr('selected',true);
	var islandId = '${ctmcase.islandid}';
	$("#island_id option[value='"+islandId+"']").attr('selected',true);
	var childId = '${ctmcase.childid}';
	$("#child_id option[value='"+childId+"']").attr('selected',true);
		
});

$(function(){
	$("#case_type").bind('change',setAreaName);
	$("#area_id").bind('change',setIslandName);
	$("#island_id").bind('change',setChildName);
	$("#child_id").bind('change',setChildTypeName);
});

function setAreaName(){
	var caseType = $("#case_type").val();
	
	$.ajax({
		type:"get",
		url:"${ctx}/customercase/ctmpkg/ctmcasepkg!getArea.action?csType="+caseType,
		dataType:"json",
		success:function(json){
			if(json.length > 0){
				$("#area_id").find("option").remove();
				$("#area_id").prepend("<option value='0'>--请选择--</option>");
				for( var i=0 ; i<json.length; i++){
					$("#area_id").append("<option value='"+json[i].id+"'>"+json[i].name+"</option>");
				}
			}else{
				$("#area_id").find("option").remove();
				$("#area_id").prepend("<option value='0'>--请选择--</option>");
			}
		}
	});
}

function setIslandName(){
	var areaName=$("#area_id").find("option:selected").text();  
	var areaId = $("#area_id").val();
	var caseType = $("#case_type").val();
	$("#area_name").val(areaName);
	
	
	$.ajax({
		type:"get",
		url:"${ctx}/customercase/ctmpkg/ctmcasepkg!getIslandByAreaId.action?areaId="+areaId+"&csType="+caseType,
		dataType:"json",
		success:function(json){
			if(json.length > 0){
				$("#island_id").find("option").remove();
				$("#island_id").prepend("<option value='0'>--请选择--</option>");
				for( var i=0 ; i<json.length; i++){
					$("#island_id").append("<option value='"+json[i].id+"'>"+json[i].name+"</option>");
				}
			}else{
				$("#island_id").find("option").remove();
				$("#island_id").prepend("<option value='0'>--请选择--</option>");
			}
			
		}
	});
}

function setChildName(){
	var caseType = $("#case_type").val();
	var areaId = $("#area_id").val();
	var islandName=$("#island_id").find("option:selected").text();  
	var islandId = $("#island_id").val();
	$("#island_name").val(islandName);
	
	$.ajax({
		type:"get",
		url:"${ctx}/customercase/ctmpkg/ctmcasepkg!getChildType.action?islandId="+islandId+"&areaId="+areaId+"&csType="+caseType,
		dataType:"json",
		success:function(json){
			if(json.length > 0){
				$("#child_id").find("option").remove();
				$("#child_id").prepend("<option value='0'>--请选择--</option>");
				for( var i=0 ; i<json.length; i++){
					$("#child_id").append("<option value='"+json[i].id+"'>"+json[i].title+"</option>");
				}
			}else{
				$("#child_id").find("option").remove();
				$("#child_id").prepend("<option value='0'>--请选择--</option>");
			}
			
		}
	});
}

function setChildTypeName(){
	var childName=$("#child_id").find("option:selected").text();  
	$("#child_name").val(childName);
}

function editBase(){
	$("#_copy_content").val(editor.html());
	$("#form").submit();
}	

</script>
</html>