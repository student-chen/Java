<%@ page language="java" pageEncoding="GBk"%>
<html>
  <head>    
    <title>�鿴����</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>  
  <body>
      <form action="<%=request.getContextPath() %>/nurse_sickbedServlet?opertion=4" method="post">
    <table class="simple textCss">
    <tr>
    	<th width="30%" align="right">��ʿ����:</th>
    	<th width="40%" class="txt"><input type="text" name="name" class="txt"
    		onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')"></th>
    	<th width="30%"><input type="submit" class="buttonClass" value="��ѯ"></th>
    </tr>
    </table>
    </form>
  </body>
</html>
