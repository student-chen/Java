<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>��ʿ������</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>
  <body>
   <form action="<%=request.getContextPath()%>/nurse_sickbedServlet?opertion=4" method="post">
   	<table class="simple textCss">
 	 <tr><th colspan="3" align="center">��ʿ������</th></tr>
   <tr>
   	<td width=30% align="center">��ʶ</td>
   	<td width=50% align="center">��ʿ����</td>
   	<td width=20% align="center">�������</td>
   	</tr>
  <%
	ArrayList arr=(ArrayList)request.getAttribute("MybedList");
	if(arr!=null&&arr.size()>=3)
	{
   %>
   <tr>
   	<td align="center"><%=arr.get(0) %></td>
   	<td align="center"><%=arr.get(1) %></td>
   	<td align="center"><%=arr.get(arr.size()-1) %></td>
   <%}else{
   		out.println("�Բ���û����Ҫ��ѯ�Ļ�ʿ�ڲ����й���......");
   }%>
   </tr>
   <tr>
   	<td colspan="3"><input type="button" class="buttonClass" value="����" onClick="window.location.href='${pageContext.request.contextPath}/view_zhouxiaoli/nurse_sickbed.jsp'">
   </tr>
   </table>
   </form>
  </body>
</html>   	