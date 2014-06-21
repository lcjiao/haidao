<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚礼套餐客片留影列表</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>
<%@ include file="/common/menu.jsp"%>
<form action="${ctx}/freewalk/package/package!toKepianList.action" id="form" method="post">
<table class="searchbar" width="100%">
	<tbody>
		<tr>
			<td width="48">客片描述</td>
			<td width="10">
				<input type="text" value="${kepianDesc}" name="kepianDesc" id="kepian_desc"/>
			</td>
			<td><input class="btn" type="button" value="搜索" id="search"/>
			</td>
		</tr>
	</tbody>
</table>
<input type="hidden" value="${pageNo}" name="pageNo" id="page_no"/>
<input type="hidden" value="${id}" name="id" id="p_id"/>
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
			<td align="right" class="tdr">
				<input type="button" value="返回" id="back_p_list"/>
				<input type="button" value="新建" id="new_create"/>
			</td>
		</tr>
</thead>

<tbody>
		<tr>
			<td colspan="2">
				<table class="datalist ask_rel" width="100%">
					<thead>
						<tr>
							<td>链接地址</td>
							<td>logo</td>
							<td>描述</td>
							<td>次序</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<c:forEach var="kepian" items="${kepianList}" varStatus="status">
							<tr>
								<td style="text-align:center;">${kepian.link}</td>
								<td style="text-align:center;">
									<img style="width:150px;height:120px;" alt="" src="${kepian.img}">
								</td>
								<td style="text-align:center;">${kepian.kepianDesc}</td>
								<td style="text-align:center;">${kepian.kepianIndex}</td>
								<td style="text-align:center;">
									<a title="${kepian.id}" onclick="editKepian(this)" >修改</a>&nbsp;|&nbsp;
									<a title="${kepian.id}"  onclick="delKepian(this)">删除</a>&nbsp;&nbsp;
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
		$("#back_p_list").bind('click',backList);
	}
	
	function loadPage(){
		//加载分页控件
		var html = pageCustomize('${pageNo}','${totalPageSize}');
		$("#page").html("");
		$("#page").html(html);
	}
	
	//初始化参数
	function initParam(){
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
		var packageId =$("#p_id").val();
		var url = "${ctx}/freewalk/package/package!toAddKepian.action?id="+packageId;
		window.location.href = url;
	};
	
	function editKepian(ele){
		var kepianId = $(ele).attr('title');
		var packageId =$("#p_id").val();
		var url =  "${ctx}/freewalk/package/package!toEditKepian.action?kepianId="+kepianId+"&id="+packageId;
		window.location.href = url; 
	}
	function delKepian(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var kepianId = $(ele).attr('title');
			var packageId =$("#p_id").val();
			var url =  "${ctx}/freewalk/package/package!delKepian.action?kepianId="+kepianId+"&id="+packageId;
			window.location.href = url; 
		}
	}

	function backList(){
		var url =  "${ctx}/freewalk/package/package!list.action";
		window.location.href = url; 
	}
</script>
</html>