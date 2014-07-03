<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单详情</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/iframe.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>



							
							
							
							
</head>
<body>
<div  class="creatcustomer" >
<table class="datalist" width="100%">
	<tbody>
		<tr>
			<td>区域</td>
			<td>${order.wedArea}</td>
		</tr>
		<tr>
			<td>国家</td>
			<td>${order.country}</td>
		</tr>
		<tr>
			<td>出发地</td>
			<td>${order.wedFrom}</td>
		</tr>
		<tr>
			<td>预算</td>
			<td>${order.budget}</td>
		</tr>
		<tr>
			<td>婚礼人数</td>
			<td>${order.wedPersonNum}</td>
		</tr>
		<tr>
			<td>新人姓名</td>
			<td>${order.wedName}</td>
		</tr>
		<tr>
			<td>电话</td>
			<td>${order.tel}</td>
		</tr>
		<tr>
			<td>qq</td>
			<td>${order.qq}</td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td>${order.mail}</td>
		</tr>
		<tr>
			<td>咨询内容</td>
			<td>
				<textarea name="content" style="width:700px;height:200px;">${order.askMsg}</textarea>
			</td>
		</tr>
		<tr>
			<td>使用套餐</td>
			<td>
				<ul>
				<li><a href="http://www.baidu.com">套餐一</a></li>
				<li><a href="http://www.baidu.com">套餐一</a></li>
				<li><a href="http://www.baidu.com">套餐一</a></li>
				</ul>
			</td>
		</tr>
	</tbody>	
</table>
</div>
<table class="creatcustomer_tfoot" width="100%">
	<tfoot>
		<td>
			<input type=button  value="返回" id="save"/>
		 </td>
</tfoot>
</table>
<input type="hidden" id="id" name="order.id" value="${order.id}"/>
</body>
<script>
	$(function(){
		$("#save").bind('click',reset);
	});
	
	function reset(){
		var link = "${ctx}/order/order!tolist.action";
		window.location.href = link; 
	}
	
	
	
	
</script>
</html>