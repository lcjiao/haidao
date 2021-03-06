<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例视频</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmpkg/ctmcasepkg!videoCaseSearch.action" id="form" method="post">
<table class="searchbar" style="width: 100%">
	<tbody>
		<tr>
			<td width="48">视频描述</td>
			<td width="10">
				<input type="text" class="text" name="casevm.videodesc"/>
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
<input type="hidden" id = "ctm_id" name="ctmId" value='${ctmcase.id }'/>
<input type="hidden" value='${pageNo }' name="pageNo" id="page_no"/>
</form>
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
			<td align="right" class="tdr">
				<input type="button" value="返回" id="back_p_list" onclick="javascript:history.go(-1);"/>
				<input type="button" value="新建" id="new_create"/>
			</td>
		</tr>
</thead>

<tbody>
		<tr>
			<td colspan="2">
				<table class="datalist ask_rel" style="width: 100%">
					<thead>
						<tr>
							<td>序号</td>
							<td>视频logo图</td>
							<td>视频描述</td>
							<td>视频地址</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<s:iterator value="caseVMList" status="_index">
							<tr>
								<td style="text-align:center;">
									<s:property value="#_index.index+1"/>
								</td>
								<td style="text-align:center;">
									<img style="width:150px;height:120px;" alt="你想看我吗？哈哈！！" src='<s:property value="logourl"/>'>
								</td>
								<td style="text-align:center;">
									<s:property value="videodesc"/>
								</td>
								<td style="text-align:center;">
									<s:property value="videourl"/>
								</td>
								<td style="text-align:center;">
									<a title="<s:property value="id"/>" onclick="editVideo(this)" >修改</a>&nbsp;|&nbsp;
									<a title="<s:property value="id"/>"  onclick="delVideo(this)">删除</a>&nbsp;&nbsp;
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
		var imgType = '${imgType}';
		$("#img_type option[value='"+imgType+"']").attr('selected',true);
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
	
	var ctmId = $('#ctm_id').val();
	
	function newCreate(){
		var url = "${ctx}/customercase/ctmpkg/ctmcasepkg!toAddVideo.action?ctmId="+ctmId;
		window.location.href = url;
	};
	
	function editVideo(ele){
		var ctmVideoId = $(ele).attr('title');
		var url =  "${ctx}/customercase/ctmpkg/ctmcasepkg!toEditVideo.action?ctmVideoId="+ctmVideoId;
		window.location.href = url; 
	}
	function delVideo(ele){
		var ctmVideoId = $(ele).attr('title');
		var isHide = confirm('确定删除吗?');
		if(isHide){
			var url =  "${ctx}/customercase/ctmpkg/ctmcasepkg!delVideoCase.action?ctmVideoId="+ctmVideoId;
			window.location.href = url; 
		}
	}
		
</script>
</html>