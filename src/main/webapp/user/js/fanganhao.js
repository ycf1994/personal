function setCookie(name, value, iDay) 
{
    var oDate=new Date();
     
    oDate.setDate(oDate.getDate()+iDay);
     
    document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
}
$(function(){
	$(".ing").click(function(){
	$(".ing").css("color","#AC8F3E");
	$(".ing").css("border-bottom","1px solid #AC8F3E");
	$(".end").css("color","#373737");
	$(".end").css("border-bottom","none");
	$(".anquan").addClass("none");
	$(".xiangmu").removeClass("none");
	});
	$(".end").click(function(){
	$(".end").css("color","#AC8F3E");
	$(".end").css("border-bottom","1px solid #AC8F3E");
	$(".ing").css("color","#373737");
	$(".ing").css("border-bottom","none");
	$(".xiangmu").addClass("none");
	$(".anquan").removeClass("none");
	
	})
	
	$(".end").click(function(){
		$(".content").css("height","38rem");
	})
	$(".ing").click(function(){
		$(".content").css("height","34rem");
	})
	
	
	
	
	$.get("../app/vip/customer/fanganhao",{hetonghao:getCookie("hetonghao")},function(result){
		$("#contractId").text(result.hetonghao);
		$(".one_2 .money").text(result.kaishi);
		$(".time").text(result.lilv);
		$(".card").text(result.zonge);
		$(".num").text(result.jieshu);
		$(".succeed").text(result.yuqi);
		$(".name span").text(jiami(result.xingming,1));
		$(".tel span").text(jiami(result.shouji,2));
		$(".id span").text(jiami(result.shenfen,3));
		$(".je").text(result.baozheng);
		$(".bfb").text(result.cangwei);
		var state=result.state;
		if(state=="投资中") $(".tiqian").remove();
		else{
			if(state=="合同结清"){
				$(".tiqian").html("<img src='img/hetongjieshu.png' />");
				$("a[href='cangwei.html']").attr("href","javascript:;").attr("onclick","javascript:webToast('该合同已经结束', 'middle', 200);");
			} else{
				$("a[href='cangwei.html']").attr("href","javascript:;").attr("onclick","javascript:webToast('该合同已经终止', 'middle', 200);");
			}
			
		}
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

function jiami(value,type){
	if(type==1){
		if(value.length==2){
			return value.substring(0,1)+"*";
		}else{
			return value.substring(0,1)+"*"+value.substring(value.length-1);
		}
	}
	if(type==2){
		return value.substring(0,3)+"****"+value.substring(7);
	}
	
	if(type==3){
		if(value.length==15){
			return value.substring(0,3)+"********"+value.substring(11);
		}else{
			return value.substring(0,3)+"********"+value.substring(14);
		}
	}
}
function setCookie(name, value, iDay) 
{
    var oDate=new Date();
     
    oDate.setDate(oDate.getDate()+iDay);
     
    document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
}