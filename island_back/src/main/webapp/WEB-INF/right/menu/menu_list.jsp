<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台菜单列表</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>

<table class="searchbar" width="100%">
	<thead>
		 <tr>
			<td><font size="3" color="red">当前位置:权限管理--后台菜单管理</font></td>
		</tr>
	</thead>
</table>
<table class="customlist" width="100%">
	<thead>
		<tr>
			<td>
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
							<td>菜单名称</td>
							<td>菜单url</td>
							<td>父菜单编号</td>
							<td>菜单编号</td>
							<td>显示次序</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="menu_list">
						<c:forEach var="menu" items="${menuList}">
							<tr>
								<td>
									<c:out value="${menu.menuName}"></c:out>
								</td>
								<td>
									<c:out value="${menu.menuUrl}"></c:out>
								</td>
								<td>
									<c:out value="${menu.menuParent}"></c:out>
								</td>
								<td>
									<c:out value="${menu.id}"></c:out>
								</td>
								<td>
									<c:out value="${menu.showIndex}"></c:out>
								</td>		
								<td>
									<a title="${menu.id}" onclick="editMenu(this)" >修改</a>
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
	$(function(){
		
		bindEvent();
	});
	
	//绑定事件
	function bindEvent(){
		$("#new_create").bind('click',newCreate);
	}
	
	
	function newCreate(){
		var url = "${ctx}/right/menu/menu!toAdd.action";
		window.location.href = url;
	};
	
	function editMenu(ele){
		var menuId = $(ele).attr('title');
		var url =  "${ctx}/right/menu/menu!toEdit.action?menuId="+menuId;
		window.location.href = url; 
	}
	
</script>
</html>