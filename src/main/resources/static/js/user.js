$(document).ready(function () {
//    var who = localStorage.getItem('isLogin');
//    if(who == 'manager' || who == 'user'){
//        if(who == 'manager'){
//            $('.admin-nav').removeClass('d-none');
//        }
//        $('.login-nav').addClass('d-none');
//        $('.signup-nav').addClass('d-none');
//        $('.mypage-nav').removeClass('d-none');
//        $('.logout-nav').removeClass('d-none');
//    }

    // 회원가입 -> 주소 검색 눌렀을 때
    $('#address-pop').click(function(e) {
        new daum.Postcode({
          oncomplete: function(data) {
              var addr = ''; // 주소 변수
              if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                  addr = data.roadAddress;
              } else { // 사용자가 지번 주소를 선택했을 경우(J)
                  addr = data.jibunAddress;
              }
              $('#address-pop').attr('style', 'display: none');
              $('#address').attr('style', 'display: block');
              $('#address').val(addr);
              $('#address-detail').focus();
          }
        }).open();
    });

//    // 로그인 했을 때
//    $('#login-btn').click(function (e) { 
//        // 유효성 검사 해야하나?
//        if($('#id-input').val() == 'ssafy' && $('#pw-input').val() == 'ssafy'){
//            if(true){
//                // 관리자라면 관리자 페이지 보여주기
//                $('.admin-nav').removeClass('d-none');
//                $('#write-notice').css('visibility', 'visible')
//                localStorage.setItem('isLogin', 'manager');
//            } else{
//                localStorage.setItem('isLogin', 'user');
//            }
//            $('.login-nav').addClass('d-none');
//            $('.signup-nav').addClass('d-none');
//            $('.mypage-nav').removeClass('d-none');
//            $('.logout-nav').removeClass('d-none');
//        }else{
//            alert("틀린 정보입니다.")
//        }
//    });
//
//    // 로그아웃 했을 때
//    $('.logout-nav').click(function (e) { 
//        $('.login-nav').removeClass('d-none');
//        $('.signup-nav').removeClass('d-none');
//        $('.mypage-nav').addClass('d-none');
//        $('.logout-nav').addClass('d-none');
//        $('.admin-nav').addClass('d-none');
//        localStorage.removeItem('isLogin');
//    });

    $('#all-select').click(function (e) { 
        if($('.user-select input').attr('checked') == 'checked'){
            $('.user-select input').attr('checked', false)
        } else{
            $('.user-select input').attr('checked', true)
        }
    });
    
/*	$('#searchHouseDeal').on('click',()=>{
		console.log('searchHouseDeal click')
		document.getElementById("writeform").action = "${root}/main.do";
		document.getElementById("writeform").submit();
	})*/
});