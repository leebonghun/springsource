/**
 * 
 */
$(function(){
	
	let form = $("#actionForm");
	$(".btn-info").click(function(){
		form.attr("action","/board/list");
		form.find("input[name='bno']").remove();
			
		
		form.submit();
		
	})
	
	$(".btn-default").click(function(){
		form.attr("action","/board/modify");
		form.submit();
		
	})
	
})