//동이름, 동코드 배열
var addressInformData = [];

//로그인한 사용자 아이디
var userId='';

var interestedAreaList=[];

//관심지역 등록
function interestedAreaRegister(){
	console.log('interestedAreaRegister')
	searchInterestedPlaces();
	 
}


//키워드 검색을 요청하는 함수입니다
function searchInterestedPlaces() {
    console.log(`interestedAreaRegister search places`);
    var keyword = "";
    keyword = document.getElementById("keyword").value;
    console.log("interestedAreaRegister keyword: ", keyword);

   
    if (!keyword.replace(/^\s+|\s+$/g, "")) {
        return false;
    }
    getInterestedAddressInform(keyword);


}

function getInterestedAddressInform(keyword) {
    console.log("interestedAreaRegister getAddressInform");
    addressInformData = [];

    $.ajax({
        url:
            "https://dapi.kakao.com/v2/local/search/address.json?query=" +
            encodeURIComponent(keyword),
        type: "GET",
        headers: {
            Authorization: "KakaoAK bdd77f4cfa5dd1d8a24efabed352181b",
        },
        success: function (data) {
            data.documents.forEach((element) => {
                addressInformData.push({
                    dongcode: element.address.b_code,
                    dong: element.address.region_3depth_name,
                });
            });

            if (addressInformData.length == 0) {
                addressInformData.push({
                    keyword: keyword,
                });
            }

            console.log("interestedAreaRegister addressInformData: ", addressInformData);
            registerRequest()
        },
        error: function (err) {
            console.log("interestedAreaRegister getAddressInform error: ", err);
        },
    });
}


function registerRequest(){
	 $.ajax({
	        url: "interested/register",
	        type: "POST",
	        contentType: "application/json; charset=UTF-8",
	        data: JSON.stringify(addressInformData),
	        dataType: "json",
	        success: function (data) {
	           console.log('interestedAreaRegister result ', data)
	        },
	        error: function (err) {
	            console.log("interestedAreaRegister error", err);
	        },
	    });
	
}

//관심지역 페이지 - 관심지역 목록 가져오기
let position=''
function getInterestedAreaList(requestPosition){
	console.log('getInterestedAreaList click')
	position=requestPosition
	 $.ajax({
	        url: "getSession",
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	           userId=data.userId;
	           console.log('interestedAreaRegister userId ', userId)
	           getInterestedAreaListJson();
	        },
	        error: function (err) {
	            console.log("interestedAreaRegister error", err);
	        },
	    });
	
}

function getInterestedAreaListJson(){	
	 $.ajax({
	        url: `interested/list/${userId}`,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	           console.log('getInterestedAreaList result ', data)
	           interestedAreaList=[]
	           data.forEach(el=>{
	        	   interestedAreaList.push(el);
	           })
	           showInterestedAreaList()
	        },
	        error: function (err) {
	            console.log("getInterestedAreaList error", err);
	        },
	    });
}


function showInterestedAreaList(){
	console.log('showInterestedAreaList')
	let html=``
	interestedAreaList.forEach((item, index)=>{
		console.log('item ', item)
		html+=`
			<div class="dropdown-item" id="select_${index}" onclick = "selectArea(` + item + `)" >  ${item.dongcode} - ${item.dong} </div >
				`
	})
	if(position=='left'){
		 $(".interested_area_menu_left").empty();
		$(".interested_area_menu_left").html(html);
	}else if(position=='right'){
		 $(".interested_area_menu_right").empty();
		$(".interested_area_menu_right").html(html);
	}
	
	
}
 function selectArea() {
 	console.log('selectArea')
 }
 
 $(document).ready(function(){
	 
	 $('')
 })
function selectArea(selected){
	let html=`<h3>${selected.dong}</h3>`;
	if(position=='left'){
		 $(".interested_area_select_left").empty();
		$(".interested_area_select_left").html(html);
	}else if(position=='right'){
		 $(".interested_area_select_right").empty();
		$(".interested_area_select_right").html(html);
	}
	
}
