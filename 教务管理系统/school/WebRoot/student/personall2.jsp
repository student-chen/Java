<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("info");
			Iterator it = list.iterator();
			List listColumn = new LinkedList();
			%>
<table width="383" height="38" border="1">
<tr>
	<td width="76">ѧ��ID</td>
	<td width="89">ѧ������</td>
	<td width="76">�γ̺�</td>
	<td width="59">�γ���</td>
	<td width="59">��ʦ��</td>
	<td width="59">��ʦ</td>
	<td width="53">����</td>
	<td width="54">ʱ��</td>
	</tr>
	<%
	while (it.hasNext()) 
	{ 
		listColumn = (List) it.next();%>
		<tr>	
	<%for(int i=0;i<listColumn.size();i++) {%>
	<td width="76"><%=listColumn.get(i)%></td>
	<%} %>
	</tr>
	<%}%>
</table>
</table>

</table>
</body>
</html>
