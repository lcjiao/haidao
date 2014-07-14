<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户咨询</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>

</head>
<body>
<%@ include file="/common/menu.jsp"%>
<form action="${ctx}/guestqa/guestqa!tolist.action" id="form" method="post">
<table class="searchbar" width="100%">
	<tbody>
		<tr>
			<td width="48">所属套餐类型</td>
			<td width="10">
				<select id="package_type" name="packageType">
					<option value="0" selected="selected">--请选择--</option>
					<option value="1" >婚礼套餐</option>
					<option value="2" >婚纱摄影套餐</option>
					<option value="3" >婚纱摄影摄影师套餐</option>
					<option value="4" >酒店套餐</option>
					<option value="5" >自由行套餐</option>
				</select>
			</td>
			<td width="48">是否有回复</td>
			<td width="10">
				<select id="is_answer" name="isAnswer">
					<option value="-1" selected="selected">--请选择--</option>
					<option value="0" >无回复</option>
					<option value="1" >有回复</option>
				</select>
			</td>
			<td width="48">归属套餐编号</td>
			<td width="10">
				<input type="text" value="" name="packageId" />
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
			<td align="right" class="tdr"><!-- <input type="button" value="新建" id="new_create"/> --></td>
		</tr>
	</thead>
	
	<tbody>
		<tr>
			<td colspan="2">
				<!--表内容-->
				<table class="datalist ask_rel" width="100%">
					<thead>
						<tr>
							<td>归属套餐类型</td>
							<td>归属套餐编号</td>
							<td>邮箱</td>
							<td>问题</td>
							<td>是否回复</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="r_list">
						<c:forEach var="qa" items="${qaList}">
							<tr >
								<td style="text-align:center;">
									<c:out value="${qa.packageTypeStr}"></c:out>
								</td>
								<td style="text-align:center;">
									<c:out value="${qa.packageId}"></c:out>
								</td>
								<td style="text-align:center;">
									<c:out value="${qa.email}"></c:out>
								</td>
								<td style="text-align:center;">
									<c:out value="${qa.question}"></c:out>
									<%-- <input style="width:50px;" type="text" value="${recommend.recommendIndex}" id="r_index" name="index">
								 --%></td>
								<td style="text-align:center;">
									<c:out value="${qa.hasAnswer}"></c:out>
								</td>
								<td style="text-align:center;">
									<a title="${qa.id}" onclick="addAnswer(this)" >回复</a>&nbsp;|&nbsp;
									<a title="${qa.id}" onclick="editAnswer(this)" >修改回复</a>&nbsp;|&nbsp;
									<a title="${qa.id}" onclick="seeAnswer(this)" >查看回复</a>&nbsp;|&nbsp;
									<a title="${qa.id}" onclick="del(this)">删除</a>
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
		//$("#new_create").bind('click',newCreate);
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
		
		var isAnswer = '${isAnswer}';
		$("#is_answer option[value='"+isAnswer+"']").attr('selected',true);
		
		
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
	
	
	/* function newCreate(){
		var url = "${ctx}/marrypackage/secondpackage/secondpackagerecommend!toAdd.action";
		window.location.href = url;
	}; */
	
	function del(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var id = $(ele).attr('title');
			var url = "${ctx}/guestqa/guestqa!del.action?id="+id;
			window.location.href = url; 
		}
	}
	
	function addAnswer(ele){
		var id = $(ele).attr('title');
		var url =  "${ctx}/guestqa/guestqa!toAddAnswer.action?id="+id;
		window.location.href = url; 
	}
	
	function editAnswer(ele){
		var id = $(ele).attr('title');
		var url =  "${ctx}/guestqa/guestqa!toEditAnswer.action?id="+id;
		window.location.href = url; 
	}
	
	function seeAnswer(ele){
		var id = $(ele).attr('title');
		var url =  "${ctx}/guestqa/guestqa!toSeeAnswer.action?id="+id;
		window.location.href = url; 
	}
	
	
</script>
</html>