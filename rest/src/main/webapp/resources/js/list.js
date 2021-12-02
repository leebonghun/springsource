/**
 * 
 */
$(function(){
	//제목을 클릭하면
	$(".move").click(function(e){
		e.preventDefault();
		
		let code = $(this).attr("href");
		
		//,$getJSON()
		$.getJSON({
			url:code,
			success:function(data){
				//console.log(data);	
				
			
			let str = '<ul>';
			
			str += "<li>code :"+data.code+"</li>";
			str += "<li>title :"+data.title+"</li>";
			str += "<li>writer :"+data.writer+"</li>";
			str += "<li>price :"+data.price+"</li>";
			str += "</ul>";
			
			$("#result").html(str);
			
			
			}
			
			
			
		})
		
	})
	
	
})