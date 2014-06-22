<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>密码重置</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<table class="searchbar" width="100%">
	<thead>
		 <tr>
			<td><font size="3" color="red">当前位置:密码修改页</font></td>
		</tr>
	</thead>
</table>
<form action="${ctx}/right/backuser/backuser!changePass.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>当前用户</td>
			<td><input type=text class="text" value="${userName}" id="user_name" name="userName"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>旧密码</td>
			<td><input type=text class="text" value="" id="old_pass" name="userPass"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>新密码</td>
			<td><input type=password class="text" value="" id="user_pass_1" name="newPass_1"  style="_width:316px;"/></td>					
		</tr>
		<tr>
			<td>新密码确认</td>
			<td><input type=password class="text" value="" id="user_pass_2" name="newPass"  style="_width:316px;"/></td>					
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td><input type=button  value="保存" id="save"/>
		<input type=button  value="返回" id="reset"/></td>
</tfoot>
</table>
</form>
</body>
<script>
	$(function(){
		$("#save").bind('click',submitSave);
		$("#reset").bind('click',resetData);
		var userName = '${userName}';
		$("#user_name").val(userName);
		$("#old_pass").val("");
		$("#user_pass_1").val("");
		$("#user_pass_2").val("");
		  
	});
	
	function submitSave(){
		if( checkData() ){
			$("#form").submit();
		}
	}
	
	function resetCreate(){
		var url = "${ctx}/right/backuser/backuser!reset.action?pageSize=10";
		window.location.href = url;
	}
	
	//表单提交前数据验证
	function checkData(){
		var user_pass = $("#old_pass").val();
		if(user_pass == ''){
			alert('请输入用户旧密码');
			return false;
		}
		
		var new_pass_one = $("#user_pass_1").val();
		if( new_pass_one == ''){
			alert('请输入用户新密码');
			return false;
		}
		
		var new_pass = $("#user_pass_2").val();
		if( new_pass == ''){
			alert('请输入用户新密码');
			return false;
		}
		
		
		$.ajax({
			type:"get",
			url:"${ctx}/right/backuser/backuser!changePass.action?userPass="+user_pass+"&newPass="+new_pass+"&newPassOne="+new_pass_one,
			dataType:"text",
			success:function(json){
				alert(json);
			}
		});
		return false;
		
	}
	
	function resetData(){
		var url =  "${ctx}/right/backuser/backuser!list.action";
		window.location.href = url; 
	}

	
</script>
</html>