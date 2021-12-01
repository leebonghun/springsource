/**
 * 
 */

$(function(){
	
	let formObj=$("#actionForm")
	
	$("button").click(function(e){
		e.preventDefault();/*submit 기능을 막아요 */
		
		//어느 버튼에서 명령이 왔는가?
		
		//data -* *위치에는 이름부여하는것이기 때문에 아무거나 와도 됨.
		let oper = $(this).data("oper");
		
		if(oper=='modify'){
			formObj = $("form[role='form']");	
			
		}else if(oper =='remove'){
			formObj.attr("action","/board/remove")
					.attr("method","post");
			
		}else{
			formObj.attr("action","/board/list")
					.attr("method","get")
					.find("input[name='bno']").remove();
		}
		
		formObj.submit();
	})
	
	
})