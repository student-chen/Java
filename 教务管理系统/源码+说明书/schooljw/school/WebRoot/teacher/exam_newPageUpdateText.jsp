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
<title>�������ʾ���޸�</title>
</head>


<body>
<form action="Cexam_newPageUpdateText" method=post>
<table width="700" >
	<tr>
		<td>${requestScope.type}</td>
	</tr>
	<tr>
	<tr>
		<td><textarea name="text_question" clos="" 
			rows="10" cols="60">
       ${requestScope.text.text_question}
  </textarea></td>
	</tr>
</table>
<!----------------------------- ����еĴ� ------------------------>
<input value="${text.text_id }" name="text_id" type="hidden"/>
<table width="700" >

	<tr>
		<td class="BODY">��:</td>
		<td><input type="text" name="text_answer" value="${requestScope.text.text_answer}"
			size="80" /></td>
		<td><input type="submit" name="update" value="�޸�" /></td>
		<td><input type="reset" name="reset" value="����" /></td>
	</tr>
</TABLE>
</body>
</html>
