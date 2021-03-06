<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>区域列表</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>
<%@ include file="/common/menu.jsp"%>
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
							<td>区域名称</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="role_list">
						<c:forEach var="area" items="${areaList}">
							<tr>
								<td>
									<c:out value="${area.name}"></c:out>
								</td>
								<td>
									<a title="${area.id}" onclick="editArea(this)" >修改</a>&nbsp;|&nbsp;
									<a title="${area.id}"  onclick="delArea(this)">删除</a>&nbsp;&nbsp;
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
		
	}
	
	
	function newCreate(){
		var url = "${ctx}/areaisland/area/area!toAdd.action";
		window.location.href = url;
	};
	
	function delArea(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var id = $(ele).attr('title');
			var url = "${ctx}/areaisland/area/area!del.action?id="+id;
			window.location.href = url; 
		}
	}
	
	function editArea(ele){
		var id = $(ele).attr('title');
		var url ="${ctx}/areaisland/area/area!toEdit.action?id="+id;
		window.location.href = url; 
	}
	
</script>
</html>