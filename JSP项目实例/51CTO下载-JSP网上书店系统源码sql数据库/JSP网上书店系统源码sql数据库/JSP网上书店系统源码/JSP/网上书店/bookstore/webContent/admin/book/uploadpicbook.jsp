<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<jsp:include page="../adminmoduleup.jsp"/>
<c:set var="pagePath" value="/admin/book/uploadPicDispBookInfo.do"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
	<tr><td colspan="6">
		<font size="2" color="#000080">上传书藉图片</font>
	</td></tr>
	<html:form action="${pagePath}" method="post" focus="bookname">
	<tr><td colspan="6"><font size="2" color="#000080">
		书名：<html:text property="bookname" size="40"/>
		<html:submit value="提交"/>
	</font></td></tr>
	</html:form>
	<tr><td colspan="6" align="right"><font size="2" color="#000080">
		<%@ include file="../common/page.txt"%>
	</td></tr>
	<tr><td align="center"><font size="2" color="#000080">ID号</font></td>
		<td width="200" align="center"><font size="2" color="#000080">书名</font></td>
		<td align="center"><font size="2" color="#000080">作者</font></td>
		<td align="center"><font size="2" color="#000080">出版社</font></td>
		<td align="center"><font size="2" color="#000080">有图片?</font></td>
		<td align="center"><font size="2" color="#000080">上传图片?</font></td>
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
			<c:if test="${empty book.imageByteArray}">
				无图片
			</c:if>
			<c:if test="${not empty book.imageByteArray}">
				已有图片
			</c:if>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<html:link page="/admin/book/uploadpic.jsp"
				paramId="bookid" paramName="book" paramProperty="bookid">
			上传图片</html:link>&nbsp;</font></td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="../adminmoduledown.jsp"/>