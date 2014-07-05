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
	
	
	<tbody>
		<tr>
			<td colspan="2">
				<!--表内容-->
				<table class="datalist ask_rel" width="100%">
					<thead>
						<tr>
							<td>所属区域</td>
							<td>所属国家</td>
							<td>岛屿名称</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="role_list">
						<c:forEach var="island" items="${islandList}">
							<tr>
								<td>
									<c:out value="${island.name}"></c:out>
								</td>
								<td>
									<c:out value="${island.areaName}"></c:out>
								</td>
								<td>
									<c:out value="${island.country}"></c:out>
								</td>
								<%-- <td>
									<c:out value="${island.islandDesc}"></c:out> 
								</td> --%>
								<td>
									<a title="${island.id}" onclick="editImg(this)" >地图图片维护</a>&nbsp;|&nbsp;
									<a title="${island.id}"  onclick="editLng(this)">地图坐标维护</a>&nbsp;&nbsp;
									<a title="${island.id}"  onclick="seeMap(this)">查看效果</a>&nbsp;&nbsp;
								</td>							
						    </tr>
					    </c:forEach>
					</tbody>
				</table>
			</td>
		</tr>

	</tbody>
</table>
<input type="hidden" id="packageType" name="islandMap.packageType" value="${packageType}"/>

</body>
<script>
	
	
	
	function editImg(ele){
		var id = $(ele).attr('title');
		var packageType = $("#packageType").val();
		var url ="${ctx}/wedfront/islandmap!toAddImg.action?islandId="+id+"&packageType="+packageType;
		window.location.href = url; 
	}
	
	function editLng(ele){
		var id = $(ele).attr('title');
		var packageType = $("#packageType").val();
		
		
		$.ajax({
			type:"get",
			url:"${ctx}/wedfront/islandmap!checkHasBackImg.action?islandId="+id+"&packageType="+packageType,
			dataType:"text",
			success:function(json){
				if( json == "has"){
					var url ="${ctx}/wedfront/islandmap!toLngList.action?islandId="+id+"&packageType="+packageType;
					window.location.href = url; 
				}else{
					alert("请先设置背景图片");
				}
			}
		});
		
	}
	
	function seeMap(ele){
		var id = $(ele).attr('title');
		var packageType = $("#packageType").val();
		var url ="${ctx}/wedfront/islandmap!seeMap.action?islandId="+id+"&packageType="+packageType;
		window.location.href = url; 
	}
	
</script>
</html>