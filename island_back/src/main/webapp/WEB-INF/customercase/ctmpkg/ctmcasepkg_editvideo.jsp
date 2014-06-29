<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import = "com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例视频修改页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmpkg/ctmcasepkg!editVideocase.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>视频logo图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
		
		<tr>
			<td>视频描述</td>
			<td><input type=text class="text" id="videodesc" name="casevm.videodesc" value="${casevm.videodesc }" style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>视频地址</td>
			<td><input type=text class="text" id="video_url" name="casevm.videourl" value="${casevm.videourl }" style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>链接地址</td>
			<td><input type=text class="text" id="video_link" name="casevm.videoLink" value="${casevm.videoLink }" style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="p_id" name="casevm.caseid" value='${casevm.caseid }'/>
<input type="hidden" id="_id" name="casevm.id" value='<s:property value="casevm.id"/>' />
<input type="hidden" id="img_url" name="casevm.logourl" value='<s:property value="casevm.logourl"/>' />
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<input type=button  value="修改" id="save" onclick="modifyData()"/>
			<input type=button  value="返回" id="_return" onclick="javascript:history.go(-1);"/>
		</td>
</tfoot>
</table>
</form>

</body>
<script>

function modifyData(){
	$("#form").submit();
}
</script>
</html>