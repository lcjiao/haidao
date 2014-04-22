<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海岛后台管理</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/page.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/home.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.4.2.min.js' ></script>

</head>
<body>
<div id="header">	
	<ul>
		<!-- <li id="logo_server"></li> -->
		<li id="Userheader"></li>
	</ul>
</div>

<div id="homepage">
	<div id="homepagebox">
	<form id="form" name="form" method="post" action="${ctx}/login!login.action">
		<p class="ajkinclogo"></p>
		<p class="error" id="errMsg"></p>
		<dl>
			<dt><strong>登录名：</strong></dt>
			<dd><input type="text" class="userinput" id="username" name="userName"/></dd>
		</dl>
		<dl>
			<dt><strong>密<span>密</span>码：</strong></dt>
			<dd><input type="password" class="userinput" id="password" name="userPass"/></dd>
		</dl>
		<dl>
			<dt>&nbsp;</dt>
			<dd><code><input id="submituserdata" value="" type="button" /></code><cite><a href="###"></a></cite></dd>
		</dl>
	</form>
	</div>
</div>

<div id="trunk" style="position: absolute; right: 0px; z-index: 9999; line-height: 25px; background: none repeat scroll 0% 0% rgb(255, 255, 255); border: 1px solid rgb(204, 204, 204); padding: 0px 10px; color: rgb(255, 0, 0); top: 565px;">

</div>
</body>


<script>

	$(function(){
		$('#username').val('');
		$("#submituserdata").bind('click',checkData);
		$("#username,#password").bind('focus',function(){
			$('.error').animate({
			    opacity: 0,
			    height: '24'
			  }, 500);    
		});
		var errorTag = '${loginErr}';
		var errMsg = '${errMsg}';
		if( errorTag == 'true'){
			$("#errMsg").text(errMsg);
			$('.error').animate({
			    opacity: 1,
			    height: '24'
			  }, 500);   
		};
		
		$("#homepagebox").keydown(function(event){
			if(event.keyCode == 13){
				checkData();
			}
		});
	});
	
	function checkData(){
		var name = $("#username").val();
		var pass = $("#password").val();
		if( name == null || name == "" || pass == null || pass == "" ){
			$("#errMsg").text('用户名不存在或密码错误');
			$('.error').animate({
			    opacity: 1,
			    height: '24'
			  }, 500);    	
		}else{
			$("#form").submit();
		}
	}
	
</script>
</html>