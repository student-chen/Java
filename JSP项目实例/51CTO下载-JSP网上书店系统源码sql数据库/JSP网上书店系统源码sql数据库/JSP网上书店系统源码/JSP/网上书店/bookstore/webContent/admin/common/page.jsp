<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<font size="2" color="#000080">
	<c:if test="${dataPageObject.currentPage>1}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=1">
		首页</a>&nbsp;
	</c:if>
	<c:if test="${dataPageObject.currentPage>1}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=<c:out value="${dataPageObject.currentPage-1}"/>">
		上一页</a>&nbsp;
	</c:if>
	<c:if test="${dataPageObject.currentPage<dataPageObject.pageCount}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=<c:out value="${dataPageObject.currentPage+1}"/>">
		下一页</a>&nbsp;
	</c:if>
	<c:if test="${dataPageObject.currentPage<dataPageObject.pageCount}">
		<a href="<%=request.getContextPath()%><c:out value="${pagePath}"/>?page=<c:out value="${dataPageObject.pageCount}"/>">
		尾页</a>&nbsp;
	</c:if>
		共<c:out value="${dataPageObject.pageCount}"/>页
</font>