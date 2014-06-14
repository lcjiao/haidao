<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页咨询内容修改</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<form action="${ctx}/front/newconsult/newconsult!edit.action" enctype="multipart/form-data" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>展示列</td>
			<td>  
				<select id="typeId" name="typeId">
					<option value="1" selected="selected">--第一列--</option>
					<option value="2">--第二列--</option>
				</select>
			</td>					
		</tr>
		<tr>
			<td>标题</td>
			<td><input type=text class="text" value="${title}" id="title" name="title"  style="width:255px;"/></td>					
		</tr>
		<tr>
			<td>链接地址</td>
			<td><input type=text class="text" value="${link}" id="link" name="link"  style="width:255px;"/></td>					
		</tr>
		<tr>
			<td>时间</td>
			 <td><input type="text" id = "time"  value="${time}"  class="Wdate" onfocus="WdatePicker()" name="time"/></td>
		 </tr>
		<tr>
			<td>排序</td>
			<td><input type=text class="text" value="${index}" id="index_num" name="index"  style="width:255px;"/><!-- <span style="color:red;">顺序调整为对调方式</span> --></td>
		</tr>
		<tr>
			<td>上传图片</td>
			<td><input type="file" name="image"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" id="id" name="id" value="${id}"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<tr>
		<td><input type=button  value="更新" id="save"/><input type=button  value="返回" id="reset"/></td>
		</tr>
	</tfoot>
</table>
</form>
</body>
<script>
	$(function(){
		var typeId = '${typeId}';
		$("#typeId option[value='"+typeId+"']").attr('selected',true);
		
		$("#save").bind('click',submitSave);
		$("#reset").bind('click',resetCreate);
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
	
	function resetCreate(){
		var url = "${ctx}/front/newconsult/newconsult!list.action";
		window.location.href = url;
	}
	//表单提交前数据验证
	function checkData(){
		var r = /^[0-9]+$/;
		var index_num = $("#index_num").val();
		if(!r.test(index_num)){
			alert('排序只能为数字');
			return false;
		}else{
			return true;
		}
	}	
	
</script>
</html>