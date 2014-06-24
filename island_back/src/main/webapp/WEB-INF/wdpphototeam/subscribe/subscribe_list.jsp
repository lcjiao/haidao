<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>档期预约</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>

<table class="customlist" style="width: 100%">
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
				<table class="datalist ask_rel" style="width: 100%">
					<thead>
						<tr>
							<td>序号</td>
							<td>摄影类型</td>
							<td>名称</td>
							<td>预约起始时间</td>
							<td>预约结束时间</td>
							<td>显示名称1</td>
							<td>显示名称2</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="r_list">
						<s:iterator value="ptoSubscribeList" status="_index">
							<tr>
								<td style="text-align:center;">
									<s:property value="#_index.index+1"/>
								</td>
								<td style="text-align:center;">
									<s:property value="workTypeStr"/>
								</td>
								<td style="text-align:center;">
									<s:property value="positionName"/>
								</td>
								<td style="text-align:center;">
									<s:property value="startT"/>
								</td>
								<td style="text-align:center;">
									<s:property value="endT"/>
								</td>
								<td style="text-align:center;">
									<s:property value="strnamef"/>
								</td>
								<td style="text-align:center;">
									<s:property value="strnamet"/>
								</td>
								<td style="text-align:center;">
									<a title='<s:property value="id"/>' onclick="edit(this)" >修改</a>&nbsp;|&nbsp;
									<a title="<s:property value="id"/>" onclick="del(this)">删除</a>
								</td>							
						    </tr>
					    </s:iterator>
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
		var url = "${ctx}/wdpphototeam/subscribe/subscribe!list?pageNo="+pageNo;
		window.location.href = url;
	}
	
	
	function newCreate(){
		var url = "${ctx}/wdpphototeam/subscribe/subscribe!toAdd.action";
		window.location.href = url;
	};
	
	function del(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var subscribeId = $(ele).attr('title');
			var url = "${ctx}/wdpphototeam/subscribe/subscribe!deleteSubscribeInfo.action?subscribeId="+subscribeId;
			window.location.href = url; 
		}
	}
	
	function edit(ele){
		var subscribeId = $(ele).attr('title');
		var url =  "${ctx}/wdpphototeam/subscribe/subscribe!toEdit.action?subscribeId="+subscribeId;
		window.location.href = url; 
	}
</script>
</html>