<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<!------ϵͳ����javascript----->
<script language="JavaScript">
<!--
function delete_confirm() {
//��ɾ������ʱ������ȷ�϶Ի���
   if(confirm("ȷ��Ҫɾ����")){
  		return true;
	}else return false;	
}
-->
</script>
<jsp:include page="../adminmoduleup.jsp"/>
<c:set var="pagePath" value="/admin/book/dispBookInfo.do"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
	<tr><td colspan="6">
		<font size="2" color="#000080">�޸������Ϣ</font>
	</td></tr>
	<html:form action="${pagePath}" method="post" focus="bookname">
	<tr><td colspan="6"><font size="2" color="#000080">
		������<html:text property="bookname" size="40"/>
		<html:submit value="�ύ"/>
	</font></td></tr>
	</html:form>
	<tr><td colspan="6" align="right"><font size="2" color="#000080">
		<%@ include file="../common/page.txt"%>
	</td></tr>
	<tr><td align="center"><font size="2" color="#000080">ID��</font></td>
		<td width="200" align="center"><font size="2" color="#000080">����</font></td>
		<td align="center"><font size="2" color="#000080">����</font></td>
		<td align="center"><font size="2" color="#000080">������</font></td>
		<td align="center"><font size="2" color="#000080">�޸�?</font></td>
		<td align="center"><font size="2" color="#000080">ɾ��?</font></td>
	</tr>
	<c:forEach items="${CurrentPageArray}" var="book">
		<tr><td align="center"><font size="2" color="#000080">
			<c:out value="${book.bookid}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<c:out value="${book.bookname}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<c:out value="${book.author}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<c:out value="${book.publisher}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<html:link page="/admin/book/updateBook.jsp"
				paramId="bookid" paramName="book" paramProperty="bookid">
			�޸�</html:link>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<html:link page="/admin/book/deleteBookAction.do"
				paramId="bookid" paramName="book" paramProperty="bookid" onclick="return delete_confirm()">
			ɾ��</html:link>&nbsp;</font></td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="../adminmoduledown.jsp"/>