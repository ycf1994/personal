$(".loginBtn").click(function(){
    	 var ci_phone = $('.mobile').val().trim();
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
					var ci_pwd = $('.pwd').val().trim();
					var myreg = /\d{4}/;
					if(ci_pwd != "") {
						if(!myreg.test(ci_pwd)) {
							webToast("密码不正确", "middle", 1000);
							return;
						}
					} else {
						webToast("请输入密码", "middle", 1000);
						return;
					}
      var uName=$("#userName").val();
      var uPwd=hex_md5($("#password").val());  

 
 
 $.get("../app/vip/customer/login",{mobile:uName,password:uPwd},function(result){
	 webToast(result.message, "middle", 1000); 
		if(result.resCode=='success'){
       		setCookie('token',result.token,99999);
       		window.location.href="my.html";
        	}
    	
	 
 });
});
function setCookie(name, value, iDay) 
{
    var oDate=new Date();
     
    oDate.setDate(oDate.getDate()+iDay);
     
    document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
}









