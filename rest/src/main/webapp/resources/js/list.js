/**
 * 
 */
$(function() {
   //전체 정보 가져오기
   $.getJSON({
      url: '/book/rest-list',
      success: function(data) {
         console.log(data);

         let str = "";

         $.each(data, function(idx, element) {
            str += "<tr>";
            str += "<td>" + element.code + "</td>";
            str += "<td><a href='" + element.code + "' class='move'>" + element.title + "</a></td>";
            str += "<td>" + element.writer + "</td><td>" + element.price + "</td>";
            str += "</tr>";
         })
         $("tbody").html(str);

      }

   })

   //이벤트 위임 - 책 하나 가져오기
   $("tbody").on("click", ".move", function(e) {
      e.preventDefault();

      let code = $(this).attr("href");

      //,$getJSON()
      $.getJSON({
         url: code,
         success: function(data) {
            //console.log(data);   


            let str = '<ul>';

            str += "<li>code :" + data.code + "</li>";
            str += "<li>title :" + data.title + "</li>";
            str += "<li>writer :" + data.writer + "</li>";
            str += "<li>price :" + data.price + "</li>";
            str += "</ul>";

            $("#result").html(str);


         }



      })

   })
   //도서 삭제
   $("#delete").click(function() {
      $.ajax({
         url:"4587",
         type :"delete",
         success:function(data){
            alert(data);
         },
         error:function(xhr,xhrStatus,error){
            alert(xhr.responseText);
         }

      })

   })
   $("#update").click(function(){
      //보낼 데이터 자바스크립트 객체
      
      let param={
         code:'4587',
         price:'50000'
         
      };
      
      $.ajax({
         url:'update',
         type:'put',
         contentType:'application/json',
         data:JSON.stringify(param),
         success:function(data){
            alert(data);
            
         },
         error:function(xhr,xhrStatus,error){
            alert(xhr.reponseText);
         }
         
         
      })      
      
      
   })







})