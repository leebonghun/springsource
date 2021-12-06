/**
 *   insert.jsp 
 */

$(function(){
   
   //submit 클릭하면 form data 가져온 후
   //ajax 전송
   
   $(":submit").click(function(e){
      e.preventDefault();
      
      let parm={
         userid:$('#userid').val(),
         password:$('#password').val(),
         name:$('#name').val(),
         gender:$('#gender').val(),
         email:$('#email').val()
      };
      
      $.ajax({
         url:'insert',
         type:'post',
         contentType:'application/json',
         data:JSON.stringify(parm),
         success:function(data){
            alert(data);
         },
         error:function(xhr,status,error){
            alert(xhr.responseText);
         }
      })
   })
})