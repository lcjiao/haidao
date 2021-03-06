<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.island.domain.model.*" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>婚纱套餐列表</title>
<link rel="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src="${ctx}/js/common.js" ></script>
<%@ include file="/common/menu.jsp"%>
<script>
var packageId="";
function popup(id){
	var popupName = $("#dialog");
	var _scrollHeight = $(document).scrollTop(),//获取当前窗口距离页面顶部高度
	_windowHeight = $(window).height(),//获取当前窗口高度
	_windowWidth = $(window).width(),//获取当前窗口宽度
	_popupHeight = popupName.height(),//获取弹出层高度
	_popupWeight = popupName.width();//获取弹出层宽度
	_posiTop = (_windowHeight - _popupHeight)/2 + _scrollHeight;
	_posiLeft = (_windowWidth - _popupWeight)/2;
	popupName.css({"left": _posiLeft + "px","top":_posiTop + "px","display":"block"});//设置position
	//$(popupName).find("div.dialog_text").first().find("input").first().val("输入姓名或邮箱地址");
	//$("#batch_del_name").val("请输入姓名");
	packageId = id;
}
</script>
</head>
<body>
<form action="${ctx}/weddingphoto/wdppackage/wdppackage!wdpPackageSearch.action" id="form" method="post">
<table class="searchbar" style="width: 100%">
	<tbody>
		<tr>
			<td width="48">所属岛屿</td>
			<td width="10">
				<select id="island_id" name="wdpPackage.islandId">
					<option value="" selected="selected">--请选择--</option>
					<c:forEach var="island" items="${islandList}">
							<option value="${island.id}" >${island.name}</option>
				   </c:forEach>
				</select>
			</td>
			<td width="48">套餐名称</td>
			<td width="10"><input type="text" name="wdpPackage.title" value="${title}" id="sear_title"/></td>
			<td width="48">套餐价格</td>
			<td width="10"><input type="text" name="wdpPackage.priceSmall" value="${priceSmall}" id="sear_price"/></td>
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
							<td>套餐名称</td>
							<td>所属区域</td>
							<td>所属岛屿</td>
							<td>所属类别</td>
							<td>淡季价格</td>
							<td>旺季价格</td>
							<td>是否在售</td>
							<td>是否热推</td>
							<td>热推操作</td>
							<td>基本操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<s:iterator value="wdpPackageList" status="_index">
							<tr>
								<td style="text-align:center;">
									<s:property value="#_index.index+1"/>
								</td>
								<td style="text-align:center;">
									<s:property value="title"/>
								</td>
								<td style="text-align:center;">
									<s:property value="areaName"/>
								</td>
								<td style="text-align:center;">
									<s:property value="islandName"/>
								</td>
								<td>
									<s:property value="typeName"/>
								</td>
								<td style="text-align:center;">
									<s:property value="priceSmall"/>
								</td>
								<td style="text-align:center;">
									<s:property value="priceBig"/>
								</td>
								<td style="text-align:center;">
									<%-- <s:if test="<s:property value="isOnline"/> != 1">非在售 </s:if>在售 --%>
									<s:property value="onlineStr"/>
								</td>
								<td style="text-align:center;" id="hot_<s:property value="#_index.index+1"/>">
									<s:property value="hotStr"/>
								</td>
								<td width="100px">
									<a title="" onclick="sethot('hot_<s:property value="#_index.index+1"/>')" >热推</a>&nbsp;|&nbsp;
									<a title="" onclick="resethot('hot_<s:property value="#_index.index+1"/>')" >取消热推</a>&nbsp;&nbsp;
									<a title="<s:property value="id"/>" onclick="popup('<s:property value="id"/>')">系统推荐</a>
								
								</td>
								<td width="360px">
									<a title="" onclick="editBase(<s:property value="id"/>)" >基本信息管理</a>&nbsp;|&nbsp;
									<a title="" onclick="editDetail(<s:property value="id"/>)" >详细信息管理</a>&nbsp;|&nbsp;
									<a title="" onclick="editImg(<s:property value="id"/>)" >图片管理</a>&nbsp;|&nbsp;
									<a title="" onclick="editKepian(<s:property value="id"/>)" >客片留影管理</a>&nbsp;|&nbsp;
									<a title=""  onclick="delweddingphoto(<s:property value="id"/>)">删除</a>&nbsp;&nbsp;
									<input type="hidden" id = "wdp_id" name="id" value="<s:property value="id"/>" />
								</td>							
						    </tr>
						</s:iterator>					
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
</table>
<div id="dialog">
  <div class="box" style="width:330px; height:200px">
    <div class="xinfos" id="system_r">
    	<ul id="r_1" >
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站首页--主打产品 &nbsp;&nbsp;&nbsp;<input width="20px"  type=checkbox  value = "1" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站首页--咨询内容&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "3" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站首页--套餐推荐&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "4" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;婚纱摄影套餐--主推套餐&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "101" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;婚纱摄影套餐--辅推套餐&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "102" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;婚纱摄影套餐--最新摄影套餐&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "103" /></h3></li>
    		<li style=" float:right; width:130px;"><h3><a href="#" onClick="gotoPage(2)">下一页</a></h3></li>
    	</ul>
    	
    	<ul id="r_2" style="display:none;">
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全站左侧导航推荐模块一&nbsp;&nbsp;&nbsp;<input width="20px"  type=checkbox  value = "20" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全站左侧导航推荐模块二&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "21" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全站左侧导航推荐模块三&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "22" /></h3></li>
    		<li><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全站详细页推荐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input width="20px" type=checkbox  value = "23" /></h3></li>
    		<li style=" float:right; width:130px;"><h3><a href="#" onClick="gotoPageDiv(1)">上一页</a></h3></li>
    	</ul>
    	
    	
    </div>
    <div class="dialogbtn" style="width:270px;">
    	<input type="button" onClick="popuphide('dialog')"  value="取消" name="button" class="close"/>
    	<input type="button" value="推荐" name="button"  class="close" onClick="system_recommend()"/>
    </div>
  </div>
