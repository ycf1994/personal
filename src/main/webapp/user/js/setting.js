$(function(){
	$(".kai").click(function(){
		$(".guan").removeClass("none");
		$(".kai").addClass("none");
	})
	$(".guan").click(function(){
		$(".kai").removeClass("none");
		$(".guan").addClass("none");
	})
	$(".guanbi").click(function(){
		window.location.href="my.html";
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
/*function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
}*/ 
function delAllCookie(){    
    var myDate=new Date();    
    myDate.setTime(-1000);//设置时间    
    var data=document.cookie;    
    var dataArray=data.split("; ");    
    for(var i=0;i<dataArray.length;i++){    
         var varName=dataArray[i].split("=");    
         document.cookie=varName[0]+"=''; expires="+myDate.toGMTString();    
    }    
                  
}  

function show(){
	//alert(2);
	delAllCookie();
	 window.location.href="login.html";
	
}
a = getCookie('salt');
value = JSON.parse(a);
token = value.token;
$(".one span").text(value.subsName);