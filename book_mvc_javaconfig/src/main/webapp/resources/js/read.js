/**
 * 
 */
$(function(){
	
	let form = $("#actionForm");
	//목록 버튼 클릭시 
	$(".btn-secondary").click(function(){
		location.href="/book/list";
	})
	
	$(".btn-danger").click(function(){
		
		form.attr("action","/book/remove");
		form.submit();
		
	})
	$(".btn-primary").click(function(){
	
		form.attr("action","/book/modify");
		form.submit();
		
		
		
		
		
	})
	
	
	
	
	
	
	
	
	
	
})


