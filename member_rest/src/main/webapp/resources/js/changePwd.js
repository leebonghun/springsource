/**
 * /rest/changePwd.jsp 검증하기
 */
$(function() {
    //비밀번호 변경 ajax 처리
   $(":submit").click(function(e){
      e.preventDefault();
      
      let param={
         userid:$('#userid').val(),
         password:$('#password').val(),
         new_password:$('#new_password').val(),
         confirm_password:$('#confirm_password').val()
      };
      
      $.ajax({
         url:'changePwd',
         type:'put',
         contentType:'application/json',
         data:JSON.stringify(param),
         success:function(data){
            alert(data);
         },
         error:function(xhr,status,error){
            alert(xhr.responseText);
         }
      })
   })
});
