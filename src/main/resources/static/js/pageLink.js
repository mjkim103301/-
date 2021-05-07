$(document).ready(function () {

	function getContextPath() {
		var hostIndex = location.href.indexOf(location.host) + location.host.length;
		console.log(hostIndex)

		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1))
	}
/*$('#searchHouseDeal').on('click', () => {
		console.log('searchHouseDeal click')
		var root=getContextPath()
		console.log('root  ', root)
		
		
		document.getElementById("search-using-dong").action = root+"/main.do";
		document.getElementById("search-using-dong").submit();
	})*/
})