<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�վ�ά��</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>
  
  <body>
  <form action="<%=request.getContextPath()%>/doctorServlet?operation=1" method="post">
  <table class="simple textCss">
  <tr>
  	<th colspan="2" align="center">�վ�ά��</th>
  </tr>
  <tr>
  	<th width="20%" align="center"> ְ�ƣ�</th>
  	<td><input type="text" name="" class="txt"></td>
  </tr>
  <tr>
  	<td colspan="2" align="center">
  		<input type="button" value="�ύ" class="buttonClass"/>&nbsp;&nbsp;&nbsp;
  		<input type="button" value="����" class="buttonClass"/>
  	</td>
  </tr>
  </table>
  </form>
  </body>
</html>