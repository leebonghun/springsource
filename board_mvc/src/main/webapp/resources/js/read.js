/**
 * 
 */
$(function(){
	
	let form = $("#actionForm");
	$(".btn-info").click(function(){
		location.href="../board/list";
	})
	
	$(".btn-default").click(function(){
		form.attr("action","/board/modify");
		form.submit();
		
		
		
		
	})
	
	
})