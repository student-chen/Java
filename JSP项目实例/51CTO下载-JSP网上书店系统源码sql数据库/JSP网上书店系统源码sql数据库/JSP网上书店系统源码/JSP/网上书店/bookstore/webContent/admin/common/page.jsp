<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<font size="2" color="#000080">
	<c:if test="${dataPageObject.currentPage>1}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=1">
		��ҳ</a>&nbsp;
	</c:if>
	<c:if test="${dataPageObject.currentPage>1}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=<c:out value="${dataPageObject.currentPage-1}"/>">
		��һҳ</a>&nbsp;
	</c:if>
	<c:if test="${dataPageObject.currentPage<dataPageObject.pageCount}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=<c:out value="${dataPageObject.currentPage+1}"/>">
		��һҳ</a>&nbsp;
	</c:if>
	<c:if test="${dataPageObject.currentPage<dataPageObject.pageCount}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=<c:out value="${dataPageObject.pageCount}"/>">
		βҳ</a>&nbsp;
	</c:if>
		��<c:out value="${dataPageObject.pageCount}"/>ҳ
</font>