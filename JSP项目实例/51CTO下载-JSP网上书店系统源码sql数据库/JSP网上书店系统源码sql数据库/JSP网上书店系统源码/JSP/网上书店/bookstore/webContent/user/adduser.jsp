<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ page isELIgnored="false"%>
<jsp:include page="../banner.jsp"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
   <tr><td colspan="2"><font size="2" color="#000080">
     ��ע���û�
   </font></td></tr>
   <tr align="center"><td colspan="2"><font color="red"><html:errors/></font></td></tr>
   <html:form action="/adduser.do" method="post">
 	<tr><td align="right"><font size="2" color="#000080">
     �û���:</font></td><td width="400">
     <html:text property="user_name" size="40"/></td></tr>
     <tr><td align="right"><font size="2" color="#000080">
     ����:</font></td><td width="400">
     <html:password property="user_password" size="40"/></td></tr>
     <tr><td align="right"><font size="2" color="#000080">
     ������һ������:</font></td><td width="400">
     <html:password property="re_user_password" size="40"/></td></tr>
     <tr><td align="right"><font size="2" color="#000080">
     �û���ʵ����:</font></td><td width="400">
     <html:text property="user_true_name" size="40"/></td></tr>
     <tr><td align="right"><font size="2" color="#000080">
     ��ϵ��ַ:</font></td><td width="400">
     <html:text property="user_address" size="40"/></td></tr>
     <tr><td align="right"><font size="2" color="#000080">
     ��ϵ�绰:</font></td><td width="400">
     <html:text property="user_telephone" size="40"/></td></tr>
     <tr><td align="right"><font size="2" color="#000080">
     ��������:</font></td><td width="400">
     <html:text property="user_postalcode" size="40"/></td></tr>
     <html:hidden property="user_role" value="1"/>
   <tr><td colspan="2" align="center">
   	<html:submit value="�ύ"/>
   </td></tr>
   </html:form>
</table>
<jsp:include page="../bottom.jsp"/>