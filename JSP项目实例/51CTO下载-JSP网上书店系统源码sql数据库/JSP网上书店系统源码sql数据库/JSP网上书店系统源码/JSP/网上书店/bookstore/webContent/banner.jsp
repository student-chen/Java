<%@ page contentType="text/html;charset=GB2312" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>�������</title>
</head>
<body>
<p align="center">
<table border="0" cellpadding="0" cellspacing="0" width="777">
  <tr>
    <td width="209" align="center">
      	<b>
      <font face="&iquest;&not;&Igrave;&aring;_GB2312" size="5" color="#000080">
       </font><u><font face="&iquest;&not;&Igrave;&aring;_GB2312" size="6" color="#000080">&nbsp;�������&nbsp;</font></u></b><br>
        <font color="#000080">
      www.ebook.com.cn</font>
      </td>
    <td >
    <img border="0" src="<%=request.getContextPath()%>/img/itren1.gif" width="386" height="60"><img border="0" src="<%=request.getContextPath()%>/img/zhaoshang.gif" width="178" height="60">
    </td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="777">
  <tr>
    <td>
      <p align="center"><font size="2" color="#000080">
      <a href="<%=request.getContextPath()%>/">��վ��ҳ</a>&nbsp;
      <a href="<%=request.getContextPath()%>/newBook.jsp">�������</a>
      <a href="<%=request.getContextPath()%>/miniPriceBook.jsp">�ؼ����</a>&nbsp;
     <jsp:useBean id="bookTypeOP" scope="page" class="bean.db.bookTypeOPBean"/>
     <c:forEach items="${bookTypeOP.bookTypeArray}" var="bookType">
     	<a href="<%=request.getContextPath()%>/viewTypeBook.jsp?bookTypeId=${bookType.bookTypeId}">
     	<c:out value="${bookType.bookTypeName}"/></a>
     </c:forEach>     
      <a href="<%=request.getContextPath()%>/admin">�����̨</a>&nbsp;
      <a href="user/adduser.jsp">ע���û�</a>&nbsp;</font>
    </td>
  </tr>
</table>