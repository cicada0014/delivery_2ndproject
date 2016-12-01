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