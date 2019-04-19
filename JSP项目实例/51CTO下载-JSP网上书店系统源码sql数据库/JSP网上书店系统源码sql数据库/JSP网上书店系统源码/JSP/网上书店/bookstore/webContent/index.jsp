<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/fn.tld" %>
<%@ page isELIgnored="false"%>
<!-- 包含进页面首部 -->
<jsp:include page="banner.jsp"/>
<table border="0" cellpadding="0" cellspacing="0" width="777">
  <tr>
    <td width="170">
      <!--用户登录界面-->
      <jsp:include page="user/userlogin.jsp"/>
    </td>
    <td>
      <!--显示最近6本新书-->
      <table border="0" cellpadding="0" cellspacing="0" width="607">
        <tr>
        <jsp:useBean id="bookOP" scope="page" class="bean.db.bookOPBean"/>
        <c:set var="top6book" value="<%=bookOP.selectBookTop6()%>"/>
        <c:forEach items="${top6book}" var="book">
          <td><a href="viewBook.jsp?bookId=${book.bookid}">
          <img border="0" src="admin/book/showbookimg.jsp?bookid=${book.bookid}" height="130"></td>
       		</a>
        </c:forEach>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!--按书藉分类显示每个分类的最近6本书的书名-->
<table>
<jsp:useBean id="bookTypeOP" scope="page" class="bean.db.bookTypeOPBean"/>
<c:set var="i" value="0"/>
<c:forEach items="${bookTypeOP.bookTypeArray}" var="bookType">
	<c:if test="${i%4==0}">
		<tr>
	</c:if>
	<td>
		<table border="0" cellpadding="0" cellspacing="0" width="194">
        	<tr>
          	<td><font size="2" color="#000080">
          	<c:out value="${bookType.bookTypeName}"/></font></td>
        	</tr>
        	<jsp:setProperty name="bookOP" property="bookTypeId" value="${bookType.bookTypeId}"/>
        	<c:set var="top10book" value="<%=bookOP.selectBookByTypeTop6()%>"/>
        	<c:forEach items="${top10book}" var="book">
          		<tr>
          			<td><font size="2" color="#000080">
          			<a href="viewBook.jsp?bookId=${book.bookid}">
          			<c:if test="${fn:length(book.bookname)>12}">
          				<li><c:out value="${fn:substring(book.bookname,0,12)}"/>...
          			</c:if>
          			<c:if test="${fn:length(book.bookname)<=12}">
          				<li><c:out value="${book.bookname}"/>
          			</c:if></a>
        		</tr>
        	</c:forEach>
		</table>
	</td> 
	<c:set var="i" value="${i+1}"/>
	<c:if test="${i==4}">
		</tr>
		<tr>
    		<td colspan="4"><img border="0" src="img/guoqing.gif" ></td>
		</tr>
	</c:if>
</c:forEach>  
</table>
<!--显示最近的7本特价书-->
 <c:set var="top7book" value="<%=bookOP.selectBookMiniPriceTop7()%>"/>
<table border="0" cellpadding="0" cellspacing="0" width="777">
        <tr>
          <td><font size="5" color="#000080">特<br>价<br>书<br>藉</font></td>
          <c:forEach items="${top7book}" var="book">
          	<td align="centers"><a href="viewBook.jsp?bookId=${book.bookid}">
          	<img border="0" src="admin/book/showbookimg.jsp?bookid=${book.bookid}" height="130">
          	</a><br><font size="2" color="#000080">${book.price_rebate}折</font></td>
          </c:forEach>
        </tr>
</table>
<!--包含进页面尾部-->
<jsp:include page="bottom.jsp"/>