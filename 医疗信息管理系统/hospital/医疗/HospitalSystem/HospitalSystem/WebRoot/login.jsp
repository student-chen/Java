<%@page contentType="text/html;charset=gbk" %>
<html>
<head>
	<title>ҽԺ��Ϣ��ϵͳ</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<link href="<%=request.getContextPath()%>/Css/login.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
       function userName(UserName){
           var myName = /[^\u4E00-\u9FA5]/g;
           if(myName.test(UserName)){
               return true;
           }else{
               return false;
           }
       }
       function pass(Password){
           var myPass = /^[A-Za-z0-9]+$/;
           if(myPass.test(Password)){
               return true;
           }else{
               return false;
           }
       }
		function loginAllTest(){
			var username=document.loginAllForm.username.value;
			var password=document.loginAllForm.password.value;
			if(username==null||username==""){
				alert("����û���Ϊ�գ�");
				return false;
			}
			if(password==null||password==""){
				alert("�������Ϊ�գ�");
				return false;
			}
           if(userName(username)){
               alert("�û�������ȷ");
               document.loginAllForm.username.value="";
               return false;
           }
           if(!pass(password)){
               alert("���벻��ȷ");
               document.loginAllForm.password.value="";
               return false;
           }
			return true;
		}	
	</script>
<style type="text/css">
<!--
body {
	background-color: #1150af;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
</head>
<body>
<form method="post" name="loginAllForm" onsubmit="return loginAllTest();" action="loginServlet">
<table id="Table_01" width="1000" height="636" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">
			<img src="imgs/login/login_01.gif" width="1000" height="226" alt=""></td>
	</tr>
	<tr>
		<td><img src="imgs/login/login_02.jpg" width="331" height="80"></td>
		<td width="432" bgcolor="#000000">
		  <table width="100%" border="0" cellspacing="0" cellpadding="5">
            <tr>
              <td width="21%"><div align="right" class="white">�û�:</div></td>
              <td width="50%"><input type="text" name="username" maxlength="8" styleClass="form" tabindex="1"/></td>
              <td width="29%" align="center"><input type="submit" class="button" value="��¼"/></td>
            </tr>
            <tr>
              <td><div align="right" class="white">����:</div></td>
              <td><input type="password" name="password" styleClass="form" maxlength="14" tabindex="2"/></td>
              <td>&nbsp;</td>
            </tr>
		    <tr>
		       <td align="right" class="white">��¼����:</td>
		       <td class="white">
		       		<input type="radio" name="postOffice" value="ҽ��" checked="checked">ҽ��
		       		<input type="radio" name="postOffice" value="��ʿ">��ʿ
		       		<input type="radio" name="postOffice" value="����Ա">����Ա
		       </td>
           </tr>
          </table>	</td>
		  <td><img src="imgs/login/login_04.jpg" width="237" height="80" alt=""></td>
	</tr>
	<tr>
		<td colspan="5"><img src="imgs/login/login_05.jpg" width="1000" height="330" alt=""></td>
	</tr>
</table>
</form>
</body>
</html>