<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" session="true" %>
<%@ page import="com.sevenEleven.javaBean.teacher.DBO,com.sevenEleven.javaBean.teacher.Doing,java.util.List,java.util.Iterator" %>
<%@ page import="com.sevenEleven.Beans.CteacherBean" %>
<% 
String userID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
if (userID==null||userID==""){
	request.setAttribute("errorMSG","��û�е�½���½�ѳ�ʱ");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}
Doing DB=DBO.DBODoing();
String teacherNAME=DB.GetTeacherName(userID);
List teacherInfo=DB.GetTeacherInfo(userID);
Iterator it=teacherInfo.iterator();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title><%=teacherNAME%>������Ϣ</title>
</head>
<body>
<form name="updateTf" method="post" action="UpdateTeacherInfo">
<table border=1 align=center width=30%>
<%
if (it.hasNext()){
	List row=(List)it.next();%>
<tr><td align=center>����:<input name="teacherNAME" type="text" value="<%=row.get(1)%>" size=10></td></tr>
<tr><td align=center>����:<input type="text" value="<%=row.get(2)%>" size=10 readonly></td></tr>
<tr><td align=center>����:<input name="teacherPWD" type="text" value="<%=row.get(3)%>" size=10></td></tr>
<tr><td align=center>�γ�:<input type="text" value="<%=row.get(4)%>" size=10 readonly></td></tr>
<tr><td align=center><input type=submit value="�ύ"></td></tr>
<%}else{%>
<tr><td align=center>����ʦ�����ڻ���ɾ��</td></tr>
<%}
DB.Close();%>
</table></form>
<div align=center><input type="button" onclick="window.location.href='info_teacher.jsp'" value="����"></div>
</body>
</html>