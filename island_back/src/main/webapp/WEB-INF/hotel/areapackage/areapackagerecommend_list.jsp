<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐区域产品</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>
<%@ include file="/common/menu.jsp"%>
<form action="${ctx}/hotel/areapackage/areapackagerecommend!tolist.action" id="form" method="post">
<table class="searchbar" width="100%">
	<tbody>
		<tr>
			<td width="48">所属区域</td>
			<td width="10">
				<select id="area_id" name="recommend.areaId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="area" items="${areaList}">
							<option value="${area.id}" >${area.name}</option>
				   </c:forEach>
				</select>
			</td>
			<td width="48">所属岛屿</td>
			<td width="10">
				<select id="island_id" name="recommend.islandId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
			</td>
			<td width="48">
				每页显示数：
			</td>
			<td width="10">
				<input type="text" class="text" value="${pageSize }" id="page_size" name="pageSize" style="_width:316px;"/>
			</td>
			<td><input class="btn" type="button" value="搜索" id="search"/>
			</td>
		</tr>
	</tbody>
</table>
<input type="hidden" value="${pageNo}" name="pageNo" id="page_no"/>
</form>

<table class="customlist" width="100%">
	<thead>
		<tr>
			<td>
				<div id="pagebar"> 
					<div id="page"></div>

					<code>共<strong id="total_page_size">${totalPageSize}</strong>页&nbsp;<strong>${totalSize}</strong>条记录</code>
					<div id="go_page">
					<input type="text" class="num numonly" size="6" id="go_no" value=""/>
					<input type="button" value="GO" id="go"/>
					</div>
				</div>
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
							<td>区域</td>
							<td>岛屿</td>
							<td>标题</td>
							<td>旺季价格</td>
							<td>淡季价格</td>
							<td>图片</td>
							<td>链接</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="r_list">
						<c:forEach var="recommend" items="${recommendList}">
							<tr >
								<td style="text-align:center;">
									<c:out value="${recommend.areaName}"></c:out>
								</td>
								<td style="text-align:center;">
									<c:out value="${recommend.islandName}"></c:out>
								</td>
								<td style="text-align:center;" title="${recommend.title}">
									<%-- <c:out value="${recommend.title}"></c:out> --%>
									<c:out value="${fn:substring(recommend.title,0,20)}"/>
								</td>
								<td style="text-align:center;">
									<c:out value="${recommend.priceBig}"></c:out>
								</td>
								<td style="text-align:center;">
									<c:out value="${recommend.priceSmall}"></c:out>
								</td>
								<td style="text-align:center;">
									<img style="width:150px;height:120px;" alt="" src="${recommend.imgUrl}">
								</td>
								<td style="text-align:center;">
									<c:out value="${recommend.linkUrl}"></c:out>
								</td>
								<td style="text-align:center;">
									<a title="${recommend.id}" onclick="edit(this)" >修改</a>&nbsp;|&nbsp;
									<a title="${recommend.id}" onclick="del(this)">删除</a>
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
		loadPage();
		
		initParam();
		
		bindEvent();
	});
	
	//绑定事件
	function bindEvent(){
		$("#go").bind('click',gotoPageNo);
		$("#new_create").bind('click',newCreate);
		$("#search").bind('click',search);
		$("#area_id").bind('change',setAreaName);
		//$("#island_id").bind('change',setIslandName);
		/* $("#question_list a[title]").each(function(i){
			$(this).bind('click',hideQuestion());
		}); */
	}
	
	function loadPage(){
		//加载分页控件
		var html = pageCustomize('${pageNo}','${totalPageSize}');
		$("#page").html("");
		$("#page").html(html);
	}
	
	//初始化参数
	function initParam(){
		
		var totalPageSize = '${totalPageSize}';
		if(totalPageSize < 2){
			$("#go_page").hide();
		}else{
			$("#go_page").hide();
		}
		
		var areaId = '${recommend.areaId}';
		$("#area_id option[value='"+areaId+"']").attr('selected',true);
		
		
		var islandId = '${recommend.islandId}';
		$("#island_id option[value='"+islandId+"']").attr('selected',true);
		
		
	}
	
	
	//分页跳转
	function gotoPage(pageNo){
		findByNo(pageNo);
	}
	
	//指定页数跳转
	function gotoPageNo(){
		var pageNo = $("#go_no").val();
		var maxNo = $("#total_page_size").text();
		var isNum = numCat.test(pageNo);
		if( isNum == false ){
			alert('请输入数字');
			return;
		}
		if(pageNo < 1 ){
			alert('请输入正确页数');
			return;
		}
		if(pageNo > maxNo){
			alert('请输入正确页数');
			return;
		}
		findByNo(pageNo);
	}
	
	//点击搜索
	function search(){
		
		findByNo(1);
	}
	
	function setAreaName(){
		var areaName=$("#area_id").find("option:selected").text();  
		var areaId = $("#area_id").val();
		$("#area_name").val(areaName);
		
		$.ajax({
			type:"get",
			url:"${ctx}/hotel/areapackage/areapackagerecommend!getIslandByArea.action?areaId="+areaId,
			dataType:"json",
			success:function(json){
				if( json.length > 0){
					var html = "";
					html +="<option value='0' selected='selected'>--请选择--</option>";
					for( var i=0 ; i<json.length; i++){
						html +="<option value='"+json[i].id+"'>"+json[i].name+"</option>";
					}
					$("#island_id").html(html);
				}else{
					var html = "";
					html +="<option value='0' selected='selected'>--请选择--</option>";
					$("#island_id").html(html);
				}
			}
		});
	}

	function setIslandName(){
		var islandName=$("#island_id").find("option:selected").text();  
		$("#island_name").val(islandName);
		
	}

	function findByNo(pageNo){
		//var url = "${ctx}/hotel/secondpackage/secondpackagerecommend!tolist.action?pageNo="+pageNo;
		//window.location.href = url;
		$("#page_no").val(pageNo);
		$("#form").submit();
	}
	
	
	function newCreate(){
		var url = "${ctx}/hotel/areapackage/areapackagerecommend!toAdd.action";
		window.location.href = url;
	};
	
	function del(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var recommendId = $(ele).attr('title');
			var url = "${ctx}/hotel/areapackage/areapackagerecommend!del.action?id="+recommendId;
			window.location.href = url; 
		}
	}
	
	function edit(ele){
		var recommendId = $(ele).attr('title');
		var url =  "${ctx}/hotel/areapackage/areapackagerecommend!toEdit.action?id="+recommendId;
		window.location.href = url; 
	}
	
	
</script>
</html>