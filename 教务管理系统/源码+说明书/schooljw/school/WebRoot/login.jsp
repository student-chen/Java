<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>login</title>
<script type="javaScript">
function submitForm()
{
	if(document.form1.userName.value=="")
        {
           alert("�������û���");
           document.form1.userName.focus();
           return false;
        }else if(document.form1.userPassword.value=="")
        {
           alert("����������");
           document.form1.userPassword.focus();
           return false;
        }else
        {
          return true;
        }
}
</script>
</head>
<STYLE TYPE="text/css">
<!--
h3 { color: black; font-size: 20px; font-family: impact }
P.first { color: green }
P.second { color: purple }
P.third { color: gray } 
-->
</STYLE>

<body bgcolor="#bbccdd">
<center>
<h3><strong>У��ϵͳ��¼</strong></h3>
<hr color="green" size="1" align="center" width="300">
<form name="form1" method="post" action="CcheckUserServlet">
<table align="center">
	<tr>
		<td>�û���</td>
		<td><input type="text" name="userName" /></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="password" name="userPassword" /></td>
	</tr>
	<tr>
		<td>�û�����</td>
		<td><select name="userType" size="1">
			<option value="3" selected>ѧ��</option>
			<option value="2">��ʦ</option>
			<option value="1">����Ա</option>
			</select></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" onclick="return submitForm()" name="Submit"
			value="��¼"> &nbsp;&nbsp; <input type="reset" value="����"></td>
	</tr>

</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<p CLASS=first><font color="#800080" size="2">�������ͨ��by:˫����&nbsp;QQ:287307421&nbsp;�ֻ�:13558690869&nbsp;����ϵͳ�뵽˫���ֵ��Ա���:<a href='http://shop34864101.taobao.com' target='_blank'>http://shop34864101.taobao.com</a>��ѯ</font></p>
<p CLASS=second>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#800080" size="2">���Ի���Ϊ:windows xp+jdk1.5+Tomcat6.0+MyEclipse5.5+SQLServer2000</font></p>
<br>
<br>
</form>
</center>
</body>
</html>
