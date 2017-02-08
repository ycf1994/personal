function getCookie(name)
{
    var arr=document.cookie.split('; ');
    var i=0;
    for(i=0;i<arr.length;i++)
    {
        var arr2=arr[i].split('=');         
        if(arr2[0]==name)
        {  
            var getC = decodeURIComponent(arr2[1]);
            return getC;
        }
    }     
    return '';
}

$.get("../app/vip/customer/fund",{token:getCookie("token")},function(result){
	$(".two").text(result.keyong);
	$(".four").text(result.zaitou);
	$(".num").text(result.zongzichan);
	var data=result.flows;
	if(data.length==0){
		$(".records").removeClass("none");
		$(".content").addClass("none");
		$(".content_2").addClass("none");
		return;
	}
	
	var s="<p class='three_2'><span class='cz'>TYPE</span><span class='date'>TIME</span><span class='money'>MONEY元</span></p>"
	var w="<div class='content_2'><p class='one_2'>NY</p></div>";
	
	for(var i in data){
		var year=getYear(data[i].time);
		var month=getMonth(data[i].time);
		data[i].type=(data[i].type=="资金入账"||data[i].type=="活期利息"||data[i].type=="定期收益")?"<span style='margin-right:1.7rem;'  >"+data[i].type+"</span>":"<span style='margin-right:4.7rem;'  >"+data[i].type+"</span>";
		var flag=true;
	$(".content_2").each(function(){
	if($($(this).children(":first")).html()==(String(year+"-"+month))){
		$(this).append(s.replace(/TYPE/,data[i].type).replace(/TIME/,data[i].time).replace(/MONEY/,(data[i].money)));
		flag=false;
		return false;
	}            			
	});
	if(flag){
		$("body").append(w.replace(/NY/,year+"-"+month));
	
	$(".content_2").each(function(){            				
		if($($(this).children(":first")).html()==(year+"-"+month)){  
			$(this).append(s.replace(/TYPE/,data[i].type).replace(/TIME/,data[i].time).replace(/MONEY/,(data[i].money)));
			flag=false;
		}            			
		});
	}
	
	}
	$(".content_2").each(function(){
		$(this).css("height",4.8+($(this).children().length-1)*5+"rem");
		var lc=$(this).children(".three_2:last-child");
		$(lc).removeClass("three_2");
		$(lc).addClass("five_2");
	})
	
	
});




	 
	 function getYear(time){
		 return time.substring(0,4);
	 }
	 function getMonth(time){
		 return time.substring(5,7);
	 }