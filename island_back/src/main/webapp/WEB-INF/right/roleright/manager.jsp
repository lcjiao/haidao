<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setAttribute("ctx",request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海岛后台管理系统</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/page.css' type="text/css" media="all" />

<link rel="stylesheet" type="text/css" href="${ctx}/js_/tree_themes/SimpleTree.css"/>
<script type="text/javascript" src="${ctx}/js_/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${ctx}/js_/SimpleTree.js"></script>
</head>
<body>
<%@ include file="/common/menu.jsp"%>
<div id="mainpanel">
<div class="st_tree">
	<ul>
		<c:forEach var="parent" items="${menuList}">
			<li><a href="${parent.menuUrl}"><c:out value="${parent.menuName}"></c:out></a></li>
			<ul>
					<c:forEach var="son" items="${parent.childList}">
						 <li><a href="${son.menuUrl}" class="test" title="${son.id}"><c:out value="${son.menuName}"></c:out></a><c:if test="${son.haschild ==0}"><input type="checkbox"></c:if></li>
						 <ul>
						 	<c:forEach var="three" items="${son.childList}">
						 		<li><a href="${three.menuUrl}" class="test" title="${three.id}"><c:out value="${three.menuName}"></c:out></a><input type="checkbox"></li>
							</c:forEach>
						 </ul>
					</c:forEach>
		    </ul>
		</c:forEach>
	</ul>
</div>
</div>
<form action="${ctx}/right/role/role!addRight.action" id="form" method="post">
	<input type="hidden" id="role_id" name="roleId" value="${roleId}"/>
	<input type="hidden" id="right_ids" name="rightIds" value=""/>
</form>
<input type="button" value="提交权限" id="btn"/>
</body>
<script type="text/javascript">

var str = "${menuIds}";

var menuIds = "";


$(function(){
	$(".st_tree").SimpleTree({
		click:function(a){
			if(!$(a).attr("hasChild"))
				$(a).attr("ref");
		}
	});
	
	$(":checkbox").each(function(i){
		var $parent = $(this).parent();
		var $a = $($parent).find("a");
		var menu_id = $($a).attr('title');
		var arr = str.split(",");
		for(i=0;i<arr.length;i++){
			if(arr[i] == menu_id){
				$(this).attr("checked","true");
			}
		}
		
	});
	
	
	
	
	$("#btn").bind('click',changeRight);
	
});
	
	function changeRight(){
		menuIds = "";
		$(":checked").each(function(i){
			var $parent = $(this).parent();
			var $a = $($parent).find("a");
			var menu_id = $($a).attr('title');
			menuIds = menuIds + menu_id +",";
			
		});
		$("#right_ids").val(menuIds);
		$("#form").submit();
	}
</script>
</html>