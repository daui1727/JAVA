function empCheck(){
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력하세요");
		return false;
	}
	
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	
	if(document.frm.name.value.length == 0){
		alert("이름을 입력하세요");
		return false;
	}
	
	if(document.frm.phone.value.length == 0){
		alert("전화번호를 입력하세요");
		return false;
	}
	
	return true;
}