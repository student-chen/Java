<%@ page  session="true" language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>

</head>
<body>
  <% 
  List list=(List)request.getAttribute("lesson2");
  List listid=(List)request.getAttribute("l2id");
   Iterator it = list.iterator();
   Iterator itid=listid.iterator();
    List listColumn=new LinkedList();
    List listId=new LinkedList();
    %>
	<table width="363" height="27" border="1">
	<tr>
	<td width="46">&nbsp;</td>
    <td width="64">�γ̺�</td>
    <td width="50">�γ���</td>
    <td width="50">��ʦ��</td>
    <td width="50">��ʦ��</td>
    <td width="45">����</td>
    <td width="46">ʱ��</td>
    <td width="46">Ԥ�޿�Ŀ��</td>
    <td width="46">Ԥ�޿�Ŀ</td>
</tr>
 <%int mm=0;
 while(it.hasNext()&&itid.hasNext()){
	listColumn=(List)it.next();
	 listId=(List)itid.next();
 %>
  <tr>
   
       <%
     for(int i=0;i<listId.size();i++){ %>
     <form  method="post" name="checkboxs<%=mm%>" action="TiJiaoL2CourseTable" > 
     <td width="46">
       <input   type="checkbox" name="checkbox" value="<%=listId.get(i)%>"/>
        </td>
		<%for(int j=0;j<listColumn.size();j++){%>
        <td width="64"><%=listColumn.get(j)%></td>
    <%}%>
   
    <%mm++;}%>
  </tr>
   <%}%>
    </tr>
	</table>
	<input type="submit"  value="�ύ">
	 </form>
</body>
</html>
