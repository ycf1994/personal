$(function(){
	$(".ing").click(function(){	
		$(".content").css("height",5.5+7*jxzNum+"rem");
	$(".ing").css("color","#AC8F3E");
	$(".ing").css("border-bottom","1px solid #AC8F3E");
	$(".end").css("color","#373737");
	$(".end").css("border-bottom","none");
	$(".record1").addClass("none");
	$(".record").removeClass("none");
	});
	$(".end").click(function(){		
		$(".content").css("height",5.5+7*yjsNum+"rem");
	$(".end").css("color","#AC8F3E");
	$(".end").css("border-bottom","1px solid #AC8F3E");
	$(".ing").css("color","#373737");
	$(".ing").css("border-bottom","none");
	$(".record").addClass("none");
	$(".record1").removeClass("none");
	})
}) 	  
function getCookie(name)
{
    var arr=document.cookie.split('; ');
    var i=0;
    for(i=0;i<arr.length;i++)
    {
        //arr2->['username', 'abc']
        var arr2=arr[i].split('=');         
        if(arr2[0]==name)
        {  
            var getC = decodeURIComponent(arr2[1]);
            return getC;
        }
    }     
    return '';
}


var jxzNum;
var yjsNum;
$.get("../app/vip/customer/invest",{token:getCookie("token"),type:"ing"},function(result){
	var hetongs=result.hetongs;
	jxzNum=hetongs.length;
	$(".content").css("height",5.5+7*jxzNum+"rem");
	var mould="<div onclick='detail(\"Q\")' class='record' style='border-bottom: none;'><p class='diyiqi'>A</p><p class='jine'>B</p><p class='riqi'>CCCC起</p><p class='lilv'>D</p></div>";
	var str="";
	
	for(var i in hetongs){
		if(i!=hetongs.length-1)
			str+=mould.replace(/style='border-bottom: none;'/,'').replace(/A/,hetongs[i].hetonghao)
			.replace(/B/,hetongs[i].jine).replace(/CCCC/,hetongs[i].kaishi).replace(/D/,hetongs[i].lilv)
			.replace(/Q/,hetongs[i].hetonghao)
			;
		else 
			str+=mould.replace(/A/,hetongs[i].hetonghao)
			.replace(/B/,hetongs[i].jine).replace(/CCCC/,hetongs[i].kaishi).replace(/D/,hetongs[i].lilv)
			.replace(/Q/,hetongs[i].hetonghao)
			;
	}
	
	$.get("../app/vip/customer/invest",{token:getCookie("token"),type:"end"},function(result){
		var hetongs=result.hetongs;
		yjsNum=hetongs.length;
		
		mould="<div onclick='detail(\"Q\")' class='record1 none' style='border-bottom: none;'><p class='diyiqi'>A</p><p class='jine'>B</p><p class='riqi'>CCCC起</p><p class='lilv'>D%</p></div>";
		for(var i in hetongs){
			if(i!=hetongs.length-1)
				str+=mould.replace(/style='border-bottom: none;'/,'').replace(/A/,hetongs[i].hetonghao)
				.replace(/B/,hetongs[i].jine).replace(/CCCC/,hetongs[i].kaishi).replace(/D/,hetongs[i].lilv)
				.replace(/Q/,hetongs[i].hetonghao)
				;
			else 
				str+=mould.replace(/A/,hetongs[i].hetonghao)
				.replace(/B/,hetongs[i].jine).replace(/CCCC/,hetongs[i].kaishi).replace(/D/,hetongs[i].lilv)
				.replace(/Q/,hetongs[i].hetonghao)
				;
		}
		$(".content div").remove();  
		$("p.qiehuan").after(str);
		
	});

	
	
	
	
});



 
 function detail(hetonghao){
		setCookie("hetonghao",hetonghao,99999);
		setCookie("type",1,99999);
		window.location.href="fanganhao.html"
	}
	function setCookie(name, value, iDay) 
	{
	    var oDate=new Date();
	     
	    oDate.setDate(oDate.getDate()+iDay);
	     
	    document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
	}
