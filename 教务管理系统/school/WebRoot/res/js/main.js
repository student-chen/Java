//--------------------------------------------------
//��û�õ� 
function movefocus(){
  if(window.event.keyCode==13)
  {
      fullwin();
  }
 }

//--------------------------------------------------
function fullwin(){
  if (FormWelcome.userid.value=="")
   {
    alert("�û�������Ϊ�գ�");
	document.FormWelcome.userid.focus();
	document.FormWelcome.userid.select();
	return false;  
   }
  else
   {
    if (FormWelcome.pswd.value=="")
    {
    alert("���벻��Ϊ�գ�");
	document.FormWelcome.pswd.focus();
	document.FormWelcome.pswd.select();
	return false;  
    }
   }
  }