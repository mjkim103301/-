var container = document.getElementById('interested_map_right'); // 지도를 담을
																	// 영역의 DOM
																	// 레퍼런스
var options = { // 지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(37.5042135, 127.0216985), // 지도의 중심좌표
        level: 5, // 지도의 확대 레벨
};

// 지도 생성 및 객체 리턴
var map = new kakao.maps.Map(container, options); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 관심지역 목록 가져오기
function getInterestedAreaListRight(){
	getInterestedAreaList('right')

}


function showShopInfoRight(dongcode){
	let shopInfoList=[]
	 $.ajax({
	        url: `interested/commercial/${dongcode}`,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	          
	        	 console.log('showShopInfoRight', data)
	           data.forEach(el=>{
	        	   shopInfoList.push(el);
	           })
	         
	            makeShopMarkerRight(shopInfoList, 'shop')
	        },
	        error: function (err) {
	            console.log("showShopInfo error", err);
	        },
	    });
}

function showInvironmentInfoRight(dongcode){
	console.log('dongcode: ', dongcode)
	let environmentInfoList=[]
	 $.ajax({
	        url: `interested/environment/${dongcode}`,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	         
	          console.log('showInvironmentInfoRight', data)
	           data.forEach(el=>{
	        	   environmentInfoList.push(el);
	           })
	          
	          makeInvironmentMarkerRight(environmentInfoList, 'invironment')
	        },
	        error: function (err) {
	            console.log("showInvironmentInfo error", err);
	        },
	    });
}

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

function makeShopMarkerRight(infoDataList, type){
	console.log('right type ', type)
	
	// 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	infoDataList.forEach(item=>{
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(item.address, function(result, status) {
			// console.log('${type} right infoDataList item item.address ',
			// item.address)
		    // 정상적으로 검색이 완료됐으면
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords,
		            image : markerImage // 마커 이미지
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: `<div style="width:150px;text-align:center;padding:6px 0;">${item.shopName}</div>`
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
	})
}




function makeInvironmentMarkerRight(infoDataList, type){
	console.log('right type ', type)
	infoDataList.forEach(item=>{
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(item.address, function(result, status) {
			// console.log('${type} right infoDataList item item.address ',
			// item.address)
		    // 정상적으로 검색이 완료됐으면
			var marker;
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: `<div style="width:150px;text-align:center;padding:6px 0;">${item.name}</div>`
		        });
		        
		        
		        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			     // 이벤트 리스너로는 클로저를 만들어 등록합니다 
			     // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			     kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			     kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		        
		    
		    } 
		     
		     
		});    
	})
}

//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}

