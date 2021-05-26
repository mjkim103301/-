var container = document.getElementById('interested_map_left'); // 지도를 담을 영역의
																// DOM 레퍼런스
var options = { // 지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(37.5042135, 127.0216985), // 지도의 중심좌표
        level: 7, // 지도의 확대 레벨
};

// 지도 생성 및 객체 리턴
var map = new kakao.maps.Map(container, options); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 관심지역 목록 가져오기
function getInterestedAreaListLeft(){
	getInterestedAreaList('left')
}


function showShopInfoLeft(dongcode){
	let shopInfoList=[]
	 $.ajax({
	        url: `interested/commercial/${dongcode}`,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	          
	        	 console.log('showShopInfoLeft', data)
	           data.forEach(el=>{
	        	   shopInfoList.push(el);
	           })
	         
	            makeShopMarkerLeft(shopInfoList, 'shop')
	        },
	        error: function (err) {
	            console.log("showShopInfo error", err);
	        },
	    });
}

function showInvironmentInfoLeft(dongcode){
	console.log('dongcode: ', dongcode)
	let environmentInfoList=[]
	 $.ajax({
	        url: `interested/environment/${dongcode}`,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	         
	        	 console.log('showInvironmentInfoLeft', data)
	           data.forEach(el=>{
	        	   environmentInfoList.push(el);
	           })
	          
	          makeInvironmentMarkerLeft(environmentInfoList, 'invironment')
	        },
	        error: function (err) {
	            console.log("showInvironmentInfo error", err);
	        },
	    });
}
// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

function makeShopMarkerLeft(infoDataList, type){
	console.log('left type ', type)
	
	// 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    
	infoDataList.forEach(item=>{
		// console.log('infoDataList item: ', item)
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(item.address, function(result, status) {
			console.log('item.address ', item.address)
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

function makeInvironmentMarkerLeft(infoDataList, type){
	console.log('left type ', type)
	infoDataList.forEach(item=>{
		// console.log('infoDataList item: ', item)
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(item.address, function(result, status) {
			console.log('item.address ', item.address)
		    // 정상적으로 검색이 완료됐으면
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: `<div style="width:150px;text-align:center;padding:6px 0;">${item.name}</div>`
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
	})
}

