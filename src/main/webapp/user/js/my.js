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




 
 
 $.get("../app/vip/customer/my",{token:getCookie("token")},function(result){
	 $(".money1").html(result.zongzichan);
	 $(".mobile").html(result.realname);
	 $(".money").html(result.keyong+"<span class=\"money\" style=\"font-size: 1.2rem;\">元</span>");
	 $(".yesterday_money").html(result.zuori);
	 $(".leiji_money").html(result.leiji);
	 $(".money2").html(result.zaitou);
 });