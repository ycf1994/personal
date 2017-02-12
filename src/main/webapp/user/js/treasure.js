$(function() {
	
	$.get("../app/vip/customer/treasure",{token:getCookie("token")},function(result){
		var data=result.hetongs;
		var s1=" <div class='swiper-slide' style='background-image:url(img/1@2x.png)'><img src='img/22x.png' /><p class='time'>起始时间</p><p class='date'>SHIJIAN</p><p class='rate'>年化<span class='num'>NIANHUA</span>收益</p><div class='information'><p><span class='one'>方案号</span><span class='two'>FANGANHAO</span></p>	<p><span class='three'>方案期限</span><span class='four'>QIXIAN</span></p><p><span class='five'>投资总额</span><span class='six'>ZONGE元</span></p>	<p><span class='seven'>预期收益</span><span class='eight'>YUQI元</span></p>	</div><p class='msg'><a href='javascript:;' onclick='detail(\"P\")'>查看详情<img src='img/3@2x.png'></a></p></div>";
		//var s2=" <div class='swiper-slide' style='background-image:url(img/4@2x.png)'><p class='fanganhao'>方案号FANGANHAO&nbsp;&nbsp;&nbsp;SHIJIAN</p><img src='img/8@2x.png' class='circle'><p class='nianhuashouyi'>年化收益率</p><p class='baifenbi'>NIANHUA<span class='fuhao'>%</span></p><p class='shuzi'><span class='liu'>QIXIAN</span><span class='baqian'>ZONGE</span><span class='ershi'>YUQI</span></p><p class='wenzi'><span class='fanganqixian'>方案期限</span><span class='touzizonge'>投资总额</span><span class='yijishouyi'>预期收益</span></p><p class='msg1'><a href='javascript:;' onclick='detail(ID)'>查看详情<img src='img/3@2x.png'></a></p></div>";
		var str="";
		for(var i in data){
			str+=s1.
			replace(/FANGANHAO/,data[i].hetonghao).
			replace(/SHIJIAN/,data[i].kaishi).
			replace(/NIANHUA/,data[i].lilv).
			replace(/QIXIAN/,data[i].qixian+"天").
			replace(/ZONGE/,data[i].jine).
			replace(/YUQI/,data[i].yuqi).
			replace(/P/,data[i].hetonghao);
		}
		
		if(str==""){
			str+="<img src='img/wushuju.png' class='wsj'/>";
		}
		$("div.swiper-wrapper").html(str);
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
function detail(hetonghao){
	setCookie("hetonghao",hetonghao,99999);
	setCookie("type",2,99999);
	window.location.href="fanganhao.html"
}
function setCookie(name, value, iDay) 
{
    var oDate=new Date();
     
    oDate.setDate(oDate.getDate()+iDay);
     
    document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
}