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
				//alert('ok');
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
	<nav>
		<div class="nav-wrapper">
			<form action="list">
				<div class="input-field">
					<input id="search" name="search" type="search" required> <label
						for="search"><i class="material-icons">search</i></label> <i
						class="material-icons" id="close">close</i>
				</div>
			</form>
		</div>
	</nav>
	<!-- 	<div class="row" id="s_rec">
		<font size='5'>검색이력 </font>
	</div> -->


</body>
</html>