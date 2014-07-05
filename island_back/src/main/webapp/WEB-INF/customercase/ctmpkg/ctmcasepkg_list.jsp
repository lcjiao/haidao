<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客片案例列表页</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>
<%@ include file="/common/menu.jsp"%>
</head>
<body>
<form action="${ctx}/customercase/ctmpkg/ctmcasepkg!ctmcasepkgSearch.action" id="form" method="post">
<table class="searchbar" style="width: 100%">
	<tbody>
		<tr>
			<td width="48">案例类型</td>
			<td width="10">
				<select id="case_type" name="ctmcase.casetype">
					<option value="" selected="selected">--请选择--</option>
					<option value="130" >摄影案例</option>
					<option value="131" >视频案例</option>
				</select>
			</td>
			<td width="48">案例名称</td>
			<td width="10"><input type="text" name="ctmcase.casename"  id="sear_name"/></td>
			<td><input class="btn" type="button" value="搜索" id="search"/>
			</td>
		</tr>
	</tbody>
</table>
<input type="hidden" value="${pageNo}" name="pageNo" id="page_no"/>
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
			<td align="right" class="tdr"><input type="button" value="新建" id="new_create"/></td>
		</tr>
</thead>

<tbody>
		<tr>
			<td colspan="2">
				<table class="datalist ask_rel" style="width: 100%">
					<thead>
						<tr>
							<td>序号</td>
							<td>案例类型</td>
							<td>案例名称</td>
							<td>新&nbsp;&nbsp;人</td>
							<td>时&nbsp;&nbsp;间</td>
							<td>基本操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<s:iterator value="ctmcaseList" status="_index">
							<tr>
								<td style="text-align:center;">
									<s:property value="#_index.index+1"/>
								</td>
								<td style="text-align:center;">
									<s:property value="caseTypeStr"/>
								</td>
								<td style="text-align:center;">
									<s:property value="casename"/>
								</td>
								<td style="text-align:center;">
									<s:property value="newperson"/>
								</td>
								<td style="text-align:center;">
									<s:property value="strPhotoTime"/>
								</td>								
								<td width="360px" style="text-align:center;">
									<a title="" onclick="editBase(<s:property value="id"/>)" >基本信息管理</a>&nbsp;|&nbsp;
									<!-- <a title="" onclick="editDetail(<s:property value="id"/>)" >详细信息管理</a>&nbsp;|&nbsp; -->
									<a title="" onclick="editImgOrVideo(<s:property value="id"/>)" >图片|视频&nbsp;管理</a>&nbsp;|&nbsp;
									<a title=""  onclick="delCtmcase(<s:property value="id"/>)">删除</a>&nbsp;&nbsp;
									<input type="hidden" id = "ctmcase_id" name="ctmcase.id" value="<s:property value="id"/>" />
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
		var url = "${ctx}/customercase/ctmpkg/ctmcasepkg!toAddBase.action";
		window.location.href = url;
	};
	
	//var workmanId = $('#workman_id').val();
	
	function editBase(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/customercase/ctmpkg/ctmcasepkg!toEditBase.action?ctmId="+ele;
		window.location.href = url; 
	}
	
	function editDetail(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/customercase/ctmpkg/ctmcasepkg!wkmDetail.action?ctmId="+ele;
		window.location.href = url; 
	}
	
	function editImgOrVideo(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/customercase/ctmpkg/ctmcasepkg!editImgOrVideo.action?ctmId="+ele;
		window.location.href = url; 
	}
	
	function delCtmcase(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			//var weddingphotoId = $(ele).attr('title');
			var url =  "${ctx}/customercase/ctmpkg/ctmcasepkg!delCtmcase.action?ctmId="+ele;
			window.location.href = url;
		}
	}
		
	
	
	
</script>
</html>