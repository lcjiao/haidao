<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐详细信息维护页</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>


<%@ include file="/common/kindeditor.jsp"%>

</head>
<body>
<%@ include file="/common/menu.jsp"%>
<form action="${ctx}/hotel/package/package!managerDetail.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>套餐详情</td>
			<td>
				<textarea name="content" style="width:300px;height:400px;"><c:out value="${detailInfo}"></c:out></textarea>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<c:if test="${actionType ==3}">
				<input type=button  value="保存" id="save_back"/>
			</c:if>
			<c:if test="${actionType==4}">
				<input type=button  value="提交" id="save"/>
				<input type=button  value="返回" id="reset"/>
			</c:if>
			
		 </td>
</tfoot>
</table>
<input type="hidden" id="p_id" name="id" value="${id}"/>
<input type="hidden" id="p_detail" name="detailInfo" />
</form>
</body>
<script>
	$(function(){
		$("#save").bind('click',submitSave);
		$("#save_back").bind('click',saveBack);
		//$("#save_add_img").bind('click',saveAddImg);
		$("#reset").bind('click',back);
		
		//ie 按钮修正 input type=button:文本垂直对齐
	    if ($.browser.msie && ($.browser.version <9) && !$.support.style) {
			$('input[type="button"]').addClass('ie6btn');
			$('ul.outwindiv').css({'width':'325','top':'20px'});
	    }
		  
	});
	
	function submitSave(){
		$("#p_detail").val(editor.html());
		$("#form").submit();
	}
	function saveBack(){
		$("#p_detail").val(editor.html());
		$("#form").submit();
	}
	function back(){
		var url = "${ctx}/hotel/package/package!back.action";
		window.location.href = url; 
	}
	function saveAddImg(){
		var url = "${ctx}/hotel/package/package!back.action";
		window.location.href = url; 
	}
</script>
</html>