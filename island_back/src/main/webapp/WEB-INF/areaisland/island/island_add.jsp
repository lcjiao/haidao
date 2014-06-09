<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建区域</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>


<%@ include file="/common/kindeditor.jsp"%>
	<%-- <style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		<link rel="stylesheet" href="${ctx}/kindeditor/themes/default/default.css" />
		<script charset="utf-8" src="${ctx}/kindeditor/kindeditor-min.js"></script>
		<script charset="utf-8" src="${ctx}/kindeditor/lang/zh_CN.js"></script>
		<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
		</script> --%>	
		

</head>
<body>
<form action="${ctx}/areaisland/island/island!addIsland.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>岛屿名称</td>
			<td><input type=text class="text" value="" id="island_name" name="name"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>所属区域</td>
			<td>
			<select id="area_id" name="areaId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>所属国家</td>
			<td>
			<select id="country" name="country">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="country" items="${countryList}">
							<option value="${country.name}">${country.name}</option>
				   </c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>岛屿简介</td>
			<td>
				<textarea name="content" style="width:700px;height:200px;">KindEditor1</textarea>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save"/>
		 </td>
</tfoot>
</table>
<input type="hidden" id="area_name" name="areaName" value=""/>
<input type="hidden" id="island_desc" name="desc" value=""/>
</form>
</body>
<script>
	$(function(){
		$("#area_id").bind('change',setAreaName);
		$("#save").bind('click',submitSave);
		$("#reset").bind('click',resetCreate);
		$('input[type="button"],input[type="checkbox"],input[type="radio"]').css({
		    'cursor':'pointer'});
		//ie 按钮修正 input type=button:文本垂直对齐
	    if ($.browser.msie && ($.browser.version <9) && !$.support.style) {
			$('input[type="button"]').addClass('ie6btn');
			$('ul.outwindiv').css({'width':'325','top':'20px'});
	    }
		  
	});
	
	function submitSave(){
		$("#island_desc").val(editor.html());
		if( checkData() ){
			$("#form").submit();
		}
	}
	
	//表单提交前数据验证
	function checkData(){
		var role_name = $("#island_name").val();
		if(role_name == ''){
			alert('请输入岛屿名称');
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