<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html>
  <head>
    <title>��ʿ�������Ҳ鿴</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head> 
  <body>
  	<form action="<%=request.getContextPath()%>/nurse_operationRoomServlet?opertion=4" method="post">  	
  	<table class="simple textCss">
  	<tr><th align="center" colspan="4">��ʿ�������ұ�</th></tr>
  	<tr>
  		<th width="20%" align="center">��ʿ���</th>
  		<th width="30%" align="center">��ʿ����</th>
  		<th width="20%" align="center">�����ұ��</th>
  		<th width="30%" align="center">����������</th>
  	</tr>
  	<%
  		ArrayList arr=(ArrayList)request.getAttribute("nurse_operationRoomList");
  		if(arr!=null){
  	 %>
  	 <tr>
  	 	<td align="center"><%=arr.get(0)%></td>
  	 	<td align="center"><%=arr.get(1)%></td>
  	 	<td align="center"><%=arr.get(2)%></td>
  	 	<td align="center"><%=arr.get(arr.size()-1)%></td>
  	 </tr>
  	 <% }%>
  	 </table>
  	 <table class="simple textCss">  	 
  		<tr><th align="center" colspan="4">
			<input type="button" class="buttonClass" value="����" 
				onclick="window.location.href='<%=request.getContextPath()%>/view_zhouxiaoli/nurse_operationRoom.jsp'">
		</th></tr>
  	 </table>
  	 </form>
  </body>
</html>
