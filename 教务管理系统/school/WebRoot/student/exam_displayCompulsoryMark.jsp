<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>���޿δ��</title>
</head>
<body>
<center><h1>���ĳɼ�����</h1></center>
<p>${student.s_name}����,</p>
<p>���ĵ�ѡ�����Ϊ:${choose1Mark}</p>
<p>���Ķ�ѡ�����Ϊ:${choose2Mark}</p>
<p>������������Ϊ:${textMark}</p>
<p>���Ŀ��Է���Ϊ:${s_mark}</p>
<a href="Cexam_getStudentCourseTocompulsoryPage" >���ؿ���ҳ��</a>
</body>
</html>