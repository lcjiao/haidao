<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>island map</title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link media="all" href="${ctx}/front_map_js_css_img/css/css.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/front_map_js_css_img/css/side1.css" rel="stylesheet" />

    <script language="JavaScript" src="${ctx}/front_map_js_css_img/js/jquery.js"></script>

    <link media="all" href="${ctx}/front_map_js_css_img/css/scroll2.css" type="text/css" rel="stylesheet">


	<title>婚礼套餐区</title>
	 <style type="text/css">

.popover-title {
  padding: 8px 14px;
  margin: 0;
  font-size: 14px;
  font-weight: normal;
  line-height: 18px;
  background-color: #f7f7f7;
  border-bottom: 1px solid #ebebeb;
  -webkit-border-radius: 5px 5px 0 0;
     -moz-border-radius: 5px 5px 0 0;
          border-radius: 5px 5px 0 0;
}
    </style>

    <script type="text/javascript">
		

 function showDiv(i){
		
		document.getElementById("pop"+i).style.display = "block";
	}
	function hidDiv(i){
		
		document.getElementById("pop"+i).style.display = "none";
	}
	function gotomethod(){
		window.location.href ="http://www1.baidu.com";
	}
	
    </script>

</head>
<body>
    <div class="w_m page_dz">
        <div class="index_con_div in_con_div">
            <div class="titles2 hltc_title yahei">
                
            </div>
            <div class="left_con">
                <iframe src="#" scrolling="no" width="100%" height="500" frameborder="0"></iframe>
            </div>
            <div class="main_con2">
                <div class="map_con">
                	 <div class="map_scroll clearfix">
                                            <div class="map_scroll_inner" id="map_scroll0">
                                                <ul>
                                                    <li class="pic">
                                                        <img src="${backImgUrl}" alt="" />
                                                        <div class="map_img">
                                                        	<img src="${frontImgUrl}" alt="" />
                                                        </div>
                                                    </li>
  
                                                </ul>
                                                
                                            	<c:forEach var="lng"  varStatus ="obj" items="${islandMapList}">
                                                	  <img src="${ctx}/front_map_js_css_img/images/arrow1.png" style="cursor:pointer;left:${lng.mapLeft}%;top:${lng.mapTop}%;position:absolute;"
                                                data-target="pop${obj.count}" onMouseOver="showDiv(${obj.count})" onMouseOut="hidDiv(${obj.count})" onclick="gotomethod()" />
                                                
	                                                <div  style="z-index:1001;cursor:pointer;left:500px;top:200px;position:absolute; display:none;" data-easein="cardInTop" data-easeout="cardOutTop" id="pop${obj.count}">	
	                                                   <h3 class="popover-title">${lng.mapDesc}</h3>
	                                                 </div>
                                                </c:forEach>  
                                                
                                                <!--  <img src="images/arrow1.png" style="cursor:pointer;left:450px;top:260px;position:absolute;" 
                                                data-target="pop1" onMouseOver="showDiv(1)" onMouseOut="hidDiv(1)" onclick="gotomethod()" />
                                                
                                                 <div  style="z-index:1001;cursor:pointer;left:400px;top:200px;position:absolute; display:none;" data-easein="cardInTop" data-easeout="cardOutTop" id="pop1">
                                                   <h3 class="popover-title">描述二</h3>
                                                </div>
                                                
                                                
                                                   <img src="images/arrow1.png" style="cursor:pointer;left:80%;top:70%;position:absolute;"
                                                data-target="pop2" onMouseOver="showDiv(2)" onMouseOut="hidDiv(2)" onclick="gotomethod()" />
                                                
                                                <div  style="z-index:1001;cursor:pointer;left:500px;top:200px;position:absolute; display:none;" data-easein="cardInTop" data-easeout="cardOutTop" id="pop2">	
                                                   <h3 class="popover-title">描述一</h3>
                                                 </div>
                                                
                                                
                                                
                                                 <img src="images/arrow1.png" style="cursor:pointer;left:500px;top:360px;position:absolute;" 
                                                data-target="pop3" onMouseOver="showDiv(3)" onMouseOut="hidDiv(3)" onclick="gotomethod()" />
                                                
                                                <div  style="z-index:1001;cursor:pointer;left:450px;top:300px;position:absolute; display:none;" data-easein="cardInTop" data-easeout="cardOutTop" id="pop3">
                                                   <h3 class="popover-title">描述三</h3>
                                                </div>  -->
                                                
                                                
<!--                                                 <img onclick="gotomethod()" onmouseout="hidDiv(1)" onmouseover="showDiv(1)" data-target="pop1" style="cursor:pointer;left:20%;top:20%;position:absolute;" src="/island_back/front_map_js_css_img/images/arrow1.png">
<div id="pop1" data-easeout="cardOutTop" data-easein="cardInTop" style="z-index:1001;cursor:pointer;left:500px;top:200px;position:absolute; display:none;">
<h3 class="popover-title">2</h3>
</div>
<img onclick="gotomethod()" onmouseout="hidDiv(2)" onmouseover="showDiv(2)" data-target="pop2" style="cursor:pointer;left:80%;top:80%;position:absolute;" src="/island_back/front_map_js_css_img/images/arrow1.png">
<div id="pop2" data-easeout="cardOutTop" data-easein="cardInTop" style="z-index:1001;cursor:pointer;left:500px;top:200px;position:absolute; display:none;">
<h3 class="popover-title">9</h3>
</div>
<img onclick="gotomethod()" onmouseout="hidDiv(3)" onmouseover="showDiv(3)" data-target="pop3" style="cursor:pointer;left:77%;top:77%;position:absolute;" src="/island_back/front_map_js_css_img/images/arrow1.png">
<div id="pop3" data-easeout="cardOutTop" data-easein="cardInTop" style="z-index:1001;cursor:pointer;left:500px;top:200px;position:absolute; display:none;">
<h3 class="popover-title">7</h3>
</div> -->
                                                
                                            </div>
                                            <div class="clearboth">
                                            </div>
                                            <span class="btn_l" id="mbtn_l0"></span><span class="btn_r" id="mbtn_r0"></span>
                                        </div>


                </div>
                
                    
                </div>
            </div>
        
        </div>
    
</body>


</html>