<%@ page language="java"pageEncoding="gbk"%>
<html>
  <head>
    <title>��ʿ������</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>  
  <body>
   <form action="<%=request.getContextPath()%>/nurse_operationRoomServlet?opertion=4" method="post">
   <table class="simple textCss">
   <tr>
	   	<th width="20%" align="right">��ʿ����:</th>
	   	<th width="30%"><input type="text" name="name" class="txt"></th>
	   	<th width="20%"><input type="submit" value="��ѯ" class="buttonClass"></th> 
	   	<th width="30%"><input type="button" value="���������" class="buttonClass" 
	   		onclick="window.location.href='<%=request.getContextPath()%>/view_wujirui/addOprationRoom.jsp'">
	   	</th>   	
    </tr>
   </table>
   </form>
   </body>
</html>
   	
