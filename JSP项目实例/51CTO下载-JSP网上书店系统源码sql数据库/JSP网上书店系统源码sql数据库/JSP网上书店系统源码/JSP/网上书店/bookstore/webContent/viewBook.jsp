<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/fn.tld" %>
<%@ page isELIgnored="false"%>
<jsp:include page="banner.jsp"/>
<jsp:useBean id="bookOP" scope="page" class="bean.db.bookOPBean"/>
<jsp:setProperty name="bookOP" property="bookid" value="${param.bookId}"/> 
<c:set var="book" value="<%=bookOP.selectBookById(bookOP.getBookid())%>"/>
<table width="777">
<tr>
	<td><img border="0" src="admin/book/showbookimg.jsp?bookid=${book.bookid}" height="280"></td>
	<td><font size="2" color="#000080">
	<a href="<%=request.getContextPath()%>/addbooktocar.do?book_id=${book.bookid}">���빺�ﳵ</a><br>
	����:${book.bookname}<br>
	������:${book.publisher}<br>
	����:${book.author}<br>
	ԭ��:${book.price}<br>
	�ۺ��:${book.price*book.price_rebate*0.1}(${book.price_rebate}��)<br>
	ҳ��:${book.pagecount}<br>
	����:${book.format}<br>
	���ݼ��:<br>
	${book.simple_content}<br>
	</font></td>
</tr>
</table>
<jsp:include page="bottom.jsp"/>