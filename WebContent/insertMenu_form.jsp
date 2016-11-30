<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="template/css/materialize.min.css"  media="screen,projection"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="template/js/materialize.min.js"></script>
<title>insertMenu.jsp</title>
<style type="text/css">

</style>
<script type="text/javascript">
	$(function(){
		
		$(document).ready(function(){
			$('select').material_select();			//����Ʈ �ڽ�
			$('textarea').trigger('autoresize');	//�޴�����
			
			var menuCategoryValue = $('value').val(); //����Ʈ �ڽ� �� �����ͼ� ī�װ� �з�
		});
	})
</script>
</head>
<body>
<div class="card-panel teal lighten-2" id="panel">�޴����</div>
	<div class="container">
		<div class="row">
			<form class="col s11 push-s2">
			
				<div class="row">
					<div class="input-field col s9">
						<input id="restaurantName" type="text" class="validate">
						<label for="restaurantName">�Ĵ��̸�</label>
					</div>
				</div>
				
				<div class="row">
					<div class="input-field col s9">
						<select>
							<option value="" disabled selected>ī�װ� ����</option>
							<option value="1">���θ޴�</option>
							<option value="2">���̵�޴�</option>
							<option value="3">����</option>
							<option value="4">��Ÿ</option>
						</select>
						<label>ī�װ�</label>
					</div>
				</div>
				
				<div class="row">
					<div class="input-field col s9">
						<input id="menuName" type="text" class="validate">
						<label for="menuName">�޴��̸�</label>
					</div>
				</div>
				
				<div class="row">
					<div class="input-field col s9">
						<input id="menuPrice" type="text" class="validate">
						<label for="menuPrice">�޴�����</label>
					</div>
				</div>
				
				<div class="row">
					<div class="input-field col s9">
						<textarea id="menuInfo" class="materialize-textarea" length="120"></textarea>
						<label for="menuInfo">�޴�����</label>
					</div>
				</div>
				
				<div class="row">
					<div class="file-path-wrapper col s7">
						<input name="imgPath" class="file-path validate" type="text" placeholder="�޴�����" disabled>
					</div>
					<div class="file-field input-field col s3">
						<div class="btn">
							<input type="file" id="photoSelect">
							<span>��������</span>
						</div>
					</div>
				</div>
				
				<div class="row">
					<button class="btn waves-effect waves-light btn-large" type="submit" name="action">�޴����</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>