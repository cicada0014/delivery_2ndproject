/**
 * 
 */

function loginCheck(){
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야해요!");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userid.value == ""){
		alert('아이디를 입력하시오.')
		document.frm.userid.focus();
		return;
	}
	var url = "member.do?action=idcheck&userid=" + document.frm.userid.value;
	window.open(url,"_blank_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=450,height=200");
			
}

function joinCheck(){
	
	if(document.frm.userid.value.length == 0){
		alert("아이디가 입력되지 않음");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length < 3){
		alert("아이디는 4글자 이상 가능");
		frm.userid.focus();
		return false;
	}
	if(document.frm.email.value == ""){
		alert("이메일이 입력되지 않음");
		frm.email.focus();
		return false;
	}	
	if(document.frm.name.value == ""){
		alert("닉네임이 입력되지 않음");
		frm.name.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해주세요.")
		frm.pwd.focus();
		return false;
	
	}
	if(document.frm.pwd.value.length < 5 ){
		alert("6글자이상 입력해주세요.")
		frm.pwd.focus();
		return false;
	
	}
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.phone.value == ""){
		alert("휸대폰 번호가 입력되지 않음");
		frm.phone.focus();
		return false;
	}
	if(document.frm.brithday.value == ""){
		alert("생년월일이 입력되지 않음");
		frm.brithday.focus();
		return false;
	}
	if(document.frm.Repetitious.value.length == 0){
		alert("아이디 중복체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}

