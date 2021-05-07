var container = document.getElementById('actual-price-map');
var options = {
    center: new kakao.maps.LatLng(37.5042135, 127.0216985),
    level: 7
};

var map = new kakao.maps.Map(container, options);


// 마커를 생성
var marker = []
marker.push(new kakao.maps.Marker({
    position: new kakao.maps.LatLng(37.486212, 127.002849)
}))
marker.push(new kakao.maps.Marker({
    position: new kakao.maps.LatLng(37.518277, 127.059170)
}))
marker.push(new kakao.maps.Marker({
    position: new kakao.maps.LatLng(37.506689, 126.994310)
}))

marker.forEach(element => {
    element.setMap(map)
});

//마커 커스텀 오버레이
// 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
var content = '<div class="customoverlay">' +
    '  <a  target="_blank">' +
    '    <span class="title" >서초 트라움 아파트 69억</span>' +
    '  </a>' +
    '</div>';

// 커스텀 오버레이가 표시될 위치입니다 
var position = new kakao.maps.LatLng(37.486212, 127.002849)
console.log(position)
// 커스텀 오버레이를 생성합니다
var customOverlay = new kakao.maps.CustomOverlay({
    map: map,
    position: position,
    content: content,

    yAnchor: 0,
});

