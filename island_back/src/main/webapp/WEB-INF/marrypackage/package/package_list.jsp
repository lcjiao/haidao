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
<table class="searchbar" width="100%">
	<tbody>
		<tr>
			<td width="48">所属岛屿</td>
			<td width="10">
				<select id="island_id" name="islandId">
					<option value="0" selected="selected">--请选择--</option>
				</select>
			</td>
			<td width="48">套餐名称</td>
			<td width="10"><input type="text" name="title" value=""/></td>
			<td width="48">套餐价格</td>
			<td width="10"><input type="text" name="price" value=""/></td>
			<td><input class="btn" type="button" value="搜索" id="search"/>
			</td>
		</tr>
	</tbody>
</table>

<table class="customlist" width="100%">
<thead>
		<tr>
			<td>
				<div id="pagebar"> 
					<div id="page"></div>
					<code>共<strong id="total_page_size">${totalPageSize}</strong>页&nbsp;<strong>${countSize}</strong>条记录</code>
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
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="question_list">
						<c:forEach var="package" items="${packageList}" varStatus="status">
							<tr>
								<td>${package.title}</td>
								<td>${package.areaName}</td>
								<td>${package.islandName}</td>
								<td>${package.priceBig}</td>
								<td>${package.priceSmall}</td>
								<td width="360px">
									<a title="${package.id}" onclick="editArea(this)" >基本信息修改</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="editArea(this)" >图片调整</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="editArea(this)" >详细信息调整</a>&nbsp;|&nbsp;
									<a title="${package.id}" onclick="editArea(this)" >客片留影调整</a>&nbsp;|&nbsp;
									<a title="${package.id}"  onclick="delArea(this)">删除</a>&nbsp;&nbsp;
								</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
</table>
<input type="hidden" name="sourceWeb"  value="${sourceWeb}" id="source_web_serarch"/>
<input type="hidden" name="parentId" value="${parentId}" id="parent_id_search"/>
</body>
<script>
	var  numCat = /^[1-9]*$/;
	$(function(){
		loadPage();
		
		//initParam();
		
		bindEvent();
	});
	
	//绑定事件
	function bindEvent(){
		$("#search").bind('click',search);
		$("#source_web").bind('change',changeByWeb);
		$("#question_parent").bind('change',changeSearchParam);
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
		var source_web = '${sourceWeb}';
		$("#source_web option[value='"+source_web+"']").attr('selected',true);
		var parent_id = '${parentId}';
		$("#question_parent option[value='"+parent_id+"']").attr('selected',true);
		
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
		/* if(pageNo < 1 || pageNo > maxNo){
			alert('请输入正确页数');
			return;
		} */
		findByNo(pageNo);
	}
	
	//点击搜索
	function search(){
		findByNo(1);
	}
	
	
	function findByNo(pageNo){
		var sourceWeb = $("#source_web_serarch").val();
		var parentId = $("#parent_id_search").val();
		var url = "${ctx}/callcenter/question/question!search.action?sourceWeb="+sourceWeb+"&parentId="+parentId+"&pageNo="+pageNo;
		window.location.href = url;
	}
	function changeByWeb(){
		$("#source_web_serarch").val( $("#source_web").val() );
		var sourceWeb = $("#source_web").val();
		var url = "${ctx}/callcenter/question/question!list.action?sourceWeb="+sourceWeb;
		window.location.href = url;
	}
	
	function changeSearchParam(){
		$("#source_web_serarch").val( $("#source_web").val() );
		$("#parent_id_search").val( $("#question_parent").val() );
	}
	
	function editQuestion(ele){
		$.ajax({
			type:"get",
			url:"${ctx}/callcenter/question/question!isRoleEdit.action",
			dataType:"text",
			success:function(text){
				if(text == "no"){
					alert("你无权限此操作");
				}else{
					var link = $(ele).attr("name");
					window.location.href = link;
				}
				
			}
		});
	}
	
	function hideQuestion(ele){
		$.ajax({
			type:"get",
			url:"${ctx}/callcenter/question/question!isRoleEdit.action",
			dataType:"text",
			success:function(text){
				if(text == "no"){
					alert("你无权限此操作");
				}else{
					var isHide = confirm('确定隐藏吗?');
					if(isHide){
						var questionId = $(ele).attr("title");
						var link = $(ele).attr("name");
						$.ajax({
							type:"get",
							url:"${ctx}/callcenter/question/question!checkHide.action?questionId="+questionId,
							dataType:"text",
							success:function(text){
								if(text == "no"){
									alert("请先删除其子问题");
								}else{
									window.location.href = link;
								};
								
							}
						});
							
					}
				}
				
			}
		});
		
		
	}
	
	
	
	function newCreate(){
		var url = "${ctx}/callcenter/question/question!toCreate.action";
		window.location.href = url;
	};
</script>
</html>