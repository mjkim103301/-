function getList(gugun, position, path) {
    $.ajax({
        url: `interested/` + path + "/" + gugun,
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log("getList success : " + data);
            setList(data, position, path);
        },
        error: function (err) {
            console.log("getList fail : " + err);
        },
    });
}

function setList(data, position, path) {
    let html = `<table class="table table-striped">
	<thead>
		<tr>
			<th style="width:30%">이름</th>
			<th style="width:40%">주소</th>
    `;
    if (path == "center") {
        html += `<th>운영시간</th>`;
    }
    html += `
			<th>연락처</th>
		</tr>
	</thead><tbody>`;

    data.forEach((value) => {
        html += `
		<tr>
			<td>${value.name}</td>
            <td>${value.address}</td>`;

        if (path == "center") {
            html += `
            <td>${value.operatingHourWeekday}</td>
            `;
        }

        html += `
			<td>${value.phone}</td>
		</tr>`;
    });

    html += `</tbody>
	</table>`;
    console.log(html);
    let targetId = `${position}_${path}`;
    console.log("targetId" + targetId);

    // let target = document.getElementById("left_hospital");
    document.getElementById(targetId).innerHTML = html;

    // target.empty();
    // target.html(html);
}
