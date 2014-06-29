<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例视频添加页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmpkg/ctmcasepkg!saveVideo.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>视频logo图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
		
		<tr>
			<td>视频描述</td>
			<td><input type=text class="text" id="videodesc" name="casevm.videodesc"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>视频地址</td>
			<td><input type=text class="text" id="video_url" name="casevm.videourl"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>链接地址</td>
			<td><input type=text class="text" id="video_link" name="casevm.videoLink"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="保存并返回" id="add_return" onclick="saveAndReturn()"/>
			<input type=button  value="保存并继续添加" id="add_continue" onclick="saveAndContinue()"/>
			<input type="hidden" id="flag" name="flag" value="">
			<input type="hidden" value="${ctmcase.id}" id="p_id" name="casevm.caseid"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>


function saveAndReturn(){
	$("#flag").val("return");
	$("#form").submit();
}	

function saveAndContinue(){
	$("#flag").val("continue");
	$("#form").submit();
}	

</script>
</html>