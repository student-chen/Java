<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!------------------- javaScript ---------------->
<script language="JavaScript" src="../res/js/main.js"> 
</script> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>��ѡ�����ʾ���޸�</title>

</head>
<body>
<form action="Cexam_newPageUpdateChoose2" method=post>
<table width="700" >
	<tr>
		<td>${requestScope.type}</td>
	</tr>
	<tr>
	<tr>
		<td><textarea name="choose2_head"  clos=" " rows="10" cols="75">
       ${choose2.ch_question }
  </textarea></td>
	</tr>
</table>
<!----------------------------- ��ѡ�е�ѡ��ʹ� ------------------------>
<input value="${choose2.ch_id }" name="choose2_id" type="hidden"/>
<table width="700" >
	<tr>
		<td width="50" class="BODY">ѡ��A:</td>

		<td width="450" class="BODY"><input type="text" name="choose2_keya"
			size="80" value="${requestScope.choose2.keya }" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��B:</td>
		<td><input type="text" name="choose2_keyb" size="80"
			value="${requestScope.choose2.keyb }" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��C:</td>
		<td><input type="text" name="choose2_keyc" size="80"
			value="${requestScope.choose2.keyc }" /></td>
	</tr>
	<tr>
		<td class="BODY">ѡ��D:</td>
		<td><input type="text" name="choose2_keyd" size="80"
			value="${requestScope.choose2.keyd }" /></td>
	</tr>
	<tr>
		<td class="BODY">��:</td>
		<td><input type="text" name="choose2_answer" size="80"
			value="${requestScope.choose2.answer }" /></td>
		<td><input type="submit" name="update" value="�޸�" /></td>
		<td><input type="reset" name="reset" value="����" /></td>
	</tr>
</TABLE>
</body>
</html>
