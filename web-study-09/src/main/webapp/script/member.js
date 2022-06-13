function loginCheck(){
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해주세요");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("암호를 입력해주세요");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력해주세요");
		document.frm.userid.focus();
		return;
	}
	
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, scrollbar=yes, resizable=no, width=450, height=200");
}

function idok(){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close();
}

function joinCheck(){
	if(document.frm.name.value.length == 0){
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요.");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.reid.value.length == 0){
		alert("중복 체크를 하지 않았습니다.");
		frm.reid.focus();
		return false;
	}
	
	return true;
}



/* 새 창을 여는 window.open() 함수
 var ret = window.open(url, name, specs, replace);
 url --> 새 창에 보여줄 주소. 비워두면 빈창(about:blank)이 보입니다.
 name --> 새로 열릴 창의 속성 또는 이름. 기본 값은 _blank
 	_blank: 새 창 , _parent: 부모 프레임에 열림
 	_self: 현재 페이지 대체,  _top: 로드된 프레임셋을 대체, 
 	_name(임의의 이름): 새 창이 열리고 창의 이름 지정. 동일한 이름에 다시  open() 을 하면 기존의 열린창의 내용이 바뀝니다. 다른 이름을 사용하면 또다른 새창이 열립니다.
 
 specs --> 선택적인 값으로 창의 크기, 스크롤 여부, 리사이즈 가능 등의 속성 지정.
 	height, width, left, top, location, menubar, resizable, scrollbars, status, titlebar, toolbar
 
 replace --> 히스토리 목록에 새 항목을 만들지 현재 항목을 대체할지 지정합니다.
 	true :  현재 히스토리 대체
 	false : 새 항목 만듬
*/