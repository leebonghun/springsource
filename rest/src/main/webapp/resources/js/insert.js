/**
 * insert.jsp 스크립트
 */
$(function(){

	$(":submit").click(function(e) {
		e.preventDefault();
		
		//사용자 입력값 가져오기
		//1) 개별로 처리하는방법(자바스크립트 객체 생성)
		
		let param={
			code:$("#code").val(),
			title:$("#title").val(),
			writer:$("#writer").val(),
			price:$("#price").val()
		};
		


		
		//Ajax 방식으로 사용자의 입력밧 서버로 전송
		//JSON.stringify : 자바스크립트 값이나 객체를 json 문자열로 변환
		$.ajax({
			url:'insert-rest', //요청주소를 적어
			type:'post', //데이터 전송 방식
			contentType:"application/json", //보내는 데이터 유형
			data:JSON.stringify(param), //전송 데이터
			success: function(data) { //서버가 전송하는 응답 결과(200)
				alert(data);
			},
			error: function(xhr, txtStatus, error) { //서버가 전송하는 응답 결과(500 or 400)
				console.log(xhr.status); //400
				console.log(xhr.responseText); //fail
				console.log(txtStatus); //error

			}

		}) //ajax종료

	})//submit종료




})