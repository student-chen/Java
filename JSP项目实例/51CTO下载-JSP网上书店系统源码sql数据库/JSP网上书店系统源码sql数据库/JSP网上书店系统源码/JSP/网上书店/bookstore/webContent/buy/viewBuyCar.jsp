<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/fn.tld" %>
<%@ page isELIgnored="false"%>
<jsp:useBean id="bookOP" scope="page" class="bean.db.bookOPBean"/>
<jsp:include page="../banner.jsp"/>
<table border="0" cellpadding="0" cellspacing="0" width="777">
  <tr>
    <td width="170">
      <jsp:include page="../user/userlogin.jsp"/>
    </td>
    <td>
      <table border="1" cellpadding="0" cellspacing="0" width="607">
      	<tr><td align="center"><font size="2" color="#000080">序号</font></td>
      		<td align="center"><font size="2" color="#000080">书名</font></td>
      		<td align="center"><font size="2" color="#000080">出版社</font></td>
      		<td align="center"><font size="2" color="#000080">数量</font></td>
      		<td align="center"><font size="2" color="#000080">单价</font></td>
      		<td align="center"><font size="2" color="#000080">总价</font></td>
      		<td align="center"><font size="2" color="#000080">拿出一本?</font></td></tr>
      	<c:set var="book_no" value="${0}"/>
      	<c:set var="allbookcount" value="${0}"/>
      	<c:set var="allbookprice" value="${0}"/>
      	<!--显示购物车中的书藉信息-->
        <c:forEach items="${sessionScope.car.myGoods}" var="carbook">
         <c:set var="book_id" value="${fn:substringBefore(carbook,'=')}"/>
         <c:set var="book_count" value="${fn:substringAfter(carbook,'=')}"/>
         <jsp:setProperty name="bookOP" property="bookid" value="${book_id}"/> 
         <c:set var="book" value="<%=bookOP.selectBookById(bookOP.getBookid())%>"/>
        <tr><c:set var="book_no" value="${book_no+1}"/>
          <td><font size="2" color="#000080">${book_no}</font></td>
          <td><font size="2" color="#000080">
          	<a href="<%=request.getContextPath()%>/viewBook.jsp?bookId=${book.bookid}">${book.bookname}</a></font></td>
          <td><font size="2" color="#000080">${book.publisher}</font></td>
          <c:set var="allbookcount" value="${allbookcount+book_count}"/>
          <td><font size="2" color="#000080">${book_count}</font></td>
          <c:set var="book_price" value="${book.price*book.price_rebate/10}"/>
          <c:set var="book_price_front" value="${fn:substringBefore(book_price,'.')}"/>
          <c:set var="book_price_After" value="${fn:substringAfter(book_price,'.')}"/>
          <c:set var="book_price_After" value="${fn:substring(book_price_After,0,2)}"/>
          <td><font size="2" color="#000080">${book_price_front}.${book_price_After}</font></td>
          <c:set var="allbookprice" value="${allbookprice+book.price*book.price_rebate*book_count/10}"/>
          <c:set var="bookcount_price" value="${book.price*book.price_rebate*book_count/10}"/>
          <c:set var="bookcount_price_front" value="${fn:substringBefore(bookcount_price,'.')}"/>
          <c:set var="bookcount_price_After" value="${fn:substringAfter(bookcount_price,'.')}"/>
          <c:set var="bookcount_price_After" value="${fn:substring(bookcount_price_After,0,2)}"/>
          <td><font size="2" color="#000080">${bookcount_price_front}.${bookcount_price_After}</font></td>
          <td><font size="2" color="#000080">
            <a href="<%=request.getContextPath()%>/deletebookfromcar.do?book_id=${book.bookid}">拿出一本</a></font></td>
        </tr>
        </c:forEach>
        <tr><td><font size="2" color="#000080">总计</font></td>
        	<td><font size="2" color="#000080">&nbsp;</font></td>
        	<td><font size="2" color="#000080">&nbsp;</font></td>
      		<td><font size="2" color="#000080">${allbookcount}</font></td>
      		<td><font size="2" color="#000080">&nbsp;</font></td>
      		<c:set var="allbookprice_front" value="${fn:substringBefore(allbookprice,'.')}"/>
            <c:set var="allbookprice_After" value="${fn:substringAfter(allbookprice,'.')}"/>
            <c:set var="allbookprice_After" value="${fn:substring(allbookprice_After,0,2)}"/>
      		<td><font size="2" color="#000080">${allbookprice_front}.${allbookprice_After}</font></td>
      		<td><font size="2" color="#000080">&nbsp;</font></td></tr>
      <c:if test="${book_no!=0}">
      <tr><td colspan="7" align="center"><font size="2" color="#000080">
      		<a href="<%=request.getContextPath()%>/makeOrderForm.do">生成订单</a></font>
      		</td></tr>
      </c:if>
      </table>
    </td>
  </tr>
</table>
<jsp:include page="../bottom.jsp"/>