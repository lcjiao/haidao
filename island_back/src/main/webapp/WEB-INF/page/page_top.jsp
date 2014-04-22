<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%request.setAttribute("ctx",request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海岛后台管理系统</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/page.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
</head>

<body>
<div id="header">	
	<ul>
		<li id="logo_server_"><a href="javascript:imageClick();"></a></li>
		<li id="Userheader">您好，<strong>${userName}</strong> <span>|</span><a href="javascript:chgpass();">密码管理</a><span>|</span> <a href="${ctx}/login!exit.action" TARGET="_top">退出</a></li>
	</ul>
</div>

</body>
 <script type="text/javascript" language="JavaScript">
        function chgpass() 
		{
        	alert('待实现');
           //var host = $('#crmHost').val();
		   //window.top.mainFrame.location.href=host+"self/toChgPass.action";
		}
        
        
        function chgMenu()
        {
        	window.top.mainFrame.location.href="${ctx}/module/module!moduleList.action";
        }
 </script>
</html>