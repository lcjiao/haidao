<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱套餐详细信息维护页</title>
<link rel="stylesheet"  href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet"  href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>


<%@ include file="/common/kindeditor.jsp"%>

</head>
<body>
<form action="${ctx}/weddingphoto/wdppackage/wdppackage!saveWdpDetail.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" style="width: 100%">
	<tbody>
		<tr>
			<td>套餐详情</td>
			<td>
				<textarea name="content" style="width:300px;height:400px;"><s:property value="pkgDetailInfo.content"/> </textarea>
				<input type="hidden" name="wdpPackage.id" value="${wdpPackage.id }"/>
				<input type="hidden" name="wdpPackage.packageType" value="${wdpPackage.packageType }"/>
				<input type="hidden" name="pkgDetailInfo.packageId" value="${wdpPackage.id }"/>
				<input type="hidden" name="pkgDetailInfo.packageType" value="${wdpPackage.packageType }"/>
				<input type="hidden" name="pkgDetailInfo.id" value="${pkgDetailInfo.id }"/>
				<input type="hidden" id="_copy_content" name="pkgDetailInfo.content" />
			</td>
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" style="width: 100%">
	<tfoot>
		<td>
			<c:if test="${actionType ==3}">
				<input type=button  value="保存" id="save_back"/>
			</c:if>
			<c:if test="${actionType==4}">
				<input type=button  value="提交" id="save"/>
				<input type=button  value="返回" id="reset" onclick="javascript:history.go(-1);"/>
			</c:if>
			
		 </td>
</tfoot>
</table>
<s:debug></s:debug>
</form>
</body>
<script>
	$(function(){
		$("#save").bind('click',submitSave);
		$("#save_back").bind('click',saveBack);
		//$("#save_add_img").bind('click',saveAddImg);
		//$("#reset").bind('click',back);
		
		//ie 按钮修正 input type=button:文本垂直对齐
	    if ($.browser.msie && ($.browser.version <9) && !$.support.style) {
			$('input[type="button"]').addClass('ie6btn');
			$('ul.outwindiv').css({'width':'325','top':'20px'});
	    }
		  
	});
	
	function submitSave(){
		$("#_copy_content").val(editor.html());
		$("#form").submit();
	}
	function saveBack(){
		$("#_copy_content").val(editor.html());
		$("#form").submit();
	}
	
	function saveAddImg(){
		var url = "${ctx}/weddingphoto/wdppackage/wdppackage!back.action";
		window.location.href = url; 
	}
</script>
</html>