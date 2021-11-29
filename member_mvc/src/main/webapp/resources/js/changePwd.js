/**
 * step2.jsp 검증하기
 */
$(function() {
  $("#regist").validate({
    errorPlacement: function(error, element) {
      $(element)
        .closest("form")
        .find("small[id='" + element.attr("id") + "']")
        .append(error);
    },
    rules: {
		password:{
			required:true
			
		},
	
      new_password: {
        required: true,
        validPwd: true
      },
      confirm_password: {
        required: true,
        validPwd: true,
        equalTo:"#new_password"
      },
     },
    messages: {
	     password:{
		
		required:"현재 비밀번호는 필수 입력 요소입니다."
	},

      new_password: {
        required: "비밀번호는 필수 입력 요소입니다."
      },
      confirm_password: {
        required: "비밀번호는 필수 입력 요소입니다.",
        equalTo:"이전 비밀번호와 다릅니다."
      },
    }
  });
});

$.validator.addMethod(
  "validPwd",
  function(value) {
    var regPwd = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
    return regPwd.test(value);
  },
  "비밀번호는 숫자와 영문자와 특수문자의 조합으로 8~15자리를 사용해야 합니다."
);

