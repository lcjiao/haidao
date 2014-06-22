<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户咨询</title>
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
<form action="${ctx}/guestqa/guestqa!processAnswer.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>问题</td>
			<td><textarea style="width:700px;height:200px;" class="text" id="question" name="qestion"  style="_width:316px;">${question}</textarea></td>					
		</tr>
		<tr>
			<td>回复</td>
			<td>
				<textarea name="content" style="width:700px;height:200px;">${answer}</textarea>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="保存" id="save"/>
			<input type=button  value="返回" id="reset"/>
			
		 </td>
</tfoot>
</table>
<input type="hidden" id="answer" name="answer" value="${answer}"/>
<input type="hidden" id="id" name="id" value="${id}"/>
</form>
</body>
<script>
	$(function(){
		$("#save").bind('click',submitSave);
		$("#reset").bind('click',resetData);
		$('input[type="button"],input[type="checkbox"],input[type="radio"]').css({
		    'cursor':'pointer'});
		//ie 按钮修正 input type=button:文本垂直对齐
	    if ($.browser.msie && ($.browser.version <9) && !$.support.style) {
			$('input[type="button"]').addClass('ie6btn');
			$('ul.outwindiv').css({'width':'325','top':'20px'});
	    }
		  
	});
	
	function submitSave(){
		$("#answer").val(editor.html());
		$("#form").submit();
	}
	
	function resetData(){
		var link = "${ctx}/guestqa/guestqa!tolist.action";
		window.location.href = link; 
	}
	
	
</script>
</html>