<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>˼Զ2030��ѧ����ϵͳ - powered by ThinkBank!</title>



<style type="text/css"><!--
a			{ text-decoration: none; color: #003366 }
a:hover			{ text-decoration: underline }
body			{ scrollbar-base-color: #000000; scrollbar-arrow-color: #000000; font-size: 12px; background-color: #000000 }
table			{ font: 12px Tahoma, Verdana; color: #000000 }
input,select,textarea	{ font: 11px Tahoma, Verdana; color: #000000; font-weight: normal; background-color: #F8F8F8 }
form			{ margin: 0; padding: 0}
select			{ font: 11px Arial, Tahoma; color: #000000; font-weight: normal; background-color: #F8F8F8 }
.nav			{ font: 12px Tahoma, Verdana; color: #000000; font-weight: bold }
.nav a			{ color: #000000 }
.header			{ font: 11px Tahoma, Verdana; color: #FFFFFF; font-weight: bold; background-color: #000000 }
.header a		{ color: #FFFFFF }
.category		{ font: 11px Arial, Tahoma; color: #000000; background-color: #EFEFEF }
.tableborder		{ background: #000000; border: 1px solid #FFFFFF } 
.singleborder		{ font-size: 0px; line-height: 1px; padding: 0px; background-color: #F8F8F8 }
.smalltxt		{ font: 11px Arial, Tahoma }
.outertxt		{ font: 12px Tahoma, Verdana; color: #000000 }
.outertxt a		{ color: #000000 }
.bold			{ font-weight: bold }
.altbg1			{ background: #F8F8F8 }
.altbg2			{ background: #FFFFFF }
.maintable		{ width: 98%; background-color: #FFFFFF }
--></style>
</head>
<SCRIPT language="JavaScript">
function check()
{
    var username = document.register.username.value;
    var name = document.register.name.value;
    var password = document.register.password.value;
    var password2 = document.register.password2.value;
    var skill = document.register.skill.value;
    
	if((username == "")||(!username.match(/^[0-9a-z]*$/i))
	{
		alert("���ύ�˷Ƿ��ַ���");
		return false;
	}
	if((password == "")||(!password.match(/^[0-9a-z]*$/i))||(password2 == "")||(!password2.match(/^[0-9a-z]*$/i)))
	{
		alert("���ύ�˷Ƿ��ַ���");
		return false;
	}
	if((skill == "")||(!skill.match(/^[0-9a-z]*$/i)))
	{
		alert("���ύ�˷Ƿ��ַ���");
		return false;
	}
	if(password != password2)
	{
	    alert("ȷ���������");
	    return false;
	}

}</script>
<body leftmargin="0" rightmargin="0" topmargin="0">

<table bgcolor="#FFFFFF" width="98%" cellpadding="0" cellspacing="0"
	border="0" align="center">



	<!--<div class="maintable"><br>
	<table cellspacing="0" cellpadding="0" border="0" width="98%"
		align="center" style="table-layout: fixed">
		<tr>
			<td class="althg1" width="90%" align="left" nowrap>˼Զ2030�������ϵͳ<a
				href="index.jsp"></a> &raquo; ѧ��ע��</td>
			<td align="right" width="10%">&nbsp;<a href="#bottom"></a></td>
		</tr>
	</table>
	<br>
	-->
	<form method="post" name="register" action="TeaRegisterServlet">

	<table cellspacing="1" cellpadding="4" width="98%" align="center"
		class="tableborder">
		<tr>
			<td colspan="2" class="header"><a href="" target=""></a>��ʦע�� - ��������</td>
		</tr>
		<tr>
			<td class="altbg1" width="21%">���ţ��û�����:</td>
			<td class="altbg2"><input type="text" name="username" size="25"
				maxlength="25">
		</tr>
		<tr>
			<td class="altbg1" width="21%">����:</td>
			<td class="altbg2"><input type="text" name="name" size="25"
				maxlength="25"></td>
		</tr>
		<tr>
			<td class="altbg1">����:</td>
			<td class="altbg2"><input type="password" name="password" size="25"></td>
		</tr>

		<tr>
			<td class="altbg1">ȷ������:</td>
			<td class="altbg2"><input type="password" name="password2" size="25"></td>
		</tr>


		<tr>
			<td class="altbg1" valign="top">����:</td>
			<td class="altbg2"><input type="text" name="skill" size="25"
				maxlength="25"><span class="smalltxt"><span class="bold">&nbsp;&nbsp;��д������Ҫ��רҵ�ʻ�</span></span></td>
		</tr>
		<tr>
			<td colspan="2" class="header">ע�� - ѡ������</td>
		</tr>

		<tr>
			<td class="altbg1">��ȫ����:</td>
			<td class="altbg2"><select name="questionid">
				<option value="0">�ް�ȫ����</option>
				<option value="1">ĸ�׵�����</option>
				<option value="2">үү������</option>
				<option value="3">���׳����ĳ���</option>
				<option value="4">������һλ��ʦ������</option>
				<option value="5">�����˼�������ͺ�</option>
				<option value="6">����ϲ���Ĳ͹�����</option>
				<option value="7">��ʻִ�յ������λ����</option>
			</select> <span class="smalltxt"><span class="bold">��������ð�ȫ���ʣ���¼ʱ��������Ӧ����Ŀ���ܵ�¼</span></span></td>
		</tr>

		<tr>
			<td class="altbg1">�ش�:</td>
			<td class="altbg2"><input type="text" name="answer" size="25"></td>
		</tr>

		<tr>
			<td colspan="2" class="singleborder">&nbsp;</td>
		</tr>
		<tr>
			<td class="altbg1">�Ա�:</td>
			<td class="altbg2"><input type="radio" name="gendernew" value="1"> ��
			&nbsp; <input type="radio" name="gendernew" value="2"> Ů &nbsp; <input
				type="radio" name="gendernew" value="0" checked> ����</td>
		</tr>

		<tr>
			<td class="altbg1">����:</td>
			<td class="altbg2"><input type="text" name="year" size="25"></td>
		</tr>


		<tr>
			<td class="altbg1">QQ:</td>
			<td class="altbg2"><input type="text" name="qq" size="25"></td>
		</tr>


		<tr>
			<td class="altbg1">MSN:</td>
			<td class="altbg2"><input type="text" name="msn" size="25"></td>
		</tr>





		<tr>
			<td class="altbg1" valign="top">���ҽ���:</td>
			<td class="altbg2"><textarea rows="5" cols="30" name="bio"></textarea></td>
		</tr>
	</table>
	<br>
	<center><input type="submit" name="regsubmit" value="�� &nbsp; ��"
		onclick="return check();"></center>
	</form>



	<br>
	<br>
	</div>
	<a name="bottom"></a>
	<div class="maintable"></div>

	<div class="maintable">
	<table cellspacing="2" cellpadding="0" align="center"
		style="font-size: 11px; font-family: Tahoma, Arial">
		<tr>
			<td align="right"><a href="http://shulixi.hbut.edu.cn/"
				target="_blank"></a> &nbsp;</td>
			<td>Powered by <a href="http://shulixi.hbut.edu.cn/" target="_blank"><b>thinkbank</b></a><b
				style="color:#FF9900"></b> &nbsp;&copy; 2006-2007 ��ѧԺ ��Ȩ����<a
				href="http://shulixi.hbut.edu.cn/" target="_blank">.</a> <br>
			Processed in 0.096299 second(s), 5 queries , Gzip enabled</td>
		</tr>
	</table>
	<br>
	</div>

	<div class="maintable">
	<table cellspacing="0" cellpadding="1" width="100%" class="outertxt">
		<tr>
			<td>
			<table cellspacing="0" cellpadding="4" width="100%" class="smalltxt">

				<tr
					style="font-size: 0px; line-height: 0px; spacing: 0px; padding: 0px; background-color: #000000">
					<td colspan="3">&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	</center>
	<br>
</body>
</html>
