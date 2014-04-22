<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setAttribute("ctx",request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海岛后台管理系统</title>
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/base.css' type="text/css" media="all" />
<link rel="stylesheet" rev="stylesheet" href='${ctx}/css/control.css' type="text/css" media="all" />
<script type="text/javascript" src='${ctx}/js/jquery-1.7.min.js' ></script>
<script type="text/javascript" src='${ctx}/js/left.js' ></script>
</head>
<body   topmargin=0   marginheight=0   leftmargin=0   marginwidth=0   bgcolor=#d0d0c8>
  <div style="width:10px;">
  <input type=image id ="image_but" src="${ctx}/images/float.jpg" style="margin-top:300px;" onclick=changeWin();></div>
</body>

<script >
  function   changeWin(){
	  var framesetname2 = window.parent.window.document.getElementsByName("framesetname2")[0];
	  if(framesetname2.getAttribute('cols')  ==  "208,7,*")
	  {
		  framesetname2.setAttribute('cols',"1,7,*");
		  document.getElementById("image_but").src="${ctx}/images/left.jpg";
	  }
	  else
	  {
		  framesetname2.setAttribute('cols',"208,7,*");
		  document.getElementById("image_but").src="${ctx}/images/float.jpg";
	  }
  }

  </script>
</html>