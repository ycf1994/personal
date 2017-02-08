$(function(){

	$.get("../app/vip/customer/cangwei",{hetonghao:getCookie("hetonghao")},function(result){
		$(".money_1").text(result.yue+"元");
		$(".money").text(result.zongshizhi+"元");
		$(".ysy").text(result.zongshizhi_zhanbi+"总市值");
		$(".wsy").text(result.yue_zhanbi+"余额");
		var moudle="<div class='dyh'><p class='dyh_a'>A</p><p class='dyh_b'>B</p><p class='dyh_c'>C</p><p class='dyh_d'>D</p></div>";
		var str="";
		var res=result.gupiaos;
		for(var i in res){
			str+=moudle
			.replace(/A/,res[i].stock_code)
			.replace(/B/,res[i].stock_name)
			.replace(/C/,res[i].balance)
			.replace(/D/,res[i].shizhi);
		}
		if(res.length==0){
			$("div.bs").remove();
			
			str+="<img src='img/wushuju.png' class='wsj'/>";
		}
		$("body").append(str);
		$(".bs").css("height",res.length*5+"rem");
	});
	

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