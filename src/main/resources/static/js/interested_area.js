
//동이름, 동코드 배열
var addressInformData = [];

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
