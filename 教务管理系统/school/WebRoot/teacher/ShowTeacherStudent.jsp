<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" session="true" %>
<%@ page import="com.sevenEleven.javaBean.teacher.DBO,com.sevenEleven.javaBean.teacher.Doing,java.util.List,java.util.Iterator" %>
<%@ page import="com.sevenEleven.Beans.CteacherBean" %>
<% 
String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
if (teacherID==null||teacherID==""){
	request.setAttribute("errorMSG","û�е�½���½�ѳ�ʱ");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}
Doing DB=DBO.DBODoing();
List allStudent=DB.GetMyStudent(teacherID);
Iterator it=allStudent.iterator();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>�鿴ѧ��</title>
</head>
<body>
<table border="1" width=50% align=center>
<%if (it.hasNext()){%>
<%while (it.hasNext()){ List rows=(List)it.next();%>
<tr><td align=center><%=rows.get(1)%></td><td align=center><a href="StuResult?s_id=<%=rows.get(0)%>">�ɼ�</a></td><%=DB.IsRequire(teacherID)?"":"<td><a href=DelStuFromClass?s_id="+rows.get(0)+" onclick='return confirm(\"ȷ��ɾ����ѧ��������Ϣ?\")'>ɾ��</a></td>"%></tr>
<%}}else{%>
<tr><td align=center>û�����ѧ��</td></tr>
<%}
DB.Close();%>
</table>
<div align=center><input type="button" onclick="window.location.href='info_teacher.jsp'" value="����"></div>
</body>
</html>