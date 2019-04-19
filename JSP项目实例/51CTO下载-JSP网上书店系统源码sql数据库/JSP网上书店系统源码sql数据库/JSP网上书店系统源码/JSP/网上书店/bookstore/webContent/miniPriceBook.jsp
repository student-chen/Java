<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/fn.tld" %>
<%@ page isELIgnored="false"%>
<jsp:include page="banner.jsp"/>
<table border="0" cellpadding="0" cellspacing="0" width="777">
  <tr>
    <td width="160">
      <jsp:include page="user/userlogin.jsp"/>
    </td>
    <td>
      <table border="0" cellpadding="0" cellspacing="0" width="610">
        <tr>
        <jsp:useBean id="bookOP" scope="page" class="bean.db.bookOPBean"/>
        <jsp:setProperty name="bookOP" property="bookTypeId" value="${param.bookTypeId}"/>
        <c:set var="top6book" value="<%=bookOP.selectBookMiniPriceTop6()%>"/>
        <c:forEach items="${top6book}" var="book">
          <td><a href="viewBook.jsp?bookId=${book.bookid}">
          <img border="0" src="admin/book/showbookimg.jsp?bookid=${book.bookid}" height="130">
          </a><br><font size="2" color="#000080">${book.price_rebate}уш</font></td>
        </c:forEach>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table width="777">
<c:set var="books" value="<%=bookOP.selectBookMiniPrice()%>"/>
<c:set var="i" value="0"/>
<c:forEach items="${books}" var="book">
	<c:if test="${i%3==0}">
		<tr>
	</c:if>
	<td><font size="2" color="#000080">
		<a href="viewBook.jsp?bookId=${book.bookid}">
		<li>[${book.price_rebate}уш]
		<c:if test="${fn:length(book.bookname)>12}">
          	<c:out value="${fn:substring(book.bookname,0,12)}"/>...
        </c:if>
        <c:if test="${fn:length(book.bookname)<=12}">
          	<c:out value="${book.bookname}"/>
        </c:if></a>
	</font></td> 
	<c:set var="i" value="${i+1}"/>
	<c:if test="${i%3==0}">
		</tr>
	</c:if>
</c:forEach>  
</table>
<jsp:include page="bottom.jsp"/>