<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>�ſε�һ��-ѡ��༶�͵ڼ��׶�</title>
</head>
<body>
�ſε�һ��-ѡ��༶�͵ڼ��׶�
<br>
<form name="" action="CautoMakeScheme_getCalssAndPhaseTosession" method="POST">
<table width="400">
	<tr>
		<td><label>�༶:<SELECT id="class" name="class">

			<c:forEach items="${myClassList}" var="myClass">
				<option value="${myClass.name}"/>${myClass.name}
			</c:forEach>
		</SELECT></label></td>
		<td><label>�׶�:<SELECT id="phase" name="phase">
			<option value="A" />A�׶�
			
		</SELECT></label></td>
		<td><input name="" type="submit" value="ȷ��" /></td>
	</tr>
</table>
<font color="red">${warnMessage}</font>
</body>
</html>
