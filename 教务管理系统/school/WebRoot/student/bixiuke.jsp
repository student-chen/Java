<%@ page language="java" contentType="text/html; charset=gb2312"
    import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<body>
<%List list=(List)request.getAttribute("lesson1"); 
    Iterator it=list.iterator();
    List listColumn = new LinkedList();
    %>
  <table width="663" height="15" border="1">
  <tr>
    <td width="66">�༶��</td>
    <td width="126">�༶��</td>
    <td width="64">�γ̺�</td>
    <td width="130">�γ���</td>
    <td width="50">��ʦ��</td>
    <td width="70">��ʦ��</td>
    <td width="125">����</td>
    <td width="66">ʱ��</td>
</tr>
  <% while (it.hasNext())
  { 
	  listColumn=(List)it.next();
	  %>
	  <tr>
	  <% 
	 for(int i=0;i<listColumn.size();i++){
		  %>
 
   <td width="46"> <%=listColumn.get(i)%> </td>
   
  
    <%} %>
    </tr>
	 <%}%>
	  </table>

</body>
</html>