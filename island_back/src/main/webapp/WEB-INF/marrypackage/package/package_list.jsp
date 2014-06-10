<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐列表</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>
<form action="${ctx}/marrypackage/package/package!list.action" id="form" method="post">
<table class="searchbar" width="100%">
	<tbody>
		<tr>
			<td width="48">所属岛屿</td>
			<td width="10">
				<select id="island_id" name="islandId">
					<option value="0" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
			</td>
			<td width="48">套餐名称</td>
			<td width="10"><input type="text" name="title" value="${title}" id="sear_title"/></td>
			<td width="48">套餐价格</td>
			<td width="10"><input type="text" name="price" value="${price}" id="sear_price"/></td>
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
				<table class="datalist ask_rel" width="100%">
					<thead>
						<tr>
							<td>套餐名称</td>
							<td>所属区域</td>
							<td>所属岛屿</td>
							<td>淡季价格</td>
							<td>旺季价格</td>
							<td>是否在售</td>
							<td>是否热推</td>
							<td>操作</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<c:forEach var="package" items="${packageList}" varStatus="status">
							<tr>
								<td>${package.title}</td>
								<td>${package.areaName}</td>
								<td>${package.islandName}</td>
								<td>${package.priceSmall}</td>
								<td>${package.priceBig}</td>
								<td>${package.onlineStr}</td>
								<td>${package.hotStr}</td>
								<td width="100px">
									<a title="${package.id}" onclick="sethot(this)" >热推</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="resethot(this)" >取消热推</a>&nbsp;|&nbsp;
								</td>
								<td width="360px">
									<a title="${package.id}" onclick="editBase(this)" >基本信息管理</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="editDetail(this)" >详细信息管理</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="editImg(this)" >图片管理</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="editKepian(this)" >客片留影管理</a>&nbsp;|&nbsp;
									<a title="${package.id}"  onclick="delPackage(this)">删除</a>&nbsp;&nbsp;
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
		$("#search").bind('click',search);
		$("#go").bind('click',gotoPageNo);
		$("#new_create").bind('click',newCreate);
		
	}
	
	function loadPage(){
		//加载分页控件
		var html = pageCustomize('${pageNo}','${totalPageSize}');
		$("#page").html("");
		$("#page").html(html);
	}
	
	//初始化参数
	function initParam(){
		var islandId = '${islandId}';
		$("#island_id option[value='"+islandId+"']").attr('selected',true);
		var pageNo = '${pageNo}';
		if(pageNo < 2){
			$("#go_page").hide();
		}else{
			$("#go_page").show();
		}
		
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
		$("#page_no").val(pageNo);
		$("#form").submit();
	}
	
	function newCreate(){
		var url = "${ctx}/marrypackage/package/package!toAddBase.action";
		window.location.href = url;
	};
	
	function editBase(ele){
		var packageId = $(ele).attr('title');
		var url =  "${ctx}/marrypackage/package/package!toEditBase.action?id="+packageId;
		window.location.href = url; 
	}
	
	function editDetail(ele){
		var packageId = $(ele).attr('title');
		var url =  "${ctx}/marrypackage/package/package!toManagerDetail.action?id="+packageId;
		window.location.href = url; 
	}
	
	function editImg(ele){
		var packageId = $(ele).attr('title');
		var url =  "${ctx}/marrypackage/package/package!toImgList.action?id="+packageId;
		window.location.href = url; 
	}
	
	function editKepian(ele){
		var packageId = $(ele).attr('title');
		var url =  "${ctx}/marrypackage/package/package!toKepianList.action?id="+packageId;
		window.location.href = url; 
	}
	
	function delPackage(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var packageId = $(ele).attr('title');
			var url =  "${ctx}/marrypackage/package/package!delPackage.action?id="+packageId;
			window.location.href = url; 
		}
	}
	
	function sethot(ele){
		var packageId = $(ele).attr('title');
		
		$(ele).parent().parent().children().each(function(i){
			if($(this).text()=="热推"){
				alert("已经是热推套餐了!");
				return;
			}
			
			
			if($(this).text() == "非热推"){
				
				$.ajax({
					type:"get",
					url:"${ctx}/marrypackage/package/package!setHot.action?id="+packageId,
					dataType:"text",
					success:function(text){
						alert("推荐成功");
						
					}
				});
				
				$(this).text("热推");
			}
		});
	}
	
	
	function resethot(ele){
		
		var packageId = $(ele).attr('title');
		
		$(ele).parent().parent().children().each(function(i){
			if($(this).text()=="非热推"){
				alert("已经是非热推套餐了!");
				return;
			}
			
			
			if($(this).text() == "热推"){
				
				$.ajax({
					type:"get",
					url:"${ctx}/marrypackage/package/package!resetHot.action?id="+packageId,
					dataType:"text",
					success:function(text){
						alert("取消推荐成功");
						
					}
				});
				
				$(this).text("非热推");
			}
		});
	}
	
</script>
</html>