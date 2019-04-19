<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/fn.tld" %>
<%@ page isELIgnored="false"%>
<jsp:useBean id="bookOP" scope="page" class="bean.db.bookOPBean"/>
<jsp:include page="../adminmoduleup.jsp"/>
<c:set var="pagePath" value="/admin/orderform/orderformview.do"/>
<table border="1" cellpadding="0" cellspacing="0" width="610">
	<tr><td colspan="4">
		<font size="2" color="#000080">��������</font>		
	</td></tr>
	<tr><td colspan="4">
		<font size="2" color="red"><html:errors/></font>
	</td></tr>
	<html:form action="${pagePath}" method="post">
	<tr><td colspan="6"><font size="2" color="#000080">
		�����ţ�<html:text property="orderformid" size="10"/>&nbsp;
		����״̬��<html:select property="status">
					<html:option value="0">0--�¶���</html:option>
					<html:option value="1">1--�ͻ���ȷ��</html:option>
					<html:option value="2">2--�������</html:option>
					<html:option value="3">3--�ѷ���</html:option>
					<html:option value="4">4--ȱ��</html:option>
				</html:select>
		<html:submit value="�ύ"/>
	</font></td></tr>
	</html:form>
	<tr><td colspan="4" align="right"><font size="2" color="#000080">
		<%@ include file="page.txt"%>
	</td></tr>
	<tr><td align="center"><font size="2" color="#000080">������</font></td>
		<td align="center"><font size="2" color="#000080">�ͻ�ID��</font></td>
		<td align="center"><font size="2" color="#000080">����״̬</font></td>
		<td align="center"><font size="2" color="#000080">�޸�״̬</font></td>
	</tr>
	<c:forEach items="${CurrentPageArray}" var="orderForm">
		<tr bgcolor="#C0C0C0"><td align="center"><font size="2" color="#000080">
			<c:out value="${orderForm.order_form_id}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			<c:out value="${orderForm.user_id}"/>&nbsp;</font></td>
			<td align="center"><font size="2" color="#000080">
			${orderForm.status}</font></td>
			<td align="center"><font size="2" color="#000080">
			<c:if test="${orderForm.status==0}">&nbsp;
			</c:if>
			<c:if test="${orderForm.status==1}">
			<a href="<%=request.getContextPath()%>/admin/orderform/modiStatusAction.do?order_form_id=${orderForm.order_form_id}&status=2">
			�޸�Ϊ�������</a>
			</c:if>
			<c:if test="${orderForm.status==2}">
			<a href="<%=request.getContextPath()%>/admin/orderform/modiStatusAction.do?order_form_id=${orderForm.order_form_id}&status=4">
			�޸�Ϊȱ��</a>
			<a href="<%=request.getContextPath()%>/admin/orderform/modiStatusAction.do?order_form_id=${orderForm.order_form_id}&status=3">
			�޸�Ϊ�ѷ���</a>
			</c:if>&nbsp;
			</font></td>
		</tr>
		<tr><td colspan=4>
			<table border="1" cellpadding="0" cellspacing="0" width="607">
      		<tr><td align="center"><font size="2" color="#000080">���</font></td>
      			<td align="center"><font size="2" color="#000080">����</font></td>
      			<td align="center"><font size="2" color="#000080">������</font></td>
      			<td align="center"><font size="2" color="#000080">����</font></td>
      			<td align="center"><font size="2" color="#000080">����</font></td>
      			<td align="center"><font size="2" color="#000080">�ܼ�</font></td></tr>
      		<c:set var="book_no" value="${0}"/>
      		<c:set var="allbookcount" value="${0}"/>
      		<c:set var="allbookprice" value="${0}"/>
        	<c:forEach items="${orderForm.myGoods}" var="carbook">
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
        	</tr>
        	</c:forEach>
        	<tr><td><font size="2" color="#000080">�ܼ�</font></td>
        		<td><font size="2" color="#000080">&nbsp;</font></td>
        		<td><font size="2" color="#000080">&nbsp;</font></td>
      			<td><font size="2" color="#000080">${allbookcount}</font></td>
      			<td><font size="2" color="#000080">&nbsp;</font></td>
      			<c:set var="allbookprice_front" value="${fn:substringBefore(allbookprice,'.')}"/>
            	<c:set var="allbookprice_After" value="${fn:substringAfter(allbookprice,'.')}"/>
            	<c:set var="allbookprice_After" value="${fn:substring(allbookprice_After,0,2)}"/>
      			<td><font size="2" color="#000080">${allbookprice_front}.${allbookprice_After}</font></td></tr>
      		</table>
		</td></tr>
	</c:forEach>
	<tr><td colspan="4" align="right"><font size="2" color="#000080">
		 ����״̬:0��0--�¶��� 1--�ͻ���ȷ��  2--������� 3--�ѷ��� 4--ȱ����
	</td></tr>
</table>
<jsp:include page="../adminmoduledown.jsp"/>