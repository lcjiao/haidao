function gotoPage(pageNo){
	
}
function pageCustomize(pageNo,totalPages){
	pageNo = parseInt(pageNo);
	totalPages = parseInt(totalPages);
	if( parseInt(totalPages) >= 1){
		var prePage = (pageNo==1) ? pageNo:(pageNo-1);
		var maxPage = (pageNo+10) > totalPages ? totalPages : (pageNo+10);
		var nextPage = (pageNo < totalPages)? (pageNo+1):totalPages;
		
		//var pageContainer="<div class=\"pager\">";
		var pageContainer = "";
		if(pageNo == 1){
			pageContainer += "<a   class=\"last_page\">首页</a>" ;
			pageContainer += " <a  class=\"last_page\">上一页</a>";
		}else{
			pageContainer += "<a href=\"javascript:gotoPage(1)\" class=\"first_page\">首页</a>" ;
			pageContainer += " <a href=\"javascript:gotoPage("+prePage+")\" class=\"prev_page\">上一页</a>";
		}
		if( pageNo <= 6 ){
			for(var i =1 ;i<11; i++){
				if(i > maxPage){
					break;
				}
				if(pageNo == i){
					pageContainer += "<a href=\"javascript:void(0)\"";
				}else{
					pageContainer += "<a href=\"javascript:gotoPage("+i+")\"";
				}
				if(pageNo==i) pageContainer += " class=\"page_now\"";
				pageContainer += ">"+i+"</a>";
			}
			if(totalPages > 10){
				var indexNo = pageNo + 10;
				pageContainer += "<a href=\"javascript:gotoPage("+indexNo+")\"";
				pageContainer += ">...</a>";
			}
		}
		
		if( pageNo > 6){
			if(pageNo > 10){
				var indexNo = pageNo -10;
				pageContainer += "<a href=\"javascript:gotoPage("+indexNo+")\"";
				pageContainer += ">...</a>";
			}
			for( var i = (pageNo-5); i<(pageNo+5); i++){
				if(i > maxPage){
					break;
				}
				if(pageNo == i){
					pageContainer += "<a href=\"javascript:void(0)\"";
				}else{
					pageContainer += "<a href=\"javascript:gotoPage("+i+")\"";
				}
				if(pageNo==i) pageContainer += " class=\"page_now\"";
				pageContainer += ">"+i+"</a>";
			}
			if(totalPages > pageNo + 10){
				var indexNo = pageNo + 10;
				pageContainer += "<a href=\"javascript:gotoPage("+indexNo+")\"";
				pageContainer += ">...</a>";
			}
		}
		
		if(pageNo == totalPages){
			pageContainer += " <a disabled='true' class=\"last_page\">下一页</a>";
			pageContainer += " <a disabled='true' class=\"last_page\">尾页</a>";
		}else{
			pageContainer += " <a href=\"javascript:gotoPage("+nextPage+")\">下一页</a>";
			pageContainer += " <a href=\"javascript:gotoPage("+totalPages+")\" >尾页</a>";
		}
		//pageContainer += "</div>";
		return pageContainer;
	}
	
}




function getSubString(str,length){
    var subStr ="";
    if(str.length > length){
    	subStr = str.substring(0,length)+"...";
    }else{
    	subStr= str;
    }
   return subStr;
    }







