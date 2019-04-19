<%@ page contentType="text/html;charset=GB2312" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<jsp:include page="adminmoduleup.jsp"/>
<table border="0" cellpadding="0" cellspacing="0" width="610">
   <tr valign="top"><td>
          <br><br><font size="2" color="#000080">
     		现在时间是:
     		<fmt:formatDate value="<%=new Date()%>" pattern="G yyyy'年'MM'月'dd'日' HH:mm:ss z"/>
     		<br>
     		欢迎进入网上书店后台管理系统!<br>  		
     		</font>
   </td></tr>
</table>
<jsp:include page="adminmoduledown.jsp"/>
