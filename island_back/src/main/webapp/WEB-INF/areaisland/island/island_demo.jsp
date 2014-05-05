<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<style>
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
		</script>

</head>
<body>
	<form>
			<textarea id="test"name="content" style="width:700px;height:200px;visibility:hidden;">KindEditor</textarea>
			<input  type="button" onclick="test()">
	</form>
</body>
<script type="text/javascript">
	$(function(){
		
	});
	function test(){
		alert(1);
	}
</script>
</html>
