/**
 * uploadFormAjax.jsp
 */
$(function(){
   $("#uploadBtn").click(function(e){
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
         success:function(result){
            console.log(result);
            showUploadedFile(result);
         },
         error:function(xhr,status,error){
            console.log(xhr.responseText);
         }
      })//uploadBtn end
      
      
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
               
               str+="<li>";
               str+="<a href=\"javascript:showImage(\'"+originPath+"\')\">";
               str+="<img src='/display?fileName="+fileCallPath+"'>";
			   str+="<div>"+obj.fileName+"</a>";
			   str+="<span data-file='"+fileCallPath+"' data-type='image'>X</span>";
			   str+="</div></li>";            
            }else{
               //다운로드 경로 설정
               var fileCallPath = encodeURIComponent(obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName);
               str+="<li>";
               str+="<a href='/download?fileName="+fileCallPath+"'>";
               str+="<img src='/resources/img/attach.png'><div>"+obj.fileName+"</a>";
			   str+="<span data-file='"+fileCallPath+"' data-type='file'>X</span>";
               str+="</div></li>";            
            }
         })   
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
   })
	
	//이미지 영역 감추기
	$(".bigPictureWrapper").on("click",function(){
		$(".bigPicture").animate({
            width:'0%',
            height:'0%'
            },1000);
		setTimeout(function(){
			$(".bigPictureWrapper").hide();
		},1000);
	})
	
	
	
	
	//첨부파일 목록에서 X누르면 목록에서 지우기
	$(".uploadResult").on("click","span",function(){
		//삭제할 파일 가져오기
		let targetFile=$(this).data("file");
		
		//삭제할 파일 타입 가져오기
		let type = $(this).data("type");
		//x버튼의 부모 li 가져오기
		var targetLi = $(this).closest("li");
		
		$.ajax({
			url:'/deleteFile',
			type:'post',
			data:{
				fileName:targetFile,
				type:type	
			},
			success:function(data){
				targetLi.remove();
			},
			error:function(xhr,status,error){
				alert(xhr.responseText);
			}		
		})
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