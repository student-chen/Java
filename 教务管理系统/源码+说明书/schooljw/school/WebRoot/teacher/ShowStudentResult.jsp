<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" session="true" %>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@ page import="com.sevenEleven.Beans.CteacherBean" %>
<% 
String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
if (teacherID==null||teacherID==""){
	request.setAttribute("errorMSG","��û�е�½���½�ѳ�ʱ");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}
List StudentRes=(List)request.getAttribute("StudentResult");
if (StudentRes==null){
	request.setAttribute("errorMSG","δ��ý��,ȷ�������Ƿ�Ϸ�");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>ѧ���ɼ���ѯ</title>
</head>
<body>
<form method="post" action="AddNorScore">
<table border=1 width=50% align=center>
<%
Iterator it=StudentRes.iterator();
if (it.hasNext()){
	List row=(List)it.next();%>
	
<tr><td>ѧ����</td><td>ѧ����</td><td>�ܷ�</td><td>���Է�</td><td>ƽʱ��</td><td>���</td></tr>
<tr><td><input type="text" name="s_id" readonly value="<%=row.get(0)%>"></td><td><%=row.get(1)%></td><td><%=row.get(2)==null?"δ���ܷ�":row.get(2)%></td><td><input type="text" name="Scored" value="<%=row.get(3)==null?"δ�����Է�":row.get(3)%>"></td><td><input type="text" name="stuScore" value="<%=row.get(4)==null?"δ��ƽʱ��":row.get(4)%>" size=3></td><td align=center><input type=submit value="����"></td></tr>
ƽʱ��ռ�ֵܷİٷֱ�Ϊ:<input type = "text" name = "scorePersent" value="" />%
	<%
}else{%>
	<tr><td>û�д�ѧ���ĳɼ�,û�п��Ի�δ�����ɼ�</td></tr>
<%}
%>
</table></form>
<div align=center border=0>
<input type="button" value="����" onclick="window.location.href='ShowTeacherStudent.jsp'">
</div>

</body>
</html>