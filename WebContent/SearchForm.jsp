<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "searchAuto.do",
			type : "post",
			data : "",
			dataType : "json",
			success : function(data) {
				var datasource = data;
				console.log(data);

				$("#search").autocomplete({
					data : datasource
				});

			},
			error : function() {
				// ajax 통신 에러남
			}
		});

		$("#close").click(function() {
			$("#search").val('');
		})

	

	})
</script>
</head>
<body>
	<div class="row ">
		<div class="col s2 m2 l2"> </div>
		<div class="row col s3 m3 l3">
			
			<form class="" action="" method="post">
<!-- 				<i class="material-icons prefix">my_location</i>  -->
			<div class="col s7 m7 l7">
				<input
					id="newlocation" type="text" class="validate " name="newlocation">
				<label for="newlocation">새로운 위치지정</label>
			</div>
				<div class="col s2 m2 l2">
				 <a id="resetLocationBtn"
					class="waves-effect waves-light btn  "> <i
					class="material-icons left">cloud</i>
				</a>
				</div>
			</form>
		</div>
		<div class="col s4 m4 l4 center ">
			<nav>
				<div class="nav-wrapper ">
					<form action="list" accept-charset="UTF-8">
						<div class="input-field">
							<input type="hidden" name ="command" value="takeList">
							<input accept-charset="UTF-8" class="blue-grey lighten-4" id="search" name="search"
								type="search" required> <label for="search"><i
								class="material-icons ">search</i></label> <i class="material-icons"
								id="close">close</i>
						</div>
					</form>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>