</div>
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
		var url = "${ctx}/weddingphoto/wdppackage/wdppackage!toAddBase.action";
		window.location.href = url;
	};
	
	//var weddingphotoId = $('#wdp_id').val();
	
	function editBase(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/weddingphoto/wdppackage/wdppackage!toEditBase.action?wdpId="+ele;
		window.location.href = url; 
	}
	
	function editDetail(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/weddingphoto/wdppackage/wdppackage!wdpDetail.action?wdpId="+ele;
		window.location.href = url; 
	}
	
	function editImg(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/weddingphoto/wdppackage/wdppackage!toImgList.action?wdpId="+ele;
		window.location.href = url; 
	}
	
	function editKepian(ele){
		//var weddingphotoId = $(ele).attr('title');
		var url =  "${ctx}/weddingphoto/wdppackage/wdppackage!toKepianList.action?wdpId="+ele;
		window.location.href = url; 
	}
	
	function delweddingphoto(ele){
		var isHide = confirm('确定删除吗?');
		if(isHide){
			//var weddingphotoId = $(ele).attr('title');
			var url =  "${ctx}/weddingphoto/wdppackage/wdppackage!delWeddingPhoto.action?wdpId="+ele;
			window.location.href = url; 
		}
	}
	
	function resethot(ele){
		//var packageId = $(ele).attr('title');
		var txt = $('#'+ele)[0].innerText;
		if(txt.trim()=="非热推"){
			alert("已经是非热推套餐了!");
			return;
		}
		if(txt.trim() == "热推"){
			
			$.ajax({
				type:"get",
				url:"${ctx}/weddingphoto/wdppackage/wdppackage!resetHot.action?wdpId="+ele,
				dataType:"text",
				success:function(text){
					alert("取消推荐成功");
					
				}
			});
			
			$('#'+ele)[0].innerText = "非热推";
		}
	}
	
	function sethot(ele){
		var txt = $('#'+ele)[0].innerText;
		if(txt.trim()=="热推"){
			alert("已经是热推套餐了!");
			return;
		}
		if(txt.trim() == "非热推"){
			
			$.ajax({
				type:"get",
				url:"${ctx}/weddingphoto/wdppackage/wdppackage!setHot.action?wdpId="+ele,
				dataType:"text",
				success:function(text){
					alert("推荐成功");
					
				}
			});
			
			$('#'+ele)[0].innerText = "热推";
		}
	}
</script>
<script>
function popuphide(popupName){
	$("#"+popupName).css({"left": _posiLeft + "px","top":_posiTop + "px","display":"none"});//设置position
}

function gotoPageDiv(num){
	$("#r_1").hide();
	$("#r_2").hide();
	$("#r_"+num).show();
	
}

function system_recommend(){
	var sel_modules ="";
	var size = $("#system_r :checked").size();
	if( size < 1 ){
		alert("请勾选推荐位置");
		return ;
	}
	
	$("#system_r :checked").each(function(i){
		var module_id = $(this).val();
		sel_modules = sel_modules + module_id +",";
	});
	
	var packageType = 2;
	$.ajax({
		type:"get",
		url:"${ctx}/system/recommend!systemRecommend.action?id="+packageId+"&packageType="+packageType+"&modueIds="+sel_modules,
		dataType:"text",
		success:function(rst){
			if( "ok" == rst ){
				alert("推荐成功");
				$("#system_r :checked").each(function(i){
					$(this).attr("checked",false);
				});
				popuphide('dialog');
			}
			
		}
	});
	
};
</script>
</html>