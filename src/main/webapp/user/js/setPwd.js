		var wait = 60;
			function time(o) {
				if(wait == 0) {
					o.removeAttribute("disabled");
					o.value = "获取验证码";
					wait = 60;
				} else {

					o.setAttribute("disabled", true);
					o.value = "重新发送" + "(" + wait + "s"+")" ;
					wait--;
					setTimeout(function() {
							time(o)
						},
						1000)
				}
			}
			
			
$(function() {
	a = getCookie('salt');
	if(a){
	//	alert(1);
		$("a").attr("href","setting.html");
	}
	
	
$(".next img").on("click", function() {
                    var result=(getCookie("result"));
                   if(result==''||result.length==0){
                		webToast("验证码已失效", "middle", 1000);
						return;
                   }
                   result=JSON.parse(result);
                   var code=result.code;
                   var phone=result.phone;
					var ci_phone = $('.mobile_').val().trim();
					//alert(phone);
					var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
					if(ci_phone != "") {
						if(!myreg.test(ci_phone)) {
							webToast("手机号格式不正确", "middle", 1000);
							return;
						}
					} else {
						webToast("请输入11位手机号", "middle", 1000);
						return;
					}
					var ci_num = $('.num_').val().trim();
					var myreg = /\d{4}/;
					if(ci_num != "") {
						if(myreg.test(ci_num)) {
							
							if((code)!=ci_num){
								webToast("验证码不正确", "middle", 1000);
								return;
							}
							//webToast("验证码正确", "middle", 1000);
							//return;
						}
					} else {
						webToast("请输入验证码", "middle", 1000);
						return;
					}
					var ci_pwd = $('.pwd_').val().trim();
					if(ci_pwd.length<8){
						webToast("密码不能小于8位", "middle", 1000);
						return;
					}
					
					var csz=/^(＼d+)$/;//纯数字
					var czm=/^([a-zA-Z]+)$/;//纯字母
					
					if(csz.test(ci_pwd)||czm.test(ci_pwd)){
						webToast("密码不允许纯数字或者纯字母", "middle", 1000);
						return;
					}
					
					var ci_pwd_2 = $('.pwd_2_').val().trim();
					if(ci_pwd_2 == ""){
						webToast("请再次输入密码", "middle", 1000);
						return;
					}
					if(ci_pwd_2 != ci_pwd) {
							webToast("密码不一致", "middle", 1000);
							return;
					}
					
					
					
					
					$.ajax({
						url:'../vip/customer/setPwd',
						data:{"phone":phone,"newPwd":hex_md5(ci_pwd)},
						
						type:'post',
						dataType:'json',
						success:function(result){
							if(result.msg){
								webToast("密码已重置", "middle", 1000);
								setTimeout("location.href='login.html'",1000);
								//alert(1);
							}else{
								webToast("该手机号未注册", "middle", 1000);
							}
						},
						error:function(){
							webToast("网络故障请重试", "middle", 1000);
						}
					})
					
		})
});


$(function(){
	$("#btn").click(function(){
		
		
		var btn=this;
		var ci_phone = $('.mobile_').val().trim();
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
		if(ci_phone != "") {
			if(!myreg.test(ci_phone)) {
				webToast("手机号格式不正确", "middle", 1000);
				return;
			}
		} else {
			webToast("请输入11位手机号", "middle", 1000);
			return;
		}
		
		$.ajax({
			url:"../vip/customer/sendCode",
			data:{phone:ci_phone},
			type:'post',
			dataType:'json',
			success:function(result){
				//alert(1);
				webToast("已发送验证码", "middle", 1000);
				time(btn);
				setCookie("result",JSON.stringify(result));
				//alert(JSON.parse(getCookie("result")).code);
				$(".num_").removeAttr("disabled");
				
			},
			error:function(){
				alert("error");
			}
		})
	})
});


function setCookie(name, value) {  
  //  var Days = 30;  
    var exp = new Date();  
    exp.setTime(exp.getTime() + 5*60 * 1000);//过期时间 5分钟  
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();  
} 
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


