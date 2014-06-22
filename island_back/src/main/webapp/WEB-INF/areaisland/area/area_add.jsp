<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建区域</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/areaisland/area/area!addArea.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>区域名称</td>
			<td><input type=text class="text" value="" id="area_name" name="name"  style="_width:316px;"/></td>					
		</tr>
		
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td><input type=button  value="保存" id="save"/>
		   <input type=button  value="返回" id="reset"/> 
		  </td>
</tfoot>
</table>
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
		if( checkData() ){
			$("#form").submit();
		}
	}
	
	//表单提交前数据验证
	function checkData(){
		var role_name = $("#area_name").val();
		if(role_name == ''){
			alert('请输入区域名称');
			return false;
		}
		return true;
		
	}
	
	function resetData(){
		var url =  "${ctx}/areaisland/area/area!list.action";
		window.location.href = url; 
	}
	
</script>
</html>