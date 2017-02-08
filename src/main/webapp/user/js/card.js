$(function(){
	a = getCookie('tixian');
	value = JSON.parse(a);
	var tixian=parseFloat(value.money).toFixed(2);
	$(".card1 p").html("是否申请提现"+tixian+"元?");
	$(".card1 .yes").click(function(){
		a = getCookie('tixian');
		value = JSON.parse(a);
		$.ajax({
		    url: "../vip/customer/withdraw/apply",
		    type: 'GET',
		    dataType: 'json',
		    data: {user_id:value.user_id,money:value.money,bank_card:value.bank_card},
		    success:function(result) { 	    	
		    	
	        		webToast(result.message, "middle", 1000); 
	        		
	        	
		    },
		    error:function(){
		        webToast("您的网络不太通畅哦~");
		    }
		});
		
		$(".card1").css("display","none");
		$(".card2").css("display","block");
		
		
	})
	$(".card1 .no,.card2 .yes").click(function(){
	
		window.location.href='money.html';		
		
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