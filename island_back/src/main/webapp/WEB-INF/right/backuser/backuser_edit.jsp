<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑后台用户</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>

</head>
<body>
<form action="${ctx}/right/backuser/backuser!updUser.action" id="form" method="post">
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>用户名</td>
			<td><input type=text class="text" value="${userName}" id="user_name" name="userName"  style="_width:316px;"/></td>					
		</tr>
		<!-- <tr>
			<td>用户密码</td>
			<td><input type=password class="text" value="" id="user_pass" name="userPass"  style="_width:316px;"/></td>					
		</tr> -->
		<tr>
			<td>用户角色</td>
			<td>
				<select id="role_sel" name="roleId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="role" items="${roleList}">
							<option value="${role.id}" >${role.roleName}</option>
				   </c:forEach>
				</select>
			</td>					
		</tr>
	</tbody>	
</table>
</div>
<input type="hidden" value="${roleName}" id="role_name" name="roleName" />
<input type="hidden" value="${userId}" name="userId"/>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td><input type=button  value="保存" id="save"/><input type=button  value="返回" id="reset"/></td>
</tfoot>
</table>
</form>
</body>
<script>
	$(function(){
		var roleId = '${roleId}';
		$("#role_sel option[value='"+roleId+"']").attr('selected',true);
		
		$("#save").bind('click',submitSave);
		$("#reset").bind('click',resetCreate);
		$("#role_sel").bind('change',setRoleName);
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
	
	function resetCreate(){
		var url = "${ctx}/right/backuser/backuser!reset.action?pageSize=10";
		window.location.href = url;
	}
	
	function setRoleName(){
		
		var checkText=$("#role_sel").find("option:selected").text();  //获取Select选择的Text
		$("#role_name").val(checkText);
	}
	//表单提交前数据验证
	function checkData(){
		var user_name = $("#user_name").val();
		if(user_name == ''){
			alert('请输入用户名');
			return false;
		}
		var user_pass = $("#user_pass").val();
		if(user_pass == ''){
			alert('请输入用户密码');
			return false;
		}
		var role_id = $("#role_sel").val();
		if(role_id < 1){
			alert('请选择用户角色');
			return false;
		}
		return true;
		
	}
	
</script>
</html>