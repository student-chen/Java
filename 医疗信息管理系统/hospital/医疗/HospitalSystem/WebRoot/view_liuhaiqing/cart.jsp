<%@page pageEncoding="gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setCharacterEncoding("gbk");
	response.setContentType("application/vnd.ms-excel;charset=gbk"); 
	response.setCharacterEncoding("gbk");
	response.setHeader("Content-Disposition","attachment; filename=\"cart.xls\"");	
%>
<html>
<head>
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
</head>
<body>
    <center>
    <form action="view_liuhaiqing/cart.jsp" method="post" name="f">
		    <%
		     	session.getAttribute("money");
		     %>
			<table class="simple textCss">
				<tr>
					<th width="30%">
						��Ŀ
					</th>
					<th width="10%">
						���
					</th>
					<th width="10%">
						�տ���
					</th>
					<th width="10%">
						������
					</th>
					<th width="30%">
						����
					</th>
					<th width="10%">
						�Ƿ�����
					</th>
				</tr>
				<c:set var="all" value="0"></c:set>
				<c:forEach items="${money}" var="Stat">
				  <c:set var="all" value="${all+ Stat.pay }"></c:set>
					<tr>
						<td align="center">
							${ Stat.items }&nbsp;
						</td>
						<td align="center">
							${ Stat.pay }&nbsp;
						</td>
						<td align="center">
							${ Stat.payee }&nbsp;
						</td>
						<td align="center">
							${ Stat.name }&nbsp;
						</td>
						<td align="center">
							${ Stat.pdate }&nbsp;
						</td>
						<td align="center">
						  <c:choose>
						   <c:when test="${ Stat.isFinished ==0}">
						     <c:out value="��"></c:out>
						   </c:when>
						   <c:otherwise>
						    <c:out value="��"></c:out>
						   </c:otherwise>
						  </c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			ͳ�ƣ����${all }Ԫ.
		 </form>
		</center> 
</body>
</html>