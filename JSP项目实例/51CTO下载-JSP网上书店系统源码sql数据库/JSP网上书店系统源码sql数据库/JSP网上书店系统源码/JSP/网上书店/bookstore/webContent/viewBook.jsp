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
	<a href="<%=request.getContextPath()%>/addbooktocar.do?book_id=${book.bookid}">放入购物车</a><br>
	书名:${book.bookname}<br>
	出版社:${book.publisher}<br>
	作者:${book.author}<br>
	原价:${book.price}<br>
	折后价:${book.price*book.price_rebate*0.1}(${book.price_rebate}折)<br>
	页数:${book.pagecount}<br>
	开本:${book.format}<br>
	内容简介:<br>
	${book.simple_content}<br>
	</font></td>
</tr>
</table>
<jsp:include page="bottom.jsp"/>