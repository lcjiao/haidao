<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>国家维护</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
</head>
<body>
<form action="${ctx}/globalnet/country/country!edit.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>区域</td>
			<td>
			<select id="area_id" name="country.areaId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>国家</td>
			<td><input type=text class="text" value="${country.name}" id="name" name="country.name"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${country.id}" id="id" name="country.id"/>
<input type="hidden" value="${country.areaName}" id="country_area_name" name="country.areaName"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="reset" onclick="resetData()"/>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>

$(function(){
	var areaId = '${country.areaId}';
	$("#area_id option[value='"+areaId+"']").attr('selected',true);
	$("#area_id").bind('change',setAreaName);
});

function setAreaName(){
	var areaName=$("#area_id").find("option:selected").text();  
	$("#country_area_name").val(areaName);
	
}
function checkData(){
	$("#form").submit();

}
function resetData(){
	var url =  "${ctx}/globalnet/country/country!tolist.action";
	window.location.href = url; 
}
</script>
</html>