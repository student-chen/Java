<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<jsp:include page="../adminmoduleup.jsp"/>
<c:set var="pagePath" value="/admin/booktype/updatebooktype.do"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
	<tr><td colspan="4">
		<font size="2" color="#000080">修改书藉类型信息</font>		
	</td></tr>
	<tr><td colspan="4">
		<font size="2" color="red"><html:errors/></font>
	</td></tr>
	<tr><td colspan="2" align="right">
		<font size="2" color="#000080">类型ID:</font>
	</td><td colspan="2" align="left">
		<font size="2" color="#000080">${param.booktypeid}</font>
	</td></tr>
	<html:form action="${pagePath}" method="post">
	<html:hidden property="booktypeid" value="${param.booktypeid}"/>
	<jsp:useBean id="bookTypeOP" scope="page" class="bean.db.bookTypeOPBean">
		<jsp:setProperty name="bookTypeOP" property="bookTypeIdStr" value="${param.booktypeid}"/>
	</jsp:useBean>
	<c:set var="bookType" value="<%=bookTypeOP.selectBookTypeId()%>"/>
	<tr><td colspan="2" align="right">
		<font size="2" color="#000080">类型名称：</font>
	</td><td colspan="2" align="left">
		<font size="2" color="#000080"><html:text property="booktypename" size="40" value="${bookType.bookTypeName}"/></font>
	</td></tr>
	<tr><td colspan="4" align="center"><font size="2" color="#000080">
		<html:submit value="提交"/>
	</font></td></tr>
	</html:form>
</table>
<jsp:include page="../adminmoduledown.jsp"/>