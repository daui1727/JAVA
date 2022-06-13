function check(){
	if(document.frm.job.value == ""){
		alert("직업 선택해주세요.");
		document.frm.job.focus();
		return false;
	}else if(document.frm.interest.value == ""){
		alert("관심분야 선택해주세요.");
		document.frm.interest.focus();
		return false;
	}else{
		return true;
	}
}