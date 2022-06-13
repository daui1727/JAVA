function check(){
	if(document.frm.content.value == ""){
		alert("인사 안하시나요?");
		document.frm.content.focus();
		return false;
	}else{
		return true;
	}
}