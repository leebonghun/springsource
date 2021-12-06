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
	
	//댓글 작성
	
	//댓글 삽입
	replyService.add({bno:bno,replyer:'test123',reply:'댓글 작성중...'},function(result){
		if(result){
			alert(result);
		}
		
	});//add end
	
	
	
})