<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐辅推产品</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>
<%@ include file="/common/menu.jsp"%>
<form action="${ctx}/hotel/secondpackage/secondpackagerecommend!tolist.action" id="form" method="post">
<table class="searchbar" width="100%">
	<tbody>
		<tr>
			<td width="48">所属岛屿</td>
			<td width="10">
				<select id="island_id" name="recommend.islandId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
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
							<td>岛屿</td>
							<td>标题</td>
							<td>描述</td>
							<td>图片</td>
							<td>链接</td>
							<td>排序</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="r_list">
						<c:forEach var="recommend" items="${recommendList}">
							<tr >
								<td style="text-align:center;">
									<c:out value="${recommend.islandName}"></c:out>
								</td>
								<td style="text-align:center;" title="${recommend.title}">
									<%-- <c:out value="${recommend.title}"></c:out> --%>
									<c:out value="${fn:substring(recommend.title,0,20)}"/>
								</td>
								<td style="text-align:center;" title="${recommend.recommendDesc}">
									<%-- <c:out value="${recommend.recommendDesc}"></c:out> --%>
									<c:out value="${fn:substring(recommend.recommendDesc,0,20)}"/>
									<%-- <input style="width:50px;" type="text" value="${recommend.recommendIndex}" id="r_index" name="index">
								 --%></td>
								<td style="text-align:center;">
									<img style="width:150px;height:120px;" alt="" src="${recommend.imgUrl}">
								</td>
								<td style="text-align:center;">
									<c:out value="${recommend.linkUrl}"></c:out>
								</td>
								<td style="text-align:center;">
									<c:out value="${recommend.recommendIndex}"></c:out>
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
	
	
	function findByNo(pageNo){
		//var url = "${ctx}/hotel/secondpackage/secondpackagerecommend!tolist.action?pageNo="+pageNo;
		//window.location.href = url;
		$("#page_no").val(pageNo);
		$("#form").submit();
	}
	
	
	function newCreate(){
		var url = "${ctx}/hotel/secondpackage/secondpackagerecommend!toAdd.action";
		window.location.href = url;
	};
	
	function del(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var recommendId = $(ele).attr('title');
			var url = "${ctx}/hotel/secondpackage/secondpackagerecommend!del.action?id="+recommendId;
			window.location.href = url; 
		}
	}
	
	function edit(ele){
		var recommendId = $(ele).attr('title');
		var url =  "${ctx}/hotel/secondpackage/secondpackagerecommend!toEdit.action?id="+recommendId;
		window.location.href = url; 
	}
	
	
</script>
</html>