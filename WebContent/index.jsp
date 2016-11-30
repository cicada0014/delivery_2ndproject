<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<!-- 아래 임포트되는 html 문서는 디자인 및 자바스크립트에 대한 여러 헤드태그를 모아두었습니d다.  -->
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>



<title>index.jsp</title>

<!--  네이버 지도 에이피아이 테스트중. 사용자의 정보값을 불러와서 지도에 표시해준다! -->
<script type="text/javascript"
src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=JKvjluyyeKcMUDL2j_l6"></script>
<script type="text/javascript">
// fdsfsdfsd




$(function() { 
		var mapDiv = document.getElementById('map');
		var mapOptions = { 
		center : new naver.maps.LatLng(37.501644, 127.03969009999997), //멀티캠퍼스 위치가 센터값.
		zoom : 10 ,
		mapTypeId:naver.maps.MapTypeId.NORMAL
		}
		
		var map = new naver.maps.Map(mapDiv, mapOptions); 
		var infowindow = new naver.maps.InfoWindow();

function resetLocation(newlocation){
	
}
		
		
 function onSuccessGeolocation(position) {
	if(sessionStorage.getItem('userCurrentLocation')==null){
    var location = new naver.maps.LatLng(position.coords.latitude,
                                         position.coords.longitude);
	
    map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
    map.setZoom(10); // 지도의 줌 레벨을 변경합니다.

    
    $.ajax({
		url:"list",
		type:"post",
		data:"command=mapAjax&lat="+location.lat()+"&lng="+location.lng(),
		dataType:"json",
		success:function(data){
//    			    $('#currentUserLocation').text(data.result.items[0].address);
   			    $.ajax({
   			    	url:"list",
   					type:"post",
   					data:"command=mapAjax&sessionLocation="+data.result.items[0].addrdetail.sigugun,
   	   			    })
   				 sessionStorage.setItem('userCurrentLocation', data.result.items[0].addrdetail.sigugun);
				
			},
		error:function(exception){
				alert(exception.message)
			}	
		})
// 		위 위치정보를 세션에 넣어두고 다니면 로딩시간이 줄어들것이야. 
    
    infowindow.setContent('요기!');

    infowindow.open(map, location);
	}
}


function onErrorGeolocation() {
    var center = map.getCenter();
	
    infowindow.setContent('<div style="padding:100px;">' +
        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

    infowindow.open(map, center);
}




if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
    } else {
        var center = map.getCenter();

        infowindow.setContent('<div style="padding:100px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');
        infowindow.open(map, center);
    }



$('#resetLocationBtn').on('click',function(){
	var newlocation = $('#newlocation').val();
	console.log(newlocation);
	    $.ajax({
	    	url:"list",
			type:"post",
			data:"command=mapAjax&sessionLocation="+newlocation
			    })
		 sessionStorage.setItem('userCurrentLocation',newlocation);
	
});


naver.maps.Event.addListener(map, 'click', function(e) {
    var marker = new naver.maps.Marker({
        position: e.coord,
        map: map
    });

    
	$.ajax({
		url:"list",
		type:"post",
		data:"command=mapAjax&lat="+e.coord.lat()+"&lng="+e.coord.lng(),
		dataType:"json",
		success:function(data){
//    			    $('#testMap').text(data.result.items[0].address);
   			 var location = new naver.maps.LatLng(e.coord.lat(),
   					e.coord.lng());
				infowindow.setContent(data.result.items[0].address);

				infowindow.open(map, location);
				
			},
		error:function(exception){
				alert(exception.message)
			}	
		})
		
		
	

//     markerList.push(marker);
});





	}) 
</script> 


</head>



<body>
<!-- 이 부분은 로고가 들어간 가장 상단부분입니다. 여러군데서 사용될가능성이 있기에 페이지를 따로 두었습니다. -->

<c:import url="projectHeader.jsp" var="header"></c:import>
		<%=pageContext.getAttribute("header")%>
		

<c:import url="SearchForm.html"></c:import>

<!-- 이 부분은 카테고리관련한 페이지 입니다. 크롬개발자 도구를 통해 어떤 부분을 차지하고 있는지 쉽게볼수 있습니다.  -->

	<div class="container">
		<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>

		${categoryList } 
		<script type="text/javascript">
              $('#uselessIndex').remove(); // categoryCarousel만 지움
			</script>
		<!-- 	현성이형이 작업하신 부분입니다.  --> 
<!-- 		해당 부분은 projectHedaer.jsp로 옮겨졌습니다  -->


	</div>
	<div class="container">
			<form class="col row" action="" method="post">
				<div class="input-field col s4 m4 l4">
					<i class="material-icons prefix">my_location</i> <input
						id="newlocation" type="text" class="validate" name="newlocation">
					<label for="newlocation">새로운 위치지정</label>
				<a id="resetLocationBtn" class="col s4 m4 l4 waves-effect waves-light btn-large">
				<i class="material-icons left">cloud</i> 위치값 재 설정!</a>
				</div>
			</form>
	</div>
	<!-- 마테리얼에서 준비해준 기본 템플릿입니다. 현재 사용하고 있지는 않습니다.  -->
	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br>
			<div class="row">
				<div class="col s2 m2 l2"> </div>
				<h5 class="header col s12 center">현재 위치 </h5>
				<div class="col s8 m8 l8" id="map" style="width:100%;height:300px;"></div>
				<div id="testMap">  </div>
			</div>
		</div>
	</div>


<!-- 이부분은 프로젝트에서 쓰이는 푸터부분입니다. 배달의 민족 하단에 나와있는 여러 약관이나 회사정보등의 정보를 나타낼수 있는 곳입니다. 역시 한페이지로 분리하였습니다.  -->
<c:import url="projectFooter.jsp" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>
</body>

</html>