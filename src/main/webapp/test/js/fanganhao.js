

	
	
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
})
