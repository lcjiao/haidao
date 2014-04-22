<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台角色列表</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>

<table class="customlist" width="100%">
	<thead>
		<tr>
			<td>
				<%-- <div id="pagebar"> 
					<div id="page"></div>

					<code>共<strong id="total_page_size">${totalPageSize}</strong>页&nbsp;<strong>${totalSize}</strong>条记录</code>
					<div id="go_page">
					<input type="text" class="num numonly" size="6" id="go_no" value=""/>
					<input type="button" value="GO" id="go"/>
					</div>
				</div> --%>
			</td>
			<td align="right" class="tdr"><input type="button" value="新建" id="new_create"/></td>
		</tr>
	</thead>
	
	<tbody>
		<tr>
			<td colspan="2">
				<!--表内容-->
				<table class="datalist ask_rel" width="100%">
					<thead>
						<tr>
							<td>角色名称</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="role_list">
						<c:forEach var="role" items="${roleList}">
							<tr>
								<td>
									<c:out value="${role.roleName}"></c:out>
								</td>
								<td>
									<a title="${role.id}" onclick="editRole(this)" >修改</a>&nbsp;|&nbsp;
									<a title="${role.id}"  onclick="delRole(this)">删除</a>&nbsp;|&nbsp;
									<a title="${role.id}" onclick="changeRight(this)">权限管理</a>
								</td>							
						    </tr>
					    </c:forEach>
					</tbody>
				</table>
			</td>
		</tr>

	</tbody>
</table>
</body>
<script>
	var  numCat = /^[1-9]*$/;
	$(function(){
		
		
		bindEvent();
	});
	
	//绑定事件
	function bindEvent(){
		$("#new_create").bind('click',newCreate);
		
		/* $("#question_list a[title]").each(function(i){
			$(this).bind('click',hideQuestion());
		}); */
	}
	
	
	function newCreate(){
		var url = "${ctx}/right/role/role!toAdd.action";
		window.location.href = url;
	};
	
	function delRole(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var roleId = $(ele).attr('title');
			$.ajax({
				type:"get",
				url:"${ctx}/right/backuser/backuser!getUserByRole.action?roleId="+roleId,
				dataType:"text",
				success:function(text){
					if(text == "has"){
						alert("该角色下拥有用户禁止删除");
					}else{
						var url = "${ctx}/right/role/role!delRole.action?roleId="+roleId;
						window.location.href = url; 
					}
					
				}
			});
			
		}
	}
	
	function editRole(ele){
		var roleId = $(ele).attr('title');
		var url =  "${ctx}/right/role/role!toEdit.action?roleId="+roleId;
		window.location.href = url; 
	}
	
	function changeRight(ele){
		var roleId = $(ele).attr('title');
		var url = "${ctx}/right/roleright/roleright!manager.action?roleId="+roleId;
		window.location.href = url;
	}
</script>
</html>