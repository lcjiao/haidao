<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>

<form action="${ctx}/wdpphototeam/teampackage/teampkg!addworkman.action"   id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td width="48">摄影类型</td>
			<td width="10">
				<select id="work_type" name="workman.workType">
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
			<td><input type="text" name="workman.name" id="p_title" value=""/></td>					
		</tr>
		<tr>
			<td>淡季价格</td>
			<td><input type="text" name="workman.priceSmall" id="p_s_price" value=""/></td>					
		</tr>
		<tr>
			<td>旺季价格</td>
			<td>
				<input type="text" name="workman.priceBig" id="p_b_price" value=""/>
			</td>					
		</tr>
		<tr>
			<td>简介</td>
			<td>
				<textarea name="content" style="width:700px;height:200px;"></textarea>
				<input type="hidden" id="_copy_content" name="workman.content" />
			</td>
		</tr>
	</tbody>	
</table>
</div>

<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="保存并返回" id="add_base" onclick="addBaseAndToList()"/>
			<input type=button  value="保存并添加详情" id="add_detail" onclick="addBaseAndToDetail()"/>
			<input type="hidden" id="flag" name="flag" value="">
		</td>
</tfoot>
</table>
</form>

</body>
<script>

function addBaseAndToList(){
	$("#flag").val("toList");
	$("#_copy_content").val(editor.html());
	$("#form").submit();
}	

function addBaseAndToDetail(){
	$("#flag").val("toDetail");
	$("#_copy_content").val(editor.html());
	$("#form").submit();
}	
</script>
</html>