<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("result_2");
			Iterator it = list.iterator();
			List listColumn = new LinkedList();
			%>
<table width="383" height="38" border="1">
��������ͼ�õ��ο���ʦ�ȸ�����Ϣ(����򵥻���)
<tr>
	<td width="89">ѧ������</td>
	<td width="59">ѡ�޿ο���</td>
	<td width="53">�ɼ�</td>
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
</body>
</html>