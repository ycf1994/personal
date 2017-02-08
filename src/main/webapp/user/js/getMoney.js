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


$.get("../app/vip/customer/tixianJilu",{token:getCookie("token")},function(result){
	var list=result.jilu;

	if(result.jilu.length==0){
		$(".records").removeClass("none");
		$(".content_2").addClass("none");
	}
	var moudle="<div class='content_2'>"+
	"<p class='one_2'>金额<span class='money'>A元</span></p>"+
	"<p class='two_2'>"+
	"<span class='date'>到账时间</span>"+
	"<span class='time'>B</span>"+
	"</p>"+
	"<p class='three_2'>"+
	"<span class='bank'>银行</span>"+
	"<span class='card'>C</span>"+
	"</p>"+
	"<p class='four_2'>"+
	"<span class='account'>账户</span>"+
	"<span class='num'>D</span>"+
	"</p>"+
	"<p class='five_2'>"+
	"<span class='state'>状态</span>"+
	"<span class='unsucceed'>E</span>"+
	"</p></div>";
	var str="";
	for(var i in list ){
	//	alert(list[i].money);
	
		str+=moudle
		.replace(/A/,list[i].jine)
		.replace(/B/,list[i].daozhang)
		.replace(/C/,list[i].yinhang)
		.replace(/D/,list[i].zhanghu)
		.replace(/E/,list[i].zhuangtai);
		
	}
	//alert(str);
	$(".header").after(str);
	
})

