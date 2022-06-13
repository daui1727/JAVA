function loginCheck(){
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요.");
		/* 다시 아이디 값을 입력받을 수 있도록 마우스 커서의 위치가 가게 하는 ~ focus()*/
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("암호를 써주세요.");
		frm.pwd.focus();
		return false;
	}
	
	return true;
}