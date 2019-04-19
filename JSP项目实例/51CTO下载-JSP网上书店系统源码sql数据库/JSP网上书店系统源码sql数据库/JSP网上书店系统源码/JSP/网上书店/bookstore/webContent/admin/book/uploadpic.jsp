<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<%@ page import="java.io.OutputStream,bean.db.bookOPBean,bean.db.bookBean"%>
<jsp:include page="../adminmoduleup.jsp"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
	<tr><td colspan="4">
		<font size="2" color="#000080">上传书藉图片</font>
	</td></tr>
	<tr><td align="center"><font size="2" color="#000080">ID号</font></td>
		<td width="200" align="center"><font size="2" color="#000080">书名</font></td>
		<td align="center"><font size="2" color="#000080">作者</font></td>
		<td align="center"><font size="2" color="#000080">出版社</font></td>
	</tr>
	<jsp:useBean id="bookOP" scope="page" class="bean.db.bookOPBean">
		<jsp:setProperty name="bookOP" property="bookid" value="${param.bookid}"/>
	</jsp:useBean>
	<c:set var="book" value="<%=bookOP.selectBookById(bookOP.getBookid())%>"/>
	<tr><td align="center"><font size="2" color="#000080">${book.bookid}&nbsp;</font></td>
		<td width="200" align="center"><font size="2" color="#000080">${book.bookname}&nbsp;</font></td>
		<td align="center"><font size="2" color="#000080">${book.author}&nbsp;</font></td>
		<td align="center"><font size="2" color="#000080">${book.publisher}&nbsp;</font></td>
	</tr>
	<tr><td colspan="4">
		<font size="2" color="#000080">上传图片:</font>
	</td></tr>
	<html:form action="/admin/book/uploadPic.do" enctype="multipart/form-data">
	<tr><td colspan="2">
		<font size="2" color="#000080">原图片:<br>
		<c:if test="${empty book.imageByteArray}">
			无图片
		</c:if>
		<c:if test="${not empty book.imageByteArray}">
			<html:img src="showbookimg.jsp?bookid=${param.bookid}" height="230"/>
		</c:if>
		</font>
	</td><td colspan="2" valign="top">
		<font size="2" color="#000080">现图片:<br>
		<html:hidden property="bookid" value="${param.bookid}"/>
		<html:file property="file"/>
		<html:submit value="提交"/>
		</font>
	</td></tr>
	</html:form>
</table>
<jsp:include page="../adminmoduledown.jsp"/>