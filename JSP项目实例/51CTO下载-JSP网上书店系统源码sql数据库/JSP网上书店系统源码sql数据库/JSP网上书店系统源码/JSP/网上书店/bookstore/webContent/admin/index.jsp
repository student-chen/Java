<%@ page contentType="text/html;charset=GB2312" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<jsp:include page="adminmoduleup.jsp"/>
<table border="0" cellpadding="0" cellspacing="0" width="610">
   <tr valign="top"><td>
          <br><br><font size="2" color="#000080">
     		����ʱ����:
     		<fmt:formatDate value="<%=new Date()%>" pattern="G yyyy'��'MM'��'dd'��' HH:mm:ss z"/>
     		<br>
     		��ӭ������������̨����ϵͳ!<br>  		
     		</font>
   </td></tr>
</table>
<jsp:include page="adminmoduledown.jsp"/>
