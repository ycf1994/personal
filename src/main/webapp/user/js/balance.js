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

$(function(){
	$.get("../app/vip/customer/balance",{token:getCookie("token")},function(result){
		$(".two").text(result.keyong);
		$(".four").text(result.zuori);
		$(".six").text(result.leiji);
		var data=result.meiri;
		var str="<p class='shuju'><span class='shijian'>时间</span><span class='jixi'>计息份额</span><span class='wanfen'>万份收益(元)</span><span class='shouyi'>收益(元)</span></p>";
		var s="<p class='shuju' style='border: none;'><span class='shijian'>A</span><span class='jixi'>B</span><span class='wanfen'>C</span><span class='shouyi'>D</span></p>";
		for(var i in data){
			if(i==data.length-1)
				str+=s.replace(/A/,data[i].shijian)
				.replace(/B/,numFormat(data[i].fene))
				.replace(/C/,numFormat(data[i].wanfen))
				.replace(/D/,numFormat(data[i].shouyi));
			else
				str+=s.replace(/A/,data[i].shijian)
				.replace(/B/,numFormat(data[i].fene))
				.replace(/C/,numFormat(data[i].wanfen))
				.replace(/D/,numFormat(data[i].shouyi))
				.replace(/style='border: none;'/,'');
		}
		if(data.length==0){
			
			str="<img    src='img/wushuju.png' style='height:90%;margin-top: 10%;'  />";
			
			
		}
		
	
		 $(".record").html(str);
		 
		 
			var myChart = echarts.init(document.getElementById('main'));
			option = {
			    title: {
			        text: ''
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['七日年化收益率']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {
			        feature: {
//			          saveAsImage: {}
			        }
			    },
			    xAxis: 
			    {
			        type: 'category',
			        boundaryGap: false,
			        data:result.dates,
			        axisLabel : {
			                show:true,
			                rotate:15,
			                margin: 8,
			            },
			    },
			    yAxis: {
			        type: 'value',
			         axisLabel : {
			                show:true,
			                interval: 'auto',    // {number}
			                formatter: '{value} %', 
			            },
			    },
			    series: [
			        {
			            name:'七日年化收益率',
			            type:'line',
			            stack: '总量',
			            data:result.nianhuas
			        }
			    ]
			};
			myChart.setOption(option);
		 
		 
	});

	
	
	
	
	
	
	
	
	
	
	
	
})











$(function(){
	$(".ing").click(function(){
	$(".ing").css("color","#AC8F3E");
	$(".ing").css("border-top","1px solid #AC8F3E");
	$(".end").css("color","#373737");
	$(".end").css("border-top","none");
	$(".record1").addClass("none");
	$(".record").removeClass("none");
	});
	$(".end").click(function(){
	$(".end").css("color","#AC8F3E");
	$(".end").css("border-top","1px solid #AC8F3E");
	$(".ing").css("color","#373737");
	$(".ing").css("border-top","none");
	$(".record").addClass("none");
	$(".record1").removeClass("none");
	})
})




