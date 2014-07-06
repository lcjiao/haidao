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
<script type="text/javascript">
$(function(){
	$(".st_tree").SimpleTree({
		click:function(a){
			var url =$(a).attr("href");
			
			if(!$(a).attr("hasChild")){
				$(a).attr("ref");
			}
			if(url.length < 10 ){
				
			}else{
				var menuId = ($(a).attr('title'));
				if( menuId ==38 || menuId == 54 || menuId == 65){
					url = url +"&menuId="+menuId;
					window.top.mainFrame.location.href=url;
				}else{
					if( url.indexOf("?") != -1 ){
						url = url +"&menuId="+menuId;
					}else{
						url = url +"?menuId="+menuId;
					}
					
					window.top.mainFrame.location.href=url;
				}
				
			}
			
			
		}
	});
});
</script>
</head>
<body>
<div id="mainpanel">
<div class="st_tree">
<ul>
	<c:forEach var="parent" items="${menuList}">
			<li><a title="parent" href="${parent.menuUrl}"><c:out value="${parent.menuName}"></c:out></a></li>
			<ul>
					<c:forEach var="son" items="${parent.childList}">
						 <li><a target="mainFrame" href="${son.menuUrl}" title="${son.id}"><c:out value="${son.menuName}"></c:out></a></li>
						<ul>
							<c:forEach var="three" items="${son.childList}">
						 		<li><a target="mainFrame" href="${three.menuUrl}" title="${three.id}"><c:out value="${three.menuName}"></c:out></a></li>
							</c:forEach>
						</ul>
					</c:forEach>
		    </ul>
	 </c:forEach>
	
</ul>
</div>
</div>
</body>
</html>