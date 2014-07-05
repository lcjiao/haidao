<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>岛屿坐标</title>
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
			<td align="right" class="tdr">
				<input type="button" value="返回" id="reset_btn"/>
				<input type="button" value="新建" id="new_create"/>
			</td>
		</tr>
	</thead>
	
	<tbody>
		<tr>
			<td colspan="2">
				<!--表内容-->
				<table class="datalist ask_rel" width="100%">
					<thead>
						<tr>
							<td>距离顶端百分值</td>
							<td>距离左边百分值</td>
							<td>坐标点描述</td>
							<td>坐标点链接</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="role_list">
						<c:forEach var="lng" items="${islandMapList}">
							<tr>
								<td>
									<c:out value="${lng.mapTop}"></c:out>
								</td>
								<td>
									<c:out value="${lng.mapLeft}"></c:out>
								</td>
								<td>
									<c:out value="${lng.mapDesc}"></c:out>
								</td>
								<td>
									<c:out value="${lng.linkUrl}"></c:out>
								</td>
								<%-- <td>
									<c:out value="${island.islandDesc}"></c:out> 
								</td> --%>
								<td>
									<a title="${lng.id}"  onclick="editLng(this)">修改</a>&nbsp;&nbsp;
									<a title="${lng.id}"  onclick="delLng(this)">删除</a>&nbsp;&nbsp;
								</td>							
						    </tr>
					    </c:forEach>
					</tbody>
				</table>
			</td>
		</tr>

	</tbody>
</table>
<input type="hidden" id="packageType" name="packageType" value="${packageType}"/>
<input type="hidden" id="island_id" name="islandId" value="${islandId}"/>
</body>
<script>
	
	$(function(){
		bindEvent();
	});
	
	//绑定事件
	function bindEvent(){
		$("#new_create").bind('click',newCreate);
		$("#reset_btn").bind('click',resetData);
		
	}
	
	
	function newCreate(){
		var id = $("#island_id").val();
		var packageType = $("#packageType").val();
		var url ="${ctx}/wedfront/islandmap!toAddLng.action?islandId="+id+"&packageType="+packageType;
		window.location.href = url; 

	};
	
	
	function editLng(ele){
		var id = $(ele).attr('title');
		var packageType = $("#packageType").val();
		var islandId = $("#island_id").val();
		var url ="${ctx}/wedfront/islandmap!toEditLng.action?id="+id+"&packageType="+packageType+"&islandId="+islandId;
		window.location.href = url; 
	}
	
	function delLng(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var id = $(ele).attr('title');
			var packageType = $("#packageType").val();
			var islandId = $("#island_id").val();
			var url ="${ctx}/wedfront/islandmap!delMapLng.action?id="+id+"&packageType="+packageType+"&islandId="+islandId;
			window.location.href = url; 
		}
		
	}
	
	function resetData(){
		var packageType = $("#packageType").val();
		var url =  "${ctx}/wedfront/islandmap!list.action?packageType="+packageType;
		window.location.href = url; 
	}
	
</script>
</html>