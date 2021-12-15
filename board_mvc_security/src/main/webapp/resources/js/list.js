/**
 * list.jsp 스크립트
 */
$(function(){
	checkModal(result);
	
	
	history.replaceState({},null,null);
	
	function checkModal(result){
		if(result==''|| history.state){
			return;
		}
		
		
		if(parseInt(result)>0){
			$(".modal-body").html("게시글"+parseInt(result)+"번이 등록되었씁니다");
		}
		
		$("#myModal").modal("show");
		
	}
	
	//페이지 나누기 스크립트
	let actionForm = $("#actionForm");
	//번호 클릭 시 클릭된 번호 값 가져오기
	$(".paginate_button a").click(function(e){
	
		//a 태그의 속성을 중지
		e.preventDefault();
		//번호 값 가져오기
		let pageNum = $(this).attr("href");
		
		//가져온 번호를 actionForm 안의 pageNum 값으로 대체
		actionForm.find("input[name='pageNum']").val(pageNum);
		actionForm.attr("action","/board/list");
		actionForm.find("input[name='bno']").remove();
		
		
		
		//폼 전송
		actionForm.submit();
		
	})
	
	
	//amount 클릭이 되면 
	$("#amount").change(function(e){
		e.preventDefault();
		
		let amount = $(this).val();
	//amount 값 가져오기
		actionForm.find("input[name='amount']").val(amount);
		
			actionForm.find("input[name='bno']").remove();
			
		actionForm.submit();
	//가져온 값을 actionForm에 
		
	})
	
	//글제목 클릭시
	$(".move").click(function(e){
		e.preventDefault();
		
		let bno = $(this).attr("href");
		
		actionForm.find("input[name='bno']").val(bno);
		
		actionForm.attr("action","/board/read");
		
		actionForm.submit();
		
		
	})
	let form1 = $("#action");
	
	$(".btn-default").click(function(e){
		e.preventDefault();
		
		/*alert($("select[name='type']").val());
		alert($("input[name='keyword']").val());*/
		
		let type = $("select[name='type']").val();
		let keyword = $("input[name='keyword']").val();
		
		if(type===''){
			alert("검색 기준을 입력해주세요");
			return;
		}else if(keyword ===''){
			alert("검색어를 입력해주세요");
			return;
		}
		
		//pageNum 1로 변경하고 보내야함
		$("#searchForm").find("input[name='pageNum']").val("1");
		$("#searchForm").submit();
		
	})
	
	
	
})



