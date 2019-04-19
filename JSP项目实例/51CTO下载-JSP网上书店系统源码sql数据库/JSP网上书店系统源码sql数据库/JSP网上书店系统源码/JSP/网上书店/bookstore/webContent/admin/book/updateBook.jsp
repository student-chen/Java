<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ page isELIgnored="false"%>
<jsp:include page="../adminmoduleup.jsp"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
   <tr><td colspan="2"><font size="2" color="#000080">
     书藉资料修改
   </font></td></tr>
   <tr align="center"><td colspan="2"><font color="red"><html:errors/></font></td></tr>
   <tr><td align="right"><font size="2" color="#000080">ID号</font></td><td>
   	<font size="2" color="#000080">${param.bookid}</font>
   </td></tr>
   <html:form action="/admin/book/updateBookAction.do" method="post" focus="bookname">
 		<html:hidden property="bookid" value="${param.bookid}"/>
 		<%@ include file="bookview.txt"%>
   <tr><td colspan="2" align="center">
   	<html:submit value="提交"/>
   </td></tr>
   </html:form>
</table>
<jsp:include page="../adminmoduledown.jsp"/>