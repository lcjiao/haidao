<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>疑难解答</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<%@ include file="/common/kindeditor.jsp"%>
</head>
<body>
<form action="${ctx}/globalqa/globalqa/globalqa!edit.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>所属类型</td>
			<td>
			<select id="type_id" name="globalQa.questionType">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="qaType" items="${globalQaTypeList}">
							<option value="${qaType.id}" >${qaType.typeName}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>问题</td>
			<td><textarea style="width:700px;height:50px;" class="text" id="question" name="globalQa.title"  style="_width:316px;">${globalQa.title}</textarea></td>					
		</tr>
		<tr>
			<td>解答</td>
			<td>
				<textarea name="content" style="width:700px;height:200px;">${globalQa.answer}</textarea>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${globalQa.answer}" id="answer" name="globalQa.answer"/>
<input type="hidden" value="${globalQa.id}" id="id" name="globalQa.id"/>

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
	var typeId = '${globalQa.questionType}';
	$("#type_id option[value='"+typeId+"']").attr('selected',true);
	
});

function checkData(){
	$("#answer").val(editor.html());
	$("#form").submit();

}

function resetData(){
	var link = "${ctx}/globalqa/globalqa/globalqa!tolist.action";
	window.location.href = link; 
}	
</script>
</html>