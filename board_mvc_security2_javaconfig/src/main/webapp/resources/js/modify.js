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
			
			//첨부 파일 정보 수집하기
			var str ="";
			$(".uploadResult ul li").each(function(i,obj){
				var ele = $(obj);
			
				str += "<input type='hidden' name='attachList["+ i +"].uuid' value='"+ele.data('uuid')+"'>";
				str += "<input type='hidden' name='attachList["+ i +"].uploadPath' value='"+ele.data('path')+"'>";
				str += "<input type='hidden' name='attachList["+ i +"].fileName' value='"+ele.data('filename')+"'>";
				str += "<input type='hidden' name='attachList["+ i +"].fileType' value='"+ele.data('type')+"'>";
			
			})
			console.log("form");
			console.log(str);
			
			
			
			//현재 폼에 첨부파일 정보 추가하기
			formObj.append(str);
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
	//첨부파일 가져오기
	let uploadResult = $(".uploadResult ul")
	let str="";
	
	//게시물에 달려있는 전체 첨부 파일 가져오기
	
	$.getJSON({
		url:'getAttachList',
		data:{
			bno:bno
		},
		success:function(data){
			console.log(data);
			//도착한 첨부파일을 보여주기 
			 showUploadedFile(data);

  }
	})//전체 첨부물 가져오기 종료
	//첨부된 파일 목록 보여주기
      function showUploadedFile(uploadResultArr){
         //첨부파일 결과를 보여줄 영역 가져오기
         var uploadResult = $(".uploadResult ul");
         
         var str="";
         $(uploadResultArr).each(function(idx,obj){
            if(obj.fileType){
               
               //썸네일 이미지 경로 생성
               var fileCallPath = encodeURIComponent(obj.uploadPath+"\\s_"+obj.uuid+"_"+obj.fileName);
               
               //원본 이미지 경로 생성
               var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
               originPath = originPath.replace(new RegExp(/\\/g),"/");
               
               str+="<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"'";
			   str+=" data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
               str+="<a href=\"javascript:showImage(\'"+originPath+"\')\">";
               str+="<img src='/display?fileName="+fileCallPath+"'>";
			   str+="<div>"+obj.fileName+"</a> ";
			   str+="<button type='button' class='btn btn-warning btn-circle btn-sm' data-file='"+ fileCallPath +"' data-type='image'><i class='fa fa-times'></i></button>";
			   str+="</div></li>";            
            }else{
               //다운로드 경로 설정
               var fileCallPath = encodeURIComponent(obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName);
              str+="<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"'";
			   str+=" data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
               str+="<a href='/download?fileName="+fileCallPath+"'>";
               str+="<img src='/resources/img/attach.png'><div>"+obj.fileName+"</a> ";
			   str+="<button type='button' class='btn btn-warning btn-circle btn-sm' data-file='"+ fileCallPath +"' data-type='file'><i class='fa fa-times'></i></button>";
               str+="</div></li>";            
            }
         })   
		console.log(str);
        uploadResult.append(str);
      }
      
      function checkExtension(fileName,fileSize){
         var regex = new RegExp("(.*?)\.(txt|jpg|gif|png)$");
         var maxSize = 2097152; //약 2MB 
         
         if(fileSize > maxSize){
            alert("파일 사이즈 초과");
            return false;
         }
         
         if(!regex.test(fileName)){
            alert("해당 종류의 파일은 업로드 할 수 없습니다.");
            return false;
         }
         return true;
      }

	//첨부파일 목록에서 X누르면 목록에서 지우기
	$(".uploadResult").on("click","button",function(){
		
		//x버튼의 부모 li 가져오기
		var targetLi = $(this).closest("li");
		
		if(confirm("정말로 파일을 지우시겠습니까??")){
					
			targetLi.remove();
		}
				
    })//x버튼 종료
	 $("input[type='file']").change(function(e){
      e.preventDefault();
      
      console.log("업로드 요청");
      
      // FormData 객체 생성 - ajax 형태로 데이터를 보낼 때 
      // key/value 형태로 쌍을 생성해 줌
      var formData = new FormData();
      
      // 첨부 파일 목록 가져오기
      var inputFile = $("input[name='uploadFile']");
      //console.log(inputFile);
      var files = inputFile[0].files;
      
      // 가져온 목록을 formData에 추가하기
      for(var i=0;i<files.length;i++){
         if(!checkExtension(files[i].name,files[i].size)){
            return false;
         }      
         formData.append("uploadFile",files[i]);
      }
      
      // query string : http://localhost:8081/upload?name=hong&age=15
      // processData:false (데이터를 query string 형태로 변환할 것인가?)
      // contentType:false,
      $.ajax({
         url:'/uploadAjax',
         type:'post',
         processData:false,
         contentType:false,
         data:formData,
		 beforeSend:function(xhr){
			xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);
		 },
         success:function(result){
            console.log(result);

            showUploadedFile(result);
			$("input[name='uploadFile']").val("");	         
		},
         error:function(xhr,status,error){
            console.log(xhr.responseText);
         }
      })//uploadBtn end
    })  
	
	
	
	//첨부파일 클릭시 이벤트
	
	//원본 이미지 창 닫기
	$(".bigPictureWrapper").on("click",function(){
		$(".bigPicture").animate({
            width:'0%',
            height:'0%'
            },1000);
		setTimeout(function(){
			$(".bigPictureWrapper").hide();
		},1000);
	})
	
})	

function showImage(fileCallPath){
    console.log(fileCallPath);
   
   //안보였던 영역 보이기
   $(".bigPictureWrapper").css("display","flex").show();
   $(".bigPicture").html("<img src='/display?fileName="+fileCallPath+"'>")
               .animate({
                  width:'100%',
                  height:'100%'
               },1000);
}