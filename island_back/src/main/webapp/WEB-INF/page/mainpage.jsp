<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
 //remove cache
 response.setHeader("Pragma","No-cache");
 response.setHeader("Cache-Control","no-cache");
 response.setDateHeader("Expires", 0);
%>
<%request.setAttribute("ctx",request.getContextPath()); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>海岛后台管理系统</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/page.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
</head>
<frameset id="framesetname1" rows="80,800,*" cols="*" frameborder="no" border="0" framespacing="0">

  <frame src="${ctx}/page/page!top.action" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
 
  <frameset name = "framesetname2" id="framesetname2" rows="*" cols="208,7,*" framespacing="0" frameborder="no" border="0">
     <frame src="${ctx}/page/page!left.action" name="leftFrame"  noresize="noresize" id="leftFrame" title="leftFrame" />
     <frame name="middle" src="${ctx}/page/page!control.action" SCROLLING=no   NORESIZE=yes/>
	 <frame src="${url}" name="mainFrame" id="mainFrame" title="mainFrame" />
	 <frame name="num" id="num" title="${num}"/>
  </frameset>
  
</frameset>
<noframes>
</noframes>

</html>