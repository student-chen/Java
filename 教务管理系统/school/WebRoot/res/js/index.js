function check(){
var post = document.form.username.value;
    var pass = document.form.password.value;
  if (post=="")
   {

    alert("�û�������Ϊ��");
    document.form.username.focus();
	document.form.username.select();
  return false;  
   }
  else if(pass=="")
    {
    alert("���벻��Ϊ��");
	document.form.password.focus();
	document.form.password.select();
	return false;  
    }
   else if(!post.match(/^[0-9a-z]*$/i))
	{
		alert("�û����Ƿ��ַ�");
		document.form.username.focus();
	    document.form.username.select();
		return false;
	}
	else if(!pass.match(/^[0-9a-z]*$/i))
	{
	    alert("����Ƿ��ַ�");
		document.form.password.focus();
	    document.form.password.select();
		return false;
	}
	
  }
  //----------------------------------------//
