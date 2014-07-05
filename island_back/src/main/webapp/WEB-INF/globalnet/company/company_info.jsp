<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司信息维护页</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<%@ include file="/common/menu.jsp"%>
<form action="${ctx}/globalnet/company/company!manager.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>公司名称</td>
			<td><input type=text class="text" value="${company.name}" id="name" name="name"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>公司地址</td>
			<td><input type=text class="text" value="${company.address}" id="address" name="address"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>联系人</td>
			<td><input type=text class="text" value="${company.person}" id="person" name="person"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>联系电话－手机</td>
			<td><input type=text class="text" value="${company.tel}" id="tel" name="tel"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>联系电话－座机</td>
			<td><input type=text class="text" value="${company.phone}" id="phone" name="phone"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>网站地址</td>
			<td><input type=text class="text" value="${company.siteAddress}" id="mail" name="siteAddress"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>公司邮箱</td>
			<td><input type=text class="text" value="${company.mail}" id="mail" name="mail"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>公司qq</td>
			<td><input type=text class="text" value="${company.qq}" id="qq" name="qq"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>公司logo</td>
			<td><input type="file" name="image"/></td>					
		</tr>
		<tr>
			<td>公司简介</td>
			<td>
				<textarea name="content" style="width:700px;height:200px;"><c:out value="${company.introduction}"></c:out></textarea>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${company.id}" id="c_id" name="id"/>
<input type="hidden" value="<c:out value="${company.introduction}" />" id="intro" name="intro"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save" onclick="checkData()"/>
			<input style="display: none" type=button  value="继续添加" id="add_more"/>
			<!-- <input type=button  value="返回" id="reset"/> -->
		</td>
</tfoot>
</table>
</form>

</body>
<script>

function checkData(){
	$("#intro").val(editor.html());
	$("#form").submit();
}
</script>
</html>