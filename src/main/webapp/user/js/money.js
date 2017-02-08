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


$(".submit").click(function(){
	
	
	
	var ci_money = $('.money_').val().trim();
	var myreg =/^[1-9]\d{2,}[\.]?\d*/;
	if(ci_money == ""){
		webToast("请输入金额", "middle", 1000); 
		return;
	}
	else if(!myreg.test(ci_money)){
		webToast("金额格式不正确", "middle", 1000);
		return;
	}else if(parseFloat(ci_money)>parseFloat(yue)){
		webToast("提现金额不能超过余额", "middle", 1000);
		return;
	}
	//alert(1);
	var v={user_id:getCookie("token"),money:ci_money,bank_card:bank_card};
	
	//return;
	
	setCookie("tixian",JSON.stringify(v),8888);
	window.location.href="card.html";
	 
});	

var bank_card;
var yue;
$(function(){
	$.get("../app/vip/customer/money",{token:getCookie("token")},function(result){		
		$(".two").text(result.yue+"元");
		$(".one").html(result.bank_name+"<span class=\"weihao\">"+result.bank_card.substring(result.bank_card.length-4)+"</span>");
		bank_card=result.bank_card;
		yue=parseFloat(result.yue.replace(/,/g,''));
		
	});	
})




function setCookie(name, value, iDay) 
{
    var oDate=new Date();
     
    oDate.setDate(oDate.getDate()+iDay);
     
    document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
}