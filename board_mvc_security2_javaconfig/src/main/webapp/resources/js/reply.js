/**
 *  reply 관련된 스크립트
 */
let replyService = (function(){
	
	function add(reply,callback){
		console.log("add method 실행");
		
		$.ajax({
			url:'/replies/new',
			type:'post',
			contentType:'application/json',
			data:JSON.stringify(reply),
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,err){
				error(err);
			}
			
		})
		
	}//add end
	function getList(param,callback){
		
		let bno = param.bno;
		let page = param.page || 1;
		
		$.getJSON({
			url:'/replies/pages/'+bno+'/'+page,
			success:function(data){
				callback(data.replyCnt,data.list);
			}
		})
		
	}//getList end
	
	function remove(rno,replyer,callback,error){
		
		$.ajax({
			url:'/replies/'+rno,
			type:'delete',
			contentType:'application/json',
			data:JSON.stringify({
				replyer:replyer
				
			}),
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(xhr.responseText);
				}
			}
			
		})
		
	}//remove end
	
	function update(reply,callback,error){
		
		$.ajax({
			
			url:'/replies/'+reply.rno,
			type:'put',
			contentType:'application/json',
			data:JSON.stringify(reply),
			success:function(data){
				if(callback){
					callback(data);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(xhr.responseText);
				}
			}
			
		})
	}//update end
	
	function get(rno,callback){
		
		$.getJSON({
			
			url:'/replies/'+rno,
			success:function(data){
				if(callback){
					callback(data);
				}
			}
		})
		
	}//get end
	
	function displayTime(timeValue){
		var today= new Date();
		
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);
		
		var str = "";
		//댓글을 단 날짜가 24시간보다 작다면 댓글 작성일을 시분초로 보여주기 위해
		if(gap < (1000 * 60 * 60 * 24)){ 
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			// 9보다 작으면 01 , 분도 9보다 작으면 01, 초도 마찬가지
			return [(hh>9?'':'0')+hh, ':' ,(mi>9?'' : '0')+mi, ':',(ss>9?'':'0')+ss].join('');
		}else{ //24시간보다 클 경우 년월일 처리
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth()+1;
			var dd = dateObj.getDate();
			
			return [yy,'/',(mm>9?'':'0')+mm, '/', (dd>9?'':'0')+dd].join('');
		}
		
		
	}//displayTime end
		
	return { //얘를 꼭써야 불러짐
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime
	};
	
	
	
})();