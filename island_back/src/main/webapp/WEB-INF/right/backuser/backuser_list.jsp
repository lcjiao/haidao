<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台用户列表</title>
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
							<td>用户名称</td>
							<td>所属角色</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<c:forEach var="user" items="${userList}">
							<tr>
								<td>
									<c:out value="${user.userName}"></c:out>
								</td>
								<td>
									<c:out value="${user.roleName}"></c:out>
								</td>
								<td><a title="${user.id}" onclick="editUser(this)" >修改</a>&nbsp;|&nbsp;<a title="${user.id}" onclick="delUser(this)">删除</a></td>							
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
		var url = "${ctx}/right/backuser/backuser!list.action?pageNo="+pageNo;
		window.location.href = url;
	}
	
	
	function newCreate(){
		var url = "${ctx}/right/backuser/backuser!toAdd.action";
		window.location.href = url;
	};
	
	function delUser(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var userId = $(ele).attr('title');
			var url = "${ctx}/right/backuser/backuser!delUser.action?userId="+userId;
			window.location.href = url; 
		}
	}
	
	function editUser(ele){
		var userId = $(ele).attr('title');
		var url =  "${ctx}/right/backuser/backuser!toEdit.action?userId="+userId;
		window.location.href = url; 
	}
</script>
</html